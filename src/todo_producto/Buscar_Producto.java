package todo_producto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import datechooser.beans.DateChooserDialog;
import funciones.Enfocar;
import funciones.Fondo;
import funciones.Mensaje;
import funciones.Pintar_Combo;
import funciones.Pintar_boton;
import funciones.Pintar_filas;
import funciones.Pintar_label;
import funciones.Pintar_txt;
import funciones.Pintar_txtarea;


@SuppressWarnings("serial")
public class Buscar_Producto extends JDialog implements ActionListener,KeyListener,MouseListener {
	
	public static JComboBox<String> lista,tipo_cant;
	public static JScrollPane barratxt;
	public static JTextArea descripcion;
	public static JTextField codigo,nombre,marca,modelo,cantidad,costo_com,costo_vent,departamento;
	public static JLabel codigol,nombrel,marcal,modelol,descripcionl,cantidadl,costo_coml,costo_ventl,ubicacionl,proveedorl;
	public static JProgressBar barra_carga;
	public static JButton btnfecha;
	public static LinkedList<Producto> listaa =new LinkedList<>();
	
	
	
	static int eliminacion=0;

	JTextField txt_buscar;
	Fondo panel;
	JButton buscar,actualizar;
	JPanel panel_datos;
	JScrollPane barra;

	//-------------------------------------------------------------
	public static JTable tabla;
	
	public static String[] columnas={"Codigo","Nombre","Descripcion","Marca","Modelo","Departamento"};
	
	 public static String[][]filas={{""}};
	
	public static DefaultTableModel dtm=new DefaultTableModel(filas,columnas){
	
	public boolean isCellEditable(int row ,int column){return false;}
		
	};
	
