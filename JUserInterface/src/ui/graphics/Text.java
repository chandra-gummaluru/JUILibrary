package ui.graphics;

import java.awt.Graphics2D;

import ui.space.Point;
import ui.style.TextStyle;

public class Text extends Scalable {

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

	// style
	private TextStyle txtStyle;

	public TextStyle getTextStyle() {
		return this.txtStyle;
	}

	public void setTextStyle(TextStyle txtStyle) {
		this.txtStyle = txtStyle;
	}

	public Text(String text, Point pos, TextStyle txtStyle, int scale) {
		super(scale);

		this.text = text;

		this.pos = pos;
		setTextStyle(txtStyle);
	}

	@Override
	public void draw(Graphics2D g) {
		g.setFont(txtStyle.getFont().deriveFont((float) (txtStyle.getFont().getSize() * getScale())));
		g.setColor(txtStyle.getClr());

		g.drawString(text, (int) pos.getX() * getScale(), (int) pos.getY() * getScale());
	}

	@Override
	public boolean isPointInBounds(Point p) {
		// TODO Auto-generated method stub
		return false;
	}

}
