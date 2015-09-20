package todo_producto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import administrador.Conexion;

import funciones.Mensaje;

public class Proceso_buscar_productos extends Thread  {
	String texto;
	Connection Conex;
	int x=0;
	
	
	public Proceso_buscar_productos(){}
	
	public Proceso_buscar_productos(String txt)
	{
		Conex=Conexion.conect;
		texto=txt;
		x=0;
		//setPriority(NORM_PRIORITY);
		
		start();
	}
	
	public void run()
	{
		synchronized (Buscar_Producto.dtm) {
			
		LinkedList<Producto> xxx=new LinkedList<>();
		Buscar_Producto.listaa=xxx;
		int xx=Buscar_Producto.dtm.getRowCount();
		for(int i=0;i<xx;i++)
		{
		 Buscar_Producto.dtm.removeRow(0);
		}
         
			try {
				Statement stm= Conex.createStatement();
				ResultSet rs2=stm.executeQuery("select count(1) from productos where CODIGO like '%"+texto+"%' or NOMBRE LIKE '%"+texto+"%' or MARCA LIKE '%"+texto+"%' or MODELO LIKE '%"+texto+"%' or DESCRIPCION LIKE '%"+texto+"%'");
				
				rs2.next();
				x=rs2.getInt(1);
				
				rs2.close();
				Buscar_Producto.barra_carga.setMaximum(x*2);
				ResultSet rs=stm.executeQuery("select *from productos where CODIGO like '%"+texto+"%' or NOMBRE LIKE '%"+texto+"%' or MARCA LIKE '%"+texto+"%' or MODELO LIKE '%"+texto+"%' or DESCRIPCION LIKE '%"+texto+"%'");
				
				
				x=0;
				while(rs.next())
				{
					Producto p=new Producto();
					p.setCodigo(rs.getString(1));
					p.setNombre(rs.getString(2));
					p.setMarca(rs.getString(3));
					p.setModelo(rs.getString(4));
					p.setDescripcion(rs.getString(5));
					p.setCosto_compra(rs.getString(6));
					p.setCosto_venta(rs.getString(7));
					p.setUbicacion(rs.getString(8));
					p.setCantidad(rs.getString(9));
					p.setCod_proveedor(rs.getString(10));
					Buscar_Producto.listaa.add(p);
					x++;
					Buscar_Producto.barra_carga.setValue(x);
				}
				rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
				new Mensaje().error("Error Al Buscar El Proveedor", "Error "+e);
			}
			
			 if(Buscar_Producto.listaa.size()<=0)
			   {
				 Buscar_Producto.barra_carga.setMaximum(10);
			    Buscar_Producto.barra_carga.setValue(10);
				new Mensaje().error("No se han encontrado registros","No encontrado" );
				Buscar_Producto.barra_carga.setValue(0);
				Buscar_Producto.codigo.setText("");
				Buscar_Producto.nombre.setText("");
				Buscar_Producto.cantidad.setText("");
				Buscar_Producto.marca.setText("");
				Buscar_Producto.modelo.setText("");
				Buscar_Producto.descripcion.setText("");
				Buscar_Producto.costo_com.setText("");
				Buscar_Producto.costo_vent.setText("");
				Buscar_Producto.ubicacion.setText("");
				Buscar_Producto.lista.setSelectedIndex(0);
				Buscar_Producto.tipo_cant.setSelectedIndex(0);
				
				int x=Buscar_Producto.dtm.getRowCount();
				for(int i=0;i<x;i++)
				{
					Buscar_Producto.dtm.removeRow(0);
				}
			}
			else
			{
				agregar();
				
				
				
				
			}
		
		}
	}
	
	
	public void agregar()
	{
		int x2= Buscar_Producto.dtm.getRowCount();
		for(int j=0;j<x2;j++)
		{
			Buscar_Producto.dtm.removeRow(0);
		}

		for(int i=0;i<Buscar_Producto.listaa.size();i++)
		{
			
		String vector[]=new String[6];
		vector[0]=Buscar_Producto.listaa.get(i).getCodigo();
		vector[1]=Buscar_Producto.listaa.get(i).getNombre();
		vector[2]=Buscar_Producto.listaa.get(i).getDescripcion();
		vector[3]=Buscar_Producto.listaa.get(i).getMarca();
		vector[4]=Buscar_Producto.listaa.get(i).getModelo();
		vector[5]=Buscar_Producto.listaa.get(i).getUbicacion();
		
		Buscar_Producto.dtm.addRow(vector);
		x++;
		Buscar_Producto.barra_carga.setValue(x);
		
		}
		
		
	}
	
	
}
