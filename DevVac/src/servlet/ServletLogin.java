package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mapping.Employer;
import mapping.Login;

import java.io.IOException;

public class ServletLogin extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            RequestDispatcher dispat = req.getRequestDispatcher("login.jsp");
            dispat.forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String email=req.getParameter("email");
        String mdp=req.getParameter("mdp");

        try {
            if (Login.checkUser(email,mdp)){
                resp.sendRedirect("allCommande");
            }else {
                resp.sendRedirect("login");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
