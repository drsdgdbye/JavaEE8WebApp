package servlets;

import servlets.basics.BasicServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "About", urlPatterns = "/about/*")
public class AboutServlet extends BasicServlet {
}
