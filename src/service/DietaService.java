/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import accesoDatos.DietaDAO;
import entidades.Dieta;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author criss
 */
public class DietaService {

    public void crearDieta(String nombre, int idPaciente, LocalDate fechaInicial, double pesoInicial, double pesoFinal, LocalDate fechaFinal) {
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
            dao.guardarDieta(new Dieta(nombre, ps.buscarPacientePorID(idPaciente), fechaInicial, pesoInicial, pesoFinal, fechaFinal));
            JOptionPane.showMessageDialog(null, "Se guardo correctamente la dieta");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear la dieta");
        }
    }
}
