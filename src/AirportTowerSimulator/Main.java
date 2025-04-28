package AirportTowerSimulator;
public class Main {
    public static void main(String[] args) {
        ControlTower tower = new ControlTower();

        PassengerPlane passenger = new PassengerPlane("Passenger-1");
        CargoPlane cargo = new CargoPlane("Cargo-1");
        Helicopter helicopter = new Helicopter("Helicopter-1");

        passenger.send("Запрашиваю разрешение на взлет", tower);
        boolean grantedPassenger = tower.requestRunway(passenger);

        cargo.send("Запрашиваю разрешение на взлет", tower);
        boolean grantedCargo = tower.requestRunway(cargo);

        helicopter.send("Запрашиваю разрешение на взлет", tower);
        boolean grantedHelicopter = tower.requestRunway(helicopter);

        if (grantedPassenger) {
            System.out.println(passenger.id + " взлетел.");
            tower.releaseRunway();
        }
        if (grantedCargo) {
            System.out.println(cargo.id + " взлетел.");
            tower.releaseRunway();
        }
    }
}
