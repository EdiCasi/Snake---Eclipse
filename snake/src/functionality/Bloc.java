package functionality;

import java.awt.Color;
import java.awt.Graphics;

public class Bloc {

	enum type {
		SNAKE, APPLE, NONE
	};

	public int dimmension;
	private int x;
	private int y;
	private type blocType;


	public Bloc(int X, int Y, int dimmension) {
		this.x = X;
		this.y = Y;
		this.dimmension = dimmension;
		blocType = type.NONE;
	}

	public void setBlocType(type blocType) {
		this.blocType = blocType;
	}

	public type getBlocType() {
		return blocType;
	}

	public void drawBloc(Graphics g) {
		
		switch (blocType) {
		case SNAKE:
			g.setColor(Color.GREEN);
			break;
		case APPLE:
			g.setColor(Color.RED);
			break;
		case NONE:
			g.setColor(Color.BLACK);
			break;
		}
		
		g.fillRect(this.x, this.y, this.dimmension, this.dimmension);
		
		g.drawRect(this.x, this.y, this.dimmension, this.dimmension);
	}
}
