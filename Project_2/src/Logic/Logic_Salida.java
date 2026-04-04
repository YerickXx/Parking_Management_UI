package Logic;

import Data.Data;
import java.time.LocalDateTime;
import java.time.Duration;
import java.util.ArrayList;
import Data.DataAtendidos;

public class Logic_Salida implements Interfaces.Manejo_Salida { // implementacion de interfaz de salida

    DataAtendidos A = new DataAtendidos();
    Data d = new Data();
    public ArrayList<String> atendidos = new ArrayList<>(); // lista para vehiculos atendidos (que salieron)

    public Duration Tiempoparqueo;
    public String entrada = "";
    public String Salida = "";
    public String TipoServicio = "";
    public double pagoTarifa = 0.0;
    public double precioFinal = 0.0;
    public boolean estado = false;

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
    public boolean Existencia_Actualizacion(String p) {
        verificacionSalida(p);
        return true;
    }

    private boolean CalculosFactura() {
        for (int i = 0; i < d.leidos.size(); i++) {
            String lineaActual = d.leidos.get(i).toString();
            // Descuento
            String lineaActualizada = lineaActual.replace(",null,", "," + Salida + ",");
            double hours = this.Tiempoparqueo.toMinutes();
            double horasRedondeadas = Math.ceil(hours / 60);

            // verificamos si la linea actual es moto o vehiculo para determinar el precio sobre el cual se haran calculos
             pagoTarifa = (lineaActual.contains("Motocilceta"))? 500.0 : 600;
                if (hours >= 0 && hours <= 60) {
                    precioFinal = 600.0;
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
            //Actualizacion lista
            d.leidos.set(i, lineaActualizada);
            atendidos.add(lineaActualizada);
            return true;
        }
        return false;
    }

    @Override
    public boolean AplicarDescuento() {
        return CalculosFactura();

    }

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

    @Override
    public boolean TomarDatos() {
        for (int i = 0; i < d.leidos.size(); i++) {
            String lineaActual = d.leidos.get(i).toString();

            if (lineaActual.contains(",null,")) {
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
