package funciones;

import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Mensaje extends JDialog implements ActionListener,KeyListener {

	JButton aceptar;
	ImageIcon icon1,icon2;
	JLabel mensaje,icon;
	JButton si,no;
	JButton aceptar2,cancelar;
	int y;
	JTextField dato_txt;
	public static String dato,tipo;
	public static boolean resp; 
	public static boolean resp_inpout;
	public void error(String msj,String titulo)
	{
		icon1=new ImageIcon("Images//error.png");
		icon=new JLabel();
		icon.setIcon(icon1);
		icon.setBounds(10,10,50,50);
		
		aceptar=new JButton("Aceptar");
		aceptar.setFont(new Font(null, 1, 12));
		new Pintar_boton(aceptar);
		aceptar.setBounds(150,60,100,30);
		
		new Enfocar(aceptar);
		setSize(300+(msj.length()*4),150);
		mensaje=new JLabel(msj);
		mensaje.setFont(new Font(null, 1, 12));
		new Pintar_label(mensaje);
		mensaje.setBounds(60,20,getWidth(),20);
		
		
		setModal(true);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(this);
		setTitle(titulo);
		add(mensaje);
		add(aceptar);
		add(icon);
		add(new Fondo(getWidth()+4,getHeight()-12));
		aceptar.addActionListener(this);
		aceptar.addKeyListener(this);
		setDefaultCloseOperation(0);
		setVisible(true);
	}
	
	
	public void listo(String msj,String titulo)
	{
		icon1=new ImageIcon("Images//ok.png");
		icon=new JLabel();
		icon.setIcon(icon1);
		icon.setBounds(10,10,50,50);

		mensaje=new JLabel(msj);
		mensaje.setFont(new Font(null, 1, 12));
	   new Pintar_label(mensaje);
		mensaje.setBounds(60,20,1000,20);		
		setSize(300+(msj.length()*2),150);
		aceptar=new JButton("Aceptar");
		aceptar.setFont(new Font(null, 1, 12));
	    new Pintar_boton(aceptar);
		aceptar.setBounds(150,80,100,30);
		new Enfocar(aceptar);
		aceptar.addActionListener(this);
		aceptar.addKeyListener(this);
		setModal(true);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(this);
		setTitle(titulo);
		add(mensaje);
		add(aceptar);
		add(icon);
		add(new Fondo(getWidth(),150));
		setDefaultCloseOperation(0);
		setVisible(true);
		
	}


	
	public void pregunta(String msj,String titulo)
	{
		
		icon1=new ImageIcon("Images//pregunta.png");
		icon=new JLabel();
		icon.setIcon(icon1);
		icon.setBounds(10,10,50,50);

		mensaje=new JLabel(msj);
		mensaje.setFont(new Font(null, 1, 12));
		
	    new Pintar_label(mensaje);
		mensaje.setBounds(60,20,1000,20);		
		setSize(300+msj.length(),150);
		
		si=new JButton("Si");
	    new Pintar_boton(si);
		si.setBounds(20,80,100,30);
		new Enfocar(si);

		
		no=new JButton("No");
	    new Pintar_boton(no);
	    no.setBounds(150,80,100,30);
		new Enfocar(si);
		
		si.addActionListener(this);
		si.addKeyListener(this);
		no.addActionListener(this);
		no.addKeyListener(this);
		setModal(true);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(this);
		setTitle(titulo);
		add(mensaje);
		add(si);
		add(no);
		add(icon);
		add(new Fondo(getWidth(),150));
	   resp=false;
	   setDefaultCloseOperation(0);
		setVisible(true);
		
	}
	
	
	public void inpout(String msj,String titulo,String tipo)
	{
		icon1=new ImageIcon("Images//pregunta.png");
		icon=new JLabel();
		icon.setIcon(icon1);
		icon.setBounds(10,10,50,50);

		dato_txt=new JTextField();
	    new Pintar_txt(dato_txt);
	    dato_txt.setBounds(60,40,210,30);
		
		mensaje=new JLabel(msj);
		mensaje.setFont(new Font(null, 1, 12));
		
	    new Pintar_label(mensaje);
		mensaje.setBounds(60,20,1000,20);		
		setSize(300+msj.length(),150);
		
		aceptar2=new JButton("Aceptar");
	    new Pintar_boton(aceptar2);
	    aceptar2.setBounds(60,80,100,30);
		new Enfocar(aceptar2);

		
		cancelar=new JButton("cancelar");
	    new Pintar_boton(cancelar);
	    cancelar.setBounds(170,80,100,30);
		new Enfocar(dato_txt);
		
		aceptar2.addActionListener(this);
		aceptar2.addKeyListener(this);
		cancelar.addActionListener(this);
		cancelar.addKeyListener(this);
		dato_txt.addKeyListener(this);
		setModal(true);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(this);
		setTitle(titulo);
		add(mensaje);
		add(aceptar2);
		add(dato_txt);
		add(cancelar);
		add(icon);
		dato="";
		add(new Fondo(getWidth(),150));
	    resp_inpout=false;
	    Mensaje.tipo=tipo;
	    setDefaultCloseOperation(0);
		setVisible(true);
		
	}
	
	
public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(si))
		{
		resp=true;
		dispose();
		}	
		else
		if(e.getSource().equals(no))
		{
		resp=false;
		dispose();
		}	
		else
		if(e.getSource().equals(aceptar)){
		this.dispose();
		}
		else
			
		if(e.getSource().equals(aceptar2))
		{
			if(dato_txt.getText().length()>=1){
				dato=dato_txt.getText();
				resp_inpout=true;
				dispose();}
			else
			{
				if(tipo.equals("telefono")){new Mensaje().error("Introduzca Un Numero Telefonico Valido", "Telefono no Valido");new Enfocar(dato_txt);}
				if(tipo.equals("dinero")){new Mensaje().error("Introduzca Valores Validos", "Monto no Valido");new Enfocar(dato_txt);}
			}
		}      
		else
			if(e.getSource().equals(cancelar))
			{
			resp_inpout=false;
			dato="0.00";
			dispose();
			}  	
	
	}

	public void keyPressed(KeyEvent arg0) {
	
		
		if(arg0.getSource().equals(dato_txt))
		{
			if(arg0.getKeyCode()==Event.ENTER)
			{
				new Enfocar(aceptar2);
			}
		}
		else
		if(arg0.getSource().equals(no))
		{
			if(arg0.getKeyCode()==Event.ENTER)
			{
				resp=false;
				dispose();
			}
		}
		else
		if(arg0.getSource().equals(si))
		{
			if(arg0.getKeyCode()==Event.ENTER){resp=true;dispose();}
		}
		else
		if(arg0.getSource().equals(aceptar)){
			
		if(arg0.getKeyCode()==Event.ENTER)
	       {dispose();}
		}
		else
		if(arg0.getSource().equals(aceptar2)){
			
			if(arg0.getKeyCode()==Event.ENTER)
		       {
				if(dato_txt.getText().length()>=1){
				dato=dato_txt.getText();
				resp_inpout=true;
				dispose();}
		       }
			else
			{
				if(tipo.equals("numero")){new Mensaje().error("Introduzca Un Valor Valido", "Valor no Valido");}
				if(tipo.equals("telefono")){new Mensaje().error("Introduzca Un Numero Telefonico Valido", "Telefono no Valido");}
				if(tipo.equals("dinero")){new Mensaje().error("Introduzca Valores Validos", "Monto no Valido");}
				
			}
			}
		else
			if(arg0.getSource().equals(cancelar)){
				
				if(arg0.getKeyCode()==Event.ENTER)
			       {resp_inpout=false;
			       dato="";
					dispose();}
				}
	}

	public void keyReleased(KeyEvent arg0) {}

	public void keyTyped(KeyEvent arg0) {
		if(arg0.getSource().equals(dato_txt))
		{
			char x= arg0.getKeyChar();
			
			if(tipo=="entero"  || tipo=="telefono"){
			if((x<'0' || x>'9') && x!='-' && x!='.')
			{
				arg0.consume();
			}}
			else
				if(tipo=="nombre"){
					if((x<'a' || x>'z') && (x<'A' || x>'Z') && arg0.getKeyCode()!=Event.ESCAPE)
					{
						arg0.consume();
					}}
			if(tipo=="dinero"){
				if((x<'0' || x>'9') && x!='.' && arg0.getKeyCode()!=Event.ESCAPE)
				{
					arg0.consume();
				}}
		}
	}
}