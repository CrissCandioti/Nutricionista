/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import accesoDatos.DietaDAO;
import entidades.Dieta;
import entidades.Paciente;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * El paquete Service contiene las clases comidaService, dietaService,
 * dietaComidaService, historialService y pacienteService. Estas clases estan en
 * constante comunicacion con el paquete "Vista" y con el paquete "Acceso a
 * Datos" Estas clases primero reciben los datos obtenidos de las "Vistas",
 * luego cada uno de los metodos ubicados dentro de las clases Services se
 * encargan de analizar y de cumplir las restricciones programas. Una vez de
 * desempeñar con la tarea asignada cada metodo establece una comunicacion con
 * el paquete "AccesoDatos", la cual se encarga de enviarle esta informacion.
 */
public class DietaService {

    public void crearDieta(String nombre, int idPaciente, LocalDate fechaInicial, double pesoInicial, double pesoFinal, LocalDate fechaFinal) {
        try {
            DietaDAO dao = new DietaDAO();
            HistorialService hs = new HistorialService();
            PacienteService ps = new PacienteService();
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La celda del nombre no puede estar vacia");
                return;
            }
            char primerCaracterN = nombre.charAt(0);
            if (Character.isDigit(primerCaracterN)) {
                JOptionPane.showMessageDialog(null, "El nombre no puede comenzar con numeros");
                return;
            }
            for (char caracter : nombre.toCharArray()) {
                if (Character.isDigit(caracter)) {
                    JOptionPane.showMessageDialog(null, "El nombre no puede contener caracteres numericos");
                    return;
                }
            }
            if (dao.dietaPorPaciente(idPaciente) != null) {
                JOptionPane.showMessageDialog(null, "El paciente ya esta registrado a una dieta, modifique u elimine la que ya tiene");
                return;
            }
            dao.guardarDieta(new Dieta(nombre, ps.buscarPacientePorID(idPaciente), fechaInicial, pesoInicial, pesoFinal, fechaFinal));
            JOptionPane.showMessageDialog(null, "Se guardo correctamente la dieta");
            hs.crearHistorial(idPaciente, pesoFinal, fechaInicial);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear la dieta");
        }
    }

    public void modificarDieta(int idDieta, String nombre, int idPaciente, LocalDate fechaInicial, double pesoInicial, double pesoFinal, LocalDate fechaFinal) {
        try {
            DietaDAO dao = new DietaDAO();
            PacienteService ps = new PacienteService();
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La celda del nombre no puede estar vacia");
                return;
            }
            char primerCaracterN = nombre.charAt(0);
            if (Character.isDigit(primerCaracterN)) {
                JOptionPane.showMessageDialog(null, "El nombre no puede comenzar con numeros");
                return;
            }
            for (char caracter : nombre.toCharArray()) {
                if (Character.isDigit(caracter)) {
                    JOptionPane.showMessageDialog(null, "El nombre no puede contener caracteres numericos");
                    return;
                }
            }
            dao.modificarDieta(new Dieta(idDieta, nombre, ps.buscarPacientePorID(idPaciente), fechaInicial, pesoInicial, pesoFinal, fechaFinal));
            JOptionPane.showMessageDialog(null, "Se modificar correctamente la dieta");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar la dieta");
        }
    }

    public ArrayList<Dieta> listaDietas() {
        try {
            DietaDAO dao = new DietaDAO();
            return dao.listaDieta();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al retornar la lista de dietas");
        }

        return null;
    }

    public Dieta buscarDietaPorId(int id) {
        try {
            DietaDAO dao = new DietaDAO();
            return dao.buscarDietaPorId(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar dieta por id");
        }
        return null;
    }

    public ArrayList<Dieta> pacientesDietaVigente(LocalDate fecha) {
        try {
            DietaDAO dao = new DietaDAO();
            return dao.pacientesDietaVigente(fecha);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar los pacientes cuya dieta esté vigente");
        }
        return null;
    }

    public ArrayList<Dieta> pacientesDietaTerminada(LocalDate fecha) {
        try {
            DietaDAO dao = new DietaDAO();
            return dao.pacientesDietaTerminada(fecha);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar los pacientes cuya dieta esté terminada");
        }
        return null;
    }

    public ArrayList<Dieta> listaPacientePesoNoLlegado() {
        try {
            DietaDAO dao = new DietaDAO();
            return dao.listaPacientePesoNoLlegado();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al retornar los pacientes cuya fecha de culminacion no haga llegado al peso buscado");
        }
        return null;
    }

    public void eliminarDieta(int id) {
        try {
            DietaDAO dd = new DietaDAO();
            dd.eliminarDieta(id);
            JOptionPane.showMessageDialog(null, "Se elimino correctamente la dieta");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar dieta" + e);
        }
    }

    public Dieta dietaPorPaciente(int idPaciente) {
        try {
            DietaDAO dao = new DietaDAO();
            return dao.dietaPorPaciente(idPaciente);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar la dieta por paciente");
        }
        return null;
    }
}
