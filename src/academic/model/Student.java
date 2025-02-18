package academic.model;

/**
 * @author 12S23009_Dina Marlina Siagian
 * @author 12S23028_Daniel Situmorang
 */
public class Student {

    private final String id;
    private final String nama;
    private final String angkatan;
    private final String prodi;

    public Student(String id, String nama, String angkatan, String prodi) {
        this.id = id;
        this.nama = nama;
        this.angkatan = angkatan;
        this.prodi = prodi;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return this.id + "|" + this.nama + "|" + this.angkatan + "|" + this.prodi;
    }
}
