package Logic;


public class LogicReportes implements Interfaces.ManejoReportes 
{
    Logic_Salida L = new Logic_Salida();
 
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
    public String PorcentajeUso()
    {
        for(String cantidad : L.atendidos)
        {
            return String.valueOf(cantidad);
        }
        return "";
    }
    
    @Override
    public String VehiculosAtendidos()
    {
        return String.valueOf(L.atendidos.size());
    }
}
