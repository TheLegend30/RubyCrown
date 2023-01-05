import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

import javax.swing.JTextArea;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GameStats extends JPanel {
    public static final int WIDTH = 140;
    public static final int HEIGHT = 480;

    public static JTextArea playerStats = new JTextArea();
    private static JButton inventoryButton = new JButton("Інвентар");
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
        playerStats.setFont(new Font("Blagovest", Font.PLAIN, 12));
        playerStats.setText(Player.getInstance().toString());
        playerStats.setForeground(Color.YELLOW);
        playerStats.setBackground(Color.BLACK);

        inventoryButton.addActionListener(e -> {
            this.removeAll();

            DefaultListModel<Item> listModel = new DefaultListModel<>();
            listModel.addAll(Player.getInstance().getInventory().getItems());
            JList<Item> inventoryList = new JList<>(listModel);
            JButton removeButton = new JButton("Викинути");
            JButton backButton = new JButton("Назад");
            removeButton.addActionListener(event -> {
                listModel.remove(inventoryList.getSelectedIndex());
                this.updateUI();
            });
            backButton.addActionListener(event -> {
                this.removeAll();
                this.add(playerStats);
                this.add(inventoryButton);
                this.add(placeStats);
                this.updateUI();
            });
            this.add(inventoryList);
            this.add(removeButton);
            this.add(backButton);
            this.updateUI();
        });

        placeStats.setEditable(false);
        placeStats.setLineWrap(true);
        placeStats.setFont(new Font("Blagovest", Font.PLAIN, 8));
        placeStats.setText(
                GamePanel.cells[Player.getInstance().getRow()][Player.getInstance().getColumn()].toString());
        placeStats.setForeground(Color.YELLOW);
        placeStats.setBackground(Color.BLACK);

        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.BLACK);
        this.add(playerStats);
        this.add(inventoryButton);
        this.add(placeStats);
    }
}
