package academic.model;

/**
 * @author 12S23009_Dina Marlina Siagian
 * @author 12S23028_Daniel Situmorang
 */
public class Enrollment {

    private final String courseId;
    private final String studentId;
    private final String tahunAjaran;
    private final String semester;
    private String nilai;

    public Enrollment(String courseId, String studentId, String tahunAjaran, String semester) {
        this.courseId = courseId.trim();
        this.studentId = studentId.trim();
        this.tahunAjaran = tahunAjaran.trim();
        this.semester = semester.trim();
        this.nilai = "None";
    }

    public String getCourseId() {
        return courseId;
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return courseId + "|" + studentId + "|" + tahunAjaran + "|" + semester + "|" + nilai;
    }
}
