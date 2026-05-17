import java.util.Arrays;
import java.util.Comparator;

public class FutsalTeam {

    static class Pemain {
        int no;
        int tinggiBadan; // cm
        int beratBadan;  // kg

        Pemain(int no, int tinggiBadan, int beratBadan) {
            this.no          = no;
            this.tinggiBadan = tinggiBadan;
            this.beratBadan  = beratBadan;
        }
    }

    static void cetakTabel(Pemain[] tim, String judul) {
        System.out.println("\n  " + judul);
        System.out.println("  +-----+------------------+-----------------+");
        System.out.println("  | No  | Tinggi Badan(cm) | Berat Badan(kg) |");
        System.out.println("  +-----+------------------+-----------------+");
        for (Pemain p : tim) {
            System.out.printf("  | %-3d | %-16d | %-15d |%n",
                    p.no, p.tinggiBadan, p.beratBadan);
        }
        System.out.println("  +-----+------------------+-----------------+");
    }

    static void urutkanTinggiBadan(Pemain[] tim, String namaTim) {
        Pemain[] sorted = Arrays.copyOf(tim, tim.length);

        System.out.println("\n======================================================");
        System.out.println("  [A] PENGURUTAN TINGGI BADAN -- " + namaTim);
        System.out.println("======================================================");

        Arrays.sort(sorted, Comparator.comparingInt(p -> p.tinggiBadan));
        cetakTabel(sorted, "Ascending / Menaik:");

        Arrays.sort(sorted, (p1, p2) -> Integer.compare(p2.tinggiBadan, p1.tinggiBadan));
        cetakTabel(sorted, "Descending / Menurun:");
    }

    static void urutkanBeratBadan(Pemain[] tim, String namaTim) {
        Pemain[] sorted = Arrays.copyOf(tim, tim.length);

        System.out.println("\n======================================================");
        System.out.println("  [B] PENGURUTAN BERAT BADAN -- " + namaTim);
        System.out.println("======================================================");

        Arrays.sort(sorted, Comparator.comparingInt(p -> p.beratBadan));
        cetakTabel(sorted, "Ascending / Menaik:");

        Arrays.sort(sorted, (p1, p2) -> Integer.compare(p2.beratBadan, p1.beratBadan));
        cetakTabel(sorted, "Descending / Menurun:");
    }

    static void cariMinMax(Pemain[] tim, String namaTim) {
        System.out.println("\n======================================================");
        System.out.println("  [C] NILAI MAKSIMUM & MINIMUM -- " + namaTim);
        System.out.println("======================================================");

        Pemain maxTinggi = tim[0], minTinggi = tim[0];
        Pemain maxBerat  = tim[0], minBerat  = tim[0];

        for (Pemain p : tim) {
            if (p.tinggiBadan > maxTinggi.tinggiBadan) maxTinggi = p;
            if (p.tinggiBadan < minTinggi.tinggiBadan) minTinggi = p;
            if (p.beratBadan  > maxBerat.beratBadan)   maxBerat  = p;
            if (p.beratBadan  < minBerat.beratBadan)   minBerat  = p;
        }

        System.out.println("\n  +------------------------------+---------+------------+");
        System.out.println("  | Keterangan                   | Nilai   | No. Pemain |");
        System.out.println("  +------------------------------+---------+------------+");
        System.out.printf ("  | Tinggi Badan Maksimum        | %3d cm  |     %-4d   |%n", maxTinggi.tinggiBadan, maxTinggi.no);
        System.out.printf ("  | Tinggi Badan Minimum         | %3d cm  |     %-4d   |%n", minTinggi.tinggiBadan, minTinggi.no);
        System.out.printf ("  | Berat Badan Maksimum         |  %2d kg  |     %-4d   |%n", maxBerat.beratBadan,  maxBerat.no);
        System.out.printf ("  | Berat Badan Minimum          |  %2d kg  |     %-4d   |%n", minBerat.beratBadan,  minBerat.no);
        System.out.println("  +------------------------------+---------+------------+");
    }

    static Pemain[] copyTimBkeTimC(Pemain[] timB) {
        Pemain[] timC = new Pemain[timB.length];
        for (int i = 0; i < timB.length; i++) {
            // Deep copy: setiap elemen adalah objek baru
            timC[i] = new Pemain(timB[i].no, timB[i].tinggiBadan, timB[i].beratBadan);
        }
        return timC;
    }

    public static void main(String[] args) {

        Pemain[] timA = {
            new Pemain(1,  168, 50),
            new Pemain(2,  170, 60),
            new Pemain(3,  165, 56),
            new Pemain(4,  168, 55),
            new Pemain(5,  172, 60),
            new Pemain(6,  170, 70),
            new Pemain(7,  169, 66),
            new Pemain(8,  165, 56),
            new Pemain(9,  171, 72),
            new Pemain(10, 166, 56)
        };

        Pemain[] timB = {
            new Pemain(1,  170, 66),
            new Pemain(2,  167, 60),
            new Pemain(3,  165, 59),
            new Pemain(4,  166, 58),
            new Pemain(5,  168, 58),
            new Pemain(6,  175, 71),
            new Pemain(7,  172, 68),
            new Pemain(8,  171, 68),
            new Pemain(9,  168, 65),
            new Pemain(10, 169, 60)
        };

        System.out.println("======================================================");
        System.out.println("       PROGRAM DATA ANGGOTA TIM FUTSAL               ");
        System.out.println("======================================================");

        cetakTabel(timA, "DATA AWAL TIM A:");
        cetakTabel(timB, "DATA AWAL TIM B:");

        urutkanTinggiBadan(timA, "TIM A");
        urutkanTinggiBadan(timB, "TIM B");

        urutkanBeratBadan(timA, "TIM A");
        urutkanBeratBadan(timB, "TIM B");

        cariMinMax(timA, "TIM A");
        cariMinMax(timB, "TIM B");

        System.out.println("\n======================================================");
        System.out.println("  [D] COPY TIM B -> TIM C (Tim Baru)");
        System.out.println("======================================================");

        Pemain[] timC = copyTimBkeTimC(timB);
        cetakTabel(timC, "DATA TIM C (salinan lengkap dari Tim B):");

        System.out.println("\n  [Verifikasi Deep Copy]");
        System.out.println("  Mengubah TB pemain No.1 Tim C menjadi 999...");
        timC[0].tinggiBadan = 999;
        System.out.printf("  Tim B No.1 TB = %d cm  --> tidak berubah (OK)%n", timB[0].tinggiBadan);
        System.out.printf("  Tim C No.1 TB = %d cm  --> berhasil diubah (OK)%n", timC[0].tinggiBadan);

        System.out.println("\n======================================================");
        System.out.println("                  PROGRAM SELESAI                    ");
        System.out.println("======================================================");
    }
}