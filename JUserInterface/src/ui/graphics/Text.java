package ui.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import ui.space.Point;

public class Text extends Figure {

	// geometric properties
	private Point pos;

	public Point getPos() {
		return this.pos;
	}

	public void setPos(Point pos) {
		this.pos = pos;
	}

	private String text;

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Text(String text, Point pos, Font font, double size, Color color) {
		super(new Style(color, font, size));

		this.text = text;
		this.pos = pos;
	}

	public Text(String text, Point pos, Font font, Color color) {
		super(new Style(color, font));

		this.text = text;
		this.pos = pos;
	}

	@Override
	public void draw(Graphics2D g) {
		g.setFont(getStyle().getFont().deriveFont(getStyle().getFont().getSize() * getScale()));
		g.setColor(getStyle().getBgClr());

		g.drawString(text, (int) pos.getX() * getScale(), (int) pos.getY() * getScale());
	}

	@Override
	public boolean isPointInFigureBounds(Point p) {
		// TODO Auto-generated method stub
		return false;
	}

}
