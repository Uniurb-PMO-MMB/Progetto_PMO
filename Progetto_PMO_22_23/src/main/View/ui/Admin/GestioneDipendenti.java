package main.View.ui.Admin;

import java.io.*;

import java.util.List;
import javax.swing.table.DefaultTableModel;

import main.Controller.Controller;
import main.Controller.ClassHelper;
import main.Controller.FileManager;
import main.Model.Lavoro.Interfaces.BaseWorker;
import main.Model.Lavoro.Interfaces.WorkerType;
import main.Model.Veicolo.VehicleBox;
import main.View.ViewController;


/**
 * Questa classe rappresenta la finestra di gestione dei dipendenti.
 */
public class GestioneDipendenti extends javax.swing.JFrame {

    // Lista dei dipendenti caricata da ClassHelper
    private List<BaseWorker> workers = ClassHelper.getWorkers();
    private List<VehicleBox> boxes = ClassHelper.getBoxes();
    private String workerType;

    /**
     * Costruttore della finestra.
     */
    public GestioneDipendenti() {
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
        txtNome = new javax.swing.JTextField();
        txtCognome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAggiungi = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnElimina = new javax.swing.JButton();
        btnAggiorna = new javax.swing.JButton();
        btnSalva = new javax.swing.JButton();
        jCombMansione = new javax.swing.JComboBox<>();

        btnEsporta1.setBackground(new java.awt.Color(69, 162, 157));
        btnEsporta1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEsporta1.setText("Esporta");

        setTitle("Gestione Dipendenti");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(225, 0, 50));

