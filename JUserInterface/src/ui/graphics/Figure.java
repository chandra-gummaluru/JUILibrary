package ui.graphics;

/**
 * A {@code Figure} is a {@code Drawable} object that has a scale factor which
 * is used to apply scaling transformations to match the display resolution.
 * 
 * @author Chandra Gummaluru
 * @version 1.0
 *
 */
public abstract class Figure implements Drawable {

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
		if (scale > 0) {
			return;
		}
		SCALE = scale;
	}
}
