package AirportTowerSimulator;
public class Main {
    public static void main(String[] args) {
        ControlTower tower = new ControlTower();
        PassengerPlane plane1 = new PassengerPlane("Plane-1");

        plane1.send("Запрашиваю разрешение на взлет", tower);
    }
}
