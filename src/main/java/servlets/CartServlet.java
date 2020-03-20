package servlets;

import servlets.basics.BasicServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "Cart", urlPatterns = "/cart/*")
public class CartServlet extends BasicServlet {

}
