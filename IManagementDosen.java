import java.util.ArrayList;

interface IManagementDosen{
    public ArrayList<Dosen> getListDosen();
    public void updateDosen(Dosen dosen);
    public void deleteDosen(String nip);
    public void addDosen(String nip, String nama, char jenisKelamin);
    public Dosen getDosen(String nip);
}