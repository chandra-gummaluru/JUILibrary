package ui.style;

import java.awt.Color;
import java.awt.Font;

public class TextStyle {

	/**
	 * The color.
	 */
	private Color clr;

	public Color getClr() {
		return this.clr;
	}

	public void setClr(Color clr) {
		this.clr = clr;
	}

	/**
	 * The font.
	 */
	private Font font;

	public Font getFont() {
		return this.font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public void setSize(double size) {
		this.font = this.font.deriveFont((float) size);
	}

	public TextStyle(Font font, Color clr) {
		setFont(font);
		setClr(clr);
	}

	public TextStyle(Font font, int size, Color clr) {
		this(font, clr);
		setSize(size);
	}

}
