package todo_ganancias;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import administrador.Conexion;
public class Buscador {
	Connection cone;
	public Buscador()
	{
		cone=Conexion.conect;
	}
	String IVA="";
	String Codigo="";
	public BigDecimal Buscar_dia(String fecha)
	{
		BigDecimal TOTALL=new BigDecimal("0");
		BigDecimal xx=new BigDecimal("0");
		BigDecimal total=new BigDecimal("0");
		LinkedList<BigDecimal> lista=new LinkedList<>();
		try{
			Statement stm= cone.createStatement();
			Statement stm1= cone.createStatement();
			ResultSet rs =stm.executeQuery("select  COD_FAC,IVA from facturacion where FECHA='"+fecha+"' and ESTADO='1'");
			while(rs.next())
			{	
				Codigo=rs.getString(1);
				IVA=rs.getString(2);
				ResultSet rs1=stm1.executeQuery("select COSTO,CANTIDAD FROM fac_prod where COD_FACT='"+Codigo+"'");
				while(rs1.next())
				{
			   BigDecimal costox=new BigDecimal("0");
			   BigDecimal costo=new BigDecimal(rs1.getString(1));
			   String c=rs1.getString(2);
			   String vect[]= c.split(":");
			   BigDecimal cantidad=new BigDecimal(vect[0]);
			   costox=costo.multiply(cantidad).setScale(2,RoundingMode.HALF_EVEN);		
	              total=total.add(costox);
				}
				    BigDecimal IVAB=new BigDecimal("0");
				    IVAB=total.multiply(new BigDecimal(IVA)).setScale(2,RoundingMode.HALF_EVEN);
				    IVAB=IVAB.divide(new BigDecimal("100")).setScale(2, RoundingMode.HALF_EVEN);
				    TOTALL=total.add(IVAB);
				    lista.add(TOTALL);  
				   TOTALL=new BigDecimal("0"); 
				   total=new BigDecimal("0");
			}
			for(int i=0;i<lista.size();i++)
			{
				xx=xx.add(lista.get(i));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return xx;
		
	}
	
	public BigDecimal Buscar_mes(String fecha)
	{
		BigDecimal TOTALL=new BigDecimal("0");
		BigDecimal xx=new BigDecimal("0");
		BigDecimal total=new BigDecimal("0");
		LinkedList<BigDecimal> lista=new LinkedList<>();
		try{
			Statement stm= cone.createStatement();
			Statement stm1= cone.createStatement();
			ResultSet rs =stm.executeQuery("select  COD_FAC,IVA from facturacion where FECHA like'%"+fecha+"' and ESTADO='1'");
		
			while(rs.next())
			{	
				Codigo=rs.getString(1);
				IVA=rs.getString(2);
				ResultSet rs1=stm1.executeQuery("select COSTO,CANTIDAD FROM fac_prod where COD_FACT='"+Codigo+"'");
				while(rs1.next())
				{
			   BigDecimal costox=new BigDecimal("0");
			   BigDecimal costo=new BigDecimal(rs1.getString(1));
			   String c=rs1.getString(2);
			   String vect[]= c.split(":");
			   BigDecimal cantidad=new BigDecimal(vect[0]);
			   costox=costo.multiply(cantidad).setScale(2,RoundingMode.HALF_EVEN);		
	              total=total.add(costox);
				}
				    BigDecimal IVAB=new BigDecimal("0");
				    IVAB=total.multiply(new BigDecimal(IVA)).setScale(2,RoundingMode.HALF_EVEN);
				    IVAB=IVAB.divide(new BigDecimal("100")).setScale(2, RoundingMode.HALF_EVEN);
				    TOTALL=total.add(IVAB);
				    lista.add(TOTALL);  
				   TOTALL=new BigDecimal("0"); 
				   total=new BigDecimal("0");
			}
			for(int i=0;i<lista.size();i++)
			{
				xx=xx.add(lista.get(i));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return xx;
		
	}
	
	public String[] ganancias_Invercion()
	{
		String Total[]={"",""};
		
		BigDecimal total_invercion=new BigDecimal("0");
		BigDecimal total_ganancia=new BigDecimal("0");
		try{
			Statement stm= cone.createStatement();
		
			ResultSet rs =stm.executeQuery("select  COSTO_COMPRA,COSTO_VENTA,CANTIDAD from productos");
		
			while(rs.next())
			{	
				BigDecimal xinvercion=new BigDecimal("0").setScale(2, RoundingMode.HALF_EVEN);
				BigDecimal xganancia=new BigDecimal("0").setScale(2, RoundingMode.HALF_EVEN);
				BigDecimal x=new BigDecimal("0").setScale(2, RoundingMode.HALF_EVEN);
				
				BigDecimal xcosto_venta=new BigDecimal(rs.getString(2)).setScale(2, RoundingMode.HALF_EVEN);
				BigDecimal xcosto_cmopra=new BigDecimal(rs.getString(1)).setScale(2, RoundingMode.HALF_EVEN);
				
				String cant[]=rs.getString(3).split(":");
				
				BigDecimal xcantidad=new BigDecimal(cant[0]).setScale(2, RoundingMode.HALF_EVEN);
				xinvercion=xcosto_cmopra.multiply(xcantidad).setScale(2,RoundingMode.HALF_EVEN);
				total_invercion=total_invercion.add(xinvercion).setScale(2,RoundingMode.HALF_EVEN);
				//------------------------------------------------------------------------------
				
				x=xcosto_venta.subtract(xcosto_cmopra).setScale(2,RoundingMode.HALF_EVEN);
				xganancia=x.multiply(xcantidad).setScale(2, RoundingMode.HALF_EVEN);
				
				total_ganancia=total_ganancia.add(xganancia);
			}
			
			
			Total[0]=total_invercion.toString();
			Total[1]=total_ganancia.toString();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return Total;
		
	}
	
}
