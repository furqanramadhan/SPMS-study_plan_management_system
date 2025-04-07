import java.util.ArrayList;

interface IMahasiswa {
    public ArrayList<MataKuliah> getMataKuliah();
    public ArrayList<KRS> getKRS();
    public void ajukanKRS(int semester, ArrayList<MataKuliah> listMK);    
}