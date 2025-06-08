/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marksapp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import marksapp.dao.UserDao;
import marksapp.model.UserData;
import marksapp.view.RegisterView;

/**
 *
 * @author ACER
 */
public class RegisterController {
    private RegisterView view =new RegisterView();
    public RegisterController (RegisterView view){
        this.view=view;
        
    }
    public void open(){
        this.view.setVisible(true);
        
    }
    public void close(){
        this.view.dispose();
        
    }
    class RegisterUser implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           String name=view.getNameTextField().getText();
           String email=view .getEmailTextField().getText();
           String password =String.valueOf(view.getPasswordTextField().getText());
           String confirmPassword =String.valueOf(view.getConfirmPasswordTextField().getText());
           if(name.isEmpty()||email.isEmpty()||password.isEmpty()||confirmPassword.isEmpty()){
               JOptionPane.showMessageDialog(view,"Fill in all the fields");
               
           }else if(!password.equals(confirmPassword)){
               JOptionPane.showMessageDialog(view,"Passwords do not match");
               
           }else{
//               if validate
                 UserData user =new UserData(name,email,password);
                 UserDao userDao=new UserDao();
                 boolean result =userDao.register(user);

           
           
           
           
           if (result){
               JOptionPane.showMessageDialog(view,"Register successfully");
           }else{
               JOptionPane.showMessageDialog(view,"Register failed");
           }
        }
        }  
    }
    
}
