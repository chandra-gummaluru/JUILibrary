package states;

import java.awt.Graphics2D;

import handlers.input.InputHandler;

public class ErrorState extends State {

	@SuppressWarnings("unused")
	private Exception e;

	public ErrorState(Exception e, int scale) {
		super(null, scale);
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
	}

}
