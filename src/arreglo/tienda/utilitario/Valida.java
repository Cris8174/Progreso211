package arreglo.tienda.utilitario;

import java.util.Scanner;

public class Valida {
    private static Scanner sc = new Scanner(System.in);

    public static String leerString(String mensaje){
        String valor;
        do {
            System.out.print(mensaje+": ");
            valor=sc.nextLine();
            if(valor==null || valor.trim().isEmpty())
                System.out.println("El dato no puede ser nulo ni estar vacio");
        }while(valor==null || valor.trim().isEmpty());
        return valor;
    }

    // Leer un número entero
    public static int leerEntero(String mensaje) {
        int valor = 0;
        boolean error;
        do {
            error = false;
            try {
                System.out.print(mensaje + ": ");
                valor = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número entero válido.");
                error = true;
            }
        } while (error);
        return valor;
    }

    // Leer un número  double
    public static double leerFlotante(String mensaje) {
        double valor = 0;
        boolean error;
        do {
            error = false;
            try {
                System.out.print(mensaje + ": ");
                valor = Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido.");
                error = true;
            }
        } while (error);
        return valor;
    }

    // Leer un número positivo (entero)
    public static int leerNumeroPositivo(String mensaje) {
        int valor;
        do {
            valor = leerEntero(mensaje);
            if (valor <= 0) {
                System.out.println("Error: El número debe ser mayor a 0.");
            }
        } while (valor <= 0);
        return valor;
    }

    // Leer un número positivo (decimales)
    public static double leerNumeroPositivoDouble(String mensaje) {
        double valor;
        do {
            valor = leerFlotante(mensaje);
            if (valor <= 0) {
                System.out.println("Error: El valor debe ser mayor a 0.");
            }
        } while (valor <= 0);
        return valor;
    }

    // Leer un número mayor que
    public static int leerNumeroMayorQue(String mensaje, int minimo) {
        int valor;
        do {
            valor = leerEntero(mensaje);
            if (valor <= minimo) {
                System.out.println("Error: El número debe ser mayor que " + minimo + ".");
            }
        } while (valor <= minimo);
        return valor;
    }

    // Leer un número menor que
    public static int leerNumeroMenorQue(String mensaje, int maximo) {
        int valor;
        do {
            valor = leerEntero(mensaje);
            if (valor >= maximo) {
                System.out.println("Error: El número debe ser menor que " + maximo + ".");
            }
        } while (valor >= maximo);
        return valor;
    }
}
