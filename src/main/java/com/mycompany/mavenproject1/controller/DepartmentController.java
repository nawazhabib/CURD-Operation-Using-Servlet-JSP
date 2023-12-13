/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.controller;

import com.mycompany.mavenproject1.DAO.DepartmentDAO;
import com.mycompany.mavenproject1.entity.Department;
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
@WebServlet("/department")
public class DepartmentController extends HttpServlet{
    private DepartmentDAO departmentDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        departmentDAO = new DepartmentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                listDepartments(request, response);
                break;
            case "showForm":
                showDepartmentForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteDepartment(request, response);
                break;
            default:
                listDepartments(request, response);
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
                createDepartment(request, response);
                break;
            case "update":
                updateDepartment(request, response);
                break;
            default:
                listDepartments(request, response);
        }
    }

    private void listDepartments(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Department> departments = departmentDAO.getAllDepartments();
        request.setAttribute("departments", departments);
        request.getRequestDispatcher("/WEB-INF/pages/department.jsp").forward(request, response);
    }

    private void showDepartmentForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/department-form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int deptId = Integer.parseInt(request.getParameter("deptId"));
        Department department = departmentDAO.getDepartmentById(deptId);
        request.setAttribute("department", department);
        request.getRequestDispatcher("/WEB-INF/pages/department-form.jsp").forward(request, response);
    }

    private void createDepartment(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String departmentName = request.getParameter("departmentName");
        Department newDepartment = new Department();
        newDepartment.setDepartmentName(departmentName);
        departmentDAO.addDepartment(newDepartment);
        response.sendRedirect(request.getContextPath() + "/department?action=list");
    }

    private void updateDepartment(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int deptId = Integer.parseInt(request.getParameter("deptId"));
        String departmentName = request.getParameter("departmentName");

        Department existingDepartment = departmentDAO.getDepartmentById(deptId);
        existingDepartment.setDepartmentName(departmentName);

        departmentDAO.updateDepartment(existingDepartment);
        response.sendRedirect(request.getContextPath() + "/department?action=list");
    }

    private void deleteDepartment(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int deptId = Integer.parseInt(request.getParameter("deptId"));
        departmentDAO.deleteDepartment(deptId);
        response.sendRedirect(request.getContextPath() + "/department?action=list");
    }
}
