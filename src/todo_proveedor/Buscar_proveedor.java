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
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import funciones.Dialogo;
import funciones.Enfocar;
import funciones.Fondo;
import funciones.Mensaje;
import funciones.Pintar_Combo;
import funciones.Pintar_boton;
import funciones.Pintar_filas;
import funciones.Pintar_label;
import funciones.Pintar_txt;
import funciones.Pintar_txtarea;

public class Buscar_proveedor implements ActionListener,KeyListener,MouseListener{
   
	LinkedList<Proveedor> lista_principal=new LinkedList<>();
	JButton eliminar,actualizar,buscar;
	JLabel id_proveedorl,nombrel,direccionl,correol,codigo_poastall,telefonol,faxl,vendedorl,aroba;
	JTextArea direccion;
	JScrollPane barra_direccion;
	JTextField id_proveedor,nombre,correo,codigo_poastal,fax,vendedor;
	JComboBox<String> lista_correo,telefonos;
	ImageIcon icono,icono2;
	JLabel mas,menos;
	Fondo fondo;
	Fondo d;
	int pocicion;
	static int eliminacion=0;

	JTextField txt_buscar;
	JScrollPane barra;

	//-------------------------------------------------------------
	JTable tabla;
	
	static String[] columnas={"Codigo","Nombre","Email","Direccion","Nombre Del Vendedor"};
	
	static String[][]filas={{""}};
	
	@SuppressWarnings("serial")
	static DefaultTableModel dtm=new DefaultTableModel(filas,columnas){

	public boolean isCellEditable(int row ,int column){return false;}
		
	};
	
