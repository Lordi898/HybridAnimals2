package entities;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {
    private int speed = 5;

    public Player(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void update() {
        // Movimiento básico (con InputHandler)
        if (InputHandler.isKeyPressed(KeyEvent.VK_W)) y -= speed; // Arriba
        if (InputHandler.isKeyPressed(KeyEvent.VK_S)) y += speed; // Abajo
        if (InputHandler.isKeyPressed(KeyEvent.VK_A)) x -= speed; // Izquierda
        if (InputHandler.isKeyPressed(KeyEvent.VK_D)) x += speed; // Derecha
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height); // Representación básica del jugador
    }
}
