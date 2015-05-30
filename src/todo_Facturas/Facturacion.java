package todo_Facturas;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import funciones.Enfocar;
import funciones.Fondo;
import funciones.Mensaje;
import funciones.Pintar_label;

import todo_clientes.Cliente;
import todo_clientes.Conexion_clientes;
import todo_clientes.Nuevo_cliente;
import todo_producto.Producto;



@SuppressWarnings("serial")
public class Facturacion extends  JDialog implements ActionListener, KeyListener {
String iva="";
String Total_pagado="0";
public static JLabel label_buqueda;
JCheckBox credito,contado,Sesta_Ticket,cheque,presupuesto;
JMenuBar barrademenu;
Fondo fondo_tipo_dato; 
Fondo p_busqueda;
Fondo fondo_cliente_select;
Fondo cuentas;
String[] Vector_Tipo_pago={"0","0","0","0"};
public static LinkedList<Producto> lista_taba1=new LinkedList<>();
public static LinkedList<Producto> lista_taba2=new LinkedList<>();
static String TOTAL_fact="";
String nombre_cliente="Sin Seleccion",Apellido_cliente="Sin Seleccion",rif_cliente="Sin Seleccion";
String hoy;
String total_tipo="0.00";
JLabel total_tipol;
SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
SimpleDateFormat dma = new SimpleDateFormat("dd:mm:yyyy");
JPanel panel=new JPanel();
Timer timpo;
JButton buscar,buscar_c,agregar_a_f,eliminar,facturar;
JTextField txtbuscar,clientetxt,cant;
JLabel hora,clientel,cedulal,nombrel,apellidol,titulo,subtotall,totall,ival,tipo_pago,rif,usuariol,cantl;
public static JTable tabla1,tabla2;
 static String[] columnas1={"CODIGO","NOMBRE","MARCA","MODELO","DESCRIPCION","CANT_EX","COSTO COMPRA","COSTO","UBICACION"};
 static String [][] filas1={{""}};
public static DefaultTableModel dtm1=new DefaultTableModel(filas1,columnas1);

static String[] columnas2={"CANTIDAD","CODIGO","NOMBRE","MARCA","MODELO","DESCRIPCION","UBICACION","TOTAL UD","TOTAL"};
static String [][] filas2={{""}};
public static DefaultTableModel dtm2=new DefaultTableModel(filas2,columnas2);

String vector2[]={"","","","","",""};
String Horax="";
String Usuarioxx="";
public Facturacion(String usuario,String titulov,String rifv,String ivav){
	   Usuarioxx=usuario;
	
	     iva=ivav;
	     titulo=new JLabel("-------------------------------------------------------" +
			"-----------------------------FACTURA--------------" +
			"-------------------------------------------------------------------------");
	     titulo.setForeground(Color.WHITE);
	     titulo.setFont(new Font(null, 1, 15));
	    setLayout(null);
	    setSize(1016,700);
	    
	    Date fechaactual= new Date();
		SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyy");
		hoy=formato.format(fechaactual);
		
		
	    usuariol=new JLabel("Usuario Actual: "+usuario);
	    usuariol.setForeground(Color.WHITE);
	    usuariol.setFont(new Font(null, 1, 18));
	    usuariol.setBounds(15,10,500,20);
	    hora=new JLabel();

	    hora.setText(sdf.format(new Date(System.currentTimeMillis()))+"         "+hoy);
	    Horax=sdf.format(new Date(System.currentTimeMillis()));
		hora.setFont(new Font("Dialog", Font.PLAIN, 24));
		hora.setBounds(720,5,300,20);
		
		timpo = new Timer(1, this);
		timpo.setRepeats(true);
		
		timpo.start();
		
		
		add(hora);
	    
	    
	   
rif=new JLabel("RIF: "+rifv);
rif.setFont(new Font(null, 1, 14));
rif.setBounds(740,615,200,30);

cantl=new JLabel("Cantiad:");
cantl.setForeground(Color.WHITE);
cantl.setFont(new Font(null, 1, 14));
cantl.setBounds(720,300,70,30);

cant=new JTextField("1");
cant.setFont(new Font(null,1, 20));
cant.setBounds(780,300,50,30);

eliminar=new JButton("Eliminar");

presupuesto=new JCheckBox("Presupuesto");
presupuesto.setCursor(new Cursor(12));
presupuesto.setFont(new Font(null, 1, 12));
presupuesto.setBounds(200,610, 100,20);

cheque=new JCheckBox("Cheque");
cheque.setCursor(new Cursor(12));
cheque.setFont(new Font(null, 1, 12));
cheque.setBounds(100,582, 80,20);

contado=new JCheckBox("Efectivo");
contado.setFont(new Font(null, 1, 12));
contado.setCursor(new Cursor(12));
contado.setBounds(20,582, 80,20);

credito=new JCheckBox("Credito");
credito.setCursor(new Cursor(12));
credito.setFont(new Font(null, 1, 12));
credito.setBounds(20,610, 80,20);

Sesta_Ticket=new JCheckBox("Sesta Ticket");
Sesta_Ticket.setFont(new Font(null, 1, 12));
Sesta_Ticket.setCursor(new Cursor(12));
Sesta_Ticket.setBounds(100,610,100,20);

tipo_pago=new JLabel("Tipo de Pago");
tipo_pago.setFont(new Font(null, 1, 14));
tipo_pago.setBounds(120,545,100,30);

subtotall=new JLabel("Sub Total:"+"0.00");
subtotall.setFont(new Font(null, Font.BOLD, 20));
subtotall.setForeground(Color.WHITE);
subtotall.setBounds(430,500,200,30);

ival=new JLabel("IVA: "+ivav+"%");
ival.setFont(new Font(null, 1, 20));
ival.setForeground(Color.WHITE);
ival.setBounds(240,500,200,30);


    totall=new JLabel("Total: 0.00");
	totall.setFont(new Font(null, 1, 20));
	totall.setForeground(Color.WHITE);
	totall.setBounds(660,500,200,30);
	
	
	facturar=new JButton("Facturar");
	facturar.setFont(new Font(null,1, 15));
	facturar.setForeground(Color.blue);
	facturar.setBounds(420,590,150,50);
	
	
	
	    eliminar.setBounds(888,500,100,30);
	
	    cedulal=new JLabel("Cedula o Rif:             "+rif_cliente);    
	    cedulal.setFont(new Font(null, 1, 12));
	    cedulal.setForeground(Color.WHITE);
	    nombrel=new JLabel("Nombre o Cliente:   "+nombre_cliente);
        nombrel.setFont(new Font(null, 1, 12));
	    nombrel.setForeground(Color.WHITE);
        apellidol=new JLabel("Apellido:                     "+Apellido_cliente);
        apellidol.setFont(new Font(null, 1, 12));
        apellidol.setForeground(Color.WHITE);
        
        fondo_cliente_select=new Fondo(0,0);
        fondo_cliente_select.setBounds(690,35,290,90);
     
        fondo_tipo_dato=new Fondo(0,0);
        fondo_tipo_dato.setBounds(10,540,295,95);
        
        
        cuentas=new Fondo(0,0);
        cuentas.setBounds(230,500,600,30);
        
        agregar_a_f=new JButton("Agregar a la Factura");
        
        agregar_a_f.setBounds(840,300,150,30);
        
	    clientel=new JLabel("Cliente");
		buscar=new JButton("Buscar Producto");
		
		txtbuscar=new JTextField();
		
		buscar_c=new JButton("Buscar Cliente");
		clientetxt=new JTextField();
			
	
		total_tipol=new  JLabel(""+total_tipo);
		new Pintar_label(total_tipol);
		total_tipol.setBounds(200, 582, 100,20);
		total_tipol.setVisible(false);
		
		titulo.setBounds(30,330,990,20);
		
		cedulal.setBounds(700,40,500,20);
		nombrel.setBounds(700,70,500,20);
		apellidol.setBounds(700,100,500,20);
		
		buscar_c.setBounds(170,65,150,30);
		clientetxt.setBounds(15,65,150,30);
		clientetxt.setFont(new Font(null,1, 20));
		
		buscar.setBounds(320,110,150,30);
		label_buqueda=new JLabel("BUSCANDO.............");
		label_buqueda.setBounds(480,110,100,20);
		new Pintar_label(label_buqueda);
		label_buqueda.setVisible(false);

		
		txtbuscar.setBounds(15,110,300,30);
		txtbuscar.setFont(new Font(null,1, 15));
		
		
	    tabla1=new JTable(dtm1);
	    tabla2=new JTable(dtm2);
	    p_busqueda=new Fondo(0, 0);
	    p_busqueda.setLayout(null);
		
		tabla1.setPreferredScrollableViewportSize(new Dimension(500,300));
	    JScrollPane escrol1=new JScrollPane(tabla1);
	    escrol1.setBounds(0,150,990,150);
	  
		
	
		tabla2.setPreferredScrollableViewportSize(new Dimension(300,300));
	    JScrollPane escrol2=new JScrollPane(tabla2);
		escrol2.setBounds(0,350,990,150);
		
		//-----------------------------tamaño de las columnas------------------------------------------------------------------
		TableColumn columna= tabla1.getColumn("DESCRIPCION");
		columna.setPreferredWidth(200);
		
		TableColumn columna3= tabla1.getColumn("CANT_EX");
		columna3.setPreferredWidth(20);
		
		TableColumn columna4= tabla1.getColumn("COSTO");
		columna4.setPreferredWidth(20);
		
		TableColumn columna1= tabla1.getColumn("UBICACION");
		columna1.setPreferredWidth(20);
		
		TableColumn columna2= tabla2.getColumn("UBICACION");
		columna2.setPreferredWidth(20);
		
		
		//----------------------------------------------------------------------------------------------------------------------
	    p_busqueda.add(escrol1);
	    p_busqueda.add(escrol2);
	    p_busqueda.add(txtbuscar);
		p_busqueda.add(buscar);
		p_busqueda.add(buscar_c);
		p_busqueda.add(clientetxt);
		p_busqueda.add(cedulal);
		p_busqueda.add(nombrel);
		p_busqueda.add(label_buqueda);
		p_busqueda.add(apellidol);
		p_busqueda.add(titulo);
		p_busqueda.add(agregar_a_f);
		p_busqueda.add(eliminar);
		p_busqueda.add(totall);
		p_busqueda.add(total_tipol);
		p_busqueda.add(facturar);
		p_busqueda.add(cheque);
		p_busqueda.add(tipo_pago);
		p_busqueda.add(Sesta_Ticket);
		p_busqueda.add(contado);
		p_busqueda.add(credito);
		p_busqueda.add(rif);
		p_busqueda.add(presupuesto);
	    p_busqueda.add(subtotall);
 	    p_busqueda.add(ival);
	    p_busqueda.add(usuariol);
	    p_busqueda.add(cantl);
	    p_busqueda.add(cant);
	    p_busqueda.add(fondo_cliente_select);
	    p_busqueda.add(fondo_tipo_dato);
	    p_busqueda.add(cuentas);
        barrademenu=new JMenuBar();
        barrademenu.setBounds(0,0,1020,30);
        add(barrademenu);
        p_busqueda.setBounds(10,30,991,642);
        
        add(p_busqueda);
        


buscar.setCursor(new Cursor(12));
agregar_a_f.setCursor(new Cursor(12));
facturar.setCursor(new Cursor(12));
eliminar.setCursor(new Cursor(12));
buscar_c.setCursor(new Cursor(12));

buscar.setForeground(Color.blue);
agregar_a_f.setForeground(Color.blue);
eliminar.setForeground(Color.blue);
buscar_c.setForeground(Color.blue);
//--------------listeners------------------------------------------------------------
facturar.addActionListener(this);
buscar_c.addActionListener(this);
presupuesto.addActionListener(this);
clientetxt.addKeyListener(this);
buscar.addActionListener(this);
txtbuscar.addKeyListener(this);
agregar_a_f.addActionListener(this);
eliminar.addActionListener(this);
tabla1.addKeyListener(this);
cant.addKeyListener(this);
contado.addActionListener(this);
cheque.addActionListener(this);
credito.addActionListener(this);
Sesta_Ticket.addActionListener(this);
//---------------------------------------------------------------------------------------
buscar.setFont(new Font(null,1, 12));
agregar_a_f.setFont(new Font(null,1, 12));
eliminar.setFont(new Font(null,1, 12));
buscar_c.setFont(new Font(null,1, 12));
setTitle(titulov);
setResizable(false);


setLocationRelativeTo(this);

int eliminacion=dtm1.getRowCount();
for(int i=0;i<eliminacion;i++){
	dtm1.removeRow(0);}

int eliminacion1=dtm2.getRowCount();
for(int i=0;i<eliminacion1;i++){
	dtm2.removeRow(0);}

setModal(true);
setVisible(true);
	}
	
