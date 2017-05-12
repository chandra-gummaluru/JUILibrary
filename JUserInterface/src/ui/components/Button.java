package ui.components;

import java.awt.Graphics2D;

import ui.graphics.Figure;
import ui.graphics.Style;
import ui.space.Point;

public class Button<T extends Figure> extends Figure {

	private Figure figure;

	private Style dflt, hvr, dwn;

	public Button(T figure, Style dflt, Style hvr, Style dwn) {
		super(dflt);

		this.dflt = dflt;
		this.hvr = hvr;
		this.dwn = dwn;

		this.figure = figure;
	}

	public void setDflt() {
		this.figure.setStyle(dflt);
	}

	public void setHvr() {
		this.figure.setStyle(hvr);
	}

	public void setDwn() {
		this.figure.setStyle(dwn);
	}

	@Override
	public void draw(Graphics2D g) {
		this.figure.draw(g);
	}

	@Override
	public boolean isPointInFigureBounds(Point p) {
		return this.figure.isPointInFigureBounds(p);
	}

}
