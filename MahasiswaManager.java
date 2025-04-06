import java.util.ArrayList;
import java.util.Date;

public class MahasiswaManager implements IManagementMahasiswa{
    private static ArrayList<Mahasiswa> listMahasiswa = new ArrayList<Mahasiswa>();

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
        for (int i = 0; i < listMahasiswa.size(); i++) {
            if (listMahasiswa.get(i).getNpm().equals(mahasiswa.getNpm())) {
                listMahasiswa.set(i, mahasiswa);
                break;
            }
        }
    }

    @Override
    public void deleteMahasiswa(String npm){
        for (int i = 0; i < listMahasiswa.size(); i++) {
            if (listMahasiswa.get(i).getNpm().equals(npm)) {
                listMahasiswa.remove(i);
                break;
            }
        }
    }

    @Override
    public void addMahasiswa(String npm, String nama, char jenisKelamin, Date tanggalMasuk){
        Mahasiswa mahasiswa = new Mahasiswa(npm, nama, jenisKelamin, tanggalMasuk);
        listMahasiswa.add(mahasiswa);
    }
}