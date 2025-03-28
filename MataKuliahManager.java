import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Date;

public class MataKuliahManager implements IListMK, IUpdatePeserta, IManagementMK{
    static Map<String, MataKuliah> listMK;

    public MataKuliahManager(){
        listMK = new HashMap<String, MataKuliah>();
    }

    @Override
    public ArrayList<MataKuliah> getListMK(){
        ArrayList<MataKuliah> result = new ArrayList<MataKuliah>();
        // TODO: Implement this method
        return result;
    };

    @Override
    public void updateMKPeserta(String kodeMK){
        // TODO: Implement this method
    }

    @Override
    public void updateMK(MataKuliah mataKuliah){
        // TODO: Implement this method
    };

    @Override
    public void deleteMK(String kodeMK){
        // TODO: Implement this method
    };

    @Override
    public void addMK(String kodeMK, String namaMK, String kelasMK, String dosen, String ruang, String hari, Date waktu, int sks){
        // TODO: Implement this method
    };

}