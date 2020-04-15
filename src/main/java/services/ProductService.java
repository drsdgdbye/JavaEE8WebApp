package services;

import entities.Product;
import repositories.ProductRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ProductService implements Serializable {
    private static final long serialVersionUID = 4480787256621840743L;

    @Inject
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product.getId());
    }

    public void saveOrUpdateProduct(Product product) {
        if (product.getId() == null) {
            productRepository.insert(product);
        } else {
            productRepository.update(product);
        }
    }
}
