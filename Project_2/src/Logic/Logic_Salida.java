package Logic;

import Data.Data;
import java.time.LocalDateTime;
import java.time.Duration;
import Logic.Logic_Objetos;

public class Logic_Salida implements Interfaces.Manejo_Salida { // implementacion de interfaz de salida

    Logic_Objetos L = new Logic_Objetos();
    Data d = new Data();
    boolean aplica = false;
    int tiempo = 0;

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

    @Override
    public boolean AplicarDescuento() {
        return false;
    }

    private boolean CalculosFactura() {
        for (int i = 0; i < d.leidos.size(); i++) {
            String lineaActual = d.leidos.get(i).toString();
            if (lineaActual.contains(",null,")) {
                //Definicion de salida
                LocalDateTime ahora = LocalDateTime.now().withNano(0).withSecond(0);
                String fechaSalidaStr = ahora.toString();

                // Extraccion de datos para calcular
                String[] datos = lineaActual.split(",");

                //tomar el tercer elemento iterando de atras hacia adelante
                String strEntrada = datos[datos.length - 3].trim();
                LocalDateTime horaEntrada = LocalDateTime.parse(strEntrada);

                //Duracion
                Duration duracion = Duration.between(horaEntrada, ahora);
                long horasTotales = duracion.toHours();

                // Descuento
                String lineaActualizada = lineaActual.replace(",null,", "," + fechaSalidaStr + ",");

                if (horasTotales >= CANTIDAD_HORAS) {
                    System.out.println("Aplica descuento de 10% por " + horasTotales + " horas.");
                }

                //Actualizacion lista
                d.leidos.set(i, lineaActualizada);
                System.out.println("Línea actualizada: " + lineaActualizada);

                return true;
            }
        }
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

}
