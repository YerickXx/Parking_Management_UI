// class Motocicleta extends atributes from Vehiculo and add two more personal atributes
package Entities;

/**
 *
 * @author yeric
 */
public class Motocicleta extends Vehiculo {
    // atributes definition
    private int Cilindraje;
    private String Tipo_Moto;
    
    public Motocicleta() // builder
    {
        this.Cilindraje = 0;
        this.Tipo_Moto = "";
    }
    
    public Motocicleta(int mCilindraje,String mTipo)
    {
        this.Cilindraje = mCilindraje;
        this.Tipo_Moto = mTipo;
    }

      //getters and setters
    
    public int getCilindraje() {
        return Cilindraje;
    }

    public void setCilindraje(int Cilindraje) {
        this.Cilindraje = Cilindraje;
    }

    public String getTipo_Moto() {
        return Tipo_Moto;
    }

    public void setTipo_Moto(String Tipo_Moto) {
        this.Tipo_Moto = Tipo_Moto;
    }
    
}
