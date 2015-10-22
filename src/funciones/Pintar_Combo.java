package funciones;

import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JComboBox;

public class Pintar_Combo {

	public Pintar_Combo(JComboBox<String> combo)
	{
		combo.setFont(new Font(null, 1, 12));
		combo.setCursor(new Cursor(12));
	}
}
