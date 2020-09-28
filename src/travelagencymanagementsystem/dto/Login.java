package travelagencymanagementsystem.dto;

/**
 *
 * @author User
 */
public class Login {
    
    private int user_id;
    private String username;
    private String password;
    private TravelAgent agent;

    public Login() {
    }

    public Login(int user_id, String username, String password, TravelAgent agent) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.agent = agent;
    }

    public TravelAgent getAgent() {
        return agent;
    }

    public String getPassword() {
        return password;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setAgent(TravelAgent agent) {
        this.agent = agent;
    }

    public void setPassword(String password) {
        this.password ="qwert"+ password+"asdf";
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String toString() {
        return "User: "+this.username;
    }
    
    
    
}