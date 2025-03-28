import java.util.ArrayList;
import java.util.Date;

public class AdminManager implements IAdmin{
    private IManagementMK managementMK = new MataKuliahManager();
    private IManagementMahasiswa managementMahasiswa = new MahasiswaManager();
    private IManagementDosen managementDosen = new DosenManager();
    private IManagementPerwalian managementPerwalian = new PerwalianManager();

    public void showMenu(){
        System.out.println("1. Lihat Daftar Mahasiswa");
        System.out.println("2. Lihat Daftar Dosen");
        System.out.println("3. Lihat Daftar Mata Kuliah");
        System.out.println("4. Lihat Perwalian");

        System.out.println("5. Tambah Mahasiswa");
        System.out.println("6. Update Mahasiswa");
        System.out.println("7. Hapus Mahasiswa");

        System.out.println("8. Tambah Dosen");
        System.out.println("9. Update Dosen");
        System.out.println("10. Hapus Dosen");        
        
        System.out.println("11. Tambah Mata Kuliah");
        System.out.println("12. Update Mata Kuliah");
        System.out.println("13. Hapus Mata Kuliah");    

        System.out.println("14. Tambah Perwalian");
        System.out.println("15. Update Perwalian");
        System.out.println("16. Hapus Perwalian");    

        System.out.println("17. Update KRS");
        System.out.println("18. Lihat KRS");
        System.out.println("19. Keluar");
    }

    @Override
    public ArrayList<MataKuliah> getListMK(){
        return managementMK.getListMK();
    };

    @Override
    public void updateMK(MataKuliah mataKuliah){
        // TODO: Implement this method
    };

    @Override
    public void deleteMK(String kodeMK){
        // TODO: Implement this method
    };

    @Override
    public void updateKRS(KRS krs){
        // TODO: Implement this method
    };

    @Override
    public KRS getKRS(Mahasiswa mahasiswa){
        // TODO: Implement this method
        return null;
    };

    @Override
    public void addMK(String kodeMK, String namaMK, String kelasMK, String dosen, String ruang, String hari, Date waktu, int sks){
        // TODO: Implement this method
    };

}