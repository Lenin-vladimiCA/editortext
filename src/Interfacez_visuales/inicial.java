package Interfacez_visuales;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class inicial {

	private JFrame frame;
	JLabel Bienvenida;
	JButton inicial;
	JPanel panel;
	public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	public inicial() {

		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setSize(null);
		frame.setBounds(100, 100, 554, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setResizable(true);

		panel = new JPanel();
		panel.setBounds(0, 0, 538, 412);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		Bienvenida = new JLabel("Bienvenido");
		Bienvenida.setBounds(161, 58, 224, 173);
		Bienvenida.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Bienvenida.setForeground(UIManager.getColor("Button.foreground"));
		Bienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(Bienvenida);

		inicial = new JButton("Inicial\r\n");
		inicial.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(inicial);

		JPanel Pagina2 = new JPanel();
		Pagina2.setBounds(0, 0, 538, 412);
		Pagina2.setLocation(0, 0);
//		pane2.add(Pagina2);

		inicial.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Inicial_2 ini = new Inicial_2();

			}
		});

	}
}
