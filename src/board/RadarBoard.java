package board;

public class RadarBoard extends Board
{
    public RadarBoard(int sizeX, int sizeY)
    {
        super(sizeX, sizeY);
    }

    @Override
    public boolean setStatus(int coordX, int coordY, DotStatus value)
    {
        switch (value)
        {
            case HIT:
            case MISS:
                super.setStatus(coordX, coordY, value);
                return true;
            default:
                return false;
        }
    }
}
