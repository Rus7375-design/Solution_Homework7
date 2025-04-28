package AirportTowerSimulator;

import java.util.*;
import java.util.concurrent.*;

public class AirportSimulation {
    private static final Random random = new Random();
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) {
        ControlTower tower = new ControlTower();

        List<Aircraft> aircrafts = Arrays.asList(
                new PassengerPlane("Boeing-747"),
                new CargoPlane("Cargolux-123"),
                new Helicopter("Chopper-77"),
                new PassengerPlane("Airbus-A320"),
                new CargoPlane("FedEx-999")
        );
        scheduler.scheduleAtFixedRate(() -> {
            Aircraft selected = aircrafts.get(random.nextInt(aircrafts.size()));

            if (random.nextInt(10) == 0) {
                selected.send("MAYDAY", tower);
                tower.processEmergency();
            } else {
                selected.send("Запрашиваю разрешение на взлет/посадку", tower);
                tower.requestRunway(selected);
            }
        }, 0, 1, TimeUnit.SECONDS);

        scheduler.schedule(() -> {
            System.out.println("\n*** Завершаем симуляцию аэропорта ***");
            scheduler.shutdown();
        }, 20, TimeUnit.SECONDS);
    }
}
