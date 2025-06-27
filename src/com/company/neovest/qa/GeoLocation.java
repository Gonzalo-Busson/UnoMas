package com.company.neovest.qa;

public class GeoLocation {
    private  int latitude;
    private  int longitude;

    public GeoLocation(int latitude, int longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLocation() {
        return "Latitude: " + latitude + ", Longitude: " + longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public Double distancia(GeoLocation otra) {
        double distancia = Math.sqrt(Math.pow((otra.getLatitude() - this.latitude), 2) + Math.pow((otra.getLongitude() - this.longitude), 2));
        return distancia;
    }

}
