/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import entidades.Historial;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import service.PacienteService;

/**
 * Las clases de entidades DAO heredan los metodos de DAO,la cual consiste en la
 * coneccion a la base de datos, la desconecion a la base de datos, y los
 * metodos de consultas propios de DAO. Esta clase ademas de heredar se declara
 * como "final", debido a que no queremos que continue con la jerarquia de la
 * herencia. Esta clase de ComidaDAO va a contener los metodos necesarios para
 * la comunicacion de la base de datos por medio de los propios comandos.
 */
public final class HistorialDAO extends DAO {

    /*
     * El metodo guardarHistorial es la encargadar de comunicarse con la base de
     * datos, realizar el comando para insertar y llamar al metodo
     * insertarModificarEliminarBaseDatos de la clase que hereda.
     */
    public void guardarHistorial(Historial aux) {
        try {
            String sql = "INSERT INTO `historial`(`idPaciente`, `peso`, `fechaRegistro`) VALUES (" + aux.getIdPaciente().getIdPaciente() + "," + aux.getPeso() + ",'" + aux.getFechaRegistro() + "')";
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al intentar guardar el historial en la base de datos");
        }
    }

    /*
     * El metodo modificarHistorial recibe por parametro un historial y se
     * encarga de modificar el historial establecida en la base de datos.
     */
    public void modificarHistorial(Historial aux) {
        try {
            String sql = "UPDATE `historial` SET `idPaciente`=" + aux.getIdPaciente().getIdPaciente() + ",`peso`=" + aux.getPeso() + ",`fechaRegistro`='" + aux.getFechaRegistro() + "' WHERE idHistorial = " + aux.getIDHistorial();
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al intentar modificar el historial en la base de datos");
        }
    }

    /*
     * //El metodo eliminarHistorial recibe por parametro un dato entero
     * llamado id, el metodo elimina el historial definitivamente de la base de datos
     */
    public void eliminarHistorial(int ID) {
        try {
            String sql = "DELETE FROM `historial` WHERE idHistorial = " + ID;
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al eliminar el historial en la base de datos");
        }
    }

    /*
     * Este metodo recibe por parametro un dato entero llamado id, la cual se
     * encarga de buscar el historial y retornarlo.
     */
    public Historial buscarHistorialPorID(int ID) {
        try {
            String sql = "SELECT `idHistorial`, `idPaciente`, `peso`, `fechaRegistro` FROM `historial` WHERE idHistorial = " + ID;
            consultarBaseDatos(sql);
            Historial aux = null;
            PacienteService ps = new PacienteService();
            while (resultado.next()) {
                Integer IDPaciente = resultado.getInt(2);
                // Crear un objeto Date SQL
                java.sql.Date fechaSQL = resultado.getDate(4);
                // Se creal localDate con los valores
                LocalDate localDate = fechaSQL.toLocalDate();
                aux = new Historial(ID, ps.buscarPacientePorID(IDPaciente), resultado.getDouble(3), localDate);
            }
            return aux;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al buscar el historial en la base de datos");
        } finally {
            desconectarBaseDatos();
        }
        return null;
    }

    /*
     * Este metodo recibe por parametro un dato entero llamado IDPaciente, la cual se
     * encarga de buscar el historial por paciente y retornarlo.
     */
    public Historial buscarHistorialPorPaciente(int IDPaciente) {
        try {
            String sql = "SELECT `idHistorial`, `idPaciente`, `peso`, `fechaRegistro` FROM `historial` WHERE idPaciente = " + IDPaciente;
            consultarBaseDatos(sql);
            Historial aux = null;
            PacienteService ps = new PacienteService();
            while (resultado.next()) {
                // Crear un objeto Date SQL
                java.sql.Date fechaSQL = resultado.getDate(4);
                // Se creal localDate con los valores
                LocalDate localDate = fechaSQL.toLocalDate();
                aux = new Historial(resultado.getInt(1), ps.buscarPacientePorID(IDPaciente), resultado.getDouble(3), localDate);
            }
            return aux;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al buscar el historial por paciente en la base de datos");
        } finally {
            desconectarBaseDatos();
        }
        return null;
    }

    /*
     * El metodo listaHistorial se encarga de retornar todos los historiales
     * que estan registradas en la base de datos.
     */
    public ArrayList<Historial> listaHistorial() {
        try {
            String sql = "SELECT `idHistorial`, `idPaciente`, `peso`, `fechaRegistro` FROM `historial`";
            consultarBaseDatos(sql);
            ArrayList<Historial> listaRetornar = new ArrayList<>();
            PacienteService ps = new PacienteService();
            while (resultado.next()) {
                Integer IDPaciente = resultado.getInt(2);
                java.sql.Date fechaSQL = resultado.getDate(4);
                LocalDate localDate = fechaSQL.toLocalDate();
                listaRetornar.add(new Historial(resultado.getInt(1), ps.buscarPacientePorID(IDPaciente), resultado.getDouble(3), localDate));
            }
            return listaRetornar;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al buscar la lista de historiales en la base de datos");
        } finally {
            desconectarBaseDatos();
        }
        return null;
    }

    /*
     * El metodo listaHistorialPorPaciente recibe por parametro un dato entero 
     * indicando el ID del Paciente, para retornar todos los historiales que 
     * contenga ese paciente en la base de datos.
     */
    public ArrayList<Historial> listaHistorialPorPaciente(int IDPaciente) {
        try {
            String sql = "SELECT `idHistorial`, `idPaciente`, `peso`, `fechaRegistro` FROM `historial` WHERE idPaciente = " + IDPaciente;
            consultarBaseDatos(sql);
            ArrayList<Historial> listaRetornar = new ArrayList<>();
            PacienteService ps = new PacienteService();
            while (resultado.next()) {
                java.sql.Date fechaSQL = resultado.getDate(4);
                LocalDate localDate = fechaSQL.toLocalDate();
                listaRetornar.add(new Historial(resultado.getInt(1), ps.buscarPacientePorID(IDPaciente), resultado.getDouble(3), localDate));
            }
            return listaRetornar;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al buscar la lista de historiales en la base de datos");
        } finally {
            desconectarBaseDatos();
        }
        return null;
    }
}
