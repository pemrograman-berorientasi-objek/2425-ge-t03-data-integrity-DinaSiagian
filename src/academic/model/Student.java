package academic.model;

/**
 * @author 12S23009_Dina Marlina Siagian
 * @author 12S23028_Daniel Situmorang
 */
public class Student {

    private final String nim;
    private final String nama;
    private final String angkatan;
    private final String prodi;

    public Student(String nim, String nama, String angkatan, String prodi) {
        this.nim = nim;
        this.nama = nama;
        this.angkatan = angkatan;
        this.prodi = prodi;
    }

    public String getNim() {
        return this.nim;
    }
    public String getNama() {
        return this.nama;
    }
    public String getAngkatan() {
        return this.angkatan;
    }
    public String getProdi() {
        return this.prodi;
    }

    @Override
    public String toString() {
        return this.nim + "|" + this.nama + "|" + this.angkatan + "|" + this.prodi;
    }
}
