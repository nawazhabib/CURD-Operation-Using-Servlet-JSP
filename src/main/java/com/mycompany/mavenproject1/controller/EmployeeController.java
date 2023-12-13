/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.controller;

import com.mycompany.mavenproject1.DAO.EmployeeDAO;
import com.mycompany.mavenproject1.entity.Employee;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author habib
 */

/**
 * This controller class is responsible for creating our APIS
 * Here i created get, post, create, update and delete apis
 */

@WebServlet("/employee")
public class EmployeeController extends HttpServlet{
    private EmployeeDAO employeeDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        employeeDAO = new EmployeeDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list"; // default action
        }

        switch (action) {
            case "list":
                listEmployees(request, response);
                break;
            case "showForm":
                showEmployeeForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
            default:
                listEmployees(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list"; // default action
        }

        switch (action) {
            case "create":
                createEmployee(request, response);
                break;
            case "update":
                updateEmployee(request, response);
                break;
            default:
                listEmployees(request, response);
        }
    }

    @Override
protected void doPut(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    int employeeId = Integer.parseInt(request.getParameter("employeeId"));
    String name = request.getParameter("name");
    int deptId = Integer.parseInt(request.getParameter("deptId"));
    String designation = request.getParameter("designation");
    int salary = Integer.parseInt(request.getParameter("salary"));
    String birthDate = request.getParameter("birthDate");
    String status = request.getParameter("status");

    Employee existingEmployee = employeeDAO.getEmployeeById(employeeId);
    existingEmployee.setName(name);
    existingEmployee.setDepartmentID(deptId);
    existingEmployee.setDesignation(designation);
    existingEmployee.setSalary(salary);
    existingEmployee.setBirthDate(birthDate);
    existingEmployee.setStatus(status);

    employeeDAO.updateEmployee(existingEmployee);
    response.sendRedirect(request.getContextPath() + "/employee?action=list");
}

@Override
protected void doDelete(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    int employeeId = Integer.parseInt(request.getParameter("employeeId"));
    employeeDAO.deleteEmployee(employeeId);
    response.sendRedirect(request.getContextPath() + "/employee?action=list");
}


    private void listEmployees(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Employee> employees = employeeDAO.getAllEmployees();
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("/WEB-INF/pages/employee.jsp").forward(request, response);
    }

    private void showEmployeeForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/employee-form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        Employee employee = employeeDAO.getEmployeeById(employeeId);
        request.setAttribute("employee", employee);
        request.getRequestDispatcher("/WEB-INF/pages/employee-form.jsp").forward(request, response);
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        int deptId = Integer.parseInt(request.getParameter("deptId"));
        String designation = request.getParameter("designation");
        int salary = Integer.parseInt(request.getParameter("salary"));
        String birthDate = request.getParameter("birthDate");
        String status = request.getParameter("status");

        Employee newEmployee = new Employee();
        newEmployee.setName(name);
        newEmployee.setDepartmentID(deptId);
        newEmployee.setDesignation(designation);
        newEmployee.setSalary(salary);
        newEmployee.setBirthDate(birthDate);
        newEmployee.setStatus(status);

        employeeDAO.addEmployee(newEmployee);
        response.sendRedirect(request.getContextPath() + "/employee?action=list");
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        String name = request.getParameter("name");
        int deptId = Integer.parseInt(request.getParameter("deptId"));
        String designation = request.getParameter("designation");
        int salary = Integer.parseInt(request.getParameter("salary"));
        String birthDate = request.getParameter("birthDate");
        String status = request.getParameter("status");

        Employee existingEmployee = employeeDAO.getEmployeeById(employeeId);
        existingEmployee.setName(name);
        existingEmployee.setDepartmentID(deptId);
        existingEmployee.setDesignation(designation);
        existingEmployee.setSalary(salary);
        existingEmployee.setBirthDate(birthDate);
        existingEmployee.setStatus(status);

        employeeDAO.updateEmployee(existingEmployee);
        response.sendRedirect(request.getContextPath() + "/employee?action=list");
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        employeeDAO.deleteEmployee(employeeId);
        response.sendRedirect(request.getContextPath() + "/employee?action=list");
    }
}
