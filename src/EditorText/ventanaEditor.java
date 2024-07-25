package EditorText;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ventanaEditor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	// Visualizacion de la ventana
	public ventanaEditor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 300, 300);
//		setResizable(false);
		setVisible(true);
		setTitle("IBrain");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		add(new Panel());

	}

}
