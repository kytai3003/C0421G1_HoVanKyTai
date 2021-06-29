package resort_management.models;

public abstract class Facility {
    protected String nameOfService;
    protected double usingArea;
    protected double price;
    protected int capacity;
    protected String typeOfHiring;

    public Facility(String nameOfService, double usingArea, double price, int capacity, String typeOfHiring) {
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

    public double getUsingArea() {
        return usingArea;
    }

    public void setUsingArea(double usingArea) {
        this.usingArea = usingArea;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getTypeOfHiring() {
        return typeOfHiring;
    }

    public void setTypeOfHiring(String typeOfHiring) {
        this.typeOfHiring = typeOfHiring;
    }

}
