/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf;

import accesoDatos.DAO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author criss
 */
public final class pdfDieta extends DAO {

    public void pdfTablaPacientesDietaVigente(LocalDate fecha) {
        try {
            String sql = "SELECT paciente.apellido, paciente.nombre, dieta.fechaInicial, dieta.pesoInicial, dieta.pesoFinal,dieta.fechaFinal FROM `dieta` JOIN paciente ON dieta.idPaciente = paciente.idPaciente WHERE `fechaFinal` > '" + fecha + "'";
            consultarBaseDatos(sql);

            int contador = 0;
            Document documento = new Document();

            String ruta = System.getProperty("user.home");
            String nombrePDF = "/OneDrive/Escritorio/Pacientes_Dieta_Vigente.pdf";

            while (new File(ruta + nombrePDF).exists()) {
                contador++;
                nombrePDF = "/OneDrive/Escritorio/Pacientes_Dieta_Vigente(" + contador + ").pdf";
            }
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + nombrePDF));

            Image header = Image.getInstance("src/pdf/nutricion.png");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Clinica Nutricional © \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Pacientes Dieta Vigente \n\n");

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(6);
            tabla.addCell("Apellido");
            tabla.addCell("Nombre");
            tabla.addCell("Fecha Inicial");
            tabla.addCell("Peso Inicial");
            tabla.addCell("Peso Final");
            tabla.addCell("Fecha Final");
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
            JOptionPane.showMessageDialog(null, "Se genero con exito el Reporte Pacientes Dieta Vigente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al crear el reporte PDF " + e);
        }
    }

    public void pdfTablaPacientesDietaTerminada(LocalDate fecha) {
        try {
            String sql = "SELECT dieta.nombre, paciente.apellido, paciente.nombre, dieta.fechaInicial, dieta.pesoInicial, dieta.pesoFinal, dieta.fechaFinal FROM dieta JOIN paciente ON dieta.idPaciente = paciente.idPaciente WHERE dieta.fechaFinal <= '" + fecha + "'";
            consultarBaseDatos(sql);

            int contador = 0;
            Document documento = new Document();

            String ruta = System.getProperty("user.home");
            String nombrePDF = "/OneDrive/Escritorio/Pacientes_Dieta_Terminada.pdf";

            while (new File(ruta + nombrePDF).exists()) {
                contador++;
                nombrePDF = "/OneDrive/Escritorio/Pacientes_Dieta_Terminada(" + contador + ").pdf";
            }
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + nombrePDF));

            Image header = Image.getInstance("src/pdf/nutricion.png");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Clinica Nutricional © \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Pacientes Dieta Terminada \n\n");

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(7);
            tabla.addCell("Dieta");
            tabla.addCell("Apellido Paciente");
            tabla.addCell("Nombre Paciente");
            tabla.addCell("Fecha Inicial");
            tabla.addCell("Peso Inicial");
            tabla.addCell("Peso Final");
            tabla.addCell("Fecha Final");
            if (resultado.next()) {
                do {
                    tabla.addCell(resultado.getString(1));
                    tabla.addCell(resultado.getString(2));
                    tabla.addCell(resultado.getString(3));
                    tabla.addCell(resultado.getString(4));
                    tabla.addCell(resultado.getString(5));
                    tabla.addCell(resultado.getString(6));
                    tabla.addCell(resultado.getString(7));
                } while (resultado.next());
                documento.add(tabla);
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Se genero con exito el Reporte Pacientes Dieta Terminada");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al crear el reporte PDF " + e);
        }
    }

    public void pdfPacientesQueNoLlegaronAlPeso() {
        try {
            String sql = "SELECT dieta.nombre,paciente.apellido,paciente.nombre,dieta.fechaInicial,dieta.pesoInicial,historial.peso,dieta.pesoFinal,dieta.fechaFinal "
                    + "FROM dieta INNER JOIN paciente ON dieta.idPaciente = paciente.idPaciente INNER JOIN historial ON dieta.idPaciente = historial.idPaciente "
                    + "WHERE dieta.pesoFinal < (SELECT historial.peso FROM historial WHERE historial.idPaciente = dieta.idPaciente "
                    + "ORDER BY historial.fechaRegistro DESC LIMIT 1) "
                    + "AND dieta.fechaFinal <= CURRENT_DATE";
            consultarBaseDatos(sql);

            int contador = 0;
            Document documento = new Document();

            String ruta = System.getProperty("user.home");
            String nombrePDF = "/OneDrive/Escritorio/Pacientes_Dieta_No_Llegados.pdf";

            while (new File(ruta + nombrePDF).exists()) {
                contador++;
                nombrePDF = "/OneDrive/Escritorio/Pacientes_Dieta_No_Llegados(" + contador + ").pdf";
            }
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + nombrePDF));

            Image header = Image.getInstance("src/pdf/nutricion.png");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Clinica Nutricional © \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Pacientes Dieta No Llegados \n\n");

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(8);
            tabla.addCell("Dieta");
            tabla.addCell("Apellido Paciente");
            tabla.addCell("Nombre Paciente");
            tabla.addCell("Fecha Inicial");
            tabla.addCell("Peso Inicial");
            tabla.addCell("Peso Actual");
            tabla.addCell("Peso Objetivo");
            tabla.addCell("Fecha Final");
            if (resultado.next()) {
                do {
                    tabla.addCell(resultado.getString(1));
                    tabla.addCell(resultado.getString(2));
                    tabla.addCell(resultado.getString(3));
                    tabla.addCell(resultado.getString(4));
                    tabla.addCell(resultado.getString(5));
                    tabla.addCell(resultado.getString(6));
                    tabla.addCell(resultado.getString(7));
                    tabla.addCell(resultado.getString(8));
                } while (resultado.next());
                documento.add(tabla);
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Se genero con exito el Reporte Pacientes Dieta Que No Llegaron Al Peso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al crear el reporte PDF " + e);
        }
    }
}
