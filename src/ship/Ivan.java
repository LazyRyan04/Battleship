package ship;

import ship.Ship;

public class Ivan extends Ship
  {
    public Ivan()
    {
      super(0);
    }

    @Override
    public boolean isSunk() 
    {
      return false; //IVAN CAN NEVER SINK!!!
    }
  }