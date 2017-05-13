package ui.graphics;

import ui.space.Point;
import ui.space.Vector;
import ui.style.ColorStyle;

/**
 * A {@code Shape} is a type of {@code Scalable} that contains a centroid and
 * can determine whether it is intersecting with other shapes.
 * 
 * @author Chandra Gummaluru
 * @version 1.2
 *
 */
public abstract class Shape extends Scalable {

	// geometric properties

	/**
	 * The centroid of {@code this Shape}.
	 */
	private Point centroid;

	// style
	private ColorStyle clrStyle;

	public ColorStyle getClrStyle() {
		return this.clrStyle;
	}

	public void setClrStyle(ColorStyle clrStyle) {
		this.clrStyle = clrStyle;
	}

	/**
	 * Constructs a {@code new Shape} using the specified fields. The centroid
	 * is determined using the specified set of points.
	 * 
	 * @param points
	 *            a set of points.
	 * @param clrStyle
	 *            the color style.
	 * @param scale
	 *            the scale factor.
	 */
	public Shape(Point[] points, ColorStyle clrStyle, int scale) {
		super(scale);

		setClrStyle(clrStyle);
		this.centroid = getCentroid(points);
	}

	/**
	 * Constructs a {@code new Shape} using the specified fields. The centroid
	 * is explicitly specified.
	 * 
	 * @param centroid
	 *            the centroid.
	 * @param clrStyle
	 *            the color style.
	 * @param scale
	 *            the scale factor.
	 */
	public Shape(Point centroid, ColorStyle clrStyle, int scale) {
		super(scale);

		setClrStyle(clrStyle);
		this.centroid = centroid;
	}

	/**
	 * Gets the centroid of {@code this Shape}.
	 * 
	 * @return centroid
	 */
	public Point getCentroid() {
		return this.centroid;
	}

	/**
	 * Whether {@code this Shape} is intersecting with the specified
	 * {@code Shape}.
	 * 
	 * @param s
	 *            some instance of {@code Shape}.
	 * @return {@code true} if the shapes are intersecting, {@code false}
	 *         otherwise.
	 */
	public boolean isIntersecting(Shape s) {
		return false;
	}

	/**
	 * Whether {@code this Shape} is intersecting with the specified
	 * {@code Polygon}.
	 * 
	 * @param s
	 *            some instance of {@code Polygon}.
	 * @return {@code true} if the shape and polygon are intersecting,
	 *         {@code false} otherwise.
	 */
	public abstract boolean isIntersecting(Polygon p);

	/**
	 * Whether {@code this Shape} is intersecting with the specified
	 * {@code Circle}.
	 * 
	 * @param s
	 *            some instance of {@code Circle}.
	 * @return {@code true} if the shape and circle are intersecting,
	 *         {@code false} otherwise.
	 */
	public abstract boolean isIntersecting(Circle c);

	/**
	 * Gets a projection of {@code this Shape} onto the axis specified by some
	 * {@code Vector}.
	 * 
	 * @param axis
	 *            the axis to project onto
	 * @return the projection length.
	 */
	public abstract double getProjection(Vector axis);

	/**
	 * Calculates the centroid of a set of points.
	 * 
	 * @param points
	 *            the set of points.
	 * @return the centroid.
	 */
	private static Point getCentroid(Point[] points) {
		Point sum = new Point(0, 0);

		for (Point p : points) {
			sum.add(p.getX(), p.getY());
		}

		return new Point(sum.getX() / points.length, sum.getY() / points.length);
	}
}
