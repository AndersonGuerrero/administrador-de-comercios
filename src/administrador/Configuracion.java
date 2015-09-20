package administrador;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import funciones.Dialogo;
import funciones.Enfocar;
import funciones.Fondo;
import funciones.Mensaje;
import funciones.Pintar_Combo;
import funciones.Pintar_boton;
import funciones.Pintar_check;
import funciones.Pintar_label;
import funciones.Pintar_titulo;
import funciones.Pintar_txt;
import funciones.Pintar_txtarea;

public class Configuracion implements ActionListener,KeyListener {

	JTabbedPane paneles;
	Fondo gestion_usuarios,gestion_sistema;
	JLabel direccionl,rifl,nombrel,nombre_userl,correol,telefonol1,telefonol2,telefonol3,ival,porcen,seleccione,pwl,privilegios;
	JTextField rif,nombre,nombre_user,correo,telefono1,telefono2,telefono3,iva;
	JPasswordField pw;
	JCheckBox facturas,inventario,proveedores,facturacion,clientes,conf;
	JButton aplicar,limpiar,aplicar_user,eliminar_user;
    JScrollPane ecrol,escrol2;
    JTextArea direccion;
	JComboBox<String> lista,usuarios;
	Dialogo d =new Dialogo("Configuracion",600,350);
	
	static Confing c;

	 LinkedList<String[]> lista_usuarios;
	public Configuracion()
	
