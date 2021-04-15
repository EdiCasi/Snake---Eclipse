package functionality;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyDemo implements KeyListener {

	public static int currentDirection;

	public KeyDemo() {
		KeyDemo.currentDirection = KeyEvent.VK_RIGHT;
	}

	private boolean verifyIfIsCommand(int key) {
		return key != KeyEvent.VK_UP && key != KeyEvent.VK_DOWN && key != KeyEvent.VK_LEFT && key != KeyEvent.VK_RIGHT;
	}

	private boolean verifyIfIsOpposite(int key) {
		if (key == KeyEvent.VK_UP && KeyDemo.currentDirection == KeyEvent.VK_DOWN)
			return true;

		if (key == KeyEvent.VK_DOWN && KeyDemo.currentDirection == KeyEvent.VK_UP)
			return true;

		if (key == KeyEvent.VK_RIGHT && KeyDemo.currentDirection == KeyEvent.VK_LEFT)
			return true;

		if (key == KeyEvent.VK_LEFT && KeyDemo.currentDirection == KeyEvent.VK_RIGHT)
			return true;
		return false;
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (verifyIfIsCommand(e.getKeyCode()))
			return;
		
		if (verifyIfIsOpposite(e.getKeyCode()))
			return;
		
		KeyDemo.currentDirection = e.getKeyCode();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public int getCurentDirection() {
		return currentDirection;
	}

}
