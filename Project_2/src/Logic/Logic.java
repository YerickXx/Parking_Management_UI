package Logic;
 import Entities.Motocicleta;
 import Entities.Automovil;
 import Entities.Camion;
import Entities.Vehiculo;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Logic implements Interfaces.Validaciones,Interfaces.manejoObjetos, Interfaces.GuardadoTemporal{
     List<Vehiculo> vehiculos = new ArrayList<>();
       
    // Validacion Placa
    private boolean ValidarIntento(String str)
    {
        String word = str.trim();
        return word.matches("^[A-Za-z]{3}[0-9]{3}$");
    }
    
    @Override
    public boolean ValidacionInputAlphaNum(String str)
    {
        return ValidarIntento(str);
    }
    
    @Override
    public void creacionVehiculos(String... str)
    {   
        if(str.length == 0)
          {
            return;
          }
        String type = str[0];
       switch(type)
       {
           case "Automovil" -> 
           {
               creacionYguardadoAutomovil(str);
            break;
           }
           
           case "Motocicleta" -> 
           {
               creacionYguardadoMotocicleta(str);
            break;
           }
           
           case "Camion" -> 
           {
               creacionYguardadoCamion(str);
            break;
           }
       }
    }
    
    // metodo para crear y guardar el automovil
    @Override
    public void creacionYguardadoAutomovil(String... str)
    {
        
      String Aplaca = str[1];
      String Aservicio = str[2];
      String marca = str[3];
      String modelo = str[4];
      String combustible = str[5];
     
      LocalDateTime Aentrada = LocalDateTime.now();
      LocalDateTime Asalida = null;
      double tarifa = 6000.0;
      boolean descuentoA = false;
      
      Automovil nuevo_vehiculo = new Automovil(Aplaca,Aservicio,Aentrada,Asalida,tarifa,descuentoA
              ,combustible,modelo,marca);
      vehiculos.add(nuevo_vehiculo);
        System.out.println("Guardado!");
    }  
    
    // metodo para crear y guardar la motocicleta
    @Override
    public void creacionYguardadoMotocicleta(String... str)
    {
      String Mplaca = str[1];
      String Mservicio =  str[2];
      String tipo = str[3];
      int cilindraje = Integer.parseInt(str[4]);
      
      LocalDateTime Mentrada = LocalDateTime.now();
      LocalDateTime Msalida = null;
      double tarifa = 3000.0;
      boolean descuento = false;
      
      Motocicleta nuevo_vehiculo = new Motocicleta(Mplaca,Mservicio,tarifa,descuento,
              Mentrada,Msalida,cilindraje,tipo);
      vehiculos.add(nuevo_vehiculo);
      System.out.println("Guardado!");
    } 
    
    
    // metodo para crear y guardar el camion
    @Override
    public void creacionYguardadoCamion(String... str)
    {
      String Cplaca = str[1];
      String Cservicio = str[2];
      int ejes = Integer.parseInt(str[3]);
      double capacidad = Double.parseDouble(str[4]);
      
      
      LocalDateTime Centrada = LocalDateTime.now();
      LocalDateTime Csalida = null;
      double Ctarifa = 6000.0;
      boolean Cdescuento = false;
      
      Camion nuevo_vehiculo = new Camion(Cplaca,Cservicio,Ctarifa,Cdescuento,
              Centrada,Csalida,capacidad,ejes);
      vehiculos.add(nuevo_vehiculo);
      System.out.println("Guardado!");
    }
}