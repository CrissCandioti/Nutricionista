/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import accesoDatos.PacienteDAO;
import entidades.Paciente;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
public class PacienteService {

    public void crearPaciente(String apellido, String nombre, int dni, String domicilio, String telefono) {
        try {
           
            PacienteDAO dao = new PacienteDAO();
            /**
             * Se crean dos variables con los nombre dniReglamentarioMinimo y
             * dniReglamentarioMaximo, estas variables de tipo de dato entero
             * sirven para la restriccion del documento establecido mas adelante
             */
            int dniReglamentarioMinimo = 1234567;
            int dniReglamentarioMaximo = 123456789;
            /**
             * Se procede a pasar el dato dni y las variables
             * cadenaDniReglamentarioMinimo y cadenaDniReglamentarioMaximo a
             * cadena de texto para proceder con su restriccion
             */
            String cadenaDni = Integer.toString(dni);
            String cadenaDniReglamentarioMinimo = Integer.toString(dniReglamentarioMinimo);
            String cadenaDniReglamentarioMaximo = Integer.toString(dniReglamentarioMaximo);
           
            if (apellido.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La celda del apellido no puede estar vacia");
                return;
            }
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La celda del nombre no puede estar vacia");
                return;
            }
            if (domicilio.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La celda del domicilio no puede estar vacia");
                return;
            }
            if (telefono.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La celda del telefono no puede estar vacia");
                return;
            }
            if (dao.buscarPacientePorDNI(dni) != null) {
                JOptionPane.showMessageDialog(null, "Tenemos registrado un paciente con el mismo numero de documento");
                return;
            }
            /**
             * Esta restriccion es la encarga de analizar la cantidad minima de
             * caracter que aceptan los datos del nombre y apellido
             */
            if (nombre.length() < 3 || apellido.length() < 3) {
                JOptionPane.showMessageDialog(null, "El nombre u apellido no pueden tener menos de 3 caracteres");
                return;
            }
            char primerCaracterA = apellido.charAt(0);
            if (Character.isDigit(primerCaracterA)) {
                JOptionPane.showMessageDialog(null, "El apellido no puede comenzar con numeros");
                return;
            }
            for (char caracter : apellido.toCharArray()) {
                if (Character.isDigit(caracter)) {
                    JOptionPane.showMessageDialog(null, "El apellido no puede contener caracteres numericos");
                    return;
                }
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
            /**
             * Esta restriccion se encarga de analizar la cantidad de caracteres
             * que se ingresa por el documento.
             */
            if (cadenaDni.length() > cadenaDniReglamentarioMaximo.length()) {
                JOptionPane.showMessageDialog(null, "El documento ingresado es mayor al reglamentario");
                return;
            }
            if (cadenaDni.length() < cadenaDniReglamentarioMinimo.length()) {
                JOptionPane.showMessageDialog(null, "El documento ingresado es menor al reglamentario");
                return;
            }
            if (!domicilio.matches("[a-zA-Z0-9 ñÑ]+")) {
                JOptionPane.showMessageDialog(null, "El domicilio contiene caracteres no permitidos");
                return;
            }
            if (!telefono.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "El telefono solamente debe contener digitos numericos");
                return;
            }
      
             
            dao.guardarPaciente(new Paciente(apellido, nombre, dni, domicilio, telefono));
            JOptionPane.showMessageDialog(null, "Se guardo con exito el paciente");
                                       
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear el paciente");
        }
    }

    public void modificarPaciente(int id, String apellido, String nombre, int dni, String domicilio, String telefono) {
        try {
            PacienteDAO dao = new PacienteDAO();
            int dniReglamentarioMinimo = 1234567;
            int dniReglamentarioMaximo = 123456789;
            String cadenaDni = Integer.toString(dni);
            String cadenaDniReglamentarioMinimo = Integer.toString(dniReglamentarioMinimo);
            String cadenaDniReglamentarioMaximo = Integer.toString(dniReglamentarioMaximo);
//            if (apellido.isEmpty()) {
//                JOptionPane.showMessageDialog(null, "La celda del apellido no puede estar vacia");
//                return;
//            }
//            if (nombre.isEmpty()) {
//                JOptionPane.showMessageDialog(null, "La celda del nombre no puede estar vacia");
//                return;
//            }
//            if (domicilio.isEmpty()) {
//                JOptionPane.showMessageDialog(null, "La celda del domicilio no puede estar vacia");
//                return;
//            }
//            if (telefono.isEmpty()) {
//                JOptionPane.showMessageDialog(null, "La celda del telefono no puede estar vacia");
//                return;
//            }
//            if (dao.buscarPacientePorDNI(dni) != null) {
//                JOptionPane.showMessageDialog(null, "Tenemos registrado un paciente con el mismo numero de documento");
//                return;
//            }
//            if (nombre.length() < 3 || apellido.length() < 3) {
//                JOptionPane.showMessageDialog(null, "El nombre u apellido no pueden tener menos de 3 caracteres");
//                return;
//            }
//            char primerCaracterA = apellido.charAt(0);
//            if (Character.isDigit(primerCaracterA)) {
//                JOptionPane.showMessageDialog(null, "El apellido no puede comenzar con numeros");
//                return;
//            }
//            for (char caracter : apellido.toCharArray()) {
//                if (Character.isDigit(caracter)) {
//                    JOptionPane.showMessageDialog(null, "El apellido no puede contener caracteres numericos");
//                    return;
//                }
//            }
//            char primerCaracterN = nombre.charAt(0);
//            if (Character.isDigit(primerCaracterN)) {
//                JOptionPane.showMessageDialog(null, "El nombre no puede comenzar con numeros");
//                return;
//            }
//            for (char caracter : nombre.toCharArray()) {
//                if (Character.isDigit(caracter)) {
//                    JOptionPane.showMessageDialog(null, "El nombre no puede contener caracteres numericos");
//                    return;
//                }
//            }
            if (cadenaDni.length() > cadenaDniReglamentarioMaximo.length()) {
                JOptionPane.showMessageDialog(null, "El documento ingresado es mayor al reglamentario");
                return;
            }
            if (cadenaDni.length() < cadenaDniReglamentarioMinimo.length()) {
                JOptionPane.showMessageDialog(null, "El documento ingresado es menor al reglamentario");
                return;
            }
            if (!domicilio.matches("[a-zA-Z0-9 ñÑ]+")) {
                JOptionPane.showMessageDialog(null, "El domicilio contiene caracteres no permitidos");
                return;
            }
            if (!telefono.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "El telefono solamente debe contener digitos numericos");
                return;
            }
            dao.modificarPaciente(new Paciente(id, apellido, nombre, dni, domicilio, telefono));
            JOptionPane.showMessageDialog(null, "Se modifico con exito el paciente");
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el paciente");
        }
    }

    public void eliminarPaciente(int ID) {
        try {
            PacienteDAO dao = new PacienteDAO();
            
            dao.eliminarPaciente(ID);
            JOptionPane.showMessageDialog(null, "Se elimino con exito el paciente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el paciente");
        }
    }

    public Paciente buscarPacientePorID(int ID) {
        try {
            PacienteDAO dao = new PacienteDAO();
            return dao.buscarPacientePorID(ID);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar el paciente por ID");
        }
        return null;
    }

    public Paciente buscarPacientePorDNI(int DNI) {
        try {
            PacienteDAO dao = new PacienteDAO();
            return dao.buscarPacientePorDNI(DNI);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar el paciente por DNI");
        }
        return null;
    }

    public ArrayList<Paciente> listaPaciente() {
        try {
            PacienteDAO dao = new PacienteDAO();
            return dao.listaPaciente();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar la lista de pacientes");
        }
        return null;
    }
    
    public void limpiar(JTextField txtDni, JTextField txtDomicilio,JTextField txtId, JTextField txtNombre, JTextField txtTelefono, JTextField txtapellido) {
        txtDni.setText("");
        txtDomicilio.setText("");
        txtId.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtapellido.setText("");
    }
}
