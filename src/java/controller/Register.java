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
public class Register extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        
        try{
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            
            AccountsDAO account = new AccountsDAO();
            if(!account.checkUsernameExist(username)){
                UserDTO addUser = new UserDTO(username, password);
                session.setAttribute("addUser", addUser);
                resp.sendRedirect("registerInfor");
            }else{
                session.setAttribute("ExistedUser", "This username is already in use");
                resp.sendRedirect("register");
            }
        } catch(IOException e){
            System.out.println(e);
        }
    }
    


}
