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
    
//    public void changeUserInformation(String parameterValue, String username, String fieldName){
//        String query = "UPDATE Users SET ? = ? WHERE username= ?";
//        
//        try{
//            conn = DBConnector.getConnection();
//            stm = conn.prepareStatement(query);
//            System.out.println("Field name: " + fieldName);
//            System.out.println("Parameter value: " + parameterValue);
//            switch (fieldName){
//                case "firstname":
//                    stm.setString(1, "first_name");
//                    break;
//                case "lastname":
//                    stm.setString(1,"last_name");
//                    break;
//                case "chargedcoin":
//                    stm.setString(1,"coin");
//                    break;
//                case "creditcard":
//                    stm.setString(1,"credit_number");
//                    break;
//                case "phonenumber":
//                    stm.setString(1,"phone_number");
//                    break;
//                case "vehiclenumber":
//                    stm.setString(1,"vehicle_number");
//                    break;
//            }
//            
//            stm.setString(2, parameterValue);
//            stm.setString(3, username);
//            
//            stm.executeUpdate();
//        }catch(SQLException e){
//            System.out.println(e);
//        }
//    }
    public void changeUserInformation(String parameterValue, String username, String fieldName){
        String query = "UPDATE Users SET " + getColumnName(fieldName) + " = ? WHERE username = ?";
    
        try {
            conn = DBConnector.getConnection();
            stm = conn.prepareStatement(query);

            stm.setString(1, parameterValue);
            stm.setString(2, username);

            stm.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e);
        }
}

// Helper method to get the corresponding column name for the given field name
private String getColumnName(String fieldName) {
    switch (fieldName) {
        case "firstname":
            return "first_name";
        case "lastname":
            return "last_name";
        case "chargedcoin":
            return "coin";
        case "creditcard":
            return "credit_number";
        case "phonenumber":
            return "phone_number";
        case "vehiclenumber":
            return "vehicle_number";
        default:
            throw new IllegalArgumentException("Invalid field name: " + fieldName);
    }
}

    public UserInforDTO getUserInforFromUsername(String username){
        String query = "SELECT * FROM Users WHERE username= ?";
        UserInforDTO userInfor = null;
        
        try{
            conn = DBConnector.getConnection();
            stm = conn.prepareStatement(query);
            stm.setString(1, username);
            
            rs = stm.executeQuery();
            
            if(rs.next()){
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String creditNumber = rs.getString("credit_number");
                String phoneNumber = rs.getString("phone_number");
                int coin = rs.getInt("coin");
                int vehicleNumber = rs.getInt("vehicle_number");
                
                userInfor = new UserInforDTO(username, firstName, lastName, creditNumber, phoneNumber, coin, vehicleNumber);
            }

        } catch(SQLException e){
            System.out.println(e);
        }
        return userInfor;
    }
    public void writeUserInforToDatabase(UserInforDTO userInfor){
        String query = "INSERT INTO Users (username, first_name, last_name, credit_number, phone_number, coin, vehicle_number) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try{
            conn = DBConnector.getConnection();
            
            stm = conn.prepareStatement(query);
            stm.setString(1, userInfor.getUsername());
            stm.setString(2, userInfor.getFirstName());
            stm.setString(3, userInfor.getLastName());
            stm.setString(4, userInfor.getCreditNumber());
            stm.setString(5, userInfor.getPhoneNumber());
            stm.setInt(6, 0);
            stm.setInt(7, 0);
            
            stm.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
                
    }
}
