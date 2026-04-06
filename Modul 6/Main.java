import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int pil;
        do {
            System.out.println("\n=== SISTEM DATA FILKOM UB ===\n1. Manusia  2. Mahasiswa  3. Pekerja  4. Manager  0. Keluar");
            System.out.print("Pilih: ");
            pil = sc.nextInt(); sc.nextLine();
            if (pil == 0) break;

            System.out.print("Nama: "); String n = sc.nextLine();
            System.out.print("NIK : ");  String nk = sc.nextLine();
            System.out.print("L/P : ");  boolean jk = sc.nextLine().equalsIgnoreCase("L");
            System.out.print("Menikah (Y/T): "); boolean m = sc.nextLine().equalsIgnoreCase("Y");

            switch (pil) {
                case 1 -> System.out.println("\n" + new Manusia(n, nk, jk, m));
                case 2 -> {
                    System.out.print("NIM : "); String nim = sc.nextLine();
                    System.out.print("IPK : ");  double ipk = sc.nextDouble();
                    System.out.println("\n" + new MahasiswaFILKOM(nim, ipk, n, nk, jk, m));
                }
                case 3, 4 -> {
                    String d = ""; if (pil == 4) { System.out.print("Dept: "); d = sc.nextLine(); }
                    System.out.print("Gaji: "); double g = sc.nextDouble();
                    System.out.print("Tgl Masuk (Thn Bln Tgl): ");
                    int y = sc.nextInt(), bl = sc.nextInt(), t = sc.nextInt();
                    System.out.print("Anak: "); int a = sc.nextInt();
                    System.out.println("\n" + (pil == 3 ? new Pekerja(g, y, bl, t, a, n, nk, jk, m) 
                                               : new Manager(d, g, y, bl, t, a, n, nk, jk, m)));
                }
            }
            System.out.println("\nTekan Enter..."); sc.nextLine(); sc.nextLine();
        } while (pil != 0);
    }
}