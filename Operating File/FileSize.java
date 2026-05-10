import java.io.File;
 
public class FileSize {
    public static void main(String[] args) {
        var file = new File("test.txt");
 
        if (!file.exists()) {
            System.out.println("File tidak ditemukan.");
            return;
        }
 
        long bytes = file.length();
        long MB = 1024 * 1024;
 
        if (bytes < MB) {
            double kb = bytes / 1024.0;
            System.out.printf("Ukuran file: %.2f KB%n", kb);
        } else {
            double mb = bytes / (double) MB;
            System.out.printf("Ukuran file: %.2f MB%n", mb);
        }
    }
}
