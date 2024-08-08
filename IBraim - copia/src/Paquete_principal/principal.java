package Paquete_principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Menu;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel PanelContenerdoGeneral;
	private JTextField barraNombre;
	private JPasswordField passwordField;
	private int Mouse_X, Mouse_Y;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal frame = new principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public principal() {

		setLocationByPlatform(true);
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		PanelContenerdoGeneral = new JPanel();
		PanelContenerdoGeneral.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(PanelContenerdoGeneral);
		PanelContenerdoGeneral.setLayout(null);

		JPanel Panel_BackGround = new JPanel();
		Panel_BackGround.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		Panel_BackGround.setBackground(new Color(255, 255, 255));
		Panel_BackGround.setBounds(0, 0, 800, 600);
		PanelContenerdoGeneral.add(Panel_BackGround);
		Panel_BackGround.setLayout(null);

		JPanel panelPulpura = new JPanel();
		panelPulpura.setBackground(new Color(128, 0, 128));
		panelPulpura.setBounds(492, 0, 308, 600);
		Panel_BackGround.add(panelPulpura);
		panelPulpura.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - Mouse_X, y - Mouse_Y);
			}
		});
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Mouse_X = e.getX();
				Mouse_Y = e.getY();
				
				
			}
		});
		panel_2.setBackground(new Color(128, 0, 128));
		panel_2.setBounds(-493, 0, 801, 51);
		panelPulpura.add(panel_2);
		panel_2.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(128, 0, 128));
		panel_3.setBounds(725, 0, 100, 51);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		JLabel la_X_Cierre = new JLabel("X");
		la_X_Cierre.setBounds(-10, 0, 100, 51);
		panel_3.add(la_X_Cierre);
		la_X_Cierre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panel_3.setBackground(Color.red);
				la_X_Cierre.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_3.setBackground(new Color(128, 0, 128));
				la_X_Cierre.setForeground(Color.black);
			}
		});
		la_X_Cierre.setBackground(new Color(128, 0, 128));
		la_X_Cierre.setFont(new Font("Tahoma", Font.PLAIN, 22));
		la_X_Cierre.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel logoNombre = new JLabel("IBraim");
		logoNombre.setHorizontalAlignment(SwingConstants.CENTER);
		logoNombre.setFont(new Font("Roboto Black", Font.PLAIN, 24));
		logoNombre.setBounds(107, 51, 214, 53);
		Panel_BackGround.add(logoNombre);

		JLabel textoInicio = new JLabel("inicio de seccion");
		textoInicio.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		textoInicio.setBounds(29, 142, 236, 44);
		Panel_BackGround.add(textoInicio);

		JLabel textoUsario = new JLabel("Usuario\r\n");
		textoUsario.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		textoUsario.setBounds(29, 197, 236, 33);
		Panel_BackGround.add(textoUsario);

		barraNombre = new JTextField();
		barraNombre.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				if (barraNombre.getText().equals("Ingrese nombre de usuario")) {

					barraNombre.setText("");
					barraNombre.setForeground(Color.black);
				}
				
				if (String.valueOf(passwordField.getPassword()).isEmpty()) {
					passwordField.setText("********");
					passwordField.setForeground(Color.LIGHT_GRAY);
				};
			}
		});
		barraNombre.setBorder(null);
		barraNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		barraNombre.setForeground(new Color(169, 169, 169));
		barraNombre.setText("Ingrese nombre de usuario");
		barraNombre.setBounds(29, 228, 453, 33);
		Panel_BackGround.add(barraNombre);
		barraNombre.setColumns(10);

		JLabel textoContraseña = new JLabel("Contraseña\r\n");
		textoContraseña.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		textoContraseña.setBounds(29, 290, 236, 33);
		Panel_BackGround.add(textoContraseña);

		passwordField = new JPasswordField();
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (String.valueOf(passwordField.getPassword()).equals("********")) {
					passwordField.setText("");
					passwordField.setForeground(Color.black);
				};
				if (barraNombre.getText().isEmpty()) {
					barraNombre.setText("Ingrese nombre de usuario");
					barraNombre.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordField.setEchoChar('*');
		passwordField.setForeground(new Color(169, 169, 169));
		passwordField.setText("********");
		passwordField.setBorder(new EmptyBorder(0, 0, 2, 0));
		passwordField.setBounds(28, 334, 454, 33);
		Panel_BackGround.add(passwordField);

		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1.setBackground(new Color(199, 21, 133));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_1.setBackground(new Color(128, 0, 128));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Menu_principal menu = new Menu_principal(null);
				menu.setSize(800,600);
				menu.setLocation(0, 0);
				
				PanelContenerdoGeneral.removeAll();
				PanelContenerdoGeneral.add(menu,BorderLayout.CENTER);
				PanelContenerdoGeneral.revalidate();
				PanelContenerdoGeneral.repaint();
			}
		});
		panel_1.setBackground(new Color(128, 0, 128));
		panel_1.setBounds(124, 429, 236, 53);
		Panel_BackGround.add(panel_1);
		panel_1.setLayout(null);

		JLabel boton_inicial = new JLabel("Inicial");
		boton_inicial.setFont(new Font("Tahoma", Font.PLAIN, 17));
		boton_inicial.setForeground(new Color(255, 255, 255));
		boton_inicial.setBackground(new Color(128, 0, 128));
		boton_inicial.setHorizontalAlignment(SwingConstants.CENTER);
		boton_inicial.setBounds(71, 11, 85, 31);
		panel_1.add(boton_inicial);
	}
	
	public void volverAlPrincipal() {
        // Aquí puedes realizar acciones antes de volver al panel principal
        // como cerrar otras ventanas o limpiar recursos
        setContentPane(PanelContenerdoGeneral);
        revalidate();
        repaint();
    }
}
