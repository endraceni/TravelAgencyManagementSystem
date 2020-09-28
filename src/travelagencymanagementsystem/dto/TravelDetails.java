/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagencymanagementsystem.dto;

import java.util.List;

/**
 *
 * @author User
 */
public class TravelDetails extends Travel{
	
    private List<Reservation> list_reservation;
    private List<Traveller>   list_traveller;
    
    public TravelDetails () {}
    
	public TravelDetails(List<Reservation> list_reservation, List<Traveller> list_traveller) {
		super();
		this.list_reservation = list_reservation;
		this.list_traveller = list_traveller;
	}

	public List<Reservation> getList_reservation() {
		return list_reservation;
	}
	public void setList_reservation(List<Reservation> list_reservation) {
		this.list_reservation = list_reservation;
	}
	
	public List<Traveller> getList_traveller() {
		return list_traveller;
	}
	
	public void setList_traveller(List<Traveller> list_traveller) {
		this.list_traveller = list_traveller;
	}

       
}
