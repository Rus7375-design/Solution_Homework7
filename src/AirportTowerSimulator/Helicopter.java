package AirportTowerSimulator;
public class Helicopter extends Aircraft {
    public Helicopter(String id) {
        super(id);
    }

    @Override
    public void receive(String msg) {
        System.out.println("Вертолёт " + id + " получил сообщение: " + msg);
    }
}

