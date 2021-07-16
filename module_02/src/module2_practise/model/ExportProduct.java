package module2_practise.model;

import java.io.Serializable;

public class ExportProduct extends Product implements Serializable {
    private double exportPrice;
    private String importCountry;

    public ExportProduct(int productId, String productCode, String productName,
                         double productPrice, int productAmount, String productBrand,
                         double exportPrice, String importCountry) {
        super(productId, productCode, productName, productPrice, productAmount, productBrand);
        this.exportPrice = exportPrice;
        this.importCountry = importCountry;
    }

    public ExportProduct(double exportPrice, String importCountry) {
        this.exportPrice = exportPrice;
        this.importCountry = importCountry;
    }

    public ExportProduct() {
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getImportCountry() {
        return importCountry;
    }

    public void setImportCountry(String importCountry) {
        this.importCountry = importCountry;
    }

    @Override
    public String toString() {
        return "ExportProduct{" +
                "exportPrice=" + exportPrice +
                ", importCountry='" + importCountry + '\'' +
                ", productId=" + productId +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productAmount=" + productAmount +
                ", productBrand='" + productBrand + '\'' +
                '}';
    }
}
