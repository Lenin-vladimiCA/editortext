package EditorText;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class Guardar extends Panel {

	private static final long serialVersionUID = 1L;

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
}
