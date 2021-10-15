package com.example.demo.model.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

//    @JsonBackReference
    @OneToMany(mappedBy = "destinationFrom", cascade = CascadeType.ALL)
    private List<Bus> busListFrom;

    @JsonBackReference
    @OneToMany(mappedBy = "destinationTo", cascade = CascadeType.ALL)
    private List<Bus> busListTo;

    public Destination() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bus> getBusListFrom() {
        return busListFrom;
    }

    public void setBusListFrom(List<Bus> busListFrom) {
        this.busListFrom = busListFrom;
    }

    public List<Bus> getBusListTo() {
        return busListTo;
    }

    public void setBusListTo(List<Bus> busListTo) {
        this.busListTo = busListTo;
    }
}
