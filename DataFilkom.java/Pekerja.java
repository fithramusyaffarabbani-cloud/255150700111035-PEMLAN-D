import java.time.LocalDate;
import java.time.Period;

public class Pekerja extends Manusia {
    protected double gaji; // protected agar bisa diakses Manager
    private LocalDate tahunMasuk;
    private int jumlahAnak;

    public Pekerja(double gaji, int thn, int bln, int tgl, int anak, String nama, String nik, boolean jk, boolean m) {
        super(nama, nik, jk, m);
        this.gaji = gaji;
        this.tahunMasuk = LocalDate.of(thn, bln, tgl);
        this.jumlahAnak = anak;
    }

    public double getBonus() {
        int lamaBekerja = Period.between(tahunMasuk, LocalDate.now()).getYears();
        if (lamaBekerja <= 5) return 0.05 * gaji;
        if (lamaBekerja <= 10) return 0.10 * gaji;
        return 0.15 * gaji;
    }

    @Override
    public double getTunjangan() {
        return super.getTunjangan() + (jumlahAnak * 20.0);
    }

    @Override
    public double getPendapatan() {
        return gaji + getBonus() + getTunjangan();
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\ntahun masuk   : %d %d %d\njumlah anak   : %d\ngaji          : %.1f", 
            tahunMasuk.getDayOfMonth(), tahunMasuk.getMonthValue(), tahunMasuk.getYear(), 
            jumlahAnak, gaji);
    }
}
