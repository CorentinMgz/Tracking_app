package com.example.tracking_app_project.model;

public class Team {
    private int id;
    private int teamLeader;

    public Team(int id, int groupLeader) {
        this.id = id;
        this.teamLeader = groupLeader;
    }

    public Team() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeamLeader() {
        return teamLeader;
    }

    public void setTeamLeader(int teamLeader) {
        this.teamLeader = teamLeader;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamLeader=" + teamLeader +
                '}';
    }
}
