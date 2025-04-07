import java.util.ArrayList;
import java.util.Scanner;

public class KRSMahasiswaManager implements IMahasiswa {
    private Mahasiswa dataMahasiswa;
    IListMK mataKuliahManager = new MataKuliahManager();
    ISubmitKRS krsManager = new KRSManager();
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
                    ajukanKRS(choice, getMataKuliah());
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
        ArrayList<MataKuliah> result = mataKuliahManager.getListMKMahasiswa();
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
            ArrayList<KRS> result = krsManager.getKRSMahasiswa(dataMahasiswa.getNpm());
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
    public void ajukanKRS(int semester, ArrayList<MataKuliah> availableMK) {
        if (dataMahasiswa == null) {
            System.out.println("Data Mahasiswa Tidak Tersedia.");
            return;
        }
        if (availableMK == null || availableMK.isEmpty()) {
            System.out.println("Tidak ada Mata Kuliah yang tersedia untuk diajukan.");
            return;
        }
    
        // Calculate semester
        int calculatedSemester = dataMahasiswa.hitungSemester();
    
        // Display available Mata Kuliah
        System.out.println("Daftar Mata Kuliah yang Tersedia:");
        for (MataKuliah mk : availableMK) {
            System.out.println("- " + mk.getKodeMK() + ": " + mk.getNamaMK() + " (" + mk.getSks() + " SKS)");
        }
    
        // Collect selected MataKuliah
        ArrayList<MataKuliah> selectedMK = new ArrayList<>();
        while (true) {
            System.out.println("Masukkan kode mata kuliah yang ingin diajukan (atau ketik 'selesai' untuk mengakhiri): ");
            String input = scanner.nextLine().trim();
    
            // Check if the user wants to finish
            if (input.equalsIgnoreCase("selesai")) {
                break;
            }
    
            // Validate and add MataKuliah
            boolean found = false;
            for (MataKuliah mk : availableMK) {
                if (mk.getKodeMK().equalsIgnoreCase(input)) {
                    selectedMK.add(mk);
                    found = true;
                    System.out.println("Mata Kuliah berhasil ditambahkan: " + mk.getNamaMK());
                    break;
                }
            }
    
            if (!found) {
                System.out.println("Kode MK tidak valid: " + input);
            }
        }
    
        // Check if any MataKuliah were selected
        if (selectedMK.isEmpty()) {
            System.out.println("Tidak ada Mata Kuliah yang dipilih. Silahkan coba lagi.");
            return;
        }
    
        // Create and submit KRS
        KRSManager krsManager = new KRSManager();
        KRS newKRS = new KRS(dataMahasiswa, calculatedSemester);
        for (MataKuliah mk : selectedMK) {
            newKRS.tambahMataKuliah(mk);
        }
        krsManager.updateKRS(newKRS);
    
        // Confirmation message
        System.out.println("KRS berhasil diajukan untuk mahasiswa: " + dataMahasiswa.getNama() + " - " + dataMahasiswa.getNpm() + " pada semester " + calculatedSemester);
        System.out.println("Mata Kuliah yang diajukan:");
        for (MataKuliah mk : selectedMK) {
            System.out.println("- " + mk.getKodeMK() + ": " + mk.getNamaMK() + " (" + mk.getSks() + " SKS)");
        }
        System.out.println("------------------------------");
        System.out.println("Silahkan tunggu konfirmasi dari dosen pembimbing akademik.");
    }   
}
