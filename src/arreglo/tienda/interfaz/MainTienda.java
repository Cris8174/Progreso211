package arreglo.tienda.interfaz;

import arreglo.tienda.modelo.AppStore;
import arreglo.tienda.modelo.Juego;
import arreglo.tienda.utilitario.Valida;

import javax.swing.*;
import java.util.Scanner;

public class MainTienda {
    private static Scanner sc = new Scanner(System.in);
    private static AppStore tienda = new AppStore();

    static void main() {
        int opc;
        tienda.cargarDatos();
        do {
            menu();
            opc = Valida.leerEntero("Seleccionar Opcion");
            switch (opc) {
                case 1: {
                    ingresarJuegos();
                }
                break;
                case 2: {
                    mostrarJuegos();}
                break;
                case 3:{
                    buscarJuego();
                }break;
                case 4:{
                    comprar();
                }break;
                case 5:{
                    vender();
                }break;
                case 6:{
                    masVendido();
                }break;
                case 7: {
                    System.out.println("Gracias por usar nuestro servicio");
                }
                break;
                default: {
                    System.out.println("Opción inválida.");
                }
            }
        } while (opc != 7);
    }


    public static void menu() {
        System.out.println("**********Appstore UDLA*********");
        System.out.println("1. Ingresar Juego");
        System.out.println("2. Mostar Juegos");
        System.out.println("3. Buscar Juego");
        System.out.println("4. Comprar");
        System.out.println("5. Vender");
        System.out.println("6. Juego mas vendido");
        System.out.println("7. Salir");
        System.out.println("Seleccionar Opcion: ");
    }

    public static void ingresarJuegos() {
        System.out.println("**********Ingreso de datos**********");
        String nombre = Valida.leerString("**********Ingrese el nombre*********");
        String categoria = Valida.leerString("**********Ingrese la categoria*********");
        int tamano = Valida.leerNumeroPositivo("Ingrese el tamano");
        double precio = Valida.leerNumeroPositivoDouble("Ingrese el Precio");
        int licenciasDisponibles = Valida.leerNumeroPositivo("Ingrese el stock inicial");
        if (tienda.agregarJuego(new Juego(nombre, categoria, tamano, precio, licenciasDisponibles))){
            JOptionPane.showMessageDialog(null, "Juego agregado correctamente");
        }else{
            JOptionPane.showMessageDialog(null, "El juego no pudo ser agregado");
        }
    }

    public static void mostrarJuegos(){
        Juego juegos[]=tienda.getJuegos();
        if(tienda.getIndice()>=0){
            for(int i=0;i<= tienda.getIndice();i++){
                System.out.println(juegos[i]);
            }
        }else{
            System.out.println("No hay juegos dentro de la Appstore");
        }
    }

    public static void buscarJuego() {
        System.out.println("********** Buscar Juego **********");
        String nombre = Valida.leerString("Ingrese el nombre del juego a buscar");
        Juego j = tienda.buscarJuego(nombre);
        if (j != null) {
            System.out.println("Juego encontrado: " + j);
        } else {
            System.out.println("El juego no se encuentra registrado.");
        }
    }

    public static void comprar() {
        System.out.println("********** Comprar Licencias (Stock) **********");
        String nombre = Valida.leerString("Ingrese el nombre del juego");
        int cantidad = Valida.leerNumeroPositivo("Ingrese la cantidad a comprar");
        if (tienda.comprar(nombre, cantidad)) {
            System.out.println("Stock actualizado correctamente.");
        } else {
            System.out.println("No se pudo realizar la compra (juego no encontrado).");
        }
    }

    public static void vender() {
        System.out.println("********** Vender Juego **********");
        String nombre = Valida.leerString("Ingrese el nombre del juego");
        int cantidad = Valida.leerNumeroPositivo("Ingrese la cantidad a vender");
        double total = tienda.vender(nombre, cantidad);
        if (total > 0) {
            System.out.println("Venta exitosa. Total a pagar: $" + total);
        } else {
            System.out.println("No se pudo realizar la venta (Stock insuficiente o juego no encontrado).");
        }
    }

    public static void masVendido() {
        System.out.println("********** Juego Más Vendido **********");
        String masVendido = tienda.masVendido();
        if (masVendido != null && !masVendido.isEmpty()) {
            System.out.println("El juego más vendido es: " + masVendido);
        } else {
            System.out.println("No hay registros suficientes de ventas.");
        }
    }
}