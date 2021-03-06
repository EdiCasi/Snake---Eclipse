package functionality;

public class SnakeHead {
	private int line;
	private int column;

	public SnakeHead(int line, int column) {
		super();
		this.line = line;
		this.column = column;

	}

	public Bloc returnUpBloc(Board board) {
		if (line - 1 < 0)
			line = board.getHeight() - 1;
		else
			line--;
		return board.getMatrix()[line][column];
	}

	public Bloc returnDownBloc(Board board) {
		if (line + 1 > board.getHeight() - 1)
			line = 0;
		else
			line++;
		return board.getMatrix()[line][column];
	}

	public Bloc returnLeftBloc(Board board) {

		if (column - 1 < 0)
			column = board.getWidth() - 1;
		else
			column--;
		return board.getMatrix()[line][column];
	}

	public Bloc returnRightrBloc(Board board) {
		if (column + 1 > board.getWidth() - 1)
			column = 0;
		else
			column++;
		return board.getMatrix()[line][column];
	}

}