	Dialogo vent=new Dialogo("", 825,520);
	public Buscar_proveedor()
	{
		vent.setLayout(null);
		
       //--------------------------------------------------------Panel Editor de Proveedores-------------------------------
       d=new Fondo(0, 0);
      
       d.setBounds(33,270,755,200);
       d.setLayout(null);
       
	
	mas=new JLabel();
	icono=new ImageIcon("Images\\mas.png");
	mas.setIcon(icono);
	mas.setBounds(680,53, 30,30);
	mas.setCursor(new Cursor(12));
	
	menos=new JLabel();
	icono2=new ImageIcon("Images\\menos.png");
	menos.setIcon(icono2);
	menos.setBounds(720,62, 50,8);
	menos.setCursor(new Cursor(12));
	
	lista_correo =new JComboBox<String>();
	lista_correo.addItem(" ");
	lista_correo.addItem("gmail.com");
	lista_correo.addItem("hotmail.com");
	lista_correo.addItem("yahoo.es");
	new Pintar_Combo(lista_correo);
	
	id_proveedorl=new JLabel("Codigo:");
	id_proveedorl.setBounds(10, 25, 100,20);
	new Pintar_label(id_proveedorl);
	id_proveedor=new JTextField();
	id_proveedor.setBounds(100, 20, 100,30);
	new Pintar_txt(id_proveedor);
	
	
	nombrel=new JLabel("Nombre:");
	nombrel.setBounds(10, 55, 100,20);
	new Pintar_label(nombrel);
	
	nombre=new JTextField();
	nombre.setBounds(100, 50, 150,30);
	new Pintar_txt(nombre);
	
	direccionl=new JLabel("Direccion:");
	direccionl.setBounds(10, 85, 100,20);
	new Pintar_label(direccionl);
	
	direccion=new JTextArea();
	new Pintar_txtarea(direccion);
	barra=new JScrollPane(direccion);
	barra.setBounds(100, 80, 300,70);
	
	correol=new JLabel("E-Mail:");
	correol.setBounds(10, 155, 100,20);
	new Pintar_label(correol);
	
	correo=new JTextField();
	correo.setBounds(100, 150, 170,30);
	new Pintar_txt(correo);
	
	aroba=new JLabel("@");
	aroba.setBounds(270, 150, 50,25);
	new Pintar_label(aroba);
	aroba.setFont(new Font(null, 1, 20));
	lista_correo.setBounds(290, 150, 110,30);
	
	
	
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
	
	actualizar=new JButton("Actualizar");
	new Pintar_boton(actualizar);
	actualizar.setBounds(570,150,100,30);
	
	eliminar=new JButton("Eliminar");
	new Pintar_boton(eliminar);
	eliminar.setBounds(410,150,100,30);
   	   
	d.add(id_proveedor);
	d.add(id_proveedorl);
	d.add(nombre);
	d.add(nombrel);
	d.add(correo);
	d.add(correol);
	d.add(lista_correo);
	d.add(aroba);
	d.add(codigo_poastal);
	d.add(codigo_poastall);
	d.add(telefonos);
	d.add(mas);
	d.add(menos);
	d.add(telefonol);
	d.add(fax);
	d.add(faxl);
	d.add(vendedor);
	d.add(vendedorl);
	d.add(barra);
	d.add(direccionl);
	d.add(eliminar);
	d.add(actualizar);
	
	
 //-----------------------------------------------------------------------------------------------------------------------------
       fondo=new Fondo(0,0);
       fondo.setBounds(10,0,800,493);
       fondo.setBackground(Color.gray);
       
		tabla=new JTable(dtm);
		
		barra=new JScrollPane(tabla);
		barra.setBounds(10,50,800,200);
		
		txt_buscar=new JTextField();
		txt_buscar.setBounds(200,15,200,30);
		new Pintar_txt(txt_buscar);
		buscar=new JButton("Buscar");
		buscar.setBounds(400, 15, 100, 30);
		new Pintar_boton(buscar);
		
		if(eliminacion==0){
			eliminacion=1;
			dtm.removeRow(0);}
		
		
		vent.add(txt_buscar);
		vent.add(buscar);
		
		vent.add(barra);
		
		vent.add(d);
		vent.add(fondo);
		vent.setResizable(false);
		
		vent.setTitle("Buscador Y editor de Proveedores");
		
		//setSize(782,500);
		menos.addMouseListener(this);
		txt_buscar.addKeyListener(this);
		mas.addMouseListener(this);
		actualizar.addActionListener(this);
		correo.addKeyListener(this);
		id_proveedor.addKeyListener(this);
		nombre.addKeyListener(this);
		vendedor.addKeyListener(this);
		buscar.addActionListener(this);
		codigo_poastal.addKeyListener(this);
		fax.addKeyListener(this);
		tabla.addMouseListener(this);
		eliminar.addActionListener(this);
		new Pintar_filas(tabla);
		vent.setModal(true);
		int x=dtm.getRowCount();
		for(int i=0;i<x;i++)
		{
			dtm.removeRow(0);
		}
		
		vent.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent g) {
	
		if(g.getSource().equals(buscar))
		{
			Buscar();
		}
		else
			
		if(g.getSource().equals(eliminar))
		{
			if(tabla.getSelectedRow()>=0)
			{
				new Mensaje().pregunta("Desea Eliminar el Proveedor "+dtm.getValueAt(tabla.getSelectedRow(),1)+"?", "Eliminacion");
				if(Mensaje.resp)
				{
					new Conexion_proveedor().eliminar(dtm.getValueAt(tabla.getSelectedRow(),0).toString());
					new Mensaje().listo("El Proveedor "+dtm.getValueAt(tabla.getSelectedRow(),0).toString()+" ha sido Eliminado", "Eliminado");
					dtm.removeRow(tabla.getSelectedRow());
					id_proveedor.setText("");
					nombre.setText("");
					direccion.setText("");
					correo.setText("");
					lista_correo.setSelectedIndex(0);
					telefonos.removeAllItems();
					codigo_poastal.setText("");
					fax.setText("");
					vendedor.setText("");
				}
			}
			else{new Mensaje().error("Debe Seleccionar un Registro a Eliminar", "Error");}
			
		}
		else
			if(g.getSource().equals(actualizar))
			{
			
				if(nombre.getText().equals("") || id_proveedor.getText().equals("") || direccion.getText().equals("") || telefonos.getItemCount()<=0 || lista_correo.getSelectedIndex()==0
						|| vendedor.getText().equals("") || fax.getText().equals("") || codigo_poastal.getText().equals("") || correo.getText().equals(""))
				{
					new Mensaje().error("No Pueden Ser Actualizados los Campos Vacios ", "Introduzca los Datos");
				}
				else
				{
					if(tabla.getSelectedRow()>=0){
						
					Proveedor p1 =new Proveedor();
					
					p1.setId(id_proveedor.getText());
					p1.setNombre(nombre.getText());
					p1.setDireccion(direccion.getText());
					p1.setCorrero(correo.getText()+"@"+lista_correo.getSelectedItem().toString());
					p1.setCodigo_postal(codigo_poastal.getText());
					p1.setFax(fax.getText());
					p1.setNombre_vendedor(vendedor.getText());
					
					
					for(int i=0;i<telefonos.getItemCount();i++)
					{
					p1.setTelefono(telefonos.getItemAt(i));
					}
					
					new Conexion_proveedor().actualizar(p1,dtm.getValueAt(tabla.getSelectedRow(), 0).toString() );
					Buscar();
					}
					else{new Mensaje().error("Debe Seleccionar Un registro de la lista", "Seleccione los Datos");}
				}
				
			}
		
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
		
		if(arg0.getSource().equals(tabla)){
			
			for(int i=0;i<lista_principal.size();i++)
			{
			
		      if(lista_principal.get(i).getId().equals(dtm.getValueAt(tabla.getSelectedRow(), 0).toString()))
		      {
		    	 id_proveedor.setText(lista_principal.get(i).getId());
		    	 nombre.setText(lista_principal.get(i).getNombre());
		    	 direccion.setText(lista_principal.get(i).getDireccion());
		    	 codigo_poastal.setText(lista_principal.get(i).getCodigo_postal());
		    	 fax.setText(lista_principal.get(i).getFax());
		    	 vendedor.setText(lista_principal.get(i).getNombre_vendedor());
		    	 telefonos.removeAllItems();
		    	 
		    	 for(int j=0;j<lista_principal.get(i).getTelefono_size();j++)
		    	 {
		    	 telefonos.addItem(lista_principal.get(i).getTelefono(j));
		    	 }
		    	 String[] x=lista_principal.get(i).getCorrero().split("@");
		    	 correo.setText(x[0]);
		    	 if(x[1].equals("gmail.com")){lista_correo.setSelectedItem("gmail.com");}
		    	 else
		    		 if(x[1].equals("hotmail.com")){lista_correo.setSelectedItem("hotmail.com");}
		    		     else
		    		    	 if(x[1].equals("yahoo.es")){lista_correo.setSelectedItem("yahoo.es");}
		    	 
		    	pocicion=i;
		    	 break;
		      }
		 
			}
		new Enfocar(id_proveedor);
		}
		
		else
		if(arg0.getSource().equals(mas)){
			
	    new Mensaje().inpout("Introduzca El Numero Telefonico","Telefono","telefono");
	    
		if(Mensaje.resp_inpout){telefonos.addItem(Mensaje.dato);}
		}
		else
			if(arg0.getSource().equals(menos))
			{
				if(telefonos.getItemCount()>0){
				telefonos.removeItemAt(telefonos.getSelectedIndex());
				   }
				else{new Mensaje().error("La Lista Telefonica Esta Vacia..", "El campo esta Vacio");}
				}
			
			
	}

