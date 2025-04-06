import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

interface IAdmin {
    // Matakuliah Manager
    public ArrayList<MataKuliah> getListMK();
    public void updateMK(MataKuliah mataKuliah);
    public void deleteMK(String kodeMK);
    public void addMK(String kodeMK, String namaMK, String kelasMK, String dosen, String ruang, String hari, Date waktu, int sks);

    // KRS Manager
    public KRS getKRS(Mahasiswa mahasiswa);
    public void updateKRS(KRS krs);

    // Dosen Manager
    public ArrayList<Dosen> getListDosen();
    public void updateDosen(Dosen dosen);
    public void deleteDosen(String nip);
    public void addDosen(String nip, String nama, char jenisKelamin, Date tanggalMasuk);

    // Mahasiswa Manager
    public ArrayList<Mahasiswa> getListMahasiswa();
    public void updateMahasiswa(Mahasiswa mahasiswa);
    public void deleteMahasiswa(String npm);
    public void addMahasiswa(String npm, String nama, char jenisKelamin, Date tanggalMasuk);

    // Perwalian Manager
    public Map<String, Dosen> getListAllPerwalian();
    public void updatePerwalian(Map<Mahasiswa, Dosen> perwalian);
    public void deletePerwalian(String npm, String kodeMK);
    public void addPerwalian(String npm, String kodeMK, String kelasMK, String dosen, String ruang, String hari, Date waktu, int sks);
}