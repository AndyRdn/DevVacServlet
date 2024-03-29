package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mapping.Sakafo;

import java.io.IOException;
import java.io.PrintWriter;

public class InsererSakafo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            if (req.getParameter("action")!=null ) {
                String action=req.getParameter("action");
                Sakafo emp=new Sakafo(Integer.parseInt(req.getParameter("id")));

                if (action.equals("del")) {
                    emp.del();
                    resp.sendRedirect("allSakafo");
                }else {
                    emp.getById();
                    req.setAttribute("emp",emp);
                    req.setAttribute("content","insertSakafo.jsp");
                    RequestDispatcher dispat = req.getRequestDispatcher("Template.jsp");
                    dispat.forward(req, resp);
                }
            }else {
                req.setAttribute("content","insertSakafo.jsp");
                RequestDispatcher dispat = req.getRequestDispatcher("Template.jsp");
                dispat.forward(req, resp);
            }

        } catch (Exception e) {
            PrintWriter out=resp.getWriter();
            out.println(e.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String nom=req.getParameter("nom");
        double prix= Double.parseDouble(req.getParameter("prix"));

        try {
            if (req.getParameter("id")!=null) {
                int id=Integer.parseInt(req.getParameter("id"));
                new Sakafo(id,nom,prix).update();
            }else {
                new Sakafo(0,nom,prix).insert();
            }

            resp.sendRedirect("allSakafo");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
