package game;

import board.OceanBoard;
import board.RadarBoard;
import coordinates.Point;
import boardObject.Displayable;
import boardObject.Status;
import ship.Ship;

public class Player
{
  private OceanBoard oBoard;
  private RadarBoard rBoard;
  private int shipsSunk;

  public Player(OceanBoard oBoard, RadarBoard rBoard)
  {
    this.oBoard = oBoard;
    this.rBoard = rBoard;
    shipsSunk = 0;
  }

  public OceanBoard getOceanBoard()
  {
    return this.oBoard;
  }

  public RadarBoard getRadarBoard()
  {
    return this.rBoard;
  }

  public Displayable takeHit(Point b)
  {
     if(!this.oBoard.inBounds(b))
    {
      return null;
    }

    Displayable a = this.oBoard.getObject(b);
    
    if(a instanceof Ship)
    {
      this.oBoard.setObject(b, Status.HIT);
    }

    else
    {
      this.oBoard.setObject(b, Status.MISS);
    }

    return a;
  }
  
  public void updateRadar(Point a, Status b) 
  {
    this.rBoard.setStatus(a, b);
  }

  public int getShipsSunk()
  {
    return this.shipsSunk;
  }

  public void sunkShip()
  {
    this.shipsSunk ++;
  }

}