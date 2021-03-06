package functionality;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import functionality.Bloc.type;

public class Game {
	private SnakeHead snakeHead;
	private Board board;
	private ArrayList<Bloc> snake;
	private Random rand;
	private boolean gameOver = false;
	private int appleEaten = 0;

	public int getAppleEaten() {
		return appleEaten;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public Game(int height, int width, int blocSize) {

		board = new Board(height, width, blocSize);

		snake = new ArrayList<Bloc>();

		snake.add(board.getMatrix()[height / 2][2]);
		snake.add(board.getMatrix()[height / 2][2]);

		snake.get(0).setBlocType(type.SNAKE);

		snakeHead = new SnakeHead(height / 2, 2);

		rand = new Random();
	}

	public Board getBoard() {
		return board;
	}

	private void moveSnakeHead(int key) {
		switch (key) {
		case KeyEvent.VK_UP:
			snake.set(0, snakeHead.returnUpBloc(board));
			break;
		case KeyEvent.VK_DOWN:
			snake.set(0, snakeHead.returnDownBloc(board));
			break;
		case KeyEvent.VK_LEFT:
			snake.set(0, snakeHead.returnLeftBloc(board));
			break;
		case KeyEvent.VK_RIGHT:
			snake.set(0, snakeHead.returnRightrBloc(board));
			break;
		}
	}

	private boolean raiseTheSnake(int key) {
		if (snake.get(0) == snake.get(1)) {
			moveSnakeHead(key);
			snake.get(0).setBlocType(type.SNAKE);
			return true;
		}
		return false;
	}

	private void snakeHitsApple() {
		if (snake.get(0).getBlocType() == type.APPLE) {
			snake.add(0, snake.get(0));
			appleEaten++;
			generateApple();
		}
	}

	private void snakeHitsSnake() {

		if (snake.get(0).getBlocType() == type.SNAKE) {
			gameOver = true;
		}
	}

	public void moveSnake(int key) {

		if (raiseTheSnake(key))
			return;

		snake.get(snake.size() - 1).setBlocType(type.NONE);

		for (int i = snake.size() - 1; i >= 1; i--)
			snake.set(i, snake.get(i - 1));

		moveSnakeHead(key);

		snakeHitsApple();

		snakeHitsSnake();

		snake.get(0).setBlocType(type.SNAKE);
	}

	public void generateApple() {
		int randomLine = rand.nextInt(board.getHeight());
		int randomColumn = rand.nextInt(board.getWidth());
		if (board.getMatrix()[randomLine][randomColumn].getBlocType() != type.NONE) {
			generateApple();
			return;
		}

		board.getMatrix()[randomLine][randomColumn].setBlocType(type.APPLE);
	}

}
