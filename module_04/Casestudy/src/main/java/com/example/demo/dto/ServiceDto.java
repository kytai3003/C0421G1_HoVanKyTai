package com.example.demo.dto;

import com.example.demo.model.entity.contract.Contract;
import com.example.demo.model.entity.service.RentType;
import com.example.demo.model.entity.service.ServiceType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

public class ServiceDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceId;
    @NotBlank(message = "Please fill in.")
    @Pattern(regexp = "^DV-\\d{4}$", message = "Invalid input.")
    private String serviceCode;
    @NotBlank(message = "Please fill in.")
    private String serviceName;
    @Min(value = 1, message = "Positive number input only.")
    private int serviceArea;
    @Min(value = 1, message = "Positive number input only.")
    private double serviceCost;
    @Min(value = 1, message = "Positive number input only.")
    private int serviceCapacity;
    @NotBlank(message = "Please fill in.")
    private String standardRoom;
    @NotBlank(message = "Please fill in.")
    private String otherConvenience;
    @Min(value = 1, message = "Positive number input only.")
    private double poolArea;
    @Min(value = 1, message = "Positive number input only.")
    private int numberOfFloor;
    private ServiceType serviceType;
    private RentType rentType;
    private List<Contract> contract;


    public ServiceDto() {
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(int serviceArea) {
        this.serviceArea = serviceArea;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public int getServiceCapacity() {
        return serviceCapacity;
    }

    public void setServiceCapacity(int serviceCapacity) {
        this.serviceCapacity = serviceCapacity;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getOtherConvenience() {
        return otherConvenience;
    }

    public void setOtherConvenience(String otherConvenience) {
        this.otherConvenience = otherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public List<Contract> getContract() {
        return contract;
    }

    public void setContract(List<Contract> contract) {
        this.contract = contract;
    }
}
