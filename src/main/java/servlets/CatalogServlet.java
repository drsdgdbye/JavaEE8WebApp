package servlets;

import servlets.basics.BasicServlet;

import javax.servlet.annotation.WebServlet;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Catalog", urlPatterns = "/catalog/*")
public class CatalogServlet extends BasicServlet {
    private Map<Integer, String> productMap;

    {
        productMap = new HashMap<>();
        for (int i = 1; i <= 9; i++) {
            productMap.put(i, "product-" + i);
        }
    }

    public Map<Integer, String> getProducts() {
        return productMap;
    }
}
