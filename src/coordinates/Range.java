package coordinates;

public class Range
{
    private final Point cornerMin;
    private final Point cornerMax;

    public Range(Point corner1, Point corner2)
    {
        int yMin = corner1.getY();
        int yMax = corner2.getY();

        int xMin = corner1.getX();
        int xMax = corner2.getX();

        if (yMax < yMin)
        {
            int y = yMin;
            yMin = yMax;
            yMax = y;
        }
        if (xMax < xMin)
        {
            int x = xMin;
            xMin = xMax;
            xMax = x;
        }

        this.cornerMin = new Point(xMin, yMin);
        this.cornerMax = new Point(xMax, yMax);
    }

    public Point getMinCorner() {
        return cornerMin;
    }

    public Point getMaxCorner() {
        return cornerMax;
    }
}
