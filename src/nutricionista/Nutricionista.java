/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutricionista;

import Vista.Principal;
import service.ComidaService;

/**
 *
 * @author criss
 */
public class Nutricionista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Principal p = new Principal();
        p.setVisible(true);
        p.setLocationRelativeTo(null);
        
        
        // TODO code application logic here
        ComidaService cs = new ComidaService();
        //cs.crearComida("Arroz", "El arroz debe ser integral", 150);
        //cs.modificarComida(2, "Fideos", "Fideo Moñitos", 200);
        //cs.eliminarComida(3);
        //System.out.println(cs.buscarComida(2));
        //System.out.println(cs.listaComida());
    }
    
}
