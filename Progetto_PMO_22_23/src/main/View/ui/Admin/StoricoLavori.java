package main.View.ui.Admin;

import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.Controller.ClassHelper;
import main.Controller.Controller;
import main.Controller.FileManager;
import main.Model.Lavoro.Quotation;
import main.Model.Veicolo.WorksDone;
import main.View.ViewController;


public class StoricoLavori extends javax.swing.JFrame {

    private List<WorksDone> worksDone = ClassHelper.getWorksDone();
    private List<Quotation> quotations = ClassHelper.getQuotations();

    Quotation q;

    private DefaultTableModel model;

    /**
     * Creates new form StoricoLavori
     */
    public StoricoLavori() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aggiornaTabella = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        prezzoTot = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        
        jPanel1.setBackground(new java.awt.Color(225, 0, 50));

        jLabel5.setFont(new java.awt.Font("Swis721 Ex BT", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("STORICO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        aggiornaTabella.setFont(new java.awt.Font("Swis721 Ex BT", 3, 12)); // NOI18N
        aggiornaTabella.setText("AGGIORNA TABELLA");
        aggiornaTabella.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aggiornaTabellaActionPerformed(evt);
            }

        });

        model = setTable();

        table.setModel(model);
        TableColumnModel columnModel = table.getColumnModel();
        TableColumn checkboxColumn = columnModel.getColumn(columnModel.getColumnCount() -1 );

       //* Create a custom cell renderer for the checkbox column //
        DefaultTableCellRenderer checkboxRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JCheckBox checkbox = new JCheckBox();
                
                // Get the "Paid" status from your WorksDone object
                Boolean isPaid = worksDone.stream()
                                        .filter(w -> w.getPlateNumber().equals(table.getValueAt(row, 0)))
                                        .findFirst().get().isPaid();
                
                checkbox.setSelected(isPaid);
                checkbox.setHorizontalAlignment(JCheckBox.CENTER);
                return checkbox;
            }
        };

        // Set the cell renderer for the checkbox column
        checkboxColumn.setCellRenderer(checkboxRenderer);

        // Add ActionListener to the checkbox column
        checkboxColumn.setCellEditor(new DefaultCellEditor(new JCheckBox()) {
            @Override
            public Object getCellEditorValue() {
                return ((JCheckBox) editorComponent).isSelected();
            }
        });

        // Add ActionListener to the editor component (checkbox)
        ((JCheckBox) checkboxColumn.getCellEditor().getTableCellEditorComponent(table, null, false, 0, 0))
        .addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();

                if (selectedRow != -1) {

                    WorksDone work = worksDone.stream()
                        .filter(w -> w.getPlateNumber().equals(table.getValueAt(selectedRow, 0)))
                        .findFirst()
                        .orElse(null);

                    if (work != null) {
                        work.setPaid();

                        try {
                            int row = Controller.findRowById(ClassHelper.worksPath, String.valueOf(work.getIssueId()), 7);
                            FileManager.modifyRow(ClassHelper.worksPath, row, "true", 12);
                            ViewController.createQuotation(quotations, work);
                            prezzoTot.setText(String.valueOf(ClassHelper.getTotPrice()));
                        } catch (Exception ex) {
                            ViewController.showErrorMessage(ex.getMessage());
                        }
                    }
                } else {
                    ViewController.showWarningMessage("Nessuna riga selezionata");
                }
            }
        });
        //*  End of checkbox column *//

        jScrollPane1.setViewportView(table);

        prezzoTot.setEditable(false);

        jLabel1.setFont(new java.awt.Font("Swis721 Ex BT", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Guadagno tot.:");
        prezzoTot.setText(String.valueOf(ClassHelper.getTotPrice()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prezzoTot, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(aggiornaTabella, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(aggiornaTabella)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(prezzoTot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
            );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aggiornaTabellaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aggiornaTabellaActionPerformed
        
        model = setTable();
        table.setModel(model);
    }//GEN-LAST:event_aggiornaTabellaActionPerformed

    public DefaultTableModel setTable(){
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                // Make the checkbox column not editable when the checkbox is checked (true)
                if (column == getColumnCount() - 1) { // Assuming the checkbox column is the last column
                    Boolean isPaid = (Boolean) getValueAt(row, column);
                    return !isPaid; // Make it editable if not paid
                } else {
                    return false; // Other columns are not editable
                }
            }

            @Override
            public Class<?> getColumnClass(int column) {
                if (column == getColumnCount() - 1) {
                    return Boolean.class;  // Checkbox column
                } else {
                    return Object.class;   // Other columns
                }
            }
        };

        model.addColumn("Targa");
        model.addColumn("Veicolo");
        model.addColumn("Marca");
        model.addColumn("Modello");
        model.addColumn("Colore");
        model.addColumn("Anno");
        model.addColumn("Impiegato");
        model.addColumn("Tipo di Lavoro");
        model.addColumn("Tempo Impiegato");
        model.addColumn("Cliente");
        model.addColumn("Costo");
        model.addColumn("Pagato");

        for(WorksDone w : worksDone)
        {
            model.addRow(new Object[]{  w.getPlateNumber(),
                                        w.getType(),
                                        w.getBrand(),
                                        w.getModel(),
                                        w.getColor(),
                                        w.getYear(),
                                        w.getWorkerName(),
                                        w.getDescription(),
                                        w.getFinalTime(),
                                        w.getCustomer(),
                                        w.getPrice(),
                                        w.isPaid()
                                });
        }
        
        return model;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aggiornaTabella;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField prezzoTot;
    // End of variables declaration//GEN-END:variables
}
