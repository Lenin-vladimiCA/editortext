package EditorText;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		ventanaEditor ven = new ventanaEditor();
		JFrame frame = new JFrame("IBrain");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800, 600);
		frame.add(new Panel());
		frame.setVisible(true);
	}

}
