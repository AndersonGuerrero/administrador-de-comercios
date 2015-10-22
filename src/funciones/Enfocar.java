package funciones;

import java.awt.Component;

import javax.swing.SwingUtilities;

public class Enfocar {
	
	public Enfocar(final Component objeto)
	{
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
			objeto.requestFocus();
				
			}
		});
		
	}
}
