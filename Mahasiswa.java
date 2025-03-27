import java.util.Calendar;
import java.util.Date;

public class Mahasiswa {
    private String npm;
    private String nama;
    private char jenisKelamin;
    private Date tanggalMasuk;

    //Constructor
    public Mahasiswa(String npm, String nama, char jenisKelamin, Date tanggalMasuk) {
        this.npm = npm;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.tanggalMasuk = tanggalMasuk;
    }

    //Method getter and setter
    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
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

    public Date getTanggalMasuk() {
        return tanggalMasuk;
    }

    public void setTanggalMasuk(Date tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }
    
    // Method untuk menghitung jumlah semester
    public int hitungSemester() {
        Calendar calNow = Calendar.getInstance();
        Calendar calMasuk = Calendar.getInstance();
        calMasuk.setTime(tanggalMasuk);
    
        int tahunSekarang = calNow.get(Calendar.YEAR);
        int tahunMasuk = calMasuk.get(Calendar.YEAR);
    
        int semester = (tahunSekarang - tahunMasuk) * 2; // 1 tahun = 2 semester
        return Math.max(semester, 1); // Minimal semester 1 jika ada kesalahan input
    }


}