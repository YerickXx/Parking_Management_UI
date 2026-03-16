// Parent class for Motocicleta, Automovil and Camion
package Entities;

/**
 *
 * @author yeric
 */
public class Vehiculo { 
    // atributes declaration
    private String Placa;
    private String Servicio;
    private double Tarifa_base;
    private boolean Descuento;
    
    public Vehiculo() // builder
    {
        this.Placa = "";
        this.Servicio = "";
        this.Tarifa_base = 0.0;
        this.Descuento = false;
    }
    
    public Vehiculo(String vPlaca, String vServicio, 
            double vTarifa_base, boolean vDescuento)
    {
        this.Placa = vPlaca;
        this.Servicio = vServicio;
        this.Tarifa_base = vTarifa_base;
        this.Descuento = vDescuento;
        
    }
    
    //getters and setters

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public String getServicio() {
        return Servicio;
    }

    public void setServicio(String Servicio) {
        this.Servicio = Servicio;
    }

    public double getTarifa_base() {
        return Tarifa_base;
    }

    public void setTarifa_base(double Tarifa_base) {
        this.Tarifa_base = Tarifa_base;
    }

    public boolean isDescuento() {
        return Descuento;
    }

    public void setDescuento(boolean Descuento) {
        this.Descuento = Descuento;
    }
    
    
}