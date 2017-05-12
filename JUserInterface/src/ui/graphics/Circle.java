package ui.graphics;

import java.awt.Color;
import java.awt.Graphics2D;

import ui.space.Point;
import ui.space.Vector;

public class Circle extends Shape {

	// geometric properties
	private int radius;

	public int getRadius() {
		return this.radius;
	}

	public Circle(Point pos, int radius, Color bgColor, Color fgColor) {
		super(pos, bgColor, fgColor);

		this.radius = radius;
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(getBgClr());
		g.fillOval((int) getCentroid().getX() * getScale(), (int) getCentroid().getY() * getScale(), radius, radius);

		g.setColor(getFgClr());
		g.drawOval((int) getCentroid().getX() * getScale(), (int) getCentroid().getY() * getScale(), radius, radius);
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
}
