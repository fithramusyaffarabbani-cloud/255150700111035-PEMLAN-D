public class Probstat extends MataKuliah {

    public Probstat() {
        super("Probstat");
    }

    @Override
    public double hitungNilaiAkhir() {
        nilaiAkhir = (tugas * 0.10) + (kuis * 0.20) + (uts * 0.35) + (uas * 0.35);
        return nilaiAkhir;
    }
}
