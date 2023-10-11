/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import entidades.Comida;
import entidades.Dieta;
import entidades.Paciente;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import service.DietaService;
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
// metodo para que me traiga todas las dietas de la base de dato

    public ArrayList<Dieta> listaDietaBaseDatos() {
        try {
            String sql = "SELECT * FROM `dieta` ORDER BY nombre ASC";
            consultarBaseDatos(sql);
            ArrayList<Dieta> listaRetornar = new ArrayList<>();
            PacienteService ps = new PacienteService();
            while (resultado.next()) {
                Integer idPaciente = resultado.getInt(3);
                java.sql.Date fechaSQL = resultado.getDate(4);
                LocalDate fechaI = fechaSQL.toLocalDate();
                java.sql.Date fechaSqlF = resultado.getDate(7);
                LocalDate fechaF = fechaSqlF.toLocalDate();
                listaRetornar.add(new Dieta(resultado.getInt(1), resultado.getString(2), ps.buscarPacientePorID(idPaciente), fechaI, resultado.getInt(5), resultado.getInt(6), fechaF));
            }
            return listaRetornar;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al listar las dietas de la base de datos");
        } finally {
            desconectarBaseDatos();
        }
        return null;
    }

    //metodo para buscar dieta por id
    public Dieta buscarDietaPorId(int ID) {
        try {
            String sql = "SELECT * FROM dieta WHERE idDieta = " + ID;
            consultarBaseDatos(sql);
            Dieta dieta = null;
            PacienteService ps = new PacienteService();
            while (resultado.next()) {
                Integer idPaciente = resultado.getInt(3);
                java.sql.Date fechaSQL = resultado.getDate(4);
                LocalDate fechaI = fechaSQL.toLocalDate();
                java.sql.Date fechaSqlF = resultado.getDate(7);
                LocalDate fechaF = fechaSqlF.toLocalDate();
               dieta = new Dieta(ID, resultado.getString(2), ps.buscarPacientePorID(idPaciente), fechaI, resultado.getInt(5), resultado.getInt(6), fechaF);

            }
            return dieta;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al buscar dieta en la base de datos");
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

}
