import java.util.Date;

public class MataKuliah {
    private String kodeMK;
    private String namaMK;
    private String kelasMK;
    private Dosen dosen;
    private String ruang;
    private String hari;
    private Date waktu;
    private int sks;
    private int peserta;

    public MataKuliah(String kodeMK, String namaMK, int sks){
        this.kodeMK = kodeMK;
        this.namaMK = namaMK;
        this.sks = sks;
        this.peserta = 0;
    }

    public void setKodeMK(String kodeMK){
        this.kodeMK = kodeMK;
    }

    public void setNamaMK(String namaMK){
        this.namaMK = namaMK;
    }

    public void setKelasMK(String kelasMK){
        this.kelasMK = kelasMK;
    }

    public void setDosen(Dosen dosen){
        this.dosen = dosen;
    }

    public void setRuang(String ruang){
        this.ruang = ruang;
    }

    public void setHari(String hari){
        this.hari = hari;
    }

    public void setWaktu(Date waktu){
        this.waktu = waktu;
    }

    public void setSks(int sks){
        this.sks = sks;
    }

    public String getKodeMK(){
        return kodeMK;
    }

    public String getNamaMK(){
        return namaMK;
    }

    public String getKelasMK(){
        return kelasMK;
    }

    public Dosen getDosen(){
        return dosen;
    }

    public String getRuang(){
        return ruang;
    }

    public String getHari(){
        return hari;
    }

    public Date getWaktu(){
        return waktu;
    }

    public int getSks(){
        return sks;
    }

    public int getPeserta(){
        return peserta;
    }

    public void addPeserta(){
        this.peserta++;
    }
    
    public void removePeserta(){
        this.peserta--;
    }

    public String toString(){
        return "Kode Mata Kuliah: " + kodeMK + "\n" +
               "Nama Mata Kuliah: " + namaMK + "\n" +
               "Kelas Mata Kuliah: " + kelasMK + "\n" +
               "Dosen: " + dosen + "\n" +
               "Ruang: " + ruang + "\n" +
               "Hari: " + hari + "\n" +
               "Waktu: " + waktu + "\n" +
               "SKS: " + sks + "\n";
    }
}