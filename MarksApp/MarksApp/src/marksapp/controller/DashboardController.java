/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marksapp.controller;

import marksapp.model.UserData;
import marksapp.view.Dashboard;

/**
 *
 * @author ACER
 */
public class DashboardController {
    private Dashboard view;
    private UserData user;
    public DashboardController(Dashboard view , UserData user){
        this.view =view;
        this.user=user;
        String name=user.getName();
        this.view.getWelcomelable().setText("Welcome"+name);
        

}
    public void open(){
        view.setVisible(true);
        
    }
public void close(){
    view.dispose();
    
    
}
        
    
}