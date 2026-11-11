package arreglo.tienda.modelo;

public class Juego {
    private String nombre;
    private String categoria;
    private int tamano;
    private double precio;
    private int licenciasVendidas;
    private int licenciasDisponibles;

    public Juego(String nombre, String categoria, int tamano, double precio, int licenciasDisponibles) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.tamano = tamano;
        this.precio = precio;
        if (licenciasDisponibles >= 0)
            this.licenciasDisponibles = licenciasDisponibles;
        licenciasVendidas = 0;
    }

    //getter
    public String getCategoria() {
        return categoria;
    }

    public int getTamano() {
        return tamano;
    }

    public double getPrecio() {
        return precio;
    }

    public int getLicenciasVendidas() {
        return licenciasVendidas;
    }

    public int getLicenciasDisponibles() {
        return licenciasDisponibles;
    }

    public String getNombre() {
        return nombre;
    }

    //setter

    public void setNombre(String nombre) {
        if(nombre != null&& !nombre.trim().isEmpty()) //trim quita los blanco al inicio y fianl de la cadena
            this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        if(categoria != null&& !categoria.trim().isEmpty())
            this.categoria = categoria;
    }

    public void setTamano(int tamano) {
        if(tamano > 0)
            this.tamano = tamano;
    }

    public void setPrecio(double precio) {
        if(precio > 0)
            this.precio = precio;
    }

    //metodos

    public boolean comprar(int cantidad) {
        if (cantidad > 0){
            licenciasVendidas += cantidad;
            return true;
        }
        return false;
    }

    public boolean vender(int cantidad) {
        if (cantidad > 0 && cantidad <= licenciasDisponibles){
            licenciasDisponibles -= cantidad;
            licenciasVendidas += cantidad;
            return true;
        }
        return false;
    }



    @Override
    public String toString() {
        return "Juego{" +
                "nombre='" + nombre + '\'' +
                ", catergoria='" + categoria + '\''+
                ", memoria=" + tamano +
                ", precio=" + precio +
                ", licenciasDisponibles=" + licenciasDisponibles +
                ", licenciasVendidas=" + licenciasVendidas +
                "}";
    }
}



