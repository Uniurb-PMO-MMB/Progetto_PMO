package main.View.ui.Lavori;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import main.Controller.ClassHelper;
import main.Model.ModelController;
import main.Model.Lavoro.Coachbuilder;
import main.Model.Lavoro.Interfaces.BaseWorker;
import main.Model.Lavoro.Interfaces.WorkerType;
import main.Model.Veicolo.VehicleBox;
import main.Model.Veicolo.WorksDone;
import main.Model.Veicolo.Interfaces.SpecificVehicle;
import main.View.ViewController;


public class ViewCoachbuilder extends javax.swing.JFrame {

    private List<VehicleBox> boxes = ClassHelper.getBoxes();
    private List<BaseWorker> workers = ClassHelper.getWorkers();
    private List<SpecificVehicle> vehicles = ClassHelper.getVehicles();
    private List<WorksDone> worksDone = ClassHelper.getWorksDone();

    private Coachbuilder coachbuilder = (Coachbuilder) workers.stream().filter(w -> w.getWorkType().equals(WorkerType.COACHBUILDER)).findFirst().get();

    private DefaultTableModel model = new DefaultTableModel();


    /**
     * Creates new form Carrozziere
     */
    public ViewCoachbuilder() {
        initComponents();
        
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanVernice = new javax.swing.JPanel();
        btnCambiaCol = new javax.swing.JButton();
        jTxtCol1 = new javax.swing.JTextField();
        jTxtCol2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnVerniciatura = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtInfo = new javax.swing.JTextArea();
        btnPosticipa = new javax.swing.JButton();
        btnCompleta = new javax.swing.JButton();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanVernice.setVisible(false);
        jPanel1.setBackground(new java.awt.Color(225, 0, 50));

        jLabel1.setFont(new java.awt.Font("Swis721 Ex BT", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Carrozziere");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addContainerGap())
        );

        model = setTable();

        jTable1.setModel(model);

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanVernice.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnCambiaCol.setFont(new java.awt.Font("Swis721 Ex BT", 3, 12)); // NOI18N
        btnCambiaCol.setText("Cambia Colore");
        btnCambiaCol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCambiaColMouseClicked(evt);
            }
        });

        jTxtCol1.setBackground(new java.awt.Color(240, 240, 240));
        jTxtCol1.setBorder(javax.swing.BorderFactory.createTitledBorder("Colore Prima"));


        jTxtCol2.setBackground(new java.awt.Color(240, 240, 240));
        jTxtCol2.setBorder(javax.swing.BorderFactory.createTitledBorder("Colore Dopo"));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Rosso", "Rosa", "Arancio", "Giallo", "Verde", "Turchese", "Azzurro", "Blu", "Nero", "Bianco", "Grigio", "Argento", "Oro" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanVerniceLayout = new javax.swing.GroupLayout(jPanVernice);
        jPanVernice.setLayout(jPanVerniceLayout);
        jPanVerniceLayout.setHorizontalGroup(
            jPanVerniceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanVerniceLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCambiaCol)
                .addContainerGap())
            .addGroup(jPanVerniceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTxtCol1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTxtCol2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanVerniceLayout.setVerticalGroup(
            jPanVerniceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanVerniceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanVerniceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCambiaCol))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanVerniceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtCol1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtCol2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
        );

        btnVerniciatura.setFont(new java.awt.Font("Swis721 Ex BT", 3, 12)); // NOI18N
        btnVerniciatura.setText("Vernciatura");
        btnVerniciatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerniciaturaActionPerformed(evt);
            }
        });

        txtInfo.setColumns(20);
        txtInfo.setRows(5);
        txtInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("Sommario Problemi"));
        jScrollPane3.setViewportView(txtInfo);

        btnPosticipa.setFont(new java.awt.Font("Swis721 Ex BT", 3, 12)); // NOI18N
        btnPosticipa.setText("Posticipa");
        btnPosticipa.setEnabled(false);
        btnPosticipa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPosticipaActionPerformed(evt);
            }
        });

        btnCompleta.setFont(new java.awt.Font("Swis721 Ex BT", 3, 12)); // NOI18N
        btnCompleta.setText("Completa");
        btnCompleta.setEnabled(false);
        btnCompleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompletaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPosticipa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCompleta))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnVerniciatura)
                    .addComponent(jPanVernice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnVerniciatura)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanVernice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPosticipa)
                    .addComponent(btnCompleta))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCambiaColMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCambiaColMouseClicked

        String colore = jComboBox1.getSelectedItem().toString();
        
        if(!colore.equals("") && jTable1.isRowSelected(jTable1.getSelectedRow()) ){

            SpecificVehicle vehicle = vehicles.stream()
                                        .filter(v -> v.getPlateNumber().equals(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString()))
                                        .findFirst().get();
            
            ModelController.changeColor(vehicle, colore);

            jTable1.setValueAt(colore, jTable1.getSelectedRow(), 4);
            jPanVernice.setVisible(false);
            
        }else {
            ViewController.showWarningMessage( "veicolo non selezionato o colore non selezionato");
        }
                
    }//GEN-LAST:event_btnCambiaColMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        String colore1 = jTable1.getValueAt(jTable1.getSelectedRow(),4).toString();
        String problema = jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString();
    
        jTxtCol1.setText(colore1);
        txtInfo.setText(problema);

        if(jTable1.getValueAt(jTable1.getSelectedRow(), 6).equals("")){
            btnCompleta.setEnabled(false);
        }else
            btnCompleta.setEnabled(true);

        btnPosticipa.setEnabled(true);
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnVerniciaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerniciaturaActionPerformed
        
        jPanVernice.setVisible(true);
    }//GEN-LAST:event_btnVerniciaturaActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        
        String colore2 = (String) jComboBox1.getSelectedItem();
        jTxtCol2.setText(colore2);
        
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void btnPosticipaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPosticipaActionPerformed

        ViewController.backInQueue(boxes, jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());

        model = setTable();

        jTable1.setModel(model);

        jTxtCol1.setText("");
        jTxtCol2.setText("");
        jPanVernice.setVisible(false);
        
        ViewController.showInfoMessage("Veicolo posticipato");

    }//GEN-LAST:event_btnPosticipaActionPerformed

    private void btnCompletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompletaActionPerformed
        
        if(!jTable1.isRowSelected(jTable1.getSelectedRow() ) ){
            ViewController.showWarningMessage("Selezionare una riga");
        } else{

            int boxId = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            VehicleBox box = boxes.stream().filter(b -> b.getBoxNumber() == boxId).findFirst().get();

            ModelController.fixCoachbuilder(box, coachbuilder, workers, worksDone, vehicles, boxes);

            model = setTable();
            jTable1.setModel(model);

            txtInfo.setText("");

            btnCompleta.setEnabled(false);
        } 
    }//GEN-LAST:event_btnCompletaActionPerformed

    public DefaultTableModel setTable(){
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        BaseWorker worker = null;

        model.addColumn("BOX ID");
        model.addColumn("Targa");
        model.addColumn("Marca");
        model.addColumn("Modello");
        model.addColumn("Colore");
        model.addColumn("Problema");
        model.addColumn("Dipendente");

        if( !boxes.isEmpty() ){
            for( VehicleBox box : boxes ){
                if(box.getBoxType().equals(WorkerType.COACHBUILDER)){
                    if( !box.getVehicle().isEmpty() ){
                        if(!box.getWorkerId().isEmpty()){

                            worker = workers.stream().filter(w -> box.getWorkerId().get().equals(w.getWorkerId())).findFirst().get();

                            model.addRow(new Object[]{  box.getBoxNumber(), 
                                                        box.getVehicle().get().getPlateNumber(), 
                                                        box.getVehicle().get().getBrand(),
                                                        box.getVehicle().get().getModel(),
                                                        box.getVehicle().get().getColor(), 
                                                        box.getVehicle().get().getIssue().get().getDescription(),
                                                        worker.getWorkerName() + " " + worker.getWorkerSurname(),
                                                    });
                        }else
                            model.addRow(new Object[]{  box.getBoxNumber(), 
                                                        box.getVehicle().get().getPlateNumber(), 
                                                        box.getVehicle().get().getBrand(),
                                                        box.getVehicle().get().getModel(),
                                                        box.getVehicle().get().getColor(), 
                                                        box.getVehicle().get().getIssue().get().getDescription(),
                                                        ""});
                    }
                }
            }
        }

        return model;
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
            java.util.logging.Logger.getLogger(ViewCoachbuilder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCoachbuilder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCoachbuilder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCoachbuilder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCoachbuilder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiaCol;
    private javax.swing.JButton btnCompleta;
    private javax.swing.JButton btnPosticipa;
    private javax.swing.JButton btnVerniciatura;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanVernice;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea txtInfo;
    private javax.swing.JTextField jTxtCol1;
    private javax.swing.JTextField jTxtCol2;
    // End of variables declaration//GEN-END:variables
}
