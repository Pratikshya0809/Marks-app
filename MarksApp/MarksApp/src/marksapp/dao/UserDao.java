/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marksapp.dao;
import marksapp.model.UserData;
import java.sql.*;
import marksapp.database.MySqlConnection;
import marksapp.model.ResetPasswordRequest;
import marksapp.model.loginRequest;

/**
 *
 * @author ACER
 */
public class UserDao {
    MySqlConnection mysql =new MySqlConnection();
    public boolean register(UserData user){
        String query ="INSERT INTO User (name,email,fpassword) VALUES(?,?,?)";
        Connection conn =mysql.openConnection();
        try{
            PreparedStatement  stmt =conn.prepareStatement(query);
            stmt.setString(1,user.getName());
            stmt .setString(2,user.getEmail());
            stmt.setString(3,user.getPassword());
            int result =stmt.executeUpdate();
            return result>0;
            
            
            
        }catch(Exception e){
            return false;
            
        }finally {
            mysql.closeConnection(conn);
        }
                
     
        
    }
    
    public UserData Login(loginRequest loginReq){
      
//        step1:write query
        String query ="SELECT * FROM User WHERE email=? and fpassword=?";
//        step2: open connection
        Connection conn =mysql.openConnection();
        try{
            
            PreparedStatement stmt =conn.prepareStatement(query);
//            stmt.setString(1,loginReq.getEmail());
//            stmt.setString(2,loginReq.getPassword());
//            always use execute query for select query
//it returns rows so use Resultset
            ResultSet result=stmt.executeQuery();
            if (result.next()){
//                the string inside getstring Should match the name of column in databse
                String id=result.getString("id");
                String name=result.getString("fname");
                String email=result.getString("email");
                String password=result.getString("fpassword");
                UserData user =new UserData( id,name,email,password);
                return user;
                
            }else{
                return null;
            }
        }catch(Exception e){
            return null;
            
            
        }finally{
            mysql.closeConnection(conn);
        }
    }
    public boolean checkeEmail(String email){
        String query="SELECT * FROM users WHERE email=?";
        Connection conn =mysql.openConnection();
        try{
            PreparedStatement  stmt =conn.prepareStatement(query);
            stmt.setString(1,email);
            ResultSet result =stmt.executeQuery();
            if (result.next()){
                return true;
                
            }else{
                return false;
            }
            
            
        }catch(Exception e){
            return false;
        }finally{
            mysql.closeConnection(conn);
        }
    }
    public boolean resetpassword(ResetPasswordRequest reset){
        String query="UPDATE SET fpassword=? WHERE email=?";
        Connection conn =mysql.openConnection();
        try{
            PreparedStatement stmnt =conn.prepareStatement(query);
            stmnt.setString(1,reset.getPassword());
            stmnt.setString(2,reset.getEmail());
            int result=stmnt.executeUpdate();
            return result>0;
            
            
            
        }catch(Exception e){
            return false;
            
        }finally {
            mysql.closeConnection(conn);
        }
        
    }

   
    
    
    
    
}
