/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import entidades.DietaComida;
import entidades.Horario;
import javax.swing.JOptionPane;
import service.ComidaService;
import service.DietaService;

/**
 *
 * @author criss
 */
public final class DietaComidaDAO extends DAO {

    public DietaComida buscarDietaComidaBaseDatos(int idDietaComida) {
        try {
            String sql = "SELECT `idDietaComida`, `idComida`, `idDieta`, `Horario` FROM `dietacomida` WHERE idDietaComida = " + idDietaComida;
            consultarBaseDatos(sql);
            DietaComida aux = null;
            ComidaService cs = new ComidaService();
            DietaService ds = new DietaService();
            String horarioStr = null;
            while (resultado.next()) {
                Integer IDComida = resultado.getInt(2);
                Integer IDDieta = resultado.getInt(3);
                horarioStr = resultado.getString(4);
                Horario horarioEnum = Horario.valueOf(horarioStr);
                aux = new DietaComida(idDietaComida, cs.buscarComida(IDComida), ds.buscarDietaPorId(IDDieta), horarioEnum);
            }
            return aux;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar la dieta comida de la base de datos");
        } finally {
            desconectarBaseDatos();
        }
        return null;
    }
}
