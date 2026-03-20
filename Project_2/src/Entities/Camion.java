// class Truck extends atributes from Vehiculo and add two more personal atributes
package Entities;
import java.time.LocalDateTime;
        
/**
 *
 * @author yeric
 */
public class Camion extends Vehiculo {
    // atributes definition
    private double Capacidad_Carga;
    private int Numero_Ejes;
    
    public Camion(){ // builder
    this.Capacidad_Carga = 0.0;
    this.Numero_Ejes = 0;
    }
    public Camion(String placa, String servicio, double total,boolean descuento,
            LocalDateTime entrada, LocalDateTime salida,double cCapacidad_Carga, int cNumero_Ejes)
    {
        super(placa, servicio,total,descuento,entrada,salida);
        this.Capacidad_Carga = cCapacidad_Carga;
        this.Numero_Ejes = cNumero_Ejes;
    }

      //getters and setters
    
    public double getCapacidad_Carga() {
        return Capacidad_Carga;
    }

    public void setCapacidad_Carga(double Capacidad_Carga) {
        this.Capacidad_Carga = Capacidad_Carga;
    }

    public int getNumero_Ejes() {
        return Numero_Ejes;
    }

    public void setNumero_Ejes(int Numero_Ejes) {
        this.Numero_Ejes = Numero_Ejes;
    }
    
    @Override
    public String toString() 
    {
    return "Camion, " + this.getPlaca() +", "+ this.getServicio() + ", " + Capacidad_Carga + ", " + Numero_Ejes + ", " +  ", " + this.getTarifa_base();
    }
}
