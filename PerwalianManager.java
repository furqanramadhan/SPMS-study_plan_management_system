import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class PerwalianManager implements IListPerwalian, IManagementPerwalian {
    private Map<String, Dosen> listPerwalian = new HashMap<String, Dosen>();
    IManagementMahasiswa mahasiswaManager = new MahasiswaManager();

    @Override
    public ArrayList<Mahasiswa> getListPerwalian(Dosen dosen){
        ArrayList<Mahasiswa> result = new ArrayList<Mahasiswa>();
        
        for (Map.Entry<String, Dosen> entry : listPerwalian.entrySet()) {
            if (entry.getValue().equals(dosen)) {
                Mahasiswa mahasiswa = mahasiswaManager.getMahasiswa(entry.getKey());
                result.add(mahasiswa);
            }
        }

        return result;
    }

    @Override
    public Map<Mahasiswa, Dosen> getListAllPerwalian(){
        Map<Mahasiswa, Dosen> result = new HashMap<Mahasiswa, Dosen>();
        
        for (Map.Entry<String, Dosen> entry : listPerwalian.entrySet()) {
            Mahasiswa mahasiswa = mahasiswaManager.getMahasiswa(entry.getKey());
            result.put(mahasiswa, entry.getValue());
        }

        return result;
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