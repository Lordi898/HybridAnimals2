import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import entities.*;
import world.*;

public class GameEngine extends JPanel implements Runnable {
    private Thread gameThread;
    private boolean running;
    private Player player;
    private Enemy enemy;
    private World world;

    player = new Player(100, 100, 32, 32);
    enemy = new Enemy(200, 200, 32, 32);
    world = new World(20, 20, 32); // Mapa de 20x20 con baldosas de 32px


    // Resolución del juego
    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    // Buffer para gráficos
    private BufferedImage canvas;
    private Graphics2D g2d;

    public GameEngine() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(new InputHandler());
        canvas = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        player = new Player(100, 100, 32, 32);
        enemy = new Enemy(200, 200, 32, 32);
        world = new World(20, 20, 32); // Mapa de 20x20 con baldosas de 32px

    }

    // Iniciar el bucle del juego
    public void start() {
        if (gameThread == null) {
            gameThread = new Thread(this);
            running = true;
            gameThread.start();
        }
    }

    // Lógica principal
    @Override
    public void run() {
        final int FPS = 60;
        final long targetTime = 1000 / FPS;

        while (running) {
            long startTime = System.currentTimeMillis();

            // Actualizar y renderizar
            update();
            render();
            repaint();

            long elapsed = System.currentTimeMillis() - startTime;
            long wait = targetTime - elapsed;

            if (wait > 0) {
                try {
                    Thread.sleep(wait);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Actualizar lógica del juego
    private void update() {
        player.update();
        enemy.update();
    }

    // Dibujar gráficos
    private void render() {
        g2d = canvas.createGraphics(); // Crear un objeto Graphics2D para dibujar

        // Fondo negro
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, WIDTH, HEIGHT);

        // Dibujar las entidades
        player.render(g2d); // Dibujar al jugador
        enemy.render(g2d);  // Dibujar al enemigo
        world.render(g2d); // Dibujar el mapa

        g2d.dispose(); // Liberar recursos gráficos
    }

    // Dibujar en la ventana
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(canvas, 0, 0, null);
    }
}
