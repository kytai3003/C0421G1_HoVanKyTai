package codegym.model.service;

import codegym.model.bean.Product;
import codegym.model.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    IProductRepo productRepo;

    @Override
    public List<Product> findAll() {
        return this.productRepo.findAll();
    }

    @Override
    public void save(Product product) {
        this.productRepo.save(product);
    }

    @Override
    public Product findById(int id) {
        return this.productRepo.findById(id);
    }

    @Override
    public void update(Product product) {
        this.productRepo.update(product);
    }

    @Override
    public void remove(int id) {
        this.productRepo.remove(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return this.productRepo.searchByName(name);
    }
}
