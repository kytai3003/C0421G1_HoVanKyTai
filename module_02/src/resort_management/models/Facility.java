package resort_management.models;

import java.io.Serializable;
import java.util.Objects;

public abstract class Facility implements Serializable {
    protected String nameOfService;
    protected String typeOfHiring;
    protected String usingArea;
    protected String price;
    protected String capacity;

    public Facility(String nameOfService, String usingArea, String price, String capacity, String typeOfHiring) {
        this.nameOfService = nameOfService;
        this.usingArea = usingArea;
        this.price = price;
        this.capacity = capacity;
        this.typeOfHiring = typeOfHiring;
    }

    public Facility() {
    }

    public String getNameOfService() {
        return nameOfService;
    }

    public void setNameOfService(String nameOfService) {
        this.nameOfService = nameOfService;
    }

    public String getUsingArea() {
        return usingArea;
    }

    public void setUsingArea(String usingArea) {
        this.usingArea = usingArea;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getTypeOfHiring() {
        return typeOfHiring;
    }

    public void setTypeOfHiring(String typeOfHiring) {
        this.typeOfHiring = typeOfHiring;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "nameOfService='" + nameOfService + '\'' +
                ", usingArea=" + usingArea +
                ", price=" + price +
                ", capacity=" + capacity +
                ", typeOfHiring='" + typeOfHiring + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Facility)) return false;
        Facility facility = (Facility) o;
        return capacity == facility.capacity &&
                Objects.equals(nameOfService, facility.nameOfService) &&
                Objects.equals(typeOfHiring, facility.typeOfHiring) &&
                Objects.equals(usingArea, facility.usingArea) &&
                Objects.equals(price, facility.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfService, typeOfHiring, usingArea, price, capacity);
    }
}
