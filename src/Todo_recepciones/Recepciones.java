package Todo_recepciones;

public class Recepciones {

	private String COD_RECEP;
	private String COD_PRO;
	private String COD_PROD;
	private String FECHA;
	public String getCANTIDAD() {
		return CANTIDAD;
	}

	public void setCANTIDAD(String cANTIDAD) {
		CANTIDAD = cANTIDAD;
	}

	private String HORA;
	private String COSTO;
	private String CANTIDAD;
	
	

	public Recepciones()
	{
		COD_RECEP="";
		COD_PRO="";
		COD_PROD="";
		FECHA="";
		HORA="";
		COSTO="";
	}

	public String getCOSTO() {
		return COSTO;
	}

	public void setCOSTO(String tOTAL) {
		COSTO = tOTAL;
	}
	
	
	public String getCOD_RECEP() {
		return COD_RECEP.toUpperCase();
	}

	public void setCOD_RECEP(String cOD_RECEP) {
		COD_RECEP = cOD_RECEP.toUpperCase();
	}

	public String getCOD_PRO() {
		return COD_PRO;
	}

	public void setCOD_PRO(String cOD_PRO) {
		COD_PRO = cOD_PRO.toUpperCase();
	}

	public String getCOD_PROD() {
		return COD_PROD;
	}

	public void setCOD_PROD(String cOD_PROD) {
		COD_PROD = cOD_PROD.toUpperCase();
	}

	public String getFECHA() {
		return FECHA;
	}

	public void setFECHA(String fECHA) {
		FECHA = fECHA.toUpperCase();
	}

	public String getHORA() {
		return HORA;
	}

	public void setHORA(String hORA) {
		HORA = hORA.toUpperCase();
	}
}
