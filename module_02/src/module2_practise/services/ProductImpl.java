package module2_practise.services;

import module2_practise.common.ReadAndWriteCSV;
import module2_practise.model.ExportProduct;
import module2_practise.model.ImportProduct;
import module2_practise.model.Product;
import module2_practise.validate.Validate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductImpl implements Serializable {
    private static final Scanner sc = new Scanner(System.in);
    private static List<Product> productList = new ArrayList<>();
    private static List<ImportProduct> importProducts = new ArrayList<>();
    private static List<ExportProduct> exportProducts = new ArrayList<>();
    private static final String FILE_PATH_PRODUCT = "D:\\C2401G1_HoVanKyTai\\module_02\\src\\module2_practise\\data\\product.csv";
    private static final ReadAndWriteCSV readAndWrite = new ReadAndWriteCSV();
    private static final Validate validate = new Validate();
    static {
        exportProducts.add(new ExportProduct(1, "Ex01", "Giay", 2323, 5, "Nike", 2525, "lao"));
        productList.addAll(importProducts);
        productList.addAll(exportProducts);
    }

    public void displayList() {
        productList = readAndWrite.readFile(FILE_PATH_PRODUCT);
        if (productList == null) {
            System.out.println("Danh sách rỗng.");
        } else {
            for (Product p : productList) {
                System.out.println(p.toString());
            }
        }
    }

    public void addNew() {
        while (true) {
            System.out.println("Bạn muốn thêm mới sản phẩm nhập khẩu hay xuất khẩu?");
            System.out.println("1) Nhập khẩu");
            System.out.println("2) Xuất khẩu");
            System.out.println("3) Thoát");
            int choice = 0;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException ex) {
                System.err.println("Chỉ nhập số và vui lòng nhập đúng số.");
            }
            switch (choice) {
                case 1:
                    addNewImportProduct();
                    break;

                case 2:
                    addNewExportProduct();
                    break;

                case 3:
                    return;

                default:
                    System.err.println("Vui lòng nhập lại.");
            }
        }
    }

    public void addNewImportProduct() {
        productList = readAndWrite.readFile(FILE_PATH_PRODUCT);
        int productId;
        if (productList == null) {
            productId = 1;
        } else {
            productId = productList.get(productList.size() - 1).getProductId() + 1;
        }
        ImportProduct newProduct = new ImportProduct();
        newProduct.setProductId(productId);
        System.out.println("Nhập mã sản phẩm: ");
        String productCode = validate.legalServiceBasicInfo();
        newProduct.setProductCode(productCode);
        System.out.println("Nhập tên sản phẩm: ");
        String productName = validate.legalServiceBasicInfo();
        newProduct.setProductName(productName);
        System.out.println("Nhập giá sản phẩm: ");
        double productPrice = validate.legalNumberField();
        newProduct.setImportPrice(productPrice);
        System.out.println("Nhập số lượng sản phẩm: ");
        int productAmount = validate.legalNumberField();
        newProduct.setProductAmount(productAmount);
        System.out.println("Nhập nhà sản xuất: ");
        String productBrand = validate.legalServiceBasicInfo();
        newProduct.setProductBrand(productBrand);
        System.out.println("Nhập giá nhập khẩu: ");
        double importPrice = validate.legalNumberField();
        newProduct.setImportPrice(importPrice);
        System.out.println("Nhập tên tỉnh thành: ");
        String province = validate.legalServiceBasicInfo();
        newProduct.setProvinceName(province);
        System.out.println("Nhập thuế: ");
        double tax = validate.legalNumberField();
        newProduct.setImportTax(tax);
        importProducts.add(newProduct);
        productList.add(newProduct);
        readAndWrite.writeFile(FILE_PATH_PRODUCT, (ArrayList<Product>) productList);
    }

    public void addNewExportProduct() {
        productList = readAndWrite.readFile(FILE_PATH_PRODUCT);
        int productId;
        if (productList == null) {
            productId = 1;
        } else {
            productId = productList.get(productList.size() - 1).getProductId() + 1;
        }
        System.out.println("Nhập mã sản phẩm: ");
        String productCode = validate.legalServiceBasicInfo();
        System.out.println("Nhập tên sản phẩm: ");
        String productName = validate.legalServiceBasicInfo();
        System.out.println("Nhập giá sản phẩm: ");
        double productPrice = validate.legalNumberField();
        System.out.println("Nhập số lượng sản phẩm: ");
        int productAmount = validate.legalNumberField();
        System.out.println("Nhập nhà sản xuất: ");
        String productBrand = validate.legalServiceBasicInfo();
        System.out.println("Nhập giá xuất khẩu: ");
        double exportPrice = validate.legalNumberField();
        System.out.println("Nhập tên nước xuất khẩu: ");
        String country = validate.legalServiceBasicInfo();
        ExportProduct newProduct = new ExportProduct(productId, productCode, productName,
                productPrice, productAmount, productBrand, exportPrice, country);
        exportProducts.add(newProduct);
        productList.add(newProduct);
        readAndWrite.writeFile(FILE_PATH_PRODUCT, (ArrayList<Product>) productList);
    }

    public void delete() {
        productList = readAndWrite.readFile(FILE_PATH_PRODUCT);
        System.out.println("Nhập mã sản phẩm cần xóa:" );
        String code = sc.nextLine();
        String result = "";
        boolean isExist = false;
        for (Product p: productList) {
            if (code.equals(p.getProductCode())) {
                result = p.toString();
                isExist = true;
                break;
            }
        }
        if (isExist) {
            System.out.println("Result: " + result);
            System.out.println("Xác nhận muốn xóa?");
            System.out.println("1) OK");
            System.out.println("2) Không");
            int choice = 0;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException ex) {
                System.err.println("Chỉ nhập số.");
            }
            if (choice == 1) {
                for (Product p: productList) {
                    if (code.equals(p.getProductCode())) {
                        productList.remove(p);
                        break;
                    }
                }
                System.out.println("Danh sách sau khi đã xóa:" );
                for (Product p : productList) {
                    System.out.println(p.toString());
                }
            } else {
                return;
            }
        } else {
            System.out.println("Không tìm thấy!");
        }
        readAndWrite.writeFile(FILE_PATH_PRODUCT, (ArrayList<Product>) productList);
    }

    public void search() {
        productList = readAndWrite.readFile(FILE_PATH_PRODUCT);
        System.out.println("Nhập mã sản phẩm cần tìm:");
        String code = sc.nextLine();
        String result = "";
        boolean isExist = true;
        for (Product p: productList) {
            if (code.equals(p.getProductCode())){
                isExist = true;
                result = p.toString();
                break;
            } else {
                isExist = false;
            }
        }
        if (isExist) {
            System.out.println("Kết quả: " + result);
        } else {
            System.out.println("Không tìm thấy");
        }
    }
}