	public void actionPerformed(ActionEvent a) {
		if (a.getSource().equals(timpo)) {hora.setText(sdf.format(new Date(System.currentTimeMillis()))+"         "+hoy);Horax=sdf.format(new Date(System.currentTimeMillis()));}
		else
			if(a.getSource().equals(cant))
			 {
				 buscar_producto();
			 }
			 else
		if(a.getSource().equals(buscar))
		 {
			 buscar_producto();
		 }
		 else
			 if(a.getSource().equals(eliminar))
			 {
				
				 if(tabla2.getSelectedRowCount()==1)
				 {
					dtm2.removeRow(tabla2.getSelectedRow());
				 
					
					float Subtotal_x=0;
				
					
					 for(int x=0;x<tabla2.getRowCount();x++)
					 {
						 Subtotal_x=Subtotal_x+Float.parseFloat(tabla2.getValueAt(x, 8).toString());
					 }
					 
					 BigDecimal SUBT=new BigDecimal(Subtotal_x).setScale(2, RoundingMode.HALF_EVEN);
					 Subtotal_x=SUBT.floatValue();
					 
					 
					 BigDecimal SUB= new BigDecimal(Subtotal_x).setScale(2, RoundingMode.HALF_EVEN); 
					 
					 
					 subtotall.setText("Sub Total: "+SUB);
					 
					 BigDecimal I= new BigDecimal(iva); 
					 BigDecimal S= new BigDecimal(Subtotal_x).setScale(2,RoundingMode.HALF_EVEN);
					 
					 
					 BigDecimal x=  S.multiply(I).setScale(2,RoundingMode.HALF_EVEN);
					 
					 BigDecimal cien= new BigDecimal("100");
					  
					 
					 BigDecimal IVA_TOTAL= new BigDecimal("0"); 

					 IVA_TOTAL=x.divide(cien).setScale(2,RoundingMode.HALF_EVEN);
					 
					 BigDecimal TOTAL=  IVA_TOTAL.add(S).setScale(2,RoundingMode.HALF_EVEN);
					 TOTAL_fact= TOTAL.toString();
					 totall.setText("Total: "+TOTAL);
					 total_tipol.setText(""+TOTAL);
					 }
				 
				 else
				 {
					 new Mensaje().error("Debe seleccionar un registro", "Error");
				 }
			 }
			 else
			 if(a.getSource().equals(agregar_a_f))
			 {
				 Agregar();
			 }
			 else
			 
		if(a.getSource().equals(buscar_c))
		 {
			 buscar_cliente();
		 }
		 else
		if(a.getSource().equals(presupuesto))
		{
			if(presupuesto.isSelected()==true){
				cheque.setSelected(false);
				credito.setSelected(false);
				Sesta_Ticket.setSelected(false);
				contado.setSelected(false);
			}
		}
		
		else
			if(a.getSource().equals(facturar))
			{
			facturar_fun();	
			}
			else
				if(a.getSource().equals(contado))
				{
					if(contado.isSelected())
					{
						new Mensaje().inpout("Introduzca la Cantidad en Efectivo","Efectivo","dinero");
						BigDecimal x=new BigDecimal(Mensaje.dato).setScale(2, RoundingMode.HALF_EVEN);
						Vector_Tipo_pago[0]=""+x;
					
						if(Mensaje.dato.equals("0.00")){Vector_Tipo_pago[0]="0"; contado.setSelected(false);}
						
						sumar_vector();
					}else
					{
						Vector_Tipo_pago[0]="0";
						sumar_vector();
					}
				}
				else
					if(a.getSource().equals(cheque))
					{
						if(cheque.isSelected())
						{
							new Mensaje().inpout("Introduzca la Cantidad del Cheque","cheque","dinero");
							BigDecimal x=new BigDecimal(Mensaje.dato).setScale(2, RoundingMode.HALF_EVEN);
							Vector_Tipo_pago[1]=""+x;
						
							if(Mensaje.dato.equals("0.00")){Vector_Tipo_pago[1]="0"; cheque.setSelected(false);}
							
							sumar_vector();
						}else
						{
							Vector_Tipo_pago[1]="0";
							sumar_vector();
						}
					} 
					else
						if(a.getSource().equals(credito))
						{
							if(credito.isSelected())
							{
								new Mensaje().inpout("Introduzca la Cantidad","Credito","dinero");
								BigDecimal x=new BigDecimal(Mensaje.dato).setScale(2, RoundingMode.HALF_EVEN);
								Vector_Tipo_pago[2]=""+x;
							
								if(Mensaje.dato.equals("0.00")){Vector_Tipo_pago[2]="0"; credito.setSelected(false);}
								
								sumar_vector();
							}else
							{
								Vector_Tipo_pago[2]="0";
								sumar_vector();
							}
						}

						else
							if(a.getSource().equals(Sesta_Ticket))
							{
								if(Sesta_Ticket.isSelected())
								{
									new Mensaje().inpout("Introduzca la Cantidad","Sesta Ticket","dinero");
									BigDecimal x=new BigDecimal(Mensaje.dato).setScale(2, RoundingMode.HALF_EVEN);
									Vector_Tipo_pago[3]=""+x;
								
									if(Mensaje.dato.equals("0.00")){Vector_Tipo_pago[3]="0"; Sesta_Ticket.setSelected(false);}
									
									sumar_vector();
								}else
								{
									Vector_Tipo_pago[3]="0";
									sumar_vector();
								}
							}
}
	
