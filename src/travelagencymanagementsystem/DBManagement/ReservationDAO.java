/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagencymanagementsystem.DBManagement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import travelagencymanagementsystem.dto.Accomodation;
import travelagencymanagementsystem.dto.Destination;
import travelagencymanagementsystem.dto.Reservation;
import travelagencymanagementsystem.dto.TravelAgent;
import travelagencymanagementsystem.dto.Traveller;
import travelagencymanagementsystem.dto.Trip;

/**
 *
 * @author User
 */
public class ReservationDAO {
    private ConnectionToDatabase dbCon;
    public Connection conn;
    private ArrayList<Reservation> reservations;
    private Reservation reservation;
    private PreparedStatement ps;
    private ResultSet rs;

    public ReservationDAO() {
//        RESERVATION(
//        ID_RESERVATION
//        TRIP_ID
//        ID_TRAVELLER
//        ID_ACCOMODATION
//        AGENT_ID
//        RESERVATION_DATE
//        FLAG_CANCELLED
//        CANCEL_DATE
    }

    public ArrayList<Reservation> getAllReservations() {
        reservations = new ArrayList<Reservation>();
        try {

            dbCon = new ConnectionToDatabase();

            ps = dbCon.getConnection().prepareStatement("SELECT R.ID_RESERVATION,R.RESERVATION_DATE,R.FLAG_CANCELLED, T.TRIP_ID,D.ID_DESTINATION,D.CITY_NAME, T.TRIP_TITLE, T.PRICE,A.ID_ACCOMODATION,\r\n" + 
            		"A.COST_PER_NIGHT, A.ACCOMODATION_TYPE,A.ADDRESS, TA.AGENT_ID, TA.AGENT_NAME,TA.AGENT_SURNAME, TR.ID_TRAVELLER, TR.TRAVELLER_NAME, TR.TRAVELLER_SURNAME\r\n" + 
            		"FROM RESERVATION R JOIN TRIP T ON R.TRIP_ID = T.TRIP_ID \r\n" + 
            		"JOIN DESTINATION D ON T.ID_DESTINATION = D.ID_DESTINATION\r\n" + 
            		"JOIN ACCOMODATION A ON R.ID_ACCOMODATION = A.ID_ACCOMODATION\r\n" + 
            		"JOIN TRAVEL_AGENT TA ON R.AGENT_ID = TA.AGENT_ID \r\n" + 
            		"JOIN TRAVELLER TR ON R.ID_TRAVELLER = TR.ID_TRAVELLER");
          
            rs = ps.executeQuery();
            while (rs.next()) {
                Reservation r = new Reservation();
                r.setIdReservation(rs.getInt("ID_RESERVATION"));
                r.setReservationDate(rs.getDate("RESERVATION_DATE"));
                r.setCancelled(rs.getBoolean("FLAG_CANCELLED"));
                
                Destination aDest = new Destination();
                aDest.setN_iddestination(rs.getInt("ID_DESTINATION"));
                aDest.setT_city(rs.getString("CITY_NAME"));
                
                Trip rsTrip = new Trip();
                rsTrip.setN_idTrip(rs.getInt("TRIP_ID"));
                rsTrip.setTitle(rs.getString("TRIP_TITLE"));
                rsTrip.setDestination(aDest);
                rsTrip.setPrice(rs.getDouble("PRICE"));
                r.setTrip(rsTrip);
                
                Accomodation rAccmdt = new Accomodation();
                rAccmdt.setN_idAccomodation(rs.getInt("ID_ACCOMODATION"));
                rAccmdt.setAccomodation_type(rs.getString("ACCOMODATION_TYPE"));
                rAccmdt.setAddress(rs.getString("ADDRESS"));
                rAccmdt.setCost(rs.getDouble("COST_PER_NIGHT"));
                r.setAccomodation(rAccmdt);
             
                TravelAgent ta = new TravelAgent();
                ta.setN_idAgent(rs.getInt("AGENT_ID"));
                ta.setAgentName(rs.getString("AGENT_NAME"));
                ta.setAgentSurname(rs.getString("AGENT_SURNAME"));
                r.setAgent(ta);
                
                Traveller tr = new Traveller();
                tr.setN_idtraveller(rs.getInt("ID_TRAVELLER"));
                tr.setT_name(rs.getString("TRAVELLER_NAME"));
                tr.setT_surname(rs.getString("TRAVELLER_SURNAME"));
                r.setTraveller(tr);
                
                reservations.add(r);
            }

        } catch (Exception e) {
            e.getMessage();
        }

        return reservations;
    }
    

    public boolean insertReservation(Reservation rsv) throws Exception {
        Boolean ans;
        try {

            dbCon = new ConnectionToDatabase();
            ps = dbCon.getConnection().prepareStatement("INSERT INTO RESERVATION (TRIP_ID,ID_ACCOMODATION,AGENT_ID,ID_TRAVELLER,RESERVATION_DATE,FLAG_CANCELLED,TOTAL_PRICE) VALUES(?,?,?,?,?,?,?)");
            ps.setInt(1,rsv.getTrip().getN_idTrip());
            AccomodationDAO accDao = new AccomodationDAO();
            Accomodation acc = accDao.getTripAccomodation(rsv.getTrip());
            ps.setInt(2, acc.getN_idAccomodation());
            ps.setInt(3,rsv.getAgent().getN_idAgent());
            ps.setInt(4,rsv.getTraveller().getN_idtraveller());
            Calendar calendar = Calendar.getInstance();
            java.util.Date currentDate = calendar.getTime();
            ps.setDate(5,new java.sql.Date(currentDate.getTime()));
            ps.setInt(6, 0);
            
            double total = rsv.getTrip().getPrice()+acc.getCost();
            ps.setDouble(7, total);
            
            
            rs = ps.executeQuery();
            dbCon.getConnection().commit();
            ans = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ans = false;
        }

        return ans;
    }

    public boolean deleteReservation(Reservation rsv) throws Exception {
        Boolean ans;
        try {
            dbCon = new ConnectionToDatabase();
            ps = dbCon.getConnection().prepareStatement("DELETE FROM RESERVATION WHERE ID_RESERVATION = ?");
            ps.setInt(1, rsv.getIdReservation());
            
            rs = ps.executeQuery();
            ans = true;
        } catch (Exception e) {
            System.out.println(e.getMessage()+ "Something went wrong");
            ans = false;
        }

        return ans;
    }

    public static Date StringToDate(String dateInString) throws ParseException {
  	  	
    	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    	java.util.Date date = formatter.parse(dateInString);
    	java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 

         return sqlStartDate;
    }
    
//    public static void main(String[] args) throws ParseException {
//
////    	Destination aDest = new Destination();
////    	aDest.setN_iddestination(12);
////    	Trip newTrip = new Trip();
////    	newTrip.setN_idTrip(4);
//////    	newTrip.setTitle("Trip 6");
//////    	newTrip.setPrice(45.3);
//////    	newTrip.setDestination(aDest);
//////    	newTrip.setD_start(StringToDate("22-02-2020"));
//////    	newTrip.setD_end(StringToDate("25-02-2020"));
//              
//        ReservationDAO dao = new ReservationDAO();
//
//        try {
//           //   dao.insertTrip(newTrip);
////            Boolean updated = dao.updateTrip(newTrip);
//          //  Boolean deleted = dao.deleteTrip(newTrip);
//          //  System.out.println(deleted);
//           ArrayList<Reservation> dest = dao.getAllReservations();
//
//            for (Reservation d : dest) {
//                System.out.println(d);
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            System.out.println(ex);
//            // Logger.getLogger(DestinationDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
////
 //   }

}
