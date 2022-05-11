package boardObject;

public enum DotStatus implements BoardObject {
    EMPTY
            {
                @Override
                public char display()
                {
                    return ' ';
                }

            },
    HIT
            {
                @Override
                public char display()
                {
                    return ' ';
                }
            },
    MISS
            {
                @Override
                public char display()
                {
                    return ' ';
                }
            },
}
