package functionality;

import javax.swing.JFrame;

public class Main {
	private static void initUI(int height, int width) {

		JFrame f = new JFrame("Algoritmica Grafurilor");

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Panel panel = new Panel(height, width);
		f.add(panel);
		f.addKeyListener(new KeyDemo());
		f.setSize(panel.getPanelWidth(), panel.getPanelHeight());
		f.setResizable(false);
		f.setVisible(true);
	}

	public static void main(String[] args) {

		initUI(18, 18);

	}
}
