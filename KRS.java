import java.util.ArrayList;

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

    public String toString(){
        return "KRS Mahasiswa " + mahasiswa.getNpm() + " " + mahasiswa.getNama() + " Semester " + semester;
    }
}