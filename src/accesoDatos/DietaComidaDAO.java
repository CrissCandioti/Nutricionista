/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import entidades.DietaComida;
import entidades.Horario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import service.ComidaService;
import service.DietaService;

/**
 *
 * @author criss
 */
public final class DietaComidaDAO extends DAO {

    public void guardarDietaComida(DietaComida aux) {
        try {
            String sql = "INSERT INTO `dietacomida`(`idComida`, `idDieta`, `Horario`) VALUES ('" + aux.getIdComida() + "','" + aux.getIdDieta() + "','" + aux.getHorario() + "')";
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al guardar dietaComida en la base de datos");
        }
    }

    public void modificarDietaComida(DietaComida aux) {
        try {
            String sql = "UPDATE `dietacomida`(`idDietaComida`, `idComida`, `idDieta`, `Horario`) VALUES ('" + aux.getIdDietaComida() + ",'" + aux.getIdComida() + "','" + aux.getIdDieta() + "','" + aux.getHorario() + "')";
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al modificar dietaComida en la base de datos");
        }
    }

    public void eliminarDietaComida(int ID) {
        try {
            String sql = "DELETE FROM `dietacomida` WHERE idDietaComida = " + ID;
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al eliminar la dietaComida de la base de datos");
        }
    }

    public DietaComida buscarDietaComidaPorId(int ID) {

        try {
            String sql = "SELECT `idDietaComida`, `idComida`, `idDieta`, `Horario` FROM `dietacomida` WHERE idDietaComida= " + ID;
            consultarBaseDatos(sql);
            DietaComida aux = null;
            ComidaService comida = new ComidaService();
            DietaService dieta = new DietaService();
            while (resultado.next()) {
                aux = new DietaComida(ID, comida.buscarComida(resultado.getInt(2)), dieta.buscarDietaPorId(resultado.getInt(3)), Horario.valueOf(resultado.getString(4)));
            }
            return aux;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al buscar dieta comida por ID en la base de datos");
        } finally {
            desconectarBaseDatos();
        }
        return null;
    }

    public ArrayList<DietaComida> listaDietaComida() {
        try {
            String sql = "SELECT `idDietaComida`, `idComida`, `idDieta`, `Horario` FROM `dietacomida` ";
            consultarBaseDatos(sql);
            ArrayList<DietaComida> listaRetornar = new ArrayList<>();
            ComidaService comida = new ComidaService();
            DietaService dieta = new DietaService();
            while (resultado.next()) {
                listaRetornar.add(new DietaComida(resultado.getInt(1), comida.buscarComida(resultado.getInt(2)), dieta.buscarDietaPorId(resultado.getInt(3)), Horario.valueOf(resultado.getString(4))));
            }
            return listaRetornar;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al retornar la lista de la asociación de la dieta con la comida");
        } finally {
            desconectarBaseDatos();
        }
        return null;
    }
    
}
