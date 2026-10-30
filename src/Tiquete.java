/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author andre
 */
public class Tiquete {

    private String nom;
    private String id;
    private int edad;
    private String horaCreacion;
    private String horaAtencion;
    private String tramite;
    private String tipo;

    public Tiquete(String nom, String id, int edad, String tramite, String tipo) {
        this.nom = nom;
        this.id = id;
        this.edad = edad;
        this.tramite = tramite;
        this.tipo = tipo;
        this.horaCreacion = java.time.LocalTime.now().toString().substring(0, 8);
        this.horaAtencion = "-1";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getHoraCreacion() {
        return horaCreacion;
    }

    public void setHoraCreacion(String horaCreacion) {
        this.horaCreacion = horaCreacion;
    }

    public String getHoraAtencion() {
        return horaAtencion;
    }

    public void setHoraAtencion(String horaAtencion) {
        this.horaAtencion = horaAtencion;
    }

    public String getTramite() {
        return tramite;
    }

    public void setTramite(String tramite) {
        this.tramite = tramite;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Tiquete{" + "nom=" + nom + ", id=" + id + ", edad=" + edad + ", horaCreacion=" + horaCreacion + ", horaAtencion=" + horaAtencion + ", tramite=" + tramite + ", tipo=" + tipo + '}';
    }

}
