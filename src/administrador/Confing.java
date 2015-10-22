package administrador;

public class Confing {

	private int cantidad,ubicacion;
	private String correo,nombre_empresa,rif,direccion,telefono1,telefono2,telefono3;
	private String iva;
	
	public Confing()
	{super();}
	
	public Confing(String tl3,String tl2,String tl1,String dir,String riff,String nomb,String corr,int cant,String ivaa,int ubi)
	{
		this.cantidad=cant;
		this.ubicacion=ubi;
		this.iva=ivaa;
		this.correo=corr;
		this.nombre_empresa=nomb;
		this.rif=riff;
		this.direccion=dir;
		this.telefono1=tl1;
		this.telefono2=tl2;
		this.telefono3=tl3;
		
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(int ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getCorrero() {
		return correo;
	}

	public void setCorrero(String correro) {
		this.correo = correro;
	}

	public String getNombre_empresa() {
		return nombre_empresa;
	}

	public void setNombre_empresa(String nombre_empresa) {
		this.nombre_empresa = nombre_empresa.toUpperCase();
	}

	public String getRif() {
		return rif;
	}

	public void setRif(String rif) {
		this.rif = rif.toUpperCase();
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion.toUpperCase();
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getTelefono3() {
		return telefono3;
	}

	public void setTelefono3(String telefono3) {
		this.telefono3 = telefono3;
	}

	public String getIva() {
		return iva;
	}

	public void setIva(String iva) {
		this.iva = iva;
	}
	
	
}
