import java.util.ArrayList;
import java.util.Scanner;

public class DosenWaliManager implements IDosenWali {
    private Dosen dosen;
    private ArrayList<Mahasiswa> perwalian;
    IListPerwalian listPerwalian = new PerwalianManager();
    IKRSApproval krsApproval = new KRSManager();
    Scanner scanner = new Scanner(System.in);

    public DosenWaliManager(Dosen dosen) {
        this.dosen = dosen;
        this.perwalian = listPerwalian.getListPerwalian(dosen);
    }

    public void showMenu() {
        while (true) {
            System.out.println("======================");
            System.out.println("Menu Dosen Wali");
            System.out.println("1. Lihat Mahasiswa Perwalian");
            System.out.println("2. Lihat Pengajuan KRS");
            System.out.println("3. Terima/Tolak KRS Mahasiswa");
            System.out.println("4. Keluar");

            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (pilihan) {
                case 1:
                    System.out.println("======================");
                    System.out.println("Daftar Mahasiswa Perwalian:");
                    for (Mahasiswa mhs : perwalian) {
                        System.out.println(mhs.toString());
                    }
                    break;
                case 2:
                    System.out.println("======================");
                    System.out.println("Daftar Pengajuan KRS:");
                    ArrayList<KRS> pengajuanKRS = krsApproval.getPengajuan(perwalian);
                    if (pengajuanKRS.isEmpty()) {
                        System.out.println("Tidak ada pengajuan KRS.");
                    } else {
                        for (KRS krs : pengajuanKRS) {
                            System.out.println(krs.toString());
                        }
                    }
                    break;
                case 3:
                    System.out.println("======================");
                    System.out.println("Pilih KRS yang ingin diterima/tolak:");
                    ArrayList<KRS> krsList = krsApproval.getPengajuan(perwalian);
                    for (int i = 0; i < krsList.size(); i++) {
                        System.out.println((i + 1) + ". " + krsList.get(i).toString());
                    }
                    System.out.print("Pilih nomor KRS: ");
                    int krsIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consume newline
                    if (krsIndex < 0 || krsIndex >= krsList.size()) {
                        System.out.println("Nomor KRS tidak valid.");
                        break;
                    }
                    KRS selectedKRS = krsList.get(krsIndex);
                    System.out.println("Pilih tindakan:");
                    System.out.println("1. Terima KRS");
                    System.out.println("2. Tolak KRS");
                    System.out.print("Pilih tindakan: ");
                    int tindakan = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    if (tindakan == 1) {
                        krsApproval.acceptPengajuan(selectedKRS);
                        System.out.println("KRS diterima.");
                    } else if (tindakan == 2) {
                        krsApproval.rejectPengajuan(selectedKRS);
                        System.out.println("KRS ditolak.");
                    } else {
                        System.out.println("Tindakan tidak valid.");
                    }
                    break;
                case 4:
                    System.out.println("Keluar dari menu Dosen Wali");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    @Override
    public ArrayList<KRS> getStatusPengajuan(Dosen dosen) {
        return krsApproval.getPengajuan(perwalian);
    }
}