import java.util.ArrayList;
import java.util.Date;

interface IManagementMahasiswa{
    public ArrayList<Mahasiswa> getListMahasiswa();
    public void updateMahasiswa(Mahasiswa mahasiswa);
    public void deleteMahasiswa(String npm);
    public void addMahasiswa(String npm, String nama, char jenisKelamin, Date tanggalMasuk);
    public Mahasiswa getMahasiswa(String npm);
}