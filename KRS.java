import java.util.ArrayList;

public class KRS{
    private Mahasiswa mahasiswa;
    private ArrayList<MataKuliah> mataKuliah;
    private int semester;
    private boolean status;

    public KRS(Mahasiswa mahasiswa, int semester) {
        this.mahasiswa = mahasiswa;
    }
    
    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public ArrayList<MataKuliah> getMataKuliah() {
        return mataKuliah;
    }

    public int getSemester() {
        return semester;
    } 

    public void tambahMataKuliah(MataKuliah mk){
        mataKuliah.add(mk);
    }

    public void hapusMataKuliah(int index) {
        mataKuliah.remove(index);
    }
    
    public boolean getStatusKRS() {
        return status;
    }

    public void setApproved(boolean status) {
        this.status = status;
    }

    public String toString(){
        return "KRS Mahasiswa " + mahasiswa.getNpm() + " " + mahasiswa.getNama() + " Semester " + semester;
    }
}