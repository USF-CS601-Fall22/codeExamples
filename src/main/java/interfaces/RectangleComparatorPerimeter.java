package interfaces;

import java.util.Comparator;

public class RectangleComparatorPerimeter implements Comparator<Rectangle> {
    @Override
    public int compare(Rectangle o1, Rectangle o2) {
        int perim1 = o1.perimeter();
        int perim2 = o2.perimeter();

        return perim1 - perim2;
    }
}
