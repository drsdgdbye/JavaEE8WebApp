package services;

import entities.Product;
import repositories.ProductRepository;
import rest.ProductServiceRs;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.List;

@Stateless
@WebService(endpointInterface = "services.ProductServiceWs", serviceName = "ProductService")
public class ProductServiceImpl implements ProductService, ProductServiceWs, ProductServiceRs {

    @EJB
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product.getId());
    }

    @Override
    public void saveOrUpdateProduct(Product product) {
        if (product.getId() == null) {
            productRepository.insert(product);
        } else {
            productRepository.update(product);
        }
    }

    @Override
    public Product getProductByTitleWs(String title) {
        return productRepository.findByTitle(title);
    }

    @Override
    public List<Product> findByCategoryWs(Long id) {
        return productRepository.findByCategory(id);
    }

    @Override
    public List<Product> getProductsWs() {
        return getProducts();
    }

    @Override
    public Product getProductByIdWs(Long id) {
        return getProductById(id);
    }

    @Override
    public void saveOrUpdateProductWs(Product product) {
        saveOrUpdateProduct(product);
    }

    @Override
    public void deleteProductWs(Product product) {
        deleteProduct(product);
    }

    @Override
    public List<Product> getProductsRs() {
        return getProducts();
    }

    @Override
    public Product getProductByIdRs(Long id) {
        return getProductById(id);
    }

    @Override
    public void saveOrUpdateProductRs(Product product) {
        saveOrUpdateProduct(product);
    }

    @Override
    public void deleteProductRs(Product product) {
        deleteProduct(product);
    }

    @Override
    public Product getProductByTitleRs(String title) {
        return getProductByTitleWs(title);
    }

    @Override
    public List<Product> findByCategoryRs(Long id) {
        return findByCategoryWs(id);
    }
}
