package todo_Facturas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.Statement;

import funciones.Mensaje;

import administrador.Conexion;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class Sourse_x_factura implements JRDataSource{

	int cant=-1;
	 BigDecimal costo,cantidad;
	Factura F;
	String subtotal;
	public Object getFieldValue(JRField fielt) throws JRException {
	
		Object dato = null;
	
		if(fielt.getName().equals("codigo"))
		{
			dato=F.getPro_fac(cant)[0];
		}
		
		else if(fielt.getName().equals("descripcion"))
		{
			try{
			Statement stm= Conexion.conect.createStatement();
			ResultSet rs=stm.executeQuery("select DESCRIPCION from productos WHERE CODIGO='"+F.getPro_fac(cant)[0]+"'");
			rs.next();
			dato=rs.getString(1);
			rs.close();
			}catch(Exception e){e.printStackTrace();new Mensaje().error("No se pudo Mostrar las descripcion del producto","Error");}
			
		}
		
		else if(fielt.getName().equals("cantidad"))
		{	
			String cantString[]=F.getPro_fac(cant)[1].split(":");
			cantidad=new BigDecimal(cantString[0]);
			dato=cantString[0];
		}
		else if(fielt.getName().equals("costo"))
		{	
			costo=new BigDecimal(F.getPro_fac(cant)[2]);
			dato=F.getPro_fac(cant)[2];
			
		}
		if(fielt.getName().equals("subtotal_tabla"))
		{
			BigDecimal subBigDecimal=new BigDecimal("0");
			subBigDecimal=costo.multiply(cantidad).setScale(2,RoundingMode.HALF_EVEN);
			dato=""+subBigDecimal;
		}
		
		return dato;
	}


	public boolean next() throws JRException {

		return ++cant<F.getPro_fac_sise();
	}

	
	public void agregar(Factura f)
	{F=f;
	
	costo=new BigDecimal("0");
	cantidad=new BigDecimal("0");
	
	}
	
}
