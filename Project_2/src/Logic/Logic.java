
package Logic;
  import java.util.ArrayList;
 import Entities.Motocicleta;
 import Entities.Automovil;
 import Entities.Camion;
import java.time.LocalDateTime;
public class Logic implements Interfaces.Validaciones,Interfaces.manejoObjetos, Interfaces.GuardadoTemporal{
    Automovil autos = new Automovil();
    Motocicleta moto;
    Camion camion;
    ArrayList vehiculoParqueo = new ArrayList();
    
    
    // Validacion Placa
    private boolean ValidarIntento(String str)
    {
        String word = str.trim();
        return word.matches("^[A-Za-z]{3}[0-9]{3}$");
    }
    
    @Override
    public boolean ValidacionInput(String str)
    {
        return ValidarIntento(str);
    }
    
    // Guardado temporal
    @Override
    public String almacenarTemp(String... str) // recibo dinamico de strings
    {
        for(String strs : str)
        {
            return strs;
        }
        return "";
    }
    
    // Creacion del Automovil (Urge terminar prioridad maxima)
    private void crearAutomovil()
    {
        String a = almacenarTemp();
        String b = nuevoAutoMovil();
        vehiculoParqueo.add(a);
        vehiculoParqueo.add(b);
        for(var da : vehiculoParqueo)
        {
            
        }
        
    }
    
    @Override
    public String nuevoAutoMovil(String... str)
    {
        for(String strs : str)
        {
            return strs;
        }
        return "";
    }
    
}
