// class Motocicleta extends atributes from Vehiculo and add two more personal atributes
package Entities;
import java.time.LocalDateTime;
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
    
    public Motocicleta(String placa, String servicio, double total, boolean descuento,LocalDateTime entrada,
            LocalDateTime salida,int mCilindraje,String mTipo)
    {
        super(placa, servicio,total,descuento,entrada,salida);
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
    
        @Override
    public String toString() 
    {
    return "Motocicleta, " + "Placa: "+this.getPlaca() +", Servicio: "+ this.getServicio() +
            ", Cilindraje: " + Cilindraje + ", Tipo Moto: " + Tipo_Moto+  ", Tarifa: " + this.getTarifa_base();
    }
    
}
