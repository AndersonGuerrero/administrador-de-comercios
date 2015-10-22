package todo_Facturas;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import administrador.Conexion;

public class Guardar_Factura {

Connection conex;
	
public static String cod="";
	public boolean Guardar_Factura_(Factura F)
	{
		cod="";
		boolean x = false;
		try{
			conex=Conexion.conect;	
			Statement stm= conex.createStatement();
			x=stm.execute("insert into facturacion(CLIENTE,FECHA,HORA,IVA,USUARIO,ESTADO) VALUES('"+F.getCliente()+"','"+F.getFecha()+"','"+F.getHora()+"','"+F.getIva()+"','"+F.getUsuario()+"','"+F.getEstado()+"')");
			if(x==false)
			{
				
				ResultSet rs1=	stm.executeQuery("select MAX(COD_FAC) From facturacion");
				rs1.next();
				String Codigo=rs1.getString(1);
				cod=Codigo;
				for(int i=0;i<F.getPro_fac_sise();i++)
				{
					 ResultSet rsx=stm.executeQuery("select CANTIDAD from productos where CODIGO='"+F.getPro_fac(i)[0]+"'");
					rsx.next();

					String txt1=rsx.getString(1);
					
				    String txt2[]=txt1.split(":"); 
					
				    BigDecimal ant=new BigDecimal(txt2[0]);
				    
				    String txt3[]=F.getPro_fac(i)[1].split(" "); 
				    
				    BigDecimal sig=new BigDecimal(txt3[0]);
				    
					
					sig=ant.subtract(sig);
				    
		
					stm.executeUpdate("update productos set CANTIDAD='"+sig+":"+txt2[1]+"'  where CODIGO='"+F.getPro_fac(i)[0]+"'");
					
					
					
					stm.execute("insert into fac_prod(COD_FACT,COD_PRO,CANTIDAD,COSTO,estado) values('"+Codigo+"','"+F.getPro_fac(i)[0]+"','"+txt3[0]+":"+txt3[1]+"','"+F.getPro_fac(i)[2]+"','1')");}
				
				
				
				
				for(int i=0;i<F.getTipo_pago_sise();i++)
				{stm.execute("insert into tipo_pago(COD_FACT,TIPO_PAGO,CANTIDAD) values('"+Codigo+"','"+F.getTipo_pago(i)[0]+"','"+F.getTipo_pago(i)[1]+"')");}
				
				
			}
			
			return x;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return x;
		
		
		
	}
	
	
	
	
	public void cancelar_factura(Factura f)
    {
	
	
		
		conex=Conexion.conect;
		
		try{
			Statement stm=conex.createStatement();	
			
		    boolean x=stm.execute("update  facturacion set ESTADO='0' where COD_FAC="+f.getCodigo()+"");

			if(x==false)
			{
				for(int i=0;i<f.getPro_fac_sise();i++)
				{
					
					
					
					
					ResultSet rs= stm.executeQuery("select CANTIDAD from productos where CODIGO='"+f.getPro_fac(i)[0]+"'");
					rs.next();
					String vector_cant_ant[]=rs.getString(1).split(":");
					
					String vector_cant_fact[]=f.getPro_fac(i)[1].split(":");
				
					BigDecimal cant1=new BigDecimal(vector_cant_ant[0]);
					BigDecimal cant2=new BigDecimal(vector_cant_fact[0]);
					
					cant1=cant1.add(cant2);
					
					if(f.getPro_fac(i)[3].equals("1")){stm.execute("update productos set CANTIDAD='"+cant1+":"+vector_cant_ant[1]+"'  where CODIGO='"+f.getPro_fac(i)[0]+"'");}
				}
				
				for(int i=0;i<f.getPro_fac_sise();i++)
				{
				stm.execute("update fac_prod set estado='0'  where COD_PRO='"+f.getPro_fac(i)[0]+"'  and COD_FACT="+f.getCodigo()+"");
				}
				
				
				
			}
	    }catch(Exception e){e.printStackTrace();}
    }

	
	
	
	public boolean cancelar_producto(String cant_ant_prod_select,String  codigo_producto,String canat_a_sumar,String Cod_fact,boolean delete,Boolean cancelar_fact)
	{
		
conex=Conexion.conect;
		
		try{
			Statement stm=conex.createStatement();	

					ResultSet rs= stm.executeQuery("select CANTIDAD from productos where CODIGO='"+codigo_producto+"'");
					rs.next();
					
					String vector_cant_ant[]=rs.getString(1).split(":");
				
					BigDecimal cant1=new BigDecimal(vector_cant_ant[0]);
					BigDecimal cant2=new BigDecimal(canat_a_sumar);
					
					cant1=cant1.add(cant2);

					
					boolean x=stm.execute("update productos set CANTIDAD='"+cant1+":"+vector_cant_ant[1]+"'  where CODIGO='"+codigo_producto+"'");
					
					if(cancelar_fact)
					{
						stm.execute("update facturacion set estado='0'  where COD_FAC="+Cod_fact+"");
					}
					
					if(delete){stm.execute("update fac_prod set estado='0'  where COD_FACT='"+Cod_fact+"'  and COD_PRO='"+codigo_producto+"'");}
					else{
						BigDecimal can_ant=new BigDecimal(cant_ant_prod_select);
						BigDecimal can_sum=new BigDecimal(canat_a_sumar);
						can_ant=can_ant.subtract(can_sum);
					    stm.execute("update fac_prod set CANTIDAD='"+can_ant+":"+vector_cant_ant[1]+"'  where COD_FACT='"+Cod_fact+"'  and  COD_PRO ='"+codigo_producto+"'");}
					
					
					
				return x;
	    }catch(Exception e){e.printStackTrace();return true;}
		
	
		
	}
}