	public void keyTyped(KeyEvent e) {
		
		if(e.getSource().equals(cant)){
			
			String vctx[]=tabla1.getValueAt(tabla1.getSelectedRow(),5).toString().split(" ");
			char ar=e.getKeyChar();
				if(vctx[1].equals("UD"))
				{if((ar<'1' || ar>'9')){e.consume();}}
				else
					{if((ar<'0' || ar>'9' ) && ar!='.'){e.consume();}}
				
			if(cant.getText().length()>=6){ e.consume();}
			
		}
		else
			if(e.getSource().equals(clientetxt)){
				char ar=e.getKeyChar();
			if((ar<'0' || ar>'9') && ar!='j' && ar!='J' && ar!='.' && ar!='-'){e.consume();}
					
				if(clientetxt.getText().length()>=20){ e.consume();}
			}
	}

	public void keyPressed(KeyEvent g) 
	{
		if(g.getSource().equals(tabla1))
		{
			
			if(g.getKeyCode()==Event.ENTER)
			{
				g.consume();
				new Enfocar(cant);
			}
		}
		else
			if(g.getSource().equals(cant))
			{
				if(g.getKeyCode()==Event.ENTER)
				{
					Agregar();
					new Enfocar(txtbuscar);
				}
			}
			else
		if(g.getSource().equals(clientetxt))
		{
			if(g.getKeyCode()==Event.ENTER)
			{
				buscar_cliente();
			}
		}
		else
			if(g.getSource().equals(txtbuscar))
			{
				if(g.getKeyCode()==Event.ENTER)
				{
					buscar_producto();
				}
			}
		
	}

