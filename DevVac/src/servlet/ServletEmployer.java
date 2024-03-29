package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mapping.Employer;
import mapping.Sakafo;

import java.io.IOException;

public class ServletEmployer extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setAttribute("employer", Employer.getAll());
            RequestDispatcher dispat = req.getRequestDispatcher("Template.jsp");
            req.setAttribute("content","employer.jsp");
            dispat.forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
