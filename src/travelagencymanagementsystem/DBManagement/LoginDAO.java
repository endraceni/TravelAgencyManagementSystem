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
import travelagencymanagementsystem.dto.Login;
import travelagencymanagementsystem.dto.TravelAgent;

/**
 *
 * @author User
 */
public class LoginDAO {
     private ConnectionToDatabase dbCon;
    public Connection conn;
  //  private ArrayList<Trip> trips;
    private Login accData;
    private PreparedStatement ps;
    private ResultSet rs;
    

    public LoginDAO() {
//        USER_ID 
//        USERNAME 
//        PASSWORDD
//          AGENT_ID 

    }
    
    public Login agentCredentialsAgentId(int agent_id){
        try {

            dbCon = new ConnectionToDatabase();
            conn = dbCon.getConnection();
            ps = conn.prepareStatement("SELECT L.USER_ID, L.USERNAME, L.PASSWORDD, TA.AGENT_ID FROM LOGIN_CREDENTIALS L JOIN TRAVEL_AGENT TA ON L.AGENT_ID = TA.AGENT_ID where TA.AGENT_ID =");
            ps.setInt(1, agent_id);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            accData = new Login();
            accData.setUser_id(rs.getInt("USER_ID"));
            accData.setUsername(rs.getString("USERNAME"));
            accData.setPassword(rs.getString("PASSWORDD"));
            
            TravelAgent ta = new TravelAgent();
            ta.setN_idAgent(rs.getInt("AGENT_ID"));
            accData.setAgent(ta);
            
            }
            conn.close();
        } catch (Exception e) {
            e.getMessage();
        }

        return accData;

    }

    public Login agentCredentials(Login log){
        try {

            dbCon = new ConnectionToDatabase();
            
            ps = dbCon.getConnection().prepareStatement("SELECT L.USER_ID, L.USERNAME, L.PASSWORDD, TA.AGENT_ID, TA.AGENT_NAME, TA.AGENT_SURNAME FROM LOGIN_CREDENTIALS L JOIN TRAVEL_AGENT TA ON L.AGENT_ID = TA.AGENT_ID where L.USERNAME = ? AND L.PASSWORDD =?");
            ps.setString(1, log.getUsername());
            ps.setString(2, log.getPassword());
            
            rs = ps.executeQuery();
            while(rs.next()) {
            accData = new Login();
            accData.setUser_id(rs.getInt("USER_ID"));
            accData.setUsername(rs.getString("USERNAME"));
            accData.setPassword(rs.getString("PASSWORDD"));
            
            TravelAgent ta = new TravelAgent();
            ta.setN_idAgent(rs.getInt("AGENT_ID"));
            ta.setAgentName(rs.getString("AGENT_NAME"));
            ta.setAgentSurname(rs.getString("AGENT_SURNAME"));
            accData.setAgent(ta);
            
            }
         //   conn.close();
        } catch (Exception e) {
            e.getMessage();
        }

        return accData;

    }   
    
    public ArrayList<Login> showLoginAccounts() {
        ArrayList<Login> logins = new ArrayList<Login>();
        try {

            dbCon = new ConnectionToDatabase();
            conn = dbCon.getConnection();
            ps = conn.prepareStatement("SELECT L.USER_ID, L.USERNAME, L.PASSWORDD, TA.AGENT_ID, TA.AGENT_NAME, TA.AGENT_SURNAME FROM LOGIN_CREDENTIALS L JOIN TRAVEL_AGENT TA ON L.AGENT_ID = TA.AGENT_ID");
          
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Login t = new Login();
                t.setUser_id(rs.getInt("USER_ID"));
                t.setUsername(rs.getString("USERNAME"));
                t.setPassword(rs.getString("PASSWORDD"));
                
                TravelAgent ta = new TravelAgent();
                ta.setN_idAgent(rs.getInt("AGENT_ID"));
                ta.setAgentName(rs.getString("AGENT_NAME"));
                ta.setAgentSurname(rs.getString("AGENT_SURNAME"));
                
                t.setAgent(ta);
                logins.add(t);
                
            }

          //  conn.close();
        } catch (Exception e) {
            e.getMessage();
        }

        return logins;
    }

    public boolean insertNewAgentLogin(Login loginData) throws Exception {
        Boolean ans;
        try {

            dbCon = new ConnectionToDatabase();
            ps = dbCon.getConnection().prepareStatement("INSERT INTO LOGIN_CREDENTIALS (USERNAME, PASSWORDD,AGENT_ID) VALUES(?,?,?)");
            ps.setString(1, loginData.getUsername());
            ps.setString(2, loginData.getPassword());
            ps.setInt(3,loginData.getAgent().getN_idAgent());
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
    public boolean updateLogin(Login loginData) throws SQLException {
        Boolean ans;
        try {
            dbCon = new ConnectionToDatabase();
            ps = dbCon.getConnection().prepareStatement("UPDATE LOGIN_CREDENTIALS SET USERNAME =?, PASSWORDD = ? "
            		+ " WHERE USER_ID = ? AND AGENT_ID = ?");

            ps.setInt(4, loginData.getUser_id());
       //     ps.setInt(3, loginData.getAgent().getN_idAgent());
            ps.setString(1, loginData.getUsername());
            ps.setString(2, loginData.getPassword());
            

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
    public boolean deleteLogin(Login loginData) throws Exception {
        Boolean ans;
        try {
            dbCon = new ConnectionToDatabase();
            ps = dbCon.getConnection().prepareStatement("DELETE FROM LOGIN_CREDENTIALS WHERE USER_ID = ? AND AGENT_ID = ?");
            ps.setInt(1, loginData.getUser_id());
            ps.setInt(2, loginData.getAgent().getN_idAgent());
            
            rs = ps.executeQuery();
            ans = true;
        } catch (Exception e) {
            System.out.println(e.getMessage()+ "Account is in use");
            ans = false;
        }

        return ans;
    }
    
    public static void main(String[] args) throws ParseException {
//        TravelAgent agent3 = new TravelAgent();
//    	agent3.setAgentName("Fatmira");
//        agent3.setAgentSurname("Bracni");
//        agent3.setSalary(20000);
//        agent3.setN_idAgent(5);
        
        
//    	Login logD = new Login();
//        logD.setUsername("Inva");
//        logD.setPassword("invaceni");
//       // logD.setAgent(agent3);
//       // logD.setUser_id(7);
//              
//        LoginDAO dao = new LoginDAO();
//
//        try {
//          //    dao.insertNewAgentLogin(logD);
//          //  Boolean updated = dao.updateLogin(logD);
//        //    Boolean deleted = dao.deleteLogin(logD);
////            System.out.println(deleted);
////            ArrayList<Login> loginAcc = dao.showLoginAccounts();
//////
////            for (Login d : loginAcc) {
////                System.out.println(d+ "  PASSW:"+d.getPassword()); 
////                //tek passwordi ne db ruhet qwert + password + asdf 
////                //shfaqet ne listim qwertqwert+password+asdfasdf pasi 1 here e ka vete passwordi qwert asdf 
////                //dhe 1 here ia shton therritja e metodes showloginAccout
////            }
//    Login log = dao.agentCredentials(logD);
//            System.out.println(log.getAgent()+" "+log.getUsername()+" "+log.getPassword());
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            System.out.println(ex);
//            // Logger.getLogger(DestinationDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }
    
}
