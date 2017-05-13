package ui.graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import ui.space.Point;

public class Image extends Scalable {

	// geometric properties
	private Point pos;

	public Point getPos() {
		return this.pos;
	}

	public void setPos(Point pos) {
		this.pos = pos;
	}

	private BufferedImage image;

	public void setImage(BufferedImage img) {
		this.image = img;
	}

	public BufferedImage getImage() {
		return this.image;
	}

	public Image(BufferedImage img, Point pos, int scale) {
		super(scale);

		this.image = img;
		this.pos = pos;
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(this.image, (int) pos.getX() * getScale(), (int) pos.getY() * getScale(), null);
	}

	@Override
	public boolean isPointInBounds(Point p) {
		return (p.getX() >= pos.getX() && p.getX() <= pos.getX() + image.getWidth())
				&& (p.getY() >= pos.getY() && p.getY() <= pos.getY() + image.getHeight());
	}

}
