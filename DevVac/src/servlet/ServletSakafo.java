package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mapping.Sakafo;

import java.io.IOException;

public class ServletSakafo extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setAttribute("sakafo", Sakafo.getAll());
            RequestDispatcher dispat = req.getRequestDispatcher("Template.jsp");
            req.setAttribute("content","sakafo.jsp");
            dispat.forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String nom=req.getParameter("nom");
            double prixmax= Double.parseDouble(req.getParameter("prixmax"));
            double prixmin= Double.parseDouble(req.getParameter("prixmin"));
            req.setAttribute("sakafo",new Sakafo().search(nom,prixmin,prixmax));
            req.setAttribute("content","sakafo.jsp");
            RequestDispatcher dispat = req.getRequestDispatcher("Template.jsp");
            dispat.forward(req, resp);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
