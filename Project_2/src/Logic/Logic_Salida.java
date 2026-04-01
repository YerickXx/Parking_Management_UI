package Logic;

import Data.Data;
import java.time.LocalDateTime;
import java.time.Duration;

public class Logic_Salida implements Interfaces.Manejo_Salida { // implementacion de interfaz de salida
    Data d = new Data();
    
    public Duration Tiempoparqueo;
    public String entrada = "";
    public String Salida = "";
    public String TipoServicio = "";
    public double pagoTarifa = 0.0;
    public double precioFinal = 0.0;
    
    // Constantes, se utilizan mayusculas por regla general de constantes
    final int CANTIDAD_HORAS = 8;
    final double DESC = 0.10;

    private boolean verificacionSalida(String p) {
        d.LeerVehiculo();
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
            }else{this.TipoServicio = "Por dia";return true;}
            
        }
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
                double hours = this.Tiempoparqueo.toHours();
                
                if (hours >= CANTIDAD_HORAS) {
                    double precio = hours*pagoTarifa;
                    double precioDesc = precio * DESC;
                    precioFinal = precio - precioDesc;
                }else{
                    precioFinal = hours*pagoTarifa;
                    return false;
                }
                //Actualizacion lista
                d.leidos.set(i, lineaActualizada);
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
                this.pagoTarifa = Double.parseDouble(pago);

                //Duracion
                Duration duracion = Duration.between(horaEntrada, ahora);
                this.Tiempoparqueo = duracion;
                return true;
               
            } 
        }
        return false;
    }

    
    
}
