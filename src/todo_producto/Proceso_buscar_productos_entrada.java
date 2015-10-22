package todo_producto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import administrador.Conexion;

import funciones.Mensaje;

public class Proceso_buscar_productos_entrada extends Thread  {
	String texto;
	Connection Conex;
	int x=0;
	
	
	public Proceso_buscar_productos_entrada(){}
	
	public Proceso_buscar_productos_entrada(String txt)
	{
		Conex=Conexion.conect;
		texto=txt;
		x=0;
		//setPriority(NORM_PRIORITY);
	}
	
	public void run()
	{
			
		LinkedList<Producto> xxx=new LinkedList<>();
		Entradas.lista=xxx;
		int xx=Entradas.dtm.getRowCount();
		for(int i=0;i<xx;i++)
		{
		 Entradas.dtm.removeRow(0);
		}
         
			try {
				Statement stm= Conex.createStatement();
				ResultSet rs2=stm.executeQuery("select count(1) from productos where CODIGO like '%"+texto+"%' or NOMBRE LIKE '%"+texto+"%' or MARCA LIKE '%"+texto+"%' or MODELO LIKE '%"+texto+"%' or DESCRIPCION LIKE '%"+texto+"%'");
				
				rs2.next();
				x=rs2.getInt(1);
				
				rs2.close();
				Entradas.barra_progreso.setMaximum(x*2);
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
					p.setDepartamento(rs.getString(8));
					p.setCantidad(rs.getString(9));
					p.setCod_proveedor(rs.getString(10));
					p.setFecha(rs.getString(11));
					Entradas.lista.add(p);
					x++;
					Entradas.barra_progreso.setValue(x);
				}
				rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
				new Mensaje().error("Error Al Buscar El Proveedor", "Error "+e);
			}
			
			 if(Entradas.lista.size()<=0)
			   {
				 Entradas.barra_progreso.setMaximum(10);
				 Entradas.barra_progreso.setValue(10);
				new Mensaje().error("No se han encontrado registros","No encontrado" );
				Entradas.barra_progreso.setValue(0);
				Entradas.Codigo.setText("");
				Entradas.descripcion.setText("");
				Entradas.cant_exis.setText("");
				Entradas.cant_entra.setText("");
				Entradas.agregar.setEnabled(false);
				int x=Entradas.dtm.getRowCount();
				for(int i=0;i<x;i++)
				{
					Entradas.dtm.removeRow(0);
				}
			}
			else
			{
				agregar();
			}
		
		
	}
	
	
	public void agregar()
	{
		int x2= Entradas.dtm.getRowCount();
		for(int j=0;j<x2;j++)
		{
			Entradas.dtm.removeRow(0);
		}

		for(int i=0;i<Entradas.lista.size();i++)
		{
			
		String vector[]=new String[6];
		vector[0]=Entradas.lista.get(i).getCodigo();
		vector[1]=Entradas.lista.get(i).getNombre();
		vector[2]=Entradas.lista.get(i).getDescripcion();
		vector[3]=Entradas.lista.get(i).getMarca();
		vector[4]=Entradas.lista.get(i).getModelo();
		vector[5]=Entradas.lista.get(i).getDepartamento();
		
		Entradas.dtm.addRow(vector);
		x++;
		Entradas.barra_progreso.setValue(x);
		
		}
		
		
	}
	
	
}
