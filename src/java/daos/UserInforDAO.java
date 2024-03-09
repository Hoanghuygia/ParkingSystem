/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import dtos.UserInforDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBConnector;

/**
 *
 * @author LAPTOP
 */
public class UserInforDAO {
    private Connection conn = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;
    
    public void writeUserInforToDatabase(UserInforDTO userInfor){
        String query = "INSERT INTO Users (username, first_name, last_name, credit_number, phone_number) VALUES (?, ?, ?, ?, ?)";
        
        try{
            conn = DBConnector.getConnection();
            
            stm = conn.prepareStatement(query);
            stm.setString(1, userInfor.getUsername());
            stm.setString(2, userInfor.getFirstName());
            stm.setString(3, userInfor.getLastName());
            stm.setString(4, userInfor.getCreditNumber());
            stm.setString(5, userInfor.getPhoneNumber());
            
            stm.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
                
    }
}
