import java.util.ArrayList;
import java.util.Scanner;

public class StudentCRUD {

    // List to store students
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // Create - Add new student
    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();

        Student student = new Student(id, name, age);
        studentList.add(student);
        System.out.println("Student added successfully!");
    }

    // Read - View students
    private static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }

    // Update - Update student details
    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        boolean found = false;
        for (Student student : studentList) {
            if (student.getId() == id) {
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter new age: ");
                int newAge = scanner.nextInt();

                student.setName(newName);
                student.setAge(newAge);
                System.out.println("Student updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student ID not found.");
        }
    }

    // Delete - Remove a student
    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();

        Student studentToRemove = null;
        for (Student student : studentList) {
            if (student.getId() == id) {
                studentToRemove = student;
                break;
            }
        }

        if (studentToRemove != null) {
            studentList.remove(studentToRemove);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student ID not found.");
        }
    }
}
