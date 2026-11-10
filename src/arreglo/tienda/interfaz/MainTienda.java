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
            opc = Integer.parseInt(sc.nextLine());
            switch (opc) {
                case 1: {
                    ingresarJuegos();
                }
                break;
                case 2: {
                    mostrarJuegos();}
                break;
                case 3: {
                }
                break;
                case 4: {
                }
                break;
                case 5: {
                }
                break;
                case 6: {
                }
                break;
                case 7: {
                    System.out.println("Gracias por usar nuestro servicio");
                }
                break;
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
            System.out.println("**********Ingrese la categoria******");
            String categoria = Valida.leerString("**********Ingrese la categoria*********");
            System.out.println("**********Ingrese el tamano*********");
            int tamano = Integer.parseInt(sc.nextLine());
            System.out.println("**********Ingrese el Precio*********");
            double precio = Double.parseDouble(sc.nextLine());
            System.out.println("**********Ingrese el stock inicial**");
            int licenciasDisponibles = Integer.parseInt(sc.nextLine());
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
}