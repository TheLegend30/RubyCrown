public class Player {
    private static Player PLAYER;
    private int hp;

    private int row = 0;
    private int column = 0;

    private Player() {
        this.hp = 100;
    }

    public int getHP() {
        return hp;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setHP(int hp) {
        this.hp = hp;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public static Player getInstance() {
        if (PLAYER == null) {
            PLAYER = new Player();
        }
        return PLAYER;
    }

    public void moveLeft() {
        this.column -= 1;
    }

    public void moveRight() {
        this.column += 1;
    }

    public void moveUp() {
        this.row -= 1;
    }

    public void moveDown() {
        this.row += 1;
    }

    @Override
    public String toString() {
        String string = "";
        string = "Здоров'я: " + hp + "\n";
        return string;
    }
}
