import java.util.ArrayList;

public class KRSMahasiswaManager implements IMahasiswa {
    private Mahasiswa dataMahasiswa;
    // Constructor
    public KRSMahasiswaManager(Mahasiswa mahasiswa) {
        this.dataMahasiswa = mahasiswa;
    }

    public void showMenu(){
        // TODO: Implement this method
    }

    @Override
    public ArrayList<MataKuliah> getMataKuliah(){
        ArrayList<MataKuliah> result = new ArrayList<MataKuliah>();
        // TODO: Implement this method
        return result;
    }

    @Override
    public ArrayList<KRS> getKRS(){
        ArrayList<KRS> result = new ArrayList<KRS>();
        // TODO: Implement this method
        return result;
    }

    @Override
    public void ajukanKRS(int semester, ArrayList<MataKuliah> listMK){
        // TODO: Implement this method
    }
}
