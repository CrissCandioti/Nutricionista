/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import entidades.Comida;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Las clases de entidades DAO heredan los metodos de DAO,la cual consiste en la
 * coneccion a la base de datos, la desconecion a la base de datos, y los
 * metodos de consultas propios de DAO. Esta clase ademas de heredar se declara
 * como "final", debido a que no queremos que continue con la jerarquia de la
 * herencia. Esta clase de ComidaDAO va a contener los metodos necesarios para
 * la comunicacion de la base de datos por medio de los propios comandos.
 */
public final class ComidaDAO extends DAO {

    /*
     * El metodo guardarComidaBaseDatos es la encargadar de comunicarse con la base de
     * datos, realizar el comando para insertar y llamar al metodo
     * insertarModificarEliminarBaseDatos de la clase que hereda.
     */
    public void guardarComidaBaseDatos(Comida aux) {
        try {
            String sql = "INSERT INTO `comida`(`nombre`, `detalle`, `cantCalorias`) VALUES ('" + aux.getNombre() + "','" + aux.getDetalle() + "'," + aux.getCantCalorias() + ")";
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al guardar la comida en la base de datos");
        }
    }

    /*
     * El metodo modificarComidaBaseDatos recibe por parametro un alimento y se
     * encarga de modificar la comida establecida en la base de datos.
     */
    public void modificarComidaBaseDatos(Comida aux) {
        try {
            String sql = "UPDATE `comida` SET `nombre`='" + aux.getNombre() + "',`detalle`='" + aux.getDetalle() + "',`cantCalorias`=" + aux.getCantCalorias() + " WHERE idComida = " + aux.getIdComida();
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al modificar la comida en la base de datos");
        }
    }

    /*
     * //El metodo eliminarComidaBaseDatos recibe por parametro un dato entero
     * llamado id, el metodo elimina la comida definitivamente de la base de datos
     */
    public void eliminarComidaBaseDatos(int ID) {
        try {
            String sql = "DELETE FROM `comida` WHERE idComida = " + ID;
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al eliminar la comida en la base de datos");
        }
    }

    /*
     * Este metodo recibe por parametro un dato entero llamado id, la cual se
     * encarga de buscar la comida y retornarlo.
     */
    public Comida buscarComidaBaseDatos(int ID) {
        try {
            String sql = "SELECT `idComida`, `nombre`, `detalle`, `cantCalorias` FROM `comida` WHERE idComida = " + ID;
            consultarBaseDatos(sql);
            Comida aux = null;
            while (resultado.next()) {
                aux = new Comida(ID, resultado.getString(2), resultado.getString(3), resultado.getInt(4));
            }
            return aux;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al buscar la comida en la base de datos"+e);
        } finally {
            desconectarBaseDatos();
        }
        return null;
    }

    /*
     * El metodo listaComidaBaseDatos se encarga de retornar todas las comidas
     * que estan registradas en la base de datos.
     */
    public ArrayList<Comida> listaComidaBaseDatos() {
        try {
            String sql = "SELECT `idComida`, `nombre`, `detalle`, `cantCalorias` FROM `comida` ORDER BY nombre ASC";
            consultarBaseDatos(sql);
            ArrayList<Comida> listaRetornar = new ArrayList<>();
            while (resultado.next()) {
                listaRetornar.add(new Comida(resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getInt(4)));
            }
            return listaRetornar;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al listar las comida de la base de datos");
        } finally {
            desconectarBaseDatos();
        }
        return null;
    }

    /*
     * El metodo comidasMenorCalorias se encarga de retornar una lista con las
     * comidas que contiene calorias minimas, este metodo recibe por parametro
     * un entero llamado calorias la cual se realiza una comparacion con ese
     * dato y retorna la lista con comidas que tengan menos calorias al pasado
     * por parametro.
     */
    public ArrayList<Comida> comidasMenorCalorias(int calorias) {
        try {
            String sql = "SELECT `idComida`, `nombre`, `detalle`, `cantCalorias` FROM `comida` WHERE cantCalorias <= " + calorias;
            consultarBaseDatos(sql);
            ArrayList<Comida> listaRetornar = new ArrayList<>();
            while (resultado.next()) {
                listaRetornar.add(new Comida(resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getInt(4)));
            }
            return listaRetornar;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al retornar las comida con menor calorias de la base de datos");
        } finally {
            desconectarBaseDatos();
        }
        return null;
    }
}
