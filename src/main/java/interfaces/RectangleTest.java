package interfaces;

import org.w3c.dom.css.Rect;

import java.util.*;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(5, 4);
        Rectangle r2 = new Rectangle(14, 1);
        List<Rectangle> list = new ArrayList<>();
        list.add(r1);
        list.add(r2);
        Comparator<Rectangle> comp1 = new RectangleComparatorArea();
        Comparator<Rectangle> comp2 = new RectangleComparatorPerimeter();
        Collections.sort(list, comp1);
        System.out.println(list);

        Collections.sort(list, comp2);
        System.out.println(list);

        TreeSet<Rectangle> setR = new TreeSet<>(comp1);
        setR.add(r1);
        setR.add(r2);
        System.out.println(setR);


    }
}
