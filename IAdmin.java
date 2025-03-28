import java.util.ArrayList;
import java.util.Date;

interface IAdmin {
    public ArrayList<MataKuliah> getListMK();
    public void updateMK(MataKuliah mataKuliah);
    public void deleteMK(String kodeMK);
    public void updateKRS(KRS krs);
    public KRS getKRS(Mahasiswa mahasiswa);
    public void addMK(String kodeMK, String namaMK, String kelasMK, String dosen, String ruang, String hari, Date waktu, int sks);
}