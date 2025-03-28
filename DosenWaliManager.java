import java.util.ArrayList;

public class DosenWaliManager implements IDosenWali {
    private Dosen dosen;
    private ArrayList<Mahasiswa> perwalian;

    public DosenWaliManager(Dosen dosen, ArrayList<Mahasiswa> perwalian) {
        this.dosen = dosen;
        this.perwalian = perwalian;
    }

    @Override
    public ArrayList<KRS> getStatusPengajuan(Dosen dosen){
        ArrayList<KRS> result = new ArrayList<KRS>();
        // TODO: Implement this method
        return result;
    }
}