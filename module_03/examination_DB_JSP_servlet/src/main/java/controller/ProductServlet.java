package controller;

import model.bean.Catelogy;
import model.bean.Product;
import model.service.ICateService;
import model.service.IProductService;
import model.service.impl.CateServiceImpl;
import model.service.impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ProductServlet", urlPatterns = {"", "/product"})
public class ProductServlet extends HttpServlet {

    IProductService iProductService = new ProductServiceImpl();
    ICateService iCateService = new CateServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create-product":
                try {
                    createProduct(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "edit-product":
                try {
                    updateProduct(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "search-product":
                try {
                    searchByProductName(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create-product":
                    showCreateProductForm(request, response);
                    break;
                case "edit-product":
                    showEditProductForm(request, response);
                    break;
                default:
                    listProduct(request, response);
                    break;
                case "delete-product":
                    try {
                        deleteProduct(request, response);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        }

    private void listProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Product> productList = iProductService.selectAll();
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateProductForm (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Catelogy> catelogyList = iCateService.selectAll();
        request.setAttribute("catelogyList", catelogyList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request, response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int catelogy = Integer.parseInt(request.getParameter("catelogy"));
        Product product = new Product(name, price, amount, color, description, catelogy);
//        Map<String, String> mapMess = this.iCustomerService.addNewCustomer(customer);
//        if (mapMess.isEmpty()) {
//            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
//            request.setAttribute("msg", "Created successfully.");
//            dispatcher.forward(request, response);
//        } else {
//            request.setAttribute("map", mapMess);
//            request.setAttribute("newCustomer", customer);
//            showCreateCustomerForm(request, response);
//        }
        this.iProductService.addNew(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        request.setAttribute("msg", "Created successfully.");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditProductForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = iProductService.selectProduct(id);
        List<Catelogy> catelogyList = iCateService.selectAll();
        request.setAttribute("catelogyList", catelogyList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        request.setAttribute("product", product);
        dispatcher.forward(request, response);
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int catelogy = Integer.parseInt(request.getParameter("catelogy"));

        Product product = new Product(id, name, price, amount, color, description, catelogy);
        iProductService.updateProduct(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        request.setAttribute("msg", "Edited successfully.");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        iProductService.deleteProduct(id);
        request.setAttribute("msg", "Product id = " + id + " have been deleted!");
        listProduct(request, response);
    }

    private void searchByProductName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String name = request.getParameter("productName");
        double price = Double.parseDouble(request.getParameter("productPrice"));
        List<Product> productList = new ArrayList<>();
        productList.addAll(iProductService.searchByName(name, price));
        RequestDispatcher dispatcher = null;
        if (productList.isEmpty()) {
            request.setAttribute("productList", productList);
            dispatcher = request.getRequestDispatcher("search.jsp");
            request.setAttribute("msg", "Empty!");
        } else {
            request.setAttribute("productList", productList);
            dispatcher = request.getRequestDispatcher("search.jsp");
            request.setAttribute("msg", productList.size() + " record(s)");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
