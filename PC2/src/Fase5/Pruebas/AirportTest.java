package Fase5.Pruebas;

import Fase5.Produccion.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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
            @DisplayName("Luegos puedes agregarlo y eliminarlo de un vuelo economico")
            public void testEconomyFlightRegularPassenger() {
                assertAll("Verifica todas las condiciones para un pasajero regular y un vuelo economico",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(jessica)),
                        () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                        () -> assertEquals("Jessica", new ArrayList<>(economyFlight.getPassengersSet()).get(0).getName()),
                        () -> assertEquals(true, economyFlight.removePassenger(jessica)),
                        () -> assertEquals(0, economyFlight.getPassengersSet().size())
                );
            }

            @DisplayName("Entonces no puedes agregarlo a un vuelo económico mas de una vez")
            @RepeatedTest(5)
            public void testEconomyFlightRegularPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
                // Completar el código. Pregunta 8

                /**
                 * Lo que hacemos es intentar añadir a la pasajera Jessica varias veces para testear
                 * que solo debería añadirse una y solo una vez. Luego de esto se procede a verificar
                 * que efectivamente solo fue añadido una sola vez con el asserEquals, también se verifica
                 * que este dentro del vuelo con el assertTrue, y finalmente
                 * que el tercer asserTrue verifica que el primer pasajero tenga el nombre de Jessica
                 * el assetAll verifica que todos sean verdadero y si es asi se pasará la prueba
                 * si alguno es falso, la prueba saldrá como fallida.
                 * Esta prueba corresponde a la pregunta 8 del examen.
                 */
                for (int indice = 0; indice < repetitionInfo.getCurrentRepetition(); indice++) {
                    economyFlight.addPassenger(jessica);
                }
                assertAll("Se verifica que un pasajero normal pueda ser añadido a un vuelo economico solo una vez",
                        () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                        () -> assertTrue(economyFlight.getPassengersSet().contains(jessica)),
                        () -> assertTrue(new ArrayList<>(economyFlight.getPassengersSet()).get(0).getName().equals("Jessica"))
                );
            }
        }

        @Nested
        @DisplayName("Cuando tenemos un pasajero VIP")
        class VipPassenger {
            @Test
            @DisplayName("Luego puedes agregarlo pero no puedes eliminarlo de un vuelo economico")
            public void testEconomyFlightVipPassenger() {
                assertAll("Verifica todas las condiciones para un pasajero VIP y un vuelo economico",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(cesar)),
                        () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                        () -> assertEquals("Cesar", new ArrayList<>(economyFlight.getPassengersSet()).get(0).getName()),
                        () -> assertEquals(false, economyFlight.removePassenger(cesar)),
                        () -> assertEquals(1, economyFlight.getPassengersSet().size())
                );
            }

            @DisplayName("Entonces no puedes agregarlo a un vuelo economico mas de una vez")
            @RepeatedTest(5)
            public void testEconomyFlightVipPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
                for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                    economyFlight.addPassenger(cesar);
                }
                assertAll("Verifica que un pasajero VIP se pueda agregar a un vuelo económico solo una vez",
                        () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                        () -> assertTrue(economyFlight.getPassengersSet().contains(cesar)),
                        () -> assertTrue(new ArrayList<>(economyFlight.getPassengersSet()).get(0).getName().equals("Cesar"))
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
            @DisplayName("Entonces no puedes agregarlo o eliminarlo de un vuelo de negocios")
            public void testBusinessFlightRegularPassenger() {
                assertAll("Verifica todas las condiciones para un pasajero regular y un vuelo de negocios",
                        () -> assertEquals(false, businessFlight.addPassenger(jessica)),
                        () -> assertEquals(0, businessFlight.getPassengersSet().size()),
                        () -> assertEquals(false, businessFlight.removePassenger(jessica)),
                        () -> assertEquals(0, businessFlight.getPassengersSet().size())
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
                        () -> assertEquals(1, businessFlight.getPassengersSet().size()),
                        () -> assertEquals(false, businessFlight.removePassenger(cesar)),
                        () -> assertEquals(1, businessFlight.getPassengersSet().size())
                );
            }

            @DisplayName("Entonces no puedes agregarlo a un vuelo de negocios mas de una vez.")
            @RepeatedTest(5)
            public void testBusinessFlightVipPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
                for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                    businessFlight.addPassenger(cesar);
                }
                assertAll("Verifica que un pasajero VIP se pueda agregar a un vuelo de negocios solo una vez",
                        () -> assertEquals(1, businessFlight.getPassengersSet().size()),
                        () -> assertTrue(businessFlight.getPassengersSet().contains(cesar)),
                        () -> assertTrue(new ArrayList<>(businessFlight.getPassengersSet()).get(0).getName().equals("Cesar"))
                );
            }
        }
    }

    // Recuerda que debes completar esto del ejercicio anterior 6


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
                        () -> assertEquals(0, premiumFlight.getPassengersSet().size()),
                        //Comprobamos que no podemos eliminar un pasajero de un vuelo premium.
                        () -> assertEquals(false, premiumFlight.removePassenger(jessica)),
                        //Comprobamos que intentar eliminar un pasajero no cambia el tamaño de la lista de pasajeros.
                        () -> assertEquals(0, premiumFlight.getPassengersSet().size())
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
                        () -> assertEquals(true, premiumFlight.addPassenger(cesar)),
                        //Comprobamos que al agregar pasajeros aumenta el tamaño de la lista de pasajeros.
                        () -> assertEquals(1, premiumFlight.getPassengersSet().size()),
                        //Comprobamos que podemos eliminar un pasajero de un vuelo premium.
                        () -> assertEquals(true, premiumFlight.removePassenger(cesar)),
                        //Comprobamos que al eliminar pasajeros disminuye el tamao de la lista de pasajeros.
                        () -> assertEquals(0, premiumFlight.getPassengersSet().size())
                );
            }

            @DisplayName("Entonces no puedes agregarlo a un vuelo premium mas de una vez")
            @RepeatedTest(5)
            public void testPremiumFlightVipPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
                for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                    premiumFlight.addPassenger(cesar);
                }
                assertAll("Verifica que un pasajero VIP se pueda agregar a un vuelo premium solo una vez",
                        () -> assertEquals(1, premiumFlight.getPassengersSet().size()),
                        () -> assertTrue(premiumFlight.getPassengersSet().contains(cesar)),
                        () -> assertTrue(new ArrayList<>(premiumFlight.getPassengersSet()).get(0).getName().equals("Cesar"))
                );
            }
        }
    }
}
