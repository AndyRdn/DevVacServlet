package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mapping.Table;

import java.io.IOException;

public class ServletTable extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setAttribute("table", Table.getAll());
            RequestDispatcher dispat = req.getRequestDispatcher("Template.jsp");
            req.setAttribute("content","table.jsp");
            dispat.forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
