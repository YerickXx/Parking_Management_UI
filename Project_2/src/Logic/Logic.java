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
    
    @Override
    public boolean cincoEspacios()
    {
        final int ESPACIOS_RESTANTES = 5;
        d.LeerVehiculo();
        if(d.leidos.size() == ESPACIOS_RESTANTES)
        {
            return true;
        }
        return false;
    }
}
