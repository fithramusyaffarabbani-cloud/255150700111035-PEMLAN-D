import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BinarySearchFutsal {
    static class Pemain {
        int no;
        int tinggiBadan;
        int beratBadan;

        Pemain(int no, int tinggiBadan, int beratBadan) {
            this.no          = no;
            this.tinggiBadan = tinggiBadan;
            this.beratBadan  = beratBadan;
        }
    }

    static void cetakTabel(ArrayList<Pemain> tim, String judul) {
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

    static int binarySearchTinggi(ArrayList<Pemain> tim, int target) {
        ArrayList<Pemain> sorted = new ArrayList<>(tim);
        sorted.sort(Comparator.comparingInt(p -> p.tinggiBadan));

        int lo = 0, hi = sorted.size() - 1;
        int indexDitemukan = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int nilai = sorted.get(mid).tinggiBadan;

            if (nilai == target) {
                indexDitemukan = mid;
                break;
            } else if (nilai < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        if (indexDitemukan == -1) return 0; // tidak ditemukan

        int count = 1;
        int kiri  = indexDitemukan - 1;
        int kanan = indexDitemukan + 1;

        while (kiri >= 0 && sorted.get(kiri).tinggiBadan == target) {
            count++;
            kiri--;
        }
        while (kanan < sorted.size() && sorted.get(kanan).tinggiBadan == target) {
            count++;
            kanan++;
        }

        return count;
    }

    static int binarySearchBerat(ArrayList<Pemain> tim, int target) {
        ArrayList<Pemain> sorted = new ArrayList<>(tim);
        sorted.sort(Comparator.comparingInt(p -> p.beratBadan));

        int lo = 0, hi = sorted.size() - 1;
        int indexDitemukan = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int nilai = sorted.get(mid).beratBadan;

            if (nilai == target) {
                indexDitemukan = mid;
                break;
            } else if (nilai < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        if (indexDitemukan == -1) return 0;

        int count = 1;
        int kiri  = indexDitemukan - 1;
        int kanan = indexDitemukan + 1;

        while (kiri >= 0 && sorted.get(kiri).beratBadan == target) {
            count++;
            kiri--;
        }
        while (kanan < sorted.size() && sorted.get(kanan).beratBadan == target) {
            count++;
            kanan++;
        }

        return count;
    }

    static void cekKesamaanAB(ArrayList<Pemain> timA, ArrayList<Pemain> timB) {
        System.out.println("\n======================================================");
        System.out.println("  [D] CEK KESAMAAN TIM A vs TIM B");
        System.out.println("======================================================");

        ArrayList<Integer> tinggiB = new ArrayList<>();
        ArrayList<Integer> beratB  = new ArrayList<>();
        for (Pemain p : timB) {
            tinggiB.add(p.tinggiBadan);
            beratB.add(p.beratBadan);
        }
        Collections.sort(tinggiB);
        Collections.sort(beratB);

        System.out.println("\n  -- Pemain Tim A dengan Tinggi Badan sama dengan Tim B --");
        System.out.println("  +-----+------------------+----------------------------+");
        System.out.println("  | No  | Tinggi Badan(cm) | Status                     |");
        System.out.println("  +-----+------------------+----------------------------+");
        boolean adaSamaTinggi = false;
        for (Pemain a : timA) {
            // Binary Search nilai tinggi badan pemain A di dalam list tinggiB
            int lo = 0, hi = tinggiB.size() - 1;
            boolean ketemu = false;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (tinggiB.get(mid) == a.tinggiBadan) { ketemu = true; break; }
                else if (tinggiB.get(mid) < a.tinggiBadan) lo = mid + 1;
                else hi = mid - 1;
            }
            if (ketemu) {
                System.out.printf("  | %-3d | %-16d | SAMA dengan pemain Tim B   |%n",
                        a.no, a.tinggiBadan);
                adaSamaTinggi = true;
            }
        }
        if (!adaSamaTinggi) {
            System.out.println("  | -   | -                | Tidak ada yang sama        |");
        }
        System.out.println("  +-----+------------------+----------------------------+");

        System.out.println("\n  -- Pemain Tim A dengan Berat Badan sama dengan Tim B --");
        System.out.println("  +-----+-----------------+----------------------------+");
        System.out.println("  | No  | Berat Badan(kg) | Status                     |");
        System.out.println("  +-----+-----------------+----------------------------+");
        boolean adaSamaBerat = false;
        for (Pemain a : timA) {
            int lo = 0, hi = beratB.size() - 1;
            boolean ketemu = false;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (beratB.get(mid) == a.beratBadan) { ketemu = true; break; }
                else if (beratB.get(mid) < a.beratBadan) lo = mid + 1;
                else hi = mid - 1;
            }
            if (ketemu) {
                System.out.printf("  | %-3d | %-15d | SAMA dengan pemain Tim B   |%n",
                        a.no, a.beratBadan);
                adaSamaBerat = true;
            }
        }
        if (!adaSamaBerat) {
            System.out.println("  | -   | -               | Tidak ada yang sama        |");
        }
        System.out.println("  +-----+-----------------+----------------------------+");
    }

    public static void main(String[] args) {

        ArrayList<Pemain> timA = new ArrayList<>();
        timA.add(new Pemain(1,  168, 50));
        timA.add(new Pemain(2,  170, 60));
        timA.add(new Pemain(3,  165, 56));
        timA.add(new Pemain(4,  168, 55));
        timA.add(new Pemain(5,  172, 60));
        timA.add(new Pemain(6,  170, 70));
        timA.add(new Pemain(7,  169, 66));
        timA.add(new Pemain(8,  165, 56));
        timA.add(new Pemain(9,  171, 72));
        timA.add(new Pemain(10, 166, 56));

        ArrayList<Pemain> timB = new ArrayList<>();
        timB.add(new Pemain(1,  170, 66));
        timB.add(new Pemain(2,  167, 60));
        timB.add(new Pemain(3,  165, 59));
        timB.add(new Pemain(4,  166, 58));
        timB.add(new Pemain(5,  168, 58));
        timB.add(new Pemain(6,  175, 71));
        timB.add(new Pemain(7,  172, 68));
        timB.add(new Pemain(8,  171, 68));
        timB.add(new Pemain(9,  168, 65));
        timB.add(new Pemain(10, 169, 60));

        System.out.println("======================================================");
        System.out.println("    IMPLEMENTASI BINARY SEARCH - TIM FUTSAL          ");
        System.out.println("======================================================");

        cetakTabel(timA, "[A] DATA TIM A (ArrayList):");
        cetakTabel(timB, "[A] DATA TIM B (ArrayList):");

        System.out.println("\n======================================================");
        System.out.println("  [B] BINARY SEARCH TINGGI BADAN -- TIM B");
        System.out.println("======================================================");

        int[] targetTinggiB = {168, 160};
        for (int target : targetTinggiB) {
            int jumlah = binarySearchTinggi(timB, target);
            if (jumlah > 0) {
                System.out.printf("%n  Tinggi badan %d cm  --> DITEMUKAN, jumlah pemain: %d orang%n",
                        target, jumlah);
            } else {
                System.out.printf("%n  Tinggi badan %d cm  --> TIDAK DITEMUKAN di Tim B%n", target);
            }
        }

        System.out.println("\n======================================================");
        System.out.println("  [C] BINARY SEARCH BERAT BADAN -- TIM A");
        System.out.println("======================================================");

        int[] targetBeratA = {56, 53};
        for (int target : targetBeratA) {
            int jumlah = binarySearchBerat(timA, target);
            if (jumlah > 0) {
                System.out.printf("%n  Berat badan %d kg  --> DITEMUKAN, jumlah pemain: %d orang%n",
                        target, jumlah);
            } else {
                System.out.printf("%n  Berat badan %d kg  --> TIDAK DITEMUKAN di Tim A%n", target);
            }
        }

        cekKesamaanAB(timA, timB);

        System.out.println("\n======================================================");
        System.out.println("                  PROGRAM SELESAI                    ");
        System.out.println("======================================================");
    }
}
