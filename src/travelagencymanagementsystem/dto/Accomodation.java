/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagencymanagementsystem.dto;

/**
 *
 * @author User
 */
public class Accomodation {
    
    private int n_idAccomodation;
    private String accomodation_type;
    private String address;
    private double cost;
    private Destination destination;

    public Accomodation() {
    }

    public Accomodation(int n_idAccomodation, String accomodation_type, String address, double cost, Destination destination) {
        this.n_idAccomodation = n_idAccomodation;
        this.accomodation_type = accomodation_type;
        this.address = address;
        this.cost = cost;
        this.destination = destination;
    }

    public String getAccomodation_type() {
        return accomodation_type;
    }

    public String getAddress() {
        return address;
    }

    public double getCost() {
        return cost;
    }

    public Destination getDestination() {
        return destination;
    }

    public int getN_idAccomodation() {
        return n_idAccomodation;
    }

    public void setAccomodation_type(String accomodation_type) {
        this.accomodation_type = accomodation_type;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public void setN_idAccomodation(int n_idAccomodation) {
        this.n_idAccomodation = n_idAccomodation;
    }

    public String toString() {
        return this.accomodation_type+" in "+this.address+" for "+this.cost;
    } 
}
