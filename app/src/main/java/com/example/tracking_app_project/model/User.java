package com.example.tracking_app_project.model;

public class User {
    private int id;
    private String pseudo;
    private int team;
    private String phoneNumber;

    public User(int id, String pseudo, int team, String phoneNumber) {
        this.id = id;
        this.pseudo = pseudo;
        this.team = team;
        this.phoneNumber = phoneNumber;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "pseudo='" + pseudo + '\'' +
                ", group=" + team +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
