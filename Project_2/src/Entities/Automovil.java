// class Automovil extends atributes from Vehiculo and add three more personal atributes
package Entities;

/**
 *
 * @author yeric
 */
public class Automovil extends Vehiculo {
    // atributes definition
    private String Tipo_Combustible;
    private String Modelo;
    private String Marca;
    
    public Automovil() // builder
    {
        this.Tipo_Combustible = "";
        this.Modelo = "";
        this.Marca = "";
    }
    
    public Automovil(String aTipo_Combustible, String aModelo, String aMarca) 
    {
        this.Tipo_Combustible = aTipo_Combustible;
        this.Modelo = aModelo;
        this.Marca = aMarca;
    }

    //getters and setters
    
    public String getTipo_Combustible() {
        return Tipo_Combustible;
    }

    public void setTipo_Combustible(String Tipo_Combustible) {
        this.Tipo_Combustible = Tipo_Combustible;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }
    
    
}
