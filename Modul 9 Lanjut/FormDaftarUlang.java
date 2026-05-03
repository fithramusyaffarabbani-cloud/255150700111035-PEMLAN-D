import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormDaftarUlang extends JFrame {
    private JTextField txtNama, txtTanggalLahir, txtNoPendaftaran, txtNoTelp, txtEmail;
    private JTextArea txtAlamat;
    private JButton btnSubmit;

    public FormDaftarUlang() {
        setTitle("Form Daftar Ulang Mahasiswa Baru");
        setSize(450, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelHeader = new JPanel();
        panelHeader.setBackground(new Color(41, 128, 185));
        JLabel lblTitle = new JLabel("DAFTAR ULANG MAHASISWA");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
        panelHeader.add(lblTitle);
        add(panelHeader, BorderLayout.NORTH);

        JPanel panelForm = new JPanel(new GridBagLayout());
        panelForm.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 5, 10, 5);

        addFormField(panelForm, "Nama Lengkap:", txtNama = new JTextField(20), gbc, 0);
        addFormField(panelForm, "Tanggal Lahir:", txtTanggalLahir = new JTextField(20), gbc, 1);
        addFormField(panelForm, "No. Pendaftaran:", txtNoPendaftaran = new JTextField(20), gbc, 2);
        addFormField(panelForm, "No. Telp:", txtNoTelp = new JTextField(20), gbc, 3);
        
        gbc.gridx = 0; gbc.gridy = 4;
        panelForm.add(new JLabel("Alamat:"), gbc);
        gbc.gridx = 1;
        txtAlamat = new JTextArea(4, 20);
        txtAlamat.setLineWrap(true);
        panelForm.add(new JScrollPane(txtAlamat), gbc);

        addFormField(panelForm, "E-mail:", txtEmail = new JTextField(20), gbc, 5);

        add(panelForm, BorderLayout.CENTER);

        btnSubmit = new JButton("SUBMIT");
        btnSubmit.setBackground(new Color(46, 204, 113));
        btnSubmit.setForeground(Color.WHITE);
        btnSubmit.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnSubmit.setFocusPainted(false);
        
        JPanel panelButton = new JPanel();
        panelButton.add(btnSubmit);
        add(panelButton, BorderLayout.SOUTH);

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validasiDanSubmit();
            }
        });
    }

    private void addFormField(JPanel panel, String label, JTextField field, GridBagConstraints gbc, int y) {
        gbc.gridx = 0; gbc.gridy = y;
        panel.add(new JLabel(label), gbc);
        gbc.gridx = 1;
        panel.add(field, gbc);
    }

    private void validasiDanSubmit() {
        if (txtNama.getText().isEmpty() || txtTanggalLahir.getText().isEmpty() || 
            txtNoPendaftaran.getText().isEmpty() || txtNoTelp.getText().isEmpty() || 
            txtAlamat.getText().isEmpty() || txtEmail.getText().isEmpty()) {
            
            JOptionPane.showMessageDialog(this, "Semua kolom harus terisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
            int response = JOptionPane.showConfirmDialog(this, 
                "Apakah anda yakin data yang Anda isi sudah benar?", 
                "Konfirmasi", JOptionPane.YES_NO_OPTION);

            if (response == JOptionPane.YES_OPTION) {
                tampilkanDataBaru();
            }
        }
    }

    private void tampilkanDataBaru() {
        JFrame frameData = new JFrame("Data Mahasiswa");
        frameData.setSize(400, 450);
        frameData.setLocationRelativeTo(this);
        
        JTextArea areaData = new JTextArea();
        areaData.setEditable(false);
        areaData.setFont(new Font("Monospaced", Font.PLAIN, 13));
        areaData.setMargin(new Insets(20, 20, 20, 20));
        
        String data = "======= DATA MAHASISWA =======\n\n" +
                      "Nama           : " + txtNama.getText() + "\n" +
                      "Tanggal Lahir  : " + txtTanggalLahir.getText() + "\n" +
                      "No. Pendaftaran: " + txtNoPendaftaran.getText() + "\n" +
                      "No. Telp       : " + txtNoTelp.getText() + "\n" +
                      "Alamat         : " + txtAlamat.getText() + "\n" +
                      "E-mail         : " + txtEmail.getText() + "\n\n" +
                      "==============================";
        
        areaData.setText(data);
        frameData.add(new JScrollPane(areaData));
        frameData.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FormDaftarUlang().setVisible(true);
        });
    }
}
