package com.example.demo.dto;

import com.example.demo.model.entity.contract.ContractDetail;
import com.example.demo.model.entity.customer.Customer;
import com.example.demo.model.entity.employee.Employee;
import com.example.demo.model.entity.service.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.List;

public class ContractDto implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contractId;
    @NotEmpty(message = "Please fill in.")
    @Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$", message = "Invalid input.")
    private String startDate;
    @NotEmpty(message = "Please fill in.")
    @Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$", message = "Invalid input.")
    private String endDate;
    @Min(value = 1, message = "Positive number input only.")
    private double deposit;
    @Min(value = 1, message = "Positive number input only.")
    private double totalMoney;
    private Employee employee;
    private Customer customer;
    private Service service;
    private List<ContractDetail> contractDetails;

    public ContractDto() {
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;
        String pattern = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";
        if (contractDto.getStartDate().matches(pattern) && contractDto.getEndDate().matches(pattern)) {
            String[] dateStart = contractDto.getStartDate().split("-");
            int dateStartInt = Integer.parseInt(dateStart[2].concat(dateStart[1]).concat(dateStart[0]));
            String[] dateEnd = contractDto.getEndDate().split("-");
            int dateEndInt = Integer.parseInt(dateEnd[2].concat(dateEnd[1]).concat(dateEnd[0]));
            if (dateEndInt <= dateStartInt) {
                errors.rejectValue("endDate", "date.illegal", "End date must be after start date.");
            }
        }
    }
}
