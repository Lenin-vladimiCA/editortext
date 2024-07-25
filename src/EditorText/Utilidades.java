package EditorText;

import java.util.ArrayList;

import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class Utilidades {

	// ------------------------ESTO AGREGA TEXTO AL FINAL--------------------------
	JEditorPane pane = new JEditorPane();

	public static void append(String linea, JTextPane areaTexto) {
		try {
			Document doc = areaTexto.getDocument();
			doc.insertString(doc.getLength(), linea, null);

		} catch (BadLocationException exc) {
			exc.printStackTrace();
		}

	}
	// -----------------------------------------------------------------------------

	// ------------------------METODO PARA MOSTRAR ENUMERACION----------------------
	public static void Numeracion(boolean numeracion, JTextPane textoArea, JScrollPane scroll) {
		if (numeracion) {
			scroll.setRowHeaderView(new TextLineNumber(textoArea));
		} else {
			scroll.setRowHeaderView(scroll);
		}
	}

	public static void ver_Numeracion(int contador, boolean numeracion1, ArrayList<JTextPane> textoArea,
			ArrayList<JScrollPane> scroll) {

		if (numeracion1) {
			for (int i = 0; i < contador; i++) {
				scroll.get(i).setRowHeaderView(new TextLineNumber(textoArea.get(i)));
			}
		} else {
			for (int i = 0; i < contador; i++) {
				scroll.get(i).setRowHeaderView(null);
			}
		}

	}
	// -----------------------------------------------------------------------------
}