/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

/**
 *
 * @author criss
 */
public final class PDFDAO extends DAO {

    public void creadorPDFPaciente() {
        try {
            String sql = "SELECT `idPaciente`, `apellido`, `nombre`, `dni`, `domicilio`, `telefono` FROM `paciente`";
            consultarBaseDatos(sql);
            Document documento = new Document();
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/OneDrive/Escritorio/Reporte_Pacientes.pdf"));
            documento.open();
            PdfPTable tabla = new PdfPTable(6);
            tabla.addCell("ID");
            tabla.addCell("Apellido");
            tabla.addCell("Nombre");
            tabla.addCell("DNI");
            tabla.addCell("Domicilio");
            tabla.addCell("Telefono");
            if (resultado.next()) {
                do {
                    tabla.addCell(resultado.getString(1));
                    tabla.addCell(resultado.getString(2));
                    tabla.addCell(resultado.getString(3));
                    tabla.addCell(resultado.getString(4));
                    tabla.addCell(resultado.getString(5));
                    tabla.addCell(resultado.getString(6));
                } while (resultado.next());
                documento.add(tabla);
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Se genero con exito el reporte");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al crear el PDF");
        }
    }
}
