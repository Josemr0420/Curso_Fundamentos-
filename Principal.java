import java.util.Scanner;
public class Principal {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Por favor ingrese la cantidad de pisos del edificio");
        int tamanoPisos = scan.nextInt();
        System.out.println("Por favor ingrese la cantidad de espacios por piso del edificio");
        int tamanoEspacios = scan.nextInt();
        Vehiculo.vehiculos = new Vehiculo[tamanoPisos][tamanoEspacios];
        Sensor.sensores = new Sensor[tamanoPisos][tamanoEspacios];
        Sensor.OrganizarArray();
        Vehiculo.tamano = tamanoPisos*tamanoEspacios;
        System.out.println("Cantidad maxima de vehiculos posibles" + Vehiculo.getTamano());
        System.out.println("Que desea hacer." );
        System.out.println("1: Numero de sensores desocupados."+"\n"+"2: Deseas parquear"+"\n"+"3: Deseas parquear (incluye valor comercial)"+"\n"
                +"4: Informacion de los vehiculos parqueados"+"\n"+"5. Historial de vehiculos"+"\n"+"6: Estado de espacio"+"\n"+"7: Estado de todos los sensores."+
                "\n"+"8: Filtro Vehiculo por color"+"\n"+"9: Filtro por valor comercial"+"\n"+"0: Salir");
        int accion = scan.nextInt();
        while(accion != 0){
            switch(accion) {
                case 0:
                    System.out.println("Salir");
                    break;
                case 1:
                    System.out.println(Sensor.sensorLibre());
                    System.out.println("Que desea hacer.");
                    accion = scan.nextInt();
                    break;
                case 2:
                    System.out.println("por favor ingrese piso y espacio que quiere parquear");
                    int piso = scan.nextInt();
                    int espacio = scan.nextInt();
                    if((piso<tamanoPisos) && (espacio<tamanoEspacios)) {
                        if (Sensor.sensores[piso][espacio].getEstado() == 1) {
                            System.out.println("Puesto ocupado");
                        } else if (Sensor.sensores[piso][espacio].getEstado() == 0) {
                            System.out.println("Ingrese la placa, la marca y el color");
                            String placa = scan.next();
                            String marca = scan.next();
                            String color = scan.next();
                            Vehiculo vh = new Vehiculo(placa,marca,color);
                            Vehiculo.vehiculos[piso][espacio] = vh;
                            Sensor.sensores[piso][espacio].setEstado(1);
                        }
                    }else{
                        System.out.println("Error");
                    }
                    System.out.println("Que desea hacer.");
                    accion = scan.nextInt();
                    break;
                case 3:
                    System.out.println("por favor ingrese piso y espacio que quiere parquear");
                    piso = scan.nextInt();
                    espacio = scan.nextInt();
                    if((piso<tamanoPisos) && (espacio<tamanoEspacios)) {
                        if (Sensor.sensores[piso][espacio].getEstado() == 1) {
                            System.out.println("Puesto ocupado");
                        } else if (Sensor.sensores[piso][espacio].getEstado() == 0) {
                            System.out.println("Ingrese la placa, la marca, el color y el valor");
                            String placa = scan.next();
                            String marca = scan.next();
                            String color = scan.next();
                            int precio = scan.nextInt();
                            Vehiculo vh = new Vehiculo(placa,marca,color,precio);
                            Vehiculo.vehiculos[piso][espacio] = vh;
                            Sensor.sensores[piso][espacio].setEstado(1);
                        }
                    }else{
                        System.out.println("Error");
                    }
                    System.out.println("Que desea hacer.");
                    accion = scan.nextInt();
                    break;
                case 4:
                    int m = 0;
                    while(m<Vehiculo.vehiculos.length){
                        int k = 0;
                        while(k<Vehiculo.vehiculos[m].length){
                            if(Vehiculo.vehiculos[m][k] != null){
                                System.out.println(Vehiculo.vehiculos[m][k].toString());
                            }
                            k++;
                        }
                        m++;
                    }
                    System.out.println("Que desea hacer.");
                    accion = scan.nextInt();
                    break;
                case 5:
                    System.out.println(Vehiculo.cantidadVehiculos());
                    System.out.println("Que desea hacer.");
                    accion = scan.nextInt();
                    break;
                case 6:
                    System.out.println("por favor ingrese piso y espacio que quiere parquear");
                    piso = scan.nextInt();
                    espacio = scan.nextInt();
                    if((piso<tamanoPisos) && (espacio<tamanoEspacios)) {
                        if (Sensor.sensores[piso][espacio].getEstado() == 1) {
                            System.out.println("Puesto ocupado");
                        } else if (Sensor.sensores[piso][espacio].getEstado() == 0) {
                            System.out.println("Puesto desocupado");
                        }
                    }
                    System.out.println("Que desea hacer.");
                    accion = scan.nextInt();
                    break;
                case 7:
                    System.out.println(Sensor.sensoresEstado());
                    System.out.println("Que desea hacer.");
                    accion = scan.nextInt();
                    break;
                case 8:
                    System.out.println(Vehiculo.sortearPorColor());
                    System.out.println("Que desea hacer.");
                    accion = scan.nextInt();
                    break;
                case 9:
                    Vehiculo.mostrarVehiculosOrdenados();
                    accion = scan.nextInt();
                    break;

            }
        }

    }
}