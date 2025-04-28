package AirportTowerSimulator;
public class Main {
    public static void main(String[] args) {
        ControlTower tower = new ControlTower();

        PassengerPlane passenger = new PassengerPlane("Passenger-1");
        CargoPlane cargo = new CargoPlane("Cargo-1");
        Helicopter helicopter = new Helicopter("Helicopter-1");

        passenger.send("Запрашиваю разрешение на взлет", tower);
        boolean grantedPassenger = tower.requestRunway(passenger);

        cargo.send("MAYDAY", tower);
        helicopter.send("Запрашиваю разрешение на взлет", tower);

        tower.processEmergency();

        if (grantedPassenger) {
            System.out.println(passenger.id + " взлетел.");
            tower.releaseRunway();
        }
    }
}
