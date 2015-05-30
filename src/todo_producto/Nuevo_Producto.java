package todo_producto;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

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


public class Nuevo_Producto implements ActionListener,KeyListener {
	JButton borrar,guardar;
	JComboBox<String> lista,tipo_cant;
	JScrollPane barra,barratxt;
JTextArea descripcion;
	JTextField codigo,nombre,marca,modelo,cantidad,costo_com,costo_vent,ubicacion;
	JLabel codigol,nombrel,marcal,modelol,descripcionl,cantidadl,costo_coml,costo_ventl,ubicacionl,proveedorl;
	public Nuevo_Producto(){
		Dialogo d=	new Dialogo("Nuevo producto", 500, 310);
		
		borrar=new JButton("Limpiar");
	    new Pintar_boton(borrar);
		borrar.setBounds(240, 235, 100, 30);
	  
	   guardar=new JButton("Guardar");
	   new Pintar_boton(guardar);
	   guardar.setBounds(380, 235, 100, 30);
	   
		descripcion=new JTextArea();
		new Pintar_txtarea(descripcion);
		barratxt=new JScrollPane(descripcion);
		
		barratxt.setBounds(90, 150, 390, 50);
		
		descripcionl=new JLabel("Descripcion:");
		new Pintar_label(descripcionl);
		descripcionl.setBounds(10, 145, 200, 30);
		
		proveedorl=new JLabel("Seleccione Un Proveedor");
		new Pintar_label(proveedorl);
		proveedorl.setBounds(10, 200, 200, 30);
		
		lista=new JComboBox<String>();
		new Pintar_Combo(lista);
		lista.setBounds(10, 230, 210, 40);
		
		
		lista.addItem("Seleccione");
		lista.addItem("Sin Proveedor");
	    new Conexion_productos().llenar_combo(lista);
		
		
		
		codigol=new JLabel("Codigo:");
		codigol.setBounds(15,25,100,20);
		new Pintar_label(codigol);
		codigo= new JTextField();
		codigo.setBounds(90,20,100,30);
		new Pintar_txt(codigo);
		
		nombrel=new JLabel("Nombre:");
		nombrel.setBounds(15,55,100,20);
		new Pintar_label(nombrel);
		nombre=new JTextField();
		new Pintar_txt(nombre);
		nombre.setBounds(90, 50, 100, 30);
		
		marcal=new JLabel("Marca:");
		new Pintar_label(marcal);
		marcal.setBounds(15,85,100,20);
		marca=new JTextField();
		new Pintar_txt(marca);
		marca.setBounds(90, 80, 100, 30);
		
		
		modelol=new JLabel("Modelo:");
		new Pintar_label(modelol);
		modelol.setBounds(15,115,100,20);
		modelo=new JTextField();
		new Pintar_txt(modelo);
		modelo.setBounds(90, 110, 100, 30);
		
		
		JLabel l=new JLabel("Bsf.");
		l.setForeground(Color. gray);
		l.setBounds(450, 20, 100, 30);
		
		JLabel l2=new JLabel("Bsf.");
		l2.setForeground(Color. gray);
		l2.setBounds(450, 50, 100, 30);
		
		
		costo_coml=new JLabel("Costo de Compra:");
		new Pintar_label(costo_coml);
		costo_coml.setBounds(260,25,150,20);
	
		costo_com=new JTextField();
		new Pintar_txt(costo_com);
		costo_com.setBounds(380, 20, 100, 30);
		
		
		
		costo_ventl=new JLabel("Costo de Venta:");
		new Pintar_label(costo_ventl);
		costo_ventl.setBounds(260,55,150,20);
		costo_vent=new JTextField();
		new Pintar_txt(costo_vent);
		costo_vent.setBounds(380, 50, 100, 30);
		
		ubicacionl=new JLabel("Ubicacion:");
		new Pintar_label(ubicacionl);
		ubicacionl.setBounds(260,85,150,20);
		ubicacion=new JTextField();
		new Pintar_txt(ubicacion);
		ubicacion.setBounds(380, 80, 50, 30);
		
		cantidadl=new JLabel("Cantidad:");
		new Pintar_label(cantidadl);
		cantidadl.setBounds(260,115,100,20);
		cantidad=new JTextField();
		new Pintar_txt(cantidad);
		cantidad.setBounds(380, 110, 50, 30);
		
		tipo_cant=new JComboBox<String>();
		new Pintar_Combo(tipo_cant);
		tipo_cant.setBounds(430,110,50,30);
		tipo_cant.addItem("--");
		tipo_cant.addItem("UD");
		tipo_cant.addItem("Kg");
		tipo_cant.addItem("Lt");
		tipo_cant.addItem("Mt");
		tipo_cant.addItem("Dc");
		
		d.add(l);
		d.add(l2);
		d.add(borrar);
		d.add(guardar);
		d.add(proveedorl);
		d.add(tipo_cant);
		d.add(descripcionl);d.add(barratxt);
		d.add(lista);
		d.add(ubicacion);d.add(ubicacionl);
		d.add(costo_vent);d.add(costo_ventl);
		d.add(costo_com);d.add(costo_coml);
		d.add(cantidad);d.add(cantidadl);
		d.add(marca);d.add(marcal);	
		d.add(modelo);d.add(modelol);	
	    d.add(nombre);d.add(nombrel);
		d.add(codigo);d.add(codigol);
        d.add(new Fondo(d.getWidth(),d.getHeight()));
		marca.addKeyListener(this);
		modelo.addKeyListener(this);
		costo_com.addKeyListener(this);
		costo_vent.addKeyListener(this);
		cantidad.addKeyListener(this);
		ubicacion.addKeyListener(this);
		nombre.addKeyListener(this);
		codigo.addKeyListener(this);
		lista.addActionListener(this);
		guardar.addActionListener(this);
		borrar.addActionListener(this);
		d.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(borrar))
		{
			codigo.setText("");
			nombre.setText("");
			cantidad.setText("");
			marca.setText("");
			modelo.setText("");
			descripcion.setText("");
			costo_com.setText("");
			costo_vent.setText("");
			ubicacion.setText("");
			lista.setSelectedIndex(0);
			tipo_cant.setSelectedIndex(0);
			new Enfocar(codigo);
		}
		else
			if(e.getSource().equals(guardar))	
		   {
			if(codigo.getText().equals("") || nombre.getText().equals("") || marca.getText().equals("") || modelo.getText().equals("") || descripcion.getText().equals("") || tipo_cant.getSelectedIndex()==0
					|| costo_com.getText().equals("") || costo_vent.getText().equals("") || ubicacion.getText().equals("") || cantidad.getText().equals("") || lista.getSelectedIndex()==0)
			{
				if(codigo.getText().equals("")){new Mensaje().error("Introduzca el Codigo del producto","Introduzca lo Requerido");new Enfocar(codigo);}
				else if(nombre.getText().equals("")){new Mensaje().error("Introduzca el Nombre del producto","Introduzca lo Requerido");new Enfocar(nombre);}
				else if(marca.getText().equals("")){new Mensaje().error("Introduzca la Marca del producto","Introduzca lo Requerido");new Enfocar(marca);}
				else if(modelo.getText().equals("")){new Mensaje().error("Introduzca el Modelo del producto","Introduzca lo Requerido");new Enfocar(modelo);}
				else if(descripcion.getText().equals("")){new Mensaje().error("Introduzca una descripcion para el producto","Introduzca lo Requerido");new Enfocar(descripcion);}
				else if(tipo_cant.getSelectedIndex()==0){new Mensaje().error("seleccione el tipo de cantidad del producto","Introduzca lo Requerido");new Enfocar(tipo_cant);}
				else if(costo_com.getText().equals("")){new Mensaje().error("Introduzca el Costo de compra para el producto","Introduzca lo Requerido");new Enfocar(costo_com);}
				else if(costo_vent.getText().equals("")){new Mensaje().error("Introduzca el Costo de venta para el producto","Introduzca lo Requerido");new Enfocar(costo_vent);}
				else if(ubicacion.getText().equals("")){new Mensaje().error("Introduzca una ubicacion para el producto","Introduzca lo Requerido");new Enfocar(ubicacion);}
				else if(cantidad.getText().equals("")){new Mensaje().error("Introduzca la cantidad del producto","Introduzca lo Requerido");new Enfocar(cantidad);}
				else if(lista.getSelectedIndex()==0){new Mensaje().error("Seleccione el Proveedor del producto","Introduzca lo Requerido");new Enfocar(lista);}
			}
			else
			{
			Producto p=new Producto();
			p.setCodigo(codigo.getText());
			p.setNombre(nombre.getText());
			p.setMarca(marca.getText());
			p.setModelo(modelo.getText());
			p.setUbicacion(ubicacion.getText());
			p.setCantidad(cantidad.getText()+":"+tipo_cant.getSelectedItem().toString());
			p.setDescripcion(descripcion.getText());
		    String x[]=lista.getSelectedItem().toString().split(" ===> ");
			p.setCod_proveedor(x[0]);
			
			try{
				BigDecimal Costo_de_compra=new  BigDecimal(costo_com.getText()).setScale(2, RoundingMode.HALF_EVEN);
			
				p.setCosto_compra(""+Costo_de_compra);
			
				BigDecimal Costo_de_Venta=new  BigDecimal(costo_vent.getText()).setScale(2, RoundingMode.HALF_EVEN);
			
			    p.setCosto_venta(""+Costo_de_Venta);
		
			boolean r=new Conexion_productos().Nuevo(p);
			if(r)
			{
				new Mensaje().listo("El Producto Fue Registrado..","Registrado");
			}
			else
			{
				new Enfocar(codigo);
				
			}
				}catch(Exception x1){new Mensaje().error("Los Percios no son Validos", "Error Numerico");}
			
			
			
			}
		   }
		
	}
	public void keyPressed(KeyEvent p) {
	
		if(p.getSource().equals(nombre))
		{
			if(p.getKeyCode()==KeyEvent.VK_ENTER){
				new Enfocar(marca);
			}
		}
		else
		if(p.getSource().equals(codigo))
		{
			if(p.getKeyCode()==KeyEvent.VK_ENTER){
				new Enfocar(nombre);
			}
		}
		else
		if(p.getSource().equals(marca))
		{
			if(p.getKeyCode()==KeyEvent.VK_ENTER){
				new Enfocar(modelo);
			}
		}
		else
		if(p.getSource().equals(modelo))
		{
			if(p.getKeyCode()==KeyEvent.VK_ENTER){
				new Enfocar(costo_com);
			}
		}
		else
		if(p.getSource().equals(costo_com))
		{
			if(p.getKeyCode()==KeyEvent.VK_ENTER){
				new Enfocar(costo_vent);
			}
		}
		else
		if(p.getSource().equals(costo_vent))
		{
			if(p.getKeyCode()==KeyEvent.VK_ENTER){
				new Enfocar(ubicacion);
			}
		}
		else
		if(p.getSource().equals(ubicacion))
		{
			if(p.getKeyCode()==KeyEvent.VK_ENTER){
				new Enfocar(cantidad);
			}
		}
		else
		if(p.getSource().equals(cantidad))
		{
			if(p.getKeyCode()==KeyEvent.VK_ENTER){
				new Enfocar(descripcion);
			}
		}
		
	}

	
	public void keyReleased(KeyEvent r) {
		
		
	}

	
	public void keyTyped(KeyEvent t) {
	
		if(t.getSource().equals(codigo))
		{
		if(codigo.getText().length()==20){t.consume();}
		}
		
		if(t.getSource().equals(marca))
		{
		if(marca.getText().length()==20){t.consume();}
		}
		
		
		if(t.getSource().equals(modelo))
		{
		if(modelo.getText().length()==20){t.consume();}
		}
		
		if(t.getSource().equals(cantidad))
		{
			char Cc=t.getKeyChar();
			if(cantidad.getText().length()==10){t.consume();}
			
			if(tipo_cant.getSelectedItem().equals("UD"))
			{
				if((Cc<'0' || Cc>'9'))
				{
					t.consume();
				}
			}
			else
			{
			if((Cc<'0' || Cc>'9') && Cc!='.' )
			{
				t.consume();
			}
			}
		}
		
		if(t.getSource().equals(ubicacion))
		{
			if(ubicacion.getText().length()==6){t.consume();}
			char Cc=t.getKeyChar();
			if((Cc<'0' || Cc>'9'))
			{
				t.consume();
			}
			
		}
		
		if(t.getSource().equals(costo_com))
		{
			if(costo_com.getText().length()==13){t.consume();}
			char Cc=t.getKeyChar();
			if((Cc<'0' || Cc>'9')&& Cc!='.')
			{
				t.consume();
			}
			
		}
		
		
		if(t.getSource().equals(costo_vent))
		{
			if(costo_vent.getText().length()==13){t.consume();}
			char Cv=t.getKeyChar();
			if((Cv<'0' || Cv>'9')&& Cv!='.')
			{
				t.consume();
			}
			
		}
		
		char N=t.getKeyChar();
		if(t.getSource().equals(nombre))
		{
			if(nombre.getText().length()==30){t.consume();}
			if((N<'a' || N>'z')&& (N<'A' || N>'Z')&& N!=KeyEvent.VK_SPACE)
			{
				t.consume();
			}
			
		}
	}


}
