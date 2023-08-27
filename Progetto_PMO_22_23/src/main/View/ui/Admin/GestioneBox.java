package main.View.ui.Admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import main.Controller.Controller;
import main.Controller.ClassHelper;
import main.Model.Lavoro.Interfaces.BaseWorker;
import main.Model.Lavoro.Interfaces.WorkerType;
import main.Model.Veicolo.VehicleBox;
import main.View.ViewController;


public class GestioneBox extends javax.swing.JFrame {

    private List<VehicleBox> boxList = ClassHelper.getBoxes();
    private List<BaseWorker> workerList = ClassHelper.getWorkers();
    
    private int boxId = 0;
    private WorkerType wType = null;
    private String boxType = "";
    private String impiegato = null;

    private static final String Carrozziere = "Carrozziere";
    private static final String Meccanico = "Meccanico";
    private static final String Gommista = "Gommista";

    /**
     * Creates new form AdminBox2
     */
    public GestioneBox() {

        initComponents();
        
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanMechanic = new javax.swing.JPanel();
        jCombMechanic = new javax.swing.JComboBox<>();
        jCombReparto = new javax.swing.JComboBox<>();
        jPanTyredealer = new javax.swing.JPanel();
        jCombTyredealer = new javax.swing.JComboBox<>();
        jPanCoachbuilder = new javax.swing.JPanel();
        jCombCoachbuilder = new javax.swing.JComboBox<>();
        jButElimina = new javax.swing.JButton();
        jButCrea = new javax.swing.JButton();
        jButMod = new javax.swing.JButton();
        
        jPanMechanic.setVisible(false);
        jPanCoachbuilder.setVisible(false);
        jPanTyredealer.setVisible(false);

        jPanel1.setBackground(new java.awt.Color(225, 0, 50));

        jLabel1.setFont(new java.awt.Font("Swis721 Ex BT", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GESTIONE BOX");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        DefaultTableModel model = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };

        model.addColumn("Box ID");
        model.addColumn("Reparto");
        model.addColumn("ID Dipendente");
        model.addColumn("Dipendente");

        if(!boxList.isEmpty()){ 

            for(VehicleBox box : boxList){
                BaseWorker worker = null;
                
                if(box.getWorkerId().isPresent()){

                    try{
                        worker = workerList.stream()
                                            .filter(x -> x.getWorkerId() == box.getWorkerId().get())
                                            .findFirst().get();
                    }catch(NullPointerException e){
                        ViewController.showErrorMessage("non esiste nessun impiegato con questo id");
                    }
                }

                boxType = ViewController.getStringWorkerType(box);

                boxId = box.getBoxNumber();

                if(worker != null)
                    model.addRow(new Object[]{boxId, boxType, worker.getWorkerId(),worker.getWorkerName() + " " + worker.getWorkerSurname()});
                else
                    model.addRow(new Object[]{boxId, boxType, "","Nessun impiegato"});
            }

        }

        table.setModel(model);

        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });

        jScrollPane1.setViewportView(table);

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jCombReparto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nulla", Meccanico, Gommista, Carrozziere }));

        jCombReparto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCombRepartoItemStateChanged(evt);
            }
        });

        jCombMechanic.addItem("Nessuno");
        jCombTyredealer.addItem("Nessuno");
        jCombCoachbuilder.addItem("Nessuno");

        // Riempie le combobox con i dipendenti
        for(BaseWorker worker : workerList) {
            
            if(worker.getWorkType() == WorkerType.MECHANIC){
                jCombMechanic.addItem(worker.getWorkerName() + " " + worker.getWorkerSurname());
            }
            else if(worker.getWorkType() == WorkerType.TYREDEALER){
                jCombTyredealer.addItem(worker.getWorkerName() + " " + worker.getWorkerSurname());
            }
            else if(worker.getWorkType() == WorkerType.COACHBUILDER){
                jCombCoachbuilder.addItem(worker.getWorkerName() + " " + worker.getWorkerSurname());
            }
        }

        jCombMechanic.setBorder(javax.swing.BorderFactory.createTitledBorder("Meccanici"));

        javax.swing.GroupLayout jPanMechanicLayout = new javax.swing.GroupLayout(jPanMechanic);
        jPanMechanic.setLayout(jPanMechanicLayout);
        jPanMechanicLayout.setHorizontalGroup(
            jPanMechanicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jCombMechanic, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        
        jPanMechanicLayout.setVerticalGroup(
            jPanMechanicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanMechanicLayout.createSequentialGroup()
                .addComponent(jCombMechanic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        jCombTyredealer.setBorder(javax.swing.BorderFactory.createTitledBorder("Gommisti"));

        javax.swing.GroupLayout jPanTyredealerLayout = new javax.swing.GroupLayout(jPanTyredealer);
        jPanTyredealer.setLayout(jPanTyredealerLayout);
        jPanTyredealerLayout.setHorizontalGroup(
            jPanTyredealerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jCombTyredealer, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanTyredealerLayout.setVerticalGroup(
            jPanTyredealerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanTyredealerLayout.createSequentialGroup()
                .addComponent(jCombTyredealer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        jCombCoachbuilder.setBorder(javax.swing.BorderFactory.createTitledBorder("Verniciatori"));

        javax.swing.GroupLayout jPanCoachbuilderLayout = new javax.swing.GroupLayout(jPanCoachbuilder);
        jPanCoachbuilder.setLayout(jPanCoachbuilderLayout);
        jPanCoachbuilderLayout.setHorizontalGroup(
            jPanCoachbuilderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jCombCoachbuilder, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanCoachbuilderLayout.setVerticalGroup(
            jPanCoachbuilderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanCoachbuilderLayout.createSequentialGroup()
                .addComponent(jCombCoachbuilder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        jButElimina.setFont(new java.awt.Font("Swis721 Ex BT", 3, 12)); // NOI18N
        jButElimina.setText("ELIMINA");
        jButElimina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButEliminaActionPerformed(evt, model);
            }
        });

        jButCrea.setFont(new java.awt.Font("Swis721 Ex BT", 3, 12)); // NOI18N
        jButCrea.setText("CREA");
        jButCrea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButCreaActionPerformed(evt, model);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanCoachbuilder, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanTyredealer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanMechanic, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButCrea)
                                .addGap(26, 26, 26)
                                .addComponent(jButElimina))
                            .addComponent(jCombReparto, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCombReparto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanMechanic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanTyredealer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanCoachbuilder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButCrea)
                    .addComponent(jButElimina))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jButMod.setFont(new java.awt.Font("Swis721 Ex BT", 3, 12)); // NOI18N
        jButMod.setText("MODIFICA");
        jButMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnModActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(jButMod)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jButMod)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButCreaActionPerformed(java.awt.event.ActionEvent evt, DefaultTableModel model) {//GEN-FIRST:event_jButCreaActionPerformed

        List<Integer> workersId = new ArrayList<>();
        Optional<Integer> workerId = Optional.empty();
        
        wType = ViewController.getWorkerType(jCombReparto.getSelectedItem().toString());

        if(wType.equals(WorkerType.MECHANIC)){
            impiegato = jCombMechanic.getSelectedItem().toString();
        }else if(wType.equals(WorkerType.TYREDEALER)){
            impiegato = jCombTyredealer.getSelectedItem().toString();
        }else if(wType.equals(WorkerType.COACHBUILDER)){
            impiegato = jCombCoachbuilder.getSelectedItem().toString();
        }

        if(jCombReparto.getSelectedItem().equals("Nulla"))
        {
            ViewController.showWarningMessage("Perfavore per creare un box sciegli un reparto!");
            
        }else{

            if(!impiegato.equals("Nessuno")){

                workersId = workerList.stream()
                                    .filter(w ->  (w.getWorkerName() + " " + w.getWorkerSurname()).equals(impiegato) && w.getWorkType().equals(wType))
                                    .map(BaseWorker::getWorkerId)
                                    .collect(Collectors.toList());
                
                for(int i = 0; i < workersId.size(); i++){
                    if(!Controller.alreadyExists(boxList, 4, String.valueOf(workersId.get(i)))){
                        workerId = Optional.ofNullable(workersId.get(i));
                    }
                }

                if(workerId.isPresent()){
                    
                    boxId = ViewController.createBox(boxList, workerId, wType);

                    model.insertRow(table.getRowCount() , new Object[ ] {boxId, jCombReparto.getSelectedItem(), workerId.get(), impiegato });            
                    ViewController.showInfoMessage("Dati inseriti correttamente");
                }else
                    ViewController.showErrorMessage("dipendente gia assegnato ad un box");


            }else{
                boxId = ViewController.createBox(boxList, Optional.empty(), null);
                model.insertRow(table.getRowCount() , new Object[ ] {boxId, jCombReparto.getSelectedItem(), "Nessuno", "Nessuno" });
                ViewController.showInfoMessage( "Dati inseriti correttamente, nessun impiegato assegnato");
            }

            jCombReparto.setSelectedItem("Nulla");
            
        }
        
    }//GEN-LAST:event_jButCreaActionPerformed

    
    //CONTROLLO DEL CAMBIO DI STATO DELL'ITEM DEL BOX
    private void jCombRepartoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCombRepartoItemStateChanged
        
        //Se il dropdown dei lavori rimane su nulla non mostra nessun lavoratore 
        if(jCombReparto.getSelectedItem().equals("Nulla"))
        { 
            jPanMechanic.setVisible(false);
            jPanCoachbuilder.setVisible(false);
            jPanTyredealer.setVisible(false);
        
        }else if(jCombReparto.getSelectedItem().equals(Meccanico))
        {
            //Rende visibile la selezione dei Meccanici//  
            jPanMechanic.setVisible(true);
            jPanCoachbuilder.setVisible(false);
            jPanTyredealer.setVisible(false);
    
        }else if(jCombReparto.getSelectedItem().equals(Carrozziere))
        {
            //Rende visibile la selezione dei Verniciatori//  
            jPanCoachbuilder.setVisible(true);
            jPanMechanic.setVisible(false);
            jPanTyredealer.setVisible(false);
            
        }else if(jCombReparto.getSelectedItem().equals(Gommista))
        {
          //Rende visibile la selezione dei gommisti//  
            jPanTyredealer.setVisible(true);  
            jPanMechanic.setVisible(false);
            jPanCoachbuilder.setVisible(false);
        } 
        
    }//GEN-LAST:event_jCombRepartoItemStateChanged

    // Bottone per eliminare un box
    private void jButEliminaActionPerformed(java.awt.event.ActionEvent evt, DefaultTableModel model) {//GEN-FIRST:event_jButEliminaActionPerformed

        if(table.getSelectedRowCount() == 1){

            boxId = (int) table.getValueAt(table.getSelectedRow(),0);

            ViewController.removeBoxfromList(boxList, boxList.get(table.getSelectedRow()).getBoxNumber());

            model.removeRow(table.getSelectedRow());

            ViewController.showInfoMessage( "Box_" + boxId + " eliminato correttamente");  
            
        }
    }//GEN-LAST:event_jButEliminaActionPerformed
    
    //BOTTONE MODIFICA
    private void jBtnModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButModActionPerformed

        int selectedRow = table.getSelectedRow();
        
        if (selectedRow == -1) {
            ViewController.showWarningMessage( "Perfavore seleziona la riga da aggiornare!");
            
        } else{

            String reparto = String.valueOf(jCombReparto.getSelectedItem());
            JComboBox<String> comboBox = null;
            String boxId = String.valueOf(table.getValueAt(selectedRow, 0));
            int control = -1;

            wType = ViewController.getWorkerType(reparto);

            if( wType.equals(WorkerType.MECHANIC)) {
                comboBox = jCombMechanic;
            } else if (wType.equals(WorkerType.COACHBUILDER)) {
                comboBox = jCombCoachbuilder;
            } else if (wType.equals(WorkerType.TYREDEALER)) {
                comboBox = jCombTyredealer;
            }

            if (comboBox.getSelectedItem().equals("Nessuno")) {
                ViewController.showWarningMessage("Impiegato non selezionato");
                
                ViewController.removeWorkerFromBox(boxList, (int) table.getValueAt(selectedRow, 0));
                
                table.setValueAt("", selectedRow, 2);

            }

            impiegato = String.valueOf(comboBox.getSelectedItem());

            if (impiegato.equals("Nessuno")) {
                impiegato = "";
            } else {

                List<Integer> workersId = workerList.stream()
                        .filter(w -> (w.getWorkerName() + " " + w.getWorkerSurname()).equals(impiegato) && w.getWorkType() == wType)
                        .map(BaseWorker::getWorkerId)
                        .collect(Collectors.toList());

                Integer workerId = workersId.stream()
                        .filter(id -> !Controller.alreadyExists(boxList, 4, String.valueOf(id)))
                        .findFirst()
                        .orElse(-1);
                        
                if (workerId != -1) {
                    
                    control = ViewController.setWorkerToBox(boxList, workerList, workerId, boxId);
                    table.setValueAt(workerId, selectedRow, 2);
                    table.setValueAt(impiegato, selectedRow, 3);
                }
                
                if (control == 1) {
                    ViewController.showInfoMessage("Box aggiornato correttamente");
                } else if (control == 0) {
                    ViewController.showErrorMessage("Non ci sono box liberi di quel tipo");
                } else if (control == -1) {
                    ViewController.showErrorMessage("Dipendente gia assegnato ad un box");
                }
                
            }
            
        }
    }//GEN-LAST:event_jButModActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        
        if(table.getSelectedRowCount() == 1){
            jCombReparto.setSelectedItem(table.getValueAt(table.getSelectedRow(),1));
            
            if(table.getValueAt(table.getSelectedRow(),1).equals(Meccanico))
            {
                //Rende visibile la selezione dei Meccanici//  
                jPanMechanic.setVisible(true);
                jPanCoachbuilder.setVisible(false);
                jPanTyredealer.setVisible(false);
                jCombMechanic.setSelectedItem(table.getValueAt(table.getSelectedRow(),3));
                
            }else if(table.getValueAt(table.getSelectedRow(),1).equals(Gommista)){
                //Rende visibile la selezione dei Verniciatori//  
                jPanCoachbuilder.setVisible(false);
                jPanMechanic.setVisible(false);
                jPanTyredealer.setVisible(true);
                jCombTyredealer.setSelectedItem(table.getValueAt(table.getSelectedRow(),3));
            }else if(table.getValueAt(table.getSelectedRow(),1).equals(Carrozziere)){
            //Rende visibile la selezione dei gommisti//  
                jPanTyredealer.setVisible(false);  
                jPanMechanic.setVisible(false);
                jPanCoachbuilder.setVisible(true);
                jCombCoachbuilder.setSelectedItem(table.getValueAt(table.getSelectedRow(),3));
            }
        }else {
            ViewController.showWarningMessage("Perfavore selezionare solo la riga da aggiornare!");  
        }

    }//GEN-LAST:event_tableMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButCrea;
    private javax.swing.JButton jButElimina;
    private javax.swing.JButton jButMod;
    private javax.swing.JComboBox<String> jCombMechanic;
    private javax.swing.JComboBox<String> jCombCoachbuilder;
    private javax.swing.JComboBox<String> jCombReparto;
    private javax.swing.JComboBox<String> jCombTyredealer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanMechanic;
    private javax.swing.JPanel jPanCoachbuilder;
    private javax.swing.JPanel jPanTyredealer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
