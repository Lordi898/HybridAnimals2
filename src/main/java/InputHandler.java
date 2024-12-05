import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

    private boolean[] keys = new boolean[256]; // Array para almacenar el estado de las teclas

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true; // Marcar la tecla como presionada
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false; // Marcar la tecla como no presionada
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // No implementado
    }

    // Método para consultar el estado de una tecla
    public boolean isKeyPressed(int keyCode) {
        return keys[keyCode];
    }
}
