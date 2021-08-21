package model.service;

import model.bean.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductService {
    void addNew(Product product) throws SQLException;

    Product selectProduct(int id);

    List<Product> selectAll();

    boolean deleteProduct(int id) throws SQLException;

    boolean updateProduct(Product product) throws SQLException;

    List<Product> searchByName(String name, double price) throws SQLException;
}
