package AirportTowerSimulator;
import java.util.LinkedList;
import java.util.Queue;

public class ControlTower implements TowerMediator {
    private Queue<Aircraft> landingQueue = new LinkedList<>();
    private Queue<Aircraft> takeOffQueue = new LinkedList<>();
    private Queue<Aircraft> emergencyQueue = new LinkedList<>();

    private boolean runwayAvailable = true;
    private boolean emergencyInProgress = false;


    @Override
    public void broadcast(String msg, Aircraft sender) {
        if (msg.equalsIgnoreCase("MAYDAY")) {
            emergencyInProgress = true;
            handleEmergency(sender);
        } else {
            System.out.println(sender.getClass().getSimpleName() + " " + sender.id + " говорит: " + msg);
        }
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

        if (emergencyInProgress) {
            processEmergency();
            emergencyInProgress = !emergencyQueue.isEmpty();
        } else if (!landingQueue.isEmpty()) {
            Aircraft next = landingQueue.poll();
            requestRunway(next);
        } else if (!takeOffQueue.isEmpty()) {
            Aircraft next = takeOffQueue.poll();
            requestRunway(next);
        }
    }

    public void handleEmergency(Aircraft aircraft) {
        System.out.println("АВАРИЯ! " + aircraft.id + " требует немедленной посадки!");
        emergencyQueue.add(aircraft);
        for (Aircraft waiting : landingQueue) {
            waiting.receive("Внимание! Аварийная ситуация! Ожидайте команды от башни.");
        }
        for (Aircraft waiting : takeOffQueue) {
            waiting.receive("Внимание! Аварийная ситуация! Ожидайте команды от башни.");
        }
    }

    public void processEmergency() {
        if (!emergencyQueue.isEmpty() && runwayAvailable) {
            Aircraft emergencyAircraft = emergencyQueue.poll();
            System.out.println(emergencyAircraft.id + " немедленно садится!");
            runwayAvailable = false;
        }
    }
}