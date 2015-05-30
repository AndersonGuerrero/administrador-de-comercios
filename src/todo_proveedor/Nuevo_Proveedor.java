package todo_proveedor;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import funciones.Dialogo;
import funciones.Enfocar;
import funciones.Fondo;
import funciones.Mensaje;
import funciones.Pintar_Combo;
import funciones.Pintar_boton;
import funciones.Pintar_label;
import funciones.Pintar_txt;
import funciones.Pintar_txtarea;

public class Nuevo_Proveedor implements ActionListener,KeyListener,MouseListener{

	JButton guardar,borrar;
	JLabel id_proveedorl,nombrel,direccionl,correol,codigo_poastall,telefonol,faxl,vendedorl,aroba;
	JTextArea direccion;
	JScrollPane barra,barra_codigos;
	JTextField id_proveedor,nombre,correo,codigo_poastal,fax,vendedor;
	JComboBox<String> lista,telefonos,codigos;
	ImageIcon icono;
	JLabel mas,codigosl;
	Fondo fondo;
	public Nuevo_Proveedor() {
		
	Dialogo d=new Dialogo("NUEVO PROVEEDOR", 725,230);
	
	codigos=new JComboBox<String>();
	barra_codigos = new JScrollPane(codigos);
	barra_codigos.setBounds(300, 15, 100,40);
	new Pintar_Combo(codigos);
	
	
	//--------------------------------------------------------
	
	new Conexion_proveedor().llenar_combo(codigos);
	
	//-------------------------------------------------------
	
	codigosl=new JLabel("Registrados:");
	new Pintar_label(codigosl);
	codigosl.setBounds(210,25,100,20);
	
	mas=new JLabel();
	icono=new ImageIcon("Images\\mas.png");
	mas.setIcon(icono);
	mas.setBounds(675,53, 50,30);
	mas.setCursor(new Cursor(12));
	
	fondo=new  Fondo(0, 0);
	fondo.setBackground(Color.gray);
	fondo.setBounds(9,0,d.getWidth()-23,d.getHeight()-27);
	
	lista =new JComboBox<String>();
	lista.addItem("Seleccione");
	lista.addItem("gmail.com");
	lista.addItem("hotmail.com");
	lista.addItem("yahoo.es");
	new Pintar_Combo(lista);
	
	id_proveedorl=new JLabel("Codigo:");
	id_proveedorl.setBounds(15, 25, 100,20);
	new Pintar_label(id_proveedorl);
	id_proveedor=new JTextField("P-");
	id_proveedor.setBounds(100, 20, 100,30);
	new Pintar_txt(id_proveedor);
	
	
	nombrel=new JLabel("Nombre:");
	nombrel.setBounds(15, 55, 100,20);
	new Pintar_label(nombrel);
	
	nombre=new JTextField();
	nombre.setBounds(100, 50, 150,30);
	new Pintar_txt(nombre);
	
	direccionl=new JLabel("Direccion:");
	direccionl.setBounds(15, 85, 100,20);
	new Pintar_label(direccionl);
	
	direccion=new JTextArea();
	new Pintar_txtarea(direccion);
	barra=new JScrollPane(direccion);
	barra.setBounds(100, 80, 300,70);
	
	correol=new JLabel("E-Mail:");
	correol.setBounds(15, 155, 100,20);
	new Pintar_label(correol);
	
	correo=new JTextField();
	correo.setBounds(100, 150, 170,30);
	new Pintar_txt(correo);
	
	aroba=new JLabel("@");
	aroba.setBounds(270, 150, 50,25);
	new Pintar_label(aroba);
	aroba.setFont(new Font(null, 1, 20));
	lista.setBounds(290, 150, 110,30);
	
	
	
	codigo_poastall=new JLabel("Codigo Postal:");
	codigo_poastall.setBounds(410, 20, 100,20);
	new Pintar_label(codigo_poastall);
	
	codigo_poastal=new JTextField();
	codigo_poastal.setBounds(540, 20, 130,30);
	new Pintar_txt(codigo_poastal);
	
	telefonol=new JLabel("Telefonos:");
	telefonol.setBounds(410, 50, 100,20);
	new Pintar_label(telefonol);
	
	telefonos=new JComboBox<>();
    telefonos.setBounds(540, 50, 130,30);
    new Pintar_Combo(telefonos);
	
	faxl=new JLabel("Fax:");
    faxl.setBounds(410, 80, 100,20);
    new Pintar_label(faxl);
    
    fax=new JTextField();
    fax.setBounds(540, 80, 130,30);
    new Pintar_txt(fax);
    
    vendedorl=new JLabel("Nombre de Vendedor:");
    vendedorl.setBounds(410,115, 130,20);
    new Pintar_label(vendedorl);
    
    vendedor=new JTextField();
    vendedor.setBounds(540, 110, 130,30);
	new Pintar_txt(vendedor);
	
	borrar=new JButton("Limpiar");
	new Pintar_boton(borrar);
	borrar.setBounds(570,150,100,30);
	
	guardar=new JButton("Guardar");
	new Pintar_boton(guardar);
	guardar.setBounds(410,150,100,30);
	
	
	
	d.add(id_proveedor);d.add(id_proveedorl);
	d.add(nombre);d.add(nombrel);
	
	d.add(correo);d.add(correol);d.add(lista);d.add(aroba);
	d.add(codigo_poastal);d.add(codigo_poastall);
	d.add(telefonos);
	d.add(mas);
	d.add(codigosl);
	d.add(barra_codigos);
	d.add(telefonol);
	d.add(fax);d.add(faxl);
	d.add(vendedor);d.add(vendedorl);
	d.add(barra);d.add(direccionl);
	d.add(guardar);d.add(borrar);
	d.add(fondo);
	new Enfocar(id_proveedor);
	mas.addMouseListener(this);
	guardar.addActionListener(this);
	correo.addKeyListener(this);
	id_proveedor.addKeyListener(this);
	nombre.addKeyListener(this);
	vendedor.addKeyListener(this);
	codigo_poastal.addKeyListener(this);
	fax.addKeyListener(this);
	borrar.addActionListener(this);
	d.setVisible(true);
	
	
	
	}
	
