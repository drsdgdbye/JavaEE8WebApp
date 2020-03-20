package servlets.basics;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public abstract class BasicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.printf("<h1>%s page here</h1>", getServletName());
        createMenu(writer, req);
    }

    private void createMenu(PrintWriter writer, HttpServletRequest req) {
        //collect all servlets to hashmap
        Map<String, ? extends ServletRegistration> servletRegistrations = req.getServletContext().getServletRegistrations();

        for (Map.Entry<String, ? extends ServletRegistration> entry : servletRegistrations.entrySet()) {
            //...and print them except default and jsp servlets. create menu links
            if (!entry.getKey().equals("default") && !entry.getKey().equals("jsp")) {
                writer.printf("<a href=\"%s/%s\">%s</a><br>", req.getContextPath(), entry.getKey().toLowerCase(), entry.getKey());
            }
        }
    }
}