	{
		
		
		lista_usuarios=new LinkedList<>();
		lista_usuarios=Conexion.lista_users;
		
		c=Conexion.conf;
		
		paneles=new JTabbedPane();
		paneles.setBackground(Color.gray);
		
		gestion_sistema=new Fondo(0, 0);
		gestion_sistema.setBackground(new Fondo(d.getWidth(),d.getHeight()).getBackground());
		gestion_sistema.setLayout(null);
		gestion_sistema.setBounds(0,0,500,430);
		
		//--------------------------------------------------------------------------------
		
		direccion=new JTextArea(c.getDireccion());
		escrol2=new JScrollPane(direccion);
		escrol2.setBounds(150,150,200,70);
		gestion_sistema.add(escrol2);
		
		direccionl=new JLabel("Direccion:");
		direccionl.setBounds(10,150,100,20);
		gestion_sistema.add(direccionl);
		
		telefonol1=new JLabel("Telefono:");
	    telefonol1.setBounds(350,20,100,20);
		gestion_sistema.add(telefonol1);
		
	
		telefono1=new JTextField(c.getTelefono1());
		telefono1.setBounds(420,20,90,30);
		gestion_sistema.add(telefono1);
		
		telefonol2=new JLabel("Telefono:");
	    telefonol2.setBounds(350,50,100,20);
		gestion_sistema.add(telefonol2);
		
	
		telefono2=new JTextField(c.getTelefono2());
		telefono2.setBounds(420,50,90,30);
		gestion_sistema.add(telefono2);
		
		
		telefonol3=new JLabel("Telefono:");
	    telefonol3.setBounds(350,80,100,20);
		gestion_sistema.add(telefonol3);
		
	
		telefono3=new JTextField(c.getTelefono3());
		telefono3.setBounds(420,80,90,30);
		gestion_sistema.add(telefono3);
	
		//---------------------------------------------------------------------
		
		aplicar=new JButton("Aplicar");
		aplicar.setBounds(170,240,90,30);
		gestion_sistema.add(aplicar);
		
		limpiar=new JButton("Limpiar");
		limpiar.setBounds(300,240,90,30);
		gestion_sistema.add(limpiar);
		
		rifl=new JLabel("RIF:");
		rifl.setBounds(10,20,100,20);
		gestion_sistema.add(rifl);
		
		rif=new JTextField(c.getRif());
		rif.setBounds(150,20,100,30);
		gestion_sistema.add(rif);
		
		nombre=new JTextField(c.getNombre_empresa());
		nombre.setBounds(150,50,150,30);
		gestion_sistema.add(nombre);
		
		nombrel=new JLabel("Nombre del Negocio:");
		nombrel.setBounds(10,50,150,20);
		gestion_sistema.add(nombrel);
		
		porcen=new JLabel("%");
		porcen.setBounds(190,85,50,20);
		porcen.setFont(new Font(null,24, 20));
		
		gestion_sistema.add(porcen);
		
		ival=new JLabel("IVA:");
		ival.setBounds(10,80,100,20);
		gestion_sistema.add(ival);
		
		
		iva=new JTextField(""+c.getIva());
		iva.setBounds(150,80,60,30);
		gestion_sistema.add(iva);
		
		correol=new JLabel("Correro:");
		correol.setBounds(10,110,100,20);
		gestion_sistema.add(correol);
		
		
		
		String separador[]=c.getCorrero().split("@");
		
		
		
		
		correo=new JTextField(separador[0]);
		correo.setBounds(150,110,200,30);
		gestion_sistema.add(correo);
		
		
		porcen=new JLabel("@");
		porcen.setBounds(350,115,50,20);
		porcen.setFont(new Font(null,0,18));
		gestion_sistema.add(porcen);
		
		lista =new JComboBox<String>();
		lista.addItem("Seleccione");
		lista.addItem("Gmail.com");
		lista.addItem("Hotmail.com");
		lista.addItem("Hotmail.es");
		lista.addItem("Yahoo.es");
		lista.setBounds(370,110,120,30);
		gestion_sistema.add(lista);
		
		
		
		if(lista.getItemAt(1).toString().equals(separador[1])){lista.setSelectedIndex(1);}
		else if(lista.getItemAt(2).toString().equals(separador[1])){lista.setSelectedIndex(2);}
		else if(lista.getItemAt(3).toString().equals(separador[1])){lista.setSelectedIndex(3);}
		else if(lista.getItemAt(4).toString().equals(separador[1])){lista.setSelectedIndex(4);}
		lista.setCursor(new Cursor(12));
		limpiar.setCursor(new Cursor(12));
		aplicar.setCursor(new Cursor(12));
		paneles.addTab("Gestion del Sistema",null, gestion_sistema,"Gestion De Opciones del sistema");
		
		gestion_usuarios=new Fondo(0, 0);
		gestion_usuarios.setBackground(new Fondo(d.getWidth(),d.getHeight()).getBackground());
		gestion_usuarios.setLayout(null);
		gestion_usuarios.setBounds(0,0,500,430);
		
		
		seleccione=new JLabel("Seleccione un usuario:");
		seleccione.setBounds(10,10,150,20);
		gestion_usuarios.add(seleccione);
		
		
		
		usuarios=new JComboBox<String>();
		ecrol=new JScrollPane(usuarios);
		ecrol.setBounds(150, 10,180, 40);
		
		gestion_usuarios.add(ecrol);
		
		
		
		usuarios.addItem("Nuevo Usuario");
		
	cargar_combo();
		
		nombre_userl=new JLabel("Nombre de Usuario:");
		nombre_userl.setBounds(10,60,150,20);
		gestion_usuarios.add(nombre_userl);
		
		nombre_user=new JTextField();
		nombre_user.setBounds(150,60,180,30);
		gestion_usuarios.add(nombre_user);
		
		pwl=new JLabel("Contraseña:");
		pwl.setBounds(10,90,150,20);
		gestion_usuarios.add(pwl);
		
		pw=new JPasswordField();
		pw.setBounds(160,90,80,20);
		gestion_usuarios.add(pw);
		
		
		privilegios=new JLabel("Privilegios");
		privilegios.setBounds(400,20,100,20);
		gestion_usuarios.add(privilegios);
		
		
		inventario=new JCheckBox("Gestion de Inventario.");
		inventario.setBounds(350,50,150,20);
		gestion_usuarios.add(inventario);
		
		facturas=new JCheckBox("Gestion de Facturas y Devoluciones.");
		facturas.setBounds(350,80,250,20);
		gestion_usuarios.add(facturas);
		
		facturacion=new JCheckBox("Facturacion de Productos.");
		facturacion.setBounds(350,110,250,20);
		gestion_usuarios.add(facturacion);
		
		clientes=new JCheckBox("Gestion de Clientes.");
		clientes.setBounds(350,140,250,20);
		gestion_usuarios.add(clientes);
		
		conf=new JCheckBox("Gestion de Configuracion.");
		conf.setBounds(350,170,250,20);
		gestion_usuarios.add(conf);
		
		proveedores=new JCheckBox("Gestion de Proveedores.");
		proveedores.setBounds(350,200,250,20);
		gestion_usuarios.add(proveedores);
		
		aplicar_user=new JButton("Agregar");
		aplicar_user.setBounds(50,170,100,30);
		aplicar_user.setCursor(new Cursor(12));
		
         gestion_usuarios.add(aplicar_user);
         
         eliminar_user=new JButton("Eliminar");
 		eliminar_user.setBounds(150,170,100,30);
 		gestion_usuarios.add(eliminar_user);
		new Pintar_boton(aplicar);
		new Pintar_boton(aplicar_user);
 		new Pintar_Combo(lista);
 		new Pintar_Combo(usuarios);
		new Pintar_boton(eliminar_user);
		new Pintar_boton(limpiar);
		
		new Pintar_txt(nombre);
		new Pintar_txt(correo);
		new Pintar_txt(iva);
		new Pintar_txt(nombre_user);
		new Pintar_txt(rif);
		new Pintar_txt(telefono3);
		new Pintar_txt(telefono2);
		new Pintar_txt(telefono1);
		new Pintar_txtarea(direccion);
		new Pintar_check(inventario);
		new Pintar_titulo(privilegios);
		new Pintar_check(proveedores);
		new Pintar_check(clientes);
		new Pintar_check(conf);
		new Pintar_check(facturacion);
		new Pintar_check(facturas);
		
		new Pintar_label(correol);
		new Pintar_label(direccionl);
		new Pintar_label(ival);
		new Pintar_label(nombre_userl);
		new Pintar_label(nombrel);
		new Pintar_label(porcen);
		new Pintar_label(pwl);
		new Pintar_label(rifl);
		new Pintar_label(seleccione);
		new Pintar_label(telefonol1);
		new Pintar_label(telefonol2);
		new Pintar_label(telefonol3);
	
		paneles.addTab("Gestion de Usuarios",null, gestion_usuarios,"Gestion De Opciones de Usuarios");
		
		
		eliminar_user.setVisible(false);
		paneles.setBounds(5,5,585,318);
		d.getContentPane().add(paneles);
		limpiar.addActionListener(this);
		aplicar.addActionListener(this);
		aplicar_user.addActionListener(this);
		rif.addKeyListener(this);
		correo.addKeyListener(this);
		nombre_user.addKeyListener(this);
		eliminar_user.addActionListener(this);
		pw.addKeyListener(this);
		
		inventario.addKeyListener(this);
		facturas.addKeyListener(this);
		facturacion.addKeyListener(this);
		conf.addKeyListener(this);
		clientes.addKeyListener(this);
		proveedores.addKeyListener(this);
		telefono1.addKeyListener(this);
		telefono2.addKeyListener(this);
		telefono3.addKeyListener(this);
		nombre.addKeyListener(this);
		nombre_user.addKeyListener(this);
		iva.addKeyListener(this);
		pw.addKeyListener(this);
		usuarios.addActionListener(this);
		new Enfocar(rif);
		d.setVisible(true);
	}
	
