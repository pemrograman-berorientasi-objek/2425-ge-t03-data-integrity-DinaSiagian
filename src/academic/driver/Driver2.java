package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.*;

/**
 * @author 12S23009_Dina Marlina Siagian
 * @author 12S23028_Daniel Situmorang
 */
public class Driver2 {
    public static void main(String[] _args) {
        Scanner input = new Scanner(System.in);

        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Enrollment> enrollments = new ArrayList<>();

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
                    boolean exists = courses.stream().anyMatch(c -> c.getNim().equals(data[1]));
                    if (!exists) {
                        courses.add(new Course(data[1], data[2], data[3], data[4]));
                    }
                }
                break;
            
            case "student-add":
                if (data.length == 5) {
                    boolean exists = students.stream().anyMatch(s -> s.getNim().equals(data[1]));
                    if (!exists) {
                        students.add(new Student(data[1], data[2], data[3], data[4]));
                    }
                }
                break;
            
                case "enrollment-add":
                    if (data.length == 5) {
                        String courseId = data[1];
                        String studentId = data[2];
                        
                        boolean courseExists = courses.stream().anyMatch(c -> c.getNim().equals(courseId));
                        boolean studentExists = students.stream().anyMatch(s -> s.getNim().equals(studentId));
                        
                        if (!courseExists) {
                            invalidEntries.append("invalid course|").append(courseId).append("\n");
                        } else if (!studentExists) {
                            invalidEntries.append("invalid student|").append(studentId).append("\n");
                        } else {
                            enrollments.add(new Enrollment(data[1], data[2], data[3], data[4]));
                        }
                    }
                    break;
                default:
                    System.out.println("Error: Perintah tidak dikenali.");
            }
        }

        input.close();
        
        System.out.print(invalidEntries.toString());
        
        courses.sort(Comparator.comparing(Course::getNim));
        students.sort(Comparator.comparing(Student::getNim));
        enrollments.sort(Comparator.comparing(Enrollment::getKodeMataKuliah));
        
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
