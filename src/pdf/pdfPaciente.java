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
import entidades.Paciente;
import java.io.File;

/**
 *
 * @author criss
 */
public final class pdfPaciente extends DAO {

    public void pdfTablaPacientes() {
        try {
            String sql = "SELECT `idPaciente`, `apellido`, `nombre`, `dni`, `domicilio`, `telefono` FROM `paciente`";
            consultarBaseDatos(sql);
            int contador = 0;
            Document documento = new Document();
            //------------------------------------------------------------------------------------------------------
            String ruta = System.getProperty("user.home"); // Se encarga de obtener la ubicación del directorio de inicio del usuario actual del sistema. 
            String nombrePDF = "/OneDrive/Escritorio/Tabla_Pacientes.pdf"; // Se construye la direccion donde se va a generar y el nombre del PDF.
            /**
             * El bucle while se encarga de comprobar si un PDF con el mismo
             * nombre ya existe. Si existe un PDF con ese nombre, se incrementa
             * el contador y se agrega ese contador al nombre.
             */
            while (new File(ruta + nombrePDF).exists()) {
                contador++;
                nombrePDF = "/OneDrive/Escritorio/Tabla_Pacientes(" + contador + ").pdf";
            }
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + nombrePDF));
            //-------------------------------------------------------------------------------------------------------
            Image header = Image.getInstance("src/pdf/nutricion.png");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Clinica Nutricional © \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Pacientes Registrados \n\n");

            documento.open();
            documento.add(header);
            documento.add(parrafo);

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
            JOptionPane.showMessageDialog(null, "Se produjo un error al crear el PDF" + e);
        }
    }

    public void pdfPorPaciente(int id) {
        try {
            String sql = "SELECT `idPaciente`, `apellido`, `nombre`, `dni`, `domicilio`, `telefono` FROM `paciente` WHERE idPaciente = " + id;
            consultarBaseDatos(sql);

            int contador = 0;

            Document documento = new Document();
            String ruta = System.getProperty("user.home");
            String nombrePDF = "/OneDrive/Escritorio/Reporte_Pacientes.pdf";

            while (new File(ruta + nombrePDF).exists()) {
                contador++;
                nombrePDF = "/OneDrive/Escritorio/Tabla_Pacientes(" + contador + ").pdf";
            }
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + nombrePDF));

            Image header = Image.getInstance("src/pdf/nutricion.png");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Clinica Nutricional © \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Pacientes Registrados \n\n");

            Paragraph texto = new Paragraph();
            texto.setAlignment(Paragraph.ALIGN_LEFT);

            while (resultado.next()) {
                Paciente aux = new Paciente(resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getInt(4), resultado.getString(5), resultado.getString(6));

                texto.add("ID: " + aux.getIdPaciente() + "\n\n");
                texto.add("APELLIDO: " + aux.getApellido() + "\n\n");
                texto.add("NOMBRE: " + aux.getNombre() + "\n\n");
                texto.add("DOCUMENTO: " + aux.getDni() + "\n\n");
                texto.add("DOMICILIO: " + aux.getDomicilio() + "\n\n");
                texto.add("TELEFONO: " + aux.getTelefono() + "\n\n");
            }

            documento.open();
            documento.add(header);
            documento.add(parrafo);
            documento.add(texto);

            documento.close();
            JOptionPane.showMessageDialog(null, "Se generó con éxito el reporte");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al crear el PDF" + e);
        }
    }
}
