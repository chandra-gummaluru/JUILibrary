package ui.graphics;

import ui.space.Point;

/**
 * A {@code Figure} is a {@code Drawable} object that has a scale factor which
 * is used to apply scaling transformations to match the display resolution.
 * 
 * @author Chandra Gummaluru
 * @version 1.0
 *
 */
public abstract class Figure implements Drawable {

	private Style style;

	public Style getStyle() {
		return this.style;
	}

	public void setStyle(Style s) {
		this.style = s;
	}

	/**
	 * The scale factor used to transform all {@code Figures}s to match the
	 * display resolution.
	 */
	public static int SCALE;

	/**
	 * Gets the scale factor.
	 * 
	 * @return SCALE
	 */
	public static int getScale() {
		return SCALE;
	}

	/**
	 * Sets the scale factor used to transform all {@code Figure}s to match the
	 * display resolution.
	 * 
	 * @param scale
	 *            the scale factor.
	 */
	public static void setScale(int scale) {
		if (SCALE > 0) {
			return;
		}
		SCALE = scale;
	}

	public Figure(Style s) {
		setStyle(s);
	}

	/**
	 * Determines whether the specified point lies within the bounds of
	 * {@code this Figure}.
	 * 
	 * @param p
	 *            the point.
	 * @return {@code true} if the specified point is in the bounds of the
	 *         figure, {@code false} otherwise.
	 */
	public abstract boolean isPointInFigureBounds(Point p);
}
