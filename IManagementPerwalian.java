import java.util.Map;

interface IManagementPerwalian {
    public Map<Mahasiswa, Dosen> getListAllPerwalian();
    public void updatePerwalian(Mahasiswa mahasiswa, Dosen dosen);
    public void deletePerwalian(Mahasiswa mahasiswa);
    public void addPerwalian(Mahasiswa mahasiswa, Dosen dosen);
}