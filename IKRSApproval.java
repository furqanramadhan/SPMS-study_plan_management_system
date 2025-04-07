import java.util.ArrayList;

interface IKRSApproval {
    public ArrayList<KRS> getPengajuan(ArrayList<Mahasiswa> mahasiswa);
    public void acceptPengajuan(KRS krs);
    public void rejectPengajuan(KRS krs);
}