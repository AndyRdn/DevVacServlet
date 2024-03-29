package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mapping.Employer;
import mapping.Sakafo;

import java.io.IOException;
import java.io.PrintWriter;

public class InsererEmployerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            if (req.getParameter("action")!=null ) {
                String action=req.getParameter("action");
                Employer emp=new Employer(Integer.parseInt(req.getParameter("id")));

                if (action.equals("del")) {
                    emp.del();
                    resp.sendRedirect("allEmployer");
                }else {
                    emp.getById();
                    req.setAttribute("emp",emp);
                    req.setAttribute("content","insertEmployer.jsp");
                    RequestDispatcher dispat = req.getRequestDispatcher("Template.jsp");
                    dispat.forward(req, resp);
                }
            }else {
                req.setAttribute("content","insertEmployer.jsp");
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
        int age= Integer.parseInt(req.getParameter("age"));

        try {
            if (req.getParameter("id")!=null) {
                int id=Integer.parseInt(req.getParameter("id"));
                new Employer(id,nom,age).update();
            }else {
                new Employer(0,nom,age).insert();
            }

            resp.sendRedirect("allEmployer");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
