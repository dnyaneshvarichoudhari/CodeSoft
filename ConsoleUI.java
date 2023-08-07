

import java.util.Scanner;
public class ConsoleUI {
    private static Scanner scanner = new Scanner(System.in);
    private static StudentManagementSystem system = new StudentManagementSystem();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Save Students to File");
            System.out.println("7. Load Students from File");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    editStudent();
                    break;

                case 3:
                    removeStudent();
                    break;

                case 4:
                    searchStudent();
                    break;

                case 5:
                    displayAllStudents();
                    break;

                case 6:
                    saveStudentsToFile();
                    break;

                case 7:
                    loadStudentsFromFile();
                    break;

                case 8:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        System.out.print("Enter roll number: ");
        int rollNumber;
        try {
            rollNumber = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid roll number format.");
            return;
        }

        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();
        if (grade.isEmpty()) {
            System.out.println("Grade cannot be empty.");
            return;
        }

        Student newStudent = new Student(name, rollNumber, grade);
        system.addStudent(newStudent);
        System.out.println("Student added successfully.");
    }

    private static void editStudent() {
        System.out.print("Enter roll number of student to edit: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter new student name: ");
        String newName = scanner.nextLine();
        if (newName.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        System.out.print("Enter new grade: ");
        String newGrade = scanner.nextLine();
        if (newGrade.isEmpty()) {
            System.out.println("Grade cannot be empty.");
            return;
        }

        system.editStudent(rollNumber, newName, newGrade);
    }

    private static void removeStudent() {
        System.out.print("Enter roll number of student to remove: ");
        int rollNumber = scanner.nextInt();
        system.removeStudent(rollNumber);
        System.out.println("Student removed successfully.");
    }

    private static void searchStudent() {
        System.out.print("Enter roll number of student to search: ");
        int rollNumber = scanner.nextInt();
        Student foundStudent = system.searchStudent(rollNumber);
        if (foundStudent != null) {
            System.out.println("Found student:");
            foundStudent.displayStudentInfo();
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void displayAllStudents() {
        System.out.println("All students:");
        system.displayAllStudents();
    }

    private static void saveStudentsToFile() {
        System.out.print("Enter filename to save students: ");
        String filename = scanner.nextLine();
        system.saveStudentsToFile(filename);
    }

    private static void loadStudentsFromFile() {
        System.out.print("Enter filename to load students: ");
        String filename = scanner.nextLine();
        system.loadStudentsFromFile(filename);
    }
}
 
