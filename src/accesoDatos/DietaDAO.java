/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import entidades.Dieta;
import entidades.Paciente;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import service.PacienteService;

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
            String sql = "UPDATE `dieta` SET `nombre`='" + aux.getNombre() + "',`idPaciente`=" + aux.getIdPaciente().getIdPaciente() + ",`fechaInicial`='" + aux.getFechaInicial() + "',`pesoInicial`='" + aux.getPesoInicial() + "',`pesoFinal`=" + aux.getPesoFinal() + ",`fechaFinal`='" + aux.getFechaFinal() + "' WHERE idDieta = " + aux.getIdDieta();
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al modificar la dieta en la base de datos");
        }
    }

    public ArrayList<Paciente> pacientesDietaVigente(LocalDate fecha) {
        try {
            String sql = "SELECT `idPaciente` FROM `dieta` WHERE `fechaFinal` > '" + fecha + "'"; //Para dietas vigentes o futuras
            consultarBaseDatos(sql);
            ArrayList<Paciente> listaRetornar = new ArrayList<>();
            PacienteService ps = new PacienteService();
            while (resultado.next()) {
                Integer IDPaciente = resultado.getInt(1);
                listaRetornar.add(ps.buscarPacientePorID(IDPaciente));
            }
            return listaRetornar;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al buscar los pacientes cuya dieta esté vigente en la base de datos");
        }
        return null;
    }

    public ArrayList<Paciente> pacientesDietaTerminada(LocalDate fecha) {
        try {
            String sql = "SELECT `idPaciente` FROM `dieta` WHERE `fechaFinal` <= '" + fecha + "'"; //Para dietas terminadas
            consultarBaseDatos(sql);
            ArrayList<Paciente> listaRetornar = new ArrayList<>();
            PacienteService ps = new PacienteService();
            while (resultado.next()) {
                Integer IDPaciente = resultado.getInt(1);
                listaRetornar.add(ps.buscarPacientePorID(IDPaciente));
            }
            return listaRetornar;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al buscar los pacientes cuya dieta esté terminada en la base de datos");
        }
        return null;
    }

    //➢	Se necesita listar los pacientes que a la fecha de culminación, no han llegado al peso buscado. 
    public ArrayList<Paciente> listaPacientePesoNoLlegado() {
        try {
            String sql = "";
            consultarBaseDatos(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al retornar los pacientes cuya fecha de culminacion no haga llegado al peso buscado");
        } finally {
            desconectarBaseDatos();
        }
        return null;
    }
}
