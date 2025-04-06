import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class AdminManager implements IAdmin {
    private IManagementMK managementMK = new MataKuliahManager();
    private IManagementMahasiswa managementMahasiswa = new MahasiswaManager();
    private IManagementDosen managementDosen = new DosenManager();
    private IManagementPerwalian managementPerwalian = new PerwalianManager();

    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        while (true) {
            System.out.println("=====================");
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

            System.out.print("Pilih menu: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (pilihan) {
                case 1:
                    try {
                        if (this.getListMahasiswa() == null || this.getListMahasiswa().isEmpty()) {
                            throw new NullPointerException();
                        }

                        System.out.println("=====================");
                        System.out.println("Daftar Mahasiswa");
                        System.out.println("=====================");
                        for (Mahasiswa mahasiswa : this.getListMahasiswa()) {
                            System.out.println(mahasiswa.toString());
                        }
                    } catch (NullPointerException e) {
                        System.out.println("=====================");
                        System.out.println("Data Mahasiswa Kosong");
                    }
                    break;
                case 2:
                    try {
                        if (this.getListDosen() == null || this.getListDosen().isEmpty()) {
                            throw new NullPointerException();
                        }

                        System.out.println("=====================");
                        System.out.println("Daftar Dosen");
                        System.out.println("=====================");
                        for (Dosen dosen : this.getListDosen()) {
                            System.out.println(dosen);
                        }
                    } catch (NullPointerException e) {
                        System.out.println("=====================");
                        System.out.println("Data Dosen Kosong");
                    }
                    break;
                case 3:
                    try {
                        if (this.getListMK() == null || this.getListMK().isEmpty()) {
                            throw new NullPointerException();
                        }

                        System.out.println("=====================");
                        System.out.println("Daftar Mata Kuliah");
                        System.out.println("=====================");
                        for (MataKuliah mataKuliah : this.getListMK()) {
                            System.out.println(mataKuliah);
                        }
                    } catch (NullPointerException e) {
                        System.out.println("=====================");
                        System.out.println("Data Mata Kuliah Kosong");
                    }
                    break;
                case 4:
                    try {
                        if (this.getListAllPerwalian() == null || this.getListAllPerwalian().isEmpty()) {
                            throw new NullPointerException();
                        }

                        System.out.println("=====================");
                        System.out.println("Daftar Perwalian");
                        System.out.println("=====================");
                        for (Entry<String, Dosen> entry : this.getListAllPerwalian().entrySet()) {
                            System.out.println(entry.getKey() + " - " + entry.getValue());
                        }
                    } catch (NullPointerException e) {
                        System.out.println("=====================");
                        System.out.println("Data Perwalian Kosong");
                    }
                    break;

                case 5:
                    System.out.print("NPM: ");
                    String npm = scanner.nextLine();
                    System.out.print("Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Jenis Kelamin (L/P): ");
                    char jenisKelamin = scanner.nextLine().charAt(0);
                    System.out.print("Tanggal Masuk (dd/MM/yyyy): ");
                    String tanggalMasukStr = scanner.nextLine();

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date tanggalMasuk = null;
                    try {
                        tanggalMasuk = dateFormat.parse(tanggalMasukStr);
                    } catch (ParseException e) {
                        System.out.println("Format tanggal salah. Gunakan dd/MM/yyyy");
                        e.printStackTrace();
                    }

                    managementMahasiswa.addMahasiswa(npm, nama, jenisKelamin, tanggalMasuk);
                    break;

                case 19:
                    System.out.println("Keluar dari menu admin.");
                    return;
                default:
                    break;
            }
        }
    }

    @Override
    public ArrayList<MataKuliah> getListMK() {
        return managementMK.getListMK();
    };

    @Override
    public void updateMK(MataKuliah mataKuliah) {
        // TODO: Implement this method
    };

    @Override
    public void deleteMK(String kodeMK) {
        // TODO: Implement this method
    };

    @Override
    public void updateKRS(KRS krs) {
        // TODO: Implement this method
    };

    @Override
    public KRS getKRS(Mahasiswa mahasiswa) {
        // TODO: Implement this method
        return null;
    };

    @Override
    public void addMK(String kodeMK, String namaMK, String kelasMK, String dosen, String ruang, String hari, Date waktu,
            int sks) {
        // TODO: Implement this method
    }

    @Override
    public ArrayList<Dosen> getListDosen() {
        return managementDosen.getListDosen();
    }

    @Override
    public void updateDosen(Dosen dosen) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateDosen'");
    }

    @Override
    public void deleteDosen(String nip) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteDosen'");
    }

    @Override
    public void addDosen(String nip, String nama, char jenisKelamin, Date tanggalMasuk) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addDosen'");
    }

    @Override
    public ArrayList<Mahasiswa> getListMahasiswa() {
        return managementMahasiswa.getListMahasiswa();
    }

    @Override
    public void updateMahasiswa(Mahasiswa mahasiswa) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateMahasiswa'");
    }

    @Override
    public void deleteMahasiswa(String npm) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteMahasiswa'");
    }

    @Override
    public void addMahasiswa(String npm, String nama, char jenisKelamin, Date tanggalMasuk) {
        try {
            managementMahasiswa.addMahasiswa(npm, nama, jenisKelamin, tanggalMasuk);
        } catch (Exception e) {
            System.out.println("Gagal menambahkan mahasiswa: " + e.getMessage());
        }
    }

    @Override
    public Map<String, Dosen> getListAllPerwalian() {
        return managementPerwalian.getListAllPerwalian();
    }

    @Override
    public void updatePerwalian(Map<Mahasiswa, Dosen> perwalian) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePerwalian'");
    }

    @Override
    public void deletePerwalian(String npm, String kodeMK) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePerwalian'");
    }

    @Override
    public void addPerwalian(String npm, String kodeMK, String kelasMK, String dosen, String ruang, String hari,
            Date waktu, int sks) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addPerwalian'");
    };

}