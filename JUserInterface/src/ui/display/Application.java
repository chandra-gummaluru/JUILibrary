package ui.display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.DecimalFormat;

import handlers.input.InputHandler;
import handlers.res.ResourceHandler;
import loop.Loop;
import loop.Tickable;
import states.State;
import states.StateHandler;
import ui.display.Window.Scalability;

public class Application implements Tickable {

	public int scale;

	private String name;

	private Window window;
	private Loop loop;

	// handlers
	private StateHandler stateHdlr;

	@SuppressWarnings("unused")
	private ResourceHandler resHdlr;

	private InputHandler inputHldr;

	// debug
	DecimalFormat df = new DecimalFormat("0.00");
	private boolean displayFPS = true;

	// graphics
	Graphics2D g;

	public Application(String src) {
		resHdlr = new ResourceHandler(src);
	}

	public Application(String name, Dimension size, Scalability scalability, int fps, State defaultState) {
		this(name, size, scalability, fps);

		stateHdlr.setState(defaultState);
	}

	public Application(String name, Dimension size, Scalability scalability, int fps) {
		// set the name of the application.
		this.name = name;

		inputHldr = new InputHandler();

		// construct the window.
		this.window = new Window(name, size, scalability, Color.WHITE);

		scale = this.window.getScale();

		// add the required listeners to the window.
		this.window.addKeyListener(inputHldr);
		this.window.addMouseListener(inputHldr);
		this.window.addMouseMotionListener(inputHldr);
		this.window.addMouseWheelListener(inputHldr);

		stateHdlr = new StateHandler();

		// set up the loop.
		this.loop = new Loop(fps, this);

		// get the back buffer graphics context for the window.
		g = (Graphics2D) window.getBufferedGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}

	@Override
	public void tick() {

		// tick
		stateHdlr.tick();

		// handle input
		stateHdlr.handleInput(inputHldr);

		// get the back buffer graphics context for the window.
		// Graphics2D g = (Graphics2D) window.getBufferedGraphics();

		// draw the state to the back buffer.
		stateHdlr.draw(window.getBufferedGraphics());

		if (displayFPS) {
			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial", Font.PLAIN, 14));
			g.drawString(df.format(loop.getFPS()) + " FPS", 9, 832);
		}

		// draw the back buffer to the window.
		window.draw();

	}

	public String getName() {
		return this.name;
	}

	public Window getWindow() {
		return this.window;
	}

	public StateHandler getStateManager() {
		return this.stateHdlr;
	}

	public int getScale() {
		return this.scale;
	}
}
