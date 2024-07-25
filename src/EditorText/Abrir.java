package EditorText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class Abrir extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void abrir() {
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
//	public void abrir() {
//		creaPanel();
//
//		JFileChooser selecionArchivo = new JFileChooser();
//		selecionArchivo.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//		int resultado = selecionArchivo.showDialog(listAreaTexto.get(tPane.getSelectedIndex()), "Abrir");
//		//
//		if (resultado == JFileChooser.APPROVE_OPTION) {
//			try {
//				boolean exitePath = false;
//				for (int i = 0; i < tPane.getTabCount(); i++) {
//
//					File f = selecionArchivo.getSelectedFile();
//					if (listFile.get(i).getPath().equals(f.getPath()))
//						exitePath = true;
//				}
//
//				if (!exitePath) {
//					File archivo = selecionArchivo.getSelectedFile();
//					listFile.set(tPane.getSelectedIndex(), archivo);
//					FileReader entrada = new FileReader(listFile.get(tPane.getSelectedIndex()).getPath());
//
//					BufferedReader mibuffer = new BufferedReader(entrada);
//					String linea = "";
//					String titulo = listFile.get(tPane.getSelectedIndex()).getName();
//					tPane.setTitleAt(tPane.getSelectedIndex(), titulo);
//
//					while (linea != null) {
//						linea = mibuffer.readLine();// lector de archivo
//						if (linea != null)
//							Utilidades.append(linea + "\n", listAreaTexto.get(tPane.getSelectedIndex()));
//					}
//				} else {
//
//					// si la ruta del fichero ya existe y esta abierto
//					// vamos a correr todos los paneles para ver es el que tiene el path
//					// del fichero y selecionar este fichero y este panel
//					for (int i = 0; i < tPane.getTabCount(); i++) {
//						File f = selecionArchivo.getSelectedFile();
//						if (listFile.get(i).getPath().equals(f.getPath())) {
//							// seleciona el panel que ya tiene el archivo abierto
//							tPane.setSelectedIndex(i);// le pasamos por parametros la posicion del panel
//														// que tiene el path
//
//							listAreaTexto.remove(tPane.getTabCount() - 1);
//							listScroll.remove(tPane.getTabCount() - 1);
//							listFile.remove(tPane.getTabCount() - 1);
//							tPane.remove(tPane.getTabCount() - 1);
//							contador--;
//							break;
//
//						}
//					}
//
//				}
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		} else {
//			// por si se posiciona el boton de cancelar en la ventana de abrir archivo
//			// eliminamos el panel que se crea por defecto
//			//
//			int selecion = tPane.getSelectedIndex();
//			if (selecion != -1) {
//				listAreaTexto.remove(tPane.getTabCount() - 1);
//				listScroll.remove(tPane.getTabCount() - 1);
//				listFile.remove(tPane.getTabCount() - 1);
//				tPane.remove(tPane.getTabCount() - 1);
//				contador--;
//			}
//		}
//	}

}
