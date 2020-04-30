package services;

import entities.Product;

import javax.ejb.Stateful;
import java.io.Serializable;
import java.util.*;

@Stateful
public class CartService implements Serializable {
    private static final long serialVersionUID = -1982148133505097709L;
    private final Map<Product, Integer> items = new HashMap<>();

    public List<Map.Entry<Product, Integer>> getItems() {
        return new ArrayList<>(items.entrySet());
    }

    public Map<Product, Integer> getItemsMap() {
        return items;
    }

    public void addProduct(Product product) {
        items.merge(product, 1, Integer::sum);
    }

    public void deleteProduct(Product product) {
        if (items.get(product) == 1) {
            items.remove(product);
        } else items.compute(product, (k, v) -> Objects.requireNonNull(v) - 1);
    }
}
