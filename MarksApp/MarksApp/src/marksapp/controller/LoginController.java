/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marksapp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import marksapp.dao.UserDao;
import marksapp.model.UserData;
import marksapp.model.loginRequest;
import marksapp.view.Dashboard;
import marksapp.view.LoginView;

/**
 *
 * @author ACER
 */
public class LoginController {
    LoginView view;
    public LoginController(LoginView view){
        this.view=view;
        LoginUser login=new LoginUser();
        this.view.loginUser(login);
//        this.view.loginUser(new LoginUser()));
        
    }
    public void open(){
        view.setVisible(true);
        
    }
    public void close(){
        view.dispose();
    }
    class LoginUser implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           String email=view.getEmailTextField().getText();
           String password=String.valueOf(view.getPasswordField().getPassword());
           if (email.isEmpty()||password.isEmpty()){
               JOptionPane.showMessageDialog(view,"Fill in all the fields" );
               
           }else{
               loginRequest loginData =new loginRequest(email,password);
               UserDao userDao =new UserDao();
               UserData user =userDao.login(loginData);
               if (user ==null){
                   JOptionPane.showMessageDialog(view,"Invalide Credentials");
               } else{
                   Dashboard dashboard =new Dashboard();
                   DashboardController dasboardController=new DashboardController(dashboard ,user);
                   dashboardController.open();
                   close();
                   
                   
                   
               }
               
           }
        }
        
    }
//    create class inside controller for each listener
//    implement controller
   class Resetpassword implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            String email =JOptionPane.showInputDialog(view,"Enter you email");
            if (email.trim().isEmpty()){
                JOptionPane.showMessageDialog(view,"Email is neccessary");
                
                
            }else{
                UserDao userDao=new UserDao();
                boolean emailExists=userDao.checkeEmail(email);
                if(!emailExists){
                JOptionPane.showMessageDialog(view,"Email doesnot exists");
                
            }else{
                    String otp="567231";
                    String subject="Rest Password Verification";
                    String body="The tp to reset your Password"+otp;
                    boolean sentMail=SMTPSMailSender.sendMail(email,subject,body);
                    if (!sentMail){
                        JOptionPane.showMessageDialog(view,"Failed to send otp.Please try again later");
                        
                    }else{
                        String receivedOtp=JOptionPane.showInputDialog(view,"EMptyOTP received");
                        if (receivedOtp.trim().isEmpty()){
                        JOptionPane.showMessageDialog(view,"Empty OTPreceived");
                        
                        }else{
                            if (!otp.equals(receivedOtp)){
                                JOptionPane.showMessageDialog(view,"The OTP was Wrong");
                                
                                
                            }else{
                                String newPassword=JOptionPane.showInputDialog(view,"Enter the new Password");
                                if(newPassword.trim().isEmpty()){
                                    JOptionPane.showMessageDialog
                                }
                                
                            }
                        }
                            
                        } 
                
            
                    
                }
                
            }
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
           
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
           
        }
       
       
   } 
}
