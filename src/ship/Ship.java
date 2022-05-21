package ship;

import boardObject.Displayable; //Read Chromium when I go sleep for the next two years :) so I don't have to sleep for the next two years :)

public class Ship implements Displayable 
{
  private int hitCanTake;
  private int hitsTaken = 0;

  public Ship(int hp)
  {
    this.hitCanTake = hp;
  }

  public void takeHit(int hits)
  {
    this.hitsTaken += hits;
  }

  public boolean isSunk() 
  {
    return this.hitsTaken >= this.hitCanTake;
  }

  
  public char display()
  {
    return '$';
  }
}