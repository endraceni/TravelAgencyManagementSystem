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
public class Destination {

    private int n_iddestination;
    private String t_city;
    private String t_state;
    private String attraction;

    public Destination() {
    }

    public Destination(int n_iddestination, String t_city, String t_state, String attraction) {
        this.n_iddestination = n_iddestination;
        this.t_city = t_city;
        this.t_state = t_state;
        this.attraction = attraction;
    }
   
    public int getN_iddestination() {
        return n_iddestination;
    }

    public void setN_iddestination(int n_iddestination) {
        this.n_iddestination = n_iddestination;
    }

    public String getT_city() {
        return t_city;
    }

    public void setT_city(String t_city) {
        this.t_city = t_city;
    }

    public String getT_state() {
        return t_state;
    }

    public void setT_state(String t_state) {
        this.t_state = t_state;
    }

    public String getAttraction() {
        return attraction;
    }

    public void setAttraction(String attraction) {
        this.attraction = attraction;
    }

    public String toString() {
        return "Visit " + this.getT_city() + " in " + this.getT_state();
    }
}
