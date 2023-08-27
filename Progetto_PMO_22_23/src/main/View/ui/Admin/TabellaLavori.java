package main.View.ui.Admin;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.swing.table.DefaultTableModel;

import main.Controller.Controller;
import main.Controller.ClassHelper;
import main.Controller.FileManager;
import main.Model.Veicolo.Tyre;
import main.Model.Veicolo.VehicleBox;
import main.Model.Veicolo.Interfaces.SpecificVehicle;
import main.View.ViewController;


public class TabellaLavori extends javax.swing.JFrame {

    private List<SpecificVehicle> vehicles = ClassHelper.getVehicles();
    private Set<Tyre> tyres = ClassHelper.getTyres();
    private List<VehicleBox> boxes = ClassHelper.getBoxes();

    public TabellaLavori() {
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
        txtMarca = new javax.swing.JTextField();
        txtModello = new javax.swing.JTextField();
        txtplateNumber = new javax.swing.JTextField();
        txtProprietario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btAggiungi = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btElimina = new javax.swing.JButton();
        btnAggiorna = new javax.swing.JButton();
        btnSalva = new javax.swing.JButton();
        txtAnno = new javax.swing.JTextField(5);
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboColor = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        btnEsporta1.setBackground(new java.awt.Color(69, 162, 157));
        btnEsporta1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEsporta1.setText("Esporta");

        setTitle("TabellaAggiuntaLavori");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(225, 0, 50));

