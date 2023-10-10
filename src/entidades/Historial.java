/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.time.LocalDate;

/**
 *
 * @author criss
 */
public class Historial {

    private int IDHistorial;
    private Paciente idPaciente;
    private double peso;
    private LocalDate fechaRegistro;

    public Historial() {
    }

    public Historial(Paciente idPaciente, double peso, LocalDate fechaRegistro) {
        this.idPaciente = idPaciente;
        this.peso = peso;
        this.fechaRegistro = fechaRegistro;
    }

    public Historial(int IDHistorial, Paciente idPaciente, double peso, LocalDate fechaRegistro) {
        this.IDHistorial = IDHistorial;
        this.idPaciente = idPaciente;
        this.peso = peso;
        this.fechaRegistro = fechaRegistro;
    }

    public int getIDHistorial() {
        return IDHistorial;
    }

    public void setIDHistorial(int IDHistorial) {
        this.IDHistorial = IDHistorial;
    }

    public Paciente getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Paciente idPaciente) {
        this.idPaciente = idPaciente;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "Historial{" + "IDHistorial=" + IDHistorial + ", idPaciente=" + idPaciente + ", peso=" + peso + ", fechaRegistro=" + fechaRegistro + '}';
    }

}
