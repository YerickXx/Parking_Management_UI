// Parent class for Motocicleta, Automovil and Camion
package Entities;
import java.time.LocalDateTime;
/**
 *
 * @author yeric
 */
public class Vehiculo { 
    // atributes declaration
    private String Placa;
    private String Servicio;
    private double Tarifa_base;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;
 
    
    public Vehiculo() // builder
    {
        this.Placa = "";
        this.Servicio = "";
        this.Tarifa_base = 0.0;
        this.horaEntrada = LocalDateTime.now();
        this.horaSalida = LocalDateTime.now();
    }
    
    public Vehiculo(String vPlaca, String vServicio, 
            double vTarifa_base, boolean vDescuento, LocalDateTime vhoraEntrada, LocalDateTime vhoraSalida)
    {
        this.Placa = vPlaca;
        this.Servicio = vServicio;
        this.Tarifa_base = vTarifa_base;
 
        
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

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
    }
      
}