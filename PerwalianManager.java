import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class PerwalianManager implements IListPerwalian, IManagementPerwalian {
    private Map<String, Dosen> listPerwalian = new HashMap<String, Dosen>();

    @Override
    public ArrayList<String> getListPerwalian(Dosen dosen){
        ArrayList<String> result = new ArrayList<String>();
        
        for (Map.Entry<String, Dosen> entry : listPerwalian.entrySet()) {
            if (entry.getValue().equals(dosen)) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    @Override
    public Map<String, Dosen> getListAllPerwalian(){
        return listPerwalian;
    }

    @Override
    public void updatePerwalian(Mahasiswa mahasiswa, Dosen dosen){
        if (listPerwalian.containsKey(mahasiswa.getNpm())) {
            listPerwalian.put(mahasiswa.getNpm(), dosen);
        } else {
            System.out.println("Mahasiswa tidak terdaftar dalam perwalian.");
        }
    }

    @Override
    public void deletePerwalian(Mahasiswa mahasiswa){
        listPerwalian.remove(mahasiswa.getNpm());
    }

    @Override
    public void addPerwalian(Mahasiswa mahasiswa, Dosen dosen){
        listPerwalian.put(mahasiswa.getNpm(), dosen);
    }
};