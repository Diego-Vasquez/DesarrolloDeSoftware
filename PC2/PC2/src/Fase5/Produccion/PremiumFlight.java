package Fase5.Produccion;

public class PremiumFlight extends Flight {
    public PremiumFlight(String id) {
        super(id);
    }

    /**
     * @param passenger
     * @return
     */
    @Override
    public boolean addPassenger(Passenger passenger) {

        /**
         * Si el pasajero es VIP se podria hacer la operación de añadir al pasajero
         * usando su metodo add, que devolverá un booleano indicando como se
         * realizo la operación, el cual a su ves retornaria este metodo,
         * además, si se ve que el pasajero no es VIP el método devolvería false.
         */

        if (passenger.isVip()) {
            return passengers.add(passenger);
        }
        return false;
    }

    /**
     * @param passenger
     * @return
     */
    @Override
    public boolean removePassenger(Passenger passenger) {

        /**
         * De forma similar al anterior método, primero se verifica que el
         * pasajero a remover sea vip, si es así se procede a remover
         * y se procede a usar el metodo remove de passenger que
         * intentará realizar la remoción del pasajero y devolverá un
         * booleano indicando si se pudo o no realizar, si se ve que no es
         * VIP, tambien devolverá un FALSE
         */
        if (passenger.isVip()) {
            return passengers.remove(passenger);
        }
        return false;
    }

    // Diseño de la lógica comercial para los pasajeros VIP.Pregunta 7
}