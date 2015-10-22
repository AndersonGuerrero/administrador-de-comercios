package Todo_recepciones;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import funciones.Mensaje;

import administrador.Conexion;

public class Procesos_recepciones extends Thread {

	Connection conex;
	String texto;
	public Procesos_recepciones( String t)
	{
		texto=t;
	conex=Conexion.conect;
	this.start();
	}
	
	
	
	
	public void buscar(String  txt)
	{
		try{
			int carga=0;
			int x2=0;
			Statement stm=conex.createStatement();
			
			ResultSet rs=stm.executeQuery("Select count(1) from recepciones where COD_RECEP LIKE'%"+txt+"%' or COD_PRO LIKE'%"+txt+"%' or COD_PROD LIKE'%"+txt+"%' or FECHA LIKE'%"+txt+"%' or HORA LIKE'%"+txt+"%'");
			
		        rs.next();
		        
		    	x2=rs.getInt(1);
		    	
		    	rs.close();
		    	
			Buscar_recepciones.barra_de_progreso.setMaximum(x2*2);
			
			if(x2>=1)
			{
				LinkedList<Recepciones> lista= new LinkedList<>();
				
				ResultSet rs2=stm.executeQuery("Select *from recepciones where COD_RECEP LIKE'%"+txt+"%' or COD_PRO LIKE'%"+txt+"%' or COD_PROD LIKE'%"+txt+"%' or FECHA LIKE'%"+txt+"%' or HORA LIKE'%"+txt+"%'");
				
				while(rs2.next())
				{
				    Recepciones r=new Recepciones();
					r.setCOD_RECEP(rs2.getString(1));
					r.setCOD_PRO(rs2.getString(2));
					r.setCOD_PROD(rs2.getString(3));
					r.setFECHA(rs2.getString(4));
					r.setHORA(rs2.getString(5));
					r.setCOSTO(rs2.getString(6));
					r.setCANTIDAD(rs2.getString(7));
				lista.add(r);
				carga++;
				Buscar_recepciones.barra_de_progreso.setValue(carga);
				}
			
					
				int xx=Buscar_recepciones.dtm.getRowCount();
				for(int i=0;i<xx;i++)
				{
				 Buscar_recepciones.dtm.removeRow(0);
				}
				
				for(int i=0;i<lista.size();i++)
				{
					String vector[]=new String[7];
				vector[0]=lista.get(i).getCOD_RECEP();
				vector[1]=lista.get(i).getCOD_PROD();
				vector[2]=lista.get(i).getCOD_PRO();
				vector[3]=lista.get(i).getFECHA();
				vector[4]=lista.get(i).getHORA();
				vector[5]=lista.get(i).getCOSTO();
				vector[6]=lista.get(i).getCANTIDAD();
				Buscar_recepciones.dtm.addRow(vector);
				carga++;
				Buscar_recepciones.barra_de_progreso.setValue(carga);
				}
				Buscar_recepciones.listax=lista;
			}
			    
			else{
				int xx=Buscar_recepciones.dtm.getRowCount();
				for(int i=0;i<xx;i++)
				{
				 Buscar_recepciones.dtm.removeRow(0);
				}
				new Mensaje().error("No se han encontrado Registros","");
			
			   	
			}
			
			
		}catch(Exception e)
		{
			new Mensaje().error("Error al Buscar las recepciones","Error"+e);
		}
		
	}
	
	
	public void run()
	{
	buscar(texto);	
	}
	
}
