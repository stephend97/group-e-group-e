package com.example.max.myapplication;

/**
 * Created by max
 */

public class User {

    String firstName = "";
    String lastName = "";
    String username = "";
    String password = "";
    boolean isTeacher;

    public User() {
        this.firstName = "John";
        this.lastName = "Doe";
        this.username = "John.Doe";
        this.password = "password";
        this.isTeacher = false;
    }

    public User(String pfirstName, String plastName, String pusername, String ppassword, boolean pisTeacher) {
        this.firstName = pfirstName;
        this.lastName = plastName;
        this.username = pusername;
        this.password = ppassword;
        this.isTeacher = pisTeacher;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setTeacher(boolean pteacher) {
        this.isTeacher = pteacher;
    }

    public boolean getTeacher() {
        return isTeacher;
    }

}
