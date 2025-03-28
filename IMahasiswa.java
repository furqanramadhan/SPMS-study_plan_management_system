import java.util.LinkedList;
public interface IMahasiswa {
    // TODO: buat method dapatkan status pengajuan
    // void getStatusPengajuan(Dosen dosen);
    LinkedList<MataKuliah> getMataKuliah();
    LinkedList<KRS> getKRS();
    void ajukanKRS(int semester, LinkedList<MataKuliah> listMK);
}
