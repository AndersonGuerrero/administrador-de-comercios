package todo_clientes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import administrador.Conexion;


import funciones.Mensaje;

public class Conexion_clientes {

  
	Connection com;
  public Conexion_clientes(){com=Conexion.conect;}
  
  
  public boolean Nuevo(Cliente cliente)
	{
	  try {
		  
			Statement stm= com.createStatement();
			ResultSet rs=stm.executeQuery("select *from clientes where CEDULA='"+cliente.getRif()+"'");
			Statement stm2= com.createStatement();
			rs.next();
			
		if(rs.getRow()>=1)
		{
			new Mensaje().error("Este Usuario ya Esta Registrado", "El Usuario Existe");
			rs.close();
			stm.close();
			return false;
		}
		else
		{
		  stm2.execute("insert into clientes values('"+cliente.getRif()+"','"+cliente.getNombre()+"','"+cliente.getApellido()+"','"+cliente.getDireccion()+"')");
		  stm2.close();
		}
		
		} catch (Exception e) {
			new Mensaje().error("Error al Insertar el Cliente","Error "+e);
		}
	return true;
	
	}
  

	public LinkedList<Cliente> buscar(String texto)
	{
		LinkedList<Cliente> lista=new LinkedList<>();
		
		try {
			Statement stm= com.createStatement();
			ResultSet rs=stm.executeQuery("select *from clientes where NOMBRE like '%"+texto+"%' or CEDULA LIKE '%"+texto+"%' or APELLIDO LIKE '%"+texto+"%' or DIRECCION LIKE '%"+texto+"%'");
			
			
			while(rs.next())
			{
				Cliente c=new Cliente();
				
				c.setNombre(rs.getString("NOMBRE"));
				c.setApellido(rs.getString("APELLIDO"));
				c.setRif(rs.getString("CEDULA"));
				c.setDireccion(rs.getString("DIRECCION"));
				lista.add(c);
			}
			
		return lista;
		
		} catch (SQLException e) {
		}
		return lista;
		
	}

	
	public LinkedList<Cliente> buscar_cedula(String cedula)
	{
		LinkedList<Cliente> lista=new LinkedList<>();
		
		try {
			Statement stm= com.createStatement();
			ResultSet rs=stm.executeQuery("select *from clientes where CEDULA='"+cedula+"'");
			
			while(rs.next())
			{
				Cliente c=new Cliente();
				
				c.setNombre(rs.getString("NOMBRE"));
				c.setApellido(rs.getString("APELLIDO"));
				c.setRif(rs.getString("CEDULA"));
				c.setDireccion(rs.getString("DIRECCION"));
				lista.add(c);
			}
			
		return lista;
		
		} catch (SQLException e) {
		}
		return lista;
		
	}
	
	
	
	public void actualizar(Cliente c,String cedula)
	{
		try {
			int cant=0;
			Statement stm= com.createStatement();
			
			ResultSet rs=stm.executeQuery("Select CEDULA from clientes where CEDULA='"+c.getRif()+"'");
			while(rs.next())
			{
				cant++;
			}
			
			
			if(c.getRif().equals(cedula)){
			
			
			stm.executeUpdate("update clientes SET CEDULA='"+c.getRif()+"', NOMBRE='"+c.getNombre()+"',  APELLIDO='"+c.getApellido()+"',DIRECCION='"+c.getDireccion()+"' WHERE CEDULA='"+cedula+"'");
			new Mensaje().listo("El Usuario Fue Actualizado..","Actualizado");
			stm.close();
		}
			else
			{
				if(cant>=1){new Mensaje().error("El Usuario ya Existe","Error");}
				else
				{
					stm.executeUpdate("update clientes SET CEDULA='"+c.getRif()+"', NOMBRE='"+c.getNombre()+"',  APELLIDO='"+c.getApellido()+"',DIRECCION='"+c.getDireccion()+"' WHERE CEDULA='"+cedula+"'");
					new Mensaje().listo("El Usuario Fue Actualizado..","Actualizado");
					stm.close();
				}
				
			}
			
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		new Mensaje().error("Error Al Actualizar el Cliente", "Error");	
		}
		
	}
	
	
	public void eliminar(String cedula)
	{
		try{
		Statement stm= com.createStatement();
		stm.executeUpdate("delete from clientes where CEDULA='"+cedula+"'");
		}catch(Exception e)
		{
			new Mensaje().error("Error al Eliminar el Cliente", "");
		}	
	}
}
