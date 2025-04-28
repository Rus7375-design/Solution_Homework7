package AirportTowerSimulator;
public abstract class Aircraft {
    protected String id;

    public Aircraft(String id) {
        this.id = id;
    }

    public void send(String msg, TowerMediator mediator) {
        mediator.broadcast(msg, this);
    }

    public abstract void receive(String msg);
}
