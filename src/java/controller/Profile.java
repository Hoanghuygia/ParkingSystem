/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import daos.ContractorDAO;
import dtos.ContractorDTO;
import dtos.UserInforDTO;
import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
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
@WebServlet(name = "Profile", urlPatterns = {"/profile"})
public class Profile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);

        UserInforDTO user = (UserInforDTO)session.getAttribute("User");
        
        ContractorDAO contractorDAO = new ContractorDAO();
        
        ArrayList<ContractorDTO> contracts = contractorDAO.getContractFromDatabase(user.getUsername());
        
        if(contracts != null){
            
            req.setAttribute("Contracts", contracts);
        }       
        req.getRequestDispatcher("profile.jsp").forward(req, resp);
    }
}
