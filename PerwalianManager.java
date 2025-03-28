import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class PerwalianManager implements IListPerwalian, IManagementPerwalian {
    private Map<Mahasiswa, Dosen> listPerwalian = new HashMap<Mahasiswa, Dosen>();

    @Override
    public ArrayList<Mahasiswa> getListPerwalian(Dosen dosen){
        ArrayList<Mahasiswa> result = new ArrayList<Mahasiswa>();
        // TODO: Implement this method
        return result;
    }

    @Override
    public Map<Mahasiswa, Dosen> getListperwalian(){
        return listPerwalian;
    }

    @Override
    public void updatePerwalian(Mahasiswa mahasiswa, Dosen dosen){
        // TODO: Implement this method
    }

    @Override
    public void deletePerwalian(Mahasiswa mahasiswa){
        // TODO: Implement this method
    }

    @Override
    public void addPerwalian(Mahasiswa mahasiswa, Dosen dosen){
        // TODO: Implement this method
    }
};