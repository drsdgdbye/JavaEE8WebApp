package controllers;

import entities.Product;
import services.OrderService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Named
@SessionScoped
public class OrderController implements Serializable {
    private static final long serialVersionUID = -4869151760270067156L;

    @Inject
    private OrderService orderService;

    public String showOrderPage(Map<Product, Integer> items) {
        orderService.saveItems(items);
        return "/order.xhtml?faces-redirect=true";
    }

    public List<Map.Entry<Product, Integer>> showOrderList() {
        return orderService.getOrderList();
    }

    public Float showTotalPrice() {
        return orderService.calculateTotalPrice();
    }
}
