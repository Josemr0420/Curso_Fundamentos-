public class Sensor {
    public static Sensor[][] sensores;

    private int estado;
    public Sensor(){
    }
    public Sensor(int estado){
        this.estado = estado;
    }
    public String toStringSensor(){
        String estadoSensor = "0";
        if(this.estado == 1){
            estadoSensor = "Ocupado";
        }else if(this.estado == 0){
            estadoSensor = "Libre";
        }
        return estadoSensor;
    }
    public static String sensorLibre(){
        String todosLosSensores = "";
        int m = 0;
        while(m<sensores.length){
            int k = 0;
            while(k<sensores[m].length){
                if (sensores[m][k] != null) {
                    if(sensores[m][k].getEstado() == 0) {
                        todosLosSensores = todosLosSensores + sensores[m][k].toStringSensor() + "Piso disponible >" + m + "\n" +
                                "Espacio disponible >" + k;
                    }
                }
                k++;
            }
            m++;
        }
        return todosLosSensores;
    }
    public static String sensoresEstado(){
        String estadoTodosLosSensores = "";
        int m = 0;
        while(m<sensores.length){
            int k = 0;
            while(k<sensores[m].length){
                if (sensores[m][k] != null) {
                    estadoTodosLosSensores = estadoTodosLosSensores + "Piso> "  + m + "" +
                            " Espacio> " + k +" "+ sensores[m][k].toStringSensor() + "\n";
                }
                k++;
            }
            m++;
        }
        return estadoTodosLosSensores;
    }
    public int getEstado(){
        return estado;
    }
    public void setEstado(int estado){
        this.estado = estado;
    }
    public static void OrganizarArray(){
        int m = 0;
        while(m<sensores.length){
            int k = 0;
            while(k<sensores[m].length){
                sensores[m][k] = new Sensor(0);
                k++;
            }
            m++;
        }
    }
}
