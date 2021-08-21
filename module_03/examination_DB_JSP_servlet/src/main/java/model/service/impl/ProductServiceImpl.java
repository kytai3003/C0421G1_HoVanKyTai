package model.service.impl;

import model.bean.Product;
import model.repository.IProductRepo;
import model.repository.impl.ProductRepoImpl;
import model.service.IProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements IProductService {
    IProductRepo iProductRepo = new ProductRepoImpl();
    @Override
    public void addNew(Product product) throws SQLException {
        this.iProductRepo.addNew(product);
    }

    @Override
    public Product selectProduct(int id) {
        return this.iProductRepo.selectProduct(id);
    }

    @Override
    public List<Product> selectAll() {
        return this.iProductRepo.selectAll();
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        return this.iProductRepo.deleteProduct(id);
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        return this.iProductRepo.updateProduct(product);
    }

    @Override
    public List<Product> searchByName(String name, double price) throws SQLException {
        return this.iProductRepo.searchByName(name, price);
    }
}
