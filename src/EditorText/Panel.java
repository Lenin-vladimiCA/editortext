package EditorText;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.text.DefaultEditorKit;
import javax.swing.undo.UndoManager;

public class Panel extends JPanel {

	private static final long serialVersionUID = 1L;

	public Panel() {
		setVisible(true);
		setLayout(new BorderLayout());

//--------------------------------------Area del Menu---------------------------------------------
		JPanel PanelMenu = new JPanel();
		PanelMenu.setBackground(Color.BLUE);
		menubar = new JMenuBar();
		archivo = new JMenu("Archivo");
		editar = new JMenu("Editar");
		seleccion = new JMenu("Seleccion");
		ver = new JMenu("Ver");
		apariencia = new JMenu("Apariencia");

		menubar.add(archivo);
		menubar.add(editar);
		menubar.add(seleccion);
		menubar.add(ver);

		// ---------------ELEMENTO DEL MENU ARCHIVOS-----------
		creaItem("Nuevo Archivo", "archivo", "nuevo");
		creaItem("Abrir Archivo", "archivo", "abrir");
		creaItem("Guardar", "archivo", "guardar");
		creaItem("Guardar Como..", "archivo", "guardarComo");
		// ----------------------------------------------------

		// ---------- ELEMENTO DEL MENU EDIIAR-----------------
		creaItem("Deshacer", "editar", "deshacer");
		creaItem("Rehacer", "editar", "rehacer");
		editar.addSeparator();
		creaItem("Cortar", "editar", "cortar");
		creaItem("Copiar", "editar", "copiar");
		creaItem("Pegar", "editar", "pegar");
		// ----------------------------------------------------

		// -----------ELEMENTO DEL MENU SELECCION--------------
		creaItem("Seleccionar todo", "seleccion", "seleccion");
		// ----------------------------------------------------

		// ------------------ ELEMENTO DEL MENU VER------------
		creaItem("Numeracion", "ver", "numeracion");
		ver.add(apariencia);
		creaItem("normal", "apariencia", "");
		creaItem("Dark", "apariencia", "");
		PanelMenu.setLayout(new BorderLayout(0, 0));

		// ----------------------------------------------------

		PanelMenu.add(menubar, BorderLayout.NORTH);
		// ----------------------------------------------------

		// -------------------TEXTO----------------------------
		tPane = new JTabbedPane();
		listFile = new ArrayList<File>();
		listAreaTexto = new ArrayList<JTextPane>();
		listScroll = new ArrayList<JScrollPane>();
		ListManager = new ArrayList<UndoManager>();
		// ----------------------NORTH-------------------------

		add(PanelMenu, BorderLayout.NORTH);
		add(tPane, BorderLayout.CENTER);
//		new ventanaEditor();
//		new JFrame("Editor de Texto");
////		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setSize(800, 600);
//		add(new Panel());
//		setVisible(true);

	}

