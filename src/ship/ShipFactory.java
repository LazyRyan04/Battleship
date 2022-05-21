package ship;

import ship.Ship;
import ship.Ivan;
import coordinates.*;
import boardObject.BoardObject;

public class ShipFactory
{
  public static BoardObject createShip(ShipTypes type)
  {
    switch(type)
    {
      case CARRIER:
        
        return new BoardObject(
          new Ship(5), 
          new Range(new Point(0, 0), new Point(0, 4))
        ); //better organized, and readable

      case BATTLESHIP:

        return new BoardObject(
          new Ship(4),
          new Range(new Point(0,0), new Point(0,3))
        );

      case SUBMARINE:
      case CRUISER:

        return new BoardObject(
          new Ship(3), 
          new Range(new Point(0,0), new Point(0,2))
        );

      case DESTROYER:

        return new BoardObject(
          new Ship(2), 
          new Range(new Point(0,0), new Point(0,1))
        );

      case IVAN:
        
        return new BoardObject(
          new Ivan(),
          new Range(new Point(0,0), new Point(0,1))
        );
        
    }
    return null; 
  }

  

  public enum ShipTypes
  {
    CARRIER,
    BATTLESHIP,
    SUBMARINE,
    CRUISER,
    DESTROYER,
    IVAN,
  }
}