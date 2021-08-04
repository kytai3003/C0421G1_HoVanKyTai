package model.repository.impl;

import model.bean.Product;
import model.repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProductRepositoryImpl implements IProductRepository {

    static Map<Integer, Product> productMap = new TreeMap<>();

    static {
        productMap.put(111, new Product(111, "IPhone 12 Pro Max",
                30000, "Best seller", "Apple"));
        productMap.put(222, new Product(222, "IPhone 12 Mini",
                18000, "Convenience", "Apple"));
        productMap.put(333, new Product(333, "Apple Watch 6",
                15000, "Modern technology", "Apple"));
        productMap.put(444, new Product(444, "Samsung Galaxy Note",
                23000, "Reality camera", "Samsung"));
        productMap.put(555, new Product(555, "Vsmart Joy 4",
                6000, "Cheap and cheerful", "Vin Group"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findByName(String name) {
        for (Map.Entry<Integer, Product> m: productMap.entrySet()) {
            if (name.equals(m.getValue().getName())) {
                return m.getValue();
            }
        }
        return null;
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }
}
