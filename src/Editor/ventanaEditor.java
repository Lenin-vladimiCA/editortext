package Editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.nio.file.DirectoryStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import compilerTools.Directory;
import compilerTools.ErrorLSSL;
import compilerTools.Functions;
import compilerTools.Production;
import compilerTools.TextColor;
import compilerTools.Token;

public class ventanaEditor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	// ESTO SILVE PARA EL COMPILADOR DE TEXTO
	private String titulo;
	private ArrayList<Token> token;
	private ArrayList<ErrorLSSL> error;
	private ArrayList<TextColor> ColorTexto;
	private ArrayList<Production> indenPro;
	private Directory directorio;
	private Timer timer;
	private HashMap<String, String> inden;
	private boolean codeHasCompile = false;

	// Visualizacion de la ventana
	public ventanaEditor() {
		init();
	}

	public void init() {

		JFrame frame = new JFrame("IBrain");
		// setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setSize(800, 600);
		add(new Panel(null));
		setVisible(true);
		titulo = "IBrain";
		directorio = new Directory(this, Panel.areaTexto, titulo, "robo");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				directorio.Exit();
				System.exit(0);
			}
		});
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				// Aquí se produce el error: "Cannot resolve symbol 'System'"
				timer.cancel();
				colorAnalitico();
			}
		}, 0, 300);
		Functions.insertAsteriskInName(this, Panel.areaTexto, () -> {
			timer.cancel();
			restartTimer();
		});
		token = new ArrayList<>();
		error = new ArrayList<>();
		ColorTexto = new ArrayList<>();
		indenPro = new ArrayList<>();
		inden = new HashMap<>();
		Functions.setAutocompleterJTextComponent(new String[] { "color", "numero", "este" }, Panel.areaTexto, () -> {
			timer.cancel();
			restartTimer();
		});
	}

	public void startTimer() {
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				// Código a ejecutar cada vez que el temporizador se activa
				System.out.println("Timer running...");
			}
		}, 0, 3000); // Ejecuta cada 3 segundos
	}

	public void restartTimer() {
		if (timer != null) {
			timer.cancel();
		}
		startTimer();
	}

	private void colorAnalitico() {

	}

}