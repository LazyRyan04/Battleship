package board;

public abstract class Board
{
    //fields
    private DotStatus[][] statuses;

    //methods
    public Board(int sizeX, int sizeY)
    {
        this.statuses = new DotStatus[sizeX][sizeY];
    }

    public DotStatus getStatus(int coordX, int coordY)
    {
        //guard clauses should be here
        DotStatus status = this.statuses[coordX][coordY];

        return status == null ? DotStatus.EMPTY : status; //return empty if null
    }

    public boolean setStatus(int coordX, int coordY, DotStatus value)
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
