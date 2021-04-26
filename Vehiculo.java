import java.util.ArrayList;
import java.util.Scanner;
public class Vehiculo {
    static Vehiculo[][] vehiculos;
    private  static int[][] precios;
    static int tamano;
    private int cantidad;
    private String placa;
    private String marca;
    private String color;
    private int valorComercial;

    public Vehiculo() {
    }

    public Vehiculo(String p, String m, String c) {
        this(p, m, c, 30000000);
    }

    public Vehiculo(String p, String m, String c, int v) {
        this.placa = p;
        this.marca = m;
        this.color = c;
        this.valorComercial = v;
    }

    public static int getTamano() {
        return tamano;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getColor() {
        return color;
    }

    public int getValorComercial() {
        return valorComercial;
    }

    public void setTamano(int t) {
        this.tamano = t;
    }

    public void setCantidad(int c) {
        this.cantidad = c;
    }

    public void setPLaca(String p) {
        this.placa = p;
    }

    public void setMarca(String m) {
        this.marca = m;
    }

    public void setColor(String c) {
        this.color = c;
    }

    public void setValorComercial(int v) {
        this.valorComercial = v;

    }

    public String toString() {
        String t = "Placa del vehiculo:"+this.placa + "  " + " Marca del vehiculo "+ this.marca + " " + "Color del vehiculo " + this.color + " " + "Valor Del vehiculo " +this.valorComercial+ "\n";
        return t;
    }

    public static String toStringVehiculos(){
        String todosLosVehiculos = "";
        int m = 0;
        while(m<vehiculos.length){
            int k = 0;
            while(k<vehiculos[m].length){
                if (vehiculos[m][k] != null) {
                    todosLosVehiculos = todosLosVehiculos + vehiculos[m][k].toString() + "Piso en el que se encuentra el vehiculo :"+ m+"\n"+
                            "Espacio en el que se encuentra el vehiculo :"+k;
                }
                k++;
            }
            m++;
        }
        return todosLosVehiculos;
    }

    public static int cantidadVehiculos() {
        int x = 0;
        for (int m = 0; vehiculos.length > m; m++) {
            for (int k = 0; vehiculos[m].length > k; k++) {

                if (vehiculos[m][k] != null) {
                    x++;
                }
            }
        }
        return x;
    }

    public static String sortearPorColor(){
        Scanner scan = new Scanner(System.in);
        String  colorCompartido = "";
        System.out.println("ingrese color");
        String colorRecibido = scan.next();
        int m = 0;
        while(m<vehiculos.length){
            int k = 0;
            while(k<vehiculos[m].length){
                if(vehiculos[m][k] != null){
                    if (vehiculos[m][k].getColor().equalsIgnoreCase(colorRecibido) ) {
                        colorCompartido = colorCompartido + vehiculos[m][k].toString() + "Piso en el que se encuentra el vehiculo:" + m + "\n" +
                                "Espacio en el que se encuentra el vehiculo:" + k + "\n";
                    }
                }
                k++;
            }
            m++;
        }
        return colorCompartido;
    }

   public  static Vehiculo[] ordenarVehiculos() {
       Vehiculo[] vehiculosOrdenados = new Vehiculo[cantidadVehiculos()];
       int pocisionesOrdenadas = 0;
       int m = 0;
       while (m < vehiculos.length) {
           int k = 0;
           while (k < vehiculos[m].length) {
               if (vehiculos[m][k] != null) {
                   vehiculosOrdenados[pocisionesOrdenadas] = vehiculos[m][k];
                   pocisionesOrdenadas++;
               }
               k++;
           }
           m++;
       }

        int n=0;
        while(n<vehiculosOrdenados.length){
            int k=0;
            while(k< vehiculosOrdenados.length-1){
                if(vehiculosOrdenados[k].valorComercial>vehiculosOrdenados[k+1].valorComercial){
                    Vehiculo aux=vehiculosOrdenados[k];
                    vehiculosOrdenados[k]=vehiculosOrdenados[k+1];
                    vehiculosOrdenados[k+1]=aux;
                }
                k++;
            }
            n++;
        }
        return vehiculosOrdenados;
    }
    public static void mostrarVehiculosOrdenados(){
        Vehiculo[] precioOrdenado = ordenarVehiculos();
        int k=0;
        while(k<precioOrdenado.length){
           System.out.println(precioOrdenado[k].valorComercial);
            k++;
        }
    }
}
