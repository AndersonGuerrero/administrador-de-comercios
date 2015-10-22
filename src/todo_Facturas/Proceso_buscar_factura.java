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
				ResultSet rs1=stm.executeQuery("select count(1) from facturacion where COD_FAC like '%"+texto+"%' or CLIENTE LIKE '%"+texto+"%' or FECHA LIKE '%"+texto+"%' or HORA LIKE '%"+texto+"%' or USUARIO like'%"+texto+"%'");
				
				rs1.next();
				int result=rs1.getInt(1);
				int progres=0;
				
			
			
				Buscar_facturas.barra_progreso.setMaximum(result*2);
				if(result>=1)
				{
					ResultSet rs=stm.executeQuery("select  *from facturacion where COD_FAC like '%"+texto+"%' or CLIENTE LIKE '%"+texto+"%' or FECHA LIKE '%"+texto+"%' or HORA LIKE '%"+texto+"%' or USUARIO like'%"+texto+"%'");
					
					while(rs.next())
					{
						Factura f=new Factura();
						f.setCodigo(rs.getString("COD_FAC"));
						f.setCliente(rs.getString("CLIENTE"));
						f.setFecha(rs.getString("FECHA"));
						f.setHora(rs.getString("HORA"));
						f.setIva(rs.getString("IVA"));
						f.setUsuario(rs.getString("USUARIO"));
						f.setEstado(rs.getString("ESTADO"));
						
				
						ResultSet rs3=stm2.executeQuery("select  *from tipo_pago where COD_FACT='"+f.getCodigo()+"'");
						
						while(rs3.next())
						{
							String xvector[]=new String[2];
							xvector[0]=rs3.getString("TIPO_PAGO");
							xvector[1]=rs3.getString("CANTIDAD");
							f.setTipo_pago(xvector);
						}
						
						ResultSet rs2=stm2.executeQuery("select  *from fac_prod where COD_FACT='"+f.getCodigo()+"'");
				
						while(rs2.next())
						{
					     String vector[]=new String[4];
					     vector[0]=rs2.getString("COD_PRO");
					     vector[1]=rs2.getString("CANTIDAD");
					     vector[2]=rs2.getString("COSTO");
					     vector[3]=rs2.getString("estado");
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
