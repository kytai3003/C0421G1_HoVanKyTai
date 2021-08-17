package model.repository;

import model.bean.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerRepository {
    void addNewCustomer(Customer customer) throws SQLException;

    Customer selectCustomer(int id);

    List<Customer> selectAllCustomer();

    boolean deleteCustomer(int id) throws SQLException;

    boolean updateCustomer(Customer customer) throws SQLException;

    List<Customer> searchByName(String name, String address) throws SQLException;
}
