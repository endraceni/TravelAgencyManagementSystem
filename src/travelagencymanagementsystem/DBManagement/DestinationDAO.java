/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagencymanagementsystem.DBManagement;

import java.util.ArrayList;
import travelagencymanagementsystem.DBManagement.ConnectionToDatabase;
import travelagencymanagementsystem.dto.Destination;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class DestinationDAO {

    private ConnectionToDatabase dbCon;
    public Connection conn;
    private ArrayList<Destination> destinations;
    private Destination aDestination;
    private PreparedStatement ps;
    private ResultSet rs;
    private String myquery;

    public DestinationDAO() {
    }

    public ArrayList<Destination> getAllDestinations() {
        ArrayList<Destination> destinations = new ArrayList<Destination>();

        try {

            dbCon = new ConnectionToDatabase();
            conn = dbCon.getConnection();

            ps = conn.prepareStatement("SELECT * FROM DESTINATION");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Destination t = new Destination();
                t.setN_iddestination(rs.getInt("ID_DESTINATION"));
                t.setT_state(rs.getString("COUNTRY_NAME"));
                t.setT_city(rs.getString("CITY_NAME"));
                t.setAttraction(rs.getString("ATTRACTION_DESC"));

                destinations.add(t);
                conn.commit();
            }

            conn.close();
        } catch (Exception e) {
            e.getMessage();
        }

        return destinations;
    }

    public boolean insertDestination(Destination dest) throws Exception {
        Boolean ans;
        try {

            dbCon = new ConnectionToDatabase();
            ps = dbCon.getConnection().prepareStatement("INSERT INTO DESTINATION (COUNTRY_NAME,CITY_NAME, ATTRACTION_DESC) VALUES(?,?,?)");
            ps.setString(1, dest.getT_state());
            ps.setString(2, dest.getT_city());
            ps.setString(3, dest.getAttraction());
            rs = ps.executeQuery();
            ans = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ans = false;
        }

        return ans;
    }

    public boolean updateDestination(Destination dest) throws SQLException {
        Boolean ans;
        try {
            dbCon = new ConnectionToDatabase();
            ps = dbCon.getConnection().prepareStatement("UPDATE DESTINATION SET COUNTRY_NAME = ?,CITY_NAME = ?, ATTRACTION_DESC = ? WHERE ID_DESTINATION = ?");

            ps.setInt(4, dest.getN_iddestination());
            ps.setString(1, dest.getT_state());
            ps.setString(2, dest.getT_city());
            ps.setString(3, dest.getAttraction());

            rs = ps.executeQuery();
            ans = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ans = false;
        }

        return ans;

    }

    public boolean deleteDestination(Destination dent) throws Exception {
        Boolean ans;
        try {
            dbCon = new ConnectionToDatabase();
            ps = dbCon.getConnection().prepareStatement("DELETE FROM DESTINATION WHERE ID_DESTINATION = ?");
            ps.setLong(1, dent.getN_iddestination());
            
            rs = ps.executeQuery();
            ans = true;
        } catch (Exception e) {
            System.out.println(e.getMessage()+ "Destination is in use");
            ans = false;
        }

        return ans;
    }

    public static void main(String[] args) {
//
//        Destination destin = new Destination();
//        //destin.setT_state("Alo me degjooon");
//       // destin.setT_city("Me deegjgjgjoon");
//        destin.setN_iddestination(13);
//        DestinationDAO dao = new DestinationDAO();
//
//        try {
//            //  dao.insertDestination(destin);
//           // Boolean updated = dao.updateDestination(destin);
//            Boolean deleted = dao.deleteDestination(destin);
//            System.out.println(deleted);
//            ArrayList<Destination> dest = dao.getAllDestinations();
//
//            for (Destination d : dest) {
//                System.out.println("Visit " + d.getT_city() + " in " + d.getT_state());
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            System.out.println(ex);
//            // Logger.getLogger(DestinationDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

}
