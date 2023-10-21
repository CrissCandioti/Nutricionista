/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import entidades.Comida;
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
            String sql = "INSERT INTO `dietacomida`(`idComida`, `idDieta`, `Horario`) VALUES (" + aux.getIdComida().getIdComida() + "," + aux.getIdDieta().getIdDieta() + ",'" + aux.getHorario().toString() + "')";
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
            String sql = "SELECT `idDietaComida`, `idComida`, `idDieta`, `Horario` FROM `dietacomida` WHERE idDieta= " + ID;
            consultarBaseDatos(sql);
            DietaComida aux = null;
            ComidaService comida = new ComidaService();
            DietaService dieta = new DietaService();
            while (resultado.next()) {
                aux = new DietaComida(resultado.getInt(1), comida.buscarComida(resultado.getInt(2)), dieta.buscarDietaPorId(resultado.getInt(3)), Horario.valueOf(resultado.getString(4)));
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

    public Comida comidaDietaEspecifica(int IDDietaComida) {
        try {
            String sql = "SELECT `idComida` FROM `dietacomida` WHERE idDietaComida = " + IDDietaComida;
            consultarBaseDatos(sql);
            ComidaService cs = new ComidaService();
            Comida aux = null;
            while (resultado.next()) {
                Integer IDComida = resultado.getInt(1);
                aux = cs.buscarComida(IDComida);
            }
            return aux;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al retornar la comida especifica de la asociación de la dieta con la comida");
        } finally {
            desconectarBaseDatos();
        }
        return null;
    }

    public DietaComida PorHorario(Horario index) {
        try {
            String sql = "SELECT `idDietaComida`, `idComida`, `idDieta`, `Horario` FROM `dietacomida` WHERE Horario = '" + index + "'";
            consultarBaseDatos(sql);
            DietaComida aux = null;
            ComidaService comida = new ComidaService();
            DietaService dieta = new DietaService();
            while (resultado.next()) {
                aux = new DietaComida(resultado.getInt(1), comida.buscarComida(resultado.getInt(2)), dieta.buscarDietaPorId(resultado.getInt(3)), index);
            }
            return aux;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al buscar la asociación de la dieta con la comida en el horario especifico");
        } finally {
            desconectarBaseDatos();
        }
        return null;
    }

    public ArrayList<DietaComida> listaPorHorario(Horario index) {
        try {
            String sql = "SELECT `idDietaComida`, `idComida`, `idDieta`, `Horario` FROM `dietacomida` WHERE Horario = '" + index + "'";
            consultarBaseDatos(sql);
            ArrayList<DietaComida> lsitaRetornar = new ArrayList<>();

            ComidaService comida = new ComidaService();
            DietaService dieta = new DietaService();
            while (resultado.next()) {
                lsitaRetornar.add(new DietaComida(resultado.getInt(1), comida.buscarComida(resultado.getInt(2)), dieta.buscarDietaPorId(resultado.getInt(3)), index));
            }
            return lsitaRetornar;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al buscar la asociación de la dieta con la comida en el horario especifico");
        } finally {
            desconectarBaseDatos();
        }
        return null;
    }

    public ArrayList<DietaComida> listaDietaComidaPorID(int id) {
        try {
            String sql = "SELECT * FROM `dietacomida` WHERE idDieta = " + id + " ORDER BY CASE Horario WHEN 'DESAYUNO' THEN 1 WHEN 'ALMUERZO' THEN 2 WHEN 'MERIENDA' THEN 3 WHEN 'CENA' THEN 4 WHEN 'SNACK' THEN 5 ELSE 6 END; ";
            consultarBaseDatos(sql);
            ArrayList<DietaComida> listaRetornar = new ArrayList<>();
            ComidaService cs = new ComidaService();
            DietaService ds = new DietaService();
            while (resultado.next()) {
                Integer IDComida = resultado.getInt(2);
                Integer IDDieta = resultado.getInt(3);
                listaRetornar.add(new DietaComida(resultado.getInt(1), cs.buscarComida(IDComida), ds.buscarDietaPorId(IDDieta), Horario.valueOf(resultado.getString(4))));
            
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
