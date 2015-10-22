package administrador;

public class Usuarios {

	 private String  xusuario;
	private String xclave;
	private String xclaveconfg;
	
public String getXclaveconfg() {
		return xclaveconfg;
	}

	public void setXclaveconfg(String xclaveconfg) {
		this.xclaveconfg = xclaveconfg;
	}

public	Usuarios()
{
	this.xclave="";
	this.xusuario="";
}

public String getXusuario() {
	return xusuario;
}

public void setXusuario(String xusuario) {
	this.xusuario = xusuario;
}

public String getXclave() {
	return xclave;
}

public void setXclave(String xclave) {
	this.xclave = xclave;
}



}
