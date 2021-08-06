package model.service.impl;

import model.bean.Product;
import model.repository.IProductRepository;
import model.repository.impl.ProductRepositoryImpl;
import model.service.IProductService;

import java.util.List;


public class ProductServiceImpl implements IProductService {

    private IProductRepository iProductRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll() {
        return this.iProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
        this.iProductRepository.save(product);
    }

    @Override
    public List<Product> findByName(String name) {
        return this.iProductRepository.findByName(name);
    }

    @Override
    public void update(int id, Product product) {
        this.iProductRepository.update(id, product);
    }

    @Override
    public void remove(int id) {
        this.iProductRepository.remove(id);
    }

    @Override
    public Product findById(int id) {
        return this.iProductRepository.findById(id);
    }
}
