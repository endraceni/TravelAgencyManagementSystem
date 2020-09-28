/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagencymanagementsystem.dto;

import java.sql.Date;

public class Traveller {
    private int n_idtraveller;
	private String t_name;
	private String t_surname;
	private Date d_birth;
	
	
	public Traveller() {}
	
	public Traveller(int n_idtraveller, String t_name, String t_surname, Date d_birth) {
		this.n_idtraveller = n_idtraveller;
		this.t_name = t_name;
		this.t_surname = t_surname;
		this.d_birth = d_birth;
	}
	public int getN_idtraveller() {
		return n_idtraveller;
	}
	public void setN_idtraveller(int n_idtraveller) {
		this.n_idtraveller = n_idtraveller;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getT_surname() {
		return t_surname;
	}
	public void setT_surname(String t_surname) {
		this.t_surname = t_surname;
	}
	public Date getD_birth() {
		return d_birth;
	}
	public void setD_birth(Date d_birth) {
		this.d_birth = d_birth;
	}

        public String toString(){
            return this.t_name+" "+this.t_surname;
        }
    
}
