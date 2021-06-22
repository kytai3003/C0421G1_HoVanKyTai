package _12_Java_collection_framework.exercise.product_management;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Product product1 = new Product("Cóc", 1, 15000);
        Product product2 = new Product("Ổi", 2, 20000);
        Product product3 = new Product("Xoài", 3, 25500);
        Product product5 = new Product("Lê", 5, 35000);
        ArrayList<Product> products = new ArrayList<>();


        // Thêm sản phẩm
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product5);
        addNewItem("Cam", 4, 30000, products);
        addNewItem("Dưa", 6, 80000, products);


        // Hiển thị danh sách sản phẩm
        for (Product product : products) {
            System.out.println(product);
        }


        // Sửa thông tin sản phẩm theo id
        System.out.println("Nhập id sản phẩm cần sửa: ");
        int editId = input.nextInt();
        boolean isIdEdit = false;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == editId) {
                isIdEdit = true;
                break;
            } else {
                isIdEdit = false;
            }
        }
        if (isIdEdit) {
            editItem(editId, products);
        } else {
            System.out.println("Wrong id.");
        }

        for (Product product: products) {
            System.out.println(product);
        }


        // Tìm kiếm theo tên sản phẩm
        System.out.println("Input name of product to search: ");
        String nameItem = input.next();
        searchNameItem(nameItem, products);


        // Xóa sản phẩm theo id
        System.out.println("Input id of deleting product: ");
        int deleteId = input.nextInt();
        deleteItem(deleteId, products);
        for (Product product: products) {
            System.out.println(product);
        }


//        Sắp xếp theo tên
        products.sort(Product::compareTo);
        System.out.println("Name arcording sorted: ");
        for (Product product: products) {
            System.out.println(product);
        }


        // Sắp xếp theo giá tăng dần và giảm dần
        PriceAscendingComparator priceAscendingComparator = new PriceAscendingComparator();
        PriceDescendingComparator priceDescendingComparator = new PriceDescendingComparator();
        products.sort(priceAscendingComparator);
        System.out.println("Price ascending sorted: ");
        for (Product product: products) {
            System.out.println(product);
        }
        products.sort(priceDescendingComparator);
        System.out.println("Price descending sorted: ");
        for (Product product: products) {
            System.out.println(product);
        }
    }

    public static void addNewItem(String name, int id, double price, ArrayList<Product> products) {
            Product product = new Product(name, id, price);
            products.add(product);
    }


    public static Product editItem(int id, ArrayList<Product> products) {
        System.out.println("Input id of the product: ");
        boolean isExist = false;
        Product productEdit = new Product();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                productEdit = products.get(i);
                isExist = true;
                break;
            } else {
                isExist = false;
            }
        }
        if (isExist) {
            System.out.println("Change options ");
            System.out.println("1) Change name");
            System.out.println("2) Change price");
            int choice =input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("New name: ");
                    String newName = input.next();
                    productEdit.setName(newName);
                    break;
                case 2:
                    System.out.println("New price: ");
                    int newPrice = input.nextInt();
                    productEdit.setPrice(newPrice);
                    break;
                default:
                    System.out.println("Err input");
            }
        }
        return productEdit;
    }

    public static void deleteItem(int id, ArrayList<Product> products) {
        boolean isIdDelete = false;
        Product productDelete = new Product();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                isIdDelete = true;
                productDelete = products.get(i);
                break;
            } else {
                isIdDelete = false;
            }
        }
        if(isIdDelete) {
            products.remove(productDelete);
        } else {
            System.out.println("Wrong Id.");
        }
    }

    public static Product searchNameItem(String name, ArrayList<Product> products) {
        Product productSearch = new Product();
        boolean isName = false;
        int size = products.size();
        for (int i = 0; i < size; i++) {
            if (name.equals(products.get(i).getName())) {
                productSearch = products.get(i);
                isName = true;
                break;
            } else {
                isName = false;
            }
        }
        if (isName) {
            System.out.println(productSearch);
        } else {
            System.out.println("Nothing.");
        }
        return productSearch;
    }
}