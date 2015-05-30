package administrador;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

import funciones.Dialogo;
import funciones.Enfocar;
import funciones.Fondo;
import funciones.Mensaje;

public class Loguin implements ActionListener,KeyListener  {
 
	JScrollPane barra;
	JComboBox<String> lista;
	JLabel user,pwl;
	JPasswordField pw;
	JButton salir,Entar;
	Dialogo d=new Dialogo("Identificacion", 300, 150);
	JLabel fondo;
	ImageIcon icono;
	public Loguin(JComboBox<String> list){	
		
		
		fondo=new JLabel();
		icono=new ImageIcon("Images\\login.png");
		fondo.setIcon(icono);
		fondo.setBounds(50,0,150,130);
		
		
		
    Entar=new JButton("Entrar");
	Entar.setFont(new Font(null,1, 15));
	Entar.setForeground(Color.blue);
	Entar.setBounds(50,90,80,30);
 
	salir=new JButton("Salir");
	salir.setFont(new Font(null,1, 15));
	salir.setForeground(Color.blue);
	salir.setBounds(160,90,80,30);
	pw=new JPasswordField();
	pw.setBounds(110,50,170,20);
	
	pwl=new JLabel("Contraseña:");
	pwl.setFont(new Font(null,1,14));
    pwl.setForeground(Color.WHITE);

	pwl.setBounds(15,50,100,20);
	
	user=new JLabel("Usuario:");
	user.setFont(new Font(null,1,14));
	user.setForeground(Color.WHITE);
	user.setBounds(15,15,100,20);
	lista=new JComboBox<>();
	barra=new JScrollPane(lista);
	barra.setBounds(110,10,170,35);
	lista.addItem("Seleccione");
	
	for(int i=0;i<list.getItemCount();i++)
	{
		lista.addItem(list.getItemAt(i));
	}
	lista.setCursor(new Cursor(12));
	lista.setFont(new Font(null, 1, 12));
	salir.setCursor(new Cursor(12));
	Entar.setCursor(new Cursor(12));

	d.add(barra);
	d.add(pwl);
	d.add(pw);
	d.add(user);
	d.add(salir);
	d.add(Entar);
	d.add(fondo);
	d.add(new Fondo(d.getWidth(),d.getHeight()));
	
	
	d.setDefaultCloseOperation(0);
	salir.addActionListener(this);
	Entar.addActionListener(this);
	lista.addKeyListener(this);
	pw.addKeyListener(this);
	d.setVisible(true);
	
	
	}


	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent w) {
	
		if(w.getSource().equals(salir))
		{
			new Conexion().close();
			System.exit(0);

		}
		else
		if(w.getSource().equals(Entar))
		{
			
			if(lista.getSelectedIndex()!=0)
			{
				if(new Conexion().entrar(pw.getText(),lista.getSelectedItem().toString())==true)
				{
					new Conexion();
					Conexion.cargar_privilegios(lista.getSelectedItem().toString());
					d.dispose();
				}
				else{
					new Mensaje().error("Contraseña Incorrecta", "Falla de Autentificación");
				    pw.setText("");
				    }
			}
			else{new Mensaje().error("Seleccione un usuario", "Seleccione");new Enfocar(lista);}
		}	
	}
	
	@SuppressWarnings("deprecation")
	public void keyPressed(KeyEvent a) {
	
		if(a.getSource().equals(lista))
		{
			if(a.getKeyCode()==Event.ENTER){new Enfocar(pw);}
		}
		else 
			if(a.getSource().equals(pw))
		{
			if(a.getKeyCode()==Event.ENTER)
			{
				if(lista.getSelectedIndex()!=0)
				{
					if(new Conexion().entrar(pw.getText(),lista.getSelectedItem().toString())==true)
					{
						new Conexion();
						Conexion.cargar_privilegios(lista.getSelectedItem().toString());
						d.dispose();
					}
					else{
						new Mensaje().error("Contraseña Incorrecta", "Falla de Autentificación");
					    pw.setText("");
					    }
				}
				else{new Mensaje().error("Seleccione un usuario", "Seleccion");new Enfocar(lista);}
			}
		}
		
	}



	public void keyReleased(KeyEvent b) {
	
		
	}



	public void keyTyped(KeyEvent c) {

		
	}

	
}
