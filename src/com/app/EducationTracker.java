package com.app;
import java.util.Scanner;

public class EducationTracker {
    public static void main(String[] args) {
        System.out.println("Welcome to Education Tracker");

        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. Add Student");
            System.out.println("2. Modify Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. Show All Students");
            System.out.println("6. Exit");

            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Enter first name:");
                    String firstName = scanner.nextLine();
                    System.out.println("Enter last name:");
                    String lastName = scanner.nextLine();
                    System.out.println("Enter age:");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter grades:");
                    String grades = scanner.nextLine();
                    MySqlRequests.AddStudent(firstName, lastName, age, grades);
                    break;
                case 2:
                    System.out.println("Enter id:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter first name:");
                    firstName = scanner.nextLine();
                    System.out.println("Enter last name:");
                    lastName = scanner.nextLine();
                    System.out.println("Enter age:");
                    age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter grades:");
                    grades = scanner.nextLine();
                    MySqlRequests.ModifyStudent(id, firstName, lastName, age, grades);
                    break;
                case 3:
                    System.out.println("Enter id:");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    MySqlRequests.DeleteUser(id);
                    break;
                case 4:
                    System.out.println("Enter id:");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    MySqlRequests.SearchStudent(id);
                    break;
                case 5:
                    MySqlRequests.ShowStudents();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}

