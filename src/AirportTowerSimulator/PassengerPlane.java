package AirportTowerSimulator;
public class PassengerPlane extends Aircraft {
    public PassengerPlane(String id) {
        super(id);
    }

    @Override
    public void receive(String msg) {
        System.out.println("Пассажирский самолет " + id + " получил сообщение: " + msg);
    }
}

