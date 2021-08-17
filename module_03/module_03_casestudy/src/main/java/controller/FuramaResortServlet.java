package controller;

import model.service.common.Validate;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "FuramaResortServlet", urlPatterns = "/furama")
public class FuramaResortServlet extends HttpServlet {

    ICustomerService iCustomerService = new CustomerServiceImpl();
    ICustomerTypeService iCustomerTypeService = new CustomerTypeSerImpl();

    IEmployeeService iEmployeeService = new EmployeeServiceImpl();
    IUserService iUserService = new UserServiceImpl();
    IEmployeePosService iEmployeePosService = new EmployeePosSerImpl();
    IEmployeeEduService iEmployeeEduService = new EmployeeEduSerImpl();
    IEmployeeDivService iEmployeeDivService = new EmployeeDivSerImpl();

    IServiceService iServiceService = new ServiceServiceImpl();
    IServiceTypeService iServiceTypeService = new ServiceTypeServiceImpl();
    IRentTypeService iRentTypeService = new RentTypeServiceImpl();

    IContractService iContractService = new ContractServiceImpl();
    IAttachServiceService iAttachServiceService = new AttachServiceServiceImpl();
//    IContractDetailService iContractDetailService = new ContractDetailServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create-employee":
                    createEmployee(request, response);
                    break;
                case "create-customer":
                    createCustomer(request, response);
                    break;
                case "create-service":
                    createService(request, response);
                    break;
                case "create-contract":
                    createContract(request, response);
                    break;
                case "edit-customer":
                    updateCustomer(request, response);
                    break;
                case "edit-employee":
                    updateEmployee(request, response);
                    break;
                case "edit-service":
                    updateService(request, response);
                    break;
                case "search-customer":
                    searchByCustomerName(request, response);
                    break;
                case "search-employee":
                    searchByEmployeeName(request, response);
                    break;
                case "search-service":
                    searchByServiceName(request, response);
                    break;
                case "search-contract":
                    searchByStarDay(request, response);
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
                case "meeting-info":
                    showMeetingInfo(request, response);
                    break;
                case "culinary":
                    showCulinaryInfo(request, response);
                    break;
                case "spa":
                    showSpaInfo(request, response);
                    break;
                case "create-customer":
                    showCreateCustomerForm(request, response);
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
                case "create-employee":
                    showCreateEmployeeForm(request, response);
                    break;
                case "list-employee":
                    listEmployee(request, response);
                    break;
                case "edit-employee":
                    showEditEmployeeForm(request, response);
                    break;
                case "delete-employee":
                    deleteEmployee(request, response);
                    break;
                case "create-service":
                    showCreateServiceForm(request, response);
                    break;
                case "list-service":
                    listService(request, response);
                    break;
                case "edit-service":
                    showEditServiceForm(request, response);
                    break;
                case "delete-service":
                    deleteService(request, response);
                    break;
                case "create-contract":
                    showCreateContractForm(request, response);
                    break;
                case "list-contract":
                    listContract(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showMeetingInfo (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("index_2.jsp");
        dispatcher.forward(request, response);
    }

    private void showCulinaryInfo (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("index_3.jsp");
        dispatcher.forward(request, response);
    }

    private void showSpaInfo (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("index_4.jsp");
        dispatcher.forward(request, response);
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

    private void listService(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Service> serviceList = iServiceService.selectAllService();
        request.setAttribute("serviceList", serviceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/list.jsp");
        dispatcher.forward(request, response);
    }

    private void listContract(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Contract> contractList = iContractService.selectAllContract();
        request.setAttribute("contractList", contractList);
        List<Customer> customerList = iCustomerService.selectAllCustomer();
        request.setAttribute("listCustomer", customerList);
        List<Employee> employeeList = iEmployeeService.selectAllEmployee();
        request.setAttribute("employeeList", employeeList);
        List<Service> serviceList = iServiceService.selectAllService();
        request.setAttribute("serviceList", serviceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/list.jsp");
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
        List<User> userList = iUserService.selectAllUser();
        request.setAttribute("userList", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateServiceForm (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RentType> rentTypes = iRentTypeService.selectAllType();
        request.setAttribute("rentTypes", rentTypes);
        List<ServiceType> serviceTypes = iServiceTypeService.selectAllType();
        request.setAttribute("serviceTypes", serviceTypes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateContractForm (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = iCustomerService.selectAllCustomer();
        request.setAttribute("customerList", customerList);
        List<Employee> employeeList = iEmployeeService.selectAllEmployee();
        request.setAttribute("employeeList", employeeList);
        List<Service> serviceList = iServiceService.selectAllService();
        request.setAttribute("serviceList", serviceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/create.jsp");
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
        Map<String, String> mapMess = this.iCustomerService.addNewCustomer(customer);
        if (mapMess.isEmpty()) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
            request.setAttribute("msg", "Created successfully.");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("map", mapMess);
            request.setAttribute("newCustomer", customer);
            showCreateCustomerForm(request, response);
        }

    }

    private void createService(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String code = request.getParameter("code");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int max = Integer.parseInt(request.getParameter("max"));
        String standard = request.getParameter("standard");
        String description = request.getParameter("description");
        double pool = Double.parseDouble(request.getParameter("pool"));
        int floor = Integer.parseInt(request.getParameter("floor"));
        int rentType = Integer.parseInt(request.getParameter("rentType"));
        int serviceType = Integer.parseInt(request.getParameter("serviceType"));
        Service service = new Service(code, name, area, cost, max, rentType, serviceType, standard, description, pool, floor);
        this.iServiceService.addNewService(service);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/create.jsp");
        request.setAttribute("msg", "Created successfully.");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createContract(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        double deposit = Double.parseDouble(request.getParameter("deposit"));
        double total = Double.parseDouble(request.getParameter("total"));
        int employee = Integer.parseInt(request.getParameter("employee"));
        int customer = Integer.parseInt(request.getParameter("customer"));
        int service = Integer.parseInt(request.getParameter("service"));
        Contract contract = new Contract(start, end, deposit, total, employee, customer, service);
        this.iContractService.addNewContract(contract);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/create.jsp");
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
        Map<String, String> mapMess = iCustomerService.updateCustomer(customer);
        if (mapMess.isEmpty()) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
            request.setAttribute("msg", "Edited successfully.");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("map", mapMess);
            request.setAttribute("editCustomer", customer);
            showEditCustomerForm(request, response);
        }
    }

    private void showEditEmployeeForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = iEmployeeService.selectEmployee(id);
        List<EmployeePosition> employeePositions = iEmployeePosService.selectAllPosition();
        request.setAttribute("positionList", employeePositions);
        List<EmployeeEducation> employeeEducations = iEmployeeEduService.selectAllEducation();
        request.setAttribute("educationList", employeeEducations);
        List<EmployeeDivision> employeeDivisions = iEmployeeDivService.selectAllDivision();
        request.setAttribute("divisionList", employeeDivisions);
        List<User> userList = iUserService.selectAllUser();
        request.setAttribute("userList", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/edit.jsp");
        request.setAttribute("employee", employee);
        dispatcher.forward(request, response);
    }

    private void showEditServiceForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Service service = iServiceService.selectService(id);
        List<RentType> rentTypes = iRentTypeService.selectAllType();
        request.setAttribute("rentTypes", rentTypes);
        List<ServiceType> serviceTypes = iServiceTypeService.selectAllType();
        request.setAttribute("serviceTypes", serviceTypes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/edit.jsp");
        request.setAttribute("service", service);
        dispatcher.forward(request, response);
    }

    private void updateService(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int max = Integer.parseInt(request.getParameter("max"));
        int rentType = Integer.parseInt(request.getParameter("rentType"));
        int serviceType = Integer.parseInt(request.getParameter("service"));
        String standard = request.getParameter("standard");
        String description = request.getParameter("description");
        double pool = Double.parseDouble(request.getParameter("pool"));
        int floor = Integer.parseInt(request.getParameter("floor"));

        Service service = new Service(id,code, name, area, cost, max, rentType, serviceType, standard, description, pool, floor);
        iServiceService.updateService(service);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/edit.jsp");
        request.setAttribute("msg", "Edited successfully.");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
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

        Employee employee = new Employee(id, name, dob, card, salary, phone, email, address, position, education, division, username);
        iEmployeeService.updateEmployee(employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/edit.jsp");
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

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        iEmployeeService.deleteEmployee(id);
        request.setAttribute("msg", "Employee id = " + id + " have been deleted!");
        listEmployee(request, response);
    }

    private void deleteService(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        iServiceService.deleteService(id);
        request.setAttribute("msg", "Service id = " + id + " have been deleted!");
        listService(request, response);
    }

    private void searchByCustomerName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String customerName = request.getParameter("customerName");
        String customerAddress = request.getParameter("customerAddress");
        System.out.println(customerName);
        List<Customer> customerList = new ArrayList<>();
        customerList.addAll(iCustomerService.searchByName(customerName, customerAddress));
        RequestDispatcher dispatcher = null;
        if (customerList.isEmpty()) {
            request.setAttribute("listCustomer", customerList);
            dispatcher = request.getRequestDispatcher("customer/search.jsp");
            request.setAttribute("msg", "Empty!");
        } else {
            request.setAttribute("listCustomer", customerList);
            dispatcher = request.getRequestDispatcher("customer/search.jsp");
            request.setAttribute("msg", customerList.size() + " record(s)");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchByEmployeeName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employeeName = request.getParameter("employeeName");
        System.out.println(employeeName);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.addAll(iEmployeeService.searchByName(employeeName));
        RequestDispatcher dispatcher = null;
        if (employeeList.isEmpty()) {
            request.setAttribute("employeeList", employeeList);
            dispatcher = request.getRequestDispatcher("employee/search.jsp");
            request.setAttribute("msg", "Empty!");
        } else {
            request.setAttribute("employeeList", employeeList);
            dispatcher = request.getRequestDispatcher("employee/search.jsp");
            request.setAttribute("msg", employeeList.size() + " record(s)");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchByServiceName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String serviceName = request.getParameter("serviceName");
        System.out.println(serviceName);
        List<Service> serviceList = new ArrayList<>();
        serviceList.addAll(iServiceService.searchByName(serviceName));
        RequestDispatcher dispatcher = null;
        if (serviceList.isEmpty()) {
            request.setAttribute("serviceList", serviceList);
            dispatcher = request.getRequestDispatcher("service/search.jsp");
            request.setAttribute("msg", "Empty!");
        } else {
            request.setAttribute("serviceList", serviceList);
            dispatcher = request.getRequestDispatcher("service/search.jsp");
            request.setAttribute("msg", serviceList.size() + " record(s)");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchByStarDay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String start = request.getParameter("start");
        System.out.println(start);
        List<Contract> contractList = new ArrayList<>();
        contractList.addAll(iContractService.searchByStartDay(start));
        RequestDispatcher dispatcher = null;
        if (contractList.isEmpty()) {
            request.setAttribute("contractList", contractList);
            dispatcher = request.getRequestDispatcher("contract/search.jsp");
            request.setAttribute("msg", "Empty!");
        } else {
            request.setAttribute("contractList", contractList);
            dispatcher = request.getRequestDispatcher("contract/search.jsp");
            request.setAttribute("msg", contractList.size() + " record(s)");
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
