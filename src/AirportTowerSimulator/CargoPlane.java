package AirportTowerSimulator;
public class CargoPlane extends Aircraft {
    public CargoPlane(String id) {
        super(id);
    }

    @Override
    public void receive(String msg) {
        System.out.println("Грузовой самолёт " + id + " получил сообщение: " + msg);
    }
}

