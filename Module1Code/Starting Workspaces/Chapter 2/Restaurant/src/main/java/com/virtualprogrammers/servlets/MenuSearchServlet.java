package com.virtualprogrammers.servlets;


import com.virtualpairprogrammers.data.MenuDataService;
import com.virtualpairprogrammers.domain.MenuItem;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MenuSearchServlet extends HttpServlet {

    public void service (HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String searchTerm = request.getParameter("searchTerm");

        MenuDataService menuDataService = new MenuDataService();
        List<MenuItem> menuItems = menuDataService.find(searchTerm);

        if(menuItems.size() > 0) {
            out.println("<html><body><h1>Ricky�s Restaurant</h1>");
            out.println("<h2>Dishes containing " + searchTerm + "</h2><ul>");
            for(MenuItem menuItem : menuItems) {
                out.println("<li>" + menuItem + " " + menuItem.getDescription() + "</li>");
            }
            out.println("</ul></html></body>");
        }
        else {
            out.println("<html><body><h1>Ricky�s Restaurant</h1>");
            out.println("<p>I�m sorry, there are no dishes containing " + searchTerm);
            out.println("</html></body>");
        }
        out.close();
    }

}

