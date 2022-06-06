package Fase4.Pruebas;

import Fase4.Produccion.*;
import Fase4.Produccion.BusinessFlight;
import Fase4.Produccion.EconomyFlight;
import Fase4.Produccion.Flight;
import Fase4.Produccion.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AirportTest {

    @DisplayName("Dado que hay un vuelo economico")
    @Nested
    class EconomyFlightTest {

        private Flight economyFlight;
        private Passenger jessica;
        private Passenger cesar;

        @BeforeEach
        void setUp() {
            economyFlight = new EconomyFlight("1");
            jessica = new Passenger("Jessica", false);
            cesar = new Passenger("Cesar", true);
        }

        @Nested
        @DisplayName("Cuando tenemos un pasajero regular")
        class RegularPassenger {

            @Test
            @DisplayName("Luego puede agregarlo y eliminarlo de un vuelo economico")
            public void testEconomyFlightRegularPassenger() {
                assertAll("Verifica todas las condiciones para un pasajero regular y un vuelo economico",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(jessica)),
                        () -> assertEquals(1, economyFlight.getPassengersList().size()),
                        () -> assertEquals("Jessica", economyFlight.getPassengersList().get(0).getName()),
                        () -> assertEquals(true, economyFlight.removePassenger(jessica)),
                        () -> assertEquals(0, economyFlight.getPassengersList().size())
                );
            }
        }

        @Nested
        @DisplayName("Cuando tenemos un pasajero VIP")
        class VipPassenger {
            @Test
            @DisplayName("Luego puedes agregarlo pero no puede eliminarlo de un vuelo economico")
            public void testEconomyFlightVipPassenger() {
                assertAll("Verifica todas las condiciones para un pasajero VIP y un vuelo economico",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(cesar)),
                        () -> assertEquals(1, economyFlight.getPassengersList().size()),
                        () -> assertEquals("Cesar", economyFlight.getPassengersList().get(0).getName()),
                        () -> assertEquals(false, economyFlight.removePassenger(cesar)),
                        () -> assertEquals(1, economyFlight.getPassengersList().size())
                );

            }
        }
    }

    @DisplayName("Dado que hay un vuelo de negocios")
    @Nested
    class BusinessFlightTest {
        private Flight businessFlight;
        private Passenger jessica;
        private Passenger cesar;

        @BeforeEach
        void setUp() {
            businessFlight = new BusinessFlight("2");
            jessica = new Passenger("Jessica", false);
            cesar = new Passenger("Cesar", true);
        }

        @Nested
        @DisplayName("Cuando tenemos un pasajero regular")
        class RegularPassenger {

            @Test
            @DisplayName("Entonces no puede agregarlo o eliminarlo de un vuelo de negocios")
            public void testBusinessFlightRegularPassenger() {
                assertAll("Verifica todas las condiciones para un pasajero regular y un vuelo de negocios",
                        () -> assertEquals(false, businessFlight.addPassenger(jessica)),
                        () -> assertEquals(0, businessFlight.getPassengersList().size()),
                        () -> assertEquals(false, businessFlight.removePassenger(jessica)),
                        () -> assertEquals(0, businessFlight.getPassengersList().size())
                );
            }
        }

        @Nested
        @DisplayName("Cuando tenemos un pasajero VIP")
        class VipPassenger {

            @Test
            @DisplayName("Luego puedes agregarlo pero no puedes eliminarlo de un vuelo de negocios")
            public void testBusinessFlightVipPassenger() {
                assertAll("Verifica todas las condiciones para un pasajero VIP y un vuelo de negocios",
                        () -> assertEquals(true, businessFlight.addPassenger(cesar)),
                        () -> assertEquals(1, businessFlight.getPassengersList().size()),
                        () -> assertEquals(false, businessFlight.removePassenger(cesar)),
                        () -> assertEquals(1, businessFlight.getPassengersList().size())
                );
            }
        }
    }
// Completa la prueba para PremiumFlight de acuerdo a la logica comercial dada. Pregunta 6

    @DisplayName("Dado que hay un vuelo premium")
    @Nested
    //Declaramos la clase PremiumFlightTest
    class PremiumFlightTest {
        //Creamos objetos de la clase vuelo y pasajeros
        private Flight premiumFlight;
        private Passenger jessica;
        private Passenger cesar;   
        
        @BeforeEach
        void setUp() {
            //preparamos los objetos para las pruebas
            premiumFlight = new PremiumFlight("3");
            jessica = new Passenger("Jessica", false);
            cesar = new Passenger("Cesar", true);
        }
        
        @Nested
        //La anotación JUnit @DisplayName se usa para proporcionar un nombre personalizado para la clase de prueba y los métodos de prueba. 
        @DisplayName("Cuando tenemos un pasajero regular")
        //Declaramos una clase aninada RegularPassenger
        class RegularPassenger {
            
            //insertamos una prueba
            @Test
            //especificamos los test con JUnit5 usando Displayname
            @DisplayName("Entonces no puedes agregarlo o quitarlo de un vuelo premium")
            public void testPremiumFlightRegularPassenger() {
                //usamos el metodo assertAll para verificar multiples condiciones para un vuelo premium y un pasajero regular 
                assertAll("Verifica todas las condiciones para un pasajero regular y un vuelo premium",
                        //Comprobamos que no puedemos agregar un pasajero a un vuelo premium. 
                        () -> assertEquals(false, premiumFlight.addPassenger(jessica)),
                        //Comprobamos que intentar agregar un pasajero no cambia el tamaño de la lista de pasajeros.
                        () -> assertEquals(0, premiumFlight.getPassengersList().size()),
                        //Comprobamos que no podemos eliminar un pasajero de un vuelo premium.
                        () -> assertEquals(false, premiumFlight.removePassenger(jessica)),
                        //Comprobamos que intentar eliminar un pasajero no cambia el tamaño de la lista de pasajeros.
                        () -> assertEquals(0, premiumFlight.getPassengersList().size())
                );
            }
        }
        
        @Nested
        @DisplayName("Cuando tenemos un pasajero VIP")
        class VipPassenger {
            
            //Insertamos otra prueba de un vuelo premium y pasajero vip
            @Test
            @DisplayName("Luego puede agregarlo y eliminarlo de un vuelo premium")
            public void testPremiumFlightVipPassenger() {
                //usamos otra vez asserAll
                assertAll("Verifica todas las condiciones para un pasajero VIP y un vuelo premium",
                        //Compropbamos que podemos agregar un pasajero a un vuelo premium.
                        () -> assertEquals(true, premiumFlight.addPassenger(cesar
                        //Comprobamos que al agregar pasajeros aumenta el tamaño de la lista de pasajeros.
                        () -> assertEquals(1, premiumFlight.getPassengersList().size()),
                        //Comprobamos que podemos eliminar un pasajero de un vuelo premium.
                        () -> assertEquals(true, premiumFlight.removePassenger(cesar)),
                        //Comprobamos que al eliminar pasajeros disminuye el tamao de la lista de pasajeros.
                        () -> assertEquals(0, premiumFlight.getPassengersList().size())
                );
            }
        }
    }
}
