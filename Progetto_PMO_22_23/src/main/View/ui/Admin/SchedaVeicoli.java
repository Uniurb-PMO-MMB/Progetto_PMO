package main.View.ui.Admin;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.swing.table.DefaultTableModel;

import main.Controller.Controller;
import main.Controller.ClassHelper;
import main.Controller.FileManager;
import main.Model.Lavoro.Issue;
import main.Model.Lavoro.Interfaces.WorkerType;
import main.Model.Veicolo.VehicleBox;
import main.Model.Veicolo.Interfaces.SpecificVehicle;
import main.View.ViewController;


public class SchedaVeicoli extends javax.swing.JFrame {

    private List<SpecificVehicle> vehicles = ClassHelper.getVehicles();
    private List<VehicleBox> boxes = ClassHelper.getBoxes();
    private List<Issue> issues = ClassHelper.getIssues();

    private WorkerType wType = null;

    /**
        Scheda Veicoli
    */
    public SchedaVeicoli() {

        initComponents();
        
    }

    private void initComponents() {

        btnEsporta1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        btnAggiorna = new javax.swing.JButton();
        btnSalva = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtProblemi = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        btnEsporta1.setBackground(new java.awt.Color(69, 162, 157));
        btnEsporta1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEsporta1.setText("Esporta");

        setTitle("TabellaAssegnaProblemi");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(225, 0, 50));

