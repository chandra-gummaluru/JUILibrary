package ui.graphics;

import java.awt.Graphics2D;

import ui.space.Point;
import ui.space.Vector;
import ui.style.ColorStyle;

public class Circle extends Shape {

	// geometric properties
	private int radius;

	public int getRadius() {
		return this.radius;
	}

	public Circle(Point pos, int radius, ColorStyle clrStyle, int scale) {
		super(pos, clrStyle, scale);

		this.radius = radius;
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(this.getClrStyle().getBgClr());
		g.fillOval((int) getCentroid().getX() * getScale(), (int) getCentroid().getY() * getScale(),
				radius * getScale(), radius * getScale());

		g.setColor(this.getClrStyle().getFgClr());
		g.drawOval((int) getCentroid().getX() * getScale(), (int) getCentroid().getY() * getScale(),
				radius * getScale(), radius * getScale());
	}

	public boolean isIntersecting(Circle c) {
		return this.radius + c.radius <= Vector.getPositionVector(c.getCentroid(), this.getCentroid()).getLength();
	}

	@Override
	public boolean isIntersecting(Polygon p) {
		return false;
	}

	@Override
	public double getProjection(Vector axis) {
		return 2 * this.radius;
	}

	@Override
	public boolean isPointInBounds(Point p) {
		double dx = p.getX() - this.getCentroid().getX();
		double dy = p.getY() - this.getCentroid().getY();

		/*
		 * A point is in the circle if the square distance to the point and the
		 * centroid of the circle is less than or equal to the square of the
		 * radius.
		 */
		return (dx * dx) * (dy * dy) <= this.getRadius() * this.getRadius();
	}
}