	public void creaItem(String rotulo, String menu, String accion) {
		elementoItem = new JMenuItem(rotulo);

		// -------------------------FUNCIONALIDADES DE ARCHIVO---------------------

		if (menu.equals("archivo")) {
			archivo.add(elementoItem);

			// esta linea de codigo crea un nuevo panel para escribir el codigo
			if (accion.equals("nuevo"))
				elementoItem.addActionListener(e -> creaPanel());

			// APERTURA DE ELEMENTO
			else if (accion.equals("abrir"))
				elementoItem.addActionListener(e -> Abrir());

			// GUARDARDO DE ELEMENTOS
			else if (accion.equals("guardar"))
				elementoItem.addActionListener(e -> Guardar_Archivo());

			// GUARDADO DE ELEMENTOS YA CREADOS
			else if (accion.equals("guardarComo"))
				elementoItem.addActionListener(e -> Guardar_Archivo_Como());
		}

		// -----------------------FUNCIONALIDADES DE EDITAR---------------------

		else if (menu.equals("editar")) {
			editar.add(elementoItem);
			if (accion.equals("deshacer"))
				elementoItem.addActionListener(e -> Deshacer());

			else if (accion.equals("rehacer"))
				elementoItem.addActionListener(e -> Rehacer());

			else if (accion.equals("cortar"))
				elementoItem.addActionListener(new DefaultEditorKit.CutAction());

			else if (accion.equals("pegar"))
				elementoItem.addActionListener(new DefaultEditorKit.PasteAction());

			else if (accion.equals("copiar"))
				elementoItem.addActionListener(new DefaultEditorKit.CopyAction());
		}

		// -------------------------FUNCIONALIDADES DE
		// SELECCION-----------------------------
		else if (menu.equals("seleccion")) {
			seleccion.add(elementoItem);

			if (accion.equals("seleccion"))
				elementoItem.addActionListener(e -> Seleccion());
		}
		// -------------------------FUNCIONALIDADES DE VER
		// ----------------------
		else if (menu.equals("ver")) {
			ver.add(elementoItem);
			if (accion.equals("numeracion"))
				elementoItem.addActionListener(e -> ver());
		}
		// ----------------------FUNCIONALIDADES DE
		// APARIENCIA----------------------------
		else if (menu.equals("apariencia"))
			apariencia.add(elementoItem);

	}

