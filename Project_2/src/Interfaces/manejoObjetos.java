package Interfaces;

import Entities.Vehiculo;
import java.util.List;

/**
 * @author yeric
 */
public interface manejoObjetos {
    public void creacionVehiculos(String... str);
    public void creacionYguardadoAutomovil(String... str);
    public void creacionYguardadoMotocicleta(String... str);
    public void creacionYguardadoCamion(String... str);
    public void creacionYguardadoAutomovilHora(String... str);
    public void creacionYguardadoMotocicletaHora(String... str);
    public void creacionYguardadoCamionHora(String... str);
    public void GuardarVehiculos(List<Vehiculo> vehiculo);
}
