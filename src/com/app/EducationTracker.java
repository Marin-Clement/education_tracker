package com.app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EducationTracker {
    public static void main(String[] args) {
        System.out.println("Welcome to Education Tracker");

        while (true) {
            TerminalUi.PrintSelectOption();

            int option = getUserInput();

            switch (option) {
                case 1 -> addStudent();
                case 2 -> modifyStudent();
                case 3 -> deleteStudent();
                case 4 -> searchStudent();
                case 5 -> showStudents();
                case 6 -> System.exit(0);
                default -> System.out.println("Invalid option");
            }
        }
    }

    private static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        boolean validInput = false;

        while (!validInput) {
            TerminalUi.PrintChoice("Enter option number: ");

            try {
                input = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                TerminalUi.PrintError(e);
                scanner.nextLine();
            }
        }

        return input;
    }

    private static void addStudent() {
        Scanner scanner = new Scanner(System.in);

        TerminalUi.PrintChoice("Enter first name:");
        String firstName = scanner.nextLine();
        TerminalUi.PrintChoice("Enter last name:");
        String lastName = scanner.nextLine();
        TerminalUi.PrintChoice("Enter age:");
        int age = scanner.nextInt();
        scanner.nextLine();
        TerminalUi.PrintChoice("Enter grades:");
        String grades = scanner.nextLine();

        MySqlRequests.AddStudent(firstName, lastName, age, grades);
    }

    private static void modifyStudent() {
        Scanner scanner = new Scanner(System.in);

        TerminalUi.PrintChoice("Enter id:");
        int id = scanner.nextInt();
        scanner.nextLine();
        TerminalUi.PrintChoice("Enter first name:");
        String firstName = scanner.nextLine();
        TerminalUi.PrintChoice("Enter last name:");
        String lastName = scanner.nextLine();
        TerminalUi.PrintChoice("Enter age:");
        int age = scanner.nextInt();
        scanner.nextLine();
        TerminalUi.PrintChoice("Enter grades:");
        String grades = scanner.nextLine();

        MySqlRequests.ModifyStudent(id, firstName, lastName, age, grades);
    }

    private static void deleteStudent() {
        Scanner scanner = new Scanner(System.in);

        TerminalUi.PrintChoice("Enter id:");
        int id = scanner.nextInt();
        scanner.nextLine();

        MySqlRequests.DeleteUser(id);
    }

    private static void searchStudent() {
        Scanner scanner = new Scanner(System.in);

        TerminalUi.PrintChoice("Enter id:");
        int id = scanner.nextInt();
        scanner.nextLine();

        MySqlRequests.SearchStudent(id);
    }

    private static void showStudents() {
        MySqlRequests.ShowStudents();
    }
}
