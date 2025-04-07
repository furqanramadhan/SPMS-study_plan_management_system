import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private IManagementKRS managementKRS = new KRSManager();

    private Scanner scanner = new Scanner(System.in);

    private SystemUtils utils = new SystemUtils();

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

            utils.clearConsole();
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
                    } catch (Exception e) {
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
                        for (Entry<Mahasiswa, Dosen> entry : this.getListAllPerwalian().entrySet()) {
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

                case 6:
                    System.out.print("NPM: ");
                    String npmUpdate = scanner.nextLine();
                    Mahasiswa mahasiswaUpdate = managementMahasiswa.getMahasiswa(npmUpdate);
                    if (mahasiswaUpdate != null) {
                        System.out.print("Nama: ");
                        String namaUpdate = scanner.nextLine();
                        System.out.print("Jenis Kelamin (L/P): ");
                        char jenisKelaminUpdate = scanner.nextLine().charAt(0);
                        System.out.print("Tanggal Masuk (dd/MM/yyyy): ");
                        String tanggalMasukStrUpdate = scanner.nextLine();

                        SimpleDateFormat dateFormatUpdate = new SimpleDateFormat("dd/MM/yyyy");
                        Date tanggalMasukUpdate = null;
                        try {
                            tanggalMasukUpdate = dateFormatUpdate.parse(tanggalMasukStrUpdate);
                        } catch (ParseException e) {
                            System.out.println("Format tanggal salah. Gunakan dd/MM/yyyy");
                            tanggalMasukUpdate = mahasiswaUpdate.getTanggalMasuk();
                            e.printStackTrace();
                        }

                        mahasiswaUpdate.setNama(namaUpdate);
                        mahasiswaUpdate.setJenisKelamin(jenisKelaminUpdate);
                        mahasiswaUpdate.setTanggalMasuk(tanggalMasukUpdate);

                        managementMahasiswa.updateMahasiswa(mahasiswaUpdate);
                    } else {
                        System.out.println("Mahasiswa tidak ditemukan.");
                    }
                    break;

                case 7:
                    System.out.print("NPM: ");
                    String npmDelete = scanner.nextLine();
                    Mahasiswa mahasiswaDelete = managementMahasiswa.getMahasiswa(npmDelete);
                    if (mahasiswaDelete != null) {
                        managementMahasiswa.deleteMahasiswa(npmDelete);
                        System.out.println("Mahasiswa dengan NPM " + npmDelete + " telah dihapus.");
                    } else {
                        System.out.println("Mahasiswa tidak ditemukan.");
                    }
                    break;
                case 8:
                    System.out.print("NIP: ");
                    String nip = scanner.nextLine();
                    System.out.print("Nama: ");
                    String namaDosen = scanner.nextLine();
                    System.out.print("Jenis Kelamin (L/P): ");
                    char jenisKelaminDosen = scanner.nextLine().charAt(0);

                    managementDosen.addDosen(nip, namaDosen, jenisKelaminDosen);
                    break;
                case 9:
                    System.out.print("NIP: ");
                    String nipUpdate = scanner.nextLine();
                    Dosen dosenUpdate = managementDosen.getDosen(nipUpdate);
                    if (dosenUpdate != null) {
                        System.out.print("Nama: ");
                        String namaDosenUpdate = scanner.nextLine();
                        System.out.print("Jenis Kelamin (L/P): ");
                        char jenisKelaminDosenUpdate = scanner.nextLine().charAt(0);

                        dosenUpdate.setNama(namaDosenUpdate);
                        dosenUpdate.setJenisKelamin(jenisKelaminDosenUpdate);

                        managementDosen.updateDosen(dosenUpdate);
                    } else {
                        System.out.println("Dosen tidak ditemukan.");
                    }
                    break;
                case 10:
                    System.out.print("NIP: ");
                    String nipDelete = scanner.nextLine();
                    Dosen dosenDelete = managementDosen.getDosen(nipDelete);
                    if (dosenDelete != null) {
                        managementDosen.deleteDosen(nipDelete);
                        System.out.println("Dosen dengan NIP " + nipDelete + " telah dihapus.");
                    } else {
                        System.out.println("Dosen tidak ditemukan.");
                    }
                    break;
                case 11:
                    System.out.print("Kode MK: ");
                    String kodeMK = scanner.nextLine();
                    System.out.print("Nama MK: ");
                    String namaMK = scanner.nextLine();
                    System.out.print("Kelas MK: ");
                    String kelasMK = scanner.nextLine();
                    System.out.print("NIP Dosen: ");
                    String nipDosen = scanner.nextLine();
                    Dosen dosen = managementDosen.getDosen(nipDosen);
                    if (dosen == null) {
                        System.out.println("Dosen tidak ditemukan.");
                        break;
                    }
                    System.out.print("Ruang: ");
                    String ruang = scanner.nextLine();
                    System.out.print("Hari: ");
                    String hari = scanner.nextLine();
                    System.out.print("Waktu (HH:mm): ");
                    String waktuStr = scanner.nextLine();

                    SimpleDateFormat dateFormatMK = new SimpleDateFormat("HH:mm");
                    Date waktuMK = null;
                    try {
                        waktuMK = dateFormatMK.parse(waktuStr);
                    } catch (ParseException e) {
                        System.out.println("Format tanggal salah. Gunakan dd/MM/yyyy");
                        e.printStackTrace();
                    }
                    System.out.print("SKS: ");
                    int sks = scanner.nextInt();

                    managementMK.addMK(kodeMK, namaMK, kelasMK, dosen, ruang, hari, waktuMK, sks);
                    break;

                case 12:
                    System.out.print("Kode MK: ");
                    String kodeMKUpdate = scanner.nextLine();
                    MataKuliah mataKuliahUpdate = managementMK.getMK(kodeMKUpdate);
                    if (mataKuliahUpdate != null) {
                        System.out.print("Nama MK: ");
                        String namaMKUpdate = scanner.nextLine();
                        System.out.print("Kelas MK: ");
                        String kelasMKUpdate = scanner.nextLine();
                        System.out.print("NIP Dosen: ");
                        String nipDosenUpdate = scanner.nextLine();
                        Dosen dosenNew = managementDosen.getDosen(nipDosenUpdate);
                        if (dosenNew == null) {
                            System.out.println("Dosen tidak ditemukan.");
                            break;
                        }
                        System.out.print("Ruang: ");
                        String ruangUpdate = scanner.nextLine();
                        System.out.print("Hari: ");
                        String hariUpdate = scanner.nextLine();
                        System.out.print("Waktu (HH:mm): ");
                        String waktuStrUpdate = scanner.nextLine();

                        SimpleDateFormat dateFormatMKUpdate = new SimpleDateFormat("HH:mm");
                        Date waktuMKUpdate = null;
                        try {
                            waktuMKUpdate = dateFormatMKUpdate.parse(waktuStrUpdate);
                        } catch (ParseException e) {
                            System.out.println("Format tanggal salah. Gunakan dd/MM/yyyy");
                            e.printStackTrace();
                        }
                        System.out.print("SKS: ");
                        int sksUpdate = scanner.nextInt();

                        mataKuliahUpdate.setNamaMK(namaMKUpdate);
                        mataKuliahUpdate.setKelasMK(kelasMKUpdate);
                        mataKuliahUpdate.setDosen(dosenNew);
                        mataKuliahUpdate.setRuang(ruangUpdate);
                        mataKuliahUpdate.setHari(hariUpdate);
                        mataKuliahUpdate.setWaktu(waktuMKUpdate);
                        mataKuliahUpdate.setSks(sksUpdate);

                        managementMK.updateMK(mataKuliahUpdate);
                    } else {
                        System.out.println("Mata Kuliah tidak ditemukan.");
                    }
                    break;

                case 13:
                    System.out.print("Kode MK: ");
                    String kodeMKDelete = scanner.nextLine();
                    MataKuliah mataKuliahDelete = managementMK.getMK(kodeMKDelete);
                    if (mataKuliahDelete != null) {
                        managementMK.deleteMK(kodeMKDelete);
                        System.out.println("Mata Kuliah dengan Kode MK " + kodeMKDelete + " telah dihapus.");
                    } else {
                        System.out.println("Mata Kuliah tidak ditemukan.");
                    }
                    break;

                case 14:
                    System.out.print("NPM Mahasiswa: ");
                    String npmPerwalian = scanner.nextLine();
                    Mahasiswa mahasiswaPerwalian = managementMahasiswa.getMahasiswa(npmPerwalian);
                    if (mahasiswaPerwalian == null) {
                        System.out.println("Mahasiswa tidak ditemukan.");
                        break;
                    }
                    System.out.print("NIP Dosen: ");
                    String nipPerwalian = scanner.nextLine();
                    Dosen dosenPerwalian = managementDosen.getDosen(nipPerwalian);
                    if (dosenPerwalian == null) {
                        System.out.println("Dosen tidak ditemukan.");
                        break;
                    }
                    managementPerwalian.addPerwalian(mahasiswaPerwalian, dosenPerwalian);
                    break;

                case 15:
                    System.out.print("NPM Mahasiswa: ");
                    String npmPerwalianUpdate = scanner.nextLine();
                    Mahasiswa mahasiswaPerwalianUpdate = managementMahasiswa.getMahasiswa(npmPerwalianUpdate);
                    if (mahasiswaPerwalianUpdate == null) {
                        System.out.println("Mahasiswa tidak ditemukan.");
                        break;
                    }
                    System.out.print("NIP Dosen: ");
                    String nipPerwalianUpdate = scanner.nextLine();
                    Dosen dosenPerwalianUpdate = managementDosen.getDosen(nipPerwalianUpdate);
                    if (dosenPerwalianUpdate == null) {
                        System.out.println("Dosen tidak ditemukan.");
                        break;
                    }
                    managementPerwalian.updatePerwalian(mahasiswaPerwalianUpdate, dosenPerwalianUpdate);
                    break;
                case 16:
                    System.out.print("NPM Mahasiswa: ");
                    String npmPerwalianDelete = scanner.nextLine();
                    Mahasiswa mahasiswaPerwalianDelete = managementMahasiswa.getMahasiswa(npmPerwalianDelete);
                    if (mahasiswaPerwalianDelete == null) {
                        System.out.println("Mahasiswa tidak ditemukan.");
                        break;
                    }
                    managementPerwalian.deletePerwalian(mahasiswaPerwalianDelete);
                    break;
                case 17:
                    System.out.print("NPM Mahasiswa: ");
                    String npmKRS = scanner.nextLine();
                    Mahasiswa mahasiswaKRS = managementMahasiswa.getMahasiswa(npmKRS);
                    if (mahasiswaKRS == null) {
                        System.out.println("Mahasiswa tidak ditemukan.");
                        break;
                    }
                    
                    ArrayList<KRS> krsList = managementKRS.getKRS(mahasiswaKRS);
                    if (krsList == null || krsList.isEmpty()) {
                        System.out.println("KRS tidak ditemukan.");
                        break;
                    }
                    System.out.println("Daftar KRS untuk Mahasiswa " + mahasiswaKRS.getNama() + ":");
                    for (KRS krs : krsList) {
                        System.out.println(krs.toString());
                    }

                    System.out.print("Pilih Semester KRS yang ingin diupdate: ");
                    int semesterKRS = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    KRS krsToUpdate = null;
                    for (KRS krs : krsList) {
                        if (krs.getSemester() == semesterKRS) {
                            krsToUpdate = krs;
                            break;
                        }
                    }
                    if (krsToUpdate == null) {
                        System.out.println("KRS untuk semester " + semesterKRS + " tidak ditemukan.");
                        break;
                    }

                    System.out.println("KRS untuk semester " + semesterKRS + ":");
                    System.out.println(krsToUpdate.toString());

                    System.out.println("1. Tambah Mata Kuliah");
                    System.out.println("2. Hapus Mata Kuliah");
                    System.out.print("Pilih opsi: ");
                    int opsiKRS = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (opsiKRS == 1) {
                        System.out.print("Kode MK: ");
                        String kodeMKKRS = scanner.nextLine();
                        MataKuliah mataKuliahKRS = managementMK.getMK(kodeMKKRS);
                        if (mataKuliahKRS == null) {
                            System.out.println("Mata Kuliah tidak ditemukan.");
                            break;
                        }
                        krsToUpdate.tambahMataKuliah(mataKuliahKRS);
                        System.out.println("Mata Kuliah " + mataKuliahKRS.getNamaMK() + " telah ditambahkan ke KRS.");
                    } else if (opsiKRS == 2) {
                        System.out.print("Index Mata Kuliah yang ingin dihapus: ");
                        int index = scanner.nextInt();
                        krsToUpdate.hapusMataKuliah(index);
                        System.out.println("Mata Kuliah pada index " + index + " telah dihapus dari KRS.");
                    } else {
                        System.out.println("Opsi tidak valid.");
                    }   
                    break;
                
                    case 18:
                    System.out.print("NPM Mahasiswa: ");
                    String npmKRSView = scanner.nextLine();
                    Mahasiswa mahasiswaKRSView = managementMahasiswa.getMahasiswa(npmKRSView);
                    if (mahasiswaKRSView == null) {
                        System.out.println("Mahasiswa tidak ditemukan.");
                        break;
                    }
                    ArrayList<KRS> krsListView = managementKRS.getKRS(mahasiswaKRSView);
                    if (krsListView == null || krsListView.isEmpty()) {
                        System.out.println("KRS tidak ditemukan.");
                        break;
                    }
                    System.out.println("Daftar KRS untuk Mahasiswa " + mahasiswaKRSView.getNama() + ":");
                    for (KRS krs : krsListView) {
                        System.out.println(krs.toString());
                    }
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
        try {
            managementMK.updateMK(mataKuliah);
        } catch (NullPointerException e) {
            System.out.println("Data Mata Kuliah Kosong");
        } catch (IllegalArgumentException e) {
            System.out.println("Data Mata Kuliah tidak valid");
        } catch (Exception e) {
            System.out.println("Gagal mengupdate mata kuliah: " + e.getMessage());
        }
    };

    @Override
    public void deleteMK(String kodeMK) {
        try {
            managementMK.deleteMK(kodeMK);
        } catch (NullPointerException e) {
            System.out.println("Data Mata Kuliah Kosong");
        } catch (IllegalArgumentException e) {
            System.out.println("Data Mata Kuliah tidak valid");
        } catch (Exception e) {
            System.out.println("Gagal menghapus mata kuliah: " + e.getMessage());
        }
    };

    @Override
    public void updateKRS(KRS krs) {
        try {
            managementKRS.updateKRS(krs);
        } catch (NullPointerException e) {
            System.out.println("Data KRS Kosong");
        } catch (IllegalArgumentException e) {
            System.out.println("Data KRS tidak valid");
        } catch (Exception e) {
            System.out.println("Gagal mengupdate KRS: " + e.getMessage());
        }
    };

    @Override
    public ArrayList<KRS> getKRS(Mahasiswa mahasiswa) {
        try {
            return managementKRS.getKRS(mahasiswa);
        } catch (NullPointerException e) {
            System.out.println("Data KRS Kosong");
        } catch (IllegalArgumentException e) {
            System.out.println("Data KRS tidak valid");
        } catch (Exception e) {
            System.out.println("Gagal mendapatkan KRS: " + e.getMessage());
        }
        return null;
    };

    @Override
    public void addMK(String kodeMK, String namaMK, String kelasMK, Dosen dosen, String ruang, String hari, Date waktu,
            int sks) {
        try {
            managementMK.addMK(kodeMK, namaMK, kelasMK, dosen, ruang, hari, waktu, sks);
        } catch (NullPointerException e) {
            System.out.println("Data Mata Kuliah Kosong");
        } catch (IllegalArgumentException e) {
            System.out.println("Data Mata Kuliah tidak valid");
        } catch (Exception e) {
            System.out.println("Gagal menambahkan mata kuliah: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Dosen> getListDosen() {
        return managementDosen.getListDosen();
    }

    @Override
    public void updateDosen(Dosen dosen) {
        try {
            managementDosen.updateDosen(dosen);
        } catch (NullPointerException e) {
            System.out.println("Data Dosen Kosong");
        } catch (IllegalArgumentException e) {
            System.out.println("Data Dosen tidak valid");
        } catch (Exception e) {
            System.out.println("Gagal mengupdate dosen: " + e.getMessage());
        }
    }

    @Override
    public void deleteDosen(String nip) {
        try {
            managementDosen.deleteDosen(nip);
        } catch (NullPointerException e) {
            System.out.println("Data Dosen Kosong");
        } catch (IllegalArgumentException e) {
            System.out.println("Data Dosen tidak valid");
        } catch (Exception e) {
            System.out.println("Gagal menghapus dosen: " + e.getMessage());
        }
    }

    @Override
    public void addDosen(String nip, String nama, char jenisKelamin) {
        try {
            managementDosen.addDosen(nip, nama, jenisKelamin);
        } catch (NullPointerException e) {
            System.out.println("Data Dosen Kosong");
        } catch (IllegalArgumentException e) {
            System.out.println("Data Dosen tidak valid");
        } catch (Exception e) {
            System.out.println("Gagal menambahkan dosen: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Mahasiswa> getListMahasiswa() {
        return managementMahasiswa.getListMahasiswa();
    }

    @Override
    public void updateMahasiswa(Mahasiswa mahasiswa) {
        try {
            managementMahasiswa.updateMahasiswa(mahasiswa);
        } catch (NullPointerException e) {
            System.out.println("Data Mahasiswa Kosong");
        } catch (IllegalArgumentException e) {
            System.out.println("Data Mahasiswa tidak valid");
        } catch (Exception e) {
            System.out.println("Gagal mengupdate mahasiswa: " + e.getMessage());
        }
    }

    @Override
    public void deleteMahasiswa(String npm) {
        try {
            managementMahasiswa.deleteMahasiswa(npm);
        } catch (NullPointerException e) {
            System.out.println("Data Mahasiswa Kosong");
        } catch (IllegalArgumentException e) {
            System.out.println("Data Mahasiswa tidak valid");
        } catch (Exception e) {
            System.out.println("Gagal menghapus mahasiswa: " + e.getMessage());
        }
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
    public Map<Mahasiswa, Dosen> getListAllPerwalian() {
        return managementPerwalian.getListAllPerwalian();
    }

    @Override
    public void updatePerwalian(Mahasiswa mahasiswa, Dosen dosen) {
        try {
            managementPerwalian.updatePerwalian(mahasiswa, dosen);
        } catch (Exception e) {
            System.out.println("Gagal mengupdate perwalian: " + e.getMessage());
        }
    }

    @Override
    public void deletePerwalian(Mahasiswa mahasiswa) {
        try {
            managementPerwalian.deletePerwalian(mahasiswa);
        } catch (Exception e) {
            System.out.println("Gagal menghapus perwalian: " + e.getMessage());
        }
    }

    @Override
    public void addPerwalian(Mahasiswa mahasiswa, Dosen dosen) {
        try {
            managementPerwalian.addPerwalian(mahasiswa, dosen);
        } catch (Exception e) {
            System.out.println("Gagal menambahkan perwalian: " + e.getMessage());
        }
    };

}