/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marksapp.model;

/**
 *
 * @author ACER
 */
public class UserData {
//    private attribute 
//    public methods
    public String id;
    private String name;
    private String email;
    private String password;
    
//    public constructor
    public UserData (String name,String email,String password){
        this.name=name;
        this.email=email;
        this.password=password;
    } 
    
     public UserData ( String id,String name,String email,String password){
        this.id=id;
        this.name=name;
        this.email=email;
        this.password=password;
     }
//    setters=set the value in a attribute
     public void setId(String id){
         this.id=id;
     }
    public void setName(String name){
        this.name=name;
    }
    public void setEmaill(String email){
        this.email=email;
        
    }
    public void setPassword(String password){
        this.password=password;
        
        
    }
//  getter =retrive the value
    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this. email;
        
    }
    public String getPassword(){
        return this.password;
    }
}
