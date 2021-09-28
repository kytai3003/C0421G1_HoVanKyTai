package com.example.demo.dto;


import com.example.demo.model.entity.contract.Contract;
import com.example.demo.model.entity.customer.Customer;
import com.example.demo.model.entity.customer.CustomerType;
import com.example.demo.model.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

public class CustomerDto{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @NotBlank(message = "Please fill in.")
    @Pattern(regexp = "^KH-\\d{4}$", message = "Invalid input.")
    private String customerCode;
    @NotBlank(message = "Please fill in.")
    private String customerName;
    @NotBlank(message = "Please fill in.")
    @Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$", message = "Invalid input.")
    private String customerDayOfBirth;
    @NotNull(message = "Please choose one.")
    private Integer customerGender;
    @Pattern(regexp = "^\\d{9}|\\d{12}$", message = "Invalid ID Card Format.")
    private String customerIdCard;
    @Pattern(regexp = "^090\\d{7}|\\(84\\)\\+90\\d{7}|091\\d{7}|\\(84\\)\\+91\\d{7}$",message = "Invalid phone number format.")
    private String customerPhone;
    @NotBlank(message = "Please fill in.")
    @Email(message = "Invalid email format.")
    private String customerEmail;
    @NotBlank(message = "Please fill in.")
    private String customerAddress;
    private CustomerType customerType;
    private List<Contract> contracts;

    public CustomerDto() {
    }

    public CustomerDto(@NotBlank(message = "Please fill in.") @Pattern(regexp = "^KH-\\d{4}$", message = "Invalid input.") String customerCode, @NotBlank(message = "Please fill in.") String customerName, @NotBlank(message = "Please fill in.") String customerDayOfBirth, @NotNull(message = "Please choose one.") Integer customerGender, @Pattern(regexp = "^\\d{9}|\\d{12}$", message = "Invalid ID Card Format") String customerIdCard, @Pattern(regexp = "^090\\d{7}|\\(84\\)\\+90\\d{7}|091\\d{7}|\\(84\\)\\+91\\d{7}$", message = "Invalid phone number format") String customerPhone, @NotBlank(message = "Please fill in.") @Email(message = "Invalid email format") String customerEmail, @NotBlank(message = "Please fill in.") String customerAddress, CustomerType customerType, List<Contract> contracts) {
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.customerDayOfBirth = customerDayOfBirth;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerType = customerType;
        this.contracts = contracts;
    }

    public CustomerDto(@NotBlank(message = "Please fill in.") @Pattern(regexp = "^KH-\\d{4}$", message = "Invalid input.") String customerCode, @NotBlank(message = "Please fill in.") String customerName, @NotBlank(message = "Please fill in.") String customerDayOfBirth, @NotNull(message = "Please choose one.") Integer customerGender, @Pattern(regexp = "^\\d{9}|\\d{12}$", message = "Invalid ID Card Format") String customerIdCard, @Pattern(regexp = "^090\\d{7}|\\(84\\)\\+90\\d{7}|091\\d{7}|\\(84\\)\\+91\\d{7}$", message = "Invalid phone number format") String customerPhone, @NotBlank(message = "Please fill in.") @Email(message = "Invalid email format") String customerEmail, @NotBlank(message = "Please fill in.") String customerAddress, CustomerType customerType) {
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.customerDayOfBirth = customerDayOfBirth;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerType = customerType;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerDayOfBirth() {
        return customerDayOfBirth;
    }

    public void setCustomerDayOfBirth(String customerDayOfBirth) {
        this.customerDayOfBirth = customerDayOfBirth;
    }

    public Integer getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Integer customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
