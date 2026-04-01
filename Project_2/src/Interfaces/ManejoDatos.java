
package Interfaces;
import java.util.List;
import Entities.Vehiculo;
import java.util.ArrayList;

public interface ManejoDatos {
    public boolean CrearArchivo();
    public boolean GuardarVehiculo(List<Vehiculo> vehiculo);
    public boolean LeerVehiculo();
    public void actualizarArchivo(ArrayList<String> lineasActualizadas);
}
