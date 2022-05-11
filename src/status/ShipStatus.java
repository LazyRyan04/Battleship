package status;

import ship.Ship;

public class ShipStatus implements Status {
    private Ship ship;

    public ShipStatus(Ship ship)
    {
        this.ship = ship;
    }

    @Override
    public Ship getShip() {
        return ship;
    }
}
