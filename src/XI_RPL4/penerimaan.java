package XI_RPL4;

import XI_RPL4.style.buttonRounded;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KIMSUL
 */
public class penerimaan extends javax.swing.JFrame {
    private DefaultTableModel model;
    
    private static final DateTimeFormatter smpdtfmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDateTime tglsekarang = LocalDateTime.now();
    private final String ltanggal = smpdtfmt.format(tglsekarang);
    
    String selectedItemStrNama,selectedItemStr,KDID,jcnya,selectedItemStrPengerjaan;
    int harganya;
    int hargahitung,totalnya,kgnya,totalfix,mayarnya,totalhitung,kembaliannya;
    String IDnya = "";

    Connection con;
    Statement st;
    private int xx;
    private int xy;

    public penerimaan() {
        initComponents();
        db_koneksi data = new db_koneksi();
        data.config();
        con = data.con;
        st = data.st;
        model = (DefaultTableModel)tabel_pen.getModel();
    }
    
    
    private void tampil_tabel() {
        try {
                st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT no_order,id_pelanggan,nama_pelanggan,tgl_masuk,tgl_keluar,t_bayar,bayar,sisa,status FROM penerimaan");
                ResultSetMetaData rsmd = rs.getMetaData();
                    int columnCount = rsmd.getColumnCount();
                DefaultTableModel tm = (DefaultTableModel) tabel_pen.getModel();
                tm.setColumnCount(9);
                    for (int i = 10; i <= columnCount; i++ ) {
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
    
    public void pelanggan_pen() {
        
        try {
                st = con.createStatement();
                String sql = "SELECT * FROM laundry.pelanggan";
                ResultSet rs = st.executeQuery(sql);
                    while(rs.next()) {
                        idpel_pen.addItem((rs.getString(2)));
                        IDnya = rs.getString(1);
                        
                        
                    }
                    
                    
                    rs.close();
                    st.close();
                        } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex, ex.getMessage(), WIDTH, null);
                        }
       }
    
    public void jenis_cucian_pen() {
        
        try {
                st = con.createStatement();
                String sql = "SELECT * FROM laundry.jenis_cucian";
                ResultSet rs = st.executeQuery(sql);
                    while(rs.next()) {
                        idjc_pen.addItem((rs.getString(2)));
                        
                    }

                    rs.close();
                    st.close();
                        } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex, ex.getMessage(), WIDTH, null);
                        }
       }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_pen = new javax.swing.JTable();
        tambah_pel = new javax.swing.JButton();
        simpan_pel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        no_pen = new buttonRounded();
        jLabel3 = new javax.swing.JLabel();
        idpel_pen = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        idjc_pen = new javax.swing.JComboBox<>();
        harga_pen = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        berat_pen = new buttonRounded();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ket_pen = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        pengerjaan_pen = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        selesai_pen = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        total_pen = new buttonRounded();
        jLabel14 = new javax.swing.JLabel();
        bayar_pen = new buttonRounded();
        jLabel15 = new javax.swing.JLabel();
        sisa_pen = new buttonRounded();
        jLabel16 = new javax.swing.JLabel();
        status_pen = new buttonRounded();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(20, 15));
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
        jLabel1.setForeground(new java.awt.Color(255, 102, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/XI_RPL4/Icon/icons8-purchase-order-40.png"))); // NOI18N
        jLabel1.setText("ORDER MASUK");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addContainerGap(607, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Order"));

        tabel_pen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No Order", "ID", "Nama Pelanggan", "Tanggal Masuk", "Tanggal Keluar", "Total Bayar", "Bayar", "Sisa", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabel_pen);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 953, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        tambah_pel.setBackground(new java.awt.Color(255, 255, 255));
        tambah_pel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tambah_pel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/XI_RPL4/Icon/icons8-plus-30.png"))); // NOI18N
        tambah_pel.setText("TAMBAH");
        tambah_pel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambah_pelActionPerformed(evt);
            }
        });

        simpan_pel.setBackground(new java.awt.Color(255, 255, 255));
        simpan_pel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        simpan_pel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/XI_RPL4/Icon/icons8-save-30.png"))); // NOI18N
        simpan_pel.setText("SIMPAN");
        simpan_pel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpan_pelActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Order"));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/XI_RPL4/Icon/icons8-numeric-20.png"))); // NOI18N
        jLabel2.setText("No Order :");

        no_pen.setEditable(false);
        no_pen.setBackground(new java.awt.Color(153, 153, 153));
        no_pen.setForeground(new java.awt.Color(255, 255, 255));
        no_pen.setText("Auto Generate");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/XI_RPL4/Icon/icons8-customer-20.png"))); // NOI18N
        jLabel3.setText("Pelanggan :");

        idpel_pen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih Pelanggan" }));
        idpel_pen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idpel_penActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/XI_RPL4/Icon/icons8-hair-dryer-20.png"))); // NOI18N
        jLabel4.setText("Jenis Cucian :");

        idjc_pen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih Jenis Cucian" }));
        idjc_pen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idjc_penActionPerformed(evt);
            }
        });

        harga_pen.setText("Harga");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/XI_RPL4/Icon/icons8-weight-kg-20.png"))); // NOI18N
        jLabel6.setText("Berat :");

        berat_pen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                berat_penKeyReleased(evt);
            }
        });

        jLabel7.setText("/ Kg");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/XI_RPL4/Icon/icons8-information-20.png"))); // NOI18N
        jLabel10.setText("Keterangan :");

        ket_pen.setColumns(20);
        ket_pen.setRows(5);
        jScrollPane2.setViewportView(ket_pen);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/XI_RPL4/Icon/icons8-submit-progress-20.png"))); // NOI18N
        jLabel11.setText("Pengerjaan :");

        pengerjaan_pen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diberikan", "Diambil" }));
        pengerjaan_pen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pengerjaan_penActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/XI_RPL4/Icon/icons8-calendar-27-20.png"))); // NOI18N
        jLabel12.setText("Selesai :");

        selesai_pen.setDateFormatString("yyyy-MM-dd");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/XI_RPL4/Icon/icons8-bill-20.png"))); // NOI18N
        jLabel13.setText("Total :");

        total_pen.setEditable(false);
        total_pen.setBackground(new java.awt.Color(153, 153, 153));
        total_pen.setForeground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/XI_RPL4/Icon/icons8-cash-hand-20.png"))); // NOI18N
        jLabel14.setText("Bayar / DP :");

        bayar_pen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bayar_penKeyReleased(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/XI_RPL4/Icon/icons8-cash-in-hand-20.png"))); // NOI18N
        jLabel15.setText("Sisa :");

        sisa_pen.setEditable(false);
        sisa_pen.setBackground(new java.awt.Color(153, 153, 153));
        sisa_pen.setForeground(new java.awt.Color(255, 255, 255));
        sisa_pen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sisa_penKeyReleased(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/XI_RPL4/Icon/icons8-data-pending-20.png"))); // NOI18N
        jLabel16.setText("Status :");

        status_pen.setEditable(false);
        status_pen.setBackground(new java.awt.Color(153, 153, 153));
        status_pen.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(berat_pen, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addComponent(idpel_pen, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(no_pen, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idjc_pen, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(harga_pen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selesai_pen, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pengerjaan_pen, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bayar_pen, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(total_pen, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sisa_pen, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(status_pen, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(total_pen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(bayar_pen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(sisa_pen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(pengerjaan_pen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(selesai_pen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(status_pen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(no_pen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(idpel_pen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(idjc_pen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(harga_pen)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(berat_pen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/XI_RPL4/Icon/icons8-tuttp-30.png"))); // NOI18N
        jButton2.setText("TUTUP");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(tambah_pel)
                .addGap(24, 24, 24)
                .addComponent(simpan_pel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(34, 34, 34))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambah_pel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(simpan_pel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tambah_pelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambah_pelActionPerformed
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM penerimaan ORDER BY no_order DESC";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                int hmmmm = Integer.parseInt(rs.getString("no_order"))+1;
                no_pen.setText(Integer.toString(hmmmm));
            } else {
                no_pen.setText("0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
        
        idpel_pen.setSelectedIndex(0);
        idjc_pen.setSelectedIndex(0);
        harga_pen.setText("Harga");
        berat_pen.setText("");
        ket_pen.setText("");
        pengerjaan_pen.setSelectedIndex(0);
        total_pen.setText("");
        bayar_pen.setText("");
        sisa_pen.setText("");
        status_pen.setText("");
    }//GEN-LAST:event_tambah_pelActionPerformed

    private void simpan_pelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpan_pelActionPerformed

        java.sql.Date Tkeluar = new java.sql.Date(selesai_pen.getDate().getTime());
        
        String TBayar = total_pen.getText();
        String Bayarr = bayar_pen.getText();
        String Sisaa = sisa_pen.getText();
        String Statuss = status_pen.getText();
        String Beratt = berat_pen.getText();
        String Keterangann = ket_pen.getText();
        
        try {
            st = con.createStatement();
            String sqlSimpan = "insert into penerimaan values (NULL,'"+IDnya+"','"+selectedItemStrNama+"','"+smpdtfmt.format(tglsekarang).toString()+"','"+Tkeluar+"','"+TBayar+"','"+Bayarr+"','"+Sisaa+"','"+Statuss+"','"+KDID+"','"+jcnya+"','"+hargahitung+"','"+Beratt+"','"+Keterangann+"','"+selectedItemStrPengerjaan+"') ";
            st.executeUpdate(sqlSimpan);
            JOptionPane.showMessageDialog(null, "Data Berhasil Masuk!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Tak Masuk " + e.getMessage());
        }
        tampil_tabel();
    }//GEN-LAST:event_simpan_pelActionPerformed

    private void idpel_penActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idpel_penActionPerformed
                    Object selectedItem = idpel_pen.getSelectedItem();
                    if (selectedItem != null)
                    {
                        selectedItemStrNama = selectedItem.toString();
                        //selectedItemStr buat ngambil Value
                    }
    }//GEN-LAST:event_idpel_penActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tampil_tabel();
        pelanggan_pen();
        jenis_cucian_pen();
    }//GEN-LAST:event_formWindowOpened

    private void idjc_penActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idjc_penActionPerformed
                    Object selectedItem = idjc_pen.getSelectedItem();
                    if (selectedItem != null)
                    {
                       selectedItemStr = selectedItem.toString();
                
                            try {
                            st = con.createStatement();
                            String sql = "SELECT * FROM laundry.jenis_cucian WHERE jenis_cucian='"+selectedItemStr+"'";
                            ResultSet rs = st.executeQuery(sql);
                                while(rs.next()) {
                                    KDID = rs.getString(1);
                                    jcnya = rs.getString(2);
                                    harga_pen.setText(rs.getString(3));
                                    total_pen.setText(harga_pen.getText());
                                }

                                rs.close();
                                st.close();
                                    } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(this, ex, ex.getMessage(), WIDTH, null);
                                    }
                    }
    }//GEN-LAST:event_idjc_penActionPerformed

    private void berat_penKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_berat_penKeyReleased
        kgnya = Integer.parseInt(berat_pen.getText());
        hargahitung = Integer.parseInt(harga_pen.getText());
        totalnya = kgnya * hargahitung;
        total_pen.setText(String.valueOf(totalnya));
    }//GEN-LAST:event_berat_penKeyReleased

    private void bayar_penKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bayar_penKeyReleased
        mayarnya = Integer.parseInt(bayar_pen.getText());
        totalhitung = Integer.parseInt(total_pen.getText());
        kembaliannya = mayarnya - totalhitung;
        sisa_pen.setText(String.valueOf(kembaliannya));
        
        int Sisanya = Integer.parseInt(sisa_pen.getText());
        if (Sisanya > -1) {
            status_pen.setText("Lunas");
        } else if(Sisanya < 0) {
        status_pen.setText("Belum Lunas");
        }
        
        
    }//GEN-LAST:event_bayar_penKeyReleased

    private void sisa_penKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sisa_penKeyReleased
        
    }//GEN-LAST:event_sisa_penKeyReleased

    private void pengerjaan_penActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pengerjaan_penActionPerformed
        Object selectedItem = pengerjaan_pen.getSelectedItem();
                    if (selectedItem != null)
                    {
                        selectedItemStrPengerjaan = selectedItem.toString();
                        //selectedItemStr buat ngambil Value
                    }
    }//GEN-LAST:event_pengerjaan_penActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_jPanel1MouseDragged

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
            java.util.logging.Logger.getLogger(penerimaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(penerimaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(penerimaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(penerimaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new penerimaan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bayar_pen;
    private javax.swing.JTextField berat_pen;
    private javax.swing.JLabel harga_pen;
    private javax.swing.JComboBox<String> idjc_pen;
    private javax.swing.JComboBox<String> idpel_pen;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea ket_pen;
    private javax.swing.JTextField no_pen;
    private javax.swing.JComboBox<String> pengerjaan_pen;
    private com.toedter.calendar.JDateChooser selesai_pen;
    private javax.swing.JButton simpan_pel;
    private javax.swing.JTextField sisa_pen;
    private javax.swing.JTextField status_pen;
    private javax.swing.JTable tabel_pen;
    private javax.swing.JButton tambah_pel;
    private javax.swing.JTextField total_pen;
    // End of variables declaration//GEN-END:variables
}
