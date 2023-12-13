/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.DAO;


import com.mycompany.mavenproject1.entity.Department;
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

public class DepartmentDAO {
//      Creating a new department
    public void addDepartment(Department department) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            String sql = "INSERT INTO DEPARTMENT (DEPT_ID, DEPARTMENT_NAME, CREATED_DATE) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, department.getDeptId());
                statement.setString(2, department.getDepartmentName());
                statement.setDate(3, new java.sql.Date(department.getCreatedDate().getTime()));
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//     Retrieving all departments
    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<>();
        try (Connection connection = DatabaseConfig.getConnection()) {
            String sql = "SELECT * FROM DEPARTMENT";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Department department = new Department();
                        department.setDeptId(resultSet.getInt("DEPT_ID"));
                        department.setDepartmentName(resultSet.getString("DEPARTMENT_NAME"));
                        department.setCreatedDate(resultSet.getDate("CREATED_DATE"));
                        departments.add(department);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return departments;
    }

//     Retrieving a specific department by deptID
    public Department getDepartmentById(int deptId) {
        Department department = null;
        try (Connection connection = DatabaseConfig.getConnection()) {
            String sql = "SELECT * FROM DEPARTMENT WHERE DEPT_ID=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, deptId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        department = new Department();
                        department.setDeptId(resultSet.getInt("DEPT_ID"));
                        department.setDepartmentName(resultSet.getString("DEPARTMENT_NAME"));
                        department.setCreatedDate(resultSet.getDate("CREATED_DATE"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }

//     Updating department
    public void updateDepartment(Department department) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            String sql = "UPDATE DEPARTMENT SET DEPARTMENT_NAME=?, CREATED_DATE=? WHERE DEPT_ID=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, department.getDepartmentName());
                statement.setDate(2, new java.sql.Date(department.getCreatedDate().getTime()));
                statement.setInt(3, department.getDeptId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//     Deleting department by deptID
    public void deleteDepartment(int deptId) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            String sql = "DELETE FROM DEPARTMENT WHERE DEPT_ID=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, deptId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
