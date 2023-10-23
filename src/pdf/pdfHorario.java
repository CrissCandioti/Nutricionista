/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf;

import accesoDatos.DAO;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import entidades.DietaComida;
import entidades.Horario;

import java.io.File;
import service.ComidaService;
import service.DietaService;

/**
 *
 * @author criss
 */
public final class pdfHorario extends DAO {

    public void pdfHorario(Horario index) {
        try {
            String sql = "SELECT `idDietaComida`, `idComida`, `idDieta`, `Horario` FROM `dietacomida` WHERE Horario = '" + index + "'";
            consultarBaseDatos(sql);

            int contador = 0;

            Document documento = new Document();
            String ruta = System.getProperty("user.home");
            String nombrePDF = "/OneDrive/Escritorio/Reporte_Horario.pdf";

            while (new File(ruta + nombrePDF).exists()) {
                contador++;
                nombrePDF = "/OneDrive/Escritorio/Reporte_Horario(" + contador + ").pdf";
            }
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + nombrePDF));

            Image header = Image.getInstance("src/pdf/nutricion.png");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Clinica Nutricional © \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));

            Paragraph texto = new Paragraph();
            texto.setAlignment(Paragraph.ALIGN_LEFT);

            Chunk APELLIDOYNOMBRE = new Chunk("APELLIDO Y NOMBRE:", FontFactory.getFont("Tahoma", 10, Font.BOLD | Font.UNDERLINE, BaseColor.DARK_GRAY));
            Chunk COMIDA = new Chunk("COMIDA:", FontFactory.getFont("Tahoma", 10, Font.BOLD | Font.UNDERLINE, BaseColor.DARK_GRAY));
            Chunk DETALLE = new Chunk("DETALLE:", FontFactory.getFont("Tahoma", 10, Font.BOLD | Font.UNDERLINE, BaseColor.DARK_GRAY));
            Chunk HORARIO = new Chunk("HORARIO:", FontFactory.getFont("Tahoma", 10, Font.BOLD | Font.UNDERLINE, BaseColor.DARK_GRAY));

            while (resultado.next()) {
                ComidaService cs = new ComidaService();
                DietaService ds = new DietaService();

                DietaComida aux = new DietaComida(resultado.getInt(1), cs.buscarComida(resultado.getInt(2)), ds.buscarDietaPorId(resultado.getInt(3)), Horario.valueOf(resultado.getString(4)));

                parrafo.add(aux.getHorario() + " \n\n");

                texto.add(APELLIDOYNOMBRE);
                texto.add(" " + aux.getIdDieta().getIdPaciente().getApellido() + " " + aux.getIdDieta().getIdPaciente().getNombre() + "\n\n"
                );

                texto.add(COMIDA);
                texto.add(" " + aux.getIdComida().getNombre() + "\n\n");

                texto.add(DETALLE);
                texto.add(" " + aux.getIdComida().getDetalle() + "\n\n");

                texto.add(HORARIO);
                texto.add(" " + aux.getHorario() + "\n\n");
            }

            documento.open();
            documento.add(header);
            documento.add(parrafo);
            documento.add(texto);

            documento.close();
            JOptionPane.showMessageDialog(null, "Se generó con éxito el Reporte Horario");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al generar el reporte PDF " + e);
        }
    }
}
