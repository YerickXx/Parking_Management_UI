package Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataAtendidos implements Interfaces.ManejoDatosSalida {
public ArrayList <String> vAtendidos = new ArrayList<>();
    
    private boolean VehiculosAtendidosCrear() {
        try {
            File files = new File("Atendidos.txt");
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
    public boolean VehiculosAtendidos() {
        VehiculosAtendidosCrear();
        return true;
    }

    private boolean EscribirVehiculoAtendidos(List<String> atendidos) {
        try (FileWriter escribir = new FileWriter("Atendidos.txt", true)) {
            for (String s : atendidos) {
                escribir.write(s.toString() + "\n");
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean EscrituraAtendidos(List<String> atendidos){
        EscribirVehiculoAtendidos(atendidos);
        return true;
    }

    
   private void Lectura() {
        vAtendidos.clear();
        File leer = new File("Atendidos.txt");
        try (Scanner lector = new Scanner(leer))// nuevo try-with-resources (cierra de forma automatica los archivos)
        {
            while (lector.hasNextLine()) {
                String dat = lector.nextLine(); // lectura linea a linea
                vAtendidos.add(dat);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
   
   @Override
   public boolean lecturaAtendidos()
   {
       Lectura();
       return true;
   }
}
