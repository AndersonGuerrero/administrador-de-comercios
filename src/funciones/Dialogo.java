package funciones;

import javax.swing.JDialog;

@SuppressWarnings("serial")
public class Dialogo extends JDialog{

	public Dialogo(String titulo, int x,int y)
	{
		
		
		
	setLayout(null);
    setModal(true);
	setTitle(titulo);
	setSize(x,y);
	setLocationRelativeTo(this);
	setResizable(false);
	
	
	
	
	}
	
}
