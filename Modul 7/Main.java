public class Main {
    public static void main(String[] args) {

        Kue[] daftarKue = new Kue[20];

        daftarKue[0]  = new KuePesanan("Kue Ulang Tahun", 150000, 1.5);
        daftarKue[1]  = new KuePesanan("Kue Pernikahan",  300000, 3.0);
        daftarKue[2]  = new KuePesanan("Kue Brownies",     80000, 0.5);
        daftarKue[3]  = new KuePesanan("Kue Lapis",        50000, 1.0);
        daftarKue[4]  = new KuePesanan("Kue Bolu",         60000, 0.8);
        daftarKue[5]  = new KuePesanan("Kue Cheesecake",  120000, 1.2);
        daftarKue[6]  = new KuePesanan("Kue Red Velvet",  200000, 2.0);
        daftarKue[7]  = new KuePesanan("Kue Tiramisu",    180000, 1.8);
        daftarKue[8]  = new KuePesanan("Kue Pandan",       70000, 0.9);
        daftarKue[9]  = new KuePesanan("Kue Marble",       90000, 1.1);
        daftarKue[10] = new KueJadi("Donat",               5000,  10);
        daftarKue[11] = new KueJadi("Croissant",          15000,   5);
        daftarKue[12] = new KueJadi("Muffin Coklat",      12000,   8);
        daftarKue[13] = new KueJadi("Eclair",             10000,   6);
        daftarKue[14] = new KueJadi("Macaron",            20000,   4);
        daftarKue[15] = new KueJadi("Bolu Kukus",          8000,  12);
        daftarKue[16] = new KueJadi("Nastar",              3000,  20);
        daftarKue[17] = new KueJadi("Putri Salju",         3500,  15);
        daftarKue[18] = new KueJadi("Kastengel",           4000,  18);
        daftarKue[19] = new KueJadi("Soes",                6000,   9);

        System.out.println("===== DAFTAR SEMUA KUE =====");
        for (Kue k : daftarKue) {
            System.out.println(k);
        }

        double totalSemua = 0;
        for (Kue k : daftarKue) {
            totalSemua += k.hitungHarga();
        }
        System.out.println("\n===== TOTAL HARGA SEMUA KUE =====");
        System.out.printf("Total: Rp %.2f%n", totalSemua);

        double totalHargaPesanan = 0;
        double totalBerat = 0;
        for (Kue k : daftarKue) {
            if (k instanceof KuePesanan) {
                KuePesanan kp = (KuePesanan) k;
                totalHargaPesanan += kp.hitungHarga();
                totalBerat += kp.getBerat();
            }
        }
        System.out.println("\n===== TOTAL KUE PESANAN =====");
        System.out.printf("Total Harga : Rp %.2f%n", totalHargaPesanan);
        System.out.printf("Total Berat : %.2f kg%n", totalBerat);

        double totalHargaJadi = 0;
        double totalJumlah = 0;
        for (Kue k : daftarKue) {
            if (k instanceof KueJadi) {
                KueJadi kj = (KueJadi) k;
                totalHargaJadi += kj.hitungHarga();
                totalJumlah += kj.getJumlah();
            }
        }
        System.out.println("\n===== TOTAL KUE JADI =====");
        System.out.printf("Total Harga  : Rp %.2f%n", totalHargaJadi);
        System.out.printf("Total Jumlah : %.0f pcs%n", totalJumlah);

        Kue kueTermahal = daftarKue[0];
        for (int i = 1; i < daftarKue.length; i++) {
            if (daftarKue[i].hitungHarga() > kueTermahal.hitungHarga()) {
                kueTermahal = daftarKue[i];
            }
        }
        System.out.println("\n===== KUE DENGAN HARGA TERBESAR =====");
        System.out.println(kueTermahal);
        System.out.printf("Harga Akhir : Rp %.2f%n", kueTermahal.hitungHarga());
    }
}