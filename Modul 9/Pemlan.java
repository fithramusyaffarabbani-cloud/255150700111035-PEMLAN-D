public class Pemlan extends MataKuliah {

    public Pemlan() {
        super("Pemlan");
    }

    @Override
    public double hitungNilaiAkhir() {
        nilaiAkhir = (tugas * 0.20) + (kuis * 0.15) + (uts * 0.30) + (uas * 0.35);
        return nilaiAkhir;
    }
}
