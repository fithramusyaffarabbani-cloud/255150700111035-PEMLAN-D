import java.io.File;

public class ListFile {
    public static void main(String[] args) {
        // Ganti path sesuai direktori yang ingin dilihat isinya
        var dir = new File(".");

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Direktori tidak ditemukan.");
            return;
        }

        File[] files = dir.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("Direktori kosong.");
            return;
        }

        System.out.println("Daftar file di: " + dir.getAbsolutePath());
        System.out.println("-----------------------------");

        for (var file : files) {
            if (file.isFile()) {
                System.out.println("[FILE] " + file.getName());
            } else if (file.isDirectory()) {
                System.out.println("[DIR]  " + file.getName());
            }
        }
    }
}
