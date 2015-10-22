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

public class Imprimir_presupuesto extends Thread {

	BigDecimal subtotal,total,iva;
	Connection cenect;
	 String cod="";
     Factura f;
     Cliente cli;
	public Imprimir_presupuesto(Factura F,BigDecimal total1, BigDecimal subtotal1)
	{
		total=total1;
		f=F;
		subtotal=subtotal1;
		iva=subtotal.multiply(new BigDecimal(f.getIva()));
        iva=iva.divide(new BigDecimal("100")).setScale(2,RoundingMode.HALF_EVEN);
		this.start();
	}
	
	
	public void run()
	{
		cenect=Conexion.conect;  
	try{
	  				

     Sourse_x_factura sourse= new Sourse_x_factura();
     //------------------------------------------------------------------------------------------------------------
		cenect=Conexion.conect;
		Statement stm11= cenect.createStatement();
		ResultSet rs11=stm11.executeQuery("select NOMBRE,DIRECCION from clientes where CEDULA='"+f.getCliente()+"'");
		rs11.next();
		cli=new Cliente();
		cli.setDireccion(rs11.getString(2));
		cli.setNombre(rs11.getString(1));
		rs11.close();
		stm11.close();
 	 //----------------------------------------------------------------------------------------------------------------
     
     
	@SuppressWarnings("deprecation")
	JasperReport reporte = (JasperReport) JRLoader.loadObject("Plantillas" + Inicio.url_sistema + "presupuesto.jasper");  
	
    Map<String, Object> parametros=new HashMap<String,Object>();
    parametros.put("nombre_cliente",cli.getNombre());
    parametros.put("rif_cliente",f.getCliente());
    parametros.put("direccion_cliente",cli.getDireccion());
    parametros.put("direccion",Inicio.c.getDireccion());
    parametros.put("nombre_empresa",Inicio.c.getNombre_empresa());
    parametros.put("rif_empresa",Inicio.c.getRif());
    parametros.put("usuario",f.getUsuario());
    parametros.put("factura","presupuesto");
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
    parametros.put("titulo","PRESUPUESTO");
  
    
	 parametros.put("vuelto","Bsf "+"0.00");
	
	 parametros.put("tipo_pago","Tipo de pago:\n"+f.getTipo_pago(0)[0]);
	 
	 sourse.agregar(f);
	 
    
     JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, sourse);  

     JRExporter exporter = new JRPdfExporter();  
     exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint); 
     exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("Reportes" + Inicio.url_sistema + "presupuesto.pdf")); 
     exporter.exportReport(); 
     
		File archivo=new File("Reportes" + Inicio.url_sistema + "presupuesto.pdf");
		Desktop.getDesktop().open(archivo);
	}catch(Exception e){
		e.printStackTrace();
		new Mensaje().error("Error En la Impresion el archivo esta abierto", "Error");}}
	
	
}
