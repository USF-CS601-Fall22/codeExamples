package generics;

/** Class Circle - used in the Generic Max Example */
public class Circle implements Comparable<Circle>{

	private double radius;
	Circle(double r) {
		this.radius = r;
	}

	public double area() {
		return Math.PI*radius*radius;
	}
	
	@Override
	public int compareTo(Circle o) {
		Double area = this.area();
		return area.compareTo(o.area());
	}

	public String toString() {
		return "Circle: " + radius + " area " + area(); 
	}
}
