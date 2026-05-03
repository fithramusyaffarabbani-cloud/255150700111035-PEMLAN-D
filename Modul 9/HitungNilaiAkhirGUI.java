import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HitungNilaiAkhirGUI extends JFrame {

    private Pemlan    pemlan    = new Pemlan();
    private ASD       asd       = new ASD();
    private Matkomlan matkomlan = new Matkomlan();
    private Probstat  probstat  = new Probstat();

    private MataKuliah aktif = pemlan;

    private JRadioButton rbPemlan, rbASD, rbMatkomlan, rbProbstat;
    private JTextField   tfTugas, tfKuis, tfUTS, tfUAS, tfHasil;
    private JTextArea    taHasil;
    private JButton      btnHitung, btnTampil;

    public HitungNilaiAkhirGUI() {
        setTitle("Hitung Nilai Akhir dengan GUI...");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setResizable(false);

        add(buildTopPanel(),    BorderLayout.NORTH);
        add(buildCenterPanel(), BorderLayout.CENTER);
        add(buildBottomPanel(), BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    private JPanel buildTopPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel lblJudul = new JLabel("Hitung Nilai Akhir", SwingConstants.CENTER);
        lblJudul.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblJudul.setBorder(BorderFactory.createEmptyBorder(10, 0, 8, 0));
        panel.add(lblJudul, BorderLayout.NORTH);

        ButtonGroup bg = new ButtonGroup();
        rbASD       = new JRadioButton("ASD");
        rbPemlan    = new JRadioButton("Pemlan", true);
        rbMatkomlan = new JRadioButton("Matkomlan");
        rbProbstat  = new JRadioButton("Probstat");

        bg.add(rbASD);
        bg.add(rbPemlan);
        bg.add(rbMatkomlan);
        bg.add(rbProbstat);

        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        radioPanel.add(rbASD);
        radioPanel.add(rbPemlan);
        radioPanel.add(rbMatkomlan);
        radioPanel.add(rbProbstat);
        panel.add(radioPanel, BorderLayout.CENTER);

        ActionListener radioListener = e -> {
            if      (rbPemlan.isSelected())    aktif = pemlan;
            else if (rbASD.isSelected())       aktif = asd;
            else if (rbMatkomlan.isSelected()) aktif = matkomlan;
            else                               aktif = probstat;
            kosongkanField();
        };

        rbPemlan.addActionListener(radioListener);
        rbASD.addActionListener(radioListener);
        rbMatkomlan.addActionListener(radioListener);
        rbProbstat.addActionListener(radioListener);

        panel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        return panel;
    }

    private JPanel buildCenterPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 8, 4, 8);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill   = GridBagConstraints.HORIZONTAL;

        String[] labels = {"Tugas :", "Kuis :", "UTS :", "UAS :", "Hasil :"};
        tfTugas = new JTextField(10);
        tfKuis  = new JTextField(10);
        tfUTS   = new JTextField(10);
        tfUAS   = new JTextField(10);
        tfHasil = new JTextField(10);
        tfHasil.setEditable(false);
        JTextField[] fields = {tfTugas, tfKuis, tfUTS, tfUAS, tfHasil};

        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = 0; gbc.gridy = i; gbc.weightx = 0;
            panel.add(new JLabel(labels[i]), gbc);
            gbc.gridx = 1; gbc.weightx = 1;
            panel.add(fields[i], gbc);
        }

        btnHitung = new JButton("Hitung");
        gbc.gridx = 0; gbc.gridy = labels.length;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(8, 8, 8, 8);
        panel.add(btnHitung, gbc);

        btnHitung.addActionListener(e -> hitungNilai());

        panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        return panel;
    }

    private JPanel buildBottomPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));

        taHasil = new JTextArea(6, 30);
        taHasil.setEditable(false);
        taHasil.setFont(new Font("Monospaced", Font.PLAIN, 12));

        JScrollPane scroll = new JScrollPane(taHasil);
        scroll.setBorder(BorderFactory.createTitledBorder("HASIL NILAI SEMUA MATA KULIAH"));
        panel.add(scroll, BorderLayout.CENTER);

        btnTampil = new JButton("Tampilkan nilai semua matkul");
        btnTampil.addActionListener(e -> tampilkanSemua());
        panel.add(btnTampil, BorderLayout.SOUTH);

        panel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        return panel;
    }

    private void hitungNilai() {
        try {
            double t = Double.parseDouble(tfTugas.getText().trim());
            double k = Double.parseDouble(tfKuis.getText().trim());
            double u = Double.parseDouble(tfUTS.getText().trim());
            double a = Double.parseDouble(tfUAS.getText().trim());

            aktif.setNilai(t, k, u, a);
            double hasil = aktif.hitungNilaiAkhir();
            tfHasil.setText(String.format("%.1f", hasil));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Harap isi semua nilai dengan angka yang valid!",
                "Input Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void tampilkanSemua() {
        StringBuilder sb = new StringBuilder();
        MataKuliah[] semua = {pemlan, asd, matkomlan, probstat};
        for (MataKuliah mk : semua) {
            if (mk.getNilaiAkhir() > 0) {
                sb.append(mk.toString()).append("\n");
            } else {
                sb.append(String.format("%-12s : belum dihitung%n", mk.getNama()));
            }
        }
        taHasil.setText(sb.toString());
    }

    private void kosongkanField() {
        tfTugas.setText("");
        tfKuis.setText("");
        tfUTS.setText("");
        tfUAS.setText("");
        tfHasil.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HitungNilaiAkhirGUI().setVisible(true));
    }
}
