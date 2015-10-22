package administrador;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import funciones.Dialogo;
import funciones.Fondo;
import funciones.Mensaje;

public class Loguin_confg implements ActionListener,KeyListener  {
 
	JLabel pwl;
	JPasswordField pw;
	JButton salir,Entar;
	Dialogo d=new Dialogo("Identificacion", 430, 180);
	JLabel fondo;
	ImageIcon icono;
	public Loguin_confg(){	
		
		
		fondo=new JLabel();
		icono=new ImageIcon("Images//login.png");
		fondo.setIcon(icono);
		fondo.setBounds(50,0,150,130);
		
		
		
    Entar=new JButton("Entrar");
	Entar.setFont(new Font(null,1, 15));
	Entar.setForeground(Color.blue);
	Entar.setBounds(80,90,100,30);
 
	salir=new JButton("Cancelar");
	salir.setFont(new Font(null,1, 15));
	salir.setForeground(Color.blue);
	salir.setBounds(250,90,100,30);
	pw=new JPasswordField();
	pw.setBounds(110,50,300,30);
	
	pwl=new JLabel("Contraseña:");
	pwl.setFont(new Font(null,1,14));
    pwl.setForeground(Color.WHITE);

	pwl.setBounds(15,55,100,20);

	salir.setCursor(new Cursor(12));
	Entar.setCursor(new Cursor(12));

	d.add(pwl);
	d.add(pw);
	d.add(salir);
	d.add(Entar);
	d.add(fondo);
	d.add(new Fondo(d.getWidth()+4,d.getHeight()-12));
	
	d.setDefaultCloseOperation(0);
	salir.addActionListener(this);
	Entar.addActionListener(this);
	pw.addKeyListener(this);
	d.setVisible(true);
	
	
	}


	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent w) {
	
		if(w.getSource().equals(salir))
		{
			d.dispose();
		}
		else
		if(w.getSource().equals(Entar))
		{
				if(pw.getText().equals(Inicio.users.getXclaveconfg()))
				{
					d.dispose();
					new Configuracion();
				}else{
					new Mensaje().error("Contraseña Incorrecta", "Falla de Autentificacion");
				}
		}	
	}
	

	public void keyPressed(KeyEvent a) {}

	public void keyReleased(KeyEvent b) {}

	public void keyTyped(KeyEvent c) {}	
}