package model.service.impl;

import model.bean.Customer;
import model.repository.ICustomerRepository;
import model.repository.impl.CustomerRepositoryImpl;
import model.service.ICustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements ICustomerService {

    ICustomerRepository iCustomerRepository = new CustomerRepositoryImpl();

    @Override
    public void addNewCustomer(Customer customer) throws SQLException {
        this.iCustomerRepository.addNewCustomer(customer);
    }

    @Override
    public Customer selectCustomer(int id) {
        return this.iCustomerRepository.selectCustomer(id);
    }

    @Override
    public List<Customer> selectAllCustomer() {
        return this.iCustomerRepository.selectAllCustomer();
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        return this.iCustomerRepository.deleteCustomer(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        return this.iCustomerRepository.updateCustomer(customer);
    }
}
