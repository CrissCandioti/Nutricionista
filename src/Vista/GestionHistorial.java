/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import static Vista.GestionDieta.cmbPaciente;
import entidades.Dieta;
import entidades.Historial;
import entidades.Paciente;
import java.awt.Color;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.DietaService;
import service.HistorialService;
import service.PacienteService;

/**
 *
 * @author Cristian
 */
public class GestionHistorial extends javax.swing.JInternalFrame {

    /**
     * Creates new form GestionHistorial
     */
    public GestionHistorial() {
        initComponents();
        lblFecha.setText(LocalDate.now().toString());

        llenarComboPaciente();
        llenarTabla();
        panelHistorialPeso.setVisible(false);
        panelIMC.setVisible(false);
        txtId.setVisible(false);
        btnIMC.setVisible(false);

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
        jLabel2 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        cmbPaciente = new javax.swing.JComboBox<>();
        panelHistorialPeso = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaHistorial = new javax.swing.JTable();
        btnRegistrar1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnIMC = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        panelIMC = new javax.swing.JPanel();
        lblAltura = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblPeso = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();

        setBorder(null);
        setIconifiable(true);
        setTitle("Historia de Pesol Pacientes");
        setMinimumSize(new java.awt.Dimension(90, 18));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Paciente:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 74, 93, -1));

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel2.setText("Fecha:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(619, 40, -1, -1));

        lblFecha.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        getContentPane().add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 40, 136, 21));

        cmbPaciente.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        cmbPaciente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPacienteActionPerformed(evt);
            }
        });
        getContentPane().add(cmbPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 67, 248, -1));

        panelHistorialPeso.setBorder(javax.swing.BorderFactory.createTitledBorder("Historial Peso"));

        tablaHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(tablaHistorial);

        btnRegistrar1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnRegistrar1.setText("Registrar Peso Actual");
        btnRegistrar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrar1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel4.setText("Kg.");

        txtPeso.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel3.setText("Ingrese Peso Actual");

        btnIMC.setText("Calcular IMC");
        btnIMC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIMCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelHistorialPesoLayout = new javax.swing.GroupLayout(panelHistorialPeso);
        panelHistorialPeso.setLayout(panelHistorialPesoLayout);
        panelHistorialPesoLayout.setHorizontalGroup(
            panelHistorialPesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHistorialPesoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelHistorialPesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHistorialPesoLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelHistorialPesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelHistorialPesoLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 29, Short.MAX_VALUE))
                            .addComponent(btnRegistrar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelHistorialPesoLayout.createSequentialGroup()
                        .addComponent(btnIMC)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelHistorialPesoLayout.setVerticalGroup(
            panelHistorialPesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHistorialPesoLayout.createSequentialGroup()
                .addGroup(panelHistorialPesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(panelHistorialPesoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelHistorialPesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(btnRegistrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnIMC))
        );

        getContentPane().add(panelHistorialPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 108, -1, -1));

        txtId.setText("txtId");
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 68, -1, -1));

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
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 600, 124, -1));

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel5.setText("Seleccione un Paciente para ver su Historial.");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 41, -1, -1));

        panelIMC.setBorder(javax.swing.BorderFactory.createTitledBorder("Indice de Masa Corporal"));

        lblAltura.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel6.setText("Altura:");

        lblPeso.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel7.setText("Peso:");

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel8.setText("cm.");

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel9.setText("Kg.");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imc.jpeg"))); // NOI18N

        lblCategoria.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N

        javax.swing.GroupLayout panelIMCLayout = new javax.swing.GroupLayout(panelIMC);
        panelIMC.setLayout(panelIMCLayout);
        panelIMCLayout.setHorizontalGroup(
            panelIMCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIMCLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelIMCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelIMCLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(lblCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelIMCLayout.setVerticalGroup(
            panelIMCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIMCLayout.createSequentialGroup()
                .addGroup(panelIMCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelIMCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addGroup(panelIMCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)))
                    .addComponent(lblCategoria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(panelIMC, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 313, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPacienteActionPerformed
       panelIMC.setVisible(false);
        panelHistorialPeso.setVisible(true);
        llenarTabla();
        btnIMC.setVisible(true);
    }//GEN-LAST:event_cmbPacienteActionPerformed

    private void btnRegistrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrar1ActionPerformed
        panelIMC.setVisible(false);
        try {
            HistorialService hs = new HistorialService();

            int id = cmbPaciente.getItemAt(cmbPaciente.getSelectedIndex()).getIdPaciente();
            String fecha = lblFecha.getText();
            double peso = Double.parseDouble(txtPeso.getText());
            hs.crearHistorial(id, peso, LocalDate.parse(fecha));
            llenarTabla();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese el Peso correspondiente");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Verifique el dato ingresado y vuelva a intentarlo");
        }


    }//GEN-LAST:event_btnRegistrar1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnIMCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIMCActionPerformed
        try{
        panelIMC.setVisible(true);
        int idPäciente = cmbPaciente.getItemAt(cmbPaciente.getSelectedIndex()).getIdPaciente();

        DietaService ds = new DietaService();
        HistorialService hs = new HistorialService();

        int alturacm = ds.dietaPorPaciente(idPäciente).getAltura();
        double pesokg = hs.buscarHistorialPorIDPaciente(idPäciente).getPeso();
        lblAltura.setText("" + alturacm);
        lblPeso.setText("" + pesokg);
        double alturametros = alturacm / 100.0;
        double Imc = pesokg / (alturametros * alturametros);
        DecimalFormat df = new DecimalFormat("#.#");
       String imcformateado = df.format(Imc);
        
       
        String categoria= obtenerCategoriaIMC(Imc);
        lblCategoria.setForeground(obtenerColorIMC(Imc));
        lblCategoria.setText("Tu IMC es: " + imcformateado + ", lo que indica que tienes: " + categoria);
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(this, "No tiene registrado un peso o una altura.");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "se produjo un error");
        }
    }//GEN-LAST:event_btnIMCActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIMC;
    private javax.swing.JButton btnRegistrar1;
    public static javax.swing.JComboBox<Paciente> cmbPaciente;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAltura;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblPeso;
    public static javax.swing.JPanel panelHistorialPeso;
    private javax.swing.JPanel panelIMC;
    private javax.swing.JTable tablaHistorial;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtPeso;
    // End of variables declaration//GEN-END:variables
