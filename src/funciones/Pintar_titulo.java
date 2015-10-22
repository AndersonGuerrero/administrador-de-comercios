package funciones;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Pintar_titulo {
	public Pintar_titulo(JLabel label)
	{
		label.setForeground(Color.WHITE);
		label.setSize(200,30);
		label.setFont(new Font(null, 1, 20));
	}
}
