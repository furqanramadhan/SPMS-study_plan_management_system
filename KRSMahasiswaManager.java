import java.util.ArrayList;
import java.util.Scanner;

public class KRSMahasiswaManager implements IMahasiswa {
    private Mahasiswa dataMahasiswa;
    private Scanner scanner = new Scanner(System.in);

    // Constructor
    public KRSMahasiswaManager(Mahasiswa mahasiswa) {
        this.dataMahasiswa = mahasiswa;
    }

    public void showMenu() {
        while (true) {
            System.out.println("Menu KRS Mahasiswa: ");
            System.out.println("1. Lihat KRS");
            System.out.println("2. Lihat Mata Kuliah");
            System.out.println("3. Ajukan KRS");
            System.out.println("4. Keluar");

            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    getKRS();
                    break;
                case 2:
                    getMataKuliah();
                    break;
                case 3:
                    // TODO: Implement Ajukan KRS
                    break;
                case 4:
                    System.out.println("Keluar dari menu KRS Mahasiswa.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
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
        if (dataMahasiswa == null) { // Corrected condition to check if dataMahasiswa is null
            System.out.println("Data Mahasiswa tidak tersedia.");
            return new ArrayList<>();
        } else {
            KRSManager krsManager = new KRSManager();
            ArrayList<KRS> result = krsManager.getKRS(dataMahasiswa);
            if (result.isEmpty()) {
                System.out.println("Tidak ada KRS yang ditemukan untuk mahasiswa: " + dataMahasiswa.getNama());
            } else {
                System.out.println("Daftar KRS untuk mahasiswa: " + dataMahasiswa.getNama());
                for (KRS krs : result) {
                    System.out.println("Semester: " + krs.getSemester());
                    System.out.println("Mata Kuliah: ");
                    for (MataKuliah mk : krs.getMataKuliah()) {
                        System.out.println("- " + mk.getKodeMK() + ": " + mk.getNamaMK());
                    }
                    System.out.println("------------------------------");
                }
            }
            return result;
        }
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
