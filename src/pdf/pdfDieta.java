/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf;

import accesoDatos.DAO;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import entidades.Dieta;
import java.io.File;

/**
 *
 * @author criss
 */
public final class pdfDieta extends DAO {

    public void pdfPorDietaID(int id) {
        try {
            String sql = "SELECT `nombre`, `idPaciente`, `fechaInicial`, `pesoInicial`, `pesoFinal`, `fechaFinal` FROM `dieta` WHERE idDieta = " + id;
            consultarBaseDatos(sql);
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al realizar el reporte de la dieta" + e);
        }
    }
}
//tabla dietacomida por id, tabla con los pacientes que llegaron al peso y lo demas (guiar con las vistas)