	public void keyReleased(KeyEvent arg0) {}


	public void buscar_cliente()
	{
		if(clientetxt.getText().length()>=8){
		LinkedList<Cliente> list=new LinkedList<>();
		list=new Conexion_clientes().buscar_cedula(clientetxt.getText());
	
		if(list.size()<=0)
	{
	    new Nuevo_cliente(clientetxt.getText(),true);
	}
		else
		{
			rif_cliente=list.get(0).getRif();
		    nombre_cliente=list.get(0).getNombre();
		    Apellido_cliente=list.get(0).getApellido();
		    
		    cedulal.setText("Cedula o Rif:             "+rif_cliente);
		    nombrel.setText("Nombre o Cliente:   "+nombre_cliente);
	        apellidol.setText("Apellido:                     "+Apellido_cliente);
	        new Enfocar(txtbuscar);
		}
		}else
		{
			new Mensaje().error("Debes Introducir el Rif del Cliente","Error");
		}
	
	}
	
	
	public void buscar_producto()
	{
		if(txtbuscar.getText().length()>=1)
		{
			label_buqueda.setVisible(true);
			new Poceso_buscar_producto_Facturacion(txtbuscar.getText());
		}
		else{new Mensaje().error("Debe Introducir Valores","Introduzca Valores");}
	}
	
	
	public boolean escan()
	{
		for(int i=0;i<tabla2.getRowCount();i++)
		{
			if(dtm2.getValueAt(i,1).equals(dtm1.getValueAt(tabla1.getSelectedRow(),0)))
			{
				new Mensaje().error("Este Producto ya esta en la Factura","Error");
				return true;
			}	
		}
		
		return false;
		
		
	}
	

