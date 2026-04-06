/*Clase encargada de manejar la salida de los vehiculos del parqueo*/

package Logic;

// importacion de clases y librerias necesarias
import Data.Data;
import java.time.LocalDateTime;
import java.time.Duration;
import java.util.ArrayList;
import Data.DataAtendidos;

public class Logic_Salida implements Interfaces.Manejo_Salida { // implementacion de interfaz de salida

    DataAtendidos A = new DataAtendidos(); // para trabajar con el txt de vehiculos atendidos
    LogicReportes L = new LogicReportes();
    Data d = new Data(); // para trabajar con el txt de vehiculos en parqueo
    public ArrayList<String> atendidos = new ArrayList<>(); // lista para vehiculos atendidos (que salieron)

    // declaracion de variables tipo globales (No es la mejor practica, en u entorno laboral no se debe ejecutar asi)
    public Duration Tiempoparqueo;
    public String entrada = "";
    public String Salida = "";
    public String TipoServicio = "";
    public double pagoTarifa = 0.0;
    public double precioFinal = 0.0;
    public boolean estado = false;
    public String placaActual = ""; 

    // Constantes, se utilizan mayusculas por regla general de constantes
    final int CANTIDAD_HORAS = 8; // constante para horas
    final double DESC = 0.10; // contante para descuento

    // funcion para verificar si la placa del vehiculo que va a salir esta en el parqueo
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
    public boolean Existencia_Actualizacion(String p) {
        verificacionSalida(p);
        return true;
    }

    // funcion que calcula los pagos y hace ciertas validaciones dentro
    // Personalmente esta funcion puede mejorar aplicando responsabilidad unica la cual actualmente no cumple
    private boolean CalculosFactura() {
        if (this.Tiempoparqueo == null) return false;
        for (int i = 0; i < d.leidos.size(); i++) {
            String lineaActual = d.leidos.get(i).toString();
            
            // Descuento
            if(lineaActual.contains(this.placaActual) && lineaActual.contains(",null,")){
            String lineaActualizada = lineaActual.replace(",null,", "," + Salida + ",");
            double hours = this.Tiempoparqueo.toMinutes();
            double horasRedondeadas = Math.ceil(hours / 60); // conversion a minutos pues si el vehiculo esta menos de una hora igualmente se le cobra una hora

            // Verificacion del servicio
            if(this.TipoServicio.equalsIgnoreCase("Por hora")){
             
                // verificacion si estuvo menos de una hora
                if (hours >= 0 && hours <= 60) {
                    precioFinal = pagoTarifa; 
                    estado = false;
                } 
               
            // verificacion si las horas en parqueo son 8 o mas se aplica descuento    
            else if (hours >= CANTIDAD_HORAS) {
                double precio = horasRedondeadas * pagoTarifa;
                double precioDesc = precio * DESC;
                precioFinal = precio - precioDesc;
                estado = true;
 
            // si las horas no son 8 o mas se cobra normal
            } else {
                precioFinal = horasRedondeadas * pagoTarifa;
                estado = false;
            }}
             
            // si el servicio no es por hora se cobra por dia
            else{
                precioFinal = pagoTarifa; 
                estado  = false;
            }
            //Actualizacion lista
            d.leidos.set(i, lineaActualizada);
            atendidos.add(lineaActualizada);
            return true;
        }}
        return false;
    }

    @Override
    public boolean AplicarDescuento() {
        return CalculosFactura();

    }

    // funcion para borrar el vehiculo de la lista de parqueo (atendidos) y reescritura del txt de parqueo sin el vehiculo
    public boolean BorrarVehiculo(String p) {
        for (int i = d.leidos.size() - 1; i >= 0; i--) {
            String lineaActual = d.leidos.get(i);
            if (lineaActual.contains(p)) {
                A.EscrituraAtendidos(atendidos); 
                d.leidos.remove(i);
            }
        }
        d.actualizarArchivo(d.leidos);
        return true;
    }

    // funcion para tomar los datos del txt de parqueo
    
    /* Observacion personal: esta funcion no es escalable, 
        con el simple factor de solicitar un elemento mas 
        de alguno de los vehiculos habria que refactorizarla    
        casi por completo, en un entorno laboral se podrian 
        usar patrones de diseno para rehacer los objetos basandonos en la informacion extraida*/
    
    @Override
    public boolean TomarDatos(String p) {
        for (int i = 0; i < d.leidos.size(); i++) {
            String lineaActual = d.leidos.get(i).toString();

            // si la linea actual contiene null y la placa del vehiculo
            if (lineaActual.contains(",null,") && lineaActual.contains(p)) {  
                this.placaActual = p;
                LocalDateTime ahora = LocalDateTime.now().withNano(0).withSecond(0); // seteo de la hora de salida
                this.Salida = ahora.toString(); // hora de salida a cadena de texto

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

                // verificacion del servicio
                String servicio = datos[2].trim();
                if (servicio.equalsIgnoreCase("Por hora")) {
                    this.TipoServicio = "Por hora";
                } else {
                    this.TipoServicio = "Por dia";
                }

                return true;
            }
        }
        return false;
    }

}
