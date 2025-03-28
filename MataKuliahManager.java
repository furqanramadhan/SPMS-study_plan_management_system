import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class MataKuliahManager implements IListMK, IUpdatePeserta{
    private Map<String, MataKuliah> listMK;

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
}