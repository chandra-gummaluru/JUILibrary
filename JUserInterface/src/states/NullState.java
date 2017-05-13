package states;

import java.awt.Graphics2D;

import handlers.input.InputHandler;

public class NullState extends State {

	public NullState() {
		super(null, 0);
	}

	@Override
	public void tick() {
		// do nothing...
	}

	@Override
	public void handleInput(InputHandler m) {

	}

	@Override
	public void draw(Graphics2D g) {
		// do nothing..
	}

}
