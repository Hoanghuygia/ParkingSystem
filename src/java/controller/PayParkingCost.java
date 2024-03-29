/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import daos.UserInforDAO;
import dtos.UserInforDTO;
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
public class PayParkingCost extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        
        UserInforDTO user = (UserInforDTO) session.getAttribute("User");
        String costString = (String) session.getAttribute("DepartCost");
        int costInt = Integer.parseInt(costString);
        
        int coin = user.getCoin() - costInt;
        if(coin >= 0){
            UserInforDAO userInforDAO = new UserInforDAO();
            userInforDAO.updateCoin(user.getUsername(), coin);
        }
        else{
            session.setAttribute("NotEnoughCoin", "Not Enough Coin");
            //we need to delete information that just add before
        }
    }

}
