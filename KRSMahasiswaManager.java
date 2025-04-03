import java.util.ArrayList;

public class KRSMahasiswaManager implements IMahasiswa {
    private Mahasiswa dataMahasiswa;

    // Constructor
    public KRSMahasiswaManager(Mahasiswa mahasiswa) {
        this.dataMahasiswa = mahasiswa;
    }

    public void showMenu() {
        System.out.println("Menu KRS Mahasiswa: ");
        System.out.println("1. Lihat KRS");
        System.out.println("2. Lihat Mata Kuliah");
        System.out.println("3. Ajukan KRS");
    }

    @Override
    public ArrayList<MataKuliah> getMataKuliah() {
        ArrayList<MataKuliah> result = new ArrayList<MataKuliah>();
        // Return the list of MataKuliah associated with this Mahasiswa
        return result;
    }

    @Override
    public ArrayList<KRS> getKRS() {
        ArrayList<KRS> result = new ArrayList<KRS>();
        // Return the list of KRS submitted by this Mahasiswa
        return result;
    }

    // @Override
    // public void ajukanKRS(int semester, ArrayList<MataKuliah> listMK) {
    //     // TODO: Implement this method
    //     if (listMK == null || listMK.isEmpty()) {
    //         System.out.println("Daftar Mata Kuliah tidak boleh kosong. Silakan pilih mata kuliah yang ingin diajukan.");
    //         return;
    //     } else {
    //         // Confirmation message with mahasiswa details
    //         System.out.println("KRS berhasil diajukan untuk mahasiswa: " + dataMahasiswa.getNama() +" (NPM: " + dataMahasiswa.getNpm() + ") pada semester " + semester);
    //         System.out.println("Mata Kuliah yang diajukan:");
    //         System.out.println("KRS untuk semester " + semester + " telah diajukan dengan kode dan mata kuliah:");
    //         for (MataKuliah mk : listMK) {
    //             System.out.println("- " + mk.getKodeMK() + ": " + mk.getNamaMK());
    //         }
    //     }
    // }

    @Override
    public void ajukanKRS(int semester, ArrayList<MataKuliah> listMK) {
        if (listMK == null || listMK.isEmpty()) {
            System.out.println("Daftar Mata Kuliah tidak boleh kosong.");
            return;
        }
    
        // Create a new KRS object
        KRS newKRS = new KRS(dataMahasiswa, semester);
        for (MataKuliah mk : listMK) {
            newKRS.tambahMataKuliah(mk);
        }
    
        // // Add the new KRS to the list
        // krsList.add(newKRS);
    
        // Confirmation message
        System.out.println("KRS berhasil diajukan untuk mahasiswa: " + dataMahasiswa.getNama() +
                           " (NPM: " + dataMahasiswa.getNpm() + ") pada semester " + semester);
        System.out.println("Mata Kuliah yang diajukan:");
        for (MataKuliah mk : listMK) {
            System.out.println("- " + mk.getKodeMK() + ": " + mk.getNamaMK());
        }
    }
}
