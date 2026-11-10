package arreglo.tienda.modelo;

public class AppStore {
    private static final int MAX = 4;
    private Juego juegos[];
    private  int indice;

    public AppStore() {
        juegos = new Juego[MAX];
        indice = -1;
    }

    public Juego[] getJuegos(){
        return juegos;
    }

    public int getIndice() {
        return indice;
    }

    /*
    No es necesario el set porque el ingreso de ser por cada elemento
    public void setJuegos(Juego juegos[]){
        this.juegos = juegos;
    }
     */

    public boolean agregarJuego(Juego j) {
        if (j != null && indice < MAX -1) {
            juegos[++indice] = j;
            return true;
        }
        return false;
    }
    public Juego buscarJuego(String nombre) {
        for (int i = 0; i <= indice; i++) {
            if (juegos[i].getNombre().equalsIgnoreCase(nombre)) {
                return juegos[i];
            }
        }
        return null;
    }

    //que es lo que tengo que darle para q funciones
    public boolean comprar(String nombre, int cantidad) {
        if(nombre != null && !nombre.trim().isEmpty() && cantidad > 0) {
            Juego j = buscarJuego(nombre);
            if (j != null) {
                return j.comprar(cantidad);
            }
        }
        return false;
    }

    public double vender (String nombre, int cantidad) {
        //no se valida xq las funciones que se llaman ya validan los datos
        Juego j = buscarJuego(nombre);
        if (j != null) {
            if(j.vender(cantidad)) {
                return j.getPrecio() * cantidad;
            } else {
                return 0;
            }
        }
        return 0;
    }

    public String masVendido(){
        String nombre = "";
        int mayor = 0;
        if (indice >= 0){
            nombre = juegos[0].getNombre();
            mayor = juegos[0].getLicenciasVendidas();
        }
        for(Juego j : juegos){
            if (j != null) {
                if (j.getLicenciasVendidas() > mayor) {
                    nombre = j.getNombre();
                    mayor = j.getLicenciasVendidas();
                }
            } else {
                return  nombre;
            }
        }
        return nombre;
    }

    public void cargarDatos(){
        //invoca a agregarJuegos como void xq no le voy a dar un mensaje al usuario
        agregarJuego(new Juego("Minecraft", "Sandobox", 14, 35, 50));
        agregarJuego(new Juego("Roblox", "PLatformer", 2, 90, 20));
    }
}