	// FUNCIONALIDAD DE ABRIR
	public void Abrir() {
		// Abrir abr = new Abrir();
		// abr.abrir();

		creaPanel();

		JFileChooser selecionArchivo = new JFileChooser();
		selecionArchivo.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int resultado = selecionArchivo.showDialog(listAreaTexto.get(tPane.getSelectedIndex()), "abrir");
		//
		if (resultado == JFileChooser.APPROVE_OPTION) {
			try {
				boolean exitePath = false;
				for (int i = 0; i < tPane.getTabCount(); i++) {

					File f = selecionArchivo.getSelectedFile();
					if (listFile.get(i).getPath().equals(f.getPath()))
						exitePath = true;
				}

				if (!exitePath) {
					File archivo = selecionArchivo.getSelectedFile();
					listFile.set(tPane.getSelectedIndex(), archivo);
					FileReader entrada = new FileReader(listFile.get(tPane.getSelectedIndex()).getPath());

					BufferedReader mibuffer = new BufferedReader(entrada);
					String linea = "";
					String titulo = listFile.get(tPane.getSelectedIndex()).getName();
					tPane.setTitleAt(tPane.getSelectedIndex(), titulo);

					while (linea != null) {
						linea = mibuffer.readLine();// lector de archivo
						if (linea != null)
							Utilidades.append(linea + "\n", listAreaTexto.get(tPane.getSelectedIndex()));
					}
				} else {

					// si la ruta del fichero ya existe y esta abierto
					// vamos a correr todos los paneles para ver es el que tiene el path
					// del fichero y selecionar este fichero y este panel
					for (int i = 0; i < tPane.getTabCount(); i++) {
						File f = selecionArchivo.getSelectedFile();
						if (listFile.get(i).getPath().equals(f.getPath())) {
							// seleciona el panel que ya tiene el archivo abierto
							tPane.setSelectedIndex(i);// le pasamos por parametros la posicion del panel
														// que tiene el path

							listAreaTexto.remove(tPane.getTabCount() - 1);
							listScroll.remove(tPane.getTabCount() - 1);
							listFile.remove(tPane.getTabCount() - 1);
							tPane.remove(tPane.getTabCount() - 1);
							contador--;
							break;

						}
					}

				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {
			// por si se posiciona el boton de cancelar en la ventana de abrir archivo
			// eliminamos el panel que se crea por defecto
			//
			int selecion = tPane.getSelectedIndex();
			if (selecion != -1) {
				listAreaTexto.remove(tPane.getTabCount() - 1);
				listScroll.remove(tPane.getTabCount() - 1);
				listFile.remove(tPane.getTabCount() - 1);
				tPane.remove(tPane.getTabCount() - 1);
				contador--;
			}
		}
	}

	// FUNCIONALIDAD DE GUARDAR
	public void Guardar_Archivo() {
		if (listFile.get(tPane.getSelectedIndex()).getPath().equals("")) {
			JFileChooser guardarArchivo = new JFileChooser();
			int opc = guardarArchivo.showSaveDialog(null);

			if (opc == JFileChooser.APPROVE_OPTION) {
				System.out.println("haz salvado el archivo");
				File file = guardarArchivo.getSelectedFile();
				listFile.set(tPane.getSelectedIndex(), file);
				tPane.setTitleAt(tPane.getSelectedIndex(), file.getName());

				try {
					FileWriter fw = new FileWriter(listFile.get(tPane.getSelectedIndex()).getPath());
					String texto = listAreaTexto.get(tPane.getSelectedIndex()).getText();

					for (int i = 0; i < texto.length(); i++) {
						fw.write(texto.charAt(i));
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	}

	// FUNCIONALIDAD DE GUARDAR COMO
	public void Guardar_Archivo_Como() {
		JFileChooser guardarArchivo = new JFileChooser();
		int opc = guardarArchivo.showSaveDialog(null);

		if (opc == JFileChooser.APPROVE_OPTION) {

			File file = guardarArchivo.getSelectedFile();
			listFile.set(tPane.getSelectedIndex(), file);
			tPane.setTitleAt(tPane.getSelectedIndex(), file.getName());

			try {
				FileWriter fw = new FileWriter(listFile.get(tPane.getSelectedIndex()).getPath());
				String texto = listAreaTexto.get(tPane.getSelectedIndex()).getText();

				for (int i = 0; i < texto.length(); i++) {
					fw.write(texto.charAt(i));
				}

				fw.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	// FUNCIONALIDA DE DESHACER
	public void Deshacer() {
		if (ListManager.get(tPane.getSelectedIndex()).canUndo())
			ListManager.get(tPane.getSelectedIndex()).undo();

	}

	// FUNCIONALIDA DE REHACER
	public void Rehacer() {
		if (ListManager.get(tPane.getSelectedIndex()).canRedo())
			ListManager.get(tPane.getSelectedIndex()).redo();
		;
	}

	public void Seleccion() {
		listAreaTexto.get(tPane.getSelectedIndex()).selectAll();

	}

	public void ver() {

		numeracion = !numeracion;
		Utilidades.ver_Numeracion(contador, numeracion, listAreaTexto, listScroll);
	}

	// CREACION DE PANELES NUEVOS
	public void creaPanel() {
		// ------------------Area del paneles--------------------
		ventana = new JPanel();

		listFile.add(new File(""));// agrega documento a la lista
		listAreaTexto.add(new JTextPane());// agrega areas de texto
		listScroll.add(new JScrollPane(listAreaTexto.get(contador))); // agrega barras a los paneles
		ListManager.add(new UndoManager());// esto rastre los cambios del area de texto

		// esto rastrea por panel
		listAreaTexto.get(contador).getDocument().addUndoableEditListener(ListManager.get(contador));
		// ------------------------------------------------------
		ventana.add(listScroll.get(contador));

		tPane.add("title", ventana);
		Utilidades.Numeracion(numeracion, listAreaTexto.get(contador), listScroll.get(contador));
		tPane.setSelectedIndex(contador);
		contador++;
		existPanel = true;
	}

	private boolean numeracion = true;
	protected int contador = 0;
	protected boolean existPanel = false;
	protected JTabbedPane tPane;
	protected JPanel ventana, PanelMenu;
	protected ArrayList<JTextPane> listAreaTexto;
	protected ArrayList<JScrollPane> listScroll;
	protected ArrayList<File> listFile;
	protected ArrayList<UndoManager> ListManager;
	protected JTextPane areaTexto;
	protected JMenuBar menubar;
	protected JMenu archivo, editar, seleccion, ver, apariencia;
	protected JMenuItem elementoItem;

}
