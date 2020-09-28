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
public class TravelAgent {
    
    private int n_idAgent;
    private String agentName;
    private String agentSurname;
    private int salary;

    public TravelAgent() {
    }

    public TravelAgent(int n_idAgent, String agentName, String agentSurname, int salary) {
        this.n_idAgent = n_idAgent;
        this.agentName = agentName;
        this.agentSurname = agentSurname;
        this.salary = salary;
    }

    public String getAgentName() {
        return agentName;
    }

    public String getAgentSurname() {
        return agentSurname;
    }

    public int getN_idAgent() {
        return n_idAgent;
    }

    public int getSalary() {
        return salary;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public void setAgentSurname(String agentSurname) {
        this.agentSurname = agentSurname;
    }

    public void setN_idAgent(int n_idAgent) {
        this.n_idAgent = n_idAgent;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    public String toString(){
        return "Agent: "+this.agentName+" "+this.agentSurname;
    }
    
}
