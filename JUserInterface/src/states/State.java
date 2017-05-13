package states;

import handlers.audio.AudioHandler;
import handlers.input.InputHandling;
import handlers.res.ResourceHandler;
import loop.Tickable;
import physics.PhysicsHandler;
import ui.graphics.Drawable;

public abstract class State implements Tickable, InputHandling, Drawable {

	/**
	 * The scale associated with {@code this State}.
	 */
	private final int scale;

	// handlers
	private ResourceHandler resHdlr;
	private AudioHandler audioHdlr;
	private PhysicsHandler physicsHdlr;

	public State(String src, int scale) {
		this.scale = scale;

		resHdlr = new ResourceHandler(src);
		audioHdlr = new AudioHandler();
		physicsHdlr = new PhysicsHandler();
	}

	public ResourceHandler getResourceHandler() {
		return this.resHdlr;
	}

	public AudioHandler getAudioHandler() {
		return this.audioHdlr;
	}

	public PhysicsHandler getPhysicsHandler() {
		return this.physicsHdlr;
	}

	public int getScale() {
		return this.scale;
	}
}
