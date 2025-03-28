import java.util.ArrayList;
import java.util.Date;

public class MahasiswaManager implements IManagementMahasiswa{
    private ArrayList<Mahasiswa> listMahasiswa = new ArrayList<Mahasiswa>();

    public Mahasiswa getMahasiswa(String npm){
        for (Mahasiswa mahasiswa : listMahasiswa) {
            if (mahasiswa.getNpm().equals(npm)) {
                return mahasiswa;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Mahasiswa> getListMahasiswa(){
        return listMahasiswa;
    }

    @Override
    public void updateMahasiswa(Mahasiswa mahasiswa){
        // TODO: Implement this method
    }

    @Override
    public void deleteMahasiswa(String npm){
        // TODO: Implement this method
    }

    @Override
    public void addMahasiswa(String npm, String nama, char jenisKelamin, Date tanggalMasuk){
        // TODO: Implement this method
    }
}