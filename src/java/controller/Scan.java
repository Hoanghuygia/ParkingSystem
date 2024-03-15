/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import daos.ContractorDAO;
import dtos.UserInforDTO;
import java.io.IOException;
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
public class Scan extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("scan.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        
        UserInforDTO user = (UserInforDTO)session.getAttribute("User");
        ContractorDAO contractorDAO = new ContractorDAO();
        
        String code = req.getParameter("licensePlate");
        String type = req.getParameter("typeMotorecycle");
        
        if(contractorDAO.checkTransportationContracted(user.getUsername(), code)){
            session.setAttribute("ParkingSpot", RandomChooseParkingSpot.chooseRandomParkingSpot("R"));
            resp.sendRedirect("recommend");
        }else{
            session.setAttribute("ParkingSpot", RandomChooseParkingSpot.chooseRandomParkingSpot("G"));
            resp.sendRedirect("recommend");
        }
    }
    
    

}
