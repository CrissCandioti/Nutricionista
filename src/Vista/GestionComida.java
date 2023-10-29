/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import entidades.Comida;
import entidades.Horario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.ComidaService;

/**
 *
 * @author Cristian
 */
public class GestionComida extends javax.swing.JInternalFrame {

    /**
     * Creates new form comida
     */
    public GestionComida() {
        initComponents();
        txtId.setVisible(false);
        panelTablaComidas.setVisible(false);
        desabilitarBotones();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelComida = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDetalle = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        txtCantCalorias = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        cmbHorario = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        panelTablaComidas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaComidas = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setIconifiable(true);
        setTitle("Gestión Comida.");
        setMinimumSize(new java.awt.Dimension(90, 18));
        setPreferredSize(new java.awt.Dimension(800, 680));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(null);

        panelComida.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Comida", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        panelComida.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Bodoni Bk BT", 1, 18)); // NOI18N
        jLabel1.setText("Nombre :");
        panelComida.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 96, -1));

        txtNombre.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        panelComida.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 24, 268, -1));

        jLabel2.setFont(new java.awt.Font("Bodoni Bk BT", 1, 18)); // NOI18N
        jLabel2.setText("Detalle:");
        panelComida.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 65, 96, -1));

        txtDetalle.setColumns(20);
        txtDetalle.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        txtDetalle.setRows(5);
        jScrollPane1.setViewportView(txtDetalle);

        panelComida.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 100, 619, 87));

        jLabel3.setFont(new java.awt.Font("Bodoni Bk BT", 1, 18)); // NOI18N
        jLabel3.setText("Calorias:");
        panelComida.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 30, 96, -1));

        txtCantCalorias.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        panelComida.add(txtCantCalorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 24, 96, -1));
        panelComida.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 28, 33, -1));

        btnGuardar.setText("GUARDAR");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panelComida.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 237, 620, 38));

        btnBuscar.setText("BUSCAR");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        panelComida.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 281, 620, 38));

        cmbHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "DESAYUNO", "MERIENDA", "ALMUERZO", "CENA", "SNACK" }));
        cmbHorario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelComida.add(cmbHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 199, 246, 32));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel4.setText("Horario:");
        panelComida.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 201, -1, -1));

        getContentPane().add(panelComida);
        panelComida.setBounds(25, 6, 640, 330);

        tablaComidas.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        tablaComidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaComidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaComidasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaComidas);

        btnModificar.setText("MODIFICAR");
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTablaComidasLayout = new javax.swing.GroupLayout(panelTablaComidas);
        panelTablaComidas.setLayout(panelTablaComidasLayout);
        panelTablaComidasLayout.setHorizontalGroup(
            panelTablaComidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaComidasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(panelTablaComidasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTablaComidasLayout.setVerticalGroup(
            panelTablaComidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaComidasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTablaComidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 44, Short.MAX_VALUE))
        );

        getContentPane().add(panelTablaComidas);
        panelTablaComidas.setBounds(25, 333, 659, 330);

        btnSalir.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/remove_6431862 (2).png"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.setBorder(null);
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(690, 580, 103, 38);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        try {
            ComidaService c = new ComidaService();

            String nombre = txtNombre.getText();
            String detalle = txtDetalle.getText();
            int calorias = Integer.parseInt(txtCantCalorias.getText());
            String horario = cmbHorario.getSelectedItem().toString();

            c.crearComida(nombre, detalle, calorias, Horario.valueOf(horario));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese numeros en 'Calorias'");
        }  catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Seleccione un Horario");
        }   catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Verifique correctamente las celdas y vuelva a intentarlo " + ex);
        }


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        panelTablaComidas.setVisible(true);
        limpiar();
        llenarTabla();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tablaComidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaComidasMouseClicked

        abilitarBotones();
        try {
            DefaultTableModel modelo = (DefaultTableModel) tablaComidas.getModel();
            int idComida = (int) modelo.getValueAt(tablaComidas.getSelectedRow(), 0);

            ComidaService cs = new ComidaService();
            Comida c = new Comida();

            c = cs.buscarComida(idComida);

            txtId.setText("" + c.getIdComida());
            txtNombre.setText(c.getNombre());
            txtDetalle.setText(c.getDetalle());
            txtCantCalorias.setText("" + c.getCantCalorias());
            cmbHorario.setSelectedItem(c.getHorario().toString());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al intentar seleccionar la materia");
        }
    }//GEN-LAST:event_tablaComidasMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        ComidaService cs = new ComidaService();
        int id = Integer.parseInt(txtId.getText());

        String nombre = txtNombre.getText();
        String detalle = txtDetalle.getText();
        int calorias = Integer.parseInt(txtCantCalorias.getText());
        String horario = cmbHorario.getSelectedItem().toString();

        if (JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE MODIFICAR COMIDA?", "SALIR", JOptionPane.YES_NO_CANCEL_OPTION) == 0) {
            cs.modificarComida(id, nombre, detalle, calorias,Horario.valueOf(horario));
            llenarTabla();
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        btnGuardar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        limpiar();
        panelTablaComidas.setVisible(false);
    }//GEN-LAST:event_formMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        ComidaService cs = new ComidaService();
        int id = Integer.parseInt(txtId.getText());

        if (JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE ELIMINAR LA COMIDA?", "SALIR", JOptionPane.YES_NO_CANCEL_OPTION) == 0) {
            cs.eliminarComida(id);
            llenarTabla();
            limpiar();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbHorario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelComida;
    private javax.swing.JPanel panelTablaComidas;
    private javax.swing.JTable tablaComidas;
    public static javax.swing.JTextField txtCantCalorias;
    public static javax.swing.JTextArea txtDetalle;
    public static javax.swing.JTextField txtId;
    public static javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
    public void llenarTabla() {

        try {
            ComidaService cs = new ComidaService();

            ArrayList comidas = cs.listaComida();

            //le otorgo un modelo a la tabla
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Código");
            modelo.addColumn("Nombre");
            
            modelo.addColumn("Calorias");

            tablaComidas.setModel(modelo);

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

    public void limpiar() {
        txtId.setText("");
        txtNombre.setText("");
        txtDetalle.setText("");
        txtCantCalorias.setText("");

    }

    public void abilitarBotones() {
        btnGuardar.setEnabled(false);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
    }

    public void desabilitarBotones() {
        btnGuardar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }
}
