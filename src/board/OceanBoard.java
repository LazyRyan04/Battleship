package board;

import boardObject.BoardObject;
import boardObject.Displayable;
import coordinates.Range;

public class OceanBoard extends Board
{
  public OceanBoard(int sizeX, int sizeY)
  {
      super(sizeX, sizeY);
  }

  public boolean addObject(BoardObject object)
  {
    Range a = object.getBounds();
    Displayable b = object.getValue();
    
    if(this.checkRange(a))
    {
      this.fillRange(a, b);
      return true;
    }
    return false;
  }


}
