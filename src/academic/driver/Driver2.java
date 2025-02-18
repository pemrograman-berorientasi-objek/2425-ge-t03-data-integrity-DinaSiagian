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
            if (data.length < 2) {
                System.out.println("Error: Perintah tidak lengkap.");
                continue;
            }

            switch (data[0]) {
                case "course-add":
                    if (data.length == 5) {
                        courses.add(new Course(data[1], data[2], data[3], data[4]));
                    } else {
                        System.out.println("Error: Format course-add salah.");
                    }
                    break;
                case "student-add":
                    if (data.length == 5) {
                        students.add(new Student(data[1], data[2], data[3], data[4]));
                    } else {
                        System.out.println("Error: Format student-add salah.");
                    }
                    break;
                case "enrollment-add":
                    if (data.length == 5) {
                        String courseId = data[1];
                        String studentId = data[2];

                        boolean courseExists = courses.stream().anyMatch(c -> c.getKodeMataKuliah().equals(courseId));
                        boolean studentExists = students.stream().anyMatch(s -> s.getId().equals(studentId));

                        if (!courseExists || !studentExists) {
                            invalidEntries.append("invalid ");
                            if (!courseExists) invalidEntries.append("course|").append(courseId).append(" ");
                            if (!studentExists) invalidEntries.append("student|").append(studentId);
                            invalidEntries.append("\n");
                        } else {
                            enrollments.add(new Enrollment(courseId, studentId, data[3], data[4]));
                        }
                    } else {
                        System.out.println("Error: Format enrollment-add salah.");
                    }
                    break;
                default:
                    System.out.println("Error: Perintah tidak dikenali.");
            }
        }

        input.close();

        if (invalidEntries.length() > 0) {
            System.out.print(invalidEntries.toString());
        }

        courses.sort(Comparator.comparing(Course::getKodeMataKuliah));
        students.sort(Comparator.comparing(Student::getId));
        enrollments.sort(Comparator.comparing(Enrollment::getCourseId));

        courses.forEach(System.out::println);
        students.forEach(System.out::println);
        enrollments.forEach(System.out::println);
    }
}
