package repositories;

import entities.Product;

import javax.ejb.Local;
import java.io.Serializable;
import java.util.List;

@Local
public interface ProductRepository extends Serializable {
    void insert(Product product);

    void update(Product product);

    void delete(Long id);

    Product findById(Long id);

    List<Product> findAll();

    Product findByTitle(String name);

    List<Product> findByCategory(Long id);
}
