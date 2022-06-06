package Fase3.Pruebas;

import Fase3.Produccion.BusinessFlight;
import Fase3.Produccion.EconomyFlight;
import Fase3.Produccion.Flight;
import Fase3.Produccion.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AirportTest {

   // Refactorización de la clase AirportTest. Pregunta 3
    private Flight claseEconomica; //Se crea una variaable de tipo Flight
    private Passenger pasajero1; //se crea dos variables  de  tipo pasajero
    private Passenger pasajero2;
   //notación se usa para indicar que el método anotado debe ejecutarse antes de cada invocación del método @Test 
    @BeforeEach

    public void setup(){
        claseEconomica = new EconomyFlight("1");//Se crea y se instancia una variable de tipo EconmyFlight
        pasajero1 = new Passenger("Hamer",false);//de la misma manera se crea y se instancia  varibales de tipo Passenger
        pasajero2 = new Passenger("Franklin", true);
    }
    //La clase anidada se coloca dentro de otra clase y se organiza en una estructura jerárquica
    @Nested
    class ClaseRegular{
        @Test
        public void  testEconomyFlightRegularPassenger(){
           //Se inician las pruebas de cada uno de los metodos que se encuentran implementadas en la carpeta de prodccion para verificar su correcto funcionamiento
            assertEquals("1",claseEconomica.getId());
            assertEquals(true,claseEconomica.addPassenger(pasajero1));
            assertEquals(1,claseEconomica.getPassengersList().size());
            assertEquals("Hamer",claseEconomica.getPassengersList().get(0).getName());
            assertEquals(true,claseEconomica.removePassenger(pasajero1));
            assertEquals(0,claseEconomica.getPassengersList().size());
        }
    }
    @Nested
    class ClaseVip{
        @Test
        public void testEconomyFlightVipPassenger(){
            assertEquals("1",claseEconomica.getId());
            assertEquals(true,claseEconomica.addPassenger(pasajero2));
            assertEquals(1,claseEconomica.getPassengersList().size());
            assertEquals("Franklin",claseEconomica.getPassengersList().get(0).getName());
            assertEquals(false,claseEconomica.removePassenger(pasajero2));
            assertEquals(1,claseEconomica.getPassengersList().size());

        }
    }
    @Nested
    class TestBusinessFlight{
        private Flight pasajeroNegocio;
        private Passenger pasajero3;
        private Passenger pasajero4;
        @BeforeEach
        public void setUp(){
            pasajeroNegocio = new BusinessFlight("2");
            pasajero3 = new Passenger("Jara", true);
            pasajero4 = new Passenger("Ocas", false);
        }
        @Nested
        class ClaseRegular{
            @Test
            public void  testEconomyFlightVipPassenger(){

                assertEquals(true,pasajeroNegocio.addPassenger(pasajero3));
                assertEquals(1,pasajeroNegocio.getPassengersList().size());

                assertEquals(false,pasajeroNegocio.removePassenger(pasajero3));
                assertEquals(1,pasajeroNegocio.getPassengersList().size());
            }
        }
        @Nested
        class ClaseVip{
            @Test
            public void  testEconomyFlightRegularPassenger(){

                assertEquals(false,pasajeroNegocio.addPassenger(pasajero4));
                assertEquals(0,pasajeroNegocio.getPassengersList().size());

                assertEquals(false,pasajeroNegocio.removePassenger(pasajero4));
                assertEquals(0,pasajeroNegocio.getPassengersList().size());
            }
        }
    }

}
