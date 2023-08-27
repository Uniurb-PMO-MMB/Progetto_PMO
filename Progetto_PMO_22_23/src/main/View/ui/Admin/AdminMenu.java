package main.View.ui.Admin;

import java.util.List;
import java.util.Optional;

import javax.swing.table.DefaultTableModel;

import main.Controller.ClassHelper;
import main.Model.Lavoro.Issue;
import main.Model.Lavoro.Interfaces.BaseWorker;
import main.Model.Veicolo.VehicleBox;
import main.Model.Veicolo.Interfaces.SpecificVehicle;
import main.View.ViewController;


public class AdminMenu extends javax.swing.JFrame {

    private List<BaseWorker> workers = ClassHelper.getWorkers();
    private List<VehicleBox> Boxes = ClassHelper.getBoxes();

    private DefaultTableModel model = new DefaultTableModel();
    /**
     * Creates new form AdminMenu
     */
    public AdminMenu() {

        initComponents();
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAggiorna = new javax.swing.JButton();
        btnAggiungi = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnBoxes = new javax.swing.JButton();
        btnVehicles = new javax.swing.JButton();
        btnWorker = new javax.swing.JButton();
        btnIssues = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setLocationRelativeTo(null);

        model = setTable();

        jTable1.setModel(model);

        jScrollPane1.setViewportView(jTable1);

        btnAggiorna.setText("CARICA TABELLA");
        btnAggiorna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAggiornaActionPerformed(evt, model);
            }
        });

        btnAggiungi.setText("ASSEGNA VEICOLO");
        btnAggiungi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAggiungiActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(27, 68, 128));

        btnBoxes.setBackground(new java.awt.Color(27, 68, 128));
        btnBoxes.setFont(new java.awt.Font("Swis721 Ex BT", 3, 14)); // NOI18N
        btnBoxes.setForeground(new java.awt.Color(255, 255, 255));
        btnBoxes.setText("BOX MENU");
        btnBoxes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoxesActionPerformed(evt);
            }
        });

        btnVehicles.setBackground(new java.awt.Color(27, 68, 128));
        btnVehicles.setFont(new java.awt.Font("Swis721 Ex BT", 3, 14)); // NOI18N
        btnVehicles.setForeground(new java.awt.Color(255, 255, 255));
        btnVehicles.setText("REGISTRAZIONE VEICOLO");
        btnVehicles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVehiclesActionPerformed(evt);
            }
        });

        btnWorker.setBackground(new java.awt.Color(27, 68, 128));
        btnWorker.setFont(new java.awt.Font("Swis721 Ex BT", 3, 14)); // NOI18N
        btnWorker.setForeground(new java.awt.Color(255, 255, 255));
        btnWorker.setText("IMPIEGATI");
        btnWorker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWorkerActionPerformed(evt);
            }
        });

        btnIssues.setBackground(new java.awt.Color(27, 68, 128));
        btnIssues.setFont(new java.awt.Font("Swis721 Ex BT", 3, 14)); // NOI18N
        btnIssues.setForeground(new java.awt.Color(255, 255, 255));
        btnIssues.setText("SCHEDA VEICOLO");
        btnIssues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIssuesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnWorker, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVehicles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBoxes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIssues, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(btnWorker)
                .addGap(18, 18, 18)
                .addComponent(btnBoxes)
                .addGap(20, 20, 20)
                .addComponent(btnIssues, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVehicles)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(225, 0, 50));

        jLabel1.setFont(new java.awt.Font("Swis721 Ex BT", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MENU TITOLARE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                    .addComponent(btnAggiorna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAggiungi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAggiorna)
                        .addComponent(btnAggiungi))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAggiornaActionPerformed(java.awt.event.ActionEvent evt, DefaultTableModel model) {//GEN-FIRST:event_btnton3ActionPerformed
        ViewController.showInfoMessage("Aggiornamento tabella");
        model = setTable();

        jTable1.setModel(model);
        
    }//GEN-LAST:event_btnton3ActionPerformed

    private void btnAggiungiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAggiungiActionPerformed

        ViewController.putVehicleInBox();
        
    }//GEN-LAST:event_btnAggiungiActionPerformed

    private void btnBoxesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoxesActionPerformed
        
        new GestioneBox().setVisible(true);

    }//GEN-LAST:event_btnBoxesActionPerformed

    private void btnVehiclesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVehiclesActionPerformed
        
        new TabellaLavori().setVisible(true);

    }//GEN-LAST:event_btnVehiclesActionPerformed

    private void btnWorkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWorkerActionPerformed
        
        new GestioneDipendenti().setVisible(true);
    }//GEN-LAST:event_btnWorkerActionPerformed

    private void btnIssuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIssuesActionPerformed
        
        new SchedaVeicoli().setVisible(true);
    }//GEN-LAST:event_btnIssuesActionPerformed

    public DefaultTableModel setTable(){
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        Optional<BaseWorker> worker = Optional.empty();
        String boxType = "";

        model.addColumn("Boxes N°");
        model.addColumn("TIPOLOGIA");
        model.addColumn("VEICOLO");
        model.addColumn("PROBLEMA");
        model.addColumn("IMPIEGATO");

        if(!Boxes.isEmpty() || !workers.isEmpty()){
            for(VehicleBox box : Boxes){

                boxType = ViewController.getStringWorkerType(box);
                worker = Optional.empty();
                Optional<SpecificVehicle> vehicle = box.getVehicle();

                String plateNumber = "";
                String issueDescription = "";
                String workerNameSurname = "";

                if (!vehicle.isEmpty()) {
                    plateNumber = vehicle.get().getPlateNumber();
                    issueDescription = vehicle.get().getIssue().map(Issue::getDescription).orElse("");
                }

                if (!box.getWorkerId().isEmpty()) {
                    worker = workers.stream().filter(w -> w.getWorkerId() == box.getWorkerId().get()).findFirst();
                    workerNameSurname = worker.get().getWorkerName() + " " + worker.get().getWorkerSurname();
                }

                model.addRow(new Object[]{box.getBoxNumber(), boxType, plateNumber, issueDescription, workerNameSurname});
            }
        
        }else{
            ViewController.showInfoMessage("Non ci sono box o dipendenti da visualizzare");
        }  

        return model;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBoxes;
    private javax.swing.JButton btnVehicles;
    private javax.swing.JButton btnWorker;
    private javax.swing.JButton btnIssues;
    private javax.swing.JButton btnAggiorna;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton btnAggiungi;
    // End of variables declaration//GEN-END:variables
}