	public void keyPressed(KeyEvent arg0) {

if(arg0.getSource().equals(rif)){
		
if(arg0.getKeyCode()==KeyEvent.VK_ENTER){new Enfocar(nombre);}
}

else
	
        if(arg0.getSource().equals(nombre)){
		
		if(arg0.getKeyCode()==KeyEvent.VK_ENTER){new Enfocar(iva);}
	    }

else
if(arg0.getSource().equals(iva)){
	
	if(arg0.getKeyCode()==KeyEvent.VK_ENTER){new Enfocar(correo);}
}
else
if(arg0.getSource().equals(telefono1)){
	
	if(arg0.getKeyCode()==KeyEvent.VK_ENTER){new Enfocar(telefono2);}
}
		
else
	
if(arg0.getSource().equals(telefono2)){
	
	if(arg0.getKeyCode()==KeyEvent.VK_ENTER){new Enfocar(telefono3);}
}
		
else

	if(arg0.getSource().equals(nombre_user)){
		
		if(arg0.getKeyCode()==KeyEvent.VK_ENTER){new Enfocar(pw);}
	}
	else
if(arg0.getSource().equals(pw)){
	
	if(arg0.getKeyCode()==KeyEvent.VK_ENTER){new Enfocar(inventario);}
}
else
if(arg0.getSource().equals(inventario)){
	
	if(arg0.getKeyCode()==KeyEvent.VK_ENTER){new Enfocar(facturas);}
}
else
if(arg0.getSource().equals(facturas)){
	
	if(arg0.getKeyCode()==KeyEvent.VK_ENTER){new Enfocar(facturacion);}
}
else
if(arg0.getSource().equals(facturacion)){
	
	if(arg0.getKeyCode()==KeyEvent.VK_ENTER){new Enfocar(clientes);}
}
else
if(arg0.getSource().equals(clientes)){
	
	if(arg0.getKeyCode()==KeyEvent.VK_ENTER){new Enfocar(conf);}
}
else
if(arg0.getSource().equals(conf)){
	
	if(arg0.getKeyCode()==KeyEvent.VK_ENTER){new Enfocar(proveedores);}
}

		
	}

