/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marksapp.model;

/**
 *
 * @author ACER
 */
public class loginRequest {
//    email,password
//    private attributes
    private String email;
    private String password;
//    publuc methods
    public loginRequest (String email,String password){
        this.email=email;
        this.password=password;
        
    }
    public void setEmail(String Email){
        this.email=email;
        
        
    }
    public void setPassword(String Password){
        this.password=password;
        
}
    public String getEmail(String email){
        return email;
    }
    public String getPassword(String password){
        return password;
    }
}
