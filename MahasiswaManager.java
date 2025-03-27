public class MahasiswaManager {
    private Mahasiswa dataMahasiswa;

    // Constructor
    public MahasiswaManager(Mahasiswa mahasiswa) {
        this.dataMahasiswa = mahasiswa;
    }

    // Getter and Setter
    public Mahasiswa getMahasiswa() {
        return dataMahasiswa;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.dataMahasiswa = mahasiswa;
    }
}
