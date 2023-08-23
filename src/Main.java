public class Main {
    public static void main(String[] args) {

        String[][] vinilos = new String[100][3];

        agregarVinilos(vinilos, "Pink Floyd", "The Wall", "1979");
        agregarVinilos(vinilos, "Pink Floyd", "The Dark Side of the Moon", "1973");
        agregarVinilos(vinilos, "Daft Punk", "Random Access Memories", "2013");
        agregarVinilos(vinilos, "The Strokes", "The New Abnormal", "323");

        System.out.println("-------------------------");
        System.out.println("Espacio máximo colección: "+vinilos.length);

        mostrarTotal(vinilos);
        mostrarDisponibles(vinilos);

        String artista = "Pink Floyd";
        mostrarBusquedaArtista(vinilos,artista);

        mostrarColeccion(vinilos);
    }



    public static String[][] agregarVinilos(String[][] vinilos, String gru, String lp, String agno) {
        String[] datos = {gru, lp, agno};
        int filaVacia = filaVacia(vinilos);
        if (filaVacia != -1){
            for (int i = 0; i < 3; i++) {
                vinilos[filaVacia][i]=datos[i];
            }
        } else {
            System.out.println("La colección está llena");
        }

        return vinilos;
    }


    public static int filaVacia(String[][] vinilos){
        for (int i = 0; i <vinilos.length ; i++) {
            for (int j = 0; j <vinilos[i].length ; j++) {
                if (vinilos[i][j] == null){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void mostrarColeccion(String m[][]){
        for (int i = 0; i <m.length ; i++) {
            if(m[i][0] != null) {
                System.out.print("Fila " + (i + 1) + (": "));
                for (int j = 0; j < m[i].length; j++) {
                    System.out.print(m[i][j] + " - ");
                }
                System.out.println();
            }
        }
    }
    public static int totalVinilos(String m[][]){
        int contador = 0;
        for (int i = 0; i < m.length; i++) {
            if (m[i][0] != null){
                contador++;
            }
        }return contador;

    }
    public static void mostrarTotal(String m[][]){
        int total = totalVinilos(m);
        System.out.println("Hay un total de: " + total + " vinilos en la colección");
        System.out.println("");
    }

    public static int disponibles(String m[][]){
        int contador = 0;
        for (int i = 0; i < m.length; i++) {
            if (m[i][0] == null){
                contador++;
            }
        }
        return contador;
    }
    public static void mostrarDisponibles(String m[][]){
        int disponibles = disponibles(m);
        System.out.println("Hay un total de: "+disponibles+" espacios disponibles en la colección");
        System.out.println();
    }

    public static boolean buscarArtista(String m[][], String artista){
        for (int i = 0; i <m.length; i++) {
            if (artista.equalsIgnoreCase(m[i][0])){
                return true;
            }
        }
        return false;
    }
    public static void mostrarBusquedaArtista(String m[][], String artista){
        System.out.println("Buscar artista: "+artista);
        boolean encontrar = buscarArtista(m,artista);
        if (encontrar==true){
            System.out.println("El artista "+artista+" si está en la colección");
        }else {
            System.out.println("El artista "+artista+" no se encuentra en la colección");
        }
        System.out.println();
    }

}