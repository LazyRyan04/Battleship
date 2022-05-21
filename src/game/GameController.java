package game;

import ship.ShipFactory;
import ship.ShipFactory.ShipTypes;
import ship.Ship;
import boardObject.Displayable;
import game.Player;
import board.*;
import coordinates.*;
import boardObject.*;
import boardObject.BoardObject;

public class GameController
{
  private Player p1;
  private Player p2;
  private static GameController instance;

  private GameController(Player a, Player b)
  {
    this.p1 = a;
    this.p2 = b;
  }

  public GameController getInstance()
  {
    return instance;
  }
  
  public synchronized static GameController init(int size)
  {
    if(instance == null)
    {
      return null;
    }
    
    instance = new GameController(
       new Player(new OceanBoard(size, size), new RadarBoard(size, size)), 
       new Player(new OceanBoard(size, size), new RadarBoard(size, size))
    );
    return instance;
  }

  
  public boolean player1Attack(Point z) //if return false, in main class, recall the method or smthng
  //returns ship which will then be tested to see if the ship sunk
  {
    Displayable a = p2.takeHit(z);
    
    if(a == null)
    {
      return false;
    }
    
    
    if(a instanceof Ship)
    {   
      p1.updateRadar(z, Status.HIT);
      Ship b = (Ship) a;
      b.takeHit(1);
      
      if(b.isSunk())
      {
        p1.sunkShip();
      }
        //might change this 1 later
      return true; 
    }

    if(a == Status.EMPTY)
    {
      p1.updateRadar(z, Status.MISS);
      return true;
    }

    return false;
  }



  public boolean player2Attack(Point z) 
  {
    Displayable a = p1.takeHit(z);
    
    if(a == null)
    {
      return false;
    }
    
    
    if(a instanceof Ship)
    {   
      p2.updateRadar(z, Status.HIT);
      Ship b = (Ship) a;
      b.takeHit(1);
      
      if(b.isSunk())
      {
        p1.sunkShip();
      }
        //might change this 1 later
      return true; 
    }

    if(a == Status.EMPTY)
    {
      p2.updateRadar(z, Status.MISS);
      return true;
    }

    return false;
  }


  public String p1SeeOBoard()
  {
    return p1.getOceanBoard().toString();
  }

  public String p2SeeOBoard()
  {
    return p2.getOceanBoard().toString();
  }

  public String p1SeeRBoard()
  {
    return p1.getRadarBoard().toString();
  }

  public String p2SeeRBoard()
  {
    return p2.getRadarBoard().toString();
  }

  public boolean player1PutShip(ShipTypes type, int coordX, int coordY, RotationDirection rotate) 
  {
    BoardObject a = ShipFactory.createShip(type);
    Point p = new Point(coordX, coordY);

    a.moveObject(p);
    
    switch(rotate)
    {
      case CCW:
        a.rotateObject(RotationDirection.CCW);
        break;

      case CW:
        a.rotateObject(RotationDirection.CW);
        break;

      default:
        break;
    }
    
    return p1.getOceanBoard().addObject(a);
  }

  
  public boolean player2PutShip(ShipTypes type, int coordX, int coordY, RotationDirection rotate) 
  {
    BoardObject a = ShipFactory.createShip(type);
    Point p = new Point(coordX, coordY);

    a.moveObject(p);
    
    switch(rotate)
    {
      case CCW:
        a.rotateObject(RotationDirection.CCW);
        break;

      case CW:
        a.rotateObject(RotationDirection.CW);
        break;

      default:
        break;
    }
    
    return p2.getOceanBoard().addObject(a);
  }
  
}