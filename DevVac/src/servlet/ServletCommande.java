package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mapping.Commande;

import java.io.IOException;

public class ServletCommande extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setAttribute("commande", Commande.getAll());
            RequestDispatcher dispat = req.getRequestDispatcher("Template.jsp");
            req.setAttribute("content","commande.jsp");
            dispat.forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
