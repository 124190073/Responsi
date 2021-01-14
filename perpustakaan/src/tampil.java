/* Endang Herlina
*124190073
*PBO C
*/

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class tampil extends JFrame implements ActionListener {
    
    int baris = 0;
    static Object  kolom[] = {"ID", "Judul Buku", "Genre Buku", "Penulis", "Penerbit", "Lokasi", "Stok"};
    DefaultTableModel tbl = new DefaultTableModel(kolom,baris);
    
    JLabel lJUDUL = new JLabel("PERPUSTAKAAN UMUM YOGYAKARTA");
    
    final JTextField fid = new JTextField(10);
    JLabel lid = new JLabel("ID");

    final JTextField fjudul = new JTextField(40);
    JLabel ljudul = new JLabel("Judul Buku");

    final JTextField fgenre = new JTextField(40);
    JLabel lgenre = new JLabel("Genre Buku");
    
    final JTextField fpenulis = new JTextField(40);
    JLabel lpenulis = new JLabel("Penulis");
    
    final JTextField fpenerbit = new JTextField(40);
    JLabel lpenerbit = new JLabel("Penerbit");
    
    final JTextField flokasi = new JTextField(40);
    JLabel llokasi = new JLabel("Lokasi");
    
    final JTextField fstok = new JTextField(40);
    JLabel lstok = new JLabel("Stok");
    

    JButton btnSave = new JButton("Save");
    JButton btnDelete = new JButton("Delete");
    JButton btnUpdate = new JButton("Update");
    JButton btnReset = new JButton("Reset");
    JButton btnEdit = new JButton("Edit");
    JTable tblBuku = new JTable();    
    
    public tampil() {
        setTitle("BUKU");
        setDefaultCloseOperation(3);
        setSize(900, 550);
        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
        int x = layar.width / 2  - this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;
        this.setLocation(x, y);
        
        form f =  new form();
        String[][] data = f.getform();
        for (int i = 0; i <data.length; i++) {
            tbl.addRow(new Object[]{data[i][0], data[i][1], data[i][2], data[i][3], data[i][4], data[i][5],  data[i][6]});
        }
        tblBuku.setModel(tbl);

        setLayout(null);
        add(lJUDUL);
        add(lid);
        add(fid);
        add(ljudul);
        add(fjudul);
        add(lgenre);
        add(fgenre);
        add(lpenulis);
        add(fpenulis);
        add(lpenerbit);
        add(fpenerbit);
        add(llokasi);
        add(flokasi);
        add(lstok);
        add(fstok);
        
        
        add(btnSave);
        add(btnDelete);
        add(btnUpdate);
        add(btnReset);
        add(btnEdit);
        add(tblBuku);

        //setBounds(m,n,o,p)
        // m=posisix
        // n=posisin
        // o=panjangkomponen
        // p=tinggikomponen
        lJUDUL.setBounds(300, 10, 500, 10);
        
        lid.setBounds(10, 10, 120, 30);
        fid.setBounds(90,10,200,30);

        ljudul.setBounds(10,55,120,30);
        fjudul.setBounds(90,55,200,30);

        lgenre.setBounds(10,100,120,30);
        fgenre.setBounds(90,100,200,30);

        lpenulis.setBounds(10,145,600,30);
        fpenulis.setBounds(90,145,200,30);

        lpenerbit.setBounds(10,190,150,30);
        fpenerbit.setBounds(90,190,200,30);
        
        llokasi.setBounds(10,235,150,30);
        flokasi.setBounds(90,235,200,30);
        
        lstok.setBounds(10,280,150,30);
        fstok.setBounds(90,280,200,30);

        btnSave.setBounds(50,315,105,50);
        btnDelete.setBounds(165, 315, 105, 50);
        btnEdit.setBounds(50,370,105,50);
        btnUpdate.setBounds(165, 370, 105, 50);
        btnReset.setBounds(125, 430, 105, 50);
        

        tblBuku.setBounds(300, 30, 900, 600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
        btnSave.addActionListener(this);
        btnDelete.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnEdit.addActionListener(this);
        btnReset.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == btnSave) {
            btnSaveActionPerformed(evt);
        }
        if (evt.getSource() == btnDelete) {
            btnDeleteActionPerformed(evt);
        }
        if (evt.getSource() == btnEdit) {
            btnEditActionPerformed(evt);
        }
        if (evt.getSource() == btnReset) {
            btnResetActionPerformed(evt);
        }
        if (evt.getSource() == btnUpdate) {
            btnUpdateActionPerformed(evt);
        }
    }
    
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {                                        
        form f =  new form();
        String id = fid.getText();
        String judul = fjudul.getText();
        String genre = fgenre.getText();
        String penulis = fpenulis.getText();
        String penerbit = fpenerbit.getText();
        String lokasi = flokasi.getText();
        String stok = fstok.getText();
        
        
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID harus diisi",
                    "Informasi", JOptionPane.INFORMATION_MESSAGE);                
        } else {
            int No = f.tambah(id, judul, genre, penulis, penerbit, lokasi, stok);
            tbl.addRow(new Object[]{id, judul, genre, penulis, penerbit, lokasi, stok});
            tblBuku.setModel(tbl);
            fid.setText("");
            fjudul.setText("");
            fgenre.setText("");
            fpenulis.setText("");
            fpenerbit.setText("");
            flokasi.setText("");
            fstok.setText("");
            
        }
    }      
    
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          
        form f =  new form();
        int PilihBaris = tblBuku.getSelectedRow();
        String id = tbl.getValueAt(PilihBaris,0).toString();
        f.Hapus(id);
        tbl.removeRow(PilihBaris);
        JOptionPane.showMessageDialog(this, "Data berhasil dihapus",
                "Informasi", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                          
        form f =  new form();
        String id = fid.getText();
        String judul = fjudul.getText();
        String genre = fgenre.getText();
        String penulis = fpenulis.getText();
        String penerbit = fpenerbit.getText();
        String lokasi = flokasi.getText();
        String stok = fstok.getText();
        f.Update(id, judul, genre, penulis, penerbit, lokasi, stok);
        tbl.getDataVector().removeAllElements();
        
        //get data tabel
        String[][] data = f.getform();
        for (int i = 0; i <data.length; i++) {
            tbl.addRow(new Object[]{data[i][0], data[i][1], data[i][2], data[i][3], data[i][4], data[i][5], data[i][6]});
        }
        tblBuku.setModel(tbl);
        JOptionPane.showMessageDialog(this, "Data berhasil di edit", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            fid.setText("");
            fjudul.setText("");
            fgenre.setText("");
            fpenulis.setText("");
            fpenerbit.setText("");
            flokasi.setText("");
            fstok.setText("");
    }
    
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {                                        
        form f =  new form();
        
        int PilihBaris = tblBuku.getSelectedRow();
        String id = tbl.getValueAt(PilihBaris,0).toString();
        String judul = tbl.getValueAt(PilihBaris,1).toString();
        String genre = tbl.getValueAt(PilihBaris,2).toString();
        String penulis = tbl.getValueAt(PilihBaris,3).toString();
        String penerbit = tbl.getValueAt(PilihBaris,4).toString();
        String lokasi = tbl.getValueAt(PilihBaris,5).toString();
        String stok= tbl.getValueAt(PilihBaris,6).toString();
        
        f.getData(id);
        fid.setText(id);
        fid.setEditable(false);
        fjudul.setText(judul);
        fgenre.setText(genre);
        fpenulis.setText(penulis);
        fpenerbit.setText(penerbit);
        flokasi.setText(lokasi);
        fstok.setText(stok);
        
    }
    
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {                                         
        fid.setText("");
        fjudul.setText("");
        fgenre.setText("");
        fpenulis.setText("");
        fpenerbit.setText("");
        flokasi.setText("");
        fstok.setText("");
    }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tampil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tampil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tampil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tampil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tampil().setVisible(true);
            }
        });
    }
}

