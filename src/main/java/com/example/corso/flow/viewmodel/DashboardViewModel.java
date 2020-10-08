package com.example.corso.flow.viewmodel;

public class DashboardViewModel {
    private String username;
    private String firstName;
    // cambio di specifica: ho una nuova property
    private String greet;

    public String getGreet() {
        return greet;
    }

    public void setGreet(String greet) {
        this.greet = greet;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
