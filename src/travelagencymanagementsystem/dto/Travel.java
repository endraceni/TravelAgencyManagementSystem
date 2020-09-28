/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagencymanagementsystem.dto;

import java.util.Date;

/**
 *
 * @author User
 */
public class Travel {

    private int n_idtravel;
    private int n_iddestination;
    private Date d_start;
    private Date d_end;
    private Date d_delete;

    public Travel() {
    }

    public Travel(int n_idtravel, int n_iddestination, Date d_start, Date d_end, Date d_delete) {
        this.n_idtravel = n_idtravel;
        this.n_iddestination = n_iddestination;
        this.d_start = d_start;
        this.d_end = d_end;
        this.d_delete = d_delete;
    }

    public int getN_idtravel() {
        return n_idtravel;
    }

    public void setN_idtravel(int n_idtravel) {
        this.n_idtravel = n_idtravel;
    }

    public int getN_iddestination() {
        return n_iddestination;
    }

    public void setN_iddestination(int n_iddestination) {
        this.n_iddestination = n_iddestination;
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

    public Date getD_delete() {
        return d_delete;
    }

    public void setD_delete(Date d_delete) {
        this.d_delete = d_delete;
    }

}
