package com.java.coronavirustracker.model;

public class LocationStat    {

    private String state;
    private String country;
    private int latestCases;


    public LocationStat(String state, String country, int latestCases) {
        this.state = state;
        this.country = country;
        this.latestCases = latestCases;
    }

    public LocationStat() {

    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getLatestCases() {
        return latestCases;
    }

    public void setLatestCases(int latestCases) {
        this.latestCases = latestCases;
    }

    @Override
    public String toString() {
        return "LocationStats{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", latestCases=" + latestCases +
                '}';
    }
}
