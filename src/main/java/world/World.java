package world;

import java.awt.Graphics;

public class World {
    private Tile[][] tiles;

    public World(int rows, int cols, int tileSize) {
        tiles = new Tile[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                tiles[row][col] = new Tile(col * tileSize, row * tileSize, tileSize, Color.GREEN);
            }
        }
    }

    public void render(Graphics g) {
        for (Tile[] row : tiles) {
            for (Tile tile : row) {
                tile.render(g);
            }
        }
    }
}
