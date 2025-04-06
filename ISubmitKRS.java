import java.util.ArrayList;

interface ISubmitKRS {
    public void ajukanKRS(Mahasiswa mahasiswa, int semester, ArrayList<MataKuliah> listMK);
    public ArrayList<KRS> getKRSMahasiswa(String npm);
}