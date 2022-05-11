import ship.Ship;
import status.DotStatus;
import status.ShipStatus;
import status.Status;

public class main
{
    public static void main(String[] args)
    {
        Ship USSIvan = new Ship();
        Status status = new ShipStatus(USSIvan);

        if (status instanceof ShipStatus)
            System.out.println("hit ship");
        else
        {
                if (status == DotStatus.EMPTY)
                    System.out.println("empty");
                if (status == DotStatus.HIT)
                    System.out.println("already hit");
                if (status == DotStatus.MISS)
                    System.out.println("miss");
        }
    }
}
