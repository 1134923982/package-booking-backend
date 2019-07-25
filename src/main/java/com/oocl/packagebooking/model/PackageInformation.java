package com.oocl.packagebooking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class PackageInformation {
    @Id
    private long id;
    private String username;
    private String iphoneNumber;

    @Column(columnDefinition = "boolean default 0")
    private int state;
    private Date bookingTime;

    public PackageInformation() {
    }

    public PackageInformation(long id, String username, String iphoneNumber, int state, Date bookingTime) {
        this.id = id;
        this.username = username;
        this.iphoneNumber = iphoneNumber;
        this.state = state;
        this.bookingTime = bookingTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIphoneNumber() {
        return iphoneNumber;
    }

    public void setIphoneNumber(String iphoneNumber) {
        this.iphoneNumber = iphoneNumber;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }
}
