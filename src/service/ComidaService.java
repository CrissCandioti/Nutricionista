/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import accesoDatos.ComidaDAO;
import entidades.Comida;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author criss
 */
public class ComidaService {
//detalle 100 carateres

    public void crearComida(String nombre, String detalle, int cantCalorias) {
        try {
            ComidaDAO dao = new ComidaDAO();
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La celda del nombre no puede estar vacia");
                return;
            }
            if (detalle.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La celda del detalle no puede estar vacia");
                return;
            }
            if (nombre.length() < 3) {
                JOptionPane.showMessageDialog(null, "El nombre no pueden tener menos de 3 caracteres");
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
            if (detalle.length() >= 100) {
                JOptionPane.showMessageDialog(null, "La celda del detalle no puede contener mas de 100 caracteres");
                return;
            }
            dao.guardarComidaBaseDatos(new Comida(nombre, detalle, cantCalorias));
            JOptionPane.showMessageDialog(null, "Se agrego correctamente la comida");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar crear la comida");
        }
    }

    public void modificarComida(int idComida, String nombre, String detalle, int cantCalorias) {
        try {
            ComidaDAO dao = new ComidaDAO();
            if (dao.buscarComidaBaseDatos(idComida) == null) {
                JOptionPane.showMessageDialog(null, "No se encontro la comida seleccionada para su modificacion");
                return;
            }
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La celda del nombre no puede estar vacia");
                return;
            }
            if (detalle.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La celda del detalle no puede estar vacia");
                return;
            }
            if (nombre.length() < 3) {
                JOptionPane.showMessageDialog(null, "El nombre no pueden tener menos de 3 caracteres");
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
            if (detalle.length() >= 100) {
                JOptionPane.showMessageDialog(null, "La celda del detalle no puede contener mas de 100 caracteres");
                return;
            }
            dao.modificarComidaBaseDatos(new Comida(idComida, nombre, detalle, cantCalorias));
            JOptionPane.showMessageDialog(null, "Se modifico correctamente la comida");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar modificar la comida");
        }
    }

    public void eliminarComida(int ID) {
        try {
            ComidaDAO dao = new ComidaDAO();
            if (dao.buscarComidaBaseDatos(ID) == null) {
                JOptionPane.showMessageDialog(null, "No se encontro la comida elegida");
                return;
            }
            dao.eliminarComidaBaseDatos(ID);
            JOptionPane.showMessageDialog(null, "Se elimino correctamente la comida");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar eliminar la comida");
        }
    }

    public Comida buscarComida(int ID) {
        try {
            ComidaDAO dao = new ComidaDAO();
            return dao.buscarComidaBaseDatos(ID);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar buscar la comida");
        }
        return null;
    }

    public ArrayList<Comida> listaComida() {
        try {
            ComidaDAO dao = new ComidaDAO();
            return dao.listaComidaBaseDatos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar buscar la lista de comida");
        }
        return null;
    }
    
    public ArrayList<Comida> listaComidaBajaCalorias(int calorias) {
        try {
            ComidaDAO dao = new ComidaDAO();
            return dao.comidasMenorCalorias(calorias);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar retornar las comida con menor calorias");
        }
        return null;
    }
}
