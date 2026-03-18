
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
    public boolean ValidacionInputAlphaNum(String str)
    {
        return ValidarIntento(str);
    }
    
    public void CreacionVehiculo()
    {
        
    }
   
    
}
