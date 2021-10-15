package com.example.demo.model.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String busCode;
    private String busType;
    private String busName;
    private String busPhone;
    private String busEmail;
    private String hourFrom;
    private String hourTo;

    @ManyToOne(targetEntity = Destination.class)
    @JsonManagedReference
    @JoinColumn(name = "destination_from_id", referencedColumnName = "id")
    private Destination destinationFrom;

    @ManyToOne(targetEntity = Destination.class)
    @JsonManagedReference
    @JoinColumn(name = "destination_to_id", referencedColumnName = "id")
    private Destination destinationTo;

    public Bus() {
    }

    public Destination getDestinationFrom() {
        return destinationFrom;
    }

    public void setDestinationFrom(Destination destinationFrom) {
        this.destinationFrom = destinationFrom;
    }

    public Destination getDestinationTo() {
        return destinationTo;
    }

    public void setDestinationTo(Destination destinationTo) {
        this.destinationTo = destinationTo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBusCode() {
        return busCode;
    }

    public void setBusCode(String busCode) {
        this.busCode = busCode;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getBusPhone() {
        return busPhone;
    }

    public void setBusPhone(String busPhone) {
        this.busPhone = busPhone;
    }

    public String getBusEmail() {
        return busEmail;
    }

    public void setBusEmail(String busEmail) {
        this.busEmail = busEmail;
    }

    public String getHourFrom() {
        return hourFrom;
    }

    public void setHourFrom(String hourFrom) {
        this.hourFrom = hourFrom;
    }

    public String getHourTo() {
        return hourTo;
    }

    public void setHourTo(String hourTo) {
        this.hourTo = hourTo;
    }
}
