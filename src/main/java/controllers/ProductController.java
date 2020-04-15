package controllers;

import entities.Product;
import lombok.Setter;
import services.CategoryService;
import services.ProductService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class ProductController implements Serializable {
    private static final long serialVersionUID = 5154582703258017555L;
    @Setter
    private Product product;
    @Setter
    private String categoryId;

    @Inject
    private ProductService productService;
    @Inject
    private CategoryService categoryService;

    public String createProduct() {
        this.product = new Product();
        return "/product.xhtml?faces-redirect=true";
    }

    public String editProduct(Product product) {
        this.product = product;
        return "/product.xhtml?faces-redirect=true";
    }

    public String saveProduct() {
        product.setCategory(categoryService.getCategoryById(Long.parseLong(categoryId)));
        productService.saveOrUpdateProduct(this.product);
        return "/shop.xhtml?faces-redirect=true";
    }
}
