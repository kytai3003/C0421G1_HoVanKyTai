package com.example.demo.dto;

import com.example.demo.model.entity.Product;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.List;

public class TypeProductDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeProductId;
    @NotBlank
    private String typeProductName;
    private List<Product> productList;

    public TypeProductDto() {
    }

    public Integer getTypeProductId() {
        return typeProductId;
    }

    public void setTypeProductId(Integer typeProductId) {
        this.typeProductId = typeProductId;
    }

    public String getTypeProductName() {
        return typeProductName;
    }

    public void setTypeProductName(String typeProductName) {
        this.typeProductName = typeProductName;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
