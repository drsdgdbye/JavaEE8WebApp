package controllers;

import entities.Product;
import services.ProductService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ShopController implements Serializable {
    private static final long serialVersionUID = 6500398559644099323L;

    @Inject
    private ProductService productService;

    public String showShopPage() {
        return "/shop.xhtml?faces-redirect=true";
    }

    public List<Product> showProducts() {
        return productService.getProducts();
    }

    public void removeProduct(Product product) {
        productService.deleteProduct(product);
    }

}
