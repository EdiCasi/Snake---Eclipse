package functionality;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	Game game;
	static final int DELAY = 175; // 175
	private Timer timer;

	public static final int blocSize = 35;

	private int panelWidth;
	private int panelHeight;

	public Panel(int height, int width) {

		game = new Game(height, width, blocSize);

		timer = new Timer(DELAY, this);
		timer.start();

		game.generateApple();

		panelWidth = (blocSize + 1) * width - 2;
		panelHeight = blocSize * (height + 1);
	}

	private void drawBlocs(Graphics g) {
		for (int i = 0; i < game.getBoard().getHeight(); i++)
			for (int j = 0; j < game.getBoard().getWidth(); j++)
				game.getBoard().getMatrix()[i][j].drawBloc(g);
	}

	private void drawScore(Graphics g) {
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free", Font.BOLD, 40));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("Score: " + game.getAppleEaten(),
				(panelWidth - metrics.stringWidth("Score: " + game.getAppleEaten())) / 2, g.getFont().getSize());
	}

	public void makeEmptyPanel()
	{
		setBackground(Color.BLACK);
		revalidate();
		repaint();
	}
	
	public void gameOver(Graphics g) {
		
		makeEmptyPanel();

		g.setColor(Color.red);
		g.setFont(new Font("Ink Free", Font.BOLD, 60));
		FontMetrics metrics1 = getFontMetrics(g.getFont());
		g.drawString("Score: " + game.getAppleEaten(),
				(panelWidth - metrics1.stringWidth("Score: " + game.getAppleEaten())) / 2, panelHeight / 3);
		
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free", Font.BOLD, 75));
		FontMetrics metrics2 = getFontMetrics(g.getFont());
		g.drawString("Game Over", (panelWidth - metrics2.stringWidth("Game Over")) / 2, panelHeight / 2);

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (game.isGameOver())
			gameOver(g);
		else {
			drawBlocs(g);

			drawScore(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (game.isGameOver()) {
			timer.stop();
			repaint();
			return;
		}
		game.moveSnake(KeyDemo.currentDirection);
		repaint();
	}

	public int getPanelWidth() {
		return panelWidth;
	}

	public int getPanelHeight() {
		return panelHeight;
	}
}
