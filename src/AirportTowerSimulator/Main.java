package AirportTowerSimulator;

public class Main {
    public static void main(String[] args) {
        ControlTower tower = new ControlTower();

        PassengerPlane passenger = new PassengerPlane("Passenger-1");
        CargoPlane cargo = new CargoPlane("Cargo-1");
        Helicopter helicopter = new Helicopter("Helicopter-1");
        passenger.send("Запрашиваю разрешение на взлёт", tower);
        if (tower.requestRunway(passenger)) {
            System.out.println(passenger.id + " взлетает...");
            tower.releaseRunway();
        }

        cargo.send("MAYDAY", tower);
        tower.processEmergency();

        helicopter.send("Запрашиваю разрешение на взлёт", tower);
        if (tower.requestRunway(helicopter)) {
            System.out.println(helicopter.id + " взлетает...");
            tower.releaseRunway();
        }
    }
}
