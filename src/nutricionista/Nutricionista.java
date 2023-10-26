/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutricionista;

import Vista.Principal;
import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;

/**
 *
 * @author criss
 */
public class Nutricionista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {      
      FlatCyanLightIJTheme.setup();
        Principal p = new Principal();
        p.setVisible(true);
        p.setLocationRelativeTo(null);
    }
    
}
