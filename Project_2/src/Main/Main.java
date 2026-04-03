package Main;

import GUI.mainMenu;
import Data.Data;
import Data.DataAtendidos;
public class Main {
    
    
public static void llamadoCrearArchivo()
{       
      Data d = new Data();
      d.CrearArchivo();
      DataAtendidos A = new DataAtendidos();
      A.VehiculosAtendidos();
}
    
    public static void main(String[] args) {
        // TODO code application logic here
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainMenu().setVisible(true);
            }
        });
         
         llamadoCrearArchivo();
    }
    public static void menu(){}
    
 
}


