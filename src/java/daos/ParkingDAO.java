/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import dtos.ContractorDTO;
import dtos.ParkingDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.DBConnector;

/**
 *
 * @author LAPTOP
 */
public class ParkingDAO {

    private Connection conn = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;

    public void calculateCost(String code, String type) {
        String query;
        if (type.equals("motorcycle")) {
            System.out.println("Remove motorcycle");
            query = """
                    UPDATE Parking
                    SET cost = 
                      CASE
                        WHEN interval_time < 43200 AND spot LIKE 'G%' THEN 1
                        WHEN interval_time < 43200 AND spot LIKE 'R%' THEN 1
                        WHEN interval_time >= 43200 AND spot LIKE 'G%' THEN 4
                        WHEN interval_time >= 43200 AND spot LIKE 'R%' THEN 2
                        WHEN interval_time >= 259200 AND spot LIKE 'G%' THEN 10
                        WHEN interval_time >= 259200 AND spot LIKE 'R%' THEN 6
                        ELSE -1
                      END
                    WHERE code = ?;""";
        } else {
            System.out.println("Remove car");
            query = """
                    UPDATE Parking
                    SET cost = 
                      CASE
                        WHEN interval_time < 43200 AND spot LIKE 'G%' THEN 1
                        WHEN interval_time < 43200 AND spot LIKE 'R%' THEN 1
                        WHEN interval_time >= 43200 AND spot LIKE 'G%' THEN 4
                        WHEN interval_time >= 43200 AND spot LIKE 'R%' THEN 2
                        WHEN interval_time >= 259200 AND spot LIKE 'G%' THEN 10
                        WHEN interval_time >= 259200 AND spot LIKE 'R%' THEN 6
                        ELSE -1
                      END
                    WHERE code = ?;""";
        }
        try {
            conn = DBConnector.getConnection();
            stm = conn.prepareStatement(query);
            stm.setString(1, code);
            
            stm.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
        }

    }
    public void removeSpotOutOfDatabase(String code){
        String query = "DELETE FROM Parking WHERE code= ? ";
        
        try{
            conn = DBConnector.getConnection();
            
            stm = conn.prepareStatement(query);
            stm.setString(1, code);
            
            stm.executeUpdate();
            
        } catch(SQLException e){
            System.out.println(e);
        }
    }
    public void calculateTotalTime(String code){
        String query = "UPDATE Parking SET "
                + "interval_time = TIMESTAMPDIFF(SECOND, start_time, end_time)"
                + "WHERE code= ?";
        
        try{
            conn = DBConnector.getConnection();
            
            stm = conn.prepareStatement(query);
            stm.setString(1, code);
            
            stm.executeUpdate();
        } catch(SQLException e){
            System.out.println(e);
        }
    }
    public void insertEndTime(String code){
        String query = "UPDATE Parking SET end_time = NOW() WHERE code= ?";
        
        try{
            conn = DBConnector.getConnection();
            
            stm = conn.prepareStatement(query);
            stm.setString(1, code);
            
            stm.executeUpdate();
        } catch(SQLException e){
            System.out.println(e);
        }
        
    }
    public ArrayList<ParkingDTO> getAllSpotFromParking(String username){
        
        ArrayList<ParkingDTO> parkings = new ArrayList<>();
        
        String query = "SELECT * FROM Parking WHERE username= ?";
        
        try{
            conn = DBConnector.getConnection();
            
            stm = conn.prepareStatement(query);
            stm.setString(1, username); // so funny
            
            rs = stm.executeQuery();
            
            while (rs.next()) {
                String code = rs.getString("code");
                String spot = rs.getString("spot");
                String startTime = rs.getString("start_time");// I wonder something here
                String transportationType = rs.getString("type_transportation");

//                System.out.println("Spot: " + spot);
//                System.out.println("startTime: " + startTime);
//                System.out.println("transportationType: " + transportationType);

                ParkingDTO parking = new ParkingDTO(username, code, spot, startTime, transportationType);

                parkings.add(parking);
            }
            System.out.println("Length: " + parkings.size());
    
        } catch(SQLException e){
            System.out.println(e);
        }
        return parkings;
    }
    public void saveParkingSpotToDatabase(ParkingDTO parkingSpot){
        String query = "INSERT INTO Parking(username, code, spot, start_time, type_transportation) VALUES (?, ?, ?, NOW(), ?)";
        
        try {
            conn = DBConnector.getConnection();

            stm = conn.prepareStatement(query);
            
            stm.setString(1, parkingSpot.getUsername());
            stm.setString(2, parkingSpot.getCode());
            stm.setString(3, parkingSpot.getSpot());
            stm.setString(4, parkingSpot.getTypeTransportation());
            
            stm.executeUpdate();
      
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public boolean checkSpotExist(String parkingSpot) {
        String query = "SELECT * FROM Parking WHERE spot= ?";

        try {
            conn = DBConnector.getConnection();

            stm = conn.prepareStatement(query);
            stm.setString(1, parkingSpot);

            rs = stm.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
}
