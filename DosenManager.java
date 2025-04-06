import java.util.ArrayList;

public class DosenManager implements IManagementDosen{
    private ArrayList<Dosen> listDosen = new ArrayList<Dosen>();

    @Override
    public ArrayList<Dosen> getListDosen(){
        return listDosen;
    }

    @Override
    public void updateDosen(Dosen dosen){
        for (int i = 0; i < listDosen.size(); i++) {
            if (listDosen.get(i).getNip().equals(dosen.getNip())) {
                listDosen.set(i, dosen);
                break;
            }
        }
    }

    @Override
    public void deleteDosen(String nip){
        for (int i = 0; i < listDosen.size(); i++) {
            if (listDosen.get(i).getNip().equals(nip)) {
                listDosen.remove(i);
                break;
            }
        }
    }

    @Override
    public void addDosen(String nip, String nama, char jenisKelamin){
        Dosen dosen = new Dosen(nip, nama, jenisKelamin);
        listDosen.add(dosen);
    }
}