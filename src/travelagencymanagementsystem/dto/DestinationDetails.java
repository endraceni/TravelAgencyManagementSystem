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
public class DestinationDetails extends Destination{
	
	private List<Travel> list_trav_dest;
	
	public DestinationDetails() {}

	public DestinationDetails(List<Travel> list_trav_dest) {
		super();
		this.list_trav_dest = list_trav_dest;
	}

	public List<Travel> getList_trav_dest() {
		return list_trav_dest;
	}

	public void setList_trav_dest(List<Travel> list_trav_dest) {
		this.list_trav_dest = list_trav_dest;
	}
    
}
