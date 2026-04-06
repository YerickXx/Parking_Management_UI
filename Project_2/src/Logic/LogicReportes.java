/*Clase encargada de generar los reportes para mostrar a usuario*/

package Logic;

//importes de clases y librerias necesarias
import Data.DataAtendidos;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Duration;

public class LogicReportes implements Interfaces.ManejoReportes 
{
    // declaracion de variables
    LocalDate D = LocalDate.now();
    DataAtendidos L = new DataAtendidos();
    public double pagosTotales = 0.0;
    public int count = 0;
 
    // leer txt de vehiculos que se encuentra dentro del parqueo
    public void leerAtendidos()
    {
        L.lecturaAtendidos();
    }
    
    // funcion para el calculo de horas totales de uso
    @Override
    public String HorasTotales()
    {
        this.leerAtendidos();
        long minutosTotales = 0;
    
    for (String linea : L.vAtendidos) {
        String[] datos = linea.split(","); // separamos por comas
        
        // tomamos la hora de entrada y salida de cada vehiculo
        LocalDateTime entrada = LocalDateTime.parse(datos[datos.length - 3].trim());
        LocalDateTime salida = LocalDateTime.parse(datos[datos.length - 2].trim());
        
        // contador va a aumentar basandose en la duracion entre la entrada y salida
        minutosTotales += Duration.between(entrada, salida).toMinutes();
    }
    
    // conversiones 
    long horas = minutosTotales / 60;
    long minsRestantes = minutosTotales % 60;
    
    return "El parqueo ha sido utilizado un total de: " + horas + " horas y " + minsRestantes + " minutos.";
}
    
   // Funcion para calcular pagos totales
    @Override
    public String PagosTotales()
    {
        String strEntrada = ""; // seteamos la variable a limpia para que no sea un acumulador
        double contador = 0;
        
        for(int i = 0; i<L.vAtendidos.size(); i++) // iteracion de index
        {
            String linea = L.vAtendidos.get(i);
                String[] datos = linea.split(",");
                strEntrada = datos[datos.length - 1].trim(); // tomamos el index de pago efectuado
                 contador += Double.parseDouble(strEntrada); // el contador aumenta segun el pago
        }
        return "Los pagos totales efectuados el dia: "+D+" fueron de: "+String.valueOf(contador)+" colones";
    }
    
 // funcion para calcular el procentaje de uso del parqueo
   @Override
    public String PorcentajeUso() {
    int cantidad = L.vAtendidos.size(); // tomamos el tamano del txt de los vehiculos atendidos
    int espaciosMax = 10; // espacios maximos de parqueo
    double porcentaje = ((double) cantidad / espaciosMax) * 100; // calculo de porcentaje
    return "El porcentaje de uso del parqueo del dia: " + D + " Fue del: " + porcentaje+"%" + " porciento!";
}
    
    // funcion para ver los la cantidad de vehiculos atendidos
    @Override
    public String VehiculosAtendidos()
    {
      int cantidad = L.vAtendidos.size(); // tomamos el tamano del txt de atendidos
     return "La cantidad de vehiculos atendidos del dia: "+D+ " Fueron "+String.valueOf(cantidad)+" vehiculos";
    }
    
}
