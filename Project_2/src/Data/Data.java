package Data;

import java.io.*;
import Entities.Vehiculo;
import java.util.List;


public class Data implements Interfaces.ManejoDatos {

    // Creacion de archivo .dat
    private boolean NuevoArchivo() {
        try {
            File files = new File("Vehiculos.txt");
            if (files.createNewFile()) // creacion del archivo
            {
                if (files.exists()) {
                    System.out.println("El archivo ya se encuantra creado");
                }
                System.out.println("Archivo Creado"); // mensaje que aparece en consola con fines tipo Log para el programador
                return true;
            }
        } catch (IOException e) // manejo de la excepcion 
        {
            e.printStackTrace(); // mostrar el error
        }
        return false;
    }

    @Override
    public boolean CrearArchivo() {
        return NuevoArchivo();
    }

    // Escritura de archivos .dat
    private boolean Escritura(List<Vehiculo> vehiculo) {
        try (FileWriter escribir = new FileWriter("Vehiculos.txt",true)) {
            for (Vehiculo s : vehiculo) {
                escribir.write(s.toString() + "\n");
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean GuardarVehiculo(List<Vehiculo> vehiculo) 
    {
        return Escritura(vehiculo);
    }

    // Lectura de los archivos .dat
    private boolean Lectura() {
        return false;
    }

    @Override
    public boolean LeerVehiculo() {
        Lectura();
        return false;
    }

    // Borrado de contenido 
    private boolean Borrado() {
        return false;
    }

    @Override
    public boolean BorrarVehiculo() {
        Borrado();
        return false;
    }

}
