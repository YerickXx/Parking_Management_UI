package Logic;
import Data.DataAtendidos;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Duration;

public class LogicReportes implements Interfaces.ManejoReportes 
{
    LocalDate D = LocalDate.now();
    DataAtendidos L = new DataAtendidos();
    public double pagosTotales = 0.0;
    public int count = 0;
 
    public void leerAtendidos()
    {
        L.lecturaAtendidos();
    }
    
    @Override
    public String HorasTotales()
    {
        this.leerAtendidos();
    long minutosTotales = 0;
    
    for (String linea : L.vAtendidos) {
        String[] datos = linea.split(",");
        // Suponiendo que la entrada es datos[length-3] y salida datos[length-2]
        LocalDateTime entrada = LocalDateTime.parse(datos[datos.length - 3].trim());
        LocalDateTime salida = LocalDateTime.parse(datos[datos.length - 2].trim());
        
        minutosTotales += Duration.between(entrada, salida).toMinutes();
    }
    
    long horas = minutosTotales / 60;
    long minsRestantes = minutosTotales % 60;
    
    return "El parqueo ha sido utilizado un total de: " + horas + " horas y " + minsRestantes + " minutos.";
}
    
   
    @Override
    public String PagosTotales()
    {
        String strEntrada = "";
        double contador = 0;
        for(int i = 0; i<L.vAtendidos.size(); i++)
        {
            String linea = L.vAtendidos.get(i);
                String[] datos = linea.split(",");
                strEntrada = datos[datos.length - 1].trim();
                 contador += Double.parseDouble(strEntrada);
        }
        return "Los pagos totales efectuados el dia: "+D+" fueron de: "+String.valueOf(contador)+" colones";
    }
    
   @Override
public String PorcentajeUso() {
    int cantidad = L.vAtendidos.size();
    int espaciosMax = 10;
    double porcentaje = ((double) cantidad / espaciosMax) * 100;
    return "El porcentaje de uso del parqueo del dia: " + D + " Fue del: " + porcentaje+"%" + " porciento!";
}
    
    @Override
    public String VehiculosAtendidos()
    {
      int cantidad = L.vAtendidos.size();
     return "La cantidad de vehiculos atendidos del dia: "+D+ " Fueron "+String.valueOf(cantidad)+" vehiculos";
    }
    
}
