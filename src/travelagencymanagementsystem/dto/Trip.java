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
public class Trip {

    private int n_idTrip;
    private String title;
    private double price;
    private Date d_start;
    private Date d_end;
    private Destination destination;

    public Trip() {
    }

    public Trip(int n_idtravel, String title, double price, Date d_start, Date d_end, Destination destination) {
        this.n_idTrip = n_idtravel;
        this.title = title;
        this.price = price;
        this.d_start = d_start;
        this.d_end = d_end;
        this.destination = destination;
    }

    public void setN_idTrip(int n_idTrip) {
        this.n_idTrip = n_idTrip;
    }

    public int getN_idTrip() {
        return n_idTrip;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    public Date getD_start() {
        return d_start;
    }

    public void setD_start(Date d_start) {
        this.d_start = d_start;
    }

    public Date getD_end() {
        return d_end;
    }

    public void setD_end(Date d_end) {
        this.d_end = d_end;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public String toString(){
        return this.getTitle()+" in "+this.getDestination().getT_city()+ " for "+this.getPrice();
    }

}
