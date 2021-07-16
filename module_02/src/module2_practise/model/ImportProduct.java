package module2_practise.model;

import java.io.Serializable;

public class ImportProduct extends Product implements Serializable {
    private double importPrice;
    private String provinceName;
    private double importTax;

    public ImportProduct(int productId, String productCode, String productName,
                         double productPrice, int productAmount, String productBrand,
                         double importPrice, String provinceName, double importTax) {
        super(productId, productCode, productName, productPrice, productAmount, productBrand);
        this.importPrice = importPrice;
        this.provinceName = provinceName;
        this.importTax = importTax;
    }

    public ImportProduct(double importPrice, String provinceName, double importTax) {
        this.importPrice = importPrice;
        this.provinceName = provinceName;
        this.importTax = importTax;
    }

    public ImportProduct() {
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String proviceName) {
        this.provinceName = proviceName;
    }

    public double getImportTax() {
        return importTax;
    }

    public void setImportTax(double importTax) {
        this.importTax = importTax;
    }

    @Override
    public String toString() {
        return "ImportProduct{" +
                "importPrice=" + importPrice +
                ", provinceName='" + provinceName + '\'' +
                ", importTax=" + importTax +
                ", productId=" + productId +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productAmount=" + productAmount +
                ", productBrand='" + productBrand + '\'' +
                '}';
    }
}
