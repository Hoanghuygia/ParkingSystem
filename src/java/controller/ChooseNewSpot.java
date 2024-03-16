/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import daos.ParkingDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utils.RandomChooseParkingSpot;

/**
 *
 * @author LAPTOP
 */
public class ChooseNewSpot extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        
        setParkingSpot((String)session.getAttribute("Marker"), session);
//        session.setAttribute("ParkingSpot", RandomChooseParkingSpot.chooseRandomParkingSpot((String)session.getAttribute("Marker")));
        resp.sendRedirect("recommend");
    }
    
    public void setParkingSpot(String marker, HttpSession session) {
        String parkingSpot = RandomChooseParkingSpot.chooseRandomParkingSpot("G");
        ParkingDAO parkingDAO = new ParkingDAO();

        while (parkingDAO.checkSpotExist(parkingSpot)) {
            parkingSpot = RandomChooseParkingSpot.chooseRandomParkingSpot("G");
            System.out.println("huy dep trai");
        }
        session.setAttribute("ParkingSpot", parkingSpot);
    }


}
