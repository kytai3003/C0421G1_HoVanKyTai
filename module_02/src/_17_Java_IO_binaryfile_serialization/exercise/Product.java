package _17_Java_IO_binaryfile_serialization.exercise;

import java.io.Serializable;

public class Product implements Serializable {
    private String productCode, productName, productBrand, otherDescription;
    private double price;

    public Product(String productCode, String productName, String productBrand, String otherDescription, double price) {
        this.productCode = productCode;
        this.productName = productName;
        this.productBrand = productBrand;
        this.otherDescription = otherDescription;
        this.price = price;
    }

    public Product() {
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getOtherDescription() {
        return otherDescription;
    }

    public void setOtherDescription(String otherDescription) {
        this.otherDescription = otherDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productBrand='" + productBrand + '\'' +
                ", otherDescription='" + otherDescription + '\'' +
                ", price=" + price +
                '}';
    }
}
