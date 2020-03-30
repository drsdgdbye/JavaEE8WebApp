package servlets;

import servlets.basics.BasicServlet;

import javax.servlet.annotation.WebServlet;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Cart", urlPatterns = "/cart/*")
public class CartServlet extends BasicServlet {
    private List<String> cartList;

    {
        cartList = new ArrayList<>();
    }

    public List<String> getCartList() {
        return cartList;
    }

    public void setProductToCart(String product) {
        cartList.add(product);
    }
}