	public void mouseReleased(MouseEvent arg0) {
	
		
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

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent k) {
		
		
        if(k.getSource().equals(txt_buscar)){
			
			char x=k.getKeyChar();
			if(x!=KeyEvent.VK_SPACE && x!=KeyEvent.VK_BACK_SPACE && x!=KeyEvent.VK_ENTER){
				
			if(txt_buscar.getText().length()>=0)
			{
				k.consume();
				txt_buscar.setText(txt_buscar.getText()+x);
				Buscar();
			}
			  }
			else
				if(x==KeyEvent.VK_ENTER)
			{
					Buscar();	
			}
		}
		
		
		
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
	
	
	
	public void agregar( LinkedList<Proveedor> listaa)
	{
		
		int x=dtm.getRowCount();
		for(int i=0;i<x;i++)
		{
			dtm.removeRow(0);
		}
		
		for(int i=0;i<listaa.size();i++)
		{
			lista_principal=listaa;
			String vector[]=new String[5];
			vector[0]=listaa.get(i).getId();
			vector[1]=listaa.get(i).getNombre();
			vector[3]=listaa.get(i).getDireccion();
			vector[2]=listaa.get(i).getCorrero();
			vector[4]=listaa.get(i).getNombre_vendedor();
		    dtm.addRow(vector);
		}
		
		 tabla.changeSelection(0, 0, false, false);
	}
	
	
	
	
	
	public void Buscar()
	{
		if(txt_buscar.getText().equals(""))
		{
			new Mensaje().error("Debe Introducir datos para Buscar", "Error al Buscar");
			new Enfocar(txt_buscar);
		}
		else
		{
             LinkedList<Proveedor> lista =new LinkedList<>();
			 lista= new Conexion_proveedor().buscar(txt_buscar.getText());
			
			 if(lista.size()<=0)
			{
				new Mensaje().error("No se han encontrado registros","No encontrado" );
				id_proveedor.setText("");
				nombre.setText("");
				direccion.setText("");
				correo.setText("");
				telefonos.removeAllItems();
				codigo_poastal.setText("");
				fax.setText("");
				vendedor.setText("");
				lista_correo.setSelectedIndex(0);
				int x=dtm.getRowCount();
				for(int i=0;i<x;i++)
				{
					dtm.removeRow(0);
				}
			}
			else
			{
				agregar(lista);
			}
		}
		
	}
	
	
	}
	

