package utils;

import entities.Product;
import lombok.Data;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Data
@Named
@SessionScoped
public class Cart implements Serializable {
    private static final long serialVersionUID = 2955392683099130625L;
    private Map<Long, Product> items = new HashMap<>();

    public ArrayList<Product> getItems() {
        return new ArrayList<Product>(items.values());
    }

    public void addProduct(Product product) {
        items.put(product.getId(), product);
    }

    public void deleteProduct(Product product) {
        if (items.size() > 0) {
            items.remove(product.getId());
        }
    }
}
