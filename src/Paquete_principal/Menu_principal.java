package Paquete_principal;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Editor.ventanaEditor;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.awt.event.MouseMotionAdapter;

public class Menu_principal extends JPanel {

	private static final long serialVersionUID = 1L;
	private JFrame parentFrame; 
	private int Mouse_X, Mouse_Y;

	
	/**
	 * Create the panel.
	 */
	public Menu_principal(JFrame frame) {
		

        setLayout(null);

        JPanel PanelContenedor = new JPanel();
        PanelContenedor.setBackground(new Color(255, 255, 255));
        PanelContenedor.setBounds(0, 0, 800, 600);
        add(PanelContenedor);
        PanelContenedor.setLayout(null);

        JPanel PanelMenu = new JPanel();
        PanelMenu.setBackground(new Color(128, 0, 128));
        PanelMenu.setBounds(0, 0, 800, 50);
        PanelContenedor.add(PanelMenu);
        PanelMenu.setLayout(null);

		JPanel PanelMenu1 = new JPanel();
		PanelMenu1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			   public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                parentFrame.setLocation(x - Mouse_X, y - Mouse_Y);
            }
        });
        PanelMenu1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Mouse_X = e.getX();
                Mouse_Y = e.getY();
            }
        });
	
		PanelMenu1.setBackground(new Color(128, 0, 128));
		PanelMenu1.setBounds(0, 0, 800, 50);
		PanelContenedor.add(PanelMenu1);
		PanelMenu1.setLayout(null);

		JPanel Boton_Atras = new JPanel();
		Boton_Atras.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				Boton_Atras.setBackground(new Color(199, 21, 133));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Boton_Atras.setBackground(new Color(128, 0, 128));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				principal frame = new principal();
				frame.setLocation(0, 0);
				frame.setSize(800,600);
				
				PanelContenedor.removeAll();
				PanelContenedor.add(frame,BorderLayout.CENTER);
				PanelContenedor.revalidate();
				PanelContenedor.repaint();
			}
		});
		Boton_Atras.setBackground(new Color(128, 0, 128));
		Boton_Atras.setBounds(0, 0, 100, 50);
		PanelMenu1.add(Boton_Atras);
		Boton_Atras.setLayout(null);

		JLabel boton_para_atras = new JLabel("Atras");
		boton_para_atras.addMouseListener(new MouseAdapter() {

		});

		boton_para_atras.setFont(new Font("Tahoma", Font.PLAIN, 18));
		boton_para_atras.setHorizontalAlignment(SwingConstants.CENTER);
		boton_para_atras.setBounds(10, 11, 64, 28);
		Boton_Atras.add(boton_para_atras);

		JPanel Boton_cierre = new JPanel();

		JLabel X = new JLabel("X");
		X.setHorizontalAlignment(SwingConstants.CENTER);
		X.setFont(new Font("Tahoma", Font.PLAIN, 18));
		X.setBounds(0, 0, 100, 50);
		Boton_cierre.add(X);

		Boton_cierre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Boton_cierre.setBackground(Color.red);
				X.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Boton_cierre.setBackground(new Color(128, 0, 128));
				X.setForeground(Color.black);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		Boton_cierre.setBackground(new Color(128, 0, 128));
		Boton_cierre.setBounds(700, 0, 100, 50);
		PanelMenu1.add(Boton_cierre);
		Boton_cierre.setLayout(null);

		movi = 120;
		JPanel Caja_java = new JPanel();
		Caja_java.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				

			}
		});
		Caja_java.setBounds(287, 121, 250, 400);
		PanelContenedor.add(Caja_java);
		Caja_java.setLayout(null);

		movi1 = 11;
		JPanel Imagen_java = new JPanel();
		Imagen_java.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Imagen_java.setBackground(new Color(255,80,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Imagen_java.setBackground(new Color(255, 69, 0));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				new ventanaEditor();
				
			}
		});
		Imagen_java.setBackground(new Color(255, 69, 0));
		Imagen_java.setBounds(10, movi1, 230, 378);
		Caja_java.add(Imagen_java);
		Imagen_java.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Java");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto Black", Font.PLAIN, 25));
		lblNewLabel.setBounds(10, 82, 210, 198);
		Imagen_java.add(lblNewLabel);

	}
	private int x = 0;
    private JFrame frame;
	private Timer timer;
	private int movi, movi1;

}