	public void actionPerformed(ActionEvent a) {
	
		if(a.getSource().equals(guardar))
		{
			if(id_proveedor.getText().equals("") ||  id_proveedor.getText().equals("P-") || nombre.getText().equals("") || direccion.getText().equals("") 
					  || telefonos.getItemCount()<=0
					  || vendedor.getText().equals(""))
			{
				if(id_proveedor.getText().equals("") || id_proveedor.getText().equals("P-") ){new Mensaje().error("Rellene el campo del codigo del proveedor", "Rellene Todos los Campos");new Enfocar(id_proveedor);}
				else if( nombre.getText().equals("")){new Mensaje().error("Rellene el campo del nombre del proveedor", "Rellene Todos los Campos");new Enfocar(nombre);}
				else if( direccion.getText().equals("")){new Mensaje().error("Introduzca la direccion del proveedor", "Rellene Todos los Campos");new Enfocar(direccion);}
				else if(telefonos.getItemCount()<=0){new Mensaje().error("Introduzca un numero telefonico para el proveedor", "Rellene Todos los Campos");new Enfocar(telefonos);}
				else if(vendedor.getText().equals("")){new Mensaje().error("Introduzca el nombre del Vendedor", "Rellene Todos los Campos");new Enfocar(vendedor);}
			}
			else
			{
				Proveedor pro=new Proveedor();			
			    pro.setId(id_proveedor.getText());
		    	pro.setNombre(nombre.getText());
			pro.setDireccion(direccion.getText());
			pro.setCorrero(correo.getText()+"@"+lista.getSelectedItem().toString());
			pro.setCodigo_postal(codigo_poastal.getText());
			pro.setFax(fax.getText());
			pro.setNombre_vendedor(vendedor.getText());
			
			LinkedList<String> lista2=new LinkedList<>();
			 
			for(int i=0;i<telefonos.getItemCount();i++)
			{
			lista2.add(telefonos.getItemAt(i).toString());
			}
			
			boolean	x=new Conexion_proveedor().Nuevo(pro ,lista2);
			
			if(x)
			{
				new Mensaje().listo("El Proveedor Con el Codogo "+pro.getId()+" Fue Registrado..","Registro Exitoso");
				id_proveedor.setText("");
				nombre.setText("");
				direccion.setText("");
				correo.setText("");
				lista.setSelectedIndex(0);
				telefonos.removeAllItems();
				codigo_poastal.setText("");
				fax.setText("");
				vendedor.setText("");
				codigos.removeAllItems();
				new Enfocar(id_proveedor);
				new Conexion_proveedor().llenar_combo(codigos);
				
			}
			
			
			}
		}
		else
	
		if(a.getSource().equals(borrar))
	    {
		id_proveedor.setText("");
		nombre.setText("");
		direccion.setText("");
		correo.setText("");
		codigo_poastal.setText("");
		telefonos.removeAllItems();
		vendedor.setText("");
		fax.setText("");
		lista.setSelectedIndex(0);
		
		new Enfocar(id_proveedor);
		
		
	}
		
	}


	public void keyPressed(KeyEvent arg0) {
	
		if(arg0.getSource().equals(fax))
		{
			if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
				
				new Enfocar(vendedor);
			}
		}
		else
		if(arg0.getSource().equals(id_proveedor)){
			
			if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
				
				new Enfocar(nombre);
			}
		}
		else
	if(arg0.getSource().equals(nombre)){
		
		if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
			
		new Enfocar(direccion);
		}
	}
		
	}


	public void keyReleased(KeyEvent arg0) {
	
		
	}


	public void keyTyped(KeyEvent k) {
	
		if(k.getSource().equals(nombre))
		{
			if(nombre.getText().length()==20){k.consume();}
		}
		
		if(k.getSource().equals(fax))
		{
			if(fax.getText().length()==30){k.consume();}
		}
		
		if(k.getSource().equals(id_proveedor))
		{
			if(id_proveedor.getText().length()==20){k.consume();}
		}
		
		if(k.getSource().equals(correo))
		{
			if(correo.getText().length()==30){k.consume();}
		}

		if(k.getSource().equals(codigo_poastal))
		{
			char ar = k.getKeyChar();
			if(ar<'0' || ar>'9')          
				 {k.consume();}
			
			if(codigo_poastal.getText().length()==5){k.consume();}
		}
		
		
		if(k.getSource().equals(vendedor))
		{
			if(vendedor.getText().length()==20){k.consume();}
		}


		
		if(k.getSource().equals(nombre) || k.getSource().equals(vendedor)){
		
			char ar = k.getKeyChar();
		
		if((ar<'a' || ar>'z')&& (ar<'A' || ar>'Z')&& ar!=KeyEvent.VK_SPACE && ar !='á'           
			    && ar !='é'
			    && ar !='.'
			    && ar !='-'
			    && ar !='í'            
			    && ar !='ó'           
			    && ar !='ú'   
			    && ar !='Á'           
			    && ar !='É'            
			    && ar !='Í'            
			    && ar !='Ó'           
			    && ar !='Ú') {k.consume();}}
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void mousePressed(MouseEvent arg0) {
		
		new Mensaje().inpout("Introduzca El Numero Telefonico","Telefono","telefono");
		
		if(Mensaje.resp_inpout)
		{
			telefonos.addItem(Mensaje.dato);
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
