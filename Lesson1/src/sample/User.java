package sample;

public class User {
    private String fname;
    private String lname;
    private String username;
    private String password;
    private String location;
    private String gender;

    public User(String fname, String lname, String username, String password, String location, String gender) {
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
        this.location = location;
        this.gender = gender;
    }

    public User() {

    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }
}