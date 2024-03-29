package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mapping.Commande;
import mapping.Employer;
import mapping.Sakafo;
import mapping.Table;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InsererCommande extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setAttribute("tbl", Table.getAll());
            req.setAttribute("skf", Sakafo.getAll());
            req.setAttribute("emp", Employer.getAll());

            if (req.getParameter("action")!=null ) {
                String action=req.getParameter("action");
                Commande cmd=new Commande(Integer.parseInt(req.getParameter("id")));

                if (action.equals("del")) {
                    cmd.del();
                    resp.sendRedirect("allCommande");
                }else {
                    cmd.getById();
                    req.setAttribute("cmd",cmd);
                    req.setAttribute("content","insertCommande.jsp");
                    RequestDispatcher dispat = req.getRequestDispatcher("Template.jsp");
                    dispat.forward(req, resp);
                }
            }else {
                req.setAttribute("content","insertCommande.jsp");
                RequestDispatcher dispat = req.getRequestDispatcher("Template.jsp");
                dispat.forward(req, resp);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        int emp= Integer.parseInt(req.getParameter("emp"));
        int skf= Integer.parseInt(req.getParameter("skf"));
        int tbl= Integer.parseInt(req.getParameter("tbl"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(req.getParameter("date"), formatter);
        Timestamp date= Timestamp.valueOf(dateTime);

        double montant= Double.parseDouble(req.getParameter("montant"));

        try {
            if (req.getParameter("id")!=null) {
                int id=Integer.parseInt(req.getParameter("id"));
                new Commande(id,skf,emp,tbl,date,montant).update();
            }else {
                new Commande(0,skf,emp,tbl,date,montant).insert();
            }

            resp.sendRedirect("allCommande");
        } catch (Exception e) {
            PrintWriter out=resp.getWriter();
            out.println(e.getMessage());
        }

    }
}
