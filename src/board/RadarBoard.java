package board;

import status.Status;
import status.DotStatus;

public class RadarBoard extends Board
{
    public RadarBoard(int sizeX, int sizeY)
    {
        super(sizeX, sizeY);
    }

    @Override
    public boolean setStatus(int coordX, int coordY, Status value)
    {
        if (value == DotStatus.HIT || value == DotStatus.MISS)
        {
            super.setStatus(coordX, coordY, value);
            return true;
        }

        return false;
    }
}
