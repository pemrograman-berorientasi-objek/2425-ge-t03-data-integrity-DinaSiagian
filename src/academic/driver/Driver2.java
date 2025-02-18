package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.Scanner;

/**
 * @author 12S23009_Dina Marlina Siagian
 * @author 12S23028_Daniel Situmorang
 */
public class Driver2 {
    public static void main(String[] _args) {
        Scanner input = new Scanner(System.in);

        Course[] courses = new Course[100];
        Student[] students = new Student[100];
        Enrollment[] enrollments = new Enrollment[100];

        int courseCount = 0;
        int studentCount = 0;
        int enrollmentCount = 0;

        StringBuilder invalidEntries = new StringBuilder();

        while (true) {
            String line = input.nextLine().trim();

            if (line.equals("---")) {
                break;
            }

            String[] data = line.split("#");

            switch (data[0]) {
                case "course-add":
                    if (data.length == 5) {
                        courses[courseCount] = new Course(data[1], data[2], data[3], data[4]);
                        courseCount++;
                    }
                    break;
                case "student-add":
                    if (data.length == 5) {
                        students[studentCount] = new Student(data[1], data[2], data[3], data[4]);
                        studentCount++;
                    }
                    break;
                case "enrollment-add":
                    if (data.length == 5) {
                        String courseId = data[1];
                        String studentId = data[2];
                        
                        boolean courseExists = false;
                        boolean studentExists = false;
                        
                        for (int i = 0; i < courseCount; i++) {
                            if (courses[i].getNim().equals(courseId)) {
                                courseExists = true;
                                break;
                            }
                        }
                        
                        for (int i = 0; i < studentCount; i++) {
                            if (students[i].getNim().equals(studentId)) {
                                studentExists = true;
                                break;
                            }
                        }
                        
                        if (!courseExists) {
                            invalidEntries.append("invalid course|").append(courseId).append("\n");
                        } else if (!studentExists) {
                            invalidEntries.append("invalid student|").append(studentId).append("\n");
                        } else {
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

        System.out.print(invalidEntries.toString());

        // Cetak semua courses
        for (int i = courseCount - 1; i >= 0; i--) {
            System.out.println(courses[i].toString());
        }

        // Cetak semua students
        for (int i = 0 ; i < studentCount ; i++) {
            System.out.println(students[i].toString());
        }

        // Cetak semua enrollments
        for (int i = 0; i < enrollmentCount; i++) {
            System.out.println(enrollments[i].toString());
        }
        
    }
}