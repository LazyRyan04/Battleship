package board;

import status.Status;
import status.DotStatus;

public abstract class Board
{
    //fields
    private Status[][] statuses;

    //methods
    public Board(int sizeX, int sizeY)
    {
        this.statuses = new Status[sizeX][sizeY];
    }

    public Status getStatus(int coordX, int coordY)
    {
        //guard clauses should be here
        Status status = this.statuses[coordX][coordY];

        return status == null ? DotStatus.EMPTY : status; //return empty if null
    }

    public boolean setStatus(int coordX, int coordY, Status value)
    {
        //guard clauses should be here
        this.statuses[coordX][coordY] = value;
        return true;
    }

    @Override
    public String toString()
    {
        //convert the board to a string

        return "";
    }
}
