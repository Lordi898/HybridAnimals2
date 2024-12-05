import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Hybrid Animals - Game Engine");
        GameEngine gameEngine = new GameEngine();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.add(gameEngine);
        window.pack(); // Ajustar el tamaño del JFrame al del panel
        window.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        window.setVisible(true);

        gameEngine.start(); // Iniciar el juego
    }
}
