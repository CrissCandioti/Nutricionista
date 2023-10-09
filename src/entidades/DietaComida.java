/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author criss
 */
public class DietaComida {

    private int idDietaComida;
    private Comida idComida;
    private Dieta idDieta;
    private Horario horario;

    public DietaComida() {
    }

    public DietaComida(Comida idComida, Dieta idDieta, Horario horario) {
        this.idComida = idComida;
        this.idDieta = idDieta;
        this.horario = horario;
    }

    public DietaComida(int idDietaComida, Comida idComida, Dieta idDieta, Horario horario) {
        this.idDietaComida = idDietaComida;
        this.idComida = idComida;
        this.idDieta = idDieta;
        this.horario = horario;
    }

    public int getIdDietaComida() {
        return idDietaComida;
    }

    public void setIdDietaComida(int idDietaComida) {
        this.idDietaComida = idDietaComida;
    }

    public Comida getIdComida() {
        return idComida;
    }

    public void setIdComida(Comida idComida) {
        this.idComida = idComida;
    }

    public Dieta getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(Dieta idDieta) {
        this.idDieta = idDieta;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "DietaComida{" + "idDietaComida=" + idDietaComida + ", idComida=" + idComida + ", idDieta=" + idDieta + ", horario=" + horario + '}';
    }

}
