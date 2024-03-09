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
public class RegisterInfor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registerInfor.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        
        //GET INFORMATION FROM FROM
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String creditCard = req.getParameter("creditCard");
        String phoneNumber = req.getParameter("phoneNumber");
        
        UserDTO user = (UserDTO) session.getAttribute("addUser");
        try{
            AccountsDAO account = new AccountsDAO();
            account.writeAccountToDatabase(user);
        }catch(Exception e){
            System.out.println(e);
        } finally{
            resp.sendRedirect("login");
        }
        

    }
    


}
