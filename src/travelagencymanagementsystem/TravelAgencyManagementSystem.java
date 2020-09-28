/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagencymanagementsystem;

import java.util.ArrayList;
import java.util.List;
import travelagencymanagementsystem.dto.Accomodation;
import travelagencymanagementsystem.dto.Destination;
import travelagencymanagementsystem.dto.Login;
import travelagencymanagementsystem.dto.Reservation;
import travelagencymanagementsystem.dto.TravelAgent;
import travelagencymanagementsystem.dto.Traveller;
import travelagencymanagementsystem.dto.Trip;


/**
 *
 * @author User
 */
public class TravelAgencyManagementSystem {

    private List<Destination> destinations = new ArrayList<Destination>();
    private List<Traveller> travellers = new ArrayList<Traveller>();
    private List<Trip> trips = new ArrayList<Trip>();
    private List<Reservation> reservations = new ArrayList<Reservation>();
    private List<TravelAgent> agent = new ArrayList<TravelAgent>();
    private List<Login> logins = new ArrayList<Login>();
    private List<Accomodation> accomodations = new ArrayList<Accomodation>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
