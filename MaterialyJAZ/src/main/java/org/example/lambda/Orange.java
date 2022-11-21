package org.example.lambda;

import java.awt.*;

public class Orange implements iFruit {
    private final int size;
    private final Color color;

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public boolean isGood(){
        return color==Color.ORANGE&&size>=3;
    }

    public Orange(int size, Color color) {
        this.size = size;
        this.color = color;
    }
}
