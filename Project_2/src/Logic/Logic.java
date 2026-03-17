
package Logic;

public class Logic {
    private boolean ValidacionInput(String str)
    {
        return str.matches("^[A-Za-z]{3}[0-9]{3}+$");
    }
    
    public boolean EnvioDeValidacion(String str)
    {
        boolean result =  this.ValidacionInput(str);
        return result;
    }
}
