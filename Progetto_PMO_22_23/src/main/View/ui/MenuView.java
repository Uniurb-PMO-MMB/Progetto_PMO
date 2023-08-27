package main.View.ui;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import main.Controller.ClassHelper;
import main.Model.Lavoro.Interfaces.BaseWorker;
import main.Model.Veicolo.VehicleBox;
import main.Model.Veicolo.Interfaces.SpecificVehicle;
import main.View.ViewController;
import main.View.ui.Admin.LoginAdmin;
import main.View.ui.Admin.StoricoLavori;
import main.View.ui.Lavori.ViewCoachbuilder;
import main.View.ui.Lavori.ViewMechanic;
import main.View.ui.Lavori.ViewTyreDealer;


public class MenuView extends javax.swing.JFrame {

    private List<VehicleBox> boxList = ClassHelper.getBoxes();
    private List<BaseWorker>  workerList = ClassHelper.getWorkers();
    private List<SpecificVehicle> vehicleList = ClassHelper.getVehicles();
    private DefaultTableModel model;

    /**
     * Creates new form Menu
     */
    public MenuView() {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblHome = new javax.swing.JLabel();
        lblTyreDl = new javax.swing.JLabel();
        lblMeccanico = new javax.swing.JLabel();
        lblCarrozziere = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPannHome = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        this.setVisible(true);
        jPannHome.setVisible(true);

        jPanel2.setBackground(new java.awt.Color(225, 0, 50));

        jLabel1.setFont(new java.awt.Font("Swis721 Ex BT", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MENU' OFFICINA & AUTORICAMBI");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)        
            .addGap(93, 93, 93))

        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(27, 68, 128));

        lblHome.setFont(new java.awt.Font("Swis721 Ex BT", 3, 17)); // NOI18N
        lblHome.setForeground(new java.awt.Color(240, 240, 240));
        lblHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHome.setText("STORICO LAVORI");
        lblHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomeMouseClicked(evt);
            }
        });

        lblTyreDl.setFont(new java.awt.Font("Swis721 Ex BT", 3, 17)); // NOI18N
        lblTyreDl.setForeground(new java.awt.Color(240, 240, 240));
        lblTyreDl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTyreDl.setText("GOMMISTA");
        lblTyreDl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTyreDlMouseClicked(evt);
            }
        });

        lblMeccanico.setFont(new java.awt.Font("Swis721 Ex BT", 3, 17)); // NOI18N
        lblMeccanico.setForeground(new java.awt.Color(240, 240, 240));
        lblMeccanico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMeccanico.setText("MECCANICO");
        lblMeccanico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMeccanicoMouseClicked(evt);
            }
        });

        lblCarrozziere.setFont(new java.awt.Font("Swis721 Ex BT", 3, 17)); // NOI18N
        lblCarrozziere.setForeground(new java.awt.Color(240, 240, 240));
        lblCarrozziere.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCarrozziere.setText("CARROZIERE");
        lblCarrozziere.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCarrozziereMouseClicked(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(27, 68, 128));
        jButton1.setFont(new java.awt.Font("Swis721 Ex BT", 3, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(240, 240, 240));
        jButton1.setText("ADMIN");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblTyreDl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblMeccanico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblCarrozziere, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(lblHome)
                .addGap(18, 18, 18)
                .addComponent(lblTyreDl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblMeccanico)
                .addGap(18, 18, 18)
                .addComponent(lblCarrozziere)
                .addGap(134, 134, 134)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jPannHome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(11, 19, 32), 1, true));
        
        model = setTable();

        table.setBackground(new java.awt.Color(240, 240, 240));
        table.setModel(model);

        jScrollPane1.setViewportView(table);

        jPanel5.setBackground(new java.awt.Color(11, 19, 32));

        jLabel2.setFont(new java.awt.Font("Swis721 Ex BT", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("I LAVORI DI OGGI:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPannHomeLayout = new javax.swing.GroupLayout(jPannHome);
        jPannHome.setLayout(jPannHomeLayout);
        jPannHomeLayout.setHorizontalGroup(
            jPannHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPannHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPannHomeLayout.setVerticalGroup(
            jPannHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPannHomeLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton2.setFont(new java.awt.Font("Swis721 Ex BT", 3, 14)); // NOI18N
        jButton2.setText("Aggiorna");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPannHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPannHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(22, 22, 22))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseClicked
        
        new StoricoLavori().setVisible(true);
        
    }//GEN-LAST:event_lblHomeMouseClicked

    private void lblTyreDlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTyreDlMouseClicked
        
        new ViewTyreDealer().setVisible(true);
    }//GEN-LAST:event_lblTyreDlMouseClicked

    private void lblMeccanicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        
        new ViewMechanic().setVisible(true);
        
    }//GEN-LAST:event_jLabel3MouseClicked

    private void lblCarrozziereMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCarrozziereMouseClicked
        
        new ViewCoachbuilder().setVisible(true);
    }//GEN-LAST:event_lblCarrozziereMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        
        new LoginAdmin().setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        ViewController.showInfoMessage("Aggiornamento tabella");
        model = setTable();

        table.setModel(model);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    public DefaultTableModel setTable(){
        DefaultTableModel model = new DefaultTableModel(){ 
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            
                            return false;
                        }};
                        
        model.addColumn("BOX ID:");
        model.addColumn("LAVORO");
        model.addColumn("TARGA");
        model.addColumn("PROBLEMA");
        model.addColumn("IMPIEGATO");

        if(!boxList.isEmpty() && !vehicleList.isEmpty()){

            for (VehicleBox box : boxList) {

                String boxType = "";

                boxType = ViewController.getStringWorkerType(box.getBoxType());
                
                if(box.getVehicle().isPresent() && box.getWorkerId().isPresent()){
                    
                    BaseWorker worker = workerList.stream()
                                                    .filter(w -> w.getWorkerId() == box.getWorkerId().get())
                                                    .findFirst().get();
                    
                    model.addRow(new Object[]{  box.getBoxNumber(),
                                                boxType, 
                                                box.getVehicle().get().getPlateNumber(), 
                                                box.getVehicle().get().getIssue().get().getDescription(),
                                                worker.getWorkerName() + " " + worker.getWorkerSurname()
                                            });
                                            
                }else if(box.getWorkerId().isEmpty() && box.getVehicle().isPresent()){

                    model.addRow(new Object[]{  box.getBoxNumber(), 
                                                boxType, 
                                                box.getVehicle().get().getPlateNumber(), 
                                                box.getVehicle().get().getIssue().get().getDescription(),
                                                null});  

                }
            }

        }else {
            ViewController.showWarningMessage(" la tabella e' vuota! ");
        }

        return model;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblHome;
    private javax.swing.JPanel jPannHome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JLabel lblMeccanico;
    private javax.swing.JLabel lblTyreDl;
    private javax.swing.JLabel lblCarrozziere;
    // End of variables declaration//GEN-END:variables
}
