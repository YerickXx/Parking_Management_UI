/*Clase que desarrolla diferentes funciones para validacion de distintos inputs*/

package Logic;
import Data.Data;

public class Logic_Validaciones implements Interfaces.Validaciones {
    Data d = new Data();
    
     // Validacion Placa
    private boolean ValidarIntento(String str) {
        String word = str.trim();
        return word.matches("^[A-Za-z]{3}[0-9]{3}$");
    }

    @Override
    public boolean ValidacionInputAlphaNum(String str) {
        return ValidarIntento(str);
    }

    //Validacion texto
    private boolean ValidarTexto(String str) {
        String palabra = str.trim();
        return palabra.matches("^[A-Za-z]+$");
    }

    @Override
    public boolean ValidacionInputTexto(String str) {
        return ValidarTexto(str);
    }

    // Validacion de doubles
    private boolean validarDouble(String str) {
        String valorDecimal = str.trim();
        return valorDecimal.matches("^\\d*\\.\\d+$"); // Regex para validar si el input es double
    }

    @Override
    public boolean ValidacionDouble(String str) {
        return validarDouble(str);
    }

    // Validacion unicidad de placa 
    public boolean placaUnica (String str) {
        String placa = str;
        d.LeerVehiculo();

        for (var v : d.leidos) {
            if (v.toString().contains(placa)) {
                return true;
            }
        }
        return false;
    }
    
    // Validacion capacidad de carga del camion
    public boolean ValidarCarga(String... str) // validacion capacidad de carga de acuerdo a la ley
    {
        int ejes = Integer.parseInt(str[1]);
        double capacidad = Double.parseDouble(str[0]);
        
        if(ejes <= 2 && capacidad > 18)
        {
            return false;
        }
        if(ejes == 3 && capacidad > 25)
        {
            return false;
        }
        if(ejes == 4 && capacidad > 36)
        {
            return false;
        }
        return true;
    }
}
