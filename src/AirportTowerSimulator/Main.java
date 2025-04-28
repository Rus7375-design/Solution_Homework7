package AirportTowerSimulator;
public class Main {
    public static void main(String[] args) {
        ControlTower tower = new ControlTower();
        PassengerPlane plane1 = new PassengerPlane("Plane-1");
        PassengerPlane plane2 = new PassengerPlane("Plane-2");

        plane1.send("Запрашиваю разрешение на взлет", tower);
        boolean granted1 = tower.requestRunway(plane1);

        plane2.send("Запрашиваю разрешение на взлет", tower);
        boolean granted2 = tower.requestRunway(plane2);

        if (granted1) {
            System.out.println(plane1.id + " взлетел.");
            tower.releaseRunway();
        }
    }
}