	public Buscar_Producto()
	{
      setLayout(null);
		descripcion=new JTextArea();
		new Pintar_txtarea(descripcion);
		barratxt=new JScrollPane(descripcion);
		descripcion.disable();
		
		barratxt.setBounds(90, 150, 390, 50);
		
		descripcionl=new JLabel("Descripcion:");
		new Pintar_label(descripcionl);
		descripcionl.setBounds(10, 145, 200, 30);
		
		proveedorl=new JLabel("Proveedor");
		new Pintar_label(proveedorl);
		proveedorl.setBounds(10, 200, 200, 30);
		
		lista=new JComboBox<String>();
		new Pintar_Combo(lista);
		lista.setBounds(10, 230, 210, 40);
		lista.addItem("------------------------------------------");
		lista.addItem("SIN PROVEEDOR");
		new Conexion_productos().llenar_combo(lista);
		lista.disable();
		
		codigol=new JLabel("Codigo:");
		codigol.setBounds(15,25,100,20);
		new Pintar_label(codigol);
		codigo= new JTextField();
		codigo.setBounds(90,20,100,30);
		new Pintar_txt(codigo);
		codigo.disable();
		
		nombrel=new JLabel("Nombre:");
		nombrel.setBounds(15,55,100,20);
		new Pintar_label(nombrel);
		nombre=new JTextField();
		new Pintar_txt(nombre);
		nombre.setBounds(90, 50, 100, 30);
		nombre.disable();
		
		marcal=new JLabel("Marca:");
		new Pintar_label(marcal);
		marcal.setBounds(15,85,100,20);
		marca=new JTextField();
		new Pintar_txt(marca);
		marca.setBounds(90, 80, 100, 30);
		marca.disable();
		
		
		modelol=new JLabel("Modelo:");
		new Pintar_label(modelol);
		modelol.setBounds(15,115,100,20);
		modelo=new JTextField();
		new Pintar_txt(modelo);
		modelo.setBounds(90, 110, 100, 30);
		modelo.disable();
		
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
		costo_com.disable();
		
		
		costo_ventl=new JLabel("Costo de Venta:");
		new Pintar_label(costo_ventl);
		costo_ventl.setBounds(260,55,150,20);
		costo_vent=new JTextField();
		new Pintar_txt(costo_vent);
		costo_vent.setBounds(380, 50, 100, 30);
		costo_vent.disable();
		
		ubicacionl=new JLabel("Departamento:");
		new Pintar_label(ubicacionl);
		ubicacionl.setBounds(260,85,150,20);
		departamento=new JTextField();
		new Pintar_txt(departamento);
		departamento.setBounds(380, 80, 100, 30);
		departamento.disable();
		cantidadl=new JLabel("Cantidad:");
		new Pintar_label(cantidadl);
		cantidadl.setBounds(260,115,100,20);
		cantidad=new JTextField();
		new Pintar_txt(cantidad);
		cantidad.setBounds(380, 110, 50, 30);
		cantidad.disable();
		
		tipo_cant=new JComboBox<String>();
		new Pintar_Combo(tipo_cant);
		tipo_cant.setBounds(430,110,60,30);
		tipo_cant.addItem("---");
		tipo_cant.addItem("UD");
		tipo_cant.addItem("KG");
		tipo_cant.addItem("LT");
		tipo_cant.addItem("MT");
		tipo_cant.addItem("DC");
		tipo_cant.disable();
      
      
		btnfecha=new JButton("Fecha");
	    new Pintar_boton(btnfecha);
	    btnfecha.setBounds(240, 235, 150, 30);
	    btnfecha.disable();
	  
	   actualizar=new JButton("Actualizar");
	   new Pintar_boton(actualizar);
	   actualizar.setBounds(380, 235, 100, 30);
		
	
      /* panel_datos=new JPanel();
       panel_datos.setBackground(Color.gray);
       panel_datos.setBounds(40,300,500, 270);
       panel_datos.setLayout(null);*/
       
       Fondo panel_datos = new Fondo(500, 275);
       panel_datos.setBounds(40,300,500, 275);
       panel_datos.setLayout(null);
       panel_datos.add(l);
       panel_datos.add(l2);
       panel_datos.add(btnfecha);
       panel_datos.add(proveedorl);
       panel_datos.add(tipo_cant);
       panel_datos.add(descripcionl);panel_datos.add(barratxt);
       panel_datos.add(lista);
       panel_datos.add(departamento);panel_datos.add(ubicacionl);
       panel_datos.add(costo_vent);panel_datos.add(costo_ventl);
       panel_datos.add(costo_com);panel_datos.add(costo_coml);
       panel_datos.add(cantidad);panel_datos.add(cantidadl);
       panel_datos.add(marca);panel_datos.add(marcal);	
       panel_datos.add(modelo);panel_datos.add(modelol);	
       panel_datos.add(nombre);panel_datos.add(nombrel);
       panel_datos.add(codigo);panel_datos.add(codigol);
       //---------------------------------------------------------------------------
       
       
       barra_carga= new JProgressBar();
       barra_carga.setBounds(-2,583,582,20);
       
		tabla=new JTable(dtm);
		barra=new JScrollPane(tabla);
		barra.setBounds(0,50,578,250);
		txt_buscar=new JTextField();
		txt_buscar.setToolTipText("Aqui se introduce el codigon Nombre o Descripcion de Producto a Buscar");
		new Pintar_txt(txt_buscar);
		txt_buscar.setBounds(150,15,200,30);
		buscar=new JButton("Buscar");
		new Pintar_boton(buscar);
		buscar.setBounds(360, 15, 100, 30);
		setSize(600,630);
		
		panel=new Fondo(600,630);
		panel.setLayout(null);
		panel.add(panel_datos);
		panel.add(txt_buscar);
		panel.add(buscar);
		panel.add(barra);
		panel.add(barra_carga);
		
		add(panel);
		
		setResizable(false);
		setTitle("Buscador Y editor de Productos");
		setModal(true);
		setLocationRelativeTo(this);
		actualizar.addActionListener(this);	
		txt_buscar.addKeyListener(this);
		buscar.addActionListener(this);
		marca.addKeyListener(this);
		modelo.addKeyListener(this);
		costo_com.addKeyListener(this);
		costo_vent.addKeyListener(this);
		cantidad.addKeyListener(this);
		departamento.addKeyListener(this);
		nombre.addKeyListener(this);
		codigo.addKeyListener(this);
		lista.addActionListener(this);
		tabla.addMouseListener(this);
		new Pintar_filas(tabla);
		int x2=dtm.getRowCount();
		for(int j=0;j<x2;j++)
		{
		dtm.removeRow(0);
		}
		
		setVisible(true);
	}

	
	public void actionPerformed(ActionEvent r) {
		if(r.getSource().equals(buscar))
		{
			buscarf();
			
		}
		else
			
		if(r.getSource().equals(actualizar))
		{
			if(tabla.getSelectedRow()>=0)
			{
			
				if(codigo.getText().equals("") || nombre.getText().equals("") || marca.getText().equals("") 
						|| modelo.getText().equals("") || descripcion.getText().equals("") 
						|| tipo_cant.getSelectedIndex()==0
						|| costo_com.getText().equals("") || costo_vent.getText().equals("") 
						|| departamento.getText().equals("") || cantidad.getText().equals("") 
						|| lista.getSelectedIndex()==0)
				{
					new Mensaje().error("Debe Rellenar Todos los campos","Llene los Campos");
				}
				else
				{
					Producto p=new Producto();
					
					p.setCantidad(cantidad.getText()+":"+tipo_cant.getSelectedItem().toString());
					String z[]=lista.getSelectedItem().toString().split(" ===> ");
					p.setCod_proveedor(z[0]);
					p.setCodigo(codigo.getText());
					p.setModelo(modelo.getText());
					p.setMarca(marca.getText());
					p.setNombre(nombre.getText());
					p.setDepartamento(departamento.getText());
					p.setDescripcion(descripcion.getText());
					
					try{
						BigDecimal Costo_de_compra=new  BigDecimal(costo_com.getText()).setScale(2, RoundingMode.HALF_EVEN);
						
						p.setCosto_compra(""+Costo_de_compra);
					
						BigDecimal Costo_de_Venta=new  BigDecimal(costo_vent.getText()).setScale(2, RoundingMode.HALF_EVEN);
					
					    p.setCosto_venta(""+Costo_de_Venta);
					    
					new Conexion_productos().actualizar(p, tabla.getValueAt(tabla.getSelectedRow(),0).toString());
					buscarf();
					}catch (Exception e) {
					new Mensaje().error("Los Costos no son Validos","Error");
					}
					
					
				}
				
			}
			else
			{new Mensaje().error("Debe Seleccionar un producto de la lista", "Seleccione");}
			
		}
		else
			if(r.getSource().equals(btnfecha))
			{
				/*if(tabla.getSelectedRow()>=0)
				{
					new Mensaje().pregunta("Desea Eliminar el Producto "+dtm.getValueAt(tabla.getSelectedRow(),1)+"?", "Eliminacion");
					if(Mensaje.resp)
					{
						new Conexion_productos().eliminar(dtm.getValueAt(tabla.getSelectedRow(),0).toString());
						new Mensaje().listo("El Producto con el codigo "+dtm.getValueAt(tabla.getSelectedRow(),0).toString()+" ha sido Eliminado", "Eliminado");
						dtm.removeRow(tabla.getSelectedRow());
						codigo.setText("");
						nombre.setText("");
						cantidad.setText("");
						marca.setText("");
						modelo.setText("");
						descripcion.setText("");
						costo_com.setText("");
						costo_vent.setText("");
						departamento.setText("");
						lista.setSelectedIndex(0);
						tipo_cant.setSelectedIndex(0);
					}
				}
				else{new Mensaje().error("Debe Seleccionar un Registro a Eliminar", "Error");}*/
			}
		
	}


