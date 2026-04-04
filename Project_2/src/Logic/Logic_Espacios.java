package Logic;
import Data.Data;

public class Logic_Espacios implements Interfaces.Control_Espacios{
    Data d = new Data();
    Logic_Salida s = new Logic_Salida();
    final int ESPACIOS_TOTALES = 10; // se usan mayusculas al ser un final para distinguirla de las variables
    final int ESPACIOS_RESTANTES = 5;
    int contadorEspacios = 0;
    
    @Override
    public boolean EspaciosEnParqueo()
    {
        if(contadorEspacios < ESPACIOS_TOTALES)
        {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean cincoEspacios()
    {
        d.LeerVehiculo();
        if(d.leidos.size() == ESPACIOS_RESTANTES)
        {
            return true;
        }
        return false;
    }
    
    public void aumentarEspacios()
    {
        contadorEspacios += s.atendidos.size();
    }
    
    
}