	public void Agregar()
	{
		if(cant.getText().length()>=1 && escan()==false && tabla1.getSelectedRow()>=0 )
		 {
		 String vector[]=new String[9];
		 
		 
		 String xxx[]= tabla1.getValueAt(tabla1.getSelectedRow(),5).toString().split(" ");

		 vector[0]=cant.getText()+" "+xxx[1] ;
		 
		 vector[1]=tabla1.getValueAt(tabla1.getSelectedRow(),0).toString();
		 vector[2]=tabla1.getValueAt(tabla1.getSelectedRow(),1).toString();
		 vector[3]=tabla1.getValueAt(tabla1.getSelectedRow(),2).toString();
		 vector[4]=tabla1.getValueAt(tabla1.getSelectedRow(),3).toString();
		 vector[5]=tabla1.getValueAt(tabla1.getSelectedRow(),4).toString();
		 vector[6]=tabla1.getValueAt(tabla1.getSelectedRow(),8).toString();
		 
		 vector[7]=tabla1.getValueAt(tabla1.getSelectedRow(),7).toString();
		 
		 BigDecimal n1=new BigDecimal(tabla1.getValueAt(tabla1.getSelectedRow(),7).toString()).setScale(2, RoundingMode.HALF_EVEN);
		 
		 BigDecimal n2=new BigDecimal(cant.getText()).setScale(2, RoundingMode.HALF_EVEN);
		 BigDecimal n3=new BigDecimal("0");
		 n3=n1.multiply(n2).setScale(2,RoundingMode.HALF_EVEN);
		 vector[8]=""+n3;
		 
		 dtm2.addRow(vector);
		 
		BigDecimal Subtotal_x=new BigDecimal("0");
			
			
		 for(int x=0;x<tabla2.getRowCount();x++)
		 {
			 Subtotal_x=Subtotal_x.add(new BigDecimal(tabla2.getValueAt(x, 8).toString()));
		 }
		 
		 BigDecimal SUBT=Subtotal_x.setScale(2, RoundingMode.HALF_EVEN);
		 Subtotal_x=SUBT;
		 
		 
		 BigDecimal SUB= Subtotal_x.setScale(2, RoundingMode.HALF_EVEN); 
		 
		 
		 subtotall.setText("Sub Total: "+SUB);
		 
		 BigDecimal I= new BigDecimal(iva); 
		 BigDecimal S= Subtotal_x.setScale(2,RoundingMode.HALF_EVEN);
		 
		 
		 BigDecimal x=  S.multiply(I).setScale(2,RoundingMode.HALF_EVEN);
		 
		 BigDecimal cien= new BigDecimal("100");
		 
		 BigDecimal IVA_TOTAL= new BigDecimal("0"); 

		 IVA_TOTAL=x.divide(cien).setScale(2,RoundingMode.HALF_EVEN);
		 
		 BigDecimal TOTAL=  IVA_TOTAL.add(S).setScale(2,RoundingMode.HALF_EVEN);
		 TOTAL_fact= TOTAL.toString();
		 totall.setText("Total: "+TOTAL);
		 cant.setText("1");
		 sumar_vector();
		 }
		else
		{
			 if(cant.getText().length()<1){new Mensaje().error("Debe de Ingresar la Cantidad", "Error");new Enfocar(cant);}
		}
	}
	
