package com.app;

import java.sql.*;

public class MySqlRequests {

    public static final String username = "root";
    public static final String password = "Minecraft01@";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        }
    }

    public static void AddStudent(String firstName, String lastName, int age, String grades) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationtracker", username, password);
            Statement stmt = con.createStatement();
            String query = "INSERT INTO students (first_name, last_name, age, grades) VALUES ('" + firstName + "', '" + lastName + "', " + age + ", '" + grades + "')";
            stmt.executeUpdate(query);
            con.close();
            TerminalUi.PrintSuccess("Student added successfully");
        } catch (SQLException ex) {
            TerminalUi.PrintSqlError(ex);
        }
    }

    public static void ModifyStudent(int id, String firstName, String lastName, int age, String grades) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationtracker", username, password);
            Statement stmt = con.createStatement();
            String query = "UPDATE students SET first_name = '" + firstName + "', last_name = '" + lastName + "', age = " + age + ", grades = '" + grades + "' WHERE id = " + id;
            stmt.executeUpdate(query);
            con.close();
            TerminalUi.PrintSuccess("Student modified successfully");
        } catch (SQLException ex) {
            TerminalUi.PrintSqlError(ex);
        }
    }

    public static void DeleteUser(int id) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationtracker", username, password);
            Statement stmt = con.createStatement();
            String query = "DELETE FROM students WHERE id = " + id;
            stmt.executeUpdate(query);
            con.close();
            TerminalUi.PrintSuccess("Student deleted successfully");
        } catch (SQLException ex) {
            TerminalUi.PrintSqlError(ex);
        }
    }

    public static void SearchStudent(int id) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationtracker", username, password);
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM students WHERE id = " + id;
            ResultSet rs = stmt.executeQuery(query);
            TerminalUi.PrintTableHeader();
            while (rs.next()) {
                TerminalUi.PrintUserLine(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getInt("age"), rs.getString("grades"));
            }
            TerminalUi.PrintTableFooter();
            con.close();
        } catch (SQLException ex) {
            TerminalUi.PrintSqlError(ex);
        }
    }

    public static void ShowStudents() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationtracker", username, password);
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM students";
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("\u001B[34mStudents:\u001B[0m");
            TerminalUi.PrintTableHeader();
            while (rs.next()) {
                TerminalUi.PrintUserLine(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getInt("age"), rs.getString("grades"));
            }
            TerminalUi.PrintTableFooter();
            con.close();
        } catch (SQLException ex) {
            TerminalUi.PrintSqlError(ex);
        }
    }
}
