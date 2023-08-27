package main.View.ui.Lavori;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import main.Controller.ClassHelper;
import main.Model.ModelController;
import main.Model.Lavoro.TyreDealer;
import main.Model.Lavoro.Interfaces.BaseWorker;
import main.Model.Lavoro.Interfaces.WorkerType;
import main.Model.Veicolo.Tyre;
import main.Model.Veicolo.VehicleBox;
import main.Model.Veicolo.WorksDone;
import main.Model.Veicolo.Interfaces.SpecificVehicle;
import main.Model.Veicolo.Interfaces.TyreType;
import main.View.ViewController;


public class ViewTyreDealer extends javax.swing.JFrame {

    private List<VehicleBox> boxes = ClassHelper.getBoxes();
    private List<BaseWorker> workers = ClassHelper.getWorkers();
    private List<WorksDone> worksDone = ClassHelper.getWorksDone();
    private List<SpecificVehicle> vehicles = ClassHelper.getVehicles();

    private TyreDealer tyreDealer = (TyreDealer) workers.stream().filter(w -> w.getWorkType().equals(WorkerType.TYREDEALER)).findFirst().get();
        
    private ImageIcon imageCar = new ImageIcon("Progetto_PMO_22_23/src/main/View/foto/car.jpg");
    private ImageIcon imageBike = new ImageIcon("Progetto_PMO_22_23/src/main/View/foto/bike.jpg");

    DefaultTableModel model = new DefaultTableModel();
        
    
    public ViewTyreDealer() {
        
        initComponents();        
        
    }

