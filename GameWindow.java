import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.*;

public class GameWindow extends JFrame implements KeyListener {
    private static GamePanel gamePanel = new GamePanel();
    private static GameStats gameStats = new GameStats();
    private static JLabel playerLabel = new JLabel();

    GameWindow() {
        playerLabel.setIcon(new ImageIcon("files/pics/player.png"));

        this.setTitle("Рубінова корона короля-привида з Північного Краю");
        this.setLayout(new FlowLayout());
        this.setResizable(false);
        this.getContentPane().setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(this);

        this.add(gamePanel);
        this.add(gameStats);
        GamePanel.cells[Player.getInstance().getRow()][Player.getInstance().getColumn()].add(playerLabel);
        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setFocusable(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                GamePanel.cells[Player.getInstance().getRow()][Player.getInstance().getColumn()].remove(playerLabel);
                Player.getInstance().moveUp();
                repaint();
                break;
            case KeyEvent.VK_S:
                GamePanel.cells[Player.getInstance().getRow()][Player.getInstance().getColumn()].remove(playerLabel);
                Player.getInstance().moveDown();
                repaint();
                break;
            case KeyEvent.VK_A:
                GamePanel.cells[Player.getInstance().getRow()][Player.getInstance().getColumn()].remove(playerLabel);
                Player.getInstance().moveLeft();
                repaint();
                break;
            case KeyEvent.VK_D:
                GamePanel.cells[Player.getInstance().getRow()][Player.getInstance().getColumn()].remove(playerLabel);
                Player.getInstance().moveRight();
                repaint();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void repaint() {
        GamePanel.cells[Player.getInstance().getRow()][Player.getInstance().getColumn()].add(playerLabel);
        gamePanel.updateUI();
        GameStats.placeStats.setText(
                GamePanel.cells[Player.getInstance().getRow()][Player.getInstance().getColumn()].toString());
    }
}
