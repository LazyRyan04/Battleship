package board;

import boardObject.BoardObject;
import boardObject.DotStatus;

public abstract class Board
{
    //fields
    private final BoardObject[][] statuses;

    //methods
    public Board(int sizeX, int sizeY)
    {
        this.statuses = new BoardObject[sizeX][sizeY];
    }

    public BoardObject getStatus(int coordX, int coordY)
    {
        //guard clauses should be here
        BoardObject status = this.statuses[coordX][coordY];

        return status == null ? DotStatus.EMPTY : status; //return empty if null
    }

    public boolean setStatus(int coordX, int coordY, BoardObject value)
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
