import java.util.Scanner;

public class SPMS{
    // Data Manager
    private MahasiswaManager mahasiswaManager = new MahasiswaManager();
    private DosenManager dosenManager = new DosenManager();
    
    // UI Manager
    private AdminManager adminManager;
    private KRSMahasiswaManager krsMahasiswaManager;
    private DosenWaliManager dosenWaliManager;

    // Scanner
    static Scanner scanner = new Scanner(System.in);

    public void setAdminManager(AdminManager adminManager){
        this.adminManager = adminManager;
    }

    private void selectRole(){
        
        while (true) {
            System.out.println("=====================");
            System.out.println("Select your role: ");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.println("3. Dosen");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch(choice){
                case 1:
                    setAdminManager(new AdminManager());
                    adminManager.showMenu();
                    break;
                case 2:
                    System.out.print("Input NPM: ");
                    String npm = scanner.nextLine();
                    Mahasiswa mahasiswa = mahasiswaManager.getMahasiswa(npm);
                    if (mahasiswa == null) {
                        System.out.println("=====================");
                        System.out.println("Mahasiswa not found.");
                    } else {
                        krsMahasiswaManager = new KRSMahasiswaManager(mahasiswa);
                        System.out.println("=====================");
                        System.out.println("Selamat datang " + mahasiswa.getNama() + " - " + mahasiswa.getNpm());
                        krsMahasiswaManager.showMenu();
                    }
                    break;
                case 3:
                    System.out.print("Input NIP: ");
                    String nidn = scanner.nextLine();
                    Dosen dosen = dosenManager.getDosen(nidn);
                    if (dosen == null) {
                        System.out.println("=====================");
                        System.out.println("Dosen not found.");
                    } else {
                        dosenWaliManager = new DosenWaliManager(dosen);
                        System.out.println("=====================");
                        System.out.println("Selamat datang " + dosen.getNama() + " - " + dosen.getNip());
                        dosenWaliManager.showMenu();
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    public static void main(String[] args){
        // Main Program
        SPMS spms = new SPMS();
        spms.selectRole();
    }
}