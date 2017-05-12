package ui.graphics;

import java.awt.Color;
import java.awt.Font;

public class Style {

	/**
	 * The background color of {@code this Figure}.
	 */
	private Color bgClr;

	/**
	 * The foreground color of {@code this Figure}.
	 */
	private Color fgClr;

	/**
	 * Gets the background color of {@code this Figure}.
	 * 
	 * @return bgClr
	 */
	public Color getBgClr() {
		return this.bgClr;
	}

	/**
	 * Gets the foreground color of {@code this Figure}.
	 * 
	 * @return fgClr
	 */
	public Color getFgClr() {
		return this.fgClr;
	}

	private Font font;

	public void setFont(Font font) {
		this.font = font;
	}

	public void setSize(double size) {
		this.font = this.font.deriveFont((float) size);
	}

	public Font getFont() {
		return this.font;
	}

	public Style(Color bgClr, Color fgClr) {
		this.bgClr = bgClr;
		this.fgClr = fgClr;
	}

	public Style(Color clr, Font font) {
		this.bgClr = clr;
		this.font = font;
	}

	public Style(Color clr, Font font, double size) {
		this(clr, font);
		setSize(size);
	}
}
