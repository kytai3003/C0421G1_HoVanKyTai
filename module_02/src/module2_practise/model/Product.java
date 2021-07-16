package module2_practise.model;

import java.io.Serializable;

public abstract class Product implements Serializable {
    protected int productId;
    protected String productCode;
    protected String productName;
    protected double productPrice;
    protected int productAmount;
    protected String productBrand;

    public Product(int productId, String productCode, String productName, double productPrice,
                   int productAmount, String productBrand) {
        this.productId = productId;
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productAmount = productAmount;
        this.productBrand = productBrand;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productAmount=" + productAmount +
                ", productBrand='" + productBrand + '\'' +
                '}';
    }
}
