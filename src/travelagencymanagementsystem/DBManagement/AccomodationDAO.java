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
import travelagencymanagementsystem.dto.Accomodation;
import travelagencymanagementsystem.dto.Destination;
import travelagencymanagementsystem.dto.Trip;

/**
 *
 * @author User
 */
public class AccomodationDAO {
 private ConnectionToDatabase dbCon;
    public Connection conn;
    private ArrayList<Accomodation> accmds;
    private Accomodation accmd;
    private PreparedStatement ps;
    private ResultSet rs;

    public AccomodationDAO() {
//        ACCOMODATION(
//        ID_ACCOMODATION 
//        ACCOMODATION_TYPE 
//        ADDRESS 
//        ID_DESTINATION 
//        COST_PER_NIGHT 
    }

    public ArrayList<Accomodation> getAllAccomodations() {
        ArrayList<Accomodation> accomodations = new ArrayList<Accomodation>();
        try {

            dbCon = new ConnectionToDatabase();
            conn = dbCon.getConnection();
            ps = conn.prepareStatement("SELECT A.ID_ACCOMODATION, A.ACCOMODATION_TYPE,A.ADDRESS, A.COST_PER_NIGHT,D.CITY_NAME FROM ACCOMODATION A JOIN DESTINATION D ON A.ID_DESTINATION = D.ID_DESTINATION");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Accomodation t = new Accomodation();
                t.setN_idAccomodation(rs.getInt("ID_ACCOMODATION"));
                t.setAccomodation_type(rs.getString("ACCOMODATION_TYPE"));
                t.setAddress(rs.getString("ADDRESS"));
                t.setCost(rs.getDouble("COST_PER_NIGHT"));

                Destination d = new Destination();
                d.setT_city(rs.getString("CITY_NAME"));
                t.setDestination(d);

                accomodations.add(t);
                
            }

            conn.close();
        } catch (Exception e) {
            e.getMessage();
        }

        return accomodations;
    }

    
    public Accomodation getTripAccomodation(Trip aTrip) {
      
        try {
        	
            dbCon = new ConnectionToDatabase();
            ps = dbCon.getConnection().prepareStatement("SELECT A.ID_ACCOMODATION, A.ACCOMODATION_TYPE, A.ADDRESS, A.COST_PER_NIGHT \r\n" + 
            		"FROM ACCOMODATION A \r\n" + 
            		"JOIN DESTINATION D on A.ID_DESTINATION = D.ID_DESTINATION\r\n" + 
            		"JOIN TRIP T ON D.ID_DESTINATION = T.ID_DESTINATION\r\n" + 
            		"where T.TRIP_ID =  ?");
            ps.setInt(1,11);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	accmd = new Accomodation();
                accmd.setN_idAccomodation(rs.getInt("ID_ACCOMODATION"));
                accmd.setAccomodation_type(rs.getString("ACCOMODATION_TYPE"));
                accmd.setAddress(rs.getString("ADDRESS"));
                accmd.setCost(rs.getDouble("COST_PER_NIGHT"));                
            }

            conn.close();
        } catch (Exception e) {
            e.getMessage();
        }

        return accmd;
    }

    
    
    
    
    public boolean insertAccomodation(Accomodation aAccomodation) throws Exception {
        Boolean ans;
        try {
            
            dbCon = new ConnectionToDatabase();
            ps = dbCon.getConnection().prepareStatement("INSERT INTO ACCOMODATION (ACCOMODATION_TYPE,ID_DESTINATION, ADDRESS, COST_PER_NIGHT) VALUES(?,?,?,?)");
            ps.setString(1, aAccomodation.getAccomodation_type());
            ps.setInt(2, aAccomodation.getDestination().getN_iddestination());
            ps.setString(3,aAccomodation.getAddress());
            ps.setDouble(4, aAccomodation.getCost());
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
    public boolean updateAccomodation(Accomodation aAccomodation) throws SQLException {
        Boolean ans;
        try {
            dbCon = new ConnectionToDatabase();
            
          //         
//         
//         
//         
//         
            ps = dbCon.getConnection().prepareStatement("UPDATE ACCOMODATION SET ACCOMODATION_TYPE =?, ID_DESTINATION = ?, "
            		+ "ADDRESS = ?, COST_PER_NIGHT = ? WHERE ID_ACCOMODATION = ?");

            ps.setInt(5, aAccomodation.getN_idAccomodation());
            ps.setString(1, aAccomodation.getAccomodation_type());
            ps.setInt(2, aAccomodation.getDestination().getN_iddestination());
            ps.setString(3,aAccomodation.getAddress());
            ps.setDouble(4, aAccomodation.getCost());
            

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
    public boolean deleteAccomodation(Accomodation aAccomodation) throws Exception {
        Boolean ans;
        try {
            dbCon = new ConnectionToDatabase();
            ps = dbCon.getConnection().prepareStatement("DELETE FROM ACCOMODATION WHERE ID_ACCOMODATION = ?");
            ps.setInt(1, aAccomodation.getN_idAccomodation());
            
            rs = ps.executeQuery();
            ans = true;
        } catch (Exception e) {
            System.out.println(e.getMessage()+ "aAccomodation is in use");
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

//    	Destination aDest = new Destination();
//    	aDest.setN_iddestination(8);
//    	Accomodation newAccomodation = new Accomodation();
   // 	newAccomodation.setAccomodation_type("Hotel");
    //    newAccomodation.setAddress("Rr.Adem Jashari");
//        newAccomodation.setCost(59.5);
//        newAccomodation.setDestination(aDest);
//        newAccomodation.setN_idAccomodation(4);
    	
    	Trip aTrip = new Trip();
    	aTrip.setN_idTrip(11);
              
        AccomodationDAO dao = new AccomodationDAO();

        try {
        //    dao.insertAccomodation(newAccomodation);
          // Boolean updated = dao.updateAccomodation(newAccomodation);
        //    Boolean deleted = dao.deleteAccomodation(newAccomodation);
          //  System.out.println(deleted);
         //   ArrayList<Accomodation> dest = dao.getAllAccomodations();

//            for (Accomodation d : dest) {
//                System.out.println(d);
//            }
        	
        	  Accomodation dest = dao.getTripAccomodation(aTrip);
        	  
        	  System.out.println(dest);
        	
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex);
            // Logger.getLogger(DestinationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
