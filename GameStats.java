import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GameStats extends JPanel {
    public static final int WIDTH = 140;
    public static final int HEIGHT = 480;

    public static JTextArea playerStats = new JTextArea();
    public static JTextArea placeStats = new JTextArea();

    public GameStats() {
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("files/Blagovest.ttf")));
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        playerStats.setEditable(false);
        playerStats.setLineWrap(true);
        playerStats.setFont(new Font("Blagovest", Font.PLAIN, 14));
        playerStats.setText(Player.getInstance().toString());
        playerStats.setForeground(Color.YELLOW);
        playerStats.setBackground(Color.BLACK);

        placeStats.setEditable(false);
        placeStats.setLineWrap(true);
        placeStats.setFont(new Font("Blagovest", Font.PLAIN, 14));
        placeStats.setText(
                GamePanel.cells[Player.getInstance().getRow()][Player.getInstance().getColumn()].toString());
        placeStats.setForeground(Color.YELLOW);
        placeStats.setBackground(Color.BLACK);

        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.BLACK);
        this.add(playerStats);
        this.add(placeStats);
    }
}
