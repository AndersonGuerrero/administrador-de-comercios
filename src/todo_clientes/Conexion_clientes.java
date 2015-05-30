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
			ResultSet rs=stm.executeQuery("select *from CLIENTES where CEDULA='"+cliente.getRif()+"'");
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
		  stm2.execute("insert into CLIENTES values('"+cliente.getRif()+"','"+cliente.getNombre()+"','"+cliente.getApellido()+"','"+cliente.getDireccion()+"')");
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
			ResultSet rs=stm.executeQuery("select *from CLIENTES where NOMBRE like '%"+texto+"%' or CEDULA LIKE '%"+texto+"%' or APELLIDO LIKE '%"+texto+"%' or DIRECCION LIKE '%"+texto+"%'");
			
			
			while(rs.next())
			{
				Cliente c=new Cliente();
				
				c.setNombre(rs.getString(2));
				c.setApellido(rs.getString(3));
				c.setRif(rs.getString(1));
				c.setDireccion(rs.getString(4));
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
			ResultSet rs=stm.executeQuery("select *from CLIENTES where CEDULA='"+cedula+"'");
			
			while(rs.next())
			{
				Cliente c=new Cliente();
				
				c.setNombre(rs.getString(2));
				c.setApellido(rs.getString(3));
				c.setRif(rs.getString(1));
				c.setDireccion(rs.getString(4));
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
			
			ResultSet rs=stm.executeQuery("Select CEDULA from CLIENTES where CEDULA='"+c.getRif()+"'");
			while(rs.next())
			{
				cant++;
			}
			
			
			if(c.getRif().equals(cedula)){
			
			
			stm.executeUpdate("update CLIENTES SET CEDULA='"+c.getRif()+"', NOMBRE='"+c.getNombre()+"',  APELLIDO='"+c.getApellido()+"',DIRECCION='"+c.getDireccion()+"' WHERE CEDULA='"+cedula+"'");
			new Mensaje().listo("El Usuario Fue Actualizado..","Actualizado");
			stm.close();
		}
			else
			{
				if(cant>=1){new Mensaje().error("El Usuario ya Existe","Error");}
				else
				{
					stm.executeUpdate("update CLIENTES SET CEDULA='"+c.getRif()+"', NOMBRE='"+c.getNombre()+"',  APELLIDO='"+c.getApellido()+"',DIRECCION='"+c.getDireccion()+"' WHERE CEDULA='"+cedula+"'");
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
		stm.executeUpdate("delete from CLIENTES where CEDULA='"+cedula+"'");
		}catch(Exception e)
		{
			new Mensaje().error("Error al Eliminar el Cliente", "");
		}
		
	}
	
	
  
}
