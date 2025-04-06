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
        MataKuliahManager mataKuliahManager = new MataKuliahManager();
        ArrayList<MataKuliah> result = mataKuliahManager.getListMK();
        if (result.isEmpty()) {
            System.out.println("Tidak ada daftar mata kuliah yang tersedia.");
        } else {
            System.out.println("Daftar Mata Kuliah yang Tersedia: ");
            for (MataKuliah mk : result) {
                System.out.println("Kode MK: " + mk.getKodeMK());
                System.out.println("Nama MK: " + mk.getNamaMK());
                System.out.println("Kelas MK: " + mk.getKelasMK());
                System.out.println("Dosen: " + mk.getDosen());
                System.out.println("Ruang: " + mk.getRuang());
                System.out.println("Hari: " + mk.getHari());
                System.out.println("Waktu: " + mk.getWaktu());
                System.out.println("SKS: " + mk.getSks());
                System.out.println("------------------------------");
            }
        }
        return result;
    }

    @Override
    public ArrayList<KRS> getKRS() {
        ArrayList<KRS> result = new ArrayList<KRS>();
        return result;
    }

    @Override
    public void ajukanKRS(int semester, ArrayList<MataKuliah> listMK) {
        // TODO: Implement this method
        if (listMK == null || listMK.isEmpty()) {
            System.out.println("Daftar Mata Kuliah tidak boleh kosong. Silakan pilih mata kuliah yang ingin diajukan.");
            return;
        } else {
            // Confirmation message with mahasiswa details
            System.out.println("KRS berhasil diajukan untuk mahasiswa: " + dataMahasiswa.getNama() + " (NPM: "
                    + dataMahasiswa.getNpm() + ") pada semester " + semester);
            System.out.println("Mata Kuliah yang diajukan:");
            System.out.println("KRS untuk semester " + semester + " telah diajukan dengan kode dan mata kuliah:");
            for (MataKuliah mk : listMK) {
                System.out.println("- " + mk.getKodeMK() + ": " + mk.getNamaMK());
            }
        }
    }
}
