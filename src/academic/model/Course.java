package academic.model;

/**
 * @author 12S23009_Dina Marlina Siagian
 * @author 12S23028_Daniel Situmorang
 */
public class Course {

    private final String nim;
    private final String mataKuliah;
    private final String sks;
    private final String grade;

    public Course(String nim, String mataKuliah, String sks, String grade) {
        this.nim = nim;
        this.mataKuliah = mataKuliah;
        this.sks = sks;
        this.grade = grade;
    }

    public String getNim() {
        return this.nim;
    }
    public String getMataKuliah() {
        return this.mataKuliah;
    }
    public String getSks() {
        return this.sks;
    }
    public String getGrade() {
        return this.grade;
    }

    @Override 
    public String toString() {
        return this.nim + "|" + this.mataKuliah + "|" + this.sks + "|" + this.grade;
    }
}