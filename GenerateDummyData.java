import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class GenerateDummyData {
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
    
    public GenerateDummyData() {
        DosenManager dosenManager = new DosenManager();
        dosenManager.addDosen("0746101", "Rasudin, S.Si., M.Info. Tech.", 'L');
        dosenManager.addDosen("0746102", "Prof. Dr. Taufik Fuadi Abidin, S.Si., M.Tech.", 'L');
        dosenManager.addDosen("0746103", "Alim Misbullah, S.Si., M.S.", 'L');
        dosenManager.addDosen("0746104", "Kikye Martiwi Sukiakhy, ST., M.Kom.", 'P');
        dosenManager.addDosen("0746105", "Ir. Rahmad Dawood, S.Kom, M.Sc., IPM., ASEAN Eng., APEC Eng.", 'L');
        dosenManager.addDosen("0746106", "Dalila Husna Yunardi, B.Sc., M.Sc.", 'P');

        // Create dummy data for Mahasiswa
        MahasiswaManager mahasiswaManager = new MahasiswaManager();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            mahasiswaManager.addMahasiswa("2108107010001", "Andi Pratama", 'L', dateFormat.parse("2021-01-01"));
            mahasiswaManager.addMahasiswa("2108107010002", "Bob Alexander", 'L', dateFormat.parse("2021-02-02"));
            mahasiswaManager.addMahasiswa("2108107010003", "Charlie Wijaya", 'L', dateFormat.parse("2021-03-03"));
            mahasiswaManager.addMahasiswa("2108107010010", "Diana Putri", 'P', dateFormat.parse("2021-04-04"));
            mahasiswaManager.addMahasiswa("2108107010013", "Eve Natalia", 'P', dateFormat.parse("2021-05-05"));
            mahasiswaManager.addMahasiswa("2208107010010", "Franky Setiawan", 'L', dateFormat.parse("2022-06-06"));
            mahasiswaManager.addMahasiswa("2208107010018", "Grace Amelia", 'P', dateFormat.parse("2022-07-07"));
            mahasiswaManager.addMahasiswa("2308107010041", "Hank Jonathan", 'L', dateFormat.parse("2023-08-08"));
            mahasiswaManager.addMahasiswa("2408107010099", "Ivy Permata Sari", 'P', dateFormat.parse("2024-09-09"));
            mahasiswaManager.addMahasiswa("2508107010075", "Jack Adrian", 'L', dateFormat.parse("2025-10-10"));
        } catch (ParseException e) {
            System.out.println("Error parsing date: " + e.getMessage());
            e.printStackTrace();
        }

        // Create dummy data for Perwalian
        PerwalianManager perwalianManager = new PerwalianManager();
        perwalianManager.addPerwalian(mahasiswaManager.getMahasiswa("2108107010001"), dosenManager.getDosen("0746101"));
        perwalianManager.addPerwalian(mahasiswaManager.getMahasiswa("2108107010002"), dosenManager.getDosen("0746102"));
        perwalianManager.addPerwalian(mahasiswaManager.getMahasiswa("2108107010013"), dosenManager.getDosen("0746103"));
        perwalianManager.addPerwalian(mahasiswaManager.getMahasiswa("2208107010010"), dosenManager.getDosen("0746104"));

        // Create dummy data for MataKuliah

        MataKuliahManager mataKuliahManager = new MataKuliahManager();
        try {
            Dosen dosen1 = dosenManager.getDosen("074601");
            Dosen dosen2 = dosenManager.getDosen("074602");
            Dosen dosen3 = dosenManager.getDosen("074603");
            Dosen dosen4 = dosenManager.getDosen("074604");
            Dosen dosen5 = dosenManager.getDosen("074605");

            mataKuliahManager.addMK("INF001", "Pemrograman Dasar", "B", dosen1, "E.02.07", "Senin",
                    timeFormat.parse("08:00"), 3);
            mataKuliahManager.addMK("INF002", "Struktur Data", "A", dosen2, "D.03.02", "Selasa",
                    timeFormat.parse("14:00"), 2);
            mataKuliahManager.addMK("INF003", "Basis Data", "C", dosen3, "E.02.08", "Rabu",
                    timeFormat.parse("10:00"), 3);
            mataKuliahManager.addMK("INF004", "Jaringan Komputer", "A", dosen4, "D.03.01", "Kamis",
                    timeFormat.parse("13:00"), 2);
            mataKuliahManager.addMK("INF005", "Sistem Operasi", "B", dosen5, "E.02.09", "Jumat", timeFormat.parse("09:00"), 3);

        } catch (Exception e) {
            System.out.println("Error adding Dosen: " + e.getMessage());
        }
        // Create dummy data for KRS
        try {
            KRSManager krsManager = new KRSManager();
            Mahasiswa mhs1 = mahasiswaManager.getMahasiswa("2108107010001");
            Mahasiswa mhs2 = mahasiswaManager.getMahasiswa("2108107010002");
            Mahasiswa mhs3 = mahasiswaManager.getMahasiswa("2108107010013");

            ArrayList<MataKuliah> listMK1 = new ArrayList<>();
            listMK1.add(mataKuliahManager.getMK("INF001"));
            listMK1.add(mataKuliahManager.getMK("INF002"));
            krsManager.ajukanKRS(mhs1, 8, listMK1);
            
            ArrayList<MataKuliah> listMK2 = new ArrayList<>();
            listMK2.add(mataKuliahManager.getMK("INF003"));
            listMK2.add(mataKuliahManager.getMK("INF004"));
            krsManager.ajukanKRS(mhs2, 8, listMK2);

            ArrayList<MataKuliah> listMK3 = new ArrayList<>();
            listMK3.add(mataKuliahManager.getMK("INF005"));
            listMK3.add(mataKuliahManager.getMK("INF001"));
            krsManager.ajukanKRS(mhs3, 8, listMK3);
        } catch (Exception e) {
            System.out.println("Error adding KRS: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
