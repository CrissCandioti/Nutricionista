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
 *
 * @author criss
 */
public final class ComidaDAO extends DAO {

    public void guardarComidaBaseDatos(Comida aux) {
        try {
            String sql = "INSERT INTO `comida`(`nombre`, `detalle`, `cantCalorias`) VALUES ('" + aux.getNombre() + "','" + aux.getDetalle() + "'," + aux.getCantCalorias() + ")";
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al guardar la comida en la base de datos");
        }
    }

    public void modificarComidaBaseDatos(Comida aux) {
        try {
            String sql = "UPDATE `comida` SET `nombre`='" + aux.getNombre() + "',`detalle`='" + aux.getDetalle() + "',`cantCalorias`=" + aux.getCantCalorias() + " WHERE idComida = " + aux.getIdComida();
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al modificar la comida en la base de datos");
        }
    }

    public void eliminarComidaBaseDatos(int ID) {
        try {
            String sql = "DELETE FROM `comida` WHERE idComida = " + ID;
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al eliminar la comida en la base de datos");
        }
    }

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
            JOptionPane.showMessageDialog(null, "Se produjo un error al buscar la comida en la base de datos");
        } finally {
            desconectarBaseDatos();
        }
        return null;
    }

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
}
