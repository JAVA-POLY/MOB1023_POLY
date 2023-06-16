package main.video3;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import main.CongViec;
import main.TrangThai;

/**
 *
 * @author hangnt
 */
public class ViewCongViec extends javax.swing.JFrame {

    private DefaultTableModel dtm = new DefaultTableModel();
    private QuanLyCongViecService quanLyCongViecService = new QuanLyCongViecService();
    private List<CongViec> lists = new ArrayList<>();
    private String path = "data.txt";

    public ViewCongViec() {
        initComponents();
        dtm = (DefaultTableModel) tblCongViec.getModel();
        lists = quanLyCongViecService.getAll();
        showDataTable(lists);
        fillData(0);
    }

    private void showDataTable(List<CongViec> listCongViec) {
        dtm.setRowCount(0);
        for (CongViec congViec : listCongViec) {
            dtm.addRow(new Object[]{congViec.getTenCongViec(),
                congViec.getTenTheLoai(), congViec.getTrangThai(),
                congViec.getThoiGianHoanThanh()});
        }
    }

    private CongViec getForm() {
        CongViec congViec = new CongViec();
        String tenCV = txtTenCongViec.getText();
        String theLoai = (String) cbbTheLoai.getSelectedItem();
        Long thoiGianHoanThanh = Long.valueOf(txtThoiGianHoanThanh.getText());
        congViec.setTenCongViec(tenCV);
        congViec.setTenTheLoai(theLoai);
        congViec.setThoiGianHoanThanh(thoiGianHoanThanh);
        if (rdoChuaThucHien.isSelected()) {
            congViec.setTrangThai(TrangThai.CHUA_THUC_HIEN);
        } else if (rdoDangThucHien.isSelected()) {
            congViec.setTrangThai(TrangThai.DANG_THUC_HIEN);
        } else {
            congViec.setTrangThai(TrangThai.DA_THUC_HIEN);
        }
        return congViec;
    }

    private void fillData(int index) {
        CongViec congViec = quanLyCongViecService.getAll().get(index);
        txtTenCongViec.setText(congViec.getTenCongViec());
        txtThoiGianHoanThanh.setText(String.valueOf(congViec.getThoiGianHoanThanh()));
        cbbTheLoai.setSelectedItem(congViec.getTenTheLoai());
        switch (congViec.getTrangThai()) {
            case CHUA_THUC_HIEN ->
                rdoChuaThucHien.setSelected(true);
            case DANG_THUC_HIEN ->
                rdoDangThucHien.setSelected(true);
            default ->
                rdoDaThucHien.setSelected(true);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTenCongViec = new javax.swing.JTextField();
        cbbTheLoai = new javax.swing.JComboBox<>();
        rdoChuaThucHien = new javax.swing.JRadioButton();
        rdoDangThucHien = new javax.swing.JRadioButton();
        rdoDaThucHien = new javax.swing.JRadioButton();
        txtThoiGianHoanThanh = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnDoc = new javax.swing.JButton();
        btnGhi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCongViec = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setText("QUAN LY CONG VIEC");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Information"));

        jLabel2.setText("Ten CV:");

        jLabel3.setText("Trang thai:");

        jLabel4.setText("The loai:");

        jLabel5.setText("Thoi gian hoan thanh: ");

        cbbTheLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Việc nhà", "Học Tập", "Giải trí", "Ăn", "Ngủ", "Lăn" }));

        buttonGroup1.add(rdoChuaThucHien);
        rdoChuaThucHien.setSelected(true);
        rdoChuaThucHien.setText("Chua thuc hien");

        buttonGroup1.add(rdoDangThucHien);
        rdoDangThucHien.setText("Dang thuc hien");

        buttonGroup1.add(rdoDaThucHien);
        rdoDaThucHien.setText("Da thuc hien");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdoDangThucHien)
                            .addComponent(rdoChuaThucHien)
                            .addComponent(rdoDaThucHien)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenCongViec, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(63, 63, 63)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtThoiGianHoanThanh, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(175, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(txtTenCongViec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(rdoChuaThucHien)
                    .addComponent(txtThoiGianHoanThanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoDangThucHien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoDaThucHien)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        btnThem.setText("Them");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sua");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnDoc.setText("Doc");
        btnDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocActionPerformed(evt);
            }
        });

        btnGhi.setText("Ghi");
        btnGhi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhiActionPerformed(evt);
            }
        });

        tblCongViec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên công việc", "Thể loại", "Trạng thái", "Thời gian hoàn thành"
            }
        ));
        tblCongViec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCongViecMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCongViec);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(197, 197, 197))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnThem)
                .addGap(50, 50, 50)
                .addComponent(btnSua)
                .addGap(83, 83, 83)
                .addComponent(btnXoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDoc)
                .addGap(98, 98, 98)
                .addComponent(btnGhi)
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnDoc)
                    .addComponent(btnGhi))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        JOptionPane.showMessageDialog(this, quanLyCongViecService.themCV(this.getForm()));
        showDataTable(lists);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int row = tblCongViec.getSelectedRow();
        JOptionPane.showMessageDialog(this, quanLyCongViecService.suaCV(row, getForm()));
        showDataTable(lists);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row = tblCongViec.getSelectedRow();
        JOptionPane.showMessageDialog(this, quanLyCongViecService.xoaCongViec(row));
        showDataTable(lists);
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblCongViecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCongViecMouseClicked
        int index = tblCongViec.getSelectedRow();
        fillData(index);
    }//GEN-LAST:event_tblCongViecMouseClicked

    private void btnDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocActionPerformed
        lists.clear();
        JOptionPane.showMessageDialog(this, quanLyCongViecService.docFile(path));
        showDataTable(lists);
    }//GEN-LAST:event_btnDocActionPerformed

    private void btnGhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhiActionPerformed
        JOptionPane.showMessageDialog(this, quanLyCongViecService.ghiFile(path));
    }//GEN-LAST:event_btnGhiActionPerformed

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
            java.util.logging.Logger.getLogger(ViewCongViec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCongViec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCongViec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCongViec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCongViec().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoc;
    private javax.swing.JButton btnGhi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbTheLoai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoChuaThucHien;
    private javax.swing.JRadioButton rdoDaThucHien;
    private javax.swing.JRadioButton rdoDangThucHien;
    private javax.swing.JTable tblCongViec;
    private javax.swing.JTextField txtTenCongViec;
    private javax.swing.JTextField txtThoiGianHoanThanh;
    // End of variables declaration//GEN-END:variables
}
