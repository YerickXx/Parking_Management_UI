package Logic;

import Data.Data;
import java.time.LocalDateTime;
import java.time.Duration;

public class Logic_Salida implements Interfaces.Manejo_Salida { // implementacion de interfaz de salida

    Data d = new Data();
    
    public  double Tiempoparqueo;
    public String entrada = "";
    public String Salida = "";
    public String TipoServicio = "";
    public String pagoTarifa = "";

    // Constantes, se utilizan mayusculas por regla general de constantes
    final int CANTIDAD_HORAS = 8;
    final double DESC = 0.10;

    private boolean verificacionSalida(String p) {
        d.LeerVehiculo();
        TomarDatos();
        for (int i = 0; i < d.leidos.size(); i++) {
            String lineaActual = d.leidos.get(i).toString();

            if (lineaActual.contains(p)) {
                return true;
            }
        }

        System.out.println("Vehículo no encontrado o ya procesado.");
        return false;
    }
    
    @Override
    public boolean VerificacionServicio()
    {
         for (int i = 0; i < d.leidos.size(); i++) {
            String lineaActual = d.leidos.get(i).toString();

            if (lineaActual.contains(",Por hora,")) {
                this.TipoServicio = "Por hora";
                return true;
            }
        }
         this.TipoServicio = "Por Dia";
         return false;
    }

    @Override
    public boolean Existencia_Actualizacion(String p) {
        verificacionSalida(p);
        return true;
    }

    @Override
    public boolean AplicarDescuento() {
        return CalculosFactura();
        
    }

    private boolean CalculosFactura() {
        if(VerificacionServicio()){
        for (int i = 0; i < d.leidos.size(); i++) {
            String lineaActual = d.leidos.get(i).toString();
                // Descuento
                String lineaActualizada = lineaActual.replace(",null,", "," + Salida+ ",");

                if (Tiempoparqueo >= CANTIDAD_HORAS) {
                    System.out.println("Aplica descuento de 10% por " + Tiempoparqueo + " horas.");
                }
                //Actualizacion lista
                d.leidos.set(i, lineaActualizada);
                System.out.println("Línea actualizada: " + lineaActualizada);

                return true;
            
        }}
        return false;
    }

    public boolean BorrarVehiculo(String p) {
        for (int i = d.leidos.size() - 1; i >= 0; i--) {
            String lineaActual = d.leidos.get(i);
            if (lineaActual.contains(p)) {
                d.leidos.remove(i);
            }
        }
        d.actualizarArchivo(d.leidos);
        return true;
    }
    
    @Override
    public boolean TomarDatos()
    {
        for (int i = 0; i < d.leidos.size(); i++){
            String lineaActual = d.leidos.get(i).toString();
            
            if (lineaActual.contains(",null,")){
            LocalDateTime ahora = LocalDateTime.now().withNano(0).withSecond(0);
                this.Salida = ahora.toString();

                // Extraccion de datos para calcular
                String[] datos = lineaActual.split(",");

                //tomar el tercer elemento iterando de atras hacia adelante
                String strEntrada = datos[datos.length - 3].trim();
                LocalDateTime horaEntrada = LocalDateTime.parse(strEntrada);
                this.entrada = horaEntrada.toString();
                
                //tomar el primer elemento de atras hacia adelante
                String pago = datos[datos.length - 1].trim();
                this.pagoTarifa = pago;

                //Duracion
                Duration duracion = Duration.between(horaEntrada, ahora);
                double horasTotales = duracion.toHours();
                this.Tiempoparqueo = horasTotales;
                return true;
               
            } 
        }
        return false;
    }

}
