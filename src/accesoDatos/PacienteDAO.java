/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import entidades.Paciente;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author criss
 */
public final class PacienteDAO extends DAO {

    public void guardarPaciente(Paciente aux) {
        try {
            String sql = "INSERT INTO `paciente`(`apellido`, `nombre`, `dni`, `domicilio`, `telefono`) VALUES ('" + aux.getApellido() + "','" + aux.getNombre() + "'," + aux.getDni() + ",'" + aux.getDomicilio() + "','" + aux.getTelefono() + "')";
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al guardar el paciente en la base de datos");
        }
    }

    public void modificarPaciente(Paciente aux) {
        try {
            String sql = "UPDATE `paciente` SET `apellido`='" + aux.getApellido() + "',`nombre`='" + aux.getNombre() + "',`dni`=" + aux.getDni() + ",`domicilio`='" + aux.getDomicilio() + "',`telefono`='" + aux.getTelefono() + "' WHERE idPaciente = " + aux.getIdPaciente();
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al modificar el paciente en la base de datos");
        }
    }

    public void eliminarPaciente(int ID) {
        try {
            String sql = "DELETE FROM `paciente` WHERE idPaciente = " + ID;
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al eliminar el paciente en la base de datos");
        }
    }

    public Paciente buscarPacientePorID(int ID) {
        try {
            String sql = "SELECT `idPaciente`, `apellido`, `nombre`, `dni`, `domicilio`, `telefono` FROM `paciente` WHERE idPaciente = " + ID;
            consultarBaseDatos(sql);
            Paciente aux = null;
            while (resultado.next()) {
                aux = new Paciente(ID, resultado.getString(2), resultado.getString(3), resultado.getInt(4), resultado.getString(5), resultado.getString(6));
            }
            return aux;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al buscar el paciente por ID en la base de datos");
        } finally {
            desconectarBaseDatos();
        }
        return null;
    }

    public Paciente buscarPacientePorDNI(int DNI) {
        try {
            String sql = "SELECT `idPaciente`, `apellido`, `nombre`, `dni`, `domicilio`, `telefono` FROM `paciente` WHERE dni = " + DNI;
            consultarBaseDatos(sql);
            Paciente aux = null;
            while (resultado.next()) {
                aux = new Paciente(resultado.getInt(1), resultado.getString(2), resultado.getString(3), DNI, resultado.getString(5), resultado.getString(6));
            }
            return aux;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al buscar el paciente por DNI en la base de datos");
        } finally {
            desconectarBaseDatos();
        }
        return null;
    }

    public ArrayList<Paciente> listaPaciente() {
        try {
            String sql = "SELECT `idPaciente`, `apellido`, `nombre`, `dni`, `domicilio`, `telefono` FROM `paciente` ORDER BY apellido ASC";
            consultarBaseDatos(sql);
            ArrayList<Paciente> listaRetornar = new ArrayList<>();
            while (resultado.next()) {
                listaRetornar.add(new Paciente(resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getInt(4), resultado.getString(5), resultado.getString(6)));
            }
            return listaRetornar;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al buscar la lista de pacientes en la base de datos");
        } finally {
            desconectarBaseDatos();
        }
        return null;
    }
    
}
