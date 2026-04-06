public class Manager extends Pekerja {
    private String departemen;

    public Manager(String departemen, double gaji, int thn, int bln, int tgl, int anak, String nama, String nik, boolean jk, boolean m) {
        super(gaji, thn, bln, tgl, anak, nama, nik, jk, m);
        this.departemen = departemen;
    }

    @Override
    public double getPendapatan() {
        // Tambahan 10% gaji untuk Manager
        return super.getPendapatan() + (0.10 * gaji);
    }

    @Override
    public String toString() {
        return super.toString() + "\ndepartemen    : " + departemen;
    }
}