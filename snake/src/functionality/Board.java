package functionality;

public class Board {

	private Bloc[][] matrix;
	private int height;
	private int width;

	public Board(int height, int width, int blocSize) {

		matrix = new Bloc[height][width];

		this.height = height;

		this.width = width;

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++)
				matrix[i][j] = new Bloc(j * blocSize, i * blocSize, blocSize);
		}

	}

	public Bloc[][] getMatrix() {
		return matrix;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
}