        jLabel5.setFont(new java.awt.Font("Swis721 Ex BT", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ACCETTAZIONE");

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
        model.addColumn("Proprietario");

        for(SpecificVehicle vehicle : vehicles){
            model.addRow(new Object[]{  vehicle.getPlateNumber(), 
                                        vehicle.getType(),
                                        vehicle.getBrand(), 
                                        vehicle.getModel(), 
                                        vehicle.getColor(), 
                                        vehicle.getYear(), 
                                        vehicle.getCustomer()});
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

        txtplateNumber.setBackground(new java.awt.Color(240, 240, 240));
        txtplateNumber.setFont(new java.awt.Font("Swis721 Ex BT", 0, 14)); // NOI18N
        txtplateNumber.setForeground(new java.awt.Color(10, 10, 10));
        txtplateNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtplateNumber.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
    

        txtMarca.setBackground(new java.awt.Color(240, 240, 240));
        txtMarca.setFont(new java.awt.Font("Swis721 Ex BT", 0, 14)); // NOI18N
        txtMarca.setForeground(new java.awt.Color(10, 10, 10));
        txtMarca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMarca.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtModello.setBackground(new java.awt.Color(240, 240, 240));
        txtModello.setFont(new java.awt.Font("Swis721 Ex BT", 0, 14)); // NOI18N
        txtModello.setForeground(new java.awt.Color(10, 10, 10));
        txtModello.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtModello.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtProprietario.setBackground(new java.awt.Color(240, 240, 240));
        txtProprietario.setFont(new java.awt.Font("Swis721 Ex BT", 0, 14)); // NOI18N
        txtProprietario.setForeground(new java.awt.Color(10, 10, 10));
        txtProprietario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtProprietario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Swis721 Ex BT", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Marca");

        jLabel2.setFont(new java.awt.Font("Swis721 Ex BT", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Modello");

        jLabel3.setFont(new java.awt.Font("Swis721 Ex BT", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Targa");

        jLabel4.setFont(new java.awt.Font("Swis721 Ex BT", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Proprietario");

        btAggiungi.setBackground(new java.awt.Color(27, 68, 128));
        btAggiungi.setFont(new java.awt.Font("Swis721 Ex BT", 1, 14)); // NOI18N
        btAggiungi.setForeground(new java.awt.Color(240, 240, 240));
        btAggiungi.setText("Aggiungi");
        btAggiungi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAggiungiActionPerformed(evt, model);
            }
        });

        btElimina.setBackground(new java.awt.Color(27, 68, 128));
        btElimina.setFont(new java.awt.Font("Swis721 Ex BT", 1, 14)); // NOI18N
        btElimina.setForeground(new java.awt.Color(240, 240, 240));
        btElimina.setText("Elimina");
        btElimina.addActionListener(new java.awt.event.ActionListener() {
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

        txtAnno.setBackground(new java.awt.Color(240, 240, 240));
        txtAnno.setFont(new java.awt.Font("Swis721 Ex BT", 0, 14)); // NOI18N
        txtAnno.setForeground(new java.awt.Color(10, 10, 10));
        txtAnno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAnno.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtAnno.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar())) // limit textfield to 4 characters
                    e.consume();
                if(txtAnno.getText().length() >= 4)
                    e.consume();
            }

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        jLabel6.setFont(new java.awt.Font("Swis721 Ex BT", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Colore");

        jLabel7.setFont(new java.awt.Font("Swis721 Ex BT", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("Tipo");

        jComboColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rosso", "Rosa", "Arancio", "Giallo", "Verde", "Turchese", "Azzurro", "Blu", "Nero", "Bianco", "Grigio", "Argento", "Oro", " " }));


        jLabel8.setFont(new java.awt.Font("Swis721 Ex BT", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(240, 240, 240));
        jLabel8.setText("Anno");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Macchina", "Moto" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMarca)
                                    .addComponent(txtProprietario)
                                    .addComponent(jComboColor)
                                    .addComponent(txtAnno, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtModello)
                                    .addComponent(txtplateNumber)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnAggiorna, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(btnSalva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btAggiungi)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btElimina, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtModello, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtplateNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAggiungi)
                    .addComponent(btElimina, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAggiorna)
                .addGap(18, 18, 18)
                .addComponent(btnSalva)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btEliminaActionPerformed(java.awt.event.ActionEvent evt, DefaultTableModel model) {//GEN-FIRST:event_btEliminaActionPerformed
        
        if(table.getSelectedRowCount() == 1){
        
            // se il veicolo e' presente nel box
            if(boxes.stream().filter(b -> b.getVehicle().isPresent()).anyMatch(b -> b.getVehicle().get().getPlateNumber().equals(table.getValueAt(table.getSelectedRow(), 0).toString()))){
                
                ViewController.removeTyres(tyres ,table.getValueAt(table.getSelectedRow(), 0).toString());
                ViewController.removeVehicleFromBox(boxes, table.getValueAt(table.getSelectedRow(), 0).toString());
                ViewController.removeVehicle(vehicles ,table.getValueAt(table.getSelectedRow(), 0).toString());

            }else {
                
                ViewController.removeVehicle(vehicles ,table.getValueAt(table.getSelectedRow(), 0).toString());
                ViewController.removeTyres(tyres ,table.getValueAt(table.getSelectedRow(), 0).toString());
                
            }
        
            model.removeRow(table.getSelectedRow());

            ViewController.showInfoMessage( "Dati eliminati correttamente"); 
            
        }else{
            if(table.getRowCount() == 0){
                //se la tabella e' vuota manda un messaggio di avviso
                ViewController.showInfoMessage( "La tabella e' vuota!"); 
            }else{
                //se la tabella no ne vuota ma la riga non e' selezionata 
                ViewController.showInfoMessage( "Perfavore seleziona una riga da eleiminare!"); 
            }
        }
        
    }//GEN-LAST:event_btEliminaActionPerformed

    private void btAggiungiActionPerformed(java.awt.event.ActionEvent evt, DefaultTableModel model) {//GEN-FIRST:event_btAggiungiActionPerformed
        
    if(txtMarca.getText().equals(" ") || txtModello.getText().equals("") || txtplateNumber.getText().equals("") || txtProprietario.getText().equals("")|| jComboColor.getSelectedItem().equals(" ")|| txtAnno.getText().equals("") )
    {
        
        ViewController.showInfoMessage( "Perfavore riempi tutti i campi !");
    
    }else{
        if(!Controller.alreadyExists(vehicles, 0, txtplateNumber.getText())){
            try{

                if(jComboBox1.getSelectedItem().equals("Macchina")){
                   ViewController.createVehicle(vehicles, txtplateNumber.getText(), "Macchina", txtMarca.getText(),txtModello.getText(),jComboColor.getSelectedItem().toString(),Integer.parseInt(txtAnno.getText()), Optional.empty(), txtProprietario.getText());
                }else
                   ViewController.createVehicle(vehicles, txtplateNumber.getText(), "Moto",txtMarca.getText(),txtModello.getText(),jComboColor.getSelectedItem().toString(),Integer.parseInt(txtAnno.getText()), Optional.empty() , txtProprietario.getText());
            
                model.insertRow(model.getRowCount() , new Object[ ] {   txtplateNumber.getText(),
                                                                        jComboBox1.getSelectedItem(),
                                                                        txtMarca.getText(),
                                                                        txtModello.getText(),
                                                                        jComboColor.getSelectedItem(),
                                                                        txtAnno.getText(),
                                                                        txtProprietario.getText()} );

                ViewController.showInfoMessage( "Dati inseriti correttamente");

            }catch(IllegalArgumentException e){
                ViewController.showInfoMessage( "targa gia' presente nel sistema !");
            }

            txtMarca.setText("");
            txtModello.setText("");
            txtplateNumber.setText("");
            txtProprietario.setText("");
            jComboColor.setSelectedItem(" ");
            txtAnno.setText("");
        }else
            ViewController.showInfoMessage( "targa gia' presente nel sistema !");
    }
        
    }//GEN-LAST:event_btAggiungiActionPerformed

    private void btnAggiornaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAggiornaActionPerformed
    
        if(table.getSelectedRowCount() == 1){ 
            //Se una sola riga e' selezionata aggiorna i dati
            String oldplateNumber = table.getValueAt(table.getSelectedRow(),0).toString();
            String marca = txtMarca.getText();
            String modello = txtModello.getText();            
            String plateNumber = txtplateNumber.getText();
            String proprietario = txtProprietario.getText();
            String colore = jComboColor.getSelectedItem().toString();
            String anno = txtAnno.getText();
            String tipo = (String) jComboBox1.getSelectedItem();

            int row = Controller.findRowById(ClassHelper.vehiclePath, oldplateNumber, 0);
            int boxRow = Controller.findRowById(ClassHelper.boxPath, oldplateNumber, 3);

                if(!plateNumber.equals(oldplateNumber) && Controller.alreadyExists(vehicles, 0, plateNumber)){
                    ViewController.showInfoMessage( "targa gia' presente nel sistema !");

                } else{
                    
                    SpecificVehicle vehicle = vehicles.stream()
                                                    .filter(v -> v.getPlateNumber().equals(oldplateNumber))
                                                    .findFirst().get();

                    vehicle.setPlateNumber(plateNumber);
                    vehicle.setBrand(marca);
                    vehicle.setModel(modello);
                    vehicle.setColor(colore);
                    vehicle.setYear(Integer.parseInt(anno));
                    vehicle.setCustomer(proprietario);
                    vehicle.setType(tipo);
                    vehicle.getTyre().forEach(t -> t.setPlateNumber(plateNumber));

                    //aggiorna i  valori sulla tabella
                    table.setValueAt(marca,table.getSelectedRow(),2);
                    table.setValueAt(modello,table.getSelectedRow(),3);
                    table.setValueAt(plateNumber,table.getSelectedRow(),0);
                    table.setValueAt(proprietario,table.getSelectedRow(),6);
                    table.setValueAt(colore,table.getSelectedRow(),4);
                    table.setValueAt(anno,table.getSelectedRow(),5);
                    table.setValueAt(tipo,table.getSelectedRow(),1);
                    
                    try {
                        FileManager.modifyRow(ClassHelper.vehiclePath, row, marca, 3);
                        FileManager.modifyRow(ClassHelper.vehiclePath, row, modello, 2);
                        FileManager.modifyRow(ClassHelper.vehiclePath, row, proprietario, 7);
                        FileManager.modifyRow(ClassHelper.vehiclePath, row, colore, 4);
                        FileManager.modifyRow(ClassHelper.vehiclePath, row, anno, 5);
                        FileManager.modifyRow(ClassHelper.vehiclePath, row, tipo, 1);
                        if(!plateNumber.equals(oldplateNumber))
                            FileManager.modifyRow(ClassHelper.vehiclePath, row, plateNumber, 0);
                        FileManager.modifyByWord(ClassHelper.tyrePath, 1, oldplateNumber, 1, oldplateNumber, plateNumber);
                        if(!plateNumber.equals(oldplateNumber) && 
                            boxes.stream().filter(b -> b.getVehicle().isPresent())
                            .anyMatch(b -> b.getVehicle().get().getPlateNumber().equals(oldplateNumber))
                        )
                            FileManager.modifyRow(ClassHelper.boxPath, boxRow, plateNumber, 3);
                        
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                
                
                    ViewController.showInfoMessage( "Dati aggiornati con successo!");  

                    txtMarca.setText("");
                    txtModello.setText("");
                    txtplateNumber.setText("");
                    txtProprietario.setText("");
                    jComboColor.setSelectedItem(" ");
                    txtAnno.setText("");
                }
            
        }else
        {
            if(table.getRowCount() == 0 )
            {
                ViewController.showInfoMessage( "La tabella è vuota!");  
            }else
            {
                ViewController.showInfoMessage( "Perfavore seleziona solo la riga da aggiornare!");  
            }
        }

    }//GEN-LAST:event_btnAggiornaActionPerformed

    private void btnSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvaActionPerformed

        this.setVisible(false);
    
    }//GEN-LAST:event_btnSalvaActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        
            
        
            String marca =          table.getValueAt(table.getSelectedRow(),2).toString();
            String modello =        table.getValueAt(table.getSelectedRow(),3).toString();         
            String plateNumber =          table.getValueAt(table.getSelectedRow(),0).toString();
            String proprietario =   table.getValueAt(table.getSelectedRow(),6).toString();
            String colore =         table.getValueAt(table.getSelectedRow(),4).toString();
            String anno =           table.getValueAt(table.getSelectedRow(),5).toString();
            String tipo =           table.getValueAt(table.getSelectedRow(),2).toString();
            
            txtMarca.setText(marca);
            txtModello.setText(modello);
            txtplateNumber.setText(plateNumber);
            txtProprietario.setText(proprietario);
            jComboColor.setSelectedItem(colore);
            txtAnno.setText(anno);
            jComboBox1.setSelectedItem(tipo);
            
    }//GEN-LAST:event_tableMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAggiungi;
    private javax.swing.JButton btElimina;
    private javax.swing.JButton btnAggiorna;
    private javax.swing.JButton btnEsporta1;
    private javax.swing.JButton btnSalva;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtAnno;
    private javax.swing.JComboBox<String> jComboColor;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModello;
    private javax.swing.JTextField txtProprietario;
    private javax.swing.JTextField txtplateNumber;
    // End of variables declaration//GEN-END:variables
}
