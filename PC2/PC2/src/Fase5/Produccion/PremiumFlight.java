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
        return false;
    }

    /**
     * @param passenger 
     * @return
     */
    @Override
    public boolean removePassenger(Passenger passenger) {
        return false;
    }

    // Diseño de la lógica comercial para los pasajeros VIP.Pregunta 7
}
