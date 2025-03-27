public class Dosen {
    private String nip;
    private String nama;
    private char jenisKelamin;

    //Constructor
    public Dosen(String nip, String nama, char jenisKelamin) {
        this.nip = nip;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
    }

    // Getter dan Setter
    public String getNip() {
        return nip;
    }

    public void setNpm(String nip) {
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public char getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(char jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
}