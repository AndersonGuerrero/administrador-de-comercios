package todo_Facturas;

import java.awt.Desktop;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import todo_clientes.Cliente;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import administrador.Conexion;
import administrador.Inicio;
import funciones.Mensaje;

public class Imprimir_factura extends Thread {

	BigDecimal subtotal,total,vuelto;
	Connection cenect;
	 String cod="";
     Factura f;
     Cliente cli;
	public Imprimir_factura(String codigo)
	{
		cod=codigo;
        this.start();
	}
	
	
	public void run()
	{
		
	subtotal=new BigDecimal("0");
	total=new BigDecimal("0");
		cenect=Conexion.conect;  
	try{
		
		 Statement stm= cenect.createStatement();
		 Statement stm1= cenect.createStatement();
		 Statement stm2= cenect.createStatement();
		 
			ResultSet rs=stm.executeQuery("select *from FACTURACION  where COD_FAC="+cod);
		
		rs.next();

		f=new Factura();
	
		f.setCodigo(rs.getString(1));
		f.setCliente(rs.getString(2));
		f.setEstado(rs.getString(7));
		f.setFecha(rs.getString(3));
		f.setHora(rs.getString(4));
		f.setIva(rs.getString(5));
		f.setUsuario(rs.getString(6));
		
		
		ResultSet rs1=stm1.executeQuery("select *from FAC_PROD  where COD_FACT='"+cod+"'");
		
		while(rs1.next())
		{
			String vectorx[]=new String[3];
			
			vectorx[0]=rs1.getString(2);
			vectorx[1]=rs1.getString(3);
			String cantString[]=vectorx[1].split(":");
			
			BigDecimal cant=new BigDecimal(cantString[0]);
			
			vectorx[2]=rs1.getString(4);
			
			BigDecimal costo=new BigDecimal(vectorx[2]);
			costo=costo.multiply(cant).setScale(2,RoundingMode.HALF_EVEN);
			subtotal=subtotal.add(costo);
			
			f.setPro_fac(vectorx);
		}
		
		
		BigDecimal iva =new BigDecimal(f.getIva());
		
		iva=subtotal.multiply(iva).setScale(2,RoundingMode.HALF_EVEN);
		
	    iva=iva.divide(new BigDecimal("100")).setScale(2, RoundingMode.HALF_EVEN);
	
	    total=iva.add(subtotal);
				
		ResultSet rs2=stm2.executeQuery("select *from TIPO_PAGO  where COD_FACT='"+cod+"'");
		
		while(rs2.next())
		{
			String vectorx[]=new String[2];
			vectorx[0]=rs2.getString(2);
			vectorx[1]=rs2.getString(3);
			
			f.setTipo_pago(vectorx);
		}
		
		rs2.close();
		rs1.close();
      rs.close();
      stm.close(); 
    
     

     Sourse_x_factura sourse= new Sourse_x_factura();
    
    

     
     
     

 	try{
		cenect=Conexion.conect;
		Statement stm11= cenect.createStatement();
		
		ResultSet rs11=stm11.executeQuery("select NOMBRE,DIRECCION from CLIENTES where CEDULA='"+f.getCliente()+"'");
		rs11.next();
		cli=new Cliente();
		cli.setDireccion(rs11.getString(2));
		cli.setNombre(rs11.getString(1));
		rs11.close();
		stm11.close();
	}catch(Exception e){}
     
 	 
     
     
	@SuppressWarnings("deprecation")
	JasperReport reporte = (JasperReport) JRLoader.loadObject("Plantillas\\Factura.jasper");  
	
    Map<String, Object> parametros=new HashMap<String,Object>();
    parametros.put("nombre_cliente",cli.getNombre());
    parametros.put("rif_cliente",f.getCliente());
    parametros.put("direccion_cliente",cli.getDireccion());
    parametros.put("direccion",Inicio.c.getDireccion());
    parametros.put("nombre_empresa",Inicio.c.getNombre_empresa());
    parametros.put("rif_empresa",Inicio.c.getRif());
    parametros.put("usuario",f.getUsuario());
    parametros.put("factura",f.getCodigo());
    parametros.put("fecha",f.getFecha());
    parametros.put("hora",f.getHora());
    parametros.put("iva",Inicio.c.getIva());
    parametros.put("telefono1",Inicio.c.getTelefono1());
    parametros.put("telefono2",Inicio.c.getTelefono2());
    parametros.put("telefono3",Inicio.c.getTelefono3());
    parametros.put("correo",Inicio.c.getCorrero());
    parametros.put("sub_total","Bsf "+subtotal);
    parametros.put("total","Bsf "+total);
    parametros.put("iva_bs","Bsf "+iva);
    parametros.put("titulo","FACTURA");
    
    vuelto=new BigDecimal("0");
    String x="";
	for(int i=0;i<f.getTipo_pago_sise();i++)
	{
		x+=f.getTipo_pago(i)[0]+"\t      Bsf "+f.getTipo_pago(i)[1]+"\n";
	vuelto=vuelto.add(new BigDecimal(f.getTipo_pago(i)[1])).setScale(2,RoundingMode.HALF_EVEN);
	}
	vuelto=vuelto.subtract(total).setScale(2,RoundingMode.HALF_EVEN);
    
	 parametros.put("vuelto","Bsf "+vuelto);
	
	 parametros.put("tipo_pago",x);
	 
	 sourse.agregar(f);
	 
    
     JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, sourse);  

     JRExporter exporter = new JRPdfExporter();  
     exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint); 
     exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("Reportes\\Factura.pdf")); 
     exporter.exportReport(); 
 
     
     
		File archivo=new File("Reportes\\Factura.pdf");
		Desktop.getDesktop().open(archivo);
	}catch(Exception e){
		e.printStackTrace();
		new Mensaje().error("Error En la Impresion el archivo esta abierto", "Error");}}
	
	
}
