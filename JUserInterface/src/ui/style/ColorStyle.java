package ui.style;

import java.awt.Color;

public class ColorStyle {
	/**
	 * The foreground color of {@code this Shape}.
	 */
	private Color fgClr;

	public Color getFgClr() {
		return this.fgClr;
	}

	public void setFgClr(Color fgClr) {
		this.fgClr = fgClr;
	}

	/**
	 * The background color of {@code this Shape}.
	 */
	private Color bgClr;

	public Color getBgClr() {
		return this.bgClr;
	}

	public void setBgClr(Color bgClr) {
		this.bgClr = bgClr;
	}

	public ColorStyle(Color bgClr, Color fgClr) {
		setBgClr(bgClr);
		setFgClr(fgClr);
	}
}
