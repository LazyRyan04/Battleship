import board.OceanBoard;
import boardObject.Displayable;
import boardObject.Status;
import coordinates.Point;
import coordinates.Range;

public class main
{
    public static void main(String[] args)
    {
        OceanBoard board = new OceanBoard(20, 10);

        Displayable value = Status.HIT;
        Range range = new Range(new Point(0, 1), new Point(3, 5));

        board.fillRange(range, value);

        System.out.println(board.toString());
    }
}
