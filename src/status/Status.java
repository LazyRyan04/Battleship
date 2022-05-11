package status;

import ship.Ship;

public interface Status {
    default Ship getShip() {
        return null;
    }
}

