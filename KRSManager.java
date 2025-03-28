import java.util.ArrayList;

public class KRSManager implements IManagementKRS{
    private ArrayList<KRS> listKRS;

    public KRSManager(){
        listKRS = new ArrayList<KRS>();
    }

    public int getTotalSKS(Mahasiswa mhs){
        // TODO: Implement this method
        return 0;
    }

    public int getTotalSKSSemester(Mahasiswa mhs, int semester){
        // TODO: Implement this method
        return 0;
    }

    @Override
    public ArrayList<KRS> getKRS(Mahasiswa mahasiswa){
        ArrayList<KRS> result = new ArrayList<KRS>();
        // TODO: Implement this method
        return result;
    }

    @Override
    public void updateKRS(KRS krs){
        // TODO: Implement this method
    }
}