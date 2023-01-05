public class Player {
    private static Player PLAYER;
    private int hp;
    private int food;
    private int money;
    private Inventory inventory;

    private int row = 0;
    private int column = 0;

    private Player() {
        this.hp = 100;
        this.food = 100;
        this.money = 500;
        inventory = new Inventory();
    }

    public int getHP() {
        return hp;
    }

    public int getFood() {
        return food;
    }

    public int getMoney() {
        return money;
    }

    public Inventory getInventory() {
        return inventory;
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

    public void setFood(int food) {
        this.food = food;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
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
        if (column < GamePanel.COLUMNS) {
            column--;
            if (food > 0) {
                food--;
            } else {
                hp--;
            }
        }
    }

    public void moveRight() {
        if (column > 0) {
            column++;
            if (food > 0) {
                food--;
            } else {
                hp--;
            }
        }
    }

    public void moveUp() {
        if (row > 0) {
            row--;
            if (food > 0) {
                food--;
            } else {
                hp--;
            }
        }
    }

    public void moveDown() {
        if (row < GamePanel.ROWS) {
            row++;
            if (food > 0) {
                food--;
            } else {
                hp--;
            }
        }
    }

    @Override
    public String toString() {
        String string = "";
        string = "Здоров'я: " + hp + "\n";
        string += "Їжа: " + food + "\n";
        string += "Гроші: " + money + "грн\n";
        return string;
    }
}
