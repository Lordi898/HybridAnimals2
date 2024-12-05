package entities;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends GameObject {

    public Enemy(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void update() {
        // Lógica para seguir al jugador
        // Esto puede mejorarse con IA más avanzada
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height); // Representación básica del enemigo
    }
}
