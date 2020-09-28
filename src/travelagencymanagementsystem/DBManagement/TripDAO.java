/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagencymanagementsystem.DBManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

import travelagencymanagementsystem.dto.Destination;
import travelagencymanagementsystem.dto.Trip;

/**
 *
 * @author User
 */
public class TripDAO {
     private ConnectionToDatabase dbCon;
    public Connection conn;
    private ArrayList<Trip> trips;
    private Trip aTrip;
    private PreparedStatement ps;
    private ResultSet rs;

    public TripDAO() {
        //TRIP_ID 
        //TRIP_TITLE 
        //ID_DESTINATION 
        //PRICE
        //DATE_FROM 
        //DATE_TO 
    }

    public ArrayList<Trip> getAllTrips() {
        ArrayList<Trip> trips = new ArrayList<Trip>();
        try {

            dbCon = new ConnectionToDatabase();
            conn = dbCon.getConnection();
            ps = conn.prepareStatement("SELECT T.TRIP_ID,T.TRIP_TITLE,T.PRICE,T.DATE_FROM,T.DATE_TO,D.CITY_NAME FROM TRIP T JOIN DESTINATION D ON T.ID_DESTINATION = D.ID_DESTINATION");
          
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Trip t = new Trip();
                t.setN_idTrip(rs.getInt("TRIP_ID"));
                t.setTitle(rs.getString("TRIP_TITLE"));
                t.setPrice(rs.getDouble("PRICE"));
                t.setD_start(rs.getDate("DATE_FROM"));
                t.setD_end(rs.getDate("DATE_TO"));

                Destination d = new Destination();
                d.setT_city(rs.getString("CITY_NAME"));
                t.setDestination(d);

                trips.add(t);
                
            }

            conn.close();
        } catch (Exception e) {
            e.getMessage();
        }

        return trips;
    }

    public boolean insertTrip(Trip aTrip) throws Exception {
        Boolean ans;
        try {

            dbCon = new ConnectionToDatabase();
            ps = dbCon.getConnection().prepareStatement("INSERT INTO TRIP (TRIP_TITLE, ID_DESTINATION, PRICE, DATE_FROM, DATE_TO) VALUES(?,?,?,?,?)");
            ps.setString(1, aTrip.getTitle());
            ps.setInt(2, aTrip.getDestination().getN_iddestination());
            ps.setDouble(3, aTrip.getPrice());
            ps.setDate(4, aTrip.getD_start());
            ps.setDate(5, aTrip.getD_end());
            rs = ps.executeQuery();
            dbCon.getConnection().commit();
            ans = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ans = false;
        }

        return ans;
    }
//
    public boolean updateTrip(Trip aTrip) throws SQLException {
        Boolean ans;
        try {
            dbCon = new ConnectionToDatabase();
            ps = dbCon.getConnection().prepareStatement("UPDATE TRIP SET TRIP_TITLE =?, ID_DESTINATION = ?, "
            		+ "PRICE = ?, DATE_FROM = ?, DATE_TO = ? WHERE TRIP_ID = ?");

            ps.setInt(6, aTrip.getN_idTrip());
            ps.setString(1, aTrip.getTitle());
            ps.setInt(2, aTrip.getDestination().getN_iddestination());
            ps.setDouble(3, aTrip.getPrice());
            ps.setDate(4, aTrip.getD_start());
            ps.setDate(5, aTrip.getD_end());
            

            rs = ps.executeQuery();

            dbCon.getConnection().commit();
            ans = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ans = false;
        }

        return ans;

    }
//
    public boolean deleteTrip(Trip aTrip) throws Exception {
        Boolean ans;
        try {
            dbCon = new ConnectionToDatabase();
            ps = dbCon.getConnection().prepareStatement("DELETE FROM TRIP WHERE TRIP_ID = ?");
            ps.setInt(1, aTrip.getN_idTrip());
            
            rs = ps.executeQuery();
            ans = true;
        } catch (Exception e) {
            System.out.println(e.getMessage()+ "Trip is in use");
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
    
    public static void main(String[] args) throws ParseException {

    	Destination aDest = new Destination();
    	aDest.setN_iddestination(12);
    	Trip newTrip = new Trip();
    	newTrip.setN_idTrip(4);
//    	newTrip.setTitle("Trip 6");
//    	newTrip.setPrice(45.3);
//    	newTrip.setDestination(aDest);
//    	newTrip.setD_start(StringToDate("22-02-2020"));
//    	newTrip.setD_end(StringToDate("25-02-2020"));
              
        TripDAO dao = new TripDAO();

        try {
           //   dao.insertTrip(newTrip);
//            Boolean updated = dao.updateTrip(newTrip);
            Boolean deleted = dao.deleteTrip(newTrip);
            System.out.println(deleted);
            ArrayList<Trip> dest = dao.getAllTrips();

            for (Trip d : dest) {
                System.out.println(d);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex);
            // Logger.getLogger(DestinationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
