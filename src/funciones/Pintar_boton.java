package funciones;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;

public class Pintar_boton {
  
	
	public Pintar_boton(JButton boton)
	{
		boton.setForeground(Color.blue);
		boton.setCursor(new Cursor(12));
		boton.setFont(new Font(null, 1, 15));
	}
	
	
	
}
