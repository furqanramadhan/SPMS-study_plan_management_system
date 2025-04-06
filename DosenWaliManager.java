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
                    // TODO: Implement method to view KRS
                    break;
                case 3:
                    // TODO: Implement method to accept/reject KRS
                    break;
                case 5:
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