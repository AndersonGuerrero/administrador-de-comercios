package todo_clientes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import funciones.Enfocar;
import funciones.Fondo;
import funciones.Mensaje;
import funciones.Pintar_boton;
import funciones.Pintar_filas;
import funciones.Pintar_label;
import funciones.Pintar_txt;
import funciones.Pintar_txtarea;


@SuppressWarnings("serial")
public class Buscar_cliente  extends JDialog implements ActionListener,KeyListener,MouseListener{
	
    static int eliminacion=0;
    JButton guardar,limpiar;
    JTextField nombre,apellido,cedula;
    JLabel nombrel,apellidol,cedulal,direccionl;
    JTextArea direccion;
    Mensaje msj;
	JTextField txt_buscar;
	Fondo fondo;
	JButton buscar,Actualizar,eliminar;
	JScrollPane barra,barra_direccion;
	//-------------------------------------------------------------
	 JTable tabla;
	 String[] columnas={"Cedula o Rif","Nombre o Cliente","Apellido","Direccion"};
	 String[][]filas={{""}};
	 DefaultTableModel dtm=new DefaultTableModel(filas,columnas){
	public boolean isCellEditable(int row ,int column){return false;}
	};
	//------------------------------------------------
	
	public Buscar_cliente(){
		
		setLayout(null);
		setSize(595,500);
		fondo= new Fondo(getWidth(), getHeight());
				
		tabla=new JTable(dtm);
		
		barra=new JScrollPane(tabla);
		barra.setBounds(9,50,572,200);
		
		txt_buscar=new JTextField();
		new Pintar_txt(txt_buscar);
		txt_buscar.setBounds(150,15,200,30);
		
		buscar=new JButton("Buscar");
		new Pintar_boton(buscar);
		buscar.setBounds(360, 15, 100, 30);
		
		eliminar=new JButton("Eliminar");
		new Pintar_boton(eliminar);
		eliminar.setBounds(350,430,100,30);
		
		Actualizar=new JButton("Actualizar");
		new Pintar_boton(Actualizar);
		Actualizar.setBounds(150,430,100,30);
		
		
		int x=dtm.getRowCount();
		for(int i=0;i<x;i++)
		{
			dtm.removeRow(0);
		}
		
		
		direccionl=new JLabel("Direccion:");
		new Pintar_label(direccionl);
		direccionl.setBounds(330,275,80,30);
		  
		direccion=new JTextArea();
		new Pintar_txtarea(direccion);
		barra_direccion=new JScrollPane(direccion);
		barra_direccion.setBounds(390,275,190,80);
	    

		
		guardar=new JButton("Guardar");
		guardar.setBounds(20,190,100,30);
		

		
		
		limpiar=new JButton("Limpiar Todo");
		limpiar.setBounds(160,190,150,30);
		
		nombrel= new JLabel("Nombre o Cliente:");
		new Pintar_label(nombrel);
		nombrel.setBounds(15,280,100,20);
		
		nombre= new JTextField(30);
		new Pintar_txt(nombre);
		nombre.setBounds(140,275,180,30);
		
		
   	    apellidol= new JLabel("Apellido (Opcional):");
   	    new Pintar_label(apellidol);
		apellidol.setBounds(15,320,120,20);
		
		apellido= new JTextField(30);
		new Pintar_txt(apellido);
		apellido.setBounds(140,315,180,30);
		
		
		cedulal= new JLabel("Cedula o Rif:");
		new Pintar_label(cedulal);
		cedulal.setBounds(15,360,100,20);
		
		cedula= new JTextField(30);
		new Pintar_txt(cedula);
		cedula.setBounds(140,355,180,30);
		
		add(txt_buscar);
		add(buscar);
		add(barra_direccion);
		add(apellido);
		add(apellidol);
		add(cedula);
		add(cedulal);
		add(direccionl);
		add(nombre);
		add(nombrel);
		add(barra);
		add(Actualizar);
		add(eliminar);
		add(fondo);
		
		setResizable(false);
		
		setTitle("Buscador Y editor de clientes");
		
	    new Pintar_filas(tabla);
		
		setModal(true);
		
		setLocationRelativeTo(this);
		Actualizar.addActionListener(this);
		cedula.addKeyListener(this);
		txt_buscar.addActionListener(this);
		txt_buscar.addKeyListener(this);
		
		tabla.addMouseListener(this);
		eliminar.addActionListener(this);
		nombre.addKeyListener(this);
		apellido.addKeyListener(this);
		buscar.addActionListener(this);
		limpiar.addActionListener(this);
		guardar.addActionListener(this);
		setVisible(true);
		
	}


