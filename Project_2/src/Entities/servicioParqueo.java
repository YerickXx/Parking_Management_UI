
package Entities;

/**
 *
 * @author yeric
 */
public class servicioParqueo {
    // atributes declaration
     private int tiempoParqueo;
    private double pagoTotal;
    
    public servicioParqueo() // builder
    {
        this.tiempoParqueo = 0;
        this.pagoTotal = 0.0;
    }
    
    public servicioParqueo(int stiempoParqueo, boolean sdescuento, 
            double spagoTotal)
    {
        this.tiempoParqueo = stiempoParqueo;
        this.pagoTotal = spagoTotal;
    }
    
    // getters and setters

    public int getTiempoParqueo() {
        return tiempoParqueo;
    }

    public void setTiempoParqueo(int tiempoParqueo) {
        this.tiempoParqueo = tiempoParqueo;
    }

    public double getPagoTotal() {
        return pagoTotal;
    }

    public void setPagoTotal(double pagoTotal) {
        this.pagoTotal = pagoTotal;
    }
    
    
}
