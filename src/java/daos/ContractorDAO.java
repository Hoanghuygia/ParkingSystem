/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import dtos.ContractorDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBConnector;

/**
 *
 * @author LAPTOP
 */
public class ContractorDAO {
    private Connection conn = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;
    
    public void writeContractToDatabase(ContractorDTO contract){
        String query = "INSERT INTO ContractTransportation (username, code, transportation_type, day_contract) VALUES (?, ?, ?, NOW())";
        try{
            conn = DBConnector.getConnection();
            
            stm = conn.prepareStatement(query);
            stm.setString(1, contract.getUsername());
            stm.setString(2, contract.getCode());
            stm.setString(3, contract.getTypeTransportation());
            
            stm.executeUpdate();
        } catch(SQLException e){
            System.out.println(e);
        }
    }
    public boolean checkTransportationContracted(String username, String code){
        String query = "SELECT * FROM ContractTransportation WHERE username= ? and code= ?";
        try{
            conn = DBConnector.getConnection();
            
            stm = conn.prepareStatement(query);
            stm.setString(1,username);
            stm.setString(2,code);
            
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
