package Interfaces;
import java.util.ArrayList;
import java.util.List;

public interface ManejoDatosSalida {
    boolean VehiculosAtendidos();
    boolean EscrituraAtendidos(List<String> atendidos);
    boolean lecturaAtendidos();
}
