package controllers;

import entities.Product;
import services.CartService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Named
@SessionScoped
public class CartController implements Serializable {
    private static final long serialVersionUID = -3840129032309317104L;

    @Inject
    private CartService cartService;

    public String showCartPage() {
        return "/cart.xhtml?faces-redirect=true";
    }

    public List<Map.Entry<Product, Integer>> getItems() {
        return cartService.getItems();
    }

    public void add(Product product) {
        cartService.addProduct(product);
    }

    public void delete(Product product) {
        cartService.deleteProduct(product);
    }
}
