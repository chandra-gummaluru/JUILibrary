package handlers.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import ui.space.Point;

public class InputHandler implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

	public static final int NULL_CHAR = 0;
	public static final int BACKSPACE = KeyEvent.VK_BACK_SPACE;

	private char lastKeyPressed;

	private boolean pointerDown;
	private Point pointerPos;

	private int wheelRotation;
	private int wheelClickCount;

	public InputHandler() {
		lastKeyPressed = NULL_CHAR;

		pointerPos = new Point(0, 0);

		pointerDown = false;
		wheelRotation = 0;
		wheelClickCount = 0;
	}

	public boolean isKeyPressed(int keyNumber) {
		return keyNumber == lastKeyPressed;
	}

	public boolean isPointerDown() {
		return this.pointerDown;
	}

	public Point getPointerPosition() {
		return this.pointerPos;
	}

	public int getWheelRotation() {
		return this.wheelRotation;
	}

	public int getWheelClickCount() {
		return this.wheelClickCount;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		lastKeyPressed = e.getKeyChar();
	}

	public char getLastKey() {
		return this.lastKeyPressed;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// do nothing.
	}

	@Override
	public void keyReleased(KeyEvent e) {
		lastKeyPressed = NULL_CHAR;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// do nothing...
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// the mouse is down.
		this.pointerDown = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// the mouse is no longer down.
		this.pointerDown = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// do nothing...
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// do nothing...
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// the mouse position has changed.
		this.pointerPos = new Point(e.getPoint().x / 2, e.getPoint().y / 2);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// the mouse position has changed.
		this.pointerPos = new Point(e.getPoint().x / 2, e.getPoint().y / 2);
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		this.wheelRotation = e.getWheelRotation();
		this.wheelClickCount = e.getClickCount();
	}

}
