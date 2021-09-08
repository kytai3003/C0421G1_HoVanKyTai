package com.example.demo.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto, Integer> productMap = new HashMap<>();

    public CartDto() {
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    public void addProduct(ProductDto productDto) {
        if (productMap.containsKey(productDto)) {
            Integer currentValue = productMap.get(productDto);
            productMap.put(productDto, currentValue + 1);
        } else {
            productMap.put(productDto, 1);
        }
    }

    public void reduceProduct(ProductDto productDto) {
        Integer currentValue = productMap.get(productDto);
        if(currentValue > 1) {
            productMap.put(productDto, currentValue - 1);
        } else {
            productMap.remove(productDto);
        }
    }

    public void remove(ProductDto productDto) {
        productMap.remove(productDto);
    }

    public Long countTotalPayment(){
        long totalPay = 0;
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            totalPay += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return totalPay;
    }
}
