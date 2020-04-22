package services;

import entities.Product;
import repositories.ProductRepository;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.util.List;

@Named
@SessionScoped
public class ProductServiceImpl implements ProductService {

    @EJB
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
