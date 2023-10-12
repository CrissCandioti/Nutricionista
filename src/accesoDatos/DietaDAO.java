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

    public ArrayList<Dieta> listaDieta() {
        try {
            String sql = "SELECT `idDieta`, `nombre`, `idPaciente`, `fechaInicial`, `pesoInicial`, `pesoFinal`, `fechaFinal` FROM `dieta`";
            consultarBaseDatos(sql);
            PacienteService ps = new PacienteService();
            ArrayList<Dieta> listaRetornar = new ArrayList<>();
            while (resultado.next()) {
                Integer IDPaciente = resultado.getInt(3);
                //fechaInicial
                java.sql.Date fechaSQLFechaInicial = resultado.getDate(4);
                LocalDate fechaInicial = fechaSQLFechaInicial.toLocalDate();
                //fechaFinal
                java.sql.Date fechaSQLFechaFinal = resultado.getDate(7);
                LocalDate fechaFinal = fechaSQLFechaFinal.toLocalDate();
                listaRetornar.add(new Dieta(resultado.getInt(1), resultado.getString(2), ps.buscarPacientePorID(IDPaciente), fechaInicial, resultado.getDouble(5), resultado.getDouble(6), fechaFinal));
            }
            return listaRetornar;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al retornar la lista de dietas de la base de datos");
        } finally {
            desconectarBaseDatos();
        }
        return null;
    }

    public Dieta buscarDietaPorId(int id) {
        try {
            String sql = "SELECT `idDieta`, `nombre`, `idPaciente`, `fechaInicial`, `pesoInicial`, `pesoFinal`, `fechaFinal` FROM `dieta` WHERE idDieta = " + id;
            consultarBaseDatos(sql);
            PacienteService ps = new PacienteService();
            Dieta aux = null;
            while (resultado.next()) {
                Integer IDPaciente = resultado.getInt(3);
                //fechaInicial
                java.sql.Date fechaSQLFechaInicial = resultado.getDate(4);
                LocalDate fechaInicial = fechaSQLFechaInicial.toLocalDate();
                //fechaFinal
                java.sql.Date fechaSQLFechaFinal = resultado.getDate(7);
                LocalDate fechaFinal = fechaSQLFechaFinal.toLocalDate();
                aux = new Dieta(id, resultado.getString(2), ps.buscarPacientePorID(IDPaciente), fechaInicial, resultado.getDouble(5), resultado.getDouble(6), fechaFinal);
            }
            return aux;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al buscar la dieta en la base de datos");
        } finally {
            desconectarBaseDatos();
        }
        return null;
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
        } finally {
            desconectarBaseDatos();
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

    //Se necesita listar los pacientes que a la fecha de culminación, no han llegado al peso buscado. 
    public ArrayList<Paciente> listaPacientePesoNoLlegado() {
        try {
            String sql = "SELECT idPaciente from dieta inner join historial on dieta.idPaciente = historial.idPaciente AND dieta.pesoFinal<>historial.peso and historial.fechaRegistro=dieta.fechaFinal";
            consultarBaseDatos(sql);
            ArrayList<Paciente> listaRetornar = new ArrayList<>();
            PacienteService ps = new PacienteService();
            while (resultado.next()) {
                Integer IDPaciente = resultado.getInt(1);
                listaRetornar.add(ps.buscarPacientePorID(IDPaciente));
            }
            return listaRetornar;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al retornar los pacientes cuya fecha de culminacion no haga llegado al peso buscado en la base de datos");
        } finally {
            desconectarBaseDatos();
        }
        return null;
    }
}
