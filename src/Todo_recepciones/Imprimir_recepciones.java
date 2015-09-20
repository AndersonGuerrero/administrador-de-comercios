package Todo_recepciones;


import java.awt.Desktop;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import funciones.Mensaje;
import administrador.Conexion;
import administrador.Inicio;

public class Imprimir_recepciones extends Thread {
		
	Connection cenect;
	 String cod="";
    Recepciones re;
	public Imprimir_recepciones(String codidgo)
	{cod=codidgo;
         this.start();
	}
	
	
	public void run()
	{
		Buscar_recepciones.imprimir.setEnabled(false);
		Buscar_recepciones.imprimir.setText("Imprimiendo");
		
		cenect=Conexion.conect;  
	try{
		
		 Statement stm= cenect.createStatement();

			ResultSet rs=stm.executeQuery("select *from recepciones where COD_RECEP="+cod);
		
		rs.next();

		re=new Recepciones();
		re.setCOD_RECEP(rs.getString(1));
       re.setCOD_PRO(rs.getString(2));
		re.setCOD_PROD(rs.getString(3));
       re.setFECHA(rs.getString(4));
       re.setHORA(rs.getString(5));
       re.setCOSTO(rs.getString(6));
       re.setCANTIDAD(rs.getString(7));
       rs.close();
       stm.close();
     
       
       String cc[]=re.getCANTIDAD().split(":");
   
       BigDecimal x=new BigDecimal("0");
		 BigDecimal cant=new BigDecimal(cc[0]);
      BigDecimal cost=new BigDecimal(re.getCOSTO());
 
      x=cost.multiply(cant).setScale(2,RoundingMode.HALF_EVEN);
      

      SourseData sourse= new SourseData();
     
      sourse.addParticipante(re,x);

      @SuppressWarnings("deprecation")
	  JasperReport reporte = (JasperReport) JRLoader.loadObject("Plantillas" + Inicio.url_sistema + "Recepciones.jasper");  
      JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, sourse);  

      JRExporter exporter = new JRPdfExporter();  
      exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint); 
      exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("Reportes" + Inicio.url_sistema + "Recepcion.pdf")); 
      exporter.exportReport(); 
  
      
      
		File archivo=new File("Reportes" + Inicio.url_sistema + "Recepcion.pdf");
		Desktop.getDesktop().open(archivo);
		
		Buscar_recepciones.imprimir.setEnabled(true);
		Buscar_recepciones.imprimir.setText("Imprimir");
	}catch(Exception e){
		e.printStackTrace();
		new Mensaje().error("Error En la Impresion el archivo esta abierto", "Error");}
	
	}
	

	}
