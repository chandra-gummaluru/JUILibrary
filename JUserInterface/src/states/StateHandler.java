package states;

import java.awt.Graphics2D;

import handlers.input.InputHandler;
import handlers.input.InputHandling;
import loop.Tickable;
import ui.graphics.Drawable;

public class StateHandler implements Tickable, InputHandling, Drawable {

	private State currentState;

	public StateHandler() {
		currentState = new NullState();
	}

	public StateHandler(State defaultState) {
		setState(defaultState);
	}

	public void setState(State newState) {
		currentState = newState;
	}

	@Override
	public void tick() {
		currentState.tick();
	}

	@Override
	public void handleInput(InputHandler m) {
		currentState.handleInput(m);
	}

	@Override
	public void draw(Graphics2D g) {
		currentState.draw(g);
	}

}
