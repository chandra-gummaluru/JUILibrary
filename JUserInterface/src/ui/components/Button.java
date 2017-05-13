package ui.components;

import java.awt.Graphics2D;

import handlers.input.InputHandler;
import ui.graphics.Shape;
import ui.graphics.Text;
import ui.style.ColorStyle;

public class Button extends Component {

	private Shape shape;
	private ColorStyle defaultStyle, hoverStyle, downStyle;

	@SuppressWarnings("unused")
	private Text text;

	public Button(Shape shape, ColorStyle defaultStyle, ColorStyle hoverStyle, ColorStyle downStyle) {
		this.shape = shape;

		this.defaultStyle = defaultStyle;
		this.hoverStyle = hoverStyle;
		this.downStyle = downStyle;
	}

	@Override
	public void draw(Graphics2D g) {
		this.shape.draw(g);
	}

	@Override
	public void handleInput(InputHandler m) {
		if (this.shape.isPointInBounds(m.getPointerPosition())) {
			if (m.isPointerDown()) {
				this.shape.setClrStyle(downStyle);
			} else {
				this.shape.setClrStyle(hoverStyle);
			}
		} else {
			this.shape.setClrStyle(defaultStyle);
		}
	}
}
