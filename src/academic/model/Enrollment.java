package academic.model;

/**
 * @author 12S23009_Dina Marlina Siagian
 * @author 12S23028_Daniel Situmorang
 */
public class Enrollment {

    private final String kodeMataKuliah;
    private final String nimMahasiswa;
    private final String tahunAjaran;
    private final String semester;
    private String nilai;

    public Enrollment(String kodeMataKuliah, String nimMahasiswa, String tahunAjaran, String semester) {
        this.kodeMataKuliah = kodeMataKuliah.trim();
        this.nimMahasiswa = nimMahasiswa.trim();
        this.tahunAjaran = tahunAjaran.trim();
        this.semester = semester.trim();
        this.nilai = "None";
    }

    public String getKodeMataKuliah() {
        return kodeMataKuliah;
    }

    public String getNimMahasiswa() {
        return nimMahasiswa;
    }

    public String getTahunAjaran() {
        return tahunAjaran;
    }

    public String getSemester() {
        return semester;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai.trim();
    }

    @Override
    public String toString() {
        return kodeMataKuliah + "|" + nimMahasiswa + "|" + tahunAjaran + "|" + semester + "|" + nilai;
    }
}
