package EditorText;

public class Edita extends Panel {

	private static final long serialVersionUID = 1L;

	public void Deshacer() {

		if (ListManager.get(tPane.getSelectedIndex()).canUndo())
			System.out.println("");
		else
			System.out.println("no se puede");
	}

	public void Rehacer() {

	}

}
