/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import daos.AccountsDAO;
import dtos.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author LAPTOP
 */
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        
        
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            
            AccountsDAO account = new AccountsDAO();
            
            if(account.checkAccount(username, password)){
                UserDTO user = new UserDTO(username, password);
//                resp.sendRedirect("login");
//                resp.setContentType("text/heml");
//                PrintWriter printWriter = resp.getWriter();
//                printWriter.println("Verify success11");
//                printWriter.println("username:  " + username);
//                printWriter.println("password:  " + password);
                session.setAttribute("User", user);
                resp.sendRedirect("Main");
            }
            else{
                session.setAttribute("InvalidUser", "Invalid username or password");
                resp.sendRedirect("login");
            }    
    }
}
