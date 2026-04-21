public class MainKoperasi {
    public static void main(String[] args) {

        Invoice[] invoices = {
            new Invoice("Beras 5kg", 2, 65000),
            new Invoice("Minyak Goreng", 3, 20000),
            new Invoice("Sabun Mandi", 5, 8000)
        };

        Employee employee = new Employee(1001, "Fithrafa Rabbani", 5000000, invoices);

        // tampilkan informasi secara polimorfis
        Payable[] payables = new Payable[invoices.length + 1];
        payables[0] = employee;
        for (int i = 0; i < invoices.length; i++) {
            payables[i + 1] = invoices[i];
        }

        System.out.println("========================================");
        System.out.println("       NV. MENEER - KOPERASI KARYAWAN   ");
        System.out.println("========================================");
        System.out.println("No. Registrasi : " + employee.getRegistrationNumber());
        System.out.println("Nama Karyawan  : " + employee.getName());
        System.out.println("Gaji Per Bulan : Rp " + employee.getSalaryPerMonth());

        System.out.println("\n--- Detail Belanjaan ---");
        for (Payable p : payables) {
            if (p instanceof Invoice) {
                Invoice inv = (Invoice) p;
                System.out.println("Produk        : " + inv.getProductName());
                System.out.println("Jumlah        : " + inv.getQuantity() + " pcs");
                System.out.println("Harga Satuan  : Rp " + inv.getPricePerItem());
                System.out.println("Total         : Rp " + inv.getPayableAmount());
                System.out.println("----------------------------------------");
            }
        }

        System.out.println("Total Belanjaan  : Rp " + employee.getTotalInvoice());
        System.out.println("Gaji Bersih      : Rp " + employee.getPayableAmount());
        System.out.println("========================================");
    }
}