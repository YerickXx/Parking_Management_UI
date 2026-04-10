/*Clase encargada de verificar el proceso de espacios dentro del parqueo*/

package Logic;

// importes de clases necesarias
import Data.Data;

public class Logic_Espacios implements Interfaces.Control_Espacios{
    Data d = new Data(); // data para trabajar con los vehiculos actualmente en el parqueo
    Logic_Salida s = new Logic_Salida(); // llamado de la clase encargada de la salidad de los vehiculos
    
    //constantes a usar en el desarrollo (Evitar harcodeo)
    final int ESPACIOS_TOTALES = 10;
    final int ESPACIOS_RESTANTES = 5;
    int contadorEspacios = 1;
    
    // funcion para verificar que el contador sea menor a los espacios en el parqueo
    @Override
    public boolean EspaciosEnParqueo()
    {
        d.LeerVehiculo(); 
        return d.leidos.size() < ESPACIOS_TOTALES; // retorno alterno que devuelve true o false 
    }
    
       // funcion para verificar si quedan 5 espacios en parqueo
    @Override
    public boolean cincoEspacios() 
    {
        d.LeerVehiculo();
        return d.leidos.size() == ESPACIOS_RESTANTES; // retorno alterno que devuelve true o false 
    }
    
    // funcion para aumentar o disminuir el contador de espacios
    public void aumentarEspacios()
    {
        contadorEspacios += s.atendidos.size(); // retorno alterno que devuelve true o false 
    }
    

}
