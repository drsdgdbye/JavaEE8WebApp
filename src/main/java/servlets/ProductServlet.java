package servlets;

import servlets.basics.BasicServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "Product", urlPatterns = "/product/*")
public class ProductServlet extends BasicServlet {
}
