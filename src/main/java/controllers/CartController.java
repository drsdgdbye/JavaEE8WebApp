package controllers;

import entities.Product;
import utils.Cart;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CartController implements Serializable {
    private static final long serialVersionUID = -3840129032309317104L;

    @Inject
    private Cart cart;

    public String showCartPage() {
        return "/cart.xhtml?faces-redirect=true";
    }

    public List<Product> getItems() {
        return cart.getItems();
    }

    public void add(Product product) {
        cart.addProduct(product);
    }

    public void delete(Product product) {
        cart.deleteProduct(product);
    }
}
