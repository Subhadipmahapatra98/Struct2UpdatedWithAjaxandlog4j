/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;


import com.exavalu.models.Employee;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 *
 * @author Avijit Chattopadhyay
 */
public class EmployeeService {
    
    public static EmployeeService employeeService = null;
    
    public static EmployeeService getInstance()
    {
        if(employeeService==null)
        {
            return new EmployeeService();
        }
        else
        {
            return employeeService;
        }
    }
    
    public ArrayList getAllEmployees()
    {
        ArrayList empList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from employees e, department d, roles r "
                    + "where e.departmentId=d.departmentId and e.roleId=r.roleId ";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();


            while(rs.next())
            {
                Employee emp = new Employee();
                emp.setAddress(rs.getString("address"));
                emp.setEmployeeId(rs.getString("employeeId"));
                emp.setFirstName(rs.getString("firstName"));
                emp.setLastName(rs.getString("lastName"));
                emp.setPhone(rs.getString("phone"));
                emp.setGender(rs.getString("gender"));
                emp.setAge(rs.getString("age"));
                emp.setDepartmentName(rs.getString("departmentName"));
                emp.setRoleName(rs.getString("roleName"));
                emp.setBasicSalary(rs.getString("basicSalary"));
                emp.setCarAllowance(rs.getString("carAllaowance"));

                empList.add(emp);

            }


        } catch (SQLException ex) {
           Logger log = Logger.getLogger(EmployeeService.class.getName());
           log.error("Error message -"+ex.getMessage());
        }
        System.out.println("Number of employees = "+empList.size());
        return empList;
    }
    
    public Employee getEmployee(String employeeId) {
        Employee emp = new Employee();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "SELECT * FROM employees,department,roles where employees.departmentId = department.departmentId and employees.roleId = roles.roleId and employees.employeeId=?;";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, employeeId);
            ResultSet rs = preparedStatement.executeQuery();


            while(rs.next())
            {
                emp.setEmployeeId(rs.getString("employeeId"));
                emp.setFirstName(rs.getString("firstName"));
                emp.setLastName(rs.getString("lastName"));
                emp.setPhone(rs.getString("phone"));
                emp.setAddress(rs.getString("address"));
                emp.setGender(rs.getString("gender"));
                emp.setAge(rs.getString("age"));
                emp.setBasicSalary(rs.getString("basicSalary"));
                emp.setCarAllowance(rs.getString("carAllowance"));
                emp.setDepartmentName(rs.getString("departmentName"));
                emp.setRoleName(rs.getString("roleName"));


            }


        } catch (SQLException ex) {
           Logger log = Logger.getLogger(EmployeeService.class.getName());
           log.error("Error message -"+ex.getMessage());
        }
        return emp;
    }
    public ArrayList SearchEmployees(String firstName, String lastName, String gender, String departmentName, String roleName) {
        ArrayList empList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            
            String sql = "SELECT * from employees e join department d join roles r where e.departmentId = d.departmentId and e.roleId = r.roleId and e.firstName like ? and e.lastName like ? and e.gender like ? and d.departmentName like ? and r.roleName like ?";
           
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, firstName+"%");
            preparedStatement.setString(2, lastName+"%");
            preparedStatement.setString(3, gender+"%");
            preparedStatement.setString(4, departmentName+"%");
            preparedStatement.setString(5, roleName+"%");
            
            
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();


            while(rs.next())
            {
                Employee emp1 = new Employee();
                
                emp1.setEmployeeId(rs.getString("employeeId"));
                emp1.setFirstName(rs.getString("firstName"));
                emp1.setLastName(rs.getString("lastName"));
                emp1.setPhone(rs.getString("phone"));
                emp1.setAddress(rs.getString("address"));
                emp1.setGender(rs.getString("gender"));
                emp1.setAge(rs.getString("age"));
                emp1.setBasicSalary(rs.getString("basicSalary"));
                emp1.setCarAllowance(rs.getString("carAllaowance"));
                emp1.setDepartmentName(rs.getString("departmentName"));
                emp1.setRoleName(rs.getString("roleName"));

                empList.add(emp1);

            }


        } catch (SQLException ex) {
           Logger log = Logger.getLogger(EmployeeService.class.getName());
           log.error("Error message -"+ex.getMessage());
        }
        System.out.println("Number of employees = "+empList.size());
        
        return empList;
    }

    public static boolean AddEmployee(Employee emp) {
        boolean result = false;
        try {

            Connection con = JDBCConnectionManager.getConnection();
        String sql = "INSERT INTO employees (firstName,lastName,phone,address,gender,age,departmentId,roleId,basicSalary,carAllaowance) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            int totalRows = 0;
            
  
            preparedStatement.setString(1, emp.getFirstName());
            preparedStatement.setString(2, emp.getLastName());
            preparedStatement.setString(3, emp.getPhone());
            preparedStatement.setString(4, emp.getAddress());
            preparedStatement.setString(5, emp.getGender());
            preparedStatement.setString(6, emp.getAge());
            preparedStatement.setString(7, emp.getDepartmentId());
            preparedStatement.setString(8, emp.getRoleId());
            preparedStatement.setString(9, emp.getBasicSalary());
            preparedStatement.setString(10, emp.getCarAllowance());

                int row = preparedStatement.executeUpdate();

                if (row == 1) {
                    result = true;
                }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(EmployeeService.class.getName());
            log.error("Error message -"+ex.getMessage());
            }
        return result;
  
    }
    public static boolean saveEmployee(Employee emp, String employeeId) {
        
        boolean result = false;
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "UPDATE employees\n"
                    + "SET firstName = ? , lastName = ? , phone = ? , address = ? ,\n"
                    + "gender = ? , age = ? , basicSalary = ?,carAllaowance = ?, departmentId=?, roleId=?\n"
                    + "WHERE employeeId = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            
            preparedStatement.setString(1, emp.getFirstName());
            preparedStatement.setString(2, emp.getLastName());
            preparedStatement.setString(3, emp.getPhone());
            preparedStatement.setString(4, emp.getAddress());
            preparedStatement.setString(5, emp.getGender());
            preparedStatement.setString(6, emp.getAge());
            preparedStatement.setDouble(7, Double.parseDouble(emp.getBasicSalary()));
            preparedStatement.setDouble(8, Double.parseDouble(emp.getCarAllowance()));
            preparedStatement.setString(9, emp.getDepartmentId());
            preparedStatement.setString(10, emp.getRoleId());
            
                       
            preparedStatement.setString(11, employeeId);
            
            int row = preparedStatement.executeUpdate();

            if(row==1)
            {
                result = true;
            }

        } catch (SQLException ex) {
           Logger log = Logger.getLogger(EmployeeService.class.getName());
           log.error("Error message -"+ex.getMessage());
        }
        return result;
    }

}