	public void keyReleased(KeyEvent arg0) {
		
		
	}

	
	@SuppressWarnings("deprecation")
	public void keyTyped(KeyEvent arg0) {
	
		
if(arg0.getSource().equals(pw)){
		
		String i=pw.getText().toString();

			if(i.length()>=10){arg0.consume();}
			
			char ar1 = arg0.getKeyChar();
			
			if((ar1<'0' || ar1>'9')  && (ar1<'a' || ar1>'z')&& (ar1<'A' || ar1>'Z')
				) {arg0.consume();}
		}
		
		
		
		if(arg0.getSource().equals(telefono1)){
			
			if(telefono1.getText().length()>=12){arg0.consume();}
			char ar1 = arg0.getKeyChar();
			
			if((ar1<'0' || ar1>'9')          
				    && ar1 !='-'
				) {arg0.consume();}
		}
		
		if(arg0.getSource().equals(telefono2)){if(telefono2.getText().length()>=12){ arg0.consume();}
		char ar1 = arg0.getKeyChar();
		
		if((ar1<'0' || ar1>'9')          
			    && ar1 !='-'
			) {arg0.consume();}
		}
		
		if(arg0.getSource().equals(telefono3)){if(telefono3.getText().length()>=12){ arg0.consume();}
		char ar1 = arg0.getKeyChar();
		
		if((ar1<'0' || ar1>'9')          
			    && ar1 !='-'
			) {arg0.consume();}
		}
		
		
		if(arg0.getSource().equals(correo)){
			if(correo.getText().length()>=40){ arg0.consume();}
			
			}
		
		if(arg0.getSource().equals(nombre)){
			if(nombre.getText().length()>=30){ arg0.consume();}
			
			}
		
		if(arg0.getSource().equals(nombre_user)){
			if(nombre_user.getText().length()>=30){ arg0.consume();}
			
			char car = arg0.getKeyChar();
			
			if((car<'a' || car>'z') && (car<'A' || car>'Z')  && car!=KeyEvent.VK_SPACE ) {arg0.consume();}
			
			
			}
		
		if(arg0.getSource().equals(rif)){
			if(rif.getText().length()>=20){ arg0.consume();}
		char car = arg0.getKeyChar();
		
		if((car<'0' || car>'9')          
			    && car !='.'
			    && car!='j'
			    && car!='J'
			    && car !='-'
			) {arg0.consume();}}
		
		if(arg0.getSource().equals(iva)){
			if(iva.getText().length()>=5){ arg0.consume();}
		char car = arg0.getKeyChar();
		
		if((car<'0' || car>'9')          
			) {arg0.consume();}}
		
	}

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent g) {
	
		
		if(g.getSource().equals(usuarios))
		{
			if(usuarios.getSelectedItem().toString().equals("Nuevo Usuario"))
			{
				nombre_user.setText("");
				pw.setText("");
				inventario.setSelected(false);
				facturas.setSelected(false);
				facturacion.setSelected(false);
				clientes.setSelected(false);
				conf.setSelected(false);
				proveedores.setSelected(false);
				aplicar_user.setText("Agregar");
				eliminar_user.setVisible(false);
			pw.setEditable(true);
				new Enfocar(nombre_user);
			}
			else{
				
			for(int i=0;i<lista_usuarios.size();i++)
			{
				
				if(lista_usuarios.get(i)[1].equals(usuarios.getSelectedItem().toString()))
				{
					nombre_user.setText(lista_usuarios.get(i)[1]);
					pw.setText(lista_usuarios.get(i)[2]);
				
					if(Conexion.user.getXusuario().equals(lista_usuarios.get(i)[1]))
					{
						pw.setEditable(true);
					}else{pw.setEditable(false);}
					
					
					eliminar_user.setVisible(true);
					if(lista_usuarios.get(i)[3].equals("1")){inventario.setSelected(true);}else{inventario.setSelected(false);}
					if(lista_usuarios.get(i)[4].equals("1")){facturas.setSelected(true);}else{facturas.setSelected(false);}
					if(lista_usuarios.get(i)[5].equals("1")){facturacion.setSelected(true);}else{facturacion.setSelected(false);}
					if(lista_usuarios.get(i)[6].equals("1")){clientes.setSelected(true);}else{clientes.setSelected(false);}
					if(lista_usuarios.get(i)[7].equals("1")){conf.setSelected(true);}else{conf.setSelected(false);}
					if(lista_usuarios.get(i)[8].equals("1")){proveedores.setSelected(true);}else{proveedores.setSelected(false);}
					
					
					aplicar_user.setText("Guardar");
					new Enfocar(nombre_user);
					break;
				}
			}
		}
		}
		
		else
		if(g.getSource().equals(aplicar))
		{

			if(nombre.getText().equals("") ||
			   correo.getText().equals("") ||
			   rif.getText().equals("") || 
			   telefono1.getText().equals("")){
				new Mensaje().error("No Deje campos vacios", "Error");
			    }else{
			    	
			    	BigDecimal IVA=new BigDecimal(iva.getText()).setScale(2, RoundingMode.HALF_EVEN);
			    	
			    Conexion.conf.setRif(rif.getText());
			    Conexion.conf.setCorrero(correo.getText()+"@"+lista.getSelectedItem().toString());
			    Conexion.conf.setDireccion(direccion.getText());
			    Conexion.conf.setIva(""+IVA);
			    iva.setText(Conexion.conf.getIva());
			    Conexion.conf.setNombre_empresa(nombre.getText());
			    Conexion.conf.setTelefono1(telefono1.getText());
			    Conexion.conf.setTelefono2(telefono2.getText());
			    Conexion.conf.setTelefono3(telefono3.getText());
			    new Conexion().actualizar_datos(nombre.getText(), correo.getText()+"@"+lista.getSelectedItem().toString(), rif.getText(), direccion.getText(), telefono1.getText(), telefono2.getText(), telefono3.getText(),IVA+"");
			    	 }
		}
		else
		if(g.getSource().equals(limpiar))
		{
			rif.setText("");
			nombre.setText("");
			iva.setText("");
			correo.setText("");
			telefono1.setText("");
			telefono2.setText("");
			telefono3.setText("");
			direccion.setText("");
			lista.setSelectedIndex(0);
			new Enfocar(rif);
		}
		else
			if(g.getSource().equals(eliminar_user))
			{
				if(lista_usuarios.size()>=1){
					new Mensaje().pregunta("Desea eliminar al Usuario "+usuarios.getSelectedItem().toString(),"Desea Eliminar.?");
				if(Mensaje.resp)
				{
					
					new Conexion().eliminar_user(usuarios.getSelectedItem().toString());
					for(int i=0;i<lista_usuarios.size();i++)
					{
						if(lista_usuarios.get(i)[1].equals(usuarios.getSelectedItem().toString()))
						{
							lista_usuarios.remove(i);
							break;
						}
					}
					new Mensaje().listo("El usuario "+usuarios.getSelectedItem().toString()+" ha sido eliminado..", "Eliminado");
					usuarios.removeItemAt(usuarios.getSelectedIndex());
					usuarios.setSelectedIndex(0);
				}
			}else
			{
				new Mensaje().error("No se puede eliminar este Usuario", "Error");
			}
		
			}
			else
			if(g.getSource().equals(aplicar_user))
			{
				
				if(usuarios.getSelectedItem().toString().equals("Nuevo Usuario"))
				{
					
					if(nombre.getText().equals("") || pw.getText().equals(""))
					{
						new Mensaje().listo("No deje Campos Vacios..", "Introduzca lo solicitado");
					}else{
					
						String vector[]=new String[9];
						vector[1]=nombre_user.getText().toUpperCase();
						vector[2]=pw.getText();
						vector[3]=boleano(inventario);
						vector[4]=boleano(facturas);
						vector[5]=boleano(facturacion);
						vector[6]=boleano(clientes);
						vector[7]=boleano(conf);
						vector[8]=boleano(proveedores);
						lista_usuarios.add(vector);
						usuarios.addItem(nombre_user.getText());
						new Conexion().Nuevo_usuario(vector);
						usuarios.setSelectedIndex(0);
						new Mensaje().listo("Usuario Guardado", "Guardado");
					}
					
				}
				
				else
				{
					
					for(int i=0;i<lista_usuarios.size();i++)
					{
						if(lista_usuarios.get(i)[1].toString().equals(usuarios.getSelectedItem().toString()))
						{
							
							String vector[]=new String[9];
							String anterior=usuarios.getSelectedItem().toString();
							
							vector[1]=nombre_user.getText().toUpperCase();
							vector[2]= pw.getText();
							vector[3]=boleano(inventario);
							vector[4]=boleano(facturas);
							vector[5]=boleano(facturacion);
							vector[6]=boleano(clientes);
							vector[7]=boleano(conf);
							vector[8]=boleano(proveedores);
							lista_usuarios.set(i, vector);
							
							new Conexion().actualizar_users(vector,anterior.toString());
							
							new Mensaje().listo("El Usuario "+anterior+" ha Sido Actualizado.." ,"Actualizado..");
							usuarios.removeItemAt(usuarios.getSelectedIndex());
							usuarios.addItem(lista_usuarios.get(i)[1]);
							usuarios.setSelectedItem(lista_usuarios.get(i)[1]);
							break;
							
						}
					
						
					}
					
				}
				
			}
	}
	
	public void cargar_combo()
	{
		    int t=lista_usuarios.size();
		    for(int i=0;i<t;i++){
			usuarios.addItem(lista_usuarios.get(i)[1]);
			     }
	}
	
	public String boleano(JCheckBox chek)
	{
		String r=null;
		if(chek.isSelected())
		{
			r="1";
			return r; 
		}else
		{
			r="0";
			return r;
		}
	}
	
}
