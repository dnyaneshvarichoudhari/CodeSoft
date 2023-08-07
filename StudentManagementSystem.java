import java.util.ArrayList;
import java.util.List;
import java.io.*;
class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            student.displayStudentInfo();
            System.out.println();
        }
    }

    public void saveStudentsToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Student student : students) {
                writer.println(student.toString());
            }
            System.out.println("Students saved to file: " + filename);
        } catch (IOException e) {
            System.err.println("Error saving students to file: " + e.getMessage());
        }
    }

    public void loadStudentsFromFile(String filename) {
        students.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0];
                    int rollNumber = Integer.parseInt(parts[1]);
                    String grade = parts[2];
                    Student student = new Student(name, rollNumber, grade);
                    students.add(student);
                }
            }
            System.out.println("Students loaded from file: " + filename);
        } catch (IOException e) {
            System.err.println("Error loading students from file: " + e.getMessage());
        }
    }

    public void editStudent(int rollNumber, String newName, String newGrade) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                student.name = newName;
                student.grade = newGrade;
                System.out.println("Student information updated.");
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }
}