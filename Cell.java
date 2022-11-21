import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Cell extends JPanel {
    private int gridRow;
    private int gridColumn;

    private Place place = new Place();

    public static class Place {
        private PlaceType placeType = PlaceType.STEPPE;

        private Place() {

        }

        Place(PlaceType placeType) {
            this.placeType = placeType;
        }

        public enum PlaceType {
            STEPPE,
            FOREST,
            VILLAGE;

            @Override
            public String toString() {
                switch (this) {
                    case STEPPE:
                        return "Степ";
                    case FOREST:
                        return "Ліс";
                    case VILLAGE:
                        return "Село";
                    default:
                        return "Пустка";
                }
            }
        }
    }

    private final Color fieldColor = new Color(40, 161, 68);
    private final Color borderColor = new Color(11, 94, 31);

    public Cell(int gridRow, int gridColumn) {
        this.gridRow = gridRow;
        this.gridColumn = gridColumn;

        setBorder(new LineBorder(borderColor, 1));
        setBackground(fieldColor);
    }

    public int getGridRow() {
        return gridRow;
    }

    public int getGridColumn() {
        return gridColumn;
    }

    public Place getPlace() {
        return place;
    }

    public void setGridRow(int gridRow) {
        this.gridRow = gridRow;
    }

    public void setGridColumn(int gridColumn) {
        this.gridColumn = gridColumn;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public String toString() {
        String string = "";
        string += place.placeType.toString();
        return string;
    }
}
