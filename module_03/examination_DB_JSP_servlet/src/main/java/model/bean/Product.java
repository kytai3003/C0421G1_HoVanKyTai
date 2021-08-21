package model.bean;

public class Product {
    private int idProduct;
    private String nameProduct;
    private double price;
    private int amount;
    private String colorProduct;
    private String description;
    private int idCatelogy;

    public Product(int idProduct, String nameProduct, double price, int amount, String colorProduct, String description, int idCatelogy) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.amount = amount;
        this.colorProduct = colorProduct;
        this.description = description;
        this.idCatelogy = idCatelogy;
    }

    public Product(String nameProduct, double price, int amount, String colorProduct, String description, int idCatelogy) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.amount = amount;
        this.colorProduct = colorProduct;
        this.description = description;
        this.idCatelogy = idCatelogy;
    }

    public Product() {
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getColorProduct() {
        return colorProduct;
    }

    public void setColorProduct(String colorProduct) {
        this.colorProduct = colorProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdCatelogy() {
        return idCatelogy;
    }

    public void setIdCatelogy(int idCatelogy) {
        this.idCatelogy = idCatelogy;
    }
}
