package boardObject;

import coordinates.Range;
import coordinates.RotationDirection;
import coordinates.Point;

public class BoardObject implements Displayable
{
    private Displayable value;
    private Range bounds;

    public BoardObject(Displayable value, Range bounds)
    {
        this.value = value;
        this.bounds = bounds;
    }

    public Range getBounds()
    {
        return this.bounds;
    }

    public Displayable getValue()
    {
        return value;
    }

    public char display()
    {
        return value.display();
    }

    public void moveObject(Point z)
    {
      this.bounds = this.bounds.addPoint(z);
    }

    public void rotateObject(RotationDirection a)
    {
      switch(a)
      {
       case CCW:
         this.bounds = this.bounds.rotateCCW();
         break;
    
       case CW:
         this.bounds = this.bounds.rotateCW();
         break;
          
      }     
    }
}
