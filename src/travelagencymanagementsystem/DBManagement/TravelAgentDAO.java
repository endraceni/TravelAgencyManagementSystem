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
import travelagencymanagementsystem.dto.TravelAgent;

/**
 *
 * @author User
 */
public class TravelAgentDAO {
    
     private ConnectionToDatabase dbCon;
    public Connection conn;
    private ArrayList<TravelAgent> agents;
    private TravelAgent agent;
    private PreparedStatement ps;
    private ResultSet rs;

    public TravelAgentDAO() {
        //AGENT_ID 
        //AGENT_NAME 
        //AGENT_SURNAME
        //SALARY 
    }
//
    public ArrayList<TravelAgent> showAllAgents() {
        ArrayList<TravelAgent> agents = new ArrayList<TravelAgent>();
        try {

            dbCon = new ConnectionToDatabase();
            conn = dbCon.getConnection();
            ps = conn.prepareStatement("SELECT AGENT_ID, AGENT_NAME, AGENT_SURNAME, SALARY FROM TRAVEL_AGENT");
          
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TravelAgent ta = new TravelAgent();
                ta.setN_idAgent(rs.getInt("AGENT_ID"));
                ta.setAgentName(rs.getString("AGENT_NAME"));
                ta.setAgentSurname(rs.getString("AGENT_SURNAME"));
                ta.setSalary(rs.getInt("SALARY"));

                agents.add(ta);
                
            }

            conn.close();
        } catch (Exception e) {
            e.getMessage();
        }

        return agents;
    }

    public boolean insertAgent(TravelAgent agent) throws Exception {
        Boolean ans;
        try {

            dbCon = new ConnectionToDatabase();
            ps = dbCon.getConnection().prepareStatement("INSERT INTO TRAVEL_AGENT (AGENT_NAME, AGENT_SURNAME,SALARY) VALUES(?,?,?)");
            ps.setString(1, agent.getAgentName());
            ps.setString(2,agent.getAgentSurname());
            ps.setInt(3, agent.getSalary());
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
    public boolean updateAgent(TravelAgent agent) throws SQLException {
        Boolean ans;
        try {
            dbCon = new ConnectionToDatabase();
            ps = dbCon.getConnection().prepareStatement("UPDATE TRAVEL_AGENT SET AGENT_NAME =?, AGENT_SURNAME = ?,"
                    + " SALARY = ? WHERE AGENT_ID = ?");

            ps.setInt(4, agent.getN_idAgent());
            ps.setString(1, agent.getAgentName());
            ps.setString(2, agent.getAgentSurname());
            ps.setDouble(3, agent.getSalary());
            
            rs = ps.executeQuery();

            dbCon.getConnection().commit();
            ans = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ans = false;
        }

        return ans;

    }
////
    public boolean deleteAgent(TravelAgent agent) throws Exception {
        Boolean ans;
        try {
            dbCon = new ConnectionToDatabase();
         //   LoginDAO dao = new LoginDAO();
         //   dao.deleteLogin(dao.agentCredentialsAgentId(agent.getN_idAgent()));
            ps = dbCon.getConnection().prepareStatement("DELETE FROM TRAVEL_AGENT WHERE AGENT_ID = ?");
            
            
            ps.setInt(1,agent.getN_idAgent());
            
            rs = ps.executeQuery();
            ans = true;
        } catch (Exception e) {
            System.out.println(e.getMessage()+ "Somewthing went wrong");
            ans = false;
        }

        return ans;
    }

    public static void main(String[] args) throws ParseException {

    	TravelAgent agent = new TravelAgent();
    	agent.setAgentName("Mihrije");
        agent.setAgentSurname("Braha");
        agent.setSalary(901);
        agent.setN_idAgent(4);
        
        TravelAgent agent2 = new TravelAgent();
    	agent2.setAgentName("Denis");
        agent2.setAgentSurname("Sahatciu");
        agent2.setSalary(2000);
        agent2.setN_idAgent(2);
        
        
        TravelAgent agent3 = new TravelAgent();
    	agent3.setAgentName("Ana");
        agent3.setAgentSurname("Ktona");
        agent3.setSalary(1000);
        agent3.setN_idAgent(5);
        
        TravelAgentDAO dao = new TravelAgentDAO();

        try {
          // dao.insertAgent(agent);
           // Boolean updated = dao.updateAgent(agent2);
            Boolean deleted = dao.deleteAgent(agent3);
            System.out.println(deleted);
            ArrayList<TravelAgent> agents= dao.showAllAgents();

            for (TravelAgent d : agents) {
                System.out.println(d + " "+d.getSalary());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex);
            // Logger.getLogger(DestinationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
