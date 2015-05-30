package todo_producto;


import java.util.LinkedList;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class Conexion_jasperreport implements JRDataSource {

	
	LinkedList<String[]> lista=new LinkedList<String[]>();
	int cont=-1,cant=0;
	
	public Object getFieldValue(JRField jrField) throws JRException {
		
		Object valor = null;  
		
		
	    if("codigo".equals(jrField.getName())) 
	    { 
	    	
	        valor = lista.get(cont)[0];
	        
	    } 
	    else if("nombre".equals(jrField.getName())) 
	    { 
	    	valor = lista.get(cont)[1];
	    } 
	    else if("marca".equals(jrField.getName())) 
	    { 
	    	valor = lista.get(cont)[2];
	    } 
	    else if("modelo".equals(jrField.getName())) 
	    { 
	    	valor = lista.get(cont)[3];
	    } 
	    else if("descripcion".equals(jrField.getName())) 
	    { 
	    	valor = lista.get(cont)[4];
	    }
	    else if("ubicacion".equals(jrField.getName())) 
	    { 
	    	valor = lista.get(cont)[5];
	    }
	    else if("cantidad".equals(jrField.getName())) 
	    { 
	    	valor = lista.get(cont)[6];
	    }
	 
	
	    return valor; 
	}

	
	public boolean next() throws JRException {
		
		return ++cont<cant;
	}

	
	
	public void addlista(LinkedList<String[]> listax)
	{
	 
	    lista=listax;
	   cant=lista.size();
	}
	
	
}
