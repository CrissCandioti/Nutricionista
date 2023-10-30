/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import accesoDatos.ComidaDAO;
import accesoDatos.DietaComidaDAO;
import entidades.Comida;
import entidades.DietaComida;
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
public class DietaComidaService {

    public void crearDietaComida(int idComida, int idDieta, Horario horario) {
        try {
            DietaComidaDAO dao = new DietaComidaDAO();
            ComidaService cs = new ComidaService();
            DietaService ds = new DietaService();

            if (cs.buscarComida(idComida) == null) {
                JOptionPane.showMessageDialog(null, "No se encontro ninguna comida asociada a la dieta");
                return;
            }
            if (ds.buscarDietaPorId(idDieta) == null) {
                JOptionPane.showMessageDialog(null, "No se encontro ninguna comida asociada a la dieta");
                return;
            }
            if (horario == null) {
                JOptionPane.showMessageDialog(null, "No selecciono un horario correspondiente a la dieta");
                return;
            }
            dao.guardarDietaComida(new DietaComida(cs.buscarComida(idComida), ds.buscarDietaPorId(idDieta), horario));
            JOptionPane.showMessageDialog(null, "Se guardo con exito la asociación de la dieta con la comida");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar la asociación de la dieta con la comida");
        }
    }

    public DietaComida buscarDietaComidaPorID(int IDDietaComida) {
        try {
            DietaComidaDAO dao = new DietaComidaDAO();
            return dao.buscarDietaComidaPorId(IDDietaComida);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar asociación de la dieta con la comida por ID");
        }
        return null;
    }

    public void modificarDietaComida(int id, int idComida, int idDieta, Horario horario) {
        try {
            DietaComidaDAO dao = new DietaComidaDAO();
            ComidaService cs = new ComidaService();
            DietaService ds = new DietaService();

            if (cs.buscarComida(idComida) == null) {
                JOptionPane.showMessageDialog(null, "No se encontro ninguna comida asociada a la dieta");
                return;
            }
            if (ds.buscarDietaPorId(idDieta) == null) {
                JOptionPane.showMessageDialog(null, "No se encontro ninguna comida asociada a la dieta");
                return;
            }
            if (horario == null) {
                JOptionPane.showMessageDialog(null, "No selecciono un horario correspondiente a la dieta");
                return;
            }
            dao.modificarDietaComida(new DietaComida(id, cs.buscarComida(idComida), ds.buscarDietaPorId(idDieta), horario));
            JOptionPane.showMessageDialog(null, "Se modifico con exito la asociación de la dieta con la comida");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar la asociación de la dieta con la comida");
        }
    }

    public void eliminarDietaComida(int IDComida, int IDDieta) {
        try {
            DietaComidaDAO dao = new DietaComidaDAO();
           dao.eliminarDietaComidaPorIdComida(IDComida,IDDieta);
            JOptionPane.showMessageDialog(null, "Se elimino correctamente la asociación de la dieta con la comida");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la asociación de la dieta con la comida");
        }
    }

    public ArrayList<DietaComida> listaDietaComida() {
        try {
            DietaComidaDAO dao = new DietaComidaDAO();
            return dao.listaDietaComida();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al retornar la lista de la asociación de la dieta con la comida");
        }
        return null;
    }

    public Comida comidaDietaEspecifica(int IDDietaComida) {
        try {
            DietaComidaDAO dao = new DietaComidaDAO();
            return dao.comidaDietaEspecifica(IDDietaComida);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar la comida especifica de la dieta");
        }
        return null;
    }

    public DietaComida PorHorario(Horario index) {
        try {
            DietaComidaDAO dao = new DietaComidaDAO();
            return dao.PorHorario(index);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar la asociación de la dieta con la comida en el horario especifico");
        }
        return null;
    }
    
    public ArrayList<DietaComida> listaPorHorario (Horario index) {
        try {
            DietaComidaDAO dao = new DietaComidaDAO();
            return dao.listaPorHorario(index);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar la asociación de la dieta con la comida en el horario especifico");
        }
        return null;
    }
    
    public ArrayList<DietaComida> listaDietaComidaPorID(int id) {
        try {
            DietaComidaDAO dao = new DietaComidaDAO();
            return dao.listaDietaComidaPorID(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al retornar la lista de la asociación de la dieta con la comida");
        }
        return null;
    }
}
