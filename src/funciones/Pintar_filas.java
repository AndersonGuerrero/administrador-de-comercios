package funciones;

import java.awt.Color;

import javax.swing.JTable;

public class Pintar_filas {

	 private Color colorx = new Color(0x666f7A);
	 
	public Pintar_filas(JTable tabla)
	{
		tabla.setRowHeight(30);
		tabla.setSelectionBackground(colorx);
		tabla.setSelectionForeground(Color.WHITE);
	}
	
}
