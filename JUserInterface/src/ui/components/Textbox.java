package ui.components;

import java.awt.Graphics2D;

import handlers.input.InputHandler;
import ui.graphics.Polygon;
import ui.graphics.Text;
import ui.space.Point;
import ui.style.ColorStyle;
import ui.style.TextStyle;

public class Textbox extends Component {

	private Polygon box;
	private ColorStyle defaultStyle, focusedStyle;
	private TextStyle defaultTextStyle, focusedTextStyle;

	private Text text;
	private boolean focused;

	int delay = 6, count = 0;
	char lastKey = InputHandler.NULL_CHAR, secondLastKey = lastKey;

	public Textbox(Point pos, double width, double height, ColorStyle defaultStyle, ColorStyle focusedStyle,
			TextStyle defaultTextStyle, TextStyle focusedTextStyle, int scale) {
		this.box = new Polygon(new Point[] { pos, pos.add(width, 0), pos.add(width, height), pos.add(0, height) },
				defaultStyle, scale);

		this.defaultStyle = defaultStyle;
		this.focusedStyle = focusedStyle;

		this.defaultTextStyle = defaultTextStyle;
		this.focusedTextStyle = focusedTextStyle;

		this.text = new Text("", pos.add(10, height), defaultTextStyle, scale);
		this.focused = false;
	}

	public void setText(String text) {
		this.text.setText(text);
	}

	public void setFocus(boolean focused) {
		this.focused = focused;
		box.setClrStyle(focused ? focusedStyle : defaultStyle);
		text.setTextStyle(focused ? focusedTextStyle : defaultTextStyle);
	}

	public boolean isFocused() {
		return this.focused;
	}

	public void handleInput(InputHandler h) {
		if (h.isPointerDown()) {
			setFocus(box.isPointInBounds(h.getPointerPosition()));
		}

		// check that the component is in focus.
		if (focused) {
			// check that some key has been pressed.
			if (h.getLastKey() != InputHandler.NULL_CHAR) {
				// check whether the key changed.
				if (h.getLastKey() == lastKey && (lastKey != secondLastKey)) {
					count++;
				} else {
					count = delay;
				}

				if (count >= delay) {
					secondLastKey = lastKey;
					lastKey = append(h.getLastKey());
					count = 0;
				}
			}
		}
	}

	private char append(char c) {
		String currentText = text.getText();
		if (c != InputHandler.BACKSPACE) {
			text.setText(currentText + c);
		} else if (currentText.length() > 0) {
			text.setText(currentText.substring(0, currentText.length() - 1));
		}

		return c;
	}

	@Override
	public void draw(Graphics2D g) {
		box.draw(g);
		text.draw(g);
	}

}
