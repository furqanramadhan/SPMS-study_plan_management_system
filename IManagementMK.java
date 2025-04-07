import java.util.Date;
import java.util.ArrayList;

interface IManagementMK {
    public ArrayList<MataKuliah> getListMK();
    public void updateMK(MataKuliah mataKuliah);
    public void deleteMK(String kodeMK);
    public void addMK(String kodeMK, String namaMK, String kelasMK, Dosen dosen, String ruang, String hari, Date waktu, int sks);
    public MataKuliah getMK(String kodeMK);
}