package controller;

import model.bean.*;
import model.service.*;
import model.service.impl.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "FuramaResortServlet", urlPatterns = "/furama")
public class FuramaResortServlet extends HttpServlet {

    ICustomerService iCustomerService = new CustomerServiceImpl();
    ICustomerTypeService iCustomerTypeService = new CustomerTypeSerImpl();
    IEmployeeService iEmployeeService = new EmployeeServiceImpl();
    IEmployeePosService iEmployeePosService = new EmployeePosSerImpl();
    IEmployeeEduService iEmployeeEduService = new EmployeeEduSerImpl();
    IEmployeeDivService iEmployeeDivService = new EmployeeDivSerImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    break;
                case "edit":
                    break;
                case "delete":
                    break;
                case "search":
                    break;
                case "sort":
                    break;
                case "create-employee":
                    createEmployee(request, response);
                    break;
                case "create-customer":
                    createCustomer(request, response);
                    break;
                case "edit-customer":
                    updateCustomer(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    break;
                case "edit":
                    break;
                case "delete":
                    break;
                case "search":
                    break;
                case "sort":
                    break;
                case "create-customer":
                    showCreateCustomerForm(request, response);
                    break;
                case "create-employee":
                    showCreateEmployeeForm(request, response);
                    break;
                case "list-customer":
                    listCustomer(request, response);
                    break;
                case "edit-customer":
                    showEditCustomerForm(request, response);
                    break;
                case "delete-customer":
                    deleteCustomer(request, response);
                    break;
                case "list-employee":
                    listEmployee(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Customer> customerList = iCustomerService.selectAllCustomer();
        request.setAttribute("listCustomer", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Employee> employeeList = iEmployeeService.selectAllEmployee();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateCustomerForm (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomerType> customerTypes = iCustomerTypeService.selectAllType();
        request.setAttribute("typeList", customerTypes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateEmployeeForm (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<EmployeePosition> employeePositions = iEmployeePosService.selectAllPosition();
        request.setAttribute("positionList", employeePositions);
        List<EmployeeEducation> employeeEducations = iEmployeeEduService.selectAllEducation();
        request.setAttribute("educationList", employeeEducations);
        List<EmployeeDivision> employeeDivisions = iEmployeeDivService.selectAllDivision();
        request.setAttribute("divisionList", employeeDivisions);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        dispatcher.forward(request, response);
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String card = request.getParameter("card");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int position = Integer.parseInt(request.getParameter("position"));
        int education = Integer.parseInt(request.getParameter("education"));
        int division = Integer.parseInt(request.getParameter("division"));
        String username = request.getParameter("username");
        Employee employee = new Employee(name, dob, card, salary, phone, email, address, position, education, division, username);
        this.iEmployeeService.addNewEmployee(employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        request.setAttribute("msg", "Created successfully.");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String code = request.getParameter("code");
        int type = Integer.parseInt(request.getParameter("type"));
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String idCard = request.getParameter("card");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(code, type, name, dob, gender, idCard, phone, email, address);
        this.iCustomerService.addNewCustomer(customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        request.setAttribute("msg", "Created successfully.");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditCustomerForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = iCustomerService.selectCustomer(id);
        List<CustomerType> customerTypes = iCustomerTypeService.selectAllType();
        request.setAttribute("typeList", customerTypes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        request.setAttribute("customer", customer);
        dispatcher.forward(request, response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String code = request.getParameter("code");
        int type = Integer.parseInt(request.getParameter("type"));
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String card = request.getParameter("card");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer customer = new Customer(id, code, type, name, dob, gender, card, phone, email, address);
        iCustomerService.updateCustomer(customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        request.setAttribute("msg", "Edited successfully.");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        iCustomerService.deleteCustomer(id);
        request.setAttribute("msg", "Customer id = " + id + " have been deleted!");
        listCustomer(request, response);
    }
}
