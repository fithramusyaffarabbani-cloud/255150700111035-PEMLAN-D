public class ASD extends MataKuliah {

    public ASD() {
        super("ASD");
    }

    @Override
    public double hitungNilaiAkhir() {
        nilaiAkhir = (tugas * 0.15) + (kuis * 0.20) + (uts * 0.25) + (uas * 0.40);
        return nilaiAkhir;
    }
}
