public class Matkomlan extends MataKuliah {

    public Matkomlan() {
        super("Matkomlan");
    }

    @Override
    public double hitungNilaiAkhir() {
        nilaiAkhir = (tugas * 0.25) + (kuis * 0.10) + (uts * 0.30) + (uas * 0.35);
        return nilaiAkhir;
    }
}
