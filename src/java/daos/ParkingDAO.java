/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBConnector;

/**
 *
 * @author LAPTOP
 */
public class ParkingDAO {
    private Connection conn = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;
    
    public boolean checkSpotExist(String parkingSpot){
        String query = "SELECT * FROM Parking WHERE spot= ?";
        
        try{
            conn = DBConnector.getConnection();
        
        stm = conn.prepareStatement(query);
        stm.setString(1, parkingSpot);
        
        rs = stm.executeQuery();
        
        if(rs.next()){
            return true;
        }
        } catch(SQLException e){
            System.out.println(e);
        }
        return false;
    }
}
