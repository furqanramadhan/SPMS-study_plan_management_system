import java.util.ArrayList;

public class KRSManager implements IManagementKRS, IKRSApproval, ISubmitKRS {
    private static ArrayList<KRS> listKRS = new ArrayList<KRS>();

    public KRSManager() {
        // Constructor
    }
    
    public int countTotalSKS(Mahasiswa mhs) {
        int totalSKS = 0;
        for (KRS krs : listKRS) {
            // Check if the KRS belongs to the specified Mahasiswa
            if (krs.getMahasiswa().getNpm().equals(mhs.getNpm())) {
                // Iterate through MataKuliah in the KRS and sum up the SKS
                for (MataKuliah mk : krs.getMataKuliah()) {
                    totalSKS += mk.getSks();
                }
            }
        }
        return totalSKS;
    }

    public int getTotalSKSSemester(Mahasiswa mhs, int semester) {
        int totalSKS = 0;
        for (KRS krs : listKRS) {
            // Check if the KRS belongs to the specified Mahasiswa and semester
            if (krs.getMahasiswa().getNpm().equals(mhs.getNpm()) && krs.getSemester() == semester) {
                for (MataKuliah mk : krs.getMataKuliah()) {
                    totalSKS += mk.getSks();
                }
            }
        }
        return totalSKS;
    }

    // Implementation of IManagementKRS
    @Override
    public ArrayList<KRS> getKRS(Mahasiswa mahasiswa) {
        ArrayList<KRS> result = new ArrayList<>();
        for (KRS krs : listKRS) {
            if (krs.getMahasiswa().getNpm().equals(mahasiswa.getNpm())) {
                result.add(krs);
            }
        }
        return result;
    }

    @Override
    public void updateKRS(KRS krs) {
        for (int i = 0; i < listKRS.size(); i++) {
            if (listKRS.get(i).getMahasiswa().getNpm().equals(krs.getMahasiswa().getNpm()) &&
                listKRS.get(i).getSemester() == krs.getSemester()) {
                listKRS.set(i, krs); // Update the existing KRS
                return;
            }
        }
        listKRS.add(krs); // Add new KRS if not found
    }

    // Implementation of IKRSApproval
    @Override
    public ArrayList<KRS> getPengajuan(ArrayList<Mahasiswa> mahasiswaList) {
        ArrayList<KRS> result = new ArrayList<>();
        for (Mahasiswa mahasiswa : mahasiswaList) {
            for (KRS krs : listKRS) {
                if (krs.getMahasiswa().getNpm().equals(mahasiswa.getNpm()) && !krs.getStatusKRS()) {
                    result.add(krs); // Add pending KRS
                }
            }
        }
        return result;
    }

    @Override
    public void acceptPengajuan(KRS krs) {
        for (KRS krsItem : listKRS) {
            if (krsItem.getMahasiswa().getNpm().equals(krs.getMahasiswa().getNpm()) &&
                krsItem.getSemester() == krs.getSemester()) {
                krsItem.setApproved(true); // Assuming KRS has an `approved` field
            }
        }
    }
    @Override
    public void rejectPengajuan(KRS krs) {
        for (KRS krsItem : listKRS) {
            if (krsItem.getMahasiswa().getNpm().equals(krs.getMahasiswa().getNpm()) &&
                krsItem.getSemester() == krs.getSemester()) {
                krsItem.setApproved(false); // Assuming KRS has an `approved` field
            }
        }
    }
    // Implementation of ISubmitKRS
    @Override
    public void ajukanKRS(Mahasiswa mahasiswa, int semester, ArrayList<MataKuliah> listMK) {
        KRS newKRS = new KRS(mahasiswa, semester);
        for (MataKuliah mk : listMK) {
            newKRS.tambahMataKuliah(mk);
        }
        updateKRS(newKRS);
        // System.out.println("KRS berhasil diajukan untuk mahasiswa: " + mahasiswa.getNama() + " (NPM: " + mahasiswa.getNpm() + ")" + " pada semester " + semester);

    }

    @Override
    public ArrayList<KRS> getKRSMahasiswa(String npm) {
        ArrayList<KRS> result = new ArrayList<>();
        for (KRS krs : listKRS) {
            if (krs.getMahasiswa().getNpm().equals(npm)) {
                result.add(krs);
            }
        }
        return result;
    }
}