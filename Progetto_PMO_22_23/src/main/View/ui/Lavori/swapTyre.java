package main.View.ui.Lavori;

import java.io.IOException;
import java.util.Set;

import javax.swing.table.DefaultTableModel;

import main.Controller.ClassHelper;
import main.Controller.FileManager;
import main.Model.ModelController;
import main.Model.Lavoro.TyreDealer;
import main.Model.Veicolo.Tyre;
import main.Model.Veicolo.Interfaces.TyreType;


public class swapTyre extends javax.swing.JFrame {

    private Tyre tyre;
    private TyreDealer tyreDealer;
    private Set<Tyre> tyresStock = ClassHelper.getTyres();

    /**
     * Creates new form swapTyre
     */
    public swapTyre(Tyre tyre,  TyreDealer tyreDealer) {

        this.tyre = tyre;
        this.tyreDealer = tyreDealer;

        initComponents();
        jTable1.setAutoCreateRowSorter(true);
        
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSelection = new javax.swing.JButton();
        txtSeason = new javax.swing.JTextField();
        txtBrand = new javax.swing.JTextField();

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Michelin", "invernali"},
                {"Michelin", "estive"},
                {"Michelin", "4_stagioni"},
                {"Tigar", "invernali"},
                {"Tigar", "estive"},
                {"Tigar", "4_stagioni"},
                {"GoodYear", "invernali"},
                {"GoodYear", "estive"},
                {"GoodYear", "4_stagioni"},
                {"Continental", "invernali"},
                {"Continental", "estive"},
                {"Continental", "4_stagioni"}
            },
            new String [] {
                "Marca", "Stagione"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.setBackground(new java.awt.Color(225, 0, 50));

        jLabel1.setFont(new java.awt.Font("Swis721 Ex BT", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("MARCA");

        jLabel2.setFont(new java.awt.Font("Swis721 Ex BT", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("STAGIONE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        btnSelection.setFont(new java.awt.Font("Swis721 Ex BT", 3, 14)); // NOI18N
        btnSelection.setText("SELEZIONA");
        btnSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectionActionPerformed(evt);
            }
        });

        txtSeason.setEditable(false);
        txtSeason.setFont(new java.awt.Font("Swis721 Ex BT", 1, 12)); // NOI18N
        txtSeason.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSeason.setBorder(null);
        txtSeason.setSelectedTextColor(new java.awt.Color(240, 240, 240));

        txtBrand.setEditable(false);
        txtBrand.setFont(new java.awt.Font("Swis721 Ex BT", 1, 12)); // NOI18N
        txtBrand.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBrand.setActionCommand("<Not Set>");
        txtBrand.setBorder(null);
        txtBrand.setSelectedTextColor(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtBrand)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSeason, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                    .addComponent(jSeparator2)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(btnSelection)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSeason, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSelection))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectionActionPerformed
    
        TyreType tyreType = null;

        if(txtSeason.getText().equals("invernali")){
            tyreType = TyreType.WINTER;
        }else if(txtSeason.getText().equals("estive")){
            tyreType = TyreType.SUMMER;
        }else if(txtSeason.getText().equals("4_stagioni")){
            tyreType = TyreType.ALLSEASON;
        }

        try {
            FileManager.modifyByWord(ClassHelper.tyrePath, 1, tyre.getPlateNumber(),  2, String.valueOf(tyre.getTyreType()), String.valueOf(tyreType));
            FileManager.modifyByWord(ClassHelper.tyrePath, 1, tyre.getPlateNumber(),  3, tyre.getTyreBrand(), txtBrand.getText());
            FileManager.modifyAll(ClassHelper.tyrePath, 1, tyre.getPlateNumber(),  4, String.valueOf(100.0));
        } catch (IOException e) {
            e.printStackTrace();
        }

        tyre.setTyreType(txtSeason.getText());
        tyre.setTyreBrand(txtBrand.getText());
        ModelController.changeAllTyresUsages(tyreDealer, tyresStock, tyre.getPlateNumber());

        // se i campi sono stati riempiti(ovver ruota selezionata) permette il montaggio.
        if(!"".equals(txtBrand.getText())&& !"".equals(txtSeason.getText() ) ){
            this.setVisible(false);
            
        }
    }//GEN-LAST:event_btnSelectionActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
        
        //setta i dati 
        String tblBrand = tblModel.getValueAt(jTable1.getSelectedRow(),0).toString();
        String tblSeason = tblModel.getValueAt(jTable1.getSelectedRow(),1).toString();
        
        txtBrand.setText(tblBrand);
        txtSeason.setText(tblSeason);
        
    }//GEN-LAST:event_jTable1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelection;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtSeason;
    // End of variables declaration//GEN-END:variables
}
