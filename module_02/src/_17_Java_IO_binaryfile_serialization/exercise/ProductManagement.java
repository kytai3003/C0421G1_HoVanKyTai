package _17_Java_IO_binaryfile_serialization.exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductManagement {
    public static final String FILE_PATH = "D:\\C2401G1_HoVanKyTai\\module_02\\src\\_17_Java_IO_binaryfile_serialization\\exercise\\fileProduct.txt";
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Product> products = new ArrayList<>();
    public static void displayMainMenu() throws IOException {
        products.add(new Product("A01", "TV", "Samsung", "Best", 500));
        do {
            System.out.println("--------Product Management----------");
            System.out.println("1) Add new product");
            System.out.println("2) Display all");
            System.out.println("3) Find product by code");
            System.out.println("4) Write data to file");
            System.out.println("5) Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addNewProduct();
                    break;

                case 2:
                    readAndDisplayList(FILE_PATH);
                    break;

                case 3:
                    System.out.println("Input product code: ");
                    sc.nextLine();
                    String inputCode = sc.nextLine();
                    findProductById(inputCode);
                    break;

                case 4:
                    writeToFile(products, FILE_PATH);
                    System.out.println("Success.");
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Wrong input. Retry.");
            }
        } while (true);
    }

    public static Product findProductById(String id) {
        boolean isExist = false;
        Product searchProduct = null;
        for (Product product : products) {
            if (product.getProductCode().equals(id)) {
                searchProduct = product;
                isExist = true;
                break;
            }
        }
        if (isExist) {
            System.out.println("Found." + searchProduct.toString());
        } else {
            System.out.println("Not found.");
        }
        return searchProduct;
    }

    public static void readAndDisplayList(String path) throws IOException {
        FileInputStream inputStream;
        ObjectInputStream objectInput = null;
        try {
            inputStream = new FileInputStream(path);
            objectInput = new ObjectInputStream(inputStream);
            products = (ArrayList<Product>) objectInput.readObject();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (objectInput != null) {
                    objectInput.close();
                }
                for (Product p : products) {
                    System.out.println(p.toString());
                }
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    public static void addNewProduct() {
        System.out.println("Input product code: ");
        sc.nextLine();
        String codeProduct = sc.nextLine();
        System.out.println("Input product name: ");
        String nameProduct = sc.nextLine();
        System.out.println("Input brand: ");
        String brandProduct = sc.nextLine();
        System.out.println("Input other description: ");
        String descriptProduct = sc.nextLine();
        System.out.println("Input product price: ");
        double priceProduct = Integer.parseInt(sc.next());
        Product newProduct = new Product(codeProduct, nameProduct, brandProduct, descriptProduct, priceProduct);
        products.add(newProduct);
    }

    public static void writeToFile (ArrayList<Product> arrayList, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(arrayList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
