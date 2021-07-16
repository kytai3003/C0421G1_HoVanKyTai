package module2_practise.controller;

import module2_practise.common.ReadAndWriteCSV;
import module2_practise.services.ProductImpl;

import java.util.Scanner;

public class ProductManagement {
    private static final Scanner sc =  new Scanner(System.in);
    private static final ProductImpl product = new ProductImpl();
    public static void productDisplayMenu() {
        do{
            System.out.println("---------Chương trình quản lý sản phẩm---------");
            System.out.println("Chọn chức năng số để tiếp tục.");
            System.out.println("1) Thêm mới");
            System.out.println("2) Xóa");
            System.out.println("3) Xem danh sách các sản phẩm");
            System.out.println("4) Tìm kiếm");
            System.out.println("5) Thoát");
            System.out.println("Chọn chức năng");
            int choice = 0;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng chỉ nhập số.");
            }
            switch (choice) {
                case 1:
                    product.addNew();
                    break;

                case 2:
                    product.delete();
                    break;

                case 3:
                    product.displayList();
                    break;

                case 4:
                    product.search();
                    break;

                case 5:
                    System.out.println("Thoát chương trình...");
                    System.exit(0);

                default:
                    System.out.println("Vui lòng nhập đúng số của những chức năng trên.");
            }

        } while (true);
    }
}
