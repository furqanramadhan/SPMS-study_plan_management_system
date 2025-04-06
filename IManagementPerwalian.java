import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

interface IManagementPerwalian {
    public Map<String, Dosen> getListAllPerwalian();
    public void updatePerwalian(Mahasiswa mahasiswa, Dosen dosen);
    public void deletePerwalian(Mahasiswa mahasiswa);
    public void addPerwalian(Mahasiswa mahasiswa, Dosen dosen);
}