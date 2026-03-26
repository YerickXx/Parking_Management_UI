package Logic;
import Data.Data;

public class Logic implements Interfaces.Control_Espacios{
    Data d = new Data();
    final int ESPACIOS_TOTALES = 10; // se usan mayusculas al ser un final para distinguirla de las variables
    
    @Override
    public boolean EspaciosEnParqueo()
    {
        d.LeerVehiculo();
        if(d.leidos.size() < ESPACIOS_TOTALES)
        {
            return true;
        }
        return false;
    }
    
}
