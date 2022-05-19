package boardObject;

import coordinates.Range;

public class BoardObject implements Displayable
{
    private Displayable value;
    private Range bounds;

    public BoardObject(Displayable value, Range bounds)
    {
        this.value = value;
        this.bounds = bounds;
    }

    public Range getBounds()
    {
        return this.bounds;
    }

    public Displayable getValue()
    {
        return value;
    }

    public char display()
    {
        return value.display();
    }
}
