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
import travelagencymanagementsystem.dto.Destination;
import travelagencymanagementsystem.dto.Traveller;

/**
 *
 * @author User
 */
public class TravellerDAO {
    private ConnectionToDatabase dbCon;
    public Connection conn;
    private ArrayList<Traveller> travellers;
    private Traveller traveller;
    private PreparedStatement ps;
    private ResultSet rs;
    private String myquery;

    public TravellerDAO() {
//
//        TABLE TRAVELLER(
//        ID_TRAVELLER
//        TRAVELLER_NAME
//        TRAVELLER_SURNAME
//        TRAVELLER_BIRTHDATE 
    }

    public ArrayList<Traveller> getAllTravellers() {
        ArrayList<Traveller> travellers = new ArrayList<Traveller>();

        try {

            dbCon = new ConnectionToDatabase();
            conn = dbCon.getConnection();

            ps = conn.prepareStatement("SELECT * FROM TRAVELLER");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Traveller t = new Traveller();
                t.setN_idtraveller(rs.getInt("ID_TRAVELLER"));
                t.setT_name(rs.getString("TRAVELLER_NAME"));
                t.setT_surname(rs.getString("TRAVELLER_SURNAME"));
                t.setD_birth(rs.getDate("TRAVELLER_BIRTHDATE"));     

                travellers.add(t);
                conn.commit();
            }

            conn.close();
        } catch (Exception e) {
            e.getMessage();
        }

        return travellers;
    }

    public boolean insertTravelller(Traveller trav) throws Exception {
        Boolean ans;
        try {

            dbCon = new ConnectionToDatabase();
            ps = dbCon.getConnection().prepareStatement("INSERT INTO TRAVELLER (TRAVELLER_NAME,TRAVELLER_SURNAME, TRAVELLER_BIRTHDATE) VALUES(?,?,?)");
            ps.setString(1, trav.getT_name());
            ps.setString(2, trav.getT_surname());
            ps.setDate(3, trav.getD_birth());
            rs = ps.executeQuery();
            ans = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ans = false;
        }

        return ans;
    }

    public boolean updateTraveller(Traveller trav) throws SQLException {
        Boolean ans;
        try {
            dbCon = new ConnectionToDatabase();
            ps = dbCon.getConnection().prepareStatement("UPDATE TRAVELLER SET TRAVELLER_NAME = ?,TRAVELLER_SURNAME = ?, TRAVELLER_BIRTHDATE = ? WHERE ID_TRAVELLER = ?");

            ps.setInt(4, trav.getN_idtraveller());
            ps.setString(1, trav.getT_name());
            ps.setString(2, trav.getT_surname());
            ps.setDate(3, trav.getD_birth());

            rs = ps.executeQuery();
            ans = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ans = false;
        }

        return ans;

    }

    public boolean deleteTraveller(Traveller trav) throws Exception {
        Boolean ans;
        try {
            dbCon = new ConnectionToDatabase();
            ps = dbCon.getConnection().prepareStatement("DELETE FROM TRAVELLER WHERE ID_TRAVELLER = ?");
            ps.setLong(1, trav.getN_idtraveller());
            
            rs = ps.executeQuery();
            ans = true;
        } catch (Exception e) {
            System.out.println(e.getMessage()+ "Traveller is part of db");
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
    
    
    public static void main(String[] args) throws ParseException{

//        Traveller trav = new Traveller();
//        trav.setT_name("MICHELLE");
//        trav.setT_surname("FOX");
//       // trav.setD_birth(StringToDate("20-01-1982"));
//        trav.setN_idtraveller(7);
//        TravellerDAO dao = new TravellerDAO();
//
//        try {
//          //  dao.insertTravelller(trav);
//          //  Boolean updated = dao.updateTraveller(trav);
//            Boolean deleted = dao.deleteTraveller(trav);
//          //  System.out.println(deleted);
//            ArrayList<Traveller> travs = dao.getAllTravellers();
//
//            for (Traveller tr : travs) {
//                System.out.println("Travelleer " + tr);
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            System.out.println(ex);
//            // Logger.getLogger(DestinationDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }
 
}
