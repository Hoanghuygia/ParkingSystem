/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import daos.ParkingDAO;
import dtos.ParkingDTO;
import dtos.UserInforDTO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author LAPTOP
 */
public class TakeTransportation extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        UserInforDTO user = (UserInforDTO)session.getAttribute("User");
        String code = req.getParameter("code");
        String typeTransporation = req.getParameter("typeTransporation");
        System.out.println("Kind: " + typeTransporation);
        
        ParkingDAO parkingDAO = new ParkingDAO();
        parkingDAO.insertEndTime(code);
        parkingDAO.calculateTotalTime(code);
//        parkingDAO.removeSpotOutOfDatabase(code);
        parkingDAO.calculateCost(code, typeTransporation );
        
        if (user != null) {

            ArrayList<ParkingDTO> parking = parkingDAO.getAllSpotFromParking(user.getUsername());
            
            if (parking != null) {
                req.setAttribute("Parking", parking);
            }
        }

        req.getRequestDispatcher("home.jsp").forward(req, resp);
        
        
        
        
    }

}
