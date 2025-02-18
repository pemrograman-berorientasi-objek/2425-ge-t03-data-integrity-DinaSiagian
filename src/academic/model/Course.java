package academic.model;

/**
 * @author 12S23009_Dina Marlina Siagian
 * @author 12S23028_Daniel Situmorang
 */
public class Course {

    private final String kodeMataKuliah;
    private final String mataKuliah;
    private final String sks;
    private final String grade;

    public Course(String kodeMataKuliah, String mataKuliah, String sks, String grade) {
        this.kodeMataKuliah = kodeMataKuliah;
        this.mataKuliah = mataKuliah;
        this.sks = sks;
        this.grade = grade;
    }

    public String getKodeMataKuliah() {
        return this.kodeMataKuliah;
    }

    @Override
    public String toString() {
        return this.kodeMataKuliah + "|" + this.mataKuliah + "|" + this.sks + "|" + this.grade;
    }
}
