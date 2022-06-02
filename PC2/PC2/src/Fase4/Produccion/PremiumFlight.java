package Fase4.Produccion;

public class PremiumFlight extends Flight {
    public PremiumFlight(String id) {
        super(id);
    }

    @Override
    public boolean addPassenger(Passenger passenger) {
        return false;
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        return false;
    }

    // Diseño inicial de la clase  PremiumFlight. Pregunta 5

}