    private void initComponents() {

        labelPic = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnGom4 = new javax.swing.JButton();
        txtGom1 = new javax.swing.JLabel();
        txtGom2 = new javax.swing.JLabel();
        txtGom4 = new javax.swing.JLabel();
        txtGom3 = new javax.swing.JLabel();
        btnGom3 = new javax.swing.JButton();
        btnGom2 = new javax.swing.JButton();
        btnGom1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtInfo = new javax.swing.JTextArea();
        jButConf = new javax.swing.JButton();
        jButPost = new javax.swing.JButton();

        txtGom1.setVisible(false);
        txtGom2.setVisible(false);
        txtGom3.setVisible(false);
        txtGom4.setVisible(false);
        btnGom1.setVisible(false);
        btnGom2.setVisible(false);
        btnGom3.setVisible(false);
        btnGom4.setVisible(false);
        labelPic.setText("");
        txtInfo.setText("");

        labelPic.setBackground(new java.awt.Color(230, 230, 230));
        labelPic.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelPic.setText("FOTO");
        labelPic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPic.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setBackground(new java.awt.Color(225, 0, 50));

        jLabel1.setFont(new java.awt.Font("Swis721 Ex BT", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GOMMISTA");

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

        table.setBackground(new java.awt.Color(240, 240, 240));
        table.setFont(new java.awt.Font("Swis721 Ex BT", 0, 12)); // NOI18N       

        model = setTable();

        table.setModel(model);

        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtGom2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtGom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtGom4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtGom3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGom4)
                    .addComponent(btnGom1)
                    .addComponent(btnGom3)
                    .addComponent(btnGom2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGom1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGom1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGom2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtGom2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGom3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGom3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGom4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGom4))
                .addContainerGap())
        );

        txtInfo.setEditable(false);
        txtInfo.setColumns(20);
        txtInfo.setRows(5);
        jScrollPane2.setViewportView(txtInfo);

        jButConf.setFont(new java.awt.Font("Swis721 Ex BT", 3, 12)); // NOI18N
        jButConf.setText("CONFERMA");
        jButConf.setEnabled(false);
        jButConf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButConfActionPerformed(evt);
            }
        });

        jButPost.setFont(new java.awt.Font("Swis721 Ex BT", 3, 12)); // NOI18N
        jButPost.setText("POSTICIPA");
        jButPost.setEnabled(false);
        jButPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButPostActionPerformed(evt);
            }

            
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelPic, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jButConf)
                            .addGap(18, 18, 18)
                            .addComponent(jButPost))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPic, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButConf)
                            .addComponent(jButPost)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked

        String vType = boxes.stream()
                            .filter(b -> b.getVehicle().isPresent())
                            .filter(b -> b.getVehicle().get().getPlateNumber().equals(table.getValueAt(table.getSelectedRow(), 1).toString()))
                            .findFirst().get()
                            .getVehicle()
                            .get().getType();

        String problemi = table.getValueAt(table.getSelectedRow(),4).toString();
        
        if(table.getValueAt(table.getSelectedRow(), 5).equals("")){
            jButConf.setEnabled(false);
        }else
            jButConf.setEnabled(true);

        txtInfo.setText(problemi);
        labelPic.setText("");

        List<Tyre> usageList = boxes.stream()
                .filter(b -> b.getVehicle().isPresent())
                .filter(b -> b.getVehicle().get().getPlateNumber().equals(table.getValueAt(table.getSelectedRow(), 1).toString()))
                .findFirst().get()
                .getVehicle()
                .get()
                .getTyre()
                .stream()
                .collect(Collectors.toList());

        if("Macchina".equals(vType)){

            btnGom4.setText("INFO");
            btnGom4.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnGom4ActionPerformed(evt, usageList.get(3));
                }
            });

            btnGom3.setText("INFO");
            btnGom3.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnGom3ActionPerformed(evt, usageList.get(2));
                }
            });

            btnGom2.setText("INFO");
            btnGom2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnGom2ActionPerformed(evt, usageList.get(1));
                }
            });

            btnGom1.setText("INFO");
            btnGom1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnGom1ActionPerformed(evt, usageList.get(0));
                }
            });

            txtGom1.setText(usageList.get(0).getTyreUsage() + "%");
            txtGom1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

            txtGom2.setText(usageList.get(1).getTyreUsage() + "%");
            txtGom2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

            txtGom4.setText(usageList.get(2).getTyreUsage() + "%");
            txtGom4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

            txtGom3.setText(usageList.get(3).getTyreUsage() + "%");
            txtGom3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

            labelPic.setIcon(imageCar) ;
            //setta i textfield visibili
            txtGom1.setVisible(true);
            txtGom2.setVisible(true);
            txtGom3.setVisible(true);
            txtGom4.setVisible(true);

            //setta i bottoni info visibili
            btnGom1.setVisible(true);
            btnGom2.setVisible(true);
            btnGom3.setVisible(true);
            btnGom4.setVisible(true);

        } else if("Moto".equals(vType)){

            btnGom3.setText("INFO");
            btnGom3.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnGom3ActionPerformed(evt, usageList.get(1));
                }
            });

            btnGom1.setText("INFO");
            btnGom1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnGom1ActionPerformed(evt, usageList.get(0));
                }
            });

            txtGom1.setText(usageList.get(0).getTyreUsage() + "%");
            txtGom1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

            txtGom3.setText(usageList.get(1).getTyreUsage() + "%");
            txtGom3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

            labelPic.setIcon(imageBike) ;
             //setta i textfield visibili
            txtGom1.setVisible(true);
            txtGom2.setVisible(false);
            txtGom3.setVisible(true);
            txtGom4.setVisible(false);

            //setta i bottoni info visibili
            btnGom1.setVisible(true);
            btnGom2.setVisible(false);
            btnGom3.setVisible(true);
            btnGom4.setVisible(false);

        }

        jButPost.setEnabled(true);
    }//GEN-LAST:event_tableMouseClicked

    private void btnGom1ActionPerformed(java.awt.event.ActionEvent evt, Tyre t) {//GEN-FIRST:event_btnGom1ActionPerformed
        new swapTyre(t, tyreDealer).setVisible(true);            
    }//GEN-LAST:event_btnGom1ActionPerformed

    private void btnGom2ActionPerformed(java.awt.event.ActionEvent evt, Tyre t) {//GEN-FIRST:event_btnGom2ActionPerformed
        new swapTyre(t, tyreDealer).setVisible(true);
    }//GEN-LAST:event_btnGom2ActionPerformed

    private void btnGom3ActionPerformed(java.awt.event.ActionEvent evt, Tyre t) {//GEN-FIRST:event_btnGom3ActionPerformed
        new swapTyre(t, tyreDealer).setVisible(true);
    }//GEN-LAST:event_btnGom3ActionPerformed

    private void btnGom4ActionPerformed(java.awt.event.ActionEvent evt, Tyre t) {//GEN-FIRST:event_btnGom4ActionPerformed
        new swapTyre(t, tyreDealer).setVisible(true);
    }//GEN-LAST:event_btnGom4ActionPerformed

    private void jButConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButConfActionPerformed
        
        if(!table.isRowSelected(table.getSelectedRow() ) ){
            ViewController.showWarningMessage("Selezionare una riga");
        } else{

                    int boxId = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
                    VehicleBox box = boxes.stream().filter(b -> b.getBoxNumber() == boxId).findFirst().get();

                    ModelController.fixTyreDealer(box,tyreDealer, workers, worksDone, vehicles, boxes);

                    model = setTable();
                    table.setModel(model);

                    labelPic.setIcon(null);
                    labelPic.setText("FOTO");

                    txtInfo.setText("");
                    txtGom1.setVisible(false);
                    txtGom2.setVisible(false);
                    txtGom3.setVisible(false);
                    txtGom4.setVisible(false);

                    btnGom1.setVisible(false);
                    btnGom2.setVisible(false);
                    btnGom3.setVisible(false);
                    btnGom4.setVisible(false);

                    jButConf.setEnabled(false);
                    jButPost.setEnabled(false);
        }         
        
    }//GEN-LAST:event_jButConfActionPerformed

    private void jButPostActionPerformed(ActionEvent evt) {
    
    ViewController.backInQueue(boxes, table.getValueAt(table.getSelectedRow(), 1).toString());

        txtInfo.setText("");

        model = setTable();
        table.setModel(model);
        
        ViewController.showInfoMessage("Posticipato");
    }

    private DefaultTableModel setTable(){

        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                
                return false;
            }
        };

        String tType = "";

        model.addColumn("BOX ID");
        model.addColumn("Targa");
        model.addColumn("Marca gomme");
        model.addColumn("Modello gomme");
        model.addColumn("Problema");
        model.addColumn("Dipendente");

        if( !boxes.isEmpty() ){
            for( VehicleBox box : boxes ){
                if(box.getBoxType().equals(WorkerType.TYREDEALER)){
                    if( !box.getVehicle().isEmpty() ){

                        if(box.getVehicle().get().getTyre().stream().findFirst().get().getTyreType().equals(TyreType.WINTER))
                            tType = "Invernali";
                        else if(box.getVehicle().get().getTyre().stream().findFirst().get().getTyreType().equals(TyreType.SUMMER))
                            tType = "Estive";
                        else if(box.getVehicle().get().getTyre().stream().findFirst().get().getTyreType().equals(TyreType.ALLSEASON))
                            tType = "4 Stagioni";
                        

                        if(!box.getWorkerId().isEmpty()){

                            BaseWorker worker = workers.stream()
                                                        .filter(w -> box.getWorkerId().get().equals(w.getWorkerId()))
                                                        .findFirst().get();

                            model.addRow(new Object[]{  box.getBoxNumber(), 
                                                        box.getVehicle().get().getPlateNumber(), 
                                                        box.getVehicle().get().getTyre().stream().findFirst().get().getTyreBrand(),
                                                        tType,
                                                        box.getVehicle().get().getIssue().get().getDescription(),
                                                        worker.getWorkerName() + " " + worker.getWorkerSurname(),
                                                    });
                        }else
                            model.addRow(new Object[]{  box.getBoxNumber(), 
                                                        box.getVehicle().get().getPlateNumber(),
                                                        box.getVehicle().get().getTyre().stream().findFirst().get().getTyreBrand(),
                                                        tType,
                                                        box.getVehicle().get().getIssue().get().getDescription(),
                                                        ""});
                    }
                }
            }
        }

        return model;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGom1;
    private javax.swing.JButton btnGom2;
    private javax.swing.JButton btnGom3;
    private javax.swing.JButton btnGom4;
    private javax.swing.JButton jButConf;
    private javax.swing.JButton jButPost;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table;
    private javax.swing.JTextArea txtInfo;
    private javax.swing.JLabel labelPic;
    private javax.swing.JLabel txtGom1;
    private javax.swing.JLabel txtGom2;
    private javax.swing.JLabel txtGom3;
    private javax.swing.JLabel txtGom4;
    // End of variables declaration//GEN-END:variables
}
