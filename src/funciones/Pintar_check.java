package funciones;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JCheckBox;

public class Pintar_check {
	public Pintar_check(JCheckBox check)
	{
		check.setForeground(Color.WHITE);
		check.setCursor(new Cursor(12));
		check.setFont(new Font(null, 1, 12));
	}
}
