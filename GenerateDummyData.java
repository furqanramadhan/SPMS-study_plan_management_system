import java.text.ParseException;
import java.text.SimpleDateFormat;

public class GenerateDummyData {
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
    
    public GenerateDummyData() {
        DosenManager dosenManager = new DosenManager();
        dosenManager.addDosen("1000", "Dr. John Doe", 'L');
        dosenManager.addDosen("1001", "Dr. Jane Smith", 'P');
        dosenManager.addDosen("1002", "Dr. Emily Davis", 'P');
        dosenManager.addDosen("1003", "Dr. Michael Brown", 'L');
        dosenManager.addDosen("1004", "Dr. Sarah Wilson", 'P');
        dosenManager.addDosen("1005", "Dr. David Johnson", 'L');

        // Create dummy data for Mahasiswa
        MahasiswaManager mahasiswaManager = new MahasiswaManager();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            mahasiswaManager.addMahasiswa("2022001", "Alice",'L' ,dateFormat.parse("2000-01-01"));
            mahasiswaManager.addMahasiswa("2022002", "Bob", 'L', dateFormat.parse("2000-02-02"));
            mahasiswaManager.addMahasiswa("2022003", "Charlie", 'L', dateFormat.parse("2000-03-03"));
            mahasiswaManager.addMahasiswa("2022004", "Diana", 'P', dateFormat.parse("2000-04-04"));
            mahasiswaManager.addMahasiswa("2022005", "Eve", 'P', dateFormat.parse("2000-05-05"));
            mahasiswaManager.addMahasiswa("2022006", "Frank", 'L', dateFormat.parse("2000-06-06"));
            mahasiswaManager.addMahasiswa("2022007", "Grace", 'P', dateFormat.parse("2000-07-07"));
            mahasiswaManager.addMahasiswa("2022008", "Hank", 'L', dateFormat.parse("2000-08-08"));
            mahasiswaManager.addMahasiswa("2022009", "Ivy", 'P', dateFormat.parse("2000-09-09"));
            mahasiswaManager.addMahasiswa("2022010", "Jack", 'L', dateFormat.parse("2000-10-10"));
        } catch (ParseException e) {
            System.out.println("Error parsing date: " + e.getMessage());
            e.printStackTrace();
        }

        // Create dummy data for Perwalian
        PerwalianManager perwalianManager = new PerwalianManager();
        perwalianManager.addPerwalian(mahasiswaManager.getMahasiswa("2022001"), dosenManager.getDosen("1000"));
        perwalianManager.addPerwalian(mahasiswaManager.getMahasiswa("2022002"), dosenManager.getDosen("1000"));
        perwalianManager.addPerwalian(mahasiswaManager.getMahasiswa("2022003"), dosenManager.getDosen("1001"));
        perwalianManager.addPerwalian(mahasiswaManager.getMahasiswa("2022004"), dosenManager.getDosen("1001"));

        // Create dummy data for MataKuliah

        try {
            Dosen dosen1 = dosenManager.getDosen("1000");
            Dosen dosen2 = dosenManager.getDosen("1001");
            Dosen dosen3 = dosenManager.getDosen("1002");
            Dosen dosen4 = dosenManager.getDosen("1003");
            Dosen dosen5 = dosenManager.getDosen("1004");

            MataKuliahManager mataKuliahManager = new MataKuliahManager();
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
        


    }
}
