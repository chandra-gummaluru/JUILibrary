package ui.graphics;

import ui.space.Point;

/**
 * A {@code Scalable} is a {@code Drawable} object that has a scale factor which
 * is used to apply scaling transformations.
 */
public abstract class Scalable implements Drawable {

	/**
	 * The scale factor associated with {@code this Scalable}.
	 */
	private final int scale;

	public Scalable(int scale) {
		this.scale = scale;
	}

	public int getScale() {
		return this.scale;
	}

	public abstract boolean isPointInBounds(Point p);

}
