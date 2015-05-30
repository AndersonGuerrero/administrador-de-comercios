package Todo_recepciones;

import java.math.BigDecimal;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class SourseData implements JRDataSource{

	 BigDecimal x=new BigDecimal("0");
	Recepciones re;
	int cant=0;
	String x2="";
	private int indice = -1;
	
	public Object getFieldValue(JRField jrField) throws JRException {
			
		Object valor = null;  

	    if("CodigoRecepcion".equals(jrField.getName())) 
	    { 
	    	
	        valor = re.getCOD_RECEP();
	    } 
	    if("CodigoProveedor".equals(jrField.getName())) 
	    { 
	        valor = re.getCOD_PRO();
	    } 
	    else if("CodigoProducto".equals(jrField.getName())) 
	    { 
	        valor = re.getCOD_PROD();
	    } 
	    else if("Fecha".equals(jrField.getName())) 
	    { 
	        valor = re.getFECHA(); 
	    } 
	    else if("Hora".equals(jrField.getName())) 
	    { 
	        valor = re.getHORA(); 
	    }
	    else if("Cantidad".equals(jrField.getName())) 
	    { 
	        valor = re.getCANTIDAD(); 
	    }
	    else if("Costo".equals(jrField.getName())) 
	    { 
	        valor = "BsF "+re.getCOSTO(); 
	    }
	    else if("Total".equals(jrField.getName())) 
	    { 
	        valor = "BsF "+x; 
	    }
	 
	    return valor; 
	}

	@Override
	public boolean next() throws JRException {
	
		return ++indice == cant;
	}
	
	public void addParticipante(Recepciones participante,BigDecimal x2)
	{
	   re=participante;

	    x=x2;
	    
	}

}