	public void facturar_fun()
	{
		if( cedulal.getText().equals("Cedula o Rif:             "+"Sin Seleccion") || tabla2.getRowCount()<0 ||(contado.isSelected()==false && credito.isSelected()==false && cheque.isSelected()==false && Sesta_Ticket.isSelected()==false && presupuesto.isSelected()==false))
		{
		if(cedulal.getText().equals("Cedula o Rif:             "+"Sin Seleccion")){new Mensaje().error("Debe Seleccionar El Cliente..","Error");new Enfocar(clientetxt);}
		else
		if(tabla2.getRowCount()<=0){new Mensaje().error("Debe de Agregar a la Factura por lo menos 1 Producto", ""); 
		if(tabla1.getRowCount()>=1)
		{tabla1.changeSelection(0, 0, false, false);
			new Enfocar(tabla1);		
		}else{new Enfocar(txtbuscar);}
		}
		else
		if(contado.isSelected()==false && credito.isSelected()==false && cheque.isSelected()==false && Sesta_Ticket.isSelected()==false && presupuesto.isSelected()==false){new Mensaje().error("Debe de Seleccionar el tipo de pago","Error al Facturar");}
		}
		else
		{
			if(presupuesto.isSelected())
			{
				new Mensaje().listo("Esta Factura se Imprimira sin Cambios en Inventario ", "");
				Factura f=new Factura();
				String user[]=cedulal.getText().split("             ");
				
				f.setCliente(user[1]);
				f.setCodigo("00000");
				f.setFecha(hoy);
				f.setHora(Horax);
				f.setIva(iva);
				f.setUsuario(Usuarioxx);
				
				String x[]=new String[1];
				x[0]="Ninguno";
				f.setTipo_pago(x);
				
				for(int i=0;i<tabla2.getRowCount();i++)
				{
					String vector[]=new String[3];
					vector[0]=tabla2.getValueAt(i, 1).toString();
					String xxxx[]=tabla2.getValueAt(i, 0).toString().split(" ");
					
					vector[1]=xxxx[0]+":"+xxxx[1];
					vector[2]=tabla2.getValueAt(i, 7).toString();
					f.setPro_fac(vector);
				}
				BigDecimal total=new BigDecimal("0");
				total=new BigDecimal(TOTAL_fact);
				String zzzzz[]=subtotall.getText().split(": ");
				BigDecimal sub_total=new BigDecimal(zzzzz[1]);
				
				new Imprimir_presupuesto(f,total,sub_total);
			}
			else
			{
				
				BigDecimal totalpa=new BigDecimal(Total_pagado);
	
				
				
				if(totalpa.compareTo(new BigDecimal("0"))<=0)
				{
					Factura fact =new Factura();
					fact.setCliente(rif_cliente);
					fact.setFecha(hoy);
					fact.setHora(Horax);
					fact.setIva(iva);
					fact.setUsuario(Usuarioxx);
					fact.setEstado("1");
					if(contado.isSelected()){
	                    String vectx[]=new String[2];
	                      vectx[0]="EFECTIVO";
	                      vectx[1]=Vector_Tipo_pago[0];
						fact.setTipo_pago(vectx);}
					
					if(cheque.isSelected()){
	                    String vectx[]=new String[2];
	                      vectx[0]="CHEQUE";
	                      vectx[1]=Vector_Tipo_pago[1];
						fact.setTipo_pago(vectx);}
					
					if(credito.isSelected()){
	                    String vectx[]=new String[2];
	                      vectx[0]="CREDITO";
	                      vectx[1]=Vector_Tipo_pago[2];
						fact.setTipo_pago(vectx);}
					
					if(Sesta_Ticket.isSelected()){
	                    String vectx[]=new String[2];
	                      vectx[0]="SESTA TICKET";
	                      vectx[1]=Vector_Tipo_pago[3];
						fact.setTipo_pago(vectx);}
					
					
					for( int x=0;x<tabla2.getRowCount();x++)
					{
	                    String xvector[]=new String[3];
	                    xvector[0]=tabla2.getValueAt(x, 1).toString();
	                    
	                    xvector[1]=tabla2.getValueAt(x, 0).toString();
						
	                    xvector[2]=tabla2.getValueAt(x, 7).toString();
						fact.setPro_fac(xvector);
					}
				
					
					BigDecimal vuelto=new BigDecimal("0");
					vuelto=totalpa.negate();
					new Mensaje().listo("Su Vuelto es: BsF "+vuelto+"".toLowerCase(),"Vuelto");
					
				boolean zz=	new Guardar_Factura().Guardar_Factura_(fact);
				
				new Imprimir_factura(Guardar_Factura.cod);
			if(zz==false)
			{
				new Mensaje().listo("Factura Registrada","Registrada");
				
				clientetxt.setText("");
				txtbuscar.setText("");
				cant.setText("1");
				Vector_Tipo_pago[0]="0";
				Vector_Tipo_pago[1]="0";
				Vector_Tipo_pago[2]="0";
				Vector_Tipo_pago[3]="0";
				lista_taba1.clear();
				lista_taba2.clear();
				
				
				cedulal.setText("Cedula o Rif:             "+"Sin Seleccion");
			    nombrel.setText("Nombre o Cliente:   "+"Sin Seleccion");
		        apellidol.setText("Apellido:                     "+"Sin Seleccion");
				
				int eliminacion=dtm1.getRowCount();
				for(int i=0;i<eliminacion;i++){dtm1.removeRow(0);}
				int eliminacion2=dtm2.getRowCount();
				for(int i=0;i<eliminacion2;i++){dtm2.removeRow(0);}
				subtotall.setText("Sub Total:"+"0.00");
				totall.setText("Total: 0.00");
				contado.setSelected(false);
				Sesta_Ticket.setSelected(false);
				credito.setSelected(false);
				cheque.setSelected(false);
				
				new Enfocar(clientetxt);
				total_tipo="0";
				total_tipol.setText("0.00");
			}else{new Mensaje().error("La Factura no fue Registrada","Error");}	
			
			
				}
				else{new Mensaje().error("El total pagado esta Incompleto","Error");}
				
				
			
		
			}
			
		
		
		}
	}
	
	
	public void sumar_vector()
	{
		BigDecimal TOTALLL=new BigDecimal(TOTAL_fact).setScale(2, RoundingMode.HALF_EVEN);
		BigDecimal RS=new BigDecimal("0").setScale(2, RoundingMode.HALF_EVEN);
		BigDecimal RS2=new BigDecimal("0").setScale(2, RoundingMode.HALF_EVEN);
		BigDecimal n1=new BigDecimal(Vector_Tipo_pago[0]).setScale(2, RoundingMode.HALF_EVEN);
		BigDecimal n2=new BigDecimal(Vector_Tipo_pago[1]).setScale(2, RoundingMode.HALF_EVEN);
		BigDecimal n3=new BigDecimal(Vector_Tipo_pago[2]).setScale(2, RoundingMode.HALF_EVEN);
		BigDecimal n4=new BigDecimal(Vector_Tipo_pago[3]).setScale(2, RoundingMode.HALF_EVEN);
		
		RS=n1.add(n2).add(n3).add(n4).setScale(2, RoundingMode.HALF_EVEN);
		RS2=TOTALLL.subtract(RS).setScale(2, RoundingMode.HALF_EVEN);
		
		Total_pagado=""+RS2;
		total_tipol.setText(""+Total_pagado);
	}
	
	
}
