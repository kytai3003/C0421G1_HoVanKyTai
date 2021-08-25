package codegym.model.repository;

import codegym.model.bean.Product;

import java.util.List;

public interface IProductRepo {

    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(Product product);

    void remove(int id);

    List<Product> searchByName(String name);
}
