package Data;

import java.io.*;
import Entities.Vehiculo;
import java.util.List;
import java.io.FileNotFoundException; // para el manejo de errores (tomado de W3 schools)
import java.util.Scanner;             // El Scanner para leer los archivos
import java.util.ArrayList;

public class Data implements Interfaces.ManejoDatos {
    public ArrayList<String> leidos = new ArrayList<>(); // lista para cargar los datos leidos

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
    
    public void actualizarArchivo(ArrayList<String> lineasActualizadas) {
    // En false para no agregar al final
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("Vehiculos.txt", false))) {
        for (String linea : lineasActualizadas) {
            bw.write(linea);
            bw.newLine();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    @Override
    public boolean GuardarVehiculo(List<Vehiculo> vehiculo) 
    {
        
        return Escritura(vehiculo);
    }

    // Lectura de los archivos .dat
    private void Lectura() 
    {
        leidos.clear();
        File leer = new File("Vehiculos.txt");
        try(Scanner lector = new Scanner(leer))// nuevo try-with-resources (cierra de forma automatica los archivos)
        {
            while(lector.hasNextLine())
            {
                String dat = lector.nextLine(); // lectura linea a linea
                leidos.add(dat);
               
            }
        } catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
       
    }

    @Override
    public boolean LeerVehiculo() {
        Lectura();
        return true;
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
