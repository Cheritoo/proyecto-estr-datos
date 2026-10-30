/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class Cola {

    private Nodo prim, ult;

    public boolean esVacia(){return prim==null;}

    //Encolar
    public void agregar(Tiquete t){
        Nodo nuevo=new Nodo(t);
        if(esVacia()){
            prim=ult=nuevo;
        }else{
            ult.setSig(nuevo);
            ult=nuevo;
        }
    }

    public void desencolar(){
        if(!esVacia()){
            prim=prim.getSig();
            if(prim==null){
                ult=null;
            }
        }else{
            JOptionPane.showMessageDialog(null, "La cola es vacia");
        }
    }

    //cantidad
    public int cantidad() {
        int cant = 0;
        Nodo aux = prim;
        while (aux != null) {
            cant += 1;
            aux = aux.getSig();
        }
        return cant;
    }

    //toString
    @Override
    public String toString() {
        String r = "Cola:\n";
        Nodo aux = prim;
        while (aux != null) {
            r += aux + "\n";
            aux = aux.getSig();
        }
        return r;
    }

}
