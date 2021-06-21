package com.example.tracking_app_project.model;

public class Route {
    private int id;
    private String routeName;
    private int distance;
    private int duration;
    private double averageSpeed;
    private int waypointQuantity;

    public Route(int id, String routeName, int distance, int duration, double averageSpeed, int waypointQuantity) {
        this.id = id;
        this.routeName = routeName;
        this.distance = distance;
        this.duration = duration;
        this.averageSpeed = averageSpeed;
        this.waypointQuantity = waypointQuantity;
    }

    public Route() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public int getWaypointQuantity() {
        return waypointQuantity;
    }

    public void setWaypointQuantity(int waypointQuantity) {
        this.waypointQuantity = waypointQuantity;
    }

    @Override
    public String toString() {
        return "Route{" +
                "routeName='" + routeName + '\'' +
                ", distance=" + distance +
                ", duration=" + duration +
                ", averageSpeed=" + averageSpeed +
                ", waypointQuantity=" + waypointQuantity +
                '}';
    }
}