public void llenarComboPaciente() {
        PacienteService ps = new PacienteService();
        try {
            for (Paciente p : ps.listaPaciente()) {
                cmbPaciente.addItem(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void llenarTabla() {
        try {
            HistorialService hs = new HistorialService();

            int idPaciente = cmbPaciente.getItemAt(cmbPaciente.getSelectedIndex()).getIdPaciente();

            ArrayList hist = hs.listaHistorialesPorPaciente(idPaciente);

            //le otorgo un modelo a la tabla
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Peso");
            modelo.addColumn("Fecha Registro");
            tablaHistorial.setModel(modelo);

            //creo un vector para guardar los datos del array y que luego el modelo de la tabla pueda agregarlo a la tabla.
            Object historial[] = null;

            for (int i = 0; i < hist.size(); i++) {
                modelo.addRow(historial);
                Historial getD = (Historial) hist.get(i);
                modelo.setValueAt(getD.getPeso(), i, 0);
                modelo.setValueAt(getD.getFechaRegistro(), i, 1);
            }
        } catch (NullPointerException e) {
//            JOptionPane.showMessageDialog(null, "No tenemos registros de dietas en la base de datos");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public static String obtenerCategoriaIMC(double imc) {
        int categoria = 0;
        if (imc < 18.5) {
            categoria = 1;
        } else if (imc < 25) {
            categoria = 2;
        } else if (imc < 30) {
            categoria = 3;
        } else if (imc < 35) {
            categoria = 4;
        } else if (imc < 40) {
            categoria = 5;
        } else if (imc < 50) {
            categoria = 6;
        } else {
            categoria = 7;
        }

        switch (categoria) {
            case 1:
                return "Bajo peso";
            case 2:
                return "Peso normal";
            case 3:
                return "Sobrepeso";
            case 4:
                return "Obesidad grado I";
            case 5:
                return "Obesidad grado II";
            case 6:
                return "Obesidad grado III";
            case 7:
                return "Obesidad Grado IV";
            default:
                return "Valor IMC no válido";
        }
    }

    public static Color obtenerColorIMC(double imc) {
        if (imc < 18.5) {
            return Color.BLUE;
        } else if (imc < 25) {
            return Color.GREEN;
        } else if (imc < 30) {
            return Color.ORANGE;
        } else if (imc < 35) {
            return Color.red;
        } else if (imc < 40) {
            return Color.RED;
        } else {
            return Color.MAGENTA;
        }
    }
}
