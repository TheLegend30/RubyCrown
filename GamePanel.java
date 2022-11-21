import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 480;

    public static Cell[][] cells = new Cell[WIDTH / 20][HEIGHT / 20];

    GamePanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setLayout(new GridLayout(WIDTH / 20, HEIGHT / 20));
        this.setBackground(Color.BLACK);

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell(i, j);
                this.add(cells[i][j]);
                if (new Random().nextBoolean()) {
                    JLabel placeLabel = new JLabel();
                    if (new Random().nextInt(6) == 5) {
                        cells[i][j].setPlace(new Cell.Place(Cell.Place.PlaceType.VILLAGE));
                        placeLabel.setIcon(new ImageIcon("files/pics/village.png"));
                    } else {
                        cells[i][j].setPlace(new Cell.Place(Cell.Place.PlaceType.FOREST));
                        placeLabel.setIcon(new ImageIcon("files/pics/forest.png"));
                    }
                    cells[i][j].add(placeLabel);
                }

            }
        }
    }

}
