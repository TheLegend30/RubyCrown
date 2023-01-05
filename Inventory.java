import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;

    Inventory() {
        items = new ArrayList<>();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void additem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    // public Item[] itemsToArray() {
    // Item[] itemsArray = new Item[items.size()];
    // for (int i = 0; i < itemsArray.length; i++) {
    // itemsArray[i] = items.get(i);
    // }
    // return itemsArray;
    // }

    @Override
    public String toString() {
        String string = "";
        for (Item item : items) {
            string += item.toString();
        }
        return string;
    }
}

class Item {
    String name = "";
    int price = 0;

    Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        String string = "";
        string = name + " " + price + "грн\n";
        return string;
    }
}