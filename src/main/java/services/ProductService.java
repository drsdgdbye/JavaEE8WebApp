package services;

import entities.Product;

import javax.ejb.Local;
import java.io.Serializable;
import java.util.List;

@Local
public interface ProductService extends Serializable {
    List<Product> getProducts();

    Product getProductById(Long id);

    void deleteProduct(Product product);

    void saveOrUpdateProduct(Product product);
}
