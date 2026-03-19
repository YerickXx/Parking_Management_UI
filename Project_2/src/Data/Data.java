
package Data;

/**
 *
 * @author yeric
 */
public class Data implements Interfaces.ManejoDatos {
    
    // Creacion de archivo .dat
    private void NuevoArchivo(){}
    
    @Override
    public void CrearArchivo(){NuevoArchivo();}
    
    // Escritura de archivos .dat
    private boolean Escritura(){return false;}
    
    @Override
    public boolean GuardarVehiculo(){Escritura();return false;}
    
    // Lectura de los archivos .dat
    private boolean Lectura(){return false;}
    
    @Override
    public boolean LeerVehiculo(){Lectura(); return false;}
    
    // Borrado de contenido 
    private boolean Borrado(){return false;}
    
    @Override
    public boolean BorrarVehiculo(){Borrado(); return false;}
    
}
