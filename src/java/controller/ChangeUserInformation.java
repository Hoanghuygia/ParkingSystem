/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import daos.UserInforDAO;
import dtos.UserInforDTO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author LAPTOP
 */
public class ChangeUserInformation extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        UserInforDTO user = (UserInforDTO) session.getAttribute("User");
            
        UserInforDAO userInforDAO = new UserInforDAO();
        
        updateUserInformation(req, user, userInforDAO);
    }
    
    public void updateUserInformation(HttpServletRequest req, UserInforDTO user, UserInforDAO userInforDAO) {
        updateUserField(req, user, userInforDAO, "firstname");
        updateUserField(req, user, userInforDAO, "lastname");
        updateUserField(req, user, userInforDAO, "chargedcoin");
        updateUserField(req, user, userInforDAO, "creditcard");
        updateUserField(req, user, userInforDAO, "phonenumber");
//        updateUserField(req, user, userInforDAO, "vehiclenumber");
    }
    
    public void updateUserField(HttpServletRequest req, UserInforDTO user, UserInforDAO userInforDAO, String fieldName) {
        String parameterValue = req.getParameter(fieldName);
        if (parameterValue != null) {
            userInforDAO.changeUserInformation(parameterValue, user.getUsername(), fieldName);
        }
    }
    
    

}
