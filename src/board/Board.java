package board;

import boardObject.BoardObject;
import boardObject.Displayable;
import boardObject.Status;
import coordinates.Point;
import coordinates.Range;

public abstract class Board
{
    //fields
    private final Displayable[][] objects;

    public Board(int xBound, int yBound)
    {
        this.objects = new Displayable[yBound][xBound];
    }

    public int getHeight()
    {
        return this.objects.length;
    }
    public int getWidth()
    {
        return this.objects[0].length;
    }

    public boolean inBounds(Point c) {
        if (c.getY() >= this.getHeight()) {
            return false;
        }

        return c.getX() < this.getWidth();
    }

    public boolean checkRange(Range range) //maybe shorten this?
    {
        Point minCorner= range.getMinCorner();
        Point maxCorner = range.getMaxCorner();

        boolean hasStuff = false;
        for (int i = minCorner.getY(); i < maxCorner.getY(); ++i)
        {
            for (int j = maxCorner.getX(); j < maxCorner.getX(); ++j)
            {
                if (this.objects[i][j] != null)
                {
                    hasStuff = true;
                    break;
                }
            }
            if (hasStuff)
                break;
        }

        return hasStuff;
    }

    public  void fillRange(Range range, Displayable value)
    {
        Point minCorner= range.getMinCorner();
        Point maxCorner = range.getMaxCorner();

        for (int i = minCorner.getX(); i < maxCorner.getX(); ++i)
        {
            for (int j = minCorner.getY(); j < maxCorner.getY(); ++j)
            {
                this.setObject(i, j, value);
            }
        }
    }

    public Displayable getObject(Point c)
    {
        return this.getObject(c.getX(), c.getY());
    }

    public void setObject(Point c, Displayable val)
    {
        this.setObject(c.getX(), c.getY(), val);
    }

    protected Displayable getObject(int x, int y)
    {
        Displayable object = this.objects[y][x];

        return object == null ? Status.EMPTY : object;
    }

    protected void setObject(int x, int y, Displayable val)
    {
        this.objects[x][y] = val;
    }

    @Override
    public String toString()
    {
        int height = this.getHeight();
        int width = this.getWidth();

        StringBuilder sb = new StringBuilder(height * width + height); //Austin please explain it to me when appropriate

        for (int i = 0; i < height; i++)
        {
            for(int j = 0; j < width; j++)
            {
                sb.append(this.getObject(j, i).display());
            }
            sb.append('\n');
        }

        return sb.toString();
    }
}
