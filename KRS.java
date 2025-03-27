import java.util.ArrayList;
import MataKuliah.MataKuliah;
import Mahasiswa;

public class KRS{
    private Mahasiswa mahasiswa;
    private ArrayList<MataKuliah> mataKuliah;
    private int semester;

    public KRS(Mahasiswa mahasiswa, int semester){
        this.mahasiswa = mahasiswa;
    }

    public void tambahMataKuliah(MataKuliah mk){
        mataKuliah.add(mk);
    }

    public void hapusMataKuliah(int index){
        mataKuliah.remove(index);
    }

    public void toString(){
        System.out.println("KRS Mahasiswa");
        System.out.println("NIM: " + mahasiswa.getNim());
        System.out.println("Nama: " + mahasiswa.getNama());
        System.out.println("Mata Kuliah yang diambil:");
        for(int i = 0; i < jumlahMK; i++){
            System.out.println(mataKuliah[i].getKodeMK() + " - " + mataKuliah[i].getNamaMK());
        }
    }
}