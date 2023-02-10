/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.User;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Avijit Chattopadhyay
 */
public class LoginService {
    
    public static LoginService loginService = null;
    
    private LoginService(){}
    
    public static LoginService getInstance()
    {
        if(loginService==null)
        {
            return new LoginService();
        }
        else
        {
            return loginService;
        }
    }
    
    public boolean doLogin(String emailAddress, String password)
    {
        boolean success = false;
        
        String sql = "Select * from employeedb2.users where emailAddress=? and password=?";
        
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, emailAddress);
            ps.setString(2, password);
            
            System.out.println("LoginService :: "+ps);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                success = true;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return success;
    }
    
     public boolean doSignUp(User user) {
        boolean result = false;
        boolean success=false;

        Connection con = JDBCConnectionManager.getConnection();

        String sql = "INSERT INTO users(emailAddress,password,firstName,lastName,status,countryId,stateId,districtId)"
                + "VALUES (?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, user.getEmailAddress());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.setInt(5, 1);
            preparedStatement.setInt(6, user.getCountryId());
            preparedStatement.setInt(7, user.getStateId());
            preparedStatement.setInt(8, user.getDistrictId());
             
             System.out.println("LoginService :: " + preparedStatement);
            int rows = preparedStatement.executeUpdate();

            if (rows==1) {
                
                result = true;
            }

            con.close();
             System.out.println("LoginService :: "+preparedStatement);

            
            ResultSet rs = preparedStatement.executeQuery();
            
            if(rs.next())
            {
                success = true;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return result;
     }

    
}
