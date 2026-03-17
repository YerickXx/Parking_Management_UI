
package Logic;
  import java.util.ArrayList;
 import Entities.Motocicleta;
 import Entities.Automovil;
 import Entities.Camion;
public class Logic implements Interfaces.Validaciones{
    Automovil auto;
    Motocicleta moto;
    Camion camion;
    ArrayList vehiculoParqueo = new ArrayList();
    
    
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
}
