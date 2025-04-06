import java.util.ArrayList;

public class KRSManager implements IManagementKRS, IKRSApproval, ISubmitKRS {
    private ArrayList<KRS> listKRS;

    public KRSManager() {
        listKRS = new ArrayList<KRS>();
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

    @Override
    public ArrayList<KRS> getKRS(Mahasiswa mahasiswa){
        ArrayList<KRS> result = new ArrayList<KRS>();
        for (KRS krs : listKRS) {
            if(krs.getMahasiswa().getNpm().equals(mahasiswa.getNpm())){
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

    @Override
    public ArrayList<KRS> getPengajuan(ArrayList<Mahasiswa> mahasiswaList) {
        ArrayList<KRS> result = new ArrayList<>();
        for (Mahasiswa mahasiswa : mahasiswaList) {
            result.addAll(getKRS(mahasiswa)); // Reuse the getKRS method
        }
        return result;
    }

    @Override
    public void acceptPengajuan(Mahasiswa mahasiswa) {
        for (KRS krs : listKRS) {
            if (krs.getMahasiswa().getNpm().equals(mahasiswa.getNpm())) {
                krs.setApproved(true); // Assuming KRS has an `approved` field
            }
        }
    }
    @Override
    public void rejectPengajuan(Mahasiswa mahasiswa) {
        for (KRS krs : listKRS) {
            if (krs.getMahasiswa().getNpm().equals(mahasiswa.getNpm())) {
                krs.setApproved(false); // Assuming KRS has an `approved` field
            }
        }
    }
    
    @Override
    public void ajukanKRS(Mahasiswa mahasiswa, int semester, ArrayList<MataKuliah> listMK) {
        KRS newKRS = new KRS(mahasiswa, semester);
        for (MataKuliah mk : listMK) {
            newKRS.tambahMataKuliah(mk);
        }
        updateKRS(newKRS);
    }
}