// class Truck extends atributes from Vehiculo and add two more personal atributes
package Entities;

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
    public Camion(double cCapacidad_Carga, int cNumero_Ejes)
    {
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
    

}
