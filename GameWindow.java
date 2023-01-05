import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GameWindow extends JFrame implements KeyListener {
    private JMenuBar menuBar = new JMenuBar();
    private JMenu fileMenu = new JMenu("Файл");
    private JMenuItem exitItem = new JMenuItem("Вихід");

    private static GamePanel gamePanel = new GamePanel();
    private static GameStats gameStats = new GameStats();
    private static JLabel playerLabel = new JLabel();

    private static JButton huntButton = new JButton("Полювати");
    private static JButton buyFoodButton = new JButton("Придбати їжу");

    GameWindow() {
        fileMenu.add(exitItem);
        exitItem.addActionListener(e -> {
            System.exit(0);
        });
        menuBar.add(fileMenu);

        playerLabel.setIcon(new ImageIcon("files/pics/player.png"));

        huntButton.setFocusable(false);
        huntButton.addActionListener(e -> {
            Player.getInstance().setHP(Player.getInstance().getHP() - new Random().nextInt(10));
            Player.getInstance().getInventory().additem(new Item("Дичка", 15));
            repaint();
        });
        buyFoodButton.setFocusable(false);
        buyFoodButton.addActionListener(e -> {
            if (Player.getInstance().getMoney() >= 150) {
                Player.getInstance().setMoney(Player.getInstance().getMoney() - 150);
                Player.getInstance().setFood(100);
                this.repaint();
            } else {
                JOptionPane.showMessageDialog(null, "Не вистачає грошей (Потрібно хоча б 150грн)");
            }

        });
        this.setJMenuBar(menuBar);
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

        repaint();
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
        if (GamePanel.cells[Player.getInstance().getRow()][Player.getInstance().getColumn()].getPlace()
                .getPlaceType() == Cell.Place.PlaceType.VILLAGE) {
            gameStats.add(buyFoodButton);
        } else if (GamePanel.cells[Player.getInstance().getRow()][Player.getInstance().getColumn()].getPlace()
                .getPlaceType() == Cell.Place.PlaceType.FOREST) {
            gameStats.add(huntButton);
        } else {
            gameStats.remove(buyFoodButton);
            gameStats.remove(huntButton);
        }
        GameStats.playerStats.setText(Player.getInstance().toString());
        GameStats.placeStats.setText(
                GamePanel.cells[Player.getInstance().getRow()][Player.getInstance().getColumn()].toString());
        gameStats.updateUI();
        if (Player.getInstance().getHP() <= 0) {
            JOptionPane.showMessageDialog(null, "Вічная памʼять");
            System.exit(0);
        }
    }
}
