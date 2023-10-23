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
import java.io.File;

/**
 *
 * @author criss
 */
public final class pdfComida extends DAO {

    public void pdfTodasLasComidasTabla() {
        try {
            String sql = "SELECT * FROM `comida` ORDER BY nombre ASC";
            consultarBaseDatos(sql);
            int contador = 0;
            Document documento = new Document();

            String ruta = System.getProperty("user.home");
            String nombrePDF = "/OneDrive/Escritorio/Tabla_Comidas.pdf";

            while (new File(ruta + nombrePDF).exists()) {
                contador++;
                nombrePDF = "/OneDrive/Escritorio/Tabla_Comida(" + contador + ").pdf";
            }
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + nombrePDF));

            Image header = Image.getInstance("src/pdf/nutricion.png");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Clinica Nutricional © \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Tabla Comidas \n\n");

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(4);
            tabla.addCell("CODIGO");
            tabla.addCell("NOMBRE");
            tabla.addCell("DETALLE");
            tabla.addCell("CALORIAS");
            if (resultado.next()) {
                do {
                    tabla.addCell(resultado.getString(1));
                    tabla.addCell(resultado.getString(2));
                    tabla.addCell(resultado.getString(3));
                    tabla.addCell(resultado.getString(4));
                } while (resultado.next());
                documento.add(tabla);
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Se genero con exito el reporte Tabla Comidas");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al crear el PDF" + e);
        }
    }

    public void pdfTablaComidaPorCalorias(int calorias) {
        try {
            String sql = "SELECT `idComida`, `nombre`, `detalle`, `cantCalorias` FROM `comida` WHERE cantCalorias <= " + calorias + " ORDER BY cantCalorias DESC";
            consultarBaseDatos(sql);
            int contador = 0;
            Document documento = new Document();

            String ruta = System.getProperty("user.home");
            String nombrePDF = "/OneDrive/Escritorio/Tabla_Comidas_Por_Calorias.pdf";

            while (new File(ruta + nombrePDF).exists()) {
                contador++;
                nombrePDF = "/OneDrive/Escritorio/Tabla_Comidas_Por_Calorias(" + contador + ").pdf";
            }
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + nombrePDF));

            Image header = Image.getInstance("src/pdf/nutricion.png");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Clinica Nutricional © \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Tabla Comidas Por Calorias \n\n");

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(4);
            tabla.addCell("CODIGO");
            tabla.addCell("NOMBRE");
            tabla.addCell("DETALLE");
            tabla.addCell("CALORIAS");
            if (resultado.next()) {
                do {
                    tabla.addCell(resultado.getString(1));
                    tabla.addCell(resultado.getString(2));
                    tabla.addCell(resultado.getString(3));
                    tabla.addCell(resultado.getString(4));
                } while (resultado.next());
                documento.add(tabla);
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Se genero con exito el reporte Tabla Comidas por cantidad de calorias");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al crear el PDF" + e);
        }

    }
}
