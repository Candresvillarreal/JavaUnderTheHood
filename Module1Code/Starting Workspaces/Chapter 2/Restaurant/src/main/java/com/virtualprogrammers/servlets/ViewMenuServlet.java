package com.virtualprogrammers.servlets;

import com.virtualpairprogrammers.data.MenuDataService;
import com.virtualpairprogrammers.domain.MenuItem;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewMenuServlet extends HttpServlet {

    public void service (HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        MenuDataService menuDataService = new MenuDataService();
        List<MenuItem> menuItems = menuDataService.getFullMenu();

        out.println("<html><body><h1>Ricky�s Restaurant</h1>");
        out.println("<h2>Menu</h2><ul>");
        for(MenuItem menuItem : menuItems) {
            out.println("<li>" + menuItem + "</li>");
        }
        out.println("</ul>");
        out.println("<a href='searchResults.html?searchTerm=chicken' >View all of our chicken dishes</a>");
        out.println("</html></body>");
        out.close();
    }

}
