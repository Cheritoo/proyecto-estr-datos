/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author andre
 */
public class Caja {

    private int num;
    private String tipo;
    private Cola cola;

    public Caja(int num, String tipo) {
        this.num = num;
        this.tipo = tipo;
        this.cola = new Cola();
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Cola getCola() {
        return cola;
    }

    public void setCola(Cola cola) {
        this.cola = cola;
    }

    @Override
    public String toString() {
        return "Caja " + num + " (" + tipo + ")\n" + cola;
    }

}
