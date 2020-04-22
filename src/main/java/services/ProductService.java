package services;

import entities.Product;

import javax.ejb.Remote;
import java.io.Serializable;
import java.util.List;

@Remote
public interface ProductService extends Serializable {
    List<Product> getProducts();

    Product getProductById(Long id);

    void deleteProduct(Product product);

    void saveOrUpdateProduct(Product product);
}
