package todo_Facturas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import todo_clientes.Cliente;
import todo_clientes.Conexion_clientes;
import administrador.Conexion;
import administrador.Confing;
import funciones.Dialogo;
import funciones.Fondo_factura;
import funciones.Mensaje;
import funciones.Pintar_boton;
import funciones.Pintar_filas;
import funciones.Pintar_label;
import funciones.Pintar_txtarea;


public class Ver_factura implements ActionListener,MouseListener {
	
	public static JButton imprimir;
	static int eliminacion=0;

	Color colorx=new Color(0x666f7A);
    JLabel rif_vl,rif_cl,negociol,direccionl1,direccionl2,clientel,codigol,fechal,horal,ival,telefonosl,subtotal,totall,iva_p,email,titulo;
	JTextArea direccion,telefonos,direccion_empre,tipo_pago;
	JButton cancelar,cancelar_prodx;
	Connection cone;
	JScrollPane barra;

	//-------------------------------------------------------------
	JTable tabla;
	
	static String[] columnas={" Codigo  " ,"Cantidad","       Descripcion       ","   Costo   ","  SubTotal   ","Estado"};
	
	static String[][]filas={{""}};
	
	
	@SuppressWarnings("serial")
	static DefaultTableModel dtm=new DefaultTableModel(filas,columnas){
		
		public boolean isCellEditable(int row ,int column){return false;}
			
		};
	String resul="";
	int p=0;
	LinkedList<Factura> listaf=new LinkedList<>(); 
	int posicion_listaf=0;
	Dialogo d=new Dialogo("Factura ", 700, 550);
	public Ver_factura(Confing c,LinkedList<Factura> f,String codigo)
	{
		
		listaf=f;
		
		LinkedList<Cliente> user=new LinkedList<>(); 
	
		int posicion=0;
	
		for(int i=0;i<f.size();i++)
		{
			if(f.get(i).getCodigo().equals(codigo))
			{
				posicion=i;
				p=i;
				posicion_listaf=i;
				break;
			}
		}
		
		
	
		user=new Conexion_clientes().buscar(f.get(posicion).getCliente());
		
		
		
		
		
		Fondo_factura fondo= new Fondo_factura(d.getWidth(),d.getHeight());
        tabla=new JTable(dtm);
		barra=new JScrollPane(tabla);
		barra.setBounds(7,180,680,150);
	
		
		negociol=new JLabel(c.getNombre_empresa());
		new Pintar_label(negociol);
		negociol.setBounds(15,5,300,20);
		d.add(negociol);
		
		rif_vl=new JLabel("Rif: "+c.getRif());
		new Pintar_label(rif_vl);
		rif_vl.setBounds(15,25,100,20);
		d.add(rif_vl);
		
		JLabel Usuario=new JLabel("Usuario: "+f.get(posicion).getUsuario());
		new Pintar_label(Usuario);
		Usuario.setBounds(15,45,200,20);
		d.add(Usuario);
		
		direccionl2=new JLabel("Direccion:");
		new Pintar_label(direccionl2);
		direccionl2.setBounds(15,65,100,20);
		d.add(direccionl2);
		
		
		   direccion_empre=new JTextArea(c.getDireccion());
	       JScrollPane barra2=new JScrollPane(direccion_empre);
	        barra2.setBounds(15,85,250,80);
			new Pintar_txtarea(direccion_empre);
			direccion_empre.setBorder(null);
			direccion_empre.setForeground(Color.WHITE);
			direccion_empre.setBackground(Color.BLACK);
			direccion_empre.setEditable(false);
			direccion_empre.setBorder(null);
			barra2.setBorder(null);
			d.add(barra2);
		
		
		
		clientel=new JLabel("CLIENTE: "+user.get(0).getNombre());
		new Pintar_label(clientel);
		clientel.setBounds(450,5,200,20);
		d.add(clientel);
		
		rif_cl=new JLabel("RIF: "+f.get(posicion).getCliente());
		new Pintar_label(rif_cl);
		rif_cl.setBounds(450,25,100,20);
		d.add(rif_cl);
		
		direccionl1=new JLabel("Direccion:");
		new Pintar_label(direccionl1);
		direccionl1.setBounds(450,45,100,20);
		d.add(direccionl1);
		
		direccion=new JTextArea(user.get(0).getDireccion());
		 JScrollPane barra1=new JScrollPane(direccion);
		 barra1.setBounds(450,65,200,80);
		 
		new Pintar_txtarea(direccion);
		direccion.setForeground(Color.WHITE);
		direccion.setBackground(Color.BLACK);
		direccion.setEditable(false);
	    direccion.setBorder(null);
	    barra1.setBorder(null);
	    d.add(barra1);
		
		
		cancelar=new JButton("Cancelar factura");
		new Pintar_boton(cancelar);
		cancelar.setBounds(10,480,150,30);
		d.add(cancelar);
     
		
		cancelar_prodx=new JButton("Cancelar Producto Seleccionado");
		new Pintar_boton(cancelar_prodx);
		cancelar_prodx.setBounds(250,480,200,30);
		//d.add(cancelar_prodx);
		
		titulo=new JLabel("FACTURA");
		new Pintar_label(titulo);
		titulo.setFont(new Font(null, 1, 15));
		titulo.setBounds(310,130,200,20);
		d.add(titulo);
		
	
	
	imprimir=new JButton("imprimir");	
	new Pintar_boton(imprimir);
	imprimir.setBounds(533,480,150,30);
    d.add(imprimir);
		
		
		codigol=new JLabel("FACTURA: "+f.get(posicion).getCodigo());
		new Pintar_label(codigol);
		codigol.setBounds(15,160,150,20);
		d.add(codigol);
		
		fechal=new JLabel("FECHA: "+f.get(posicion).getFecha());
		new Pintar_label(fechal);
		fechal.setBounds(460,160,120,20);
		d.add(fechal);
		
		horal=new JLabel("HORA: "+f.get(posicion).getHora());
		new Pintar_label(horal);
		horal.setBounds(590,160,100,20);
		d.add(horal);
		
		
		
		
		
		
		ival=new JLabel("IVA:    "+f.get(posicion).getIva()+"%");
		new Pintar_label(ival);
		ival.setBounds(15,330,100,20);
		d.add(ival);
		
		
		telefonosl=new JLabel("Telf:");
		new Pintar_label(telefonosl);
		telefonosl.setBounds(15,350,100,30);
		d.add(telefonosl);
		
		telefonos=new JTextArea(c.getTelefono1()+"\n"+c.getTelefono2()+"\n"+c.getTelefono3());
		telefonos.setBounds(50,350,100,55);
		telefonos.setEditable(false);
		telefonos.setBackground(Color.BLACK);
		telefonos.setForeground(Color.WHITE);
		new Pintar_txtarea(telefonos);
		telefonos.setBorder(null);
		d.add(telefonos);
		
		email=new JLabel("Email: "+c.getCorrero());
		new Pintar_label(email);
		email.setBounds(15,400,300,30);
		d.add(email);
		new Pintar_filas(tabla);
				
		int x2=dtm.getRowCount();
		for(int j=0;j<x2;j++)
		{
		dtm.removeRow(0);
		}
		
		
		BigDecimal SunTOTAL=new BigDecimal("0");
		
		
		for(int i=0;i<f.get(posicion).getPro_fac_sise();i++)
		{
			String vector[]=new String[6];
			vector[0]=f.get(posicion).getPro_fac(i)[0];
			vector[1]=f.get(posicion).getPro_fac(i)[1];
			try{
			
				cone=Conexion.conect;
			    Statement stm= cone.createStatement();
			    ResultSet rs= stm.executeQuery("select DESCRIPCION  from PRODUCTOS where CODIGO='"+f.get(posicion).getPro_fac(i)[0]+"'");
			    rs.next();
			    vector[2]=rs.getString(1);
			    
			}catch (Exception e){}
			
			BigDecimal RS=new BigDecimal("0");
			String canString[]=f.get(posicion).getPro_fac(i)[1].split(":");
			BigDecimal cantidad=new BigDecimal(canString[0]);
			
			BigDecimal costo=new BigDecimal(f.get(posicion).getPro_fac(i)[2]);
		    RS=costo.multiply(cantidad).setScale(2,RoundingMode.HALF_EVEN);
			
			vector[3]=f.get(posicion).getPro_fac(i)[2];
			vector[4]=""+RS;
			
			if(f.get(posicion).getPro_fac(i)[3].equals("1"))
			{vector[5]="Activo";}
			else{vector[5]="Cancelado";}
			
			 SunTOTAL=RS.add(SunTOTAL);
			
			dtm.addRow(vector);
		}
		
		BigDecimal cont=new BigDecimal("0");
		 BigDecimal cien=new BigDecimal("100");
		 BigDecimal Ivabig=new BigDecimal(f.get(posicion).getIva());
		
		 
		 cont=SunTOTAL.multiply(Ivabig).setScale(2,RoundingMode.HALF_EVEN);
		
		 Ivabig=cont.divide(cien).setScale(2,RoundingMode.HALF_EVEN);
		
		
		
		
		BigDecimal TOTALL=new BigDecimal("0");
		TOTALL=SunTOTAL.add(Ivabig).setScale(2,RoundingMode.HALF_EVEN);


		
		subtotal=new JLabel("SUBTOTAL:         BsF "+SunTOTAL);
		new Pintar_label(subtotal);
		subtotal.setBounds(500,330,200,20);
		d.add(subtotal);
		
		iva_p=new JLabel("IVA:                       BsF "+Ivabig);
		new Pintar_label(iva_p);
		iva_p.setBounds(500,350,250,20);
		d.add(iva_p);
		
		
		
		totall=new JLabel("TOTAL:                 BsF "+TOTALL);
		new Pintar_label(totall);
		totall.setBounds(500,370,250,20);
		d.add(totall);
	
		
        BigDecimal total_tipo_pago =new BigDecimal("0");
		
		String tipo_de_pago="";
		for(int r=0;r<f.get(posicion).getTipo_pago_sise();r++)
		{
		tipo_de_pago+=f.get(posicion).getTipo_pago(r)[0]+":\t BsF "+f.get(posicion).getTipo_pago(r)[1]+"\n";	
		
		BigDecimal pago =new BigDecimal(f.get(posicion).getTipo_pago(r)[1]);
		
		total_tipo_pago=total_tipo_pago.add(pago);
		}
		
		total_tipo_pago=total_tipo_pago.subtract(TOTALL).setScale(2,RoundingMode.HALF_EVEN);
		
		
		tipo_de_pago=tipo_de_pago+"VUELTO:              BsF "+total_tipo_pago;
		tipo_pago=new JTextArea(tipo_de_pago);
		tipo_pago.setBounds(500,390,180,80);
		new Pintar_txtarea(tipo_pago);
		tipo_pago.setForeground(Color.WHITE);
		tipo_pago.setBackground(Color.BLACK);
		tipo_pago.setEditable(false);
		tipo_pago.setBorder(null);
		d.add(tipo_pago);
		
		
		
		imprimir.addActionListener(this);
		
		cancelar_prodx.addActionListener(this);
		cancelar.addActionListener(this);
		
		d.add(barra);
		d.add(fondo);
		
		if(f.get(posicion).getEstado().equals("0"))
		{
			cancelar.setEnabled(false);
			cancelar_prodx.setEnabled(false);
			titulo.setText("FACTURA CANCELADA");
			titulo.setBounds(280,130,250,20);
	         new Mensaje().error("Esta Factura Esta Cancelada", "Cancelada");
		}
		
		
		tabla.addMouseListener(this);
		d.setVisible(true);
		
	
		
	}

