/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import entidades.Comida;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pdf.pdfComida;
import service.ComidaService;

/**
 *
 * @author Cristian
 */
public class ConsultasComida extends javax.swing.JInternalFrame {

    /**
     * Creates new form ConsultasComida
     */
    public ConsultasComida() {
        initComponents();
        panelComida.setVisible(false);
        btnComidas.setVisible(false);
        btnComidasPorCalorias.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelComida = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaComiida = new javax.swing.JTable();
        txtCalorias = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnComidas = new javax.swing.JButton();
        btnComidasPorCalorias = new javax.swing.JButton();
        rbTodas = new javax.swing.JRadioButton();
        rbCantCalorias = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setTitle("Listado Comida");
        setMinimumSize(new java.awt.Dimension(90, 18));
        setPreferredSize(new java.awt.Dimension(800, 563));
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelComida.setBackground(new java.awt.Color(255, 255, 255));

        tablaComiida.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        tablaComiida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Detalle", "Calorias"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaComiida);
        if (tablaComiida.getColumnModel().getColumnCount() > 0) {
            tablaComiida.getColumnModel().getColumn(0).setResizable(false);
            tablaComiida.getColumnModel().getColumn(1).setResizable(false);
            tablaComiida.getColumnModel().getColumn(2).setResizable(false);
            tablaComiida.getColumnModel().getColumn(3).setResizable(false);
        }

        txtCalorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCaloriasActionPerformed(evt);
            }
        });
        txtCalorias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCaloriasKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel1.setText("Ingrese Cantidad de Calorias");

        btnComidas.setBackground(new java.awt.Color(255, 255, 255));
        btnComidas.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnComidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/print_9635651 (1).png"))); // NOI18N
        btnComidas.setText("Imprimir Reporte");
        btnComidas.setBorder(null);
        btnComidas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnComidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComidasActionPerformed(evt);
            }
        });

        btnComidasPorCalorias.setBackground(new java.awt.Color(255, 255, 255));
        btnComidasPorCalorias.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnComidasPorCalorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/print_9635651 (1).png"))); // NOI18N
        btnComidasPorCalorias.setText("Imprimir Reporte");
        btnComidasPorCalorias.setBorder(null);
        btnComidasPorCalorias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnComidasPorCalorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComidasPorCaloriasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelComidaLayout = new javax.swing.GroupLayout(panelComida);
        panelComida.setLayout(panelComidaLayout);
        panelComidaLayout.setHorizontalGroup(
            panelComidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComidaLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCalorias, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(199, Short.MAX_VALUE))
            .addGroup(panelComidaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnComidas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnComidasPorCalorias))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelComidaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelComidaLayout.setVerticalGroup(
            panelComidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComidaLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelComidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCalorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelComidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnComidas)
                    .addComponent(btnComidasPorCalorias))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelComida, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 600, 460));

        buttonGroup1.add(rbTodas);
        rbTodas.setText("Todas las comidas");
        rbTodas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTodasActionPerformed(evt);
            }
        });
        getContentPane().add(rbTodas, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, -1, -1));

        buttonGroup1.add(rbCantCalorias);
        rbCantCalorias.setText("Comidas por cantidad de calorias");
        rbCantCalorias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbCantCalorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCantCaloriasActionPerformed(evt);
            }
        });
        getContentPane().add(rbCantCalorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setText("Listado de Comidas");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 8, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 38, 568, 10));

        jButton1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/remove_6431862 (2).png"))); // NOI18N
        jButton1.setText("SALIR");
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 480, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCaloriasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCaloriasKeyReleased
        try {
            int id = Integer.parseInt(txtCalorias.getText());
            llenarTabla(id);

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_txtCaloriasKeyReleased

    private void txtCaloriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCaloriasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCaloriasActionPerformed

    private void rbTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTodasActionPerformed
        panelComida.setVisible(true);
        txtCalorias.setVisible(false);
        jLabel1.setVisible(false);
        btnComidas.setVisible(true);
         btnComidasPorCalorias.setVisible(false);
        llenarTablaTodas();

    }//GEN-LAST:event_rbTodasActionPerformed

    private void rbCantCaloriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCantCaloriasActionPerformed

        panelComida.setVisible(true);
        txtCalorias.setVisible(true);
        jLabel1.setVisible(true);
         btnComidas.setVisible(false);
        btnComidasPorCalorias.setVisible(true);

        DefaultTableModel model = (DefaultTableModel) tablaComiida.getModel();
        model.setRowCount(0);
    }//GEN-LAST:event_rbCantCaloriasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnComidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComidasActionPerformed
       pdfComida c = new pdfComida();
       c.pdfTablaComida();
    }//GEN-LAST:event_btnComidasActionPerformed

    private void btnComidasPorCaloriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComidasPorCaloriasActionPerformed
        int calorias = Integer.parseInt(txtCalorias.getText());
        pdfComida c = new pdfComida();
       c.pdfTablaComidaPorCalorias(calorias);
    }//GEN-LAST:event_btnComidasPorCaloriasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComidas;
    private javax.swing.JButton btnComidasPorCalorias;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelComida;
    private javax.swing.JRadioButton rbCantCalorias;
    private javax.swing.JRadioButton rbTodas;
    private javax.swing.JTable tablaComiida;
    private javax.swing.JTextField txtCalorias;
    // End of variables declaration//GEN-END:variables
    public void llenarTabla(int id) {

        try {
            ComidaService cs = new ComidaService();

            ArrayList comidas = cs.listaComidaBajaCalorias(id);

            //le otorgo un modelo a la tabla
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Código");
            modelo.addColumn("Nombre");

            modelo.addColumn("Calorias");

            tablaComiida.setModel(modelo);

            //creo un vector para guardar los datos del array y que luego el modelo de la tabla pueda agregarlo a la tabla.
            Object comida[] = null;

            for (int i = 0; i < comidas.size(); i++) {
                modelo.addRow(comida);
                Comida getC = (Comida) comidas.get(i);

                modelo.setValueAt(getC.getIdComida(), i, 0);
                modelo.setValueAt(getC.getNombre(), i, 1);

                modelo.setValueAt(getC.getCantCalorias(), i, 2);

            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No tenemos registros de comidas en la base de datos");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void llenarTablaTodas() {

        try {
            ComidaService cs = new ComidaService();

            ArrayList comidas = cs.listaComida();

            //le otorgo un modelo a la tabla
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Horario");
            modelo.addColumn("Nombre");
          
            modelo.addColumn("Calorias");

            tablaComiida.setModel(modelo);

            //creo un vector para guardar los datos del array y que luego el modelo de la tabla pueda agregarlo a la tabla.
            Object comida[] = null;

            for (int i = 0; i < comidas.size(); i++) {
                modelo.addRow(comida);
                Comida getC = (Comida) comidas.get(i);

                modelo.setValueAt(getC.getHorario().toString(), i, 0);
                modelo.setValueAt(getC.getNombre(), i, 1);
              
                modelo.setValueAt(getC.getCantCalorias(), i, 2);

            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No tenemos registros de comidas en la base de datos");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