	public void actionPerformed(ActionEvent c) {
	
		if(c.getSource().equals(Actualizar))
		{
		
			if(nombre.getText().equals("") || cedula.getText().equals("") || direccion.getText().equals(""))
			{
				new Mensaje().error("No Pueden Ser Actualizados los Campos Vacios ", "Introduzca los Datos");
			}
			else
			{
				if(tabla.getSelectedRow()>=0){
					
				Cliente c1 =new Cliente();
				c1.setApellido(apellido.getText());
				c1.setNombre(nombre.getText());
				c1.setDireccion(direccion.getText());
				c1.setRif(cedula.getText());
				
				new Conexion_clientes().actualizar(c1,dtm.getValueAt(tabla.getSelectedRow(), 0).toString() );
				
				
				Buscar();
				
				}
				else{new Mensaje().error("Debe Seleccionar Un registro de la lista", "Seleccione los Datos");}
			}
			
		}
		else
		if(c.getSource().equals(eliminar))
		{
		
			

			if(tabla.getSelectedRow()>=0){
			
				new Mensaje().pregunta("Desea Eliminar a "+dtm.getValueAt(tabla.getSelectedRow(), 1).toString(), "Eliminacion..");
				if(Mensaje.resp){
			    new Conexion_clientes().eliminar(dtm.getValueAt(tabla.getSelectedRow(), 0).toString());
			    new Mensaje().listo(dtm.getValueAt(tabla.getSelectedRow(), 1).toString()+" Eliminado(a)", "Eliminado");
			    nombre.setText("");
			    apellido.setText("");
			    cedula.setText("");
			    direccion.setText("");
			    dtm.removeRow(tabla.getSelectedRow());
				}
			    // Buscar();
			}else{new Mensaje().error("Debe Seleccionar Un registro de la lista", "Seleccione los Datos");}
			
		}
		else
			if(c.getSource().equals(buscar))
			{
				Buscar();
			}
	}






	public void keyPressed(KeyEvent e) {
		
		if(e.getSource().equals(txt_buscar)){
			
			if(e.getKeyCode()==KeyEvent.VK_ENTER)
		{
				Buscar();	
		}	
	}
		else	
		if(e.getSource().equals(cedula))
		{
			if(e.getKeyCode()==KeyEvent.VK_ENTER)
			{
				new Enfocar(direccion);
			}
		}
		else
		if(e.getSource().equals(apellido))
		{
			if(e.getKeyCode()==KeyEvent.VK_ENTER)
			{
				new Enfocar(cedula);
			}
		}
		
		else
		if(e.getSource().equals(nombre))
		{
			if(e.getKeyCode()==KeyEvent.VK_ENTER)
			{
				new Enfocar(apellido);
				
			}
		}
		
	}






	public void keyReleased(KeyEvent e) {}



	public void keyTyped(KeyEvent e) {
	
	
		
				
		if(e.getSource().equals(nombre)){
			if(nombre.getText().length()>=30){ e.consume();}
			}
		else
			if(e.getSource().equals(apellido)){
				if(apellido.getText().length()>=30){ e.consume();}
				}
			else
			if(e.getSource().equals(nombre) || e.getSource().equals(apellido)){
				
				
				
				char ar = e.getKeyChar();
			
				if((ar<'a' || ar>'z')&& (ar<'A' || ar>'Z')&& ar!=KeyEvent.VK_SPACE && ar !='á'           
					    && ar !='é'            
					    && ar !='í'            
					    && ar !='ó'           
					    && ar !='ú'   
					    && ar !='Á'           
					    && ar !='É'            
					    && ar !='Í'            
					    && ar !='Ó'           
					    && ar !='Ú') {e.consume();}
				
			}
			
			else
			if(e.getSource().equals(cedula)){
				if(cedula.getText().length()>=30){ e.consume();}
			char car = e.getKeyChar();
			if((car<'0' || car>'9')          
				    && car !='.'
				    && car !='V'
				    && car !='v'
				    && car!='j'
				    && car!='J'
				    && car !='-'
				) {e.consume();}}
		
		
				
	}
	
	
	public void agregar( LinkedList<Cliente> listaa)
	{
		int x=dtm.getRowCount();
		for(int i=0;i<x;i++)
		{
			dtm.removeRow(0);
		}
		
		for(int i=0;i<listaa.size();i++)
		{
			String vector[]=new String[4];
			vector[0]=listaa.get(i).getRif();
			vector[1]=listaa.get(i).getNombre();
			vector[2]=listaa.get(i).getApellido();
			vector[3]=listaa.get(i).getDireccion();
		    dtm.addRow(vector);
		}
		
	}
	
	public void Buscar()
	{
		if(txt_buscar.getText().equals(""))
		{
			new Mensaje().error("Introduzca un Nombre o Rif a Buscar", "Introduzca Valores");
			
		}
		else
		{
			 LinkedList<Cliente> lista =new LinkedList<>();
			 
			 lista=new Conexion_clientes().buscar(txt_buscar.getText());
			
			 if(lista.size()<=0)
			{
				new Mensaje().error("No se han encontrado registros","No encontrado" );
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



	public void mouseClicked(MouseEvent arg0) {
	
		
	}



	public void mouseEntered(MouseEvent arg0) {
	
		
	}


	public void mouseExited(MouseEvent arg0) {
		
	}



	public void mousePressed(MouseEvent a) {
	
	 cedula.setText(dtm.getValueAt(tabla.getSelectedRow(), 0).toString());
	 nombre.setText(dtm.getValueAt(tabla.getSelectedRow(), 1).toString());
	 apellido.setText(dtm.getValueAt(tabla.getSelectedRow(), 2).toString());
	 direccion.setText(dtm.getValueAt(tabla.getSelectedRow(), 3).toString());
		new Enfocar(nombre);
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
	
		
	}
	
}
