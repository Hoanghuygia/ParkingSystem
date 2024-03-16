/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import daos.ParkingDAO;
import dtos.ParkingDTO;
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
public class Recommend extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("recommend.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //in this method, we need to visualize like the recommend as well as save information to the database
        HttpSession session = req.getSession(true);
        
        ParkingDTO parkingSlot = (ParkingDTO)session.getAttribute("ParkingSlot");
        String spot = (String)session.getAttribute("ParkingSpot");
        parkingSlot.setSpot(spot);
        
        ParkingDAO parkingDAO = new ParkingDAO();
        parkingDAO.saveParkingSpotToDatabase(parkingSlot);
        System.out.println("tram lakakaka");
    }
    
    
}
