/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagencymanagementsystem.dto;

import java.sql.Date;
/**
 *
 * @author User
 */
public class Reservation {
    private int idReservation;
    private Trip trip;
    private Traveller traveller;
    private Accomodation accomodation;
    private TravelAgent agent;
    private Date reservationDate;
    private double totalPrice;
    private Boolean cancelled = false;
    private Date cancelDate;

    public Reservation() {
    }

    public Reservation(int idReservation, Trip trip, Traveller traveller, Accomodation accomodation, TravelAgent agent, Date reservationDate, double totalPrice, Date cancelDate) {
        this.idReservation = idReservation;
        this.trip = trip;
        this.traveller = traveller;
        this.accomodation = accomodation;
        this.agent = agent;
        this.reservationDate = reservationDate;
        this.totalPrice = totalPrice;
        this.cancelDate = cancelDate;
    }

    public double getTotalPrice() {
    	totalPrice = accomodation.getCost()+trip.getPrice();
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Accomodation getAccomodation() {
        return accomodation;
    }

    public TravelAgent getAgent() {
        return agent;
    }

    public Date getCancelDate() {
        return cancelDate;
    }

    public Boolean getCancelled() {
        return cancelled;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public Traveller getTraveller() {
        return traveller;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setAccomodation(Accomodation accomodation) {
        this.accomodation = accomodation;
    }

    public void setAgent(TravelAgent agent) {
        this.agent = agent;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }

    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public void setTraveller(Traveller traveller) {
        this.traveller = traveller;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public String toString() {
        if(this.cancelled == false){
        return "Reservation made for "+this.traveller+" from agent "+this.agent+". \n Details: \n "+this.trip+" "+
                this.accomodation+" "+this.reservationDate+" Price:"+this.getTotalPrice();
        }
        else{
            return "Reservation made for"+this.traveller+" from agent "+this.agent+".\nDetails: "+this.trip+" "+
                this.accomodation+" "+this.reservationDate+" Price:"+this.totalPrice+ " was cancelled on "+this.cancelDate;
        }
    }
    
    
    
    
}
