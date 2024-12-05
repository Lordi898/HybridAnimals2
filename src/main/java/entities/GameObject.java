package entities;

import java.awt.Graphics;

public abstract class GameObject {
    protected int x, y; // Posición
    protected int width, height; // Tamaño

    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public abstract void update(); // Lógica de actualización
    public abstract void render(Graphics g); // Dibujar en pantalla

    // Getters y setters para posición
    public int getX() { return x; }
    public int getY() { return y; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
}
