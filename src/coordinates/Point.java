package coordinates;

public class Point
{
    private final int x;
    private final int y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX() 
    {
        return this.x;
    }

    public int getY() 
    {
        return this.y;
    }

    public Point addPoint(Point z)
    {
      return new Point(this.getX() + z.getX(), this.getY() + z.getY());    
    }
}
