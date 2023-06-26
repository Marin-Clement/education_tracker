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
            System.out.println("\u001B[32mStudent added successfully:\u001B[0m");
            ShowStudentsTable();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("Error: " + ex.getErrorCode());
        }
    }

    public static void ModifyStudent(int id, String firstName, String lastName, int age, String grades) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationtracker", username, password);
            Statement stmt = con.createStatement();
            String query = "UPDATE students SET first_name = '" + firstName + "', last_name = '" + lastName + "', age = " + age + ", grades = '" + grades + "' WHERE id = " + id;
            stmt.executeUpdate(query);
            con.close();
            System.out.println("\u001B[32mStudent modified successfully:\u001B[0m");
            ShowStudentsTable();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("Error: " + ex.getErrorCode());
        }
    }

    public static void DeleteUser(int id) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationtracker", username, password);
            Statement stmt = con.createStatement();
            String query = "DELETE FROM students WHERE id = " + id;
            stmt.executeUpdate(query);
            con.close();
            System.out.println("\u001B[32mStudent deleted successfully:\u001B[0m");
            ShowStudentsTable();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("Error: " + ex.getErrorCode());
        }
    }

    public static void SearchStudent(int id) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationtracker", username, password);
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM students WHERE id = " + id;
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("\u001B[34mSearch results:\u001B[0m");
            System.out.println("+----+------------+-----------+-----+---------+");
            System.out.println("| ID | First Name | Last Name | Age | Grades  |");
            System.out.println("+----+------------+-----------+-----+---------+");
            while (rs.next()) {
                System.out.printf("| %-2s | %-10s | %-9s | %-3s | %-7s |\n", rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getInt("age"), rs.getString("grades"));
            }
            System.out.println("+----+------------+-----------+-----+---------+");
            con.close();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("Error: " + ex.getErrorCode());
        }
    }

    public static void ShowStudents() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationtracker", username, password);
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM students";
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("\u001B[34mStudents:\u001B[0m");
            System.out.println("+----+------------+-----------+-----+---------+");
            System.out.println("| ID | First Name | Last Name | Age | Grades  |");
            System.out.println("+----+------------+-----------+-----+---------+");
            while (rs.next()) {
                System.out.printf("| %-2s | %-10s | %-9s | %-3s | %-7s |\n", rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getInt("age"), rs.getString("grades"));
            }
            System.out.println("+----+------------+-----------+-----+---------+");
            con.close();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("Error: " + ex.getErrorCode());
        }
    }

    private static void ShowStudentsTable() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationtracker", username, password);
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM students";
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("+----+------------+-----------+-----+---------+");
            System.out.println("| ID | First Name | Last Name | Age | Grades  |");
            System.out.println("+----+------------+-----------+-----+---------+");
            while (rs.next()) {
                System.out.printf("| %-2s | %-10s | %-9s | %-3s | %-7s |\n", rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getInt("age"), rs.getString("grades"));
            }
            System.out.println("+----+------------+-----------+-----+---------+");
            con.close();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("Error: " + ex.getErrorCode());
        }
    }
}