	@Override
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
				new Enfocar(departamento);
			}
		}
		else
		if(p.getSource().equals(departamento))
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


	public void keyReleased(KeyEvent arg0) {
		
	}


	@Override
	public void keyTyped(KeyEvent t) {
		
		   if(t.getSource().equals(txt_buscar)){

				char x=t.getKeyChar();
					if(x==KeyEvent.VK_ENTER)
				{
						buscarf();	
				}
			}
		
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
		
		if(t.getSource().equals(departamento))
		{
			if(departamento.getText().length()==6){t.consume();}
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
	
	
	public void buscarf()
	{
		
		if(txt_buscar.getText().equals(""))
		{
			barra_carga.setValue(0);
		    new Proceso_buscar_productos(txt_buscar.getText());
            new Enfocar(txt_buscar);	
		}
		
		else
		{
			barra_carga.setValue(0);
		    new Proceso_buscar_productos(txt_buscar.getText());
            new Enfocar(txt_buscar);		
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


	@Override
	public void mousePressed(MouseEvent arg0) {
	
		if(arg0.getSource().equals(tabla)){
			
			for(int i=0;i<listaa.size();i++)
			{
			
		      if(listaa.get(i).getCodigo().equals(dtm.getValueAt(tabla.getSelectedRow(), 0).toString()))
		      {
		    	 codigo.setText(listaa.get(i).getCodigo());
		    	 nombre.setText(listaa.get(i).getNombre());
		    	 btnfecha.setText(listaa.get(i).getFecha());
		    	 descripcion.setText(listaa.get(i).getDescripcion());
		    	 marca.setText(listaa.get(i).getMarca());
		    	 modelo.setText(listaa.get(i).getModelo());
	             costo_com.setText(listaa.get(i).getCosto_compra());
	             costo_vent.setText(listaa.get(i).getCosto_venta()); 
		    	 
		    	 
	             departamento.setText(listaa.get(i).getDepartamento());
		    	 
		    	 
		    	 String[] x=listaa.get(i).getCantidad().split(":");
		    	 
		    	 cantidad.setText(x[0]);
		    	 if(x[1].equals("UD")){tipo_cant.setSelectedItem("UD");}
		    	 else
		    		 if(x[1].equals("KG")){tipo_cant.setSelectedItem("KG");}
		    		     else
		    		    	 if(x[1].equals("LT")){tipo_cant.setSelectedItem("LT");}
		    		    	 else
			    		    	 if(x[1].equals("MT")){tipo_cant.setSelectedItem("MT");}
			    		    	 else
				    		    	 if(x[1].equals("DC")){tipo_cant.setSelectedItem("DC");}
		    	
		    	 
		    	
			 		
		    	 for(int y=0;y<lista.getItemCount();y++)
		    	 {
		    		 
		    		String cc[]= lista.getItemAt(y).toString().split(" ===> ");
		    		
		    		
		    		if(listaa.get(i).getCod_proveedor().toString().equals(lista.getItemAt(y).toString()))
		    		{
		    			lista.setSelectedIndex(y);
		    			break;
		    		}
		    		else
		    		if(cc[0].equals(listaa.get(i).getCod_proveedor().toString()))
		    		{
		    			lista.setSelectedIndex(y);
		    			break;
		    		}
		    	 }
		    	 
		    	 
		    	 break;
		      }
			}
		new Enfocar(codigo);
		}	
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub	
	}	
}