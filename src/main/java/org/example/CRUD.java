package org.example;

import java.sql.*;

public class CRUD {
    private Connection connection;

    // Constructor
    public CRUD(String url, String user, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, user, password);
    }

    //a method to create a new user
    public void createEmployee(String name, String email) throws SQLException{
        String query = "INSERT INTO employees (name, email) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setString(2, email);
            statement.executeUpdate();
        }
    }

    // a method for reading/retrieving employees from the DB
    public void readEmployees()throws SQLException{
       String query = "SELECT id, name, email FROM employees";

       try (Statement statement = connection.createStatement()){
           ResultSet resultSet = statement.executeQuery(query);

           while (resultSet.next()){
               System.out.println("ID: " + resultSet.getInt("id") + "  Name: " + resultSet.getString("name")+ "  Email: " + resultSet.getString("email"));
           }
       }
    }

    // a method of reading/ retrieving a single employee
    public void readOneEmployee(int id) throws  SQLException{
        String query = "SELECT * FROM employees WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                System.out.println("ID: " + resultSet.getInt("id") + "  Name: " + resultSet.getString("name") + " Email: " + resultSet.getString("email"));
            } else {
                System.out.println("Employee with ID: " + id + "NOT FOUND!!");
            }
        }
    }

    // a method for updating employees
    public void updateEmployee(int id, String name, String email)throws SQLException{
        String query = "UPDATE employees SET name = ?, email = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setInt(3, id);
            statement.executeUpdate();
        }
    }

    // a method for deleting an employee
    public void deleteEmployee(int id)throws SQLException{
        String query = "DELETE From employees WHERE id = ?";

        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
