/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import accesoDatos.HistorialDAO;
import entidades.Historial;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author criss
 */
public class HistorialService {

    public void crearHistorial(int IDPaciente, double peso, LocalDate fechaRegistro) {
        try {
            HistorialDAO dao = new HistorialDAO();
            PacienteService ps = new PacienteService();
            dao.guardarHistorial(new Historial(ps.buscarPacientePorID(IDPaciente), peso, fechaRegistro));
            JOptionPane.showMessageDialog(null, "Se guardo exitosamente el historial");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear el historial");
        }
    }

    public void modificarHistorial(int IDHistorial, int IDPaciente, double peso, LocalDate fechaRegistro) {
        try {
            HistorialDAO dao = new HistorialDAO();
            PacienteService ps = new PacienteService();
            dao.modificarHistorial(new Historial(IDHistorial, ps.buscarPacientePorID(IDPaciente), peso, fechaRegistro));
            JOptionPane.showMessageDialog(null, "Se modifico correctamente el historial");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el historial");
        }
    }

    public void eliminarHistorial(int ID) {
        try {
            HistorialDAO dao = new HistorialDAO();
            dao.eliminarHistorial(ID);
            JOptionPane.showMessageDialog(null, "Se elimino correctamente el historial");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el historial");
        }
    }

    public Historial buscarHistorialPorID(int id) {
        try {
            HistorialDAO dao = new HistorialDAO();
            return dao.buscarHistorialPorID(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar el historial por id");
        }
        return null;
    }

    public Historial buscarHistorialPorIDPaciente(int IDPaciente) {
        try {
            HistorialDAO dao = new HistorialDAO();
            return dao.buscarHistorialPorPaciente(IDPaciente);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar el historial por id paciente");
        }
        return null;
    }

    public ArrayList<Historial> listaHistoriales() {
        try {
            HistorialDAO dao = new HistorialDAO();
            return dao.listaHistorial();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al retornar la lista de historiales");
        }
        return null;
    }

    public ArrayList<Historial> listaHistorialesPorPaciente(int IDPaciente) {
        try {
            HistorialDAO dao = new HistorialDAO();
            return dao.listaHistorialPorPaciente(IDPaciente);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al retornar la lista de historial del paciente");
        }
        return null;
    }
}
