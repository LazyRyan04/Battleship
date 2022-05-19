package board;

import boardObject.BoardObject;
import boardObject.Displayable;
import boardObject.Status;
import coordinates.Point;

public class RadarBoard extends Board
{
    public RadarBoard(int sizeX, int sizeY)
    {
        super(sizeX, sizeY);
    }

    public boolean setStatus(Point c, BoardObject val)
    {
        Displayable value = val.getValue();
        if (value == Status.HIT || value == Status.MISS)
        {
            super.setObject(c, val);
            return true;
        }

        return false;
    }
}
