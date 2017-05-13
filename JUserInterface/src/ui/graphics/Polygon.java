package ui.graphics;

import java.awt.Graphics2D;

import ui.space.Point;
import ui.space.Vector;
import ui.style.ColorStyle;

public class Polygon extends Shape {

	// geometric properties
	private Point[] points;

	public Point[] getPoints() {
		return this.points;
	}

	public Polygon(Point[] points, ColorStyle clrStyle, int scale) {
		super(points, clrStyle, scale);

		this.points = points;
	}

	@Override
	public void draw(Graphics2D g) {
		int[] xpts = new int[points.length];
		int[] ypts = new int[points.length];

		for (int i = 0; i < points.length; i++) {
			xpts[i] = (int) points[i].getX() * getScale();
			ypts[i] = (int) points[i].getY() * getScale();
		}

		g.setColor(this.getClrStyle().getBgClr());
		g.fillPolygon(xpts, ypts, points.length);

		g.setColor(this.getClrStyle().getFgClr());
		g.drawPolygon(xpts, ypts, points.length);
	}

	@Override
	public boolean isIntersecting(Polygon p) {
		return false;
	}

	@Override
	public boolean isIntersecting(Circle c) {
		return false;
	}

	public double getProjection(Vector v) {
		double p1 = 0;
		double p2 = 0;

		for (int i = 0; i < points.length; i++) {
			double p = ((Vector) points[i]).project(v);

			if (p < p1) {
				p1 = p;
			}

			if (p > p2) {
				p2 = p;
			}
		}

		return p2 - p1;
	}

	@Override
	public boolean isPointInBounds(Point p) {
		int i, j;
		boolean intersecting = false;

		for (i = 0, j = this.points.length - 1; i < this.points.length - 1; j = i++) {
			if (((points[i].getY() > p.getY()) != (points[j].getY() > p.getY()))
					&& (p.getX() < (points[j].getX() - points[i].getX()) * (p.getY() - points[i].getY())
							/ (points[j].getY() - points[i].getY()) + points[i].getX()))
				intersecting = !intersecting;
		}

		return intersecting;
	}
}
