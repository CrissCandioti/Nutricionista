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

    public DietaComida() {
    }

    public DietaComida(int idDietaComida, Comida idComida, Dieta idDieta) {
        this.idDietaComida = idDietaComida;
        this.idComida = idComida;
        this.idDieta = idDieta;
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

    @Override
    public String toString() {
        return "DietaComida{" + "idDietaComida=" + idDietaComida + ", idComida=" + idComida + ", idDieta=" + idDieta + '}';
    }

}
