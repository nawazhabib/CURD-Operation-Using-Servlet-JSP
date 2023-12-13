/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.DAO;

import com.mycompany.mavenproject1.entity.Employee;
import config.DatabaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author habib
 */

/**
 * This Data Access Object class is responsible for CURD operation
 * to database
 * 
 */

public class EmployeeDAO {
//      Creating a new employee
    public void addEmployee(Employee employee) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            String sql = "INSERT INTO EMPLOYEE (ID, NAME, DEPT_ID, DESIGNATION, SALARY, BIRTH_DATE, STATUS, CREATED_DATE, UPDATED_DATE) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, employee.getId());
                statement.setString(2, employee.getName());
                statement.setInt(3, employee.getDepartmentID());
                statement.setString(4, employee.getDesignation());
                statement.setDouble(5, employee.getSalary());
                statement.setDate(6, new java.sql.Date(employee.getCreatedDate().indexOf(5)));
                statement.setString(7, employee.getStatus());
                statement.setDate(8, new java.sql.Date(employee.getCreatedDate().indexOf(7)));
                statement.setDate(9, new java.sql.Date(employee.getUpdateDate().indexOf(8)));
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//     Retrieving all employees
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = DatabaseConfig.getConnection()) {
            String sql = "SELECT * FROM EMPLOYEE";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Employee employee = mapResultSetToEmployee(resultSet);
                        employees.add(employee);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

//     Retrieving a specific employee by employeeID
    public Employee getEmployeeById(int employeeId) {
        Employee employee = null;
        try (Connection connection = DatabaseConfig.getConnection()) {
            String sql = "SELECT * FROM EMPLOYEE WHERE ID=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, employeeId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        employee = mapResultSetToEmployee(resultSet);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

//     Updatting employee
    public void updateEmployee(Employee employee) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            String sql = "UPDATE EMPLOYEE SET NAME=?, DEPT_ID=?, DESIGNATION=?, SALARY=?, BIRTH_DATE=?, " +
                    "STATUS=?, CREATED_DATE=?, UPDATED_DATE=? WHERE ID=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, employee.getName());
                statement.setInt(2, employee.getDepartmentID());
                statement.setString(3, employee.getDesignation());
                statement.setDouble(4, employee.getSalary());
                statement.setDate(5, new java.sql.Date(employee.getBirthDate().indexOf(4)));
                statement.setString(6, employee.getStatus());
                statement.setDate(7, new java.sql.Date(employee.getCreatedDate().indexOf(6)));
                statement.setDate(8, new java.sql.Date(employee.getUpdateDate().indexOf(7)));
                statement.setInt(9, employee.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//     Deleting employee by ID
    public void deleteEmployee(int employeeId) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            String sql = "DELETE FROM EMPLOYEE WHERE ID=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, employeeId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//     maping ResultSet to Employee object
    private Employee mapResultSetToEmployee(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("ID"));
        employee.setName(resultSet.getString("NAME"));
        employee.setDepartmentID(resultSet.getInt("DEPT_ID"));
        employee.setDesignation(resultSet.getString("DESIGNATION"));
        employee.setSalary(resultSet.getInt("SALARY"));
        employee.setBirthDate(resultSet.getDate("BIRTH_DATE").toString());
        employee.setStatus(resultSet.getString("STATUS"));
        employee.setCreatedDate(resultSet.getDate("CREATED_DATE").toString());
        employee.setUpdateDate(resultSet.getDate("UPDATED_DATE").toString());
        return employee;
    }
}
