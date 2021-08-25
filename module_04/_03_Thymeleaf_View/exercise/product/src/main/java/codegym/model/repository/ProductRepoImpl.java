package codegym.model.repository;

import codegym.model.bean.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepoImpl implements IProductRepo{
    private static int autoIncreaseId = 0;
    private static final List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(++autoIncreaseId, "Shoe", 500, "Best quality", "Adidas"));
        productList.add(new Product(++autoIncreaseId, "T-shirt", 800, "Standard", "Dolce"));
        productList.add(new Product(++autoIncreaseId, "NVX", 20000, "Best racing boy", "Yamaha"));
        productList.add(new Product(++autoIncreaseId, "Cub", 1500, "Second hand", "Honda"));
        productList.add(new Product(++autoIncreaseId, "Iphone 13", 5000, "Newest model", "Apple"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product p: productList) {
            if (id == p.getProductId())
                return p;
        }
        return null;
    }

    @Override
    public void update(Product product) {
        for (Product p: productList) {
            if (product.getProductId() == p.getProductId()) {
                p.setProductName(product.getProductName());
                p.setProductPrice(product.getProductPrice());
                p.setDescription(product.getDescription());
                p.setProductBrand(product.getProductBrand());
                break;
            }
        }
    }

    @Override
    public void remove(int id) {
        for (Product p: productList) {
            if (id == p.getProductId()) {
                productList.remove(p);
                break;
            }
        }
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> products = new ArrayList<>();

        for (Product p: productList) {
            if (name.equals(p.getProductName())) {
                products.add(p);
            }
        }
        return products;
    }
}
