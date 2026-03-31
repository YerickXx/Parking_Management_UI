/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import Entities.Automovil;
import Entities.Camion;
import Entities.Motocicleta;
import Entities.Vehiculo;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import Data.Data;

/**
 *
 * @author yeric
 */
public class Logic_Objetos implements Interfaces.manejoObjetos {
        Data d = new Data();
        public List<Vehiculo> vehiculos = new ArrayList<>();
    
    // variables con valores para no tenerlas harcodeadas
    double  tarifaDiaAutomovil = 5000.0;
    double  tarifaDiaCamion = 5000.0;
    double tarifaDiaMotocicleta = 3000.0;
    double tarifaHoraAuto = 600.0;
    double tarifaHoraCamion = 600.0;
    double tarifaHoraMotocicleta = 500.0;
    
     // Metodo para crear vehiculos 
    @Override
    public void creacionVehiculos(String... str) {
        if (str.length == 0) // validacion de input vacio
        {
            return;
        }
        String type = str[0]; // tomar el valor de la poscicion 0 del 

            switch (type) {
                case "Automovil" -> {
                    if (str[1].equalsIgnoreCase("Por dia")) {
                        creacionYguardadoAutomovil(str);
                    } else {
                        creacionYguardadoAutomovilHora(str);
                    }
                }

                case "Motocicleta" -> {
                    if (str[1].equalsIgnoreCase("Por dia")) {
                        creacionYguardadoMotocicleta(str);
                    } else {
                        creacionYguardadoMotocicletaHora(str);
                    }
                }

                case "Camion" -> {
                    if (str[1].equalsIgnoreCase("Por dia")) {
                        creacionYguardadoCamion(str);
                    } else {
                        creacionYguardadoCamionHora(str);
                    }
                }
            }
        

    }
       // metodo para crear y guardar el automovil
    @Override
    public void creacionYguardadoAutomovil(String... str) {

        String Aplaca = str[1];
        String Aservicio = str[2];
        String marca = str[3];
        String modelo = str[4];
        String combustible = str[5];

        LocalDateTime Aentrada = LocalDateTime.now().withNano(0).withSecond(0); // eliminar milisegundos y segundos
        LocalDateTime Asalida = null;
        double tarifa = tarifaDiaAutomovil;
        boolean descuentoA = false;

        Automovil nuevo_vehiculo = new Automovil(Aplaca, Aservicio, Aentrada, Asalida, tarifa, descuentoA,
                combustible, modelo, marca);
        vehiculos.add(nuevo_vehiculo);
        GuardarVehiculos(vehiculos);
    }

    @Override
    public void creacionYguardadoAutomovilHora(String... str) {
        String Aplaca = str[1];
        String Aservicio = str[2];
        String marca = str[3];
        String modelo = str[4];
        String combustible = str[5];

        LocalDateTime Aentrada = LocalDateTime.now().withNano(0).withSecond(0);
        LocalDateTime Asalida = null;
        double tarifa = tarifaHoraAuto;
        boolean descuentoA = false;

        Automovil nuevo_vehiculo = new Automovil(Aplaca, Aservicio, Aentrada, Asalida, tarifa, descuentoA,
                combustible, modelo, marca);
        vehiculos.add(nuevo_vehiculo);
        GuardarVehiculos(vehiculos);
    }

    @Override
    public void creacionYguardadoMotocicletaHora(String... str) {
        String Mplaca = str[1];
        String Mservicio = str[2];
        String tipo = str[4];
        int cilindraje = Integer.parseInt(str[3]);

        LocalDateTime Mentrada = LocalDateTime.now().withNano(0).withSecond(0);
        LocalDateTime Msalida = null;
        double tarifa = tarifaHoraMotocicleta;
        boolean descuento = false;

        Motocicleta nuevo_vehiculo = new Motocicleta(Mplaca, Mservicio, tarifa, descuento,
                Mentrada, Msalida, cilindraje, tipo);
        vehiculos.add(nuevo_vehiculo);
        GuardarVehiculos(vehiculos);
    }

    // metodo para crear y guardar la motocicleta
    @Override
    public void creacionYguardadoMotocicleta(String... str) {
        String Mplaca = str[1];
        String Mservicio = str[2];
        String tipo = str[4];
        int cilindraje = Integer.parseInt(str[3]);

        LocalDateTime Mentrada = LocalDateTime.now().withNano(0).withSecond(0);
        LocalDateTime Msalida = null;
        double tarifa = tarifaDiaMotocicleta;
        boolean descuento = false;

        Motocicleta nuevo_vehiculo = new Motocicleta(Mplaca, Mservicio, tarifa, descuento,
                Mentrada, Msalida, cilindraje, tipo);
        vehiculos.add(nuevo_vehiculo);
        GuardarVehiculos(vehiculos);
    }

    // metodo para crear y guardar el camion
    @Override
    public void creacionYguardadoCamion(String... str) {
        String Cplaca = str[1];
        String Cservicio = str[2];
        int ejes = Integer.parseInt(str[4]);
        double capacidad = Double.parseDouble(str[3]);

        LocalDateTime Centrada = LocalDateTime.now().withNano(0).withSecond(0);
        LocalDateTime Csalida = null;
        boolean Cdescuento = false;
        double Ctarifa = tarifaDiaCamion;
        Camion nuevo_vehiculo = new Camion(Cplaca, Cservicio, Ctarifa, Cdescuento,
                Centrada, Csalida, capacidad, ejes);
        vehiculos.add(nuevo_vehiculo);
        GuardarVehiculos(vehiculos);
    }

    @Override
    public void creacionYguardadoCamionHora(String... str) {
        String Cplaca = str[1];
        String Cservicio = str[2];
        int ejes = Integer.parseInt(str[4]);
        double capacidad = Double.parseDouble(str[3]);

        LocalDateTime Centrada = LocalDateTime.now().withNano(0).withSecond(0);
        LocalDateTime Csalida = null;
        boolean Cdescuento = false;
        double Ctarifa = tarifaHoraCamion;
        Camion nuevo_vehiculo = new Camion(Cplaca, Cservicio, Ctarifa, Cdescuento,
                Centrada, Csalida, capacidad, ejes);
        vehiculos.add(nuevo_vehiculo);
        GuardarVehiculos(vehiculos);
    }

    @Override
    public void GuardarVehiculos(List<Vehiculo> vehiculo) {
        d.GuardarVehiculo(vehiculo);
    }
    
    
    public String MostrarVehiculos() {
        String contenido = "";
        d.LeerVehiculo();
        if (!d.leidos.isEmpty()) {
            for (var s : d.leidos) {
                contenido += s.toString() + "\n";
            }
            return contenido;
        }
        return "";
    }
}
