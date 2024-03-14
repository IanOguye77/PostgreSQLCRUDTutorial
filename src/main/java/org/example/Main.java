package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // DB Parameters
        String url = "jdbc:postgresql://localhost/crudDB";
        String user = "postgres";
        String password = "246813579";

        // perform the crud operations

        try {

            // create the CRUD object
            CRUD employee = new CRUD(url, user, password);


            // create a new employee
            // employee.createEmployee("Ian Oguye","Ian.com.com");
            // employee.createEmployee("Ryan Roimen","Ryan.com.com");
            // employee.createEmployee("Nethan Mopel","Nethan.com.com");
            // employee.createEmployee("Ephraim Imani","Ephraim.com.com");
            // employee.createEmployee("Praise Mwangi","Praise.com.com");
            //employee.createEmployee("ME ME","meme.gmail.com");

            // update an employee
           // employee.updateEmployee(6, "Ian Ian", "ianian7@gmail.com");

            // delete an employee
            // employee.deleteEmployee(6)


            // Read/Retrieve employees
            employee.readEmployees();

            // read one employee
           // employee.readOneEmployee(1);


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}