	@Override
	public void actionPerformed(ActionEvent boton_que_se_presiono) {
		
		if(boton_que_se_presiono.getSource()==imprimir)
		{
			new Imprimir_x_factura(listaf.get(p).getCodigo());
		}
		else if(boton_que_se_presiono.getSource()==cancelar)
		{
			new Mensaje().pregunta("Desea Cancelar la Factura","Cancelar");
			if(Mensaje.resp)
			{
				 new Guardar_Factura().cancelar_factura(listaf.get(posicion_listaf));
		         new Mensaje().listo("La Factura Fue Cancelada","Cancelada");
		         d.dispose();
			}
		}
		else if(boton_que_se_presiono.getSource()==cancelar_prodx)
		{

			if(tabla.getSelectedRow()>=0)
			{
				
				new Mensaje().inpout("Inserte la Cantidad de la Devolucion","Cantidad A Cancelar", "dinero");
			if(Mensaje.resp_inpout)
			{
				boolean x=true;
				BigDecimal inpout=new BigDecimal("0");
				try{inpout=new BigDecimal(Mensaje.dato);}catch(Exception e){new Mensaje().error("Los Valores no Son Validos","Error");x=false;}
				
				String zz[]=tabla.getValueAt(tabla.getSelectedRow(),1).toString().split(":");
				
				if( x==false || inpout.compareTo(new BigDecimal("0"))==0 || inpout.compareTo(new BigDecimal(zz[0]))>0)
				{
					if(x=false){new Mensaje().error("Error la Cantidad no es valida", "Error");}
					else if(inpout.compareTo(new BigDecimal("0"))==0){new Mensaje().error("La Cantidad no puede ser cero", "Error");}
					else if(inpout.compareTo(new BigDecimal(zz[0]))>0){new Mensaje().error("La Cantidad Introducida es mayor a la Registrada", "Error");}
				}
				else
				{
					boolean delete=false;
					if(inpout.compareTo(new BigDecimal(zz[0]))==0)
					{delete=true;}
					
					boolean cancelar_factura=false;
					int cant_filas=tabla.getRowCount();
					
					BigDecimal n1=new BigDecimal(Mensaje.dato);
					BigDecimal n2=new BigDecimal(zz[0]);
					
					
					int contador=0;
					for(int i=0;i<cant_filas;i++)
					{
						if(tabla.getValueAt(i, 5).equals("Cancelado"))
						{
							contador++;
						}
						
					}
					
					if(n1.compareTo(n2)==0 && contador==cant_filas-1)
					{
						cancelar_factura=true;
					}
					
				
					boolean zzzzz=new Guardar_Factura().cancelar_producto(zz[0],tabla.getValueAt(tabla.getSelectedRow(),0).toString(),Mensaje.dato,listaf.get(posicion_listaf).getCodigo(),delete,cancelar_factura);
					
					if(zzzzz==false)
					{
						new Mensaje().listo("La Cantidad del Producto fue Retirado de la Factura","Realizado");
						d.dispose();
					}
					else{new Mensaje().error("Hubo un error al Realizar la Operacion", "Error");}
				}
			
			}
				
			}else{new Mensaje().error("Debe Seleccionar Un Producto a Cancelar","Seleccione");}
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

       if(arg0.getSource().equals(tabla))
       {
    	   if(tabla.getValueAt(tabla.getSelectedRow(), 5).equals("Cancelado"))
    	   {
    		   cancelar_prodx.setEnabled(false);
    	   }
    	   else{cancelar_prodx.setEnabled(true);}
       }
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
