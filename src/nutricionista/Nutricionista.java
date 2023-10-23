/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutricionista;

import Vista.Principal;
import accesoDatos.DietaComidaDAO;
import entidades.DietaComida;
import entidades.Horario;
import java.time.LocalDate;
import pdf.pdfComida;
import pdf.pdfDieta;
import pdf.pdfDietaComida;
import pdf.pdfHorario;
import pdf.pdfPaciente;
import service.ComidaService;
import service.DietaService;
import service.HistorialService;
import service.PacienteService;

/**
 *
 * @author criss
 */
public class Nutricionista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        // TODO code application logic here
//        ComidaService cs = new ComidaService();
//        //cs.crearComida("Arroz", "El arroz debe ser integral", 150);
//        //cs.modificarComida(2, "Fideos", "Fideo Moñitos", 200);
//        //cs.eliminarComida(3);
//        //System.out.println(cs.buscarComida(2));
//        //System.out.println(cs.listaComida());
//        DietaService ds = new DietaService();
////        System.out.println(ds.pacientesDietaVigente(LocalDate.now()));
////        System.out.println(ds.pacientesDietaTerminada(LocalDate.now()));
//        PacienteService ps = new PacienteService();
////        ps.crearPaciente("Merlo", "Carlitox", 3312, "JR VIñas", "0342");
//        HistorialService hs = new HistorialService();
////        System.out.println(hs.listaHistorialesPorPaciente(1));
//        Principal p = new Principal();
//        p.setVisible(true);
//        p.setLocationRelativeTo(null);
//        DietaComidaDAO dao = new DietaComidaDAO();
//        ComidaService cs = new ComidaService();
//        DietaService ds = new DietaService();
//                System.out.println(dao.PorHorario(Horario.DESAYUNO));
//        dao.guardarDietaComida(new DietaComida(cs.buscarComida(24), ds.buscarDietaPorId(15), Horario.ALMUERZO));
//            System.out.println(dao.buscarDietaComidaPorId(17));

pdfDietaComida d = new pdfDietaComida();
d.pdfPorDietaID(1);

    }
    
}
