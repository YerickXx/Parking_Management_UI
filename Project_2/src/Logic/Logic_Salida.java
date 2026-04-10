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
        
        if(lineaActual.contains(this.placaActual) && lineaActual.contains(",null,")){
            String lineaActualizada = lineaActual.replace(",null,", "," + Salida + ",");
            double hours = this.Tiempoparqueo.toMinutes();
            double horasRedondeadas = Math.ceil(hours / 60);

            if(this.TipoServicio.equalsIgnoreCase("Por hora")){
                if (hours >= 0 && hours <= 60) {
                    precioFinal = pagoTarifa; 
                    estado = false;
                } 
                else if (hours >= CANTIDAD_HORAS) {
                    double precio = horasRedondeadas * pagoTarifa;
                    double precioDesc = precio * DESC;
                    precioFinal = precio - precioDesc;
                    estado = true;
                } else {
                    precioFinal = horasRedondeadas * pagoTarifa;
                    estado = false;
                }
            }
            // "Por dia" también multiplica Tarifa * Tiempo
            else {
                precioFinal = horasRedondeadas * pagoTarifa; 
                estado = false;
            }

            // ACTUALIZACIÓN DE LA LÍNEA: 
            // Concatenamos el precioFinal al final de la línea para que el reporte lo lea
            lineaActualizada = lineaActualizada + "," + precioFinal;

            d.leidos.set(i, lineaActualizada);
            atendidos.add(lineaActualizada);
            return true;
        }
    }
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
    
    
    // Para esta funcion especifica me apoye de Gemini IA para generarla, pues era una funcion algo basica simplemente utilizando variables globales de esta misma clase
    public String obtenerReciboTexto() {
    // horas y el subtotal base (Tarifa * Tiempo)
    double horasUso = Math.ceil(this.Tiempoparqueo.toMinutes() / 60.0);
    
    //el subtotal
    double subtotalCalculado = horasUso * pagoTarifa;
    
    // 2. Manejo del Total
    double montoDescuento = estado ? (subtotalCalculado * DESC) : 0;
    double totalReal = subtotalCalculado - montoDescuento;

    StringBuilder sb = new StringBuilder();
    sb.append("--------------------------------------------------\n");
    sb.append("           RECIBO DE SERVICIO DE PARQUEO          \n");
    sb.append("--------------------------------------------------\n\n");
    
    sb.append("Placa del vehiculo: ").append(this.placaActual).append("\n");
    sb.append("Tipo de servicio: ").append(this.TipoServicio).append("\n");
    sb.append("Horas de uso: ").append((int)horasUso).append("\n");
    sb.append("Tarifa: ₡").append((int)pagoTarifa).append("\n");
    
    //Mostramos el resultado de la multiplicación
    sb.append("Subtotal: ₡").append((int)subtotalCalculado).append("\n");
    
    if (estado) {
        sb.append("Descuento aplicado (10%): ₡").append((int)montoDescuento).append("\n");
    }
    
    sb.append("--------------------------------------------------\n");
    sb.append("TOTAL A PAGAR: ₡").append((int)totalReal).append("\n");
    sb.append("--------------------------------------------------\n\n");
    
    sb.append("Gracias por utilizar nuestro servicio.");
    
    return sb.toString();
}
}
