/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class Main {

    static String[] usuarios = {"admin", "cajero"};
    static String[] claves = {"1234", "5678"};
    static Caja[] cajas;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String res;

        //Login
        login();

        //Modulo 0: Configuracion
        Configuracion conf= new Configuracion();
        if(conf.existe()){
            conf.cargar();
            JOptionPane.showMessageDialog(null, "Configuracion cargada\nBanco: "+conf.getNomBanco()+"\nCajas: "+conf.getCantCajas());
        }else{
            JOptionPane.showMessageDialog(null, "Primera ejecucion: configure el sistema");
            conf.configurar();
            JOptionPane.showMessageDialog(null, "Configuracion guardada en prod.txt");
        }
        crearCajas(conf.getCantCajas());

        //Menu
        do{
            res=JOptionPane.showInputDialog("^^^^^^^^ "+conf.getNomBanco()+" ^^^^^^^^\n"
                    + "1)Crear tiquete\n"
                    + "2)Tiquete atendido\n"
                    + "3)Ver colas\n"
                    + "4)Reportes\n"
                    + "5)Tipo de cambio del dolar\n"
                    + "0)Salir\n\nIngrese una opcion (0-5)");
            switch(res){
                case "1":
                    crearTiquete();
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "En construccion");
                    break;
                case "3":
                    verColas();
                    break;
                case "4":
                    JOptionPane.showMessageDialog(null, "En construccion");
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null, "En construccion");
                    break;
                case "0":
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error: opcion no valida");
            }
        }while(!res.equals("0"));
    }

    //login
    public static void login(){
        String usu, cla;
        boolean entro=false;
        do{
            usu=JOptionPane.showInputDialog("^^^^^^^^ LOGIN ^^^^^^^^\nUsuario:");
            cla=JOptionPane.showInputDialog("^^^^^^^^ LOGIN ^^^^^^^^\nClave:");
            for (int i = 0; i < usuarios.length; i++) {
                if (usuarios[i].equals(usu) && claves[i].equals(cla)) {
                    entro = true;
                }
            }
            if(!entro){
                JOptionPane.showMessageDialog(null, "Usuario o clave incorrectos");
            }
        }while(!entro);
        JOptionPane.showMessageDialog(null, "Bienvenido "+usu);
    }

    //crear cajas: 1 preferencial, 1 rapida y las demas B
    public static void crearCajas(int cant){
        cajas=new Caja[cant];
        cajas[0]=new Caja(1,"P");
        cajas[1]=new Caja(2,"A");
        for (int i = 2; i < cajas.length; i++) {
            cajas[i] = new Caja(i + 1, "B");
        }
    }

    //crear tiquete
    public static void crearTiquete(){
        String nom, id, tramite, tipo, op;
        int edad, pos, delante;
        nom=JOptionPane.showInputDialog("Nombre del cliente:");
        id=JOptionPane.showInputDialog("ID del cliente:");
        edad=Integer.parseInt(JOptionPane.showInputDialog("Edad del cliente:"));

        tramite="";
        do{
            op=JOptionPane.showInputDialog("Tramite:\n1)Depositos\n2)Retiros\n3)Cambio de divisas");
            switch(op){
                case "1":
                    tramite="Depositos";
                    break;
                case "2":
                    tramite="Retiros";
                    break;
                case "3":
                    tramite="Cambio de divisas";
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error: opcion no valida");
            }
        }while(tramite.equals(""));

        do{
            tipo=JOptionPane.showInputDialog("Tipo:\nP)Preferencial\nA)Un solo tramite\nB)Dos o mas tramites").toUpperCase();
            if(!tipo.equals("P") && !tipo.equals("A") && !tipo.equals("B")){
                JOptionPane.showMessageDialog(null, "Error: tipo no valido");
            }
        }while(!tipo.equals("P") && !tipo.equals("A") && !tipo.equals("B"));

        Tiquete t= new Tiquete(nom, id, edad, tramite, tipo);

        //asignar caja
        if(tipo.equals("P")){
            pos=0;
        }else if(tipo.equals("A")){
            pos=1;
        }else{
            pos=cajaMenosGente();
        }
        delante=cajas[pos].getCola().cantidad();
        cajas[pos].getCola().agregar(t);

        if(delante==0){
            JOptionPane.showMessageDialog(null, "Tiquete creado\nCaja: "+cajas[pos].getNum()+"\nYa es su turno de atencion");
        }else{
            JOptionPane.showMessageDialog(null, "Tiquete creado\nCaja: "+cajas[pos].getNum()+"\nPersonas delante: "+delante);
        }
    }

    //caja B con menos gente
    public static int cajaMenosGente() {
        int pos = 2;
        for (int i = 3; i < cajas.length; i++) {
            if (cajas[i].getCola().cantidad() < cajas[pos].getCola().cantidad()) {
                pos = i;
            }
        }
        return pos;
    }

    //ver colas
    public static void verColas() {
        String r = "";
        for (int i = 0; i < cajas.length; i++) {
            r += cajas[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, r);
    }

}
