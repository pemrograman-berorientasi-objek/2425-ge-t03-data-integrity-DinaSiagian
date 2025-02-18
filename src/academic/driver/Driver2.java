package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.Scanner;

public class Driver2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Course[] courses = new Course[100];
        Student[] students = new Student[100];
        Enrollment[] enrollments = new Enrollment[100];

        int courseCount = 0;
        int studentCount = 0;
        int enrollmentCount = 0;

        while (true) {
            String line = input.nextLine().trim();

            if (line.equals("---")) {
                break; 
            }

            String[] data = line.split("#");
            if (data.length < 2) continue; 

            switch (data[0]) {
                case "course-add":
                    if (data.length == 5) {
                        // Check for duplicates
                        boolean exists = false;
                        for (int i = 0; i < courseCount; i++) {
                            if (courses[i].getNim().equals(data[1])) {
                                exists = true;
                                break;
                            }
                        }
                        if (!exists) {
                            try {
                                int sks = Integer.parseInt(data[3].trim());
                                courses[courseCount] = new Course(data[1], data[2], sks, data[4]);
                                courseCount++;
                            } catch (NumberFormatException e) {
                                System.out.println("Error: SKS harus berupa angka.");
                            }
                        }
                    }
                    break;

                case "student-add":
                    if (data.length == 5) {
                        // Check for duplicates
                        boolean existsStudent = false;
                        for (int i = 0; i < studentCount; i++) {
                            if (students[i].getNim().equals(data[1])) {
                                existsStudent = true;
                                break;
                            }
                        }
                        if (!existsStudent) {
                            try {
                                int angkatan = Integer.parseInt(data[3].trim());
                                students[studentCount] = new Student(data[1].trim(), data[2].trim(), angkatan, data[4].trim());
                                studentCount++;
                            } catch (NumberFormatException e) {
                                System.out.println("Error: Angkatan harus berupa angka.");
                            }
                        }
                    }
                    break;

                case "enrollment-add":
                    if (data.length == 5) {
                        // Check if course exists first
                        boolean courseExists = false;
                        for (int i = 0; i < courseCount; i++) {
                            if (courses[i].getNim().equals(data[1])) {
                                courseExists = true;
                                break;
                            }
                        }

                        // If course does not exist, print error and skip further checks
                        if (!courseExists) {
                            System.out.println("invalid course|" + data[1]);
                            break;
                        }

                        // Check if student exists
                        boolean studentExists = false;
                        for (int i = 0; i < studentCount; i++) {
                            if (students[i].getNim().equals(data[2])) {
                                studentExists = true;
                                break;
                            }
                        }

                        // If student does not exist, print error
                        if (!studentExists) {
                            System.out.println("invalid student|" + data[2]);
                        } else { // If both exist, add enrollment
                            enrollments[enrollmentCount] = new Enrollment(data[1], data[2], data[3], data[4]);
                            enrollmentCount++;
                        }
                    }
                    break;

                default:
                    System.out.println("Error: Perintah tidak dikenali.");
            }
        }

        input.close();

        // Print all courses
        for (int i = 0; i < courseCount; i++) {
            System.out.println(courses[i].toString());
        }

        // Print all students
        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i].toString());
        }

        // Print all enrollments
        for (int i = 0; i < enrollmentCount; i++) {
            System.out.println(enrollments[i].toString());
        }
    }
}
