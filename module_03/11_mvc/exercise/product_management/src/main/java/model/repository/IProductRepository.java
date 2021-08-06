package model.repository;

import model.bean.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void save(Product product);

    List<Product> findByName(String name);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);
}
