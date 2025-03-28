import java.util.ArrayList;

interface IManagementKRS {
    public ArrayList<KRS> getKRS(Mahasiswa mahasiswa);
    public void updateKRS(KRS krs);
}