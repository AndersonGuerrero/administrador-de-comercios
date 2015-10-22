package todo_Facturas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import todo_producto.Producto;

import administrador.Conexion;

import funciones.Enfocar;
import funciones.Mensaje;

public class Poceso_buscar_producto_Facturacion extends Thread  {
	String texto;
	Connection Conex;
	int x=0;
	
	
	
	public Poceso_buscar_producto_Facturacion(String txt)
	{
		Conex=Conexion.conect;
		texto=txt;
		x=0;
		start();
	}
	
	public void run()
	{
		synchronized (Facturacion.dtm1) {
			Facturacion.lista_taba1.clear();
			int eliminacion=Facturacion.dtm1.getRowCount();
			for(int i=0;i<eliminacion;i++){
				
				Facturacion.dtm1.removeRow(0);
			}
         
			try {
				Statement stm= Conex.createStatement();
				ResultSet rs2=stm.executeQuery("select count(1) from productos where CODIGO like '%"+texto+"%' or NOMBRE LIKE '%"+texto+"%' or MARCA LIKE '%"+texto+"%' or MODELO LIKE '%"+texto+"%' or DESCRIPCION LIKE '%"+texto+"%'");
				
				rs2.next();
				x=rs2.getInt(1);
				
				rs2.close();
				
				ResultSet rs=stm.executeQuery("select *from productos where CODIGO like '%"+texto+"%' or NOMBRE LIKE '%"+texto+"%' or MARCA LIKE '%"+texto+"%' or MODELO LIKE '%"+texto+"%' or DESCRIPCION LIKE '%"+texto+"%'");
				
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
				    Facturacion.lista_taba1.add(p);
				}
				rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
				new Mensaje().error("Error Al Buscar El Proveedor", "Error "+e);
			}
			
			 if(Facturacion.lista_taba1.size()<=0)
			   {
				 Facturacion.label_buqueda.setVisible(false);
				new Mensaje().error("No se han encontrado registros","No encontrado" );
				
				int x=Facturacion.dtm1.getRowCount();
				for(int i=0;i<x;i++)
				{
					Facturacion.dtm1.removeRow(0);
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
		int x2=Facturacion.dtm1.getRowCount();
		for(int j=0;j<x2;j++)
		{
			Facturacion.dtm1.removeRow(0);
		}

		for(int i=0;i<Facturacion.lista_taba1.size();i++)
		{
			
		String vectorx[]=new String[9];
		vectorx[0]=Facturacion.lista_taba1.get(i).getCodigo();
		vectorx[1]=Facturacion.lista_taba1.get(i).getNombre();
		vectorx[2]=Facturacion.lista_taba1.get(i).getMarca();
		vectorx[3]=Facturacion.lista_taba1.get(i).getModelo();
		vectorx[4]=Facturacion.lista_taba1.get(i).getDescripcion();
		
		String zzzz[]=Facturacion.lista_taba1.get(i).getCantidad().split(":");
		vectorx[5]=zzzz[0]+" "+zzzz[1];
		
		vectorx[6]=Facturacion.lista_taba1.get(i).getCosto_compra();
		vectorx[7]=Facturacion.lista_taba1.get(i).getCosto_venta();
		vectorx[8]=Facturacion.lista_taba1.get(i).getDepartamento();
		
		Facturacion.dtm1.addRow(vectorx);
		
		}
		if(x>=1)
		{
		 Facturacion.tabla1.changeSelection(0, 0, false, false);
		 new Enfocar(Facturacion.tabla1);
		}
		Facturacion.label_buqueda.setVisible(false);
		
	}
	
	
}