import java.io.File;

public class DeleteDir {
    public static void main(String[] args) {
        // Ganti nama direktori yang ingin dihapus
        var dir = new File("folder-hapus");

        if (!dir.exists()) {
            System.out.println("Direktori tidak ditemukan.");
            return;
        }

        if (!dir.isDirectory()) {
            System.out.println("Path bukan sebuah direktori.");
            return;
        }

        // Hapus semua file di dalam direktori terlebih dahulu
        File[] files = dir.listFiles();
        if (files != null) {
            for (var file : files) {
                if (file.isFile()) {
                    boolean deleted = file.delete();
                    System.out.println((deleted ? "Berhasil" : "Gagal")
                            + " menghapus file: " + file.getName());
                }
            }
        }

        // Setelah semua file terhapus, hapus direktorinya
        boolean dirDeleted = dir.delete();
        System.out.println((dirDeleted ? "Berhasil" : "Gagal")
                + " menghapus direktori: " + dir.getName());
    }
}
