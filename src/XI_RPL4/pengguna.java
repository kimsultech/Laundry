package XI_RPL4;

import XI_RPL4.style.buttonRounded;
import java.awt.GraphicsEnvironment;
import java.awt.geom.RoundRectangle2D;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KIMSUL
 */
public class pengguna extends javax.swing.JFrame {
    private DefaultTableModel model;
    public static int statusSearching = 0;
    
    Connection con;
    Statement st;
    
    int xy;
    int xx;


    public pengguna() {
        initComponents();
        db_koneksi data = new db_koneksi();
        data.config();
        con = data.con;
        st = data.st;
        model = (DefaultTableModel)tabel_peng.getModel();
    }

    
    private void tampil_tabel_peng() {
        try {
                st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM pengguna");
                ResultSetMetaData rsmd = rs.getMetaData();
                    int columnCount = rsmd.getColumnCount();
                DefaultTableModel tm = (DefaultTableModel) tabel_peng.getModel();
                tm.setColumnCount(5);
                    for (int i = 6; i <= columnCount; i++ ) {
                    tm.addColumn(rsmd.getColumnName(i));
                }
                    tm.setRowCount(0);
                    while (rs.next()) {
                    String[] a = new String[columnCount];
                        for(int i = 0; i < columnCount; i++) {
                        a[i] = rs.getString(i+1);
                    }
                    tm.addRow(a);
                }
                tm.fireTableDataChanged();
                rs.close();
                st.close();
                } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex, ex.getMessage(), WIDTH, null);
                }
       }
    
    private void simpan_peng() {
        String UserPeng = username_peng.getText();
        String PassPeng = password_peng.getText();
        String NamaPeng = nama_peng.getText();

        try {
            st = con.createStatement();
            String sqlSimpan = "insert into pengguna values (NULL,'"+UserPeng+"','"+PassPeng+"','"+hakakses.getSelectedItem()+"','"+NamaPeng+"') ";
            st.executeUpdate(sqlSimpan);
            JOptionPane.showMessageDialog(null, "Data Berhasil Masuk!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Tak Masuk " + e.getMessage());
        }
    }
    
    private void klik_tabel_peng() {
        String PengID = tabel_peng.getValueAt(tabel_peng.getSelectedRow(), 0).toString();
        String PengUser = tabel_peng.getValueAt(tabel_peng.getSelectedRow(), 1).toString();
        String PengPass = tabel_peng.getValueAt(tabel_peng.getSelectedRow(), 2).toString();
        String PengHak = tabel_peng.getValueAt(tabel_peng.getSelectedRow(), 3).toString();
        String PengNama = tabel_peng.getValueAt(tabel_peng.getSelectedRow(), 4).toString();
        
        id_peng.setText(PengID);
        username_peng.setText(PengUser);
        password_peng.setText(PengPass);
        hakakses.getModel().setSelectedItem(PengHak);
        nama_peng.setText(PengNama);
    }
    
    private void ubah_data() {
        int index = tabel_peng.getSelectedRow();
        String id = tabel_peng.getValueAt(index, 0).toString();
        
        String IDPENG = id_peng.getText();
        String User = username_peng.getText();
        String Pass = password_peng.getText();
        String Nama = nama_peng.getText();
        
        
        try {

            st = con.createStatement();
            String sqlUpdate = "UPDATE pengguna SET id_pengguna='"+IDPENG+"',username='"+User+"',password='"+Pass+"',hakakses='"+hakakses.getSelectedItem()+"',nama_pengguna='"+Nama+"' WHERE id_pengguna='"+id+"' ";
            st.executeUpdate(sqlUpdate);

        JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Data Gagal di Ubah " + e.getMessage());
            }
        }
    
    private void hapus_data() {
            String[] options = {"Yes", "No"};
            JOptionPane.showOptionDialog(null, "Yakin Hapus Data Ini??", "Delete Confirm", 
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

            String id = id_peng.getText();

            try {

            st = con.createStatement();
            String sqlUpdate = "DELETE FROM pengguna WHERE id_pengguna='"+id+"'";
            st.executeUpdate(sqlUpdate);
            
            
            username_peng.setText("");
            password_peng.setText("");
        
            nama_peng.setText("");
            id_peng.setText("Auto Generate");
            

        JOptionPane.showMessageDialog(null, "Data Dihapus dari Database");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus " + e.getMessage());
            }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        id_peng = new buttonRounded();
        jLabel28 = new javax.swing.JLabel();
        username_peng = new buttonRounded();
        jLabel29 = new javax.swing.JLabel();
        password_peng = new buttonRounded();
        jLabel30 = new javax.swing.JLabel();
        hakakses = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        nama_peng = new buttonRounded();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_peng = new javax.swing.JTable();
        tambah_peng = new javax.swing.JButton();
        simpan_peng = new javax.swing.JButton();
        hapus_peng = new javax.swing.JButton();
        ubah_peng = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(20, 20));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/XI_RPL4/Icon/icons8-administrator-male-40.png"))); // NOI18N
        jLabel1.setText("PENGGUNA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));

        jPanel9.setBackground(new java.awt.Color(102, 102, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Pengguna"));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/XI_RPL4/Icon/icons8-touch-id-20.png"))); // NOI18N
        jLabel27.setText("User ID :");

        id_peng.setEditable(false);
        id_peng.setBackground(new java.awt.Color(153, 153, 153));
        id_peng.setText("Auto Generate");
        id_peng.setDoubleBuffered(true);

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/XI_RPL4/Icon/icons8-user-male-20.png"))); // NOI18N
        jLabel28.setText("Username :");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/XI_RPL4/Icon/icons8-lock-20.png"))); // NOI18N
        jLabel29.setText("Password :");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/XI_RPL4/Icon/icons8-access-20.png"))); // NOI18N
        jLabel30.setText("Hak Akses :");

        hakakses.setBackground(new java.awt.Color(0, 204, 153));
        hakakses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User" }));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/XI_RPL4/Icon/icons8-name-tag-20.png"))); // NOI18N
        jLabel31.setText("Nama Lengkap :");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(18, 18, 18)
                        .addComponent(nama_peng))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(password_peng, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hakakses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(username_peng, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id_peng, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(308, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(id_peng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(username_peng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(password_peng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(hakakses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(nama_peng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(102, 102, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Pengguna"));

        tabel_peng.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Pengguna", "Username", "Password", "Hak Akses", "Nama Lengkap"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel_peng.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_pengMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_peng);
        if (tabel_peng.getColumnModel().getColumnCount() > 0) {
            tabel_peng.getColumnModel().getColumn(0).setHeaderValue("ID Pengguna");
            tabel_peng.getColumnModel().getColumn(1).setHeaderValue("Username");
            tabel_peng.getColumnModel().getColumn(2).setHeaderValue("Password");
            tabel_peng.getColumnModel().getColumn(3).setHeaderValue("Hak Akses");
            tabel_peng.getColumnModel().getColumn(4).setHeaderValue("Nama Lengkap");
        }

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        tambah_peng.setBackground(new java.awt.Color(255, 255, 255));
        tambah_peng.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tambah_peng.setIcon(new javax.swing.ImageIcon(getClass().getResource("/XI_RPL4/Icon/icons8-plus-30.png"))); // NOI18N
        tambah_peng.setText("TAMBAH");
        tambah_peng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambah_pengActionPerformed(evt);
            }
        });

        simpan_peng.setBackground(new java.awt.Color(255, 255, 255));
        simpan_peng.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        simpan_peng.setIcon(new javax.swing.ImageIcon(getClass().getResource("/XI_RPL4/Icon/icons8-save-30.png"))); // NOI18N
        simpan_peng.setText("SIMPAN");
        simpan_peng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpan_pengActionPerformed(evt);
            }
        });

        hapus_peng.setBackground(new java.awt.Color(255, 51, 51));
        hapus_peng.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        hapus_peng.setIcon(new javax.swing.ImageIcon(getClass().getResource("/XI_RPL4/Icon/icons8-cancel-30.png"))); // NOI18N
        hapus_peng.setText("HAPUS");
        hapus_peng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapus_pengActionPerformed(evt);
            }
        });

        ubah_peng.setBackground(new java.awt.Color(255, 255, 255));
        ubah_peng.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ubah_peng.setIcon(new javax.swing.ImageIcon(getClass().getResource("/XI_RPL4/Icon/icons8-edit-30.png"))); // NOI18N
        ubah_peng.setText("UBAH");
        ubah_peng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubah_pengActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/XI_RPL4/Icon/icons8-tuttp-30.png"))); // NOI18N
        jButton1.setText("TUTUP");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(tambah_peng)
                .addGap(29, 29, 29)
                .addComponent(simpan_peng)
                .addGap(34, 34, 34)
                .addComponent(hapus_peng)
                .addGap(38, 38, 38)
                .addComponent(ubah_peng)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(28, 28, 28))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tambah_peng, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(simpan_peng, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ubah_peng, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hapus_peng, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tambah_pengActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambah_pengActionPerformed

        username_peng.setText("");
        password_peng.setText("");
        
        nama_peng.setText("");
        
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM pengguna ORDER BY id_pengguna DESC";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                int hmmmm = Integer.parseInt(rs.getString("id_pengguna"))+1;
                id_peng.setText(Integer.toString(hmmmm));
            } else {
                id_peng.setText("0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
    }//GEN-LAST:event_tambah_pengActionPerformed

    private void simpan_pengActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpan_pengActionPerformed
        simpan_peng();
        tampil_tabel_peng();
    }//GEN-LAST:event_simpan_pengActionPerformed

    private void hapus_pengActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus_pengActionPerformed
        hapus_data();
        tampil_tabel_peng();
    }//GEN-LAST:event_hapus_pengActionPerformed

    private void ubah_pengActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubah_pengActionPerformed
        ubah_data();
        tampil_tabel_peng();
    }//GEN-LAST:event_ubah_pengActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tampil_tabel_peng();
        
    }//GEN-LAST:event_formWindowOpened

    private void tabel_pengMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_pengMouseClicked
        klik_tabel_peng();
    }//GEN-LAST:event_tabel_pengMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(pengguna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pengguna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pengguna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pengguna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pengguna().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> hakakses;
    private javax.swing.JButton hapus_peng;
    private javax.swing.JTextField id_peng;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nama_peng;
    private javax.swing.JTextField password_peng;
    private javax.swing.JButton simpan_peng;
    private javax.swing.JTable tabel_peng;
    private javax.swing.JButton tambah_peng;
    private javax.swing.JButton ubah_peng;
    private javax.swing.JTextField username_peng;
    // End of variables declaration//GEN-END:variables
}
