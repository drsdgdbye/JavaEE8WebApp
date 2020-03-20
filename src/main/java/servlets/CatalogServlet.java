package servlets;

import servlets.basics.BasicServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "Catalog", urlPatterns = "/catalog/*")
public class CatalogServlet extends BasicServlet {
}
