import java.util.ArrayList;

interface IKRSApproval {
    public ArrayList<KRS> getPengajuan(ArrayList<Mahasiswa> mahasiswa);
    public void acceptPengajuan(Mahasiswa mahasiswa);
    public void rejectPengajuan(Mahasiswa mahasiswa);
    
    //TODO: Implements in manager.
}