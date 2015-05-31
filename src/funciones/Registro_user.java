package funciones;

import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import administrador.Conexion;

public class Registro_user implements ActionListener,KeyListener{

	Dialogo d=new Dialogo("Registro del Administador", 300, 200);
	
	JButton Registar,salir;
	JLabel Nombrel,pwl,titulo;
	JTextField nombre;
	JPasswordField pw;

	public Registro_user()
	{
		titulo=new JLabel("Administrador");
		titulo.setFont(new Font(null, 1, 20));
		titulo.setForeground(Color.WHITE);
		titulo.setBounds(100,0,200,20);
		
		nombre=new JTextField();
		nombre.setBounds(100,40,150,30);
		
		pw=new JPasswordField();
		pw.setBounds(100,80,150,20);
	
		
		Registar=new JButton("Registar");
		Registar.setForeground(Color.blue);
		Registar.setFont(new Font(null, 1, 12));
		Registar.setBounds(20,130,100,30);
		
		salir=new JButton("Salir");
		salir.setForeground(Color.blue);
		salir.setFont(new Font(null, 1, 12));
		salir.setBounds(180,130,100,30);
		
		Nombrel=new JLabel("Nombre:");
		Nombrel.setForeground(Color.WHITE);
		Nombrel.setFont(new Font(null, 1, 12));
		Nombrel.setBounds(10,40,100,30);
		
		
		pwl=new JLabel("Password:");
		pwl.setFont(new Font(null, 1, 12));
		pwl.setForeground(Color.WHITE);
		pwl.setBounds(10,80,100,20);
		
		
		
		d.add(Registar);
		d.add(titulo);
		d.add(nombre);
		d.add(pw);
		d.add(pwl);
		d.add(Nombrel);
		d.add(salir);
		d.add(new Fondo(d.getWidth(),d.getHeight()));
	
		salir.addActionListener(this);
		nombre.addKeyListener(this);
		pw.addKeyListener(this);
		Registar.addKeyListener(this);
		Registar.addActionListener(this);
		d.setDefaultCloseOperation(0);
		d.setVisible(true);
	
	}


	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource().equals(salir))
	{
	new Conexion().close();
	System.exit(0);
	}else
		if(e.getSource().equals(Registar))
		{
			if(pw.getText().equals("") || nombre.getText().equals("") )
			{
				new Mensaje().error("No dejes Campos Vacios", "Rellene los Campos");
				new Enfocar(nombre);
			}
			else
			{
				String vector[]=new String[9];
				vector[1]=nombre.getText();
				vector[2]=new Cod_pw().Codificacionm(pw.getText());
				vector[3]="1";
				vector[4]="1";
				vector[5]="1";
				vector[6]="1";
				vector[7]="1";
				vector[8]="1";
				new Conexion().Nuevo_usuario(vector);
				new Mensaje().listo("Administrador Registrado..", "Finalizado");
				d.dispose();
			}
		}
		
	}


	@SuppressWarnings("deprecation")
	@Override
	public void keyPressed(KeyEvent x) {
	
		if(x.getSource().equals(nombre)){	
		if(x.getKeyCode()==Event.ENTER)
	   {
		new Enfocar(pw);
	   }
		}
		else
		if(x.getSource().equals(pw)){	
			if(x.getKeyCode()==Event.ENTER)
		   {
			new Enfocar(Registar);
		   }
			}
		else
			if(x.getSource().equals(Registar)){	
				if(x.getKeyCode()==Event.ENTER)
			   {
			
					if(pw.getText().equals("") || nombre.getText().equals("") )
					{
						new Mensaje().error("No dejes Campos Vacios", "Rellene los Campos");
						new Enfocar(nombre);
					}
					else
					{
						String vector[]=new String[9];
						vector[1]=nombre.getText();
						vector[2]=new Cod_pw().Codificacionm(pw.getText());
						vector[3]="1";
						vector[4]="1";
						vector[5]="1";
						vector[6]="1";
						vector[7]="1";
						vector[8]="1";
						new Conexion().Nuevo_usuario(vector);
						new Mensaje().listo("Administrador Registrado..", "Finalizado");
						d.dispose();
					}
					
			   }
				}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {}
	@Override
	public void keyTyped(KeyEvent arg0) {}
}
