package daos;

import dtos.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBConnector;

public class AccountsDAO {
    private Connection conn = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;
    
    public void writeAccountToDatabase(UserDTO user){
        String query = "INSERT INTO Accounts (username, password) VALUES (?, ?)";
        
        try{
            conn = DBConnector.getConnection();
            
            stm = conn.prepareStatement(query);
            stm.setString(1, user.getUsername());
            stm.setString(2, user.getPassword());
            
            stm.executeUpdate();
        } catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public boolean checkAccount(String username, String password){ //return true if the account exist in the database
        String query = "SELECT * FROM Accounts WHERE username= ? AND password= ?";
        try{
            conn = DBConnector.getConnection();
            stm = conn.prepareStatement(query);
            stm.setString(1, username);
            stm.setString(2, password);
            
            rs = stm.executeQuery();
            
            if(rs.next()){
                return true;
            }

        } catch(SQLException e){
            System.out.println(e);
        }
        return false;
    }
    public boolean checkUsernameExist(String username){
        String query = "SELECT * FROM Accounts WHERE username= ?";
        try{
            conn = DBConnector.getConnection();
            stm = conn.prepareStatement(query);
            stm.setString(1, username);
            
            rs = stm.executeQuery();
            
            if(rs.next()){
                return true;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return false;
    }
}
