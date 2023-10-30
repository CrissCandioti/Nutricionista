/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import entidades.Comida;
import entidades.Dieta;
import entidades.DietaComida;
import entidades.Horario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.ComidaService;
import service.DietaComidaService;
import service.DietaService;

/**
 *
 * @author Cristian
 */
public class GestionDietaComida extends javax.swing.JInternalFrame {

    /**
     * Creates new form GestionDietaComida
     */
    public GestionDietaComida() {
        initComponents();
        llenarComboDieta();
        panelComidas.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmbDieta = new javax.swing.JComboBox<>();
        panelComidas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaComida = new javax.swing.JTable();
        btnAgregarComida = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDietaComida = new javax.swing.JTable();
        btnQuitar = new javax.swing.JButton();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setTitle("Creacion de Dietas");
        setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        setMinimumSize(new java.awt.Dimension(90, 18));
        setPreferredSize(new java.awt.Dimension(828, 675));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Dieta");

        cmbDieta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cmbDieta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDietaActionPerformed(evt);
            }
        });

        panelComidas.setBorder(javax.swing.BorderFactory.createTitledBorder("comidas"));

        tablaComida.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaComida);

        btnAgregarComida.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        btnAgregarComida.setText("AGREGAR A DIETA");
        btnAgregarComida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarComida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarComidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelComidasLayout = new javax.swing.GroupLayout(panelComidas);
        panelComidas.setLayout(panelComidasLayout);
        panelComidasLayout.setHorizontalGroup(
            panelComidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComidasLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregarComida)
                .addContainerGap())
        );
        panelComidasLayout.setVerticalGroup(
            panelComidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComidasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelComidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarComida, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jButton1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/remove_6431862 (2).png"))); // NOI18N
        jButton1.setText("SALIR");
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel2.setText("Seleccione una dieta a la que quiera agregar comidas...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Comidas en la dieta"));

        tablaDietaComida.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaDietaComida);

        btnQuitar.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        btnQuitar.setText("QUITAR DE DIETA");
        btnQuitar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnQuitar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelComidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(136, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelComidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(187, 187, 187))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDietaActionPerformed
        int idDieta = cmbDieta.getItemAt(cmbDieta.getSelectedIndex()).getIdDieta();
        panelComidas.setVisible(true);
        llenarTabla();
        llenarTablaDietaComida(idDieta);
    }//GEN-LAST:event_cmbDietaActionPerformed

    private void btnAgregarComidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarComidaActionPerformed
        try {

            DietaComidaService cd = new DietaComidaService();

            int idDieta = cmbDieta.getItemAt(cmbDieta.getSelectedIndex()).getIdDieta();
//            System.out.println("dieta " + idDieta);

            DefaultTableModel modelo = (DefaultTableModel) tablaComida.getModel();
            int idComida = (int) modelo.getValueAt(tablaComida.getSelectedRow(), 0);
            System.out.println("comida " + idComida);

            String horario = modelo.getValueAt(tablaComida.getSelectedRow(), 3).toString();
//            System.out.println(horario);
            cd.crearDietaComida(idComida, idDieta, Horario.valueOf(horario));
            llenarTablaDietaComida(idDieta);

        } catch (ArrayIndexOutOfBoundsException f) {
            JOptionPane.showMessageDialog(this, "Eliga una comida para poder continuar");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Verifique los datos y vuelva a intentar");
        }
    }//GEN-LAST:event_btnAgregarComidaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
       try{
           int idDieta = cmbDieta.getItemAt(cmbDieta.getSelectedIndex()).getIdDieta();
           System.out.println(idDieta);
           
        DietaComidaService ds = new DietaComidaService();
        DefaultTableModel modelo = (DefaultTableModel) tablaDietaComida.getModel();
            int idComida = (int) modelo.getValueAt(tablaDietaComida.getSelectedRow(), 0);
            System.out.println(idComida);
            if (JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE ELIMINAR LA COMIDA?", "SALIR", JOptionPane.YES_NO_CANCEL_OPTION) == 0) {
            ds.eliminarDietaComida(idComida,idDieta);
            }
             llenarTablaDietaComida(idDieta);
       }catch( Exception e){
           JOptionPane.showMessageDialog(this, "Seleccione una comida para eliminar");
       }
    }//GEN-LAST:event_btnQuitarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarComida;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JComboBox<Dieta> cmbDieta;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelComidas;
    private javax.swing.JTable tablaComida;
    private javax.swing.JTable tablaDietaComida;
    // End of variables declaration//GEN-END:variables
public void llenarComboDieta() {
        DietaService ds = new DietaService();

        try {
            for (Dieta object : ds.listaDietas()) {
                cmbDieta.addItem(object);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void llenarTabla() {

        try {
            ComidaService cs = new ComidaService();

            ArrayList comidas = cs.listaComida();

            //le otorgo un modelo a la tabla
            DefaultTableModel modelo = new DefaultTableModel();

            modelo.addColumn("Código");
            modelo.addColumn("Nombre");

            modelo.addColumn("Calorias");
            modelo.addColumn("Horario");

            tablaComida.setModel(modelo);

            //creo un vector para guardar los datos del array y que luego el modelo de la tabla pueda agregarlo a la tabla.
            Object comida[] = null;

            for (int i = 0; i < comidas.size(); i++) {
                modelo.addRow(comida);
                Comida getC = (Comida) comidas.get(i);

                modelo.setValueAt(getC.getIdComida(), i, 0);
                modelo.setValueAt(getC.getNombre(), i, 1);
                modelo.setValueAt(getC.getCantCalorias(), i, 2);
                modelo.setValueAt(getC.getHorario().toString(), i, 3);

            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No tenemos registros de comidas en la base de datos" + e);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void llenarTablaDietaComida(int id) {

        try {
            DietaComidaService dc = new DietaComidaService();

            
            ArrayList dietComida = dc.listaDietaComidaPorID(id);

            //le otorgo un modelo a la tabla
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Código");
            modelo.addColumn("Comida");
            modelo.addColumn("Calorias");
           
            modelo.addColumn("Horario");

            tablaDietaComida.setModel(modelo);

            //creo un vector para guardar los datos del array y que luego el modelo de la tabla pueda agregarlo a la tabla.
            Object dietacomida[] = null;

            for (int i = 0; i < dietComida.size(); i++) {
                modelo.addRow(dietacomida);
                DietaComida getC = (DietaComida) dietComida.get(i);

                modelo.setValueAt(getC.getIdComida().getIdComida(), i, 0);
                modelo.setValueAt(getC.getIdComida().getNombre(), i, 1);
                modelo.setValueAt(getC.getIdComida().getCantCalorias(), i, 2);
         
                modelo.setValueAt(getC.getHorario().toString(), i, 3);

            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No tenemos registros de comidas en la base de datos");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
