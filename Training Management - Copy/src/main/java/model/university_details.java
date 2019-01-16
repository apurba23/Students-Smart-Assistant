/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author faisal-shakiba
 */
public class university_details {
    private String id;

    public university_details(String id, String university_name, String address, String location, String lat_long) {
        this.id = id;
        this.university_name = university_name;
        this.address = address;
        this.location = location;
        this.lat_long = lat_long;
    }
    private String university_name;
    private String address;
    private String location;
    private String lat_long;

    public university_details() {
    }

    public university_details(String university_name, String address, String location, String lat_long) {
        this.university_name = university_name;
        this.address = address;
        this.location = location;
        this.lat_long = lat_long;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUniversity_name() {
        return university_name;
    }

    public void setUniversity_name(String university_name) {
        this.university_name = university_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLat_long() {
        return lat_long;
    }

    public void setLat_long(String lat_long) {
        this.lat_long = lat_long;
    }

    @Override
    public String toString() {
        return "university_details{" + "university_name=" + university_name + ", address=" + address + ", location=" + location + ", lat_long=" + lat_long + '}';
    }
    
}
