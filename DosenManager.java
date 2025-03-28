import java.util.ArrayList;

public class DosenManager implements IManagementDosen{
    private ArrayList<Dosen> listDosen = new ArrayList<Dosen>();

    @Override
    public ArrayList<Dosen> getListDosen(){
        return listDosen;
    }

    @Override
    public void updateDosen(Dosen dosen){
        // TODO: Implement this method
    }

    @Override
    public void deleteDosen(String nip){
        // TODO: Implement this method
    }

    @Override
    public void addDosen(String nip, String nama, char jenisKelamin){
        // TODO: Implement this method
    }
}