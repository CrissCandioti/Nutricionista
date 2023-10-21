/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import entidades.Comida;
import entidades.Dieta;
import entidades.Horario;
import entidades.Paciente;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.ComidaService;
import service.DietaComidaService;
import service.DietaService;
import service.PacienteService;

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

        setClosable(true);
        setIconifiable(true);
        setTitle("Creacion de Dietas");
        setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Dieta");

        cmbDieta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
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
                .addContainerGap()
                .addGroup(panelComidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarComida, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(166, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelComidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelComidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDietaActionPerformed
        panelComidas.setVisible(true);
        llenarTabla();
    }//GEN-LAST:event_cmbDietaActionPerformed

    private void btnAgregarComidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarComidaActionPerformed
        try {
            
            
            DietaComidaService cd = new DietaComidaService();
                    
            int idDieta = cmbDieta.getItemAt(cmbDieta.getSelectedIndex()).getIdDieta();
//            System.out.println("dieta " + idDieta);
            
           DefaultTableModel modelo = (DefaultTableModel) tablaComida.getModel();
            int idComida =(int) modelo.getValueAt(tablaComida.getSelectedRow(), 0) ;
            System.out.println("comida " + idComida);
            
            String horario = modelo.getValueAt(tablaComida.getSelectedRow(), 3).toString();
            
//            System.out.println(horario);
            
            
            cd.crearDietaComida(idComida, idDieta, Horario.valueOf(horario));
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnAgregarComidaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarComida;
    private javax.swing.JComboBox<Dieta> cmbDieta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelComidas;
    private javax.swing.JTable tablaComida;
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
            JOptionPane.showMessageDialog(null, "No tenemos registros de comidas en la base de datos"+e);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