        jLabel5.setFont(new java.awt.Font("Swis721 Ex BT", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Scheda veicolo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        table.setFont(new java.awt.Font("Swis721 Ex BT", 0, 16)); // NOI18N

        DefaultTableModel model = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };

        model.addColumn("Targa");
        model.addColumn("Tipo");
        model.addColumn("Marca");
        model.addColumn("Modello");
        model.addColumn("Colore");
        model.addColumn("Anno Produzione");
        model.addColumn("Problema");
        model.addColumn("Proprietario");

        for(SpecificVehicle vehicle : vehicles){
            if(!vehicle.getIssue().isEmpty()){
                model.addRow(new Object[]{  vehicle.getPlateNumber(), 
                                            vehicle.getType(),
                                            vehicle.getBrand(), 
                                            vehicle.getModel(), 
                                            vehicle.getColor(), 
                                            vehicle.getYear(),
                                            vehicle.getIssue().get().getIssueId(),
                                            vehicle.getCustomer()
                                        }
                            );
            }else
                model.addRow(new Object[]{  vehicle.getPlateNumber(), 
                                            vehicle.getType(),
                                            vehicle.getBrand(), 
                                            vehicle.getModel(), 
                                            vehicle.getColor(), 
                                            vehicle.getYear(),
                                            " ",
                                            vehicle.getCustomer()
                                        }
                            );  
        }

        table.setModel(model);

        table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jPanel2.setBackground(new java.awt.Color(27, 68, 128));

        btnAggiorna.setBackground(new java.awt.Color(27, 68, 128));
        btnAggiorna.setFont(new java.awt.Font("Swis721 Ex BT", 1, 14)); // NOI18N
        btnAggiorna.setForeground(new java.awt.Color(240, 240, 240));
        btnAggiorna.setText("Aggiorna");
        btnAggiorna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAggiornaActionPerformed(evt);
            }
        });

        btnSalva.setBackground(new java.awt.Color(27, 68, 128));
        btnSalva.setFont(new java.awt.Font("Swis721 Ex BT", 1, 14)); // NOI18N
        btnSalva.setForeground(new java.awt.Color(240, 240, 240));
        btnSalva.setText("Salva");
        btnSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Swis721 Ex BT", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("Tipo");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nulla", "Meccanico", "Carrozziere", "Gommista" }));

        txtProblemi.setColumns(20);
        txtProblemi.setRows(5);
        jScrollPane2.setViewportView(txtProblemi);

        jLabel8.setFont(new java.awt.Font("Swis721 Ex BT", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(240, 240, 240));
        jLabel8.setText("Prezzo");

        jTextField1.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()) && !(e.getKeyChar() == '.')) // limit textfield to 4 characters
                    e.consume();
            }

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAggiorna, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalva, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField1))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAggiorna)
                    .addComponent(btnSalva))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 931, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAggiornaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAggiornaActionPerformed
        
        if(table.getSelectedRowCount() == 1){ 
            
            //Se una sola riga e selezionata aggiornala
            String problemi = txtProblemi.getText();
            String tipo = jComboBox1.getSelectedItem().toString();
            String id = table.getValueAt(table.getSelectedRow(), 6).toString();
            double prezzo = 0.0;
            
            if(tipo.equals("Nulla"))
                ViewController.showInfoMessage("Impostato il veicolo con nessun lavoro da fare");
            
            else {
            
                // prendo il tipo di lavoro della issue
                wType = ViewController.getWorkerType(tipo);
                // prendo il prezzo della issue
                prezzo = Double.parseDouble(jTextField1.getText());

                // se la issue non ha un id, la creo
                if(id.equals(" ")){

                    int issueId = ViewController.createIssue( issues, wType, problemi, prezzo);
                    
                    table.setValueAt(issueId, table.getSelectedRow(),6);
                    
                    ViewController.setVehicleIssue( vehicles.stream()
                                                        .filter(v -> v.getPlateNumber().equals(table.getValueAt(table.getSelectedRow(), 0)))
                                                        .findFirst().get(), 
                                                issues.stream()
                                                        .filter(i -> i.getIssueId() == issueId)
                                                        .findFirst().get());

                }   
                // altrimenti aggiorno la issue
                else {
                    int issueId = Integer.parseInt(id);
                    
                    Issue issue = issues.stream()
                                        .filter(i -> i.getIssueId() == issueId)
                                        .findFirst().get();
                    
                    int issuePos = Controller.findRowById(ClassHelper.issuePath, id, 0);

                    // se il tipo di lavoro è lo stesso, aggiorno solo i valori
                    if(issue.getIssueType().equals(wType)){

                        issue.setPrice(prezzo);
                        issue.setDescription(problemi);

                        ViewController.updateIssue(issue, issuePos, problemi, prezzo);

                    }   
                    // altrimenti aggiorno il tipo di lavoro e i valori
                    else {
                        
                        ViewController.updateIssue(issue, issuePos, wType, problemi, prezzo);

                        SpecificVehicle vehicle = vehicles.stream()
                                                    .filter(v -> v.getIssue().isPresent())
                                                    .filter(v -> v.getIssue().get().getIssueId() == issueId)
                                                    .findFirst().get();

                        VehicleBox box = boxes.stream()
                                                .filter(b -> b.getVehicle().isPresent())
                                                .filter(b -> b.getVehicle().get().getPlateNumber().equals(vehicle.getPlateNumber()))
                                                .findFirst().orElse(null);
                        if(box != null){
                            int pos = Controller.findRowById(ClassHelper.boxPath, String.valueOf(box.getBoxNumber()), 0);
                                                        
                            box.setVehicle(Optional.empty());
                            box.setBoxTime(Optional.empty());

                            try {

                                FileManager.modifyRow(ClassHelper.boxPath, pos, "", 2);
                                FileManager.modifyRow(ClassHelper.boxPath, pos, "", 3);

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            ViewController.backInQueue(boxes, vehicle.getPlateNumber());
                        }

                        ViewController.addQueue(vehicle);
                        ViewController.putVehicleInBox(boxes);
                    }
                }
            }
                //reset dei campi
                ViewController.showInfoMessage("Dati aggiornati con successo!");  
                txtProblemi.setText("");
                jComboBox1.setSelectedItem("Nulla");
                jTextField1.setText("");
                
        }else {

            if(table.getRowCount() == 0 )
            {
                ViewController.showWarningMessage( "La tabella è vuota!");  
            }else {
                ViewController.showWarningMessage("Perfavore seleziona solo la riga da aggiornare!");  
            }

        }

    }//GEN-LAST:event_btnAggiornaActionPerformed
        
    private void btnSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvaActionPerformed
        
        ViewController.showInfoMessage("Dati salvati con successo!");

        this.setVisible(false);
    
    }//GEN-LAST:event_btnSalvaActionPerformed

    
    //rimuovere inutilizzata
    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked

        Object tableIssueId = table.getValueAt(table.getSelectedRow(),6);
        String problemi = tableIssueId.toString();
        WorkerType wType = null;
        String tipo = null;
        double costi = 0;

        if(!problemi.equals(" "))
        {
            Optional<Issue> issue = issues.stream()
                            .filter(i -> i.getIssueId() == Integer.parseInt(tableIssueId.toString()))
                            .findFirst();

                problemi = issue.get().getDescription();
                wType = issue.get().getIssueType();
                costi = issue.get().getPrice();

        }

        txtProblemi.setText(problemi);

        if(wType != null){
        
            tipo = ViewController.getStringWorkerType(wType);

            jComboBox1.setSelectedItem(tipo);
        }else
            jComboBox1.setSelectedItem("Nulla");
        
        jTextField1.setText(String.valueOf(costi));
    }//GEN-LAST:event_tableMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAggiorna;
    private javax.swing.JButton btnEsporta1;
    private javax.swing.JButton btnSalva;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable table;
    private javax.swing.JTextArea txtProblemi;
    // End of variables declaration//GEN-END:variables
}
