/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import daos.ContractorDAO;
import dtos.ContractorDTO;
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
public class AddVehileToDatabase extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        UserInforDTO user = (UserInforDTO)session.getAttribute("User");
        
        String username = user.getUsername();
        String code = req.getParameter("code");
        String typeTransportation = req.getParameter("typeTransportation");
        
        ContractorDTO contract = new ContractorDTO(username, code, typeTransportation);
        
        ContractorDAO contractorDAO = new ContractorDAO();
        if (!contractorDAO.checkCodeExisted(contract.getCode())) {

            contractorDAO.writeContractToDatabase(contract);
            session.removeAttribute("ActiveAddVehicleModal");
        }
        else{
            session.setAttribute("InvalidCode", "Liscence plate had existed" );
            
        }
        
        resp.sendRedirect("profile");
        
        
    }

}
