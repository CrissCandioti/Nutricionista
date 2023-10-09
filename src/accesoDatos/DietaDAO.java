/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import entidades.Dieta;
import javax.swing.JOptionPane;

/**
 *
 * @author criss
 */
public final class DietaDAO extends DAO {

    public void guardarDieta(Dieta aux) {
        try {
            String sql = "INSERT INTO `dieta`(`nombre`, `idPaciente`, `fechaInicial`, `pesoInicial`, `pesoFinal`, `fechaFinal`) VALUES ('" + aux.getNombre() + "'," + aux.getIdPaciente().getIdPaciente() + ",'" + aux.getFechaInicial() + "'," + aux.getPesoInicial() + "," + aux.getPesoFinal() + ",'" + aux.getFechaFinal() + "')";
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al guardar la dieta en la base de datos");
        }
    }

    public void modificarDieta(Dieta aux) {
        try {
            String sql = "UPDATE `dieta` SET `nombre`='[value-2]',`idPaciente`='[value-3]',`fechaInicial`='[value-4]',`pesoInicial`='[value-5]',`pesoFinal`='[value-6]',`fechaFinal`='[value-7]' WHERE idDieta = ";
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Se produjo un error al modificar la dieta en la base de datos" );
        }
    }
}
