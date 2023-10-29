/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Vista.GestionComida;
import Vista.GestionPaciente;
import accesoDatos.ComidaDAO;
import entidades.Comida;
import entidades.Horario;
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
public class ComidaService {

    /*
     * El metodo "ComidaService" recibe toda la informacion establecida en la
     * vistas para completar el registro de los alumnos
     */
    public void crearComida(String nombre, String detalle, int cantCalorias, Horario horario) {
        /**
         * Dentro de un bloque try-catch el metodo procede a analizar estos
         * datos con las restricciones
         */
        try {
            ComidaDAO dao = new ComidaDAO();
            /**
             * Las restricciones realizada mas adelante se encargan de
             * desempeñar distintas condiciones. Las siguientes restricciones se
             * encargan de verificar si los datos estan vacios.Muestra un
             * mensaje de ser asi.
             */
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La celda del nombre no puede estar vacia");
                return;
            }
            if (detalle.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La celda del detalle no puede estar vacia");
                return;
            }
            /**
             * La siguientes restriccion se encarga que el nombre contenga mas
             * de 3 caracteres.
             */
            if (nombre.length() < 3) {
                JOptionPane.showMessageDialog(null, "El nombre no pueden tener menos de 3 caracteres");
                return;
            }
            /**
             * La siguientes restriccion se encarga que el nombre no pueda
             * comenzar con caracteres numericos.
             */
            char primerCaracterN = nombre.charAt(0);
            if (Character.isDigit(primerCaracterN)) {
                JOptionPane.showMessageDialog(null, "El nombre no puede comenzar con numeros");
                return;
            }
            /**
             * La siguientes restriccion se encarga que el nombre no pueda
             * contener numeros dentro de el.
             */
            for (char caracter : nombre.toCharArray()) {
                if (Character.isDigit(caracter)) {
                    JOptionPane.showMessageDialog(null, "El nombre no puede contener caracteres numericos");
                    return;
                }
            }
            /**
             * La siguientes restriccion se encarga que el dato de los detalles
             * cumpla la condicion que no pueda exederse en los caracteres
             */
            if (detalle.length() >= 100) {
                JOptionPane.showMessageDialog(null, "La celda del detalle no puede contener mas de 100 caracteres");
                return;
            }
            /**
             * Se establece la comunicacion con el paquete "AccesoDatos" la cual
             * se envia por argumentos la comida instanciada para registrar en
             * la base de datos
             */
            dao.guardarComidaBaseDatos(new Comida(nombre, detalle, cantCalorias, horario));
            /**
             * Por ultimo se muestra un mensaje
             */
            JOptionPane.showMessageDialog(null, "Se agrego correctamente la comida");
            limpiar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar crear la comida");
        }
    }

    /*
     * El siguiente metodo actua muy similar con guardar comida con respecto a
     * las restricciones, se diferencia en su tarea principal que es la de
     * modificar la comida que esta registrada en la base de datos.
     */
    public void modificarComida(int idComida, String nombre, String detalle, int cantCalorias, Horario horario) {
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
            dao.modificarComidaBaseDatos(new Comida(idComida, nombre, detalle, cantCalorias, horario));
            JOptionPane.showMessageDialog(null, "Se modifico correctamente la comida");
            limpiar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar modificar la comida");
        }
    }

    /*
     * El metodo eliminarComida se encarga de eliminar la comida de la base de datos
     */
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

    /*
     * El metodo buscarComida recibe por parametro un entero con el dato del id
     * para buscar la comida en la base de datos
     */
    public Comida buscarComida(int ID) {
        try {
            ComidaDAO dao = new ComidaDAO();
            return dao.buscarComidaBaseDatos(ID);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar buscar la comida");
        }
        return null;
    }

    /*
     * El metodo listaComida se utiliza para retornar una lista con todas las
     * comidas registradas
     */
    public ArrayList<Comida> listaComida() {
        try {
            ComidaDAO dao = new ComidaDAO();
            return dao.listaComidaBaseDatos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar buscar la lista de comida");
        }
        return null;
    }

    /*
     * El metodo listaComidaBajaCalorias recibe por parametro las calorias para
     * traer una lista de comidas que tengan una cantidad menor de un
     * determinado número de calorías.
     */
    public ArrayList<Comida> listaComidaBajaCalorias(int calorias) {
        try {
            ComidaDAO dao = new ComidaDAO();
            return dao.comidasMenorCalorias(calorias);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar retornar las comida con menor calorias");
        }
        return null;
    }

    public void limpiar() {
        GestionComida.txtId.setText("");
        GestionComida.txtNombre.setText("");
        GestionComida.txtDetalle.setText("");
        GestionComida.txtCantCalorias.setText("");
    }
}
