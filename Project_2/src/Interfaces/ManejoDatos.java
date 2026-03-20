
package Interfaces;
import java.util.List;
import Entities.Vehiculo;

public interface ManejoDatos {
    public boolean CrearArchivo();
    public boolean GuardarVehiculo(List<Vehiculo> vehiculo);
    public boolean LeerVehiculo();
    public boolean BorrarVehiculo();
}
