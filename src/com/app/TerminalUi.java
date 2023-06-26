package com.app;

import java.sql.SQLException;

public class TerminalUi {

    // ANSI color codes
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_GREEN = "\u001B[32m";

    public static void PrintSelectOption() {
        System.out.println(ANSI_CYAN + "Select an option:" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "1. Add student" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "2. Modify student" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "3. Delete student" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "4. Search student" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "5. Show students" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "6. Exit" + ANSI_RESET);
    }

    public static void PrintSqlError(SQLException ex) {
        System.out.println(ANSI_RED + "SQLException: " + ex.getMessage() + ANSI_RESET);
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("Error: " + ex.getErrorCode());
    }

    public static void PrintError(Exception ex) {
        System.out.println(ANSI_RED + "Error: " + ex.getMessage() + ANSI_RESET);
    }

    public static void PrintChoice(String choice) {
        System.out.println(ANSI_YELLOW + choice + ANSI_RESET);
    }

    public static void PrintSuccess(String message) {
        System.out.println(ANSI_GREEN + message + ANSI_RESET);
    }

    public static void PrintTableHeader() {
        System.out.println(ANSI_CYAN + "+----+------------+-----------+-----+---------+" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "| ID | First Name | Last Name | Age | Grades  |" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "+----+------------+-----------+-----+---------+" + ANSI_RESET);
    }

    public static void PrintTableFooter() {
        System.out.println(ANSI_CYAN + "+----+------------+-----------+-----+---------+" + ANSI_RESET);
    }

    public static void PrintUserLine(int id, String firstName, String lastName, int age, String grades) {
        System.out.printf(ANSI_CYAN + "| " + ANSI_YELLOW + " %2d | %-10s | %-9s | %3d | %-7s " + ANSI_CYAN + " |\n" + ANSI_RESET, id, firstName, lastName, age, grades);
    }
}
