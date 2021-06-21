package com.example.tracking_app_project.model;

public class Waypoint {
    private int id;
    private String waypointName;
    private double longitude;
    private double latitude;
    private double altitude;
    private int route;

    public Waypoint(int id, String waypointName, double longitude, double latitude, double altitude, int route) {
        this.id = id;
        this.waypointName = waypointName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
        this.route = route;
    }

    public Waypoint() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWaypointName() {
        return waypointName;
    }

    public void setWaypointName(String waypointName) {
        this.waypointName = waypointName;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public int getRoute() {
        return route;
    }

    public void setRoute(int route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "Waypoint{" +
                "waypointName='" + waypointName + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", altitude=" + altitude +
                ", route=" + route +
                '}';
    }
}
