/*Clase principal de acceso al programa, este es el disparador de la aplicacion*/

package Main;

import GUI.mainMenu;
import Data.Data;
import Data.DataAtendidos;
import com.formdev.flatlaf.FlatDarkLaf; // IMPORT
import javax.swing.UIManager;
public class Main {
    
    
public static void llamadoCrearArchivo()
{       
      Data d = new Data(); // llamado de la clase data
      d.CrearArchivo(); // creacion del archivo que guardara los vehiculos que estan dentro del parqueo
      DataAtendidos A = new DataAtendidos(); // llamado de la clase DataAtendidos
      A.VehiculosAtendidos(); // archivo que guardara los vehiculos que fueron atendidos
}
    
    public static void main(String[] args) {
        // TODO code application logic here
        try {
    UIManager.setLookAndFeel(new FlatDarkLaf()); // uso de la libreria FlatLafDark para mejorar un poco el nivel visual
} catch (Exception ex) {
    ex.printStackTrace();
}
        
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainMenu().setVisible(true); // generacion de la ventana del menu principal
            }
        });
         
         llamadoCrearArchivo();
    }
    public static void menu(){}
    
 
}


