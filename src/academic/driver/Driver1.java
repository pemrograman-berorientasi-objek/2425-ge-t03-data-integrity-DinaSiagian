package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.*;

/**
 * @author 12S23009_Dina Marlina Siagian
 * @author 12S23028_Daniel Situmorang
 */
public class Driver1 {
    public static void main(String[] _args) {
        Scanner input = new Scanner(System.in);

        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Enrollment> enrollments = new ArrayList<>();

        while (true) {
            String line = input.nextLine().trim();

            if (line.equals("---")) {
                break;
            }

            String[] data = line.split("#");

            switch (data[0]) {
                case "course-add":
                    if (data.length == 5) {
                        courses.add(new Course(data[1], data[2], data[3], data[4]));
                    }
                    break;
                case "student-add":
                    if (data.length == 5) {
                        students.add(new Student(data[1], data[2], data[3], data[4]));
                    }
                    break;
                case "enrollment-add":
                    if (data.length == 5) {
                        enrollments.add(new Enrollment(data[1], data[2], data[3], data[4]));
                    }
                    break;
                default:
                    System.out.println("Error: Perintah tidak dikenali.");
            }
        }

        input.close();

        courses.sort(Comparator.comparing(Course::getKodeMataKuliah));
        students.sort(Comparator.comparing(Student::getId));
        enrollments.sort(Comparator.comparing(Enrollment::getCourseId));

        for (Course course : courses) {
            System.out.println(course.toString());
        }
        for (Student student : students) {
            System.out.println(student.toString());
        }
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment.toString());
        }
    }
}
