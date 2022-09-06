package interfaces;

import java.util.Comparator;

public class RectangleComparatorArea implements Comparator<Rectangle> {

    @Override
    public int compare(Rectangle o1, Rectangle o2) {
        int area1 = o1.area();
        int area2 = o2.area();

        return area1 - area2;
    }
}
