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
    private Flight claseEconomica;
    private Passenger pasajero1;
    private Passenger pasajero2;
    @BeforeEach

    public void setup(){
        claseEconomica = new EconomyFlight("1");
        pasajero1 = new Passenger("Hamer",false);
        pasajero2 = new Passenger("Franklin", true);
    }
    //Se realiza el primer testeo  con una pasajero de clase regular
    @Nested
    class ClaseRegular{
        @Test
        public void  testEconomyFlightRegularPassenger(){
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