        jLabel5.setFont(new java.awt.Font("Swis721 Ex BT", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("OPERATORI");

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

        DefaultTableModel model = new DefaultTableModel();

        table.setFont(new java.awt.Font("Swis721 Ex BT", 0, 16)); // NOI18N
        
        model.addColumn("ID");
        model.addColumn("Nome");
        model.addColumn("Cognome");
        model.addColumn("Mansione");

        if(!workers.isEmpty()){

            for(BaseWorker worker : workers){
                
                workerType = ViewController.getStringWorkerType(worker);

                model.addRow(new Object[]{worker.getWorkerId(),worker.getWorkerName(), worker.getWorkerSurname(), workerType});
            }
        }

        table.setModel(model);

        table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel2.setBackground(new java.awt.Color(27, 68, 128));

        txtNome.setBackground(new java.awt.Color(240, 240, 240));
        txtNome.setFont(new java.awt.Font("Swis721 Ex BT", 0, 14)); // NOI18N
        txtNome.setForeground(new java.awt.Color(10, 10, 10));
        txtNome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNome.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtCognome.setBackground(new java.awt.Color(240, 240, 240));
        txtCognome.setFont(new java.awt.Font("Swis721 Ex BT", 0, 14)); // NOI18N
        txtCognome.setForeground(new java.awt.Color(10, 10, 10));
        txtCognome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCognome.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        

        jLabel1.setFont(new java.awt.Font("Swis721 Ex BT", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Nome");

        jLabel2.setFont(new java.awt.Font("Swis721 Ex BT", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Cognome");

        jLabel3.setFont(new java.awt.Font("Swis721 Ex BT", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Mansione");

        btnAggiungi.setBackground(new java.awt.Color(27, 68, 128));
        btnAggiungi.setFont(new java.awt.Font("Swis721 Ex BT", 1, 14)); // NOI18N
        btnAggiungi.setForeground(new java.awt.Color(240, 240, 240));
        btnAggiungi.setText("Aggiungi");
        btnAggiungi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAggiungiActionPerformed(evt, model);
            }
        });

        btnElimina.setBackground(new java.awt.Color(27, 68, 128));
        btnElimina.setFont(new java.awt.Font("Swis721 Ex BT", 1, 14)); // NOI18N
        btnElimina.setForeground(new java.awt.Color(240, 240, 240));
        btnElimina.setText("Elimina");
        btnElimina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminaActionPerformed(evt, model);
            }
        });

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
        btnSalva.setFont(new java.awt.Font("Swis721 Ex BT", 1, 18)); // NOI18N
        btnSalva.setForeground(new java.awt.Color(240, 240, 240));
        btnSalva.setText("Salva");
        btnSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvaActionPerformed(evt);
            }
        });

        jCombMansione.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nessuna", "Carrozziere", "Meccanico", "Gommista" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER, false)
                                        .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                        .addComponent(txtCognome))
                                    .addComponent(jCombMansione, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnAggiungi)
                                .addGap(18, 18, 18)
                                .addComponent(btnElimina))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAggiorna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSalva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCognome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jCombMansione, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAggiungi)
                    .addComponent(btnElimina))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAggiorna)
                .addGap(36, 36, 36)
                .addComponent(btnSalva)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btEliminaActionPerformed(java.awt.event.ActionEvent evt , DefaultTableModel model) {//GEN-FIRST:event_btEliminaActionPerformed
        
        // Ottiene l'ID del impiegato selezionato nella tabella

        int workerId = -1; 
            
        if(table.getSelectedRowCount() == 1){
        
            // Ottiene l'ID del impiegato selezionato nella tabella
            workerId = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());

            if(workerId >= 0){
                ViewController.removeWorker(boxes ,workers , workerId);
            }else
                throw new IllegalArgumentException("Errore nella ricerca della riga");

            model.removeRow(table.getSelectedRow());

            ViewController.showInfoMessage("Dati eliminata con successo!");
            
        }else{
            if(table.getRowCount() == 0){
                //se la tabella e' vuota manda un messaggio di avviso
                ViewController.showInfoMessage("La tabella e' vuota!");
            }else{
                //se la tabella no ne vuota ma la riga non e' selezionata 
                ViewController.showErrorMessage("Perfavore seleziona una riga!");
            }
        }
        
    }//GEN-LAST:event_btEliminaActionPerformed

    private void btnAggiungiActionPerformed(java.awt.event.ActionEvent evt, DefaultTableModel model) {//GEN-FIRST:event_btAggiungiActionPerformed
    
        String workerType = "";
        WorkerType mansione = null;

         // Verifica che i campi di input siano stati riempiti correttamente
        if(txtNome.getText().equals("") || txtCognome.getText().equals("") || jCombMansione.getSelectedItem().equals("Nessuna"))
        {
        
            ViewController.showWarningMessage("Perfavore riempi tutti i campi");
        
        }else{   
            // Ottiene i valori dai campi di input
            String nome = txtNome.getText();
            String cognome = txtCognome.getText();
            workerType = jCombMansione.getSelectedItem().toString();

            mansione = ViewController.getWorkerType(workerType);

            // Crea un nuovo impiegato e lo aggiunge alla collezione "workers"
            int workerId = ViewController.createWorker(workers, mansione, nome, cognome);

            model.insertRow(model.getRowCount() , new Object[ ] {workerId ,txtNome.getText(), txtCognome.getText(), jCombMansione.getSelectedItem()} );  
                
            try {
                FileManager.removeEmptyLines("Progetto_PMO_22_23/src/files/workers.csv");
            } catch (IOException e) {
                
                e.printStackTrace();
            }
            
            ViewController.showInfoMessage("Dati aggiunti correttamente");

            txtNome.setText("");
            txtCognome.setText("");
            jCombMansione.setSelectedItem("Nessuna");
            
        }
        
    }//GEN-LAST:event_btAggiungiActionPerformed

    private void btnAggiornaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAggiornaActionPerformed
    
        if (table.getSelectedRowCount() == 1) {
            
            // Ottieni l'ID della riga selezionata dalla prima colonna della tabella
            String id = table.getValueAt(table.getSelectedRow(), 0).toString();
        
            // Ottieni i valori dai campi di input
            String nome = txtNome.getText();
            String cognome = txtCognome.getText();
            String postazione = jCombMansione.getSelectedItem().toString();
        
            WorkerType mansione = null;
        
            // Mappa il valore della stringa "postazione" all'enum WorkerType corrispondente
            mansione = ViewController.getWorkerType(postazione);
        
            // Trova la riga corrispondente nel file usando l'ID del lavoratore
            int row = Controller.findRowById(ClassHelper.workerPath, id, 0);
        
            try {
                // Aggiorna l'oggetto Worker corrispondente nella collezione "workers" in base all'ID
                BaseWorker worker = workers.stream()
                    .filter(w -> w.getWorkerId() == Integer.parseInt(id))
                    .findFirst().get();

                worker.setName(nome);
                worker.setSurname(cognome);
                worker.setWorkType(mansione);
        
                // Aggiorna il file dopo aver aggiornato l'oggetto Worker
                FileManager.modifyRow(ClassHelper.workerPath, row, nome, 2);
                FileManager.modifyRow(ClassHelper.workerPath, row, cognome, 3);
                FileManager.modifyRow(ClassHelper.workerPath, row, mansione.toString(), 1);
        
                // Aggiorna i valori nella tabella dopo il successo dell'aggiornamento del file
                table.setValueAt(nome, table.getSelectedRow(), 1);
                table.setValueAt(cognome, table.getSelectedRow(), 2);
                table.setValueAt(postazione, table.getSelectedRow(), 3);
        
            } catch (IOException e) {
                // Gestisci l'eccezione IOException adeguatamente (mostra un messaggio, registra l'errore, ecc.)
                e.printStackTrace();
            }
        
            ViewController.showInfoMessage("Dati aggiornati con successo!");

            txtNome.setText("");
            txtCognome.setText("");
            jCombMansione.setSelectedItem("Nessuna");
            
            
        }else
        {
            if(table.getRowCount() == 0 )
            {
                ViewController.showInfoMessage("La tabella e' vuota!");
            }else
            {
                ViewController.showWarningMessage("Perfavore seleziona una riga!");
            }
        }
    }//GEN-LAST:event_btnAggiornaActionPerformed

    private void btnSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvaActionPerformed
    
        ViewController.showConfirmMessage("Vuoi salvare i dati?");
        
        this.setVisible(false);
    
    }//GEN-LAST:event_btnSalvaActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
            
            // Ottieni i dati del impiegato selezionato dalla tabella
            String Marca =          table.getValueAt(table.getSelectedRow(),1).toString();
            String Modello =        table.getValueAt(table.getSelectedRow(),2).toString();         
            String mansione =       table.getValueAt(table.getSelectedRow(),3).toString();
            
            // Popola i campi di input con i dati del impiegato selezionato
            txtNome.setText(Marca);
            txtCognome.setText(Modello);
            jCombMansione.setSelectedItem(mansione);
            
            
    }//GEN-LAST:event_tableMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAggiungi;
    private javax.swing.JButton btnElimina;
    private javax.swing.JButton btnAggiorna;
    private javax.swing.JButton btnEsporta1;
    private javax.swing.JButton btnSalva;
    private javax.swing.JComboBox<String> jCombMansione;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtCognome;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
