package AirportTowerSimulator;
import java.util.LinkedList;
import java.util.Queue;

public class ControlTower implements TowerMediator {
    private Queue<Aircraft> landingQueue = new LinkedList<>();
    private Queue<Aircraft> takeOffQueue = new LinkedList<>();
    private boolean runwayAvailable = true;

    @Override
    public void broadcast(String msg, Aircraft sender) {
        System.out.println(sender.getClass().getSimpleName() + " " + sender.id + " говорит: " + msg);
    }

    @Override
    public boolean requestRunway(Aircraft aircraft) {
        if (runwayAvailable) {
            System.out.println(aircraft.id + " получает разрешение на использование полосы.");
            runwayAvailable = false;
            return true;
        } else {
            System.out.println(aircraft.id + " ожидает освобождения полосы.");
            landingQueue.add(aircraft);
            return false;
        }
    }

    public void releaseRunway() {
        runwayAvailable = true;
        System.out.println("Полоса освободилась.");
        if (!landingQueue.isEmpty()) {
            Aircraft next = landingQueue.poll();
            requestRunway(next);
        }
    }
}

