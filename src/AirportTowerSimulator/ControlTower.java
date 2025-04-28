package AirportTowerSimulator;
public class ControlTower implements TowerMediator {
    @Override
    public void broadcast(String msg, Aircraft sender) {
        System.out.println(sender.getClass().getSimpleName() + " " + sender.id + " говорит: " + msg);
    }
}

