/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class Configuracion {

    private String nomBanco;
    private int cantCajas;

    public Configuracion() {
        this.nomBanco = "";
        this.cantCajas = 0;
    }

    public String getNomBanco() {
        return nomBanco;
    }

    public void setNomBanco(String nomBanco) {
        this.nomBanco = nomBanco;
    }

    public int getCantCajas() {
        return cantCajas;
    }

    public void setCantCajas(int cantCajas) {
        this.cantCajas = cantCajas;
    }

    //existe
    public boolean existe(){
        File f=new File("prod.txt");
        return f.exists();
    }

    //Modulo 0: pedir los datos la primera vez
    public void configurar(){
        nomBanco=JOptionPane.showInputDialog("Ingrese el nombre del banco");
        do{
            cantCajas=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de cajas (minimo 3)"));
            if(cantCajas<3){
                JOptionPane.showMessageDialog(null, "Error: deben ser minimo 3 cajas");
            }
        }while(cantCajas<3);
        guardar();
    }

    //guardar en prod.txt
    public void guardar() {
        try {
            FileWriter fw = new FileWriter("prod.txt");
            fw.write("Banco:" + nomBanco + "\n");
            fw.write("Cajas:" + cantCajas + "\n");
            fw.write("Caja 1:P\n");
            fw.write("Caja 2:A\n");
            for (int i = 3; i <= cantCajas; i++) {
                fw.write("Caja " + i + ":B\n");
            }
            fw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar prod.txt");
        }
    }

    //cargar de prod.txt
    public void cargar() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("prod.txt"));
            String linea = br.readLine();
            nomBanco = linea.substring(linea.indexOf(":") + 1);
            linea = br.readLine();
            cantCajas = Integer.parseInt(linea.substring(linea.indexOf(":") + 1));
            br.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al leer prod.txt");
        }
    }

    @Override
    public String toString() {
        return "Configuracion{" + "nomBanco=" + nomBanco + ", cantCajas=" + cantCajas + '}';
    }

}
