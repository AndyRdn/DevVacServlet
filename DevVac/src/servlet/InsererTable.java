package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mapping.Table;

import java.io.IOException;
import java.io.PrintWriter;

public class InsererTable extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            if (req.getParameter("action")!=null ) {
                String action=req.getParameter("action");
                Table tab=new Table(Integer.parseInt(req.getParameter("id")),null);

                if (action.equals("del")) {
                    tab.del();
                    resp.sendRedirect("allTable");
                }else {
                    tab.getById();
                    req.setAttribute("tab",tab);
                    req.setAttribute("content","insertTable.jsp");
                    RequestDispatcher dispat = req.getRequestDispatcher("Template.jsp");
                    dispat.forward(req, resp);
                }
            }else {
                req.setAttribute("content","insertTable.jsp");
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

        try {
            if (req.getParameter("id")!=null) {
                int id=Integer.parseInt(req.getParameter("id"));
                new Table(id,nom).update();
            }else {
                new Table(0,nom).insert();
            }

            resp.sendRedirect("allTable");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
