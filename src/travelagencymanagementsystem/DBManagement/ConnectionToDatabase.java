/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagencymanagementsystem.DBManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class ConnectionToDatabase {
 
    static ConnectionToDatabase instance ;
    static Connection connection ;
    static Statement stmt ;
    static ResultSet resultSet ;

    ConnectionToDatabase(){}

   public static ConnectionToDatabase getInstance(){
        if(instance == null){
            instance = new ConnectionToDatabase();
        }
        return instance;
    }
    
    public static Statement getStatement(){
        try{
            stmt = connection.createStatement(); 
        }catch (Exception e ) {
            System.out.println(e);
        }
    
        return stmt;
    }
    
    public static void insertQuery(String query){
        try{
            stmt=getStatement(); 
            stmt.execute(query);
        } 
        catch (Exception e ) {
            System.out.println(e);
        }
    }
   
    public  Connection getConnection(){
        try{ 
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            connection =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ADMIN","endra123"); 
        }catch(Exception e){ 
            e.printStackTrace();
            System.out.println(e+ ". Could not connect");
        }  
   
        return connection;
    }
        
    public static ResultSet readDatabase (String query) {
        try{  
            stmt=getStatement();  
            resultSet = stmt.executeQuery(query);                
        }
        catch(Exception e){
            System.out.println(e+" prob reading the database");
        }  
        return resultSet;
    }
    
    public static void closeConnection(){
         try{
          try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (stmt != null) {
                stmt.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {

        }
         }
         catch(Exception e){ System.out.println(e);} 
    }
}
