package ui.graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import ui.space.Point;

public class Image extends Figure {

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

	public Image(BufferedImage img, Point pos) {
		this.image = img;
		this.pos = pos;
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(this.image, (int) pos.getX() * getScale(), (int) pos.getY() * getScale(), null);
	}

}
