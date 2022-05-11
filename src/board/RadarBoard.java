package board;

import boardObject.BoardObject;
import boardObject.DotStatus;

public class RadarBoard extends Board
{
    public RadarBoard(int sizeX, int sizeY)
    {
        super(sizeX, sizeY);
    }

    @Override
    public boolean setStatus(int coordX, int coordY, BoardObject value)
    {
        if (value == DotStatus.HIT || value == DotStatus.MISS)
        {
            super.setStatus(coordX, coordY, value);
            return true;
        }

        return false;
    }
}
