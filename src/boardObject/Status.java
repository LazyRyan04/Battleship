package boardObject;

public enum Status implements Displayable
{
    HIT
            {
                @Override
                public char display() {
                    return 'X';
                }
            },
    MISS
            {
                @Override
                public char display() {
                    return '@';
                }
            },
    SUNK
            {
                @Override
                public char display() {
                    return '=';
                }
            },
    EMPTY
            {
                @Override
                public char display() {
                    return '_';
                }
            },



}
