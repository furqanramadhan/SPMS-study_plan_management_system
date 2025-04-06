import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Date;

public class MataKuliahManager implements IListMK, IUpdatePeserta, IManagementMK{
    private static Map<String, MataKuliah> listMK;

    public MataKuliahManager(){
        listMK = new HashMap<String, MataKuliah>();
    }

    @Override
    public ArrayList<MataKuliah> getListMK(){
        ArrayList<MataKuliah> list = new ArrayList<MataKuliah>();
        for (Map.Entry<String, MataKuliah> entry : listMK.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    };

    @Override
    public void updateMKPeserta(String kodeMK, int peserta){
        if (listMK.containsKey(kodeMK)){
            MataKuliah mataKuliah = listMK.get(kodeMK);
            if (peserta == 1){
                mataKuliah.addPeserta();
            } else if (peserta == -1){
                mataKuliah.removePeserta();
            } else {
                System.out.println("Input tidak valid");
            }
        } else {
            System.out.println("Mata Kuliah tidak ditemukan");
        }
    }

    @Override
    public void updateMK(MataKuliah mataKuliah){
        if (listMK.containsKey(mataKuliah.getKodeMK())){
            listMK.put(mataKuliah.getKodeMK(), mataKuliah);
        } else {
            System.out.println("Mata Kuliah tidak ditemukan");
        }
    };

    @Override
    public void deleteMK(String kodeMK){
        if (listMK.containsKey(kodeMK)){
            listMK.remove(kodeMK);
        } else {
            System.out.println("Mata Kuliah tidak ditemukan");
        }
    };

    @Override
    public void addMK(String kodeMK, String namaMK, String kelasMK, Dosen dosen, String ruang, String hari, Date waktu, int sks){
        MataKuliah mataKuliah = new MataKuliah(kodeMK, namaMK, sks);
        mataKuliah.setKelasMK(kelasMK);
        mataKuliah.setDosen(dosen);
        mataKuliah.setRuang(ruang);
        mataKuliah.setHari(hari);
        mataKuliah.setWaktu(waktu);
        listMK.put(kodeMK, mataKuliah);
    }

    @Override
    public MataKuliah getMK(String kodeMK) {
        if (listMK.containsKey(kodeMK)){
            return listMK.get(kodeMK);
        } else {
            System.out.println("Mata Kuliah tidak ditemukan");
            return null;
        }
    };

}