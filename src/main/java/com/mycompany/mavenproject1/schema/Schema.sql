/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  habib
 * Created: Dec 12, 2023
 */

CREATE TABLE DEPARTMENT (
    DEPT_ID INT PRIMARY KEY,
    DEPARTMENT_NAME VARCHAR(255),
    CREATED_DATE VARCHAR(255)
);

CREATE TABLE EMPLOYEE (
    ID INT PRIMARY KEY,
    NAME VARCHAR(255),
    DEPT_ID INT,
    DESIGNATION VARCHAR(255),
    SALARY DECIMAL(10, 2),
    BIRTH_DATE VARCHAR(255),
    STATUS VARCHAR(20),
    CREATED_DATE VARCHAR(255),
    UPDATED_DATE VARCHAR(255),
    FOREIGN KEY (DEPT_ID) REFERENCES DEPARTMENT(DEPT_ID)
);
