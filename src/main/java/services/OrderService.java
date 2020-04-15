package services;

import entities.Product;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Named
@SessionScoped
public class OrderService implements Serializable {
    private static final long serialVersionUID = -3399646432133294555L;
    Map<Product, Integer> orderMap;
    private Float totalPrice;

    public void saveItems(Map<Product, Integer> orderMap) {
        this.orderMap = orderMap;
    }

    public List<Map.Entry<Product, Integer>> getOrderList() {
        return new ArrayList<>(orderMap.entrySet());
    }

    public Float calculateTotalPrice() {
        for (Map.Entry<Product, Integer> entry : orderMap.entrySet()) {
            totalPrice += entry.getKey().getPrice() * entry.getValue();
        }
        return totalPrice;
    }
}
