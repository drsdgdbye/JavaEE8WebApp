package controllers;

import entities.Product;
import lombok.Getter;
import lombok.Setter;
import repositories.ProductRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ShopController implements Serializable {
    private static final long serialVersionUID = 6500398559644099323L;

    @Getter
    @Setter
    private Product product;

    @Inject
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public String createProduct() {
        this.product = new Product();
        return "/product.xhtml?faces-redirect=true";
    }

    public String editProduct(Product product) {
        this.product = product;
        return "/product.xhtml?faces-redirect=true";
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product.getId());
    }

    public String saveProduct() {
        if (this.product.getId() == null) {
            productRepository.insert(product);
        } else {
            productRepository.update(product);
        }
        return "/shop.xhtml?faces-redirect=true";
    }

    public String showShopPage() {
        return "/shop.xhtml?faces-redirect=true";
    }
}
