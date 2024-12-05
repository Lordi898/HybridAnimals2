package world;

import java.awt.Graphics;
import java.awt.Color;

public class Tile {
    private int x, y, size;
    private Color color;

    public Tile(int x, int y, int size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, size, size);
    }
}
