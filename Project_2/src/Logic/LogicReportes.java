package Logic;
import Data.DataAtendidos;
import java.time.LocalDate;

public class LogicReportes implements Interfaces.ManejoReportes 
{
    LocalDate D = LocalDate.now();
    DataAtendidos L = new DataAtendidos();
 
    public void leerAtendidos()
    {
        L.lecturaAtendidos();
    }
    
    @Override
    public String HorasTotales()
    {
        return "";
    }
    
    @Override
    public String PagosTotales()
    {
        return "";
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
