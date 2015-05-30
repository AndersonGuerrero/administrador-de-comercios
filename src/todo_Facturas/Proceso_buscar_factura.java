package todo_Facturas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import funciones.Mensaje;

import administrador.Conexion;

public class Proceso_buscar_factura extends Thread {

	String texto;
	Connection cone;
	public Proceso_buscar_factura(String txt)
	{
		texto=txt;
		cone=Conexion.conect;
		start();
	}

	
	
	public void run()
	{
	    LinkedList<Factura> lista=new LinkedList<>();
        
			try {
				Statement stm= cone.createStatement();
				Statement stm2= cone.createStatement();
				//Statement stm3= cone.createStatement();
				ResultSet rs1=stm.executeQuery("select count(1) from FACTURACION where COD_FAC like '%"+texto+"%' or CLIENTE LIKE '%"+texto+"%' or FECHA LIKE '%"+texto+"%' or HORA LIKE '%"+texto+"%' or USUARIO like'%"+texto+"%'");
				
				rs1.next();
				int result=rs1.getInt(1);
				int progres=0;
				
			
			
				Buscar_facturas.barra_progreso.setMaximum(result*2);
				if(result>=1)
				{
					ResultSet rs=stm.executeQuery("select  *from FACTURACION where COD_FAC like '%"+texto+"%' or CLIENTE LIKE '%"+texto+"%' or FECHA LIKE '%"+texto+"%' or HORA LIKE '%"+texto+"%' or USUARIO like'%"+texto+"%'");
					
					while(rs.next())
					{
						Factura f=new Factura();
						f.setCodigo(rs.getString(1));
						f.setCliente(rs.getString(2));
						f.setFecha(rs.getString(3));
						f.setHora(rs.getString(4));
						f.setIva(rs.getString(5));
						f.setUsuario(rs.getString(6));
						f.setEstado(rs.getString(7));
						
				
						ResultSet rs3=stm2.executeQuery("select  *from TIPO_PAGO where COD_FACT='"+f.getCodigo()+"'");
						
						while(rs3.next())
						{
							String xvector[]=new String[2];
							xvector[0]=rs3.getString(2);
							xvector[1]=rs3.getString(3);
							f.setTipo_pago(xvector);
						}
						
						ResultSet rs2=stm2.executeQuery("select  *from FAC_PROD where COD_FACT='"+f.getCodigo()+"'");
				
						while(rs2.next())
						{
					     String vector[]=new String[4];
					     vector[0]=rs2.getString(2);
					     vector[1]=rs2.getString(3);
					     vector[2]=rs2.getString(4);
					     vector[3]=rs2.getString(5);
					     f.setPro_fac(vector);
						}
						
						
						
						lista.add(f);
						progres++;
						Buscar_facturas.barra_progreso.setValue(progres);
					}
					
					rs.close();	
					stm.close();
					
					Buscar_facturas.lista_principal=lista;
					int x2=Buscar_facturas.dtm.getRowCount();
					for(int j=0;j<x2;j++)
					{
						Buscar_facturas.dtm.removeRow(0);
					}
					
					for(int i=0;i<lista.size();i++)
					{
						String array[]=new String[5];
						array[0]=lista.get(i).getCodigo();
						array[1]=lista.get(i).getCliente();
						array[2]=lista.get(i).getUsuario();
						array[3]=lista.get(i).getFecha();
						array[4]=lista.get(i).getHora();
						Buscar_facturas.dtm.addRow(array);
						progres++;
						Buscar_facturas.barra_progreso.setValue(progres);
					}
					
				}else
				{new Mensaje().error("La descripcion de la factura no existe ","No encontrado");}
				
				
				
			
			
			
			} catch (SQLException e) {
				e.printStackTrace();
				new Mensaje().error("Error Al Buscar El Producto", "Error "+e);
			}
		
		
		
	}
}
