
package Logic;
import Data.Data;
import java.time.LocalDateTime;
import Entities.Vehiculo;
import java.time.Duration;

public class Logic_Salida implements Interfaces.Manejo_Salida{
    Data d = new Data();
    final int CANTIDAD_HORAS = 8;
    final double DESC = 0.10;
    
@Override 
public boolean Existencia_Actualizacion(String p) {
    d.LeerVehiculo();

    
    for (int i = 0; i < d.leidos.size(); i++) {
        Vehiculo v = (Vehiculo) d.leidos.get(i); // tomar la posicion de un elemento dentro de la lista
        
        // actualizacion hora de salida
        if (v.getPlaca().equals(p)) {
            LocalDateTime s = LocalDateTime.now().withNano(0).withSecond(0); // eliminar milisegundos y segundos
            v.setHoraSalida(s); // actualizar la hora de salida a la hora actual
            d.leidos.set(i, v);
            
            //actualizacion descuento
            Duration duration = Duration.between(v.getHoraEntrada(), v.getHoraSalida());
            if(duration.toHours() >= CANTIDAD_HORAS)
            {
                boolean desc = true;
                v.setDescuento(desc);
                AplicarDescuento();
                d.leidos.set(i, v);
            }
            
            return true; 
        }
        
    }
    
    return false;
}

@Override
public boolean AplicarDescuento()
{
    for (int i = 0; i < d.leidos.size(); i++) {
    Vehiculo v = (Vehiculo) d.leidos.get(i); // tomar la posicion de un elemento dentro de la lista
    if(v.getServicio().equalsIgnoreCase("Por dia"))
    {
        double tarifa = v.getTarifa_base();
        double total = tarifa*DESC;
        v.setTarifa_base(total);
    }
    return true;
    }
    return false;
}


@Override
public String factura()
{
    
    return "";
}

}
 