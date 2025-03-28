import java.util.ArrayList;
import java.util.Date;

public class AdminManager implements IAdmin{

    @Override
    public ArrayList<MataKuliah> getListMK(){
        ArrayList<MataKuliah> result = new ArrayList<MataKuliah>();
        // TODO: Implement this method
        return result;
    };

    @Override
    public void updateMK(MataKuliah mataKuliah){
        // TODO: Implement this method
    };

    @Override
    public void deleteMK(String kodeMK){
        // TODO: Implement this method
    };

    @Override
    public void updateKRS(KRS krs){
        // TODO: Implement this method
    };

    @Override
    public KRS getKRS(Mahasiswa mahasiswa){
        // TODO: Implement this method
        return null;
    };

    @Override
    public void addMK(String kodeMK, String namaMK, String kelasMK, String dosen, String ruang, String hari, Date waktu, int sks){
        // TODO: Implement this method
    };

}