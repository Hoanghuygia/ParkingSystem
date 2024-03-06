package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBConnector;

public class AccountsDAO {
    private Connection conn = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;
    
    public UserDTO checkAccount(String username, String password){
        String query = "SELECT * FROM Accounts WHERE username= ? AND password= ?";
        try{
            conn = DBConnector.getConnection();
            stm = conn.prepareStatement(query);
            stm.setString(1, username);
            stm.setString(2, password);
            
            rs = stm.executeQuery();

        } catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
}
