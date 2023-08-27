package main.View.ui.Lavori;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import main.Controller.ClassHelper;
import main.Model.ModelController;
import main.Model.Lavoro.Mechanic;
import main.Model.Lavoro.Interfaces.BaseWorker;
import main.Model.Lavoro.Interfaces.WorkerType;
import main.Model.Veicolo.VehicleBox;
import main.Model.Veicolo.WorksDone;
import main.Model.Veicolo.Interfaces.SpecificVehicle;
import main.View.ViewController;


public class ViewMechanic extends javax.swing.JFrame {

    private List<VehicleBox> boxes = ClassHelper.getBoxes();
    private List<BaseWorker> workers = ClassHelper.getWorkers();
    private List<WorksDone> worksDone = ClassHelper.getWorksDone();
    private List<SpecificVehicle> vehicles = ClassHelper.getVehicles();

    private Mechanic mechanic = (Mechanic) workers.stream().filter(w -> w.getWorkType().equals(WorkerType.MECHANIC)).findFirst().get();

    private DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form Meccanico
     */
    public ViewMechanic() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnRipara = new javax.swing.JButton();
        btnPost = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtInfo = new javax.swing.JTextArea();

        jPanel1.setBackground(new java.awt.Color(225, 0, 50));

        jLabel1.setFont(new java.awt.Font("Swis721 Ex BT", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("OFFICINA MECCANICA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(291, 291, 291))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        model = setTable();

        table.setModel(model);

        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        btnRipara.setFont(new java.awt.Font("Swis721 Ex BT", 3, 14)); // NOI18N
        btnRipara.setText("RIPARA");
        btnRipara.setEnabled(false);
        btnRipara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRiparaActionPerformed(evt);
            }
        });

        btnPost.setFont(new java.awt.Font("Swis721 Ex BT", 3, 14)); // NOI18N
        btnPost.setText("POSTICIPA");
        btnPost.setEnabled(false);
        btnPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INFO PROBLEMI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Swis721 Ex BT", 3, 14))); // NOI18N

        txtInfo.setEditable(false);
        txtInfo.setColumns(20);
        txtInfo.setLineWrap(true);
        txtInfo.setRows(5);
        txtInfo.setBorder(null);
        jScrollPane2.setViewportView(txtInfo);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRipara, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPost))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRipara)
                            .addComponent(btnPost, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRiparaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRiparaActionPerformed
        
        if(!table.isRowSelected(table.getSelectedRow() ) ){
            ViewController.showWarningMessage("Selezionare una riga");
        } else{

            int boxId = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
            VehicleBox box = boxes.stream().filter(b -> b.getBoxNumber() == boxId).findFirst().get();

            ModelController.fixMechanical(box, mechanic, workers, worksDone, vehicles, boxes);

            model = setTable();
            table.setModel(model);

            btnRipara.setEnabled(false);
        } 

    }//GEN-LAST:event_btnRiparaActionPerformed

    private void btnPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostActionPerformed
        
        ViewController.backInQueue(boxes, table.getValueAt(table.getSelectedRow(), 1).toString());

        txtInfo.setText("");

        model = setTable();
        table.setModel(model);
        
        ViewController.showInfoMessage("Posticipato");
    }//GEN-LAST:event_btnPostActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked

        if(table.isRowSelected(table.getSelectedRow())){
            btnPost.setEnabled(true);
            txtInfo.setText(table.getValueAt(table.getSelectedRow(),4).toString());

            if(table.getValueAt(table.getSelectedRow(), 5).equals(""))
                btnRipara.setEnabled(false);
            else
                btnRipara.setEnabled(true);
        }else
            ViewController.showWarningMessage("Seleziona una riga");

    }//GEN-LAST:event_tableMouseClicked


    public DefaultTableModel setTable() {

        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        model.addColumn("BOX ID");
        model.addColumn("Targa");
        model.addColumn("Marca");
        model.addColumn("Modello");
        model.addColumn("Problema");
        model.addColumn("Dipendente");

        if( !boxes.isEmpty() ){
            for( VehicleBox box : boxes ){
                if(box.getBoxType().equals(WorkerType.MECHANIC)){
                    if( !box.getVehicle().isEmpty() ){
                        if(!box.getWorkerId().isEmpty()){

                            BaseWorker worker = workers.stream().filter(w -> box.getWorkerId().get().equals(w.getWorkerId())).findFirst().get();

                            model.addRow(new Object[]{  box.getBoxNumber(), 
                                                        box.getVehicle().get().getPlateNumber(), 
                                                        box.getVehicle().get().getBrand(),
                                                        box.getVehicle().get().getModel(), 
                                                        box.getVehicle().get().getIssue().get().getDescription(),
                                                        worker.getWorkerName() + " " + worker.getWorkerSurname(),
                                                    });
                        }
                    }
                }
            }
        }
        return model; 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPost;
    private javax.swing.JButton btnRipara;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table;
    private javax.swing.JTextArea txtInfo;
    // End of variables declaration//GEN-END:variables
}
