package servlets;

import servlets.basics.BasicServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "Order", urlPatterns = "/order/*")
public class OrderServlet extends BasicServlet {

}
