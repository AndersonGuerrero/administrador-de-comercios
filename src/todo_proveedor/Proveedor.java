package todo_proveedor;

import java.util.LinkedList;

public class Proveedor {

	private String id;
	private String nombre;
	private String direccion;
	private String correro;
	private String codigo_postal;
	private LinkedList<String> telefono;
	private String fax;
	private String nombre_vendedor;
	
	public Proveedor()
	{
		this.id="";
		this.nombre="";
		this.direccion="";
		this.correro="";
		this.codigo_postal="";
		this.telefono=new LinkedList<>();
		this.fax="";
		this.nombre_vendedor="";
	}

	public String getId() {
		
		return id;
	}

	public void setId(String id) {
		this.id = id.toUpperCase();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre.toUpperCase();
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion.toUpperCase();
	}

	public String getCorrero() {
		return correro;
	}

	public void setCorrero(String correro) {
		this.correro = correro;
	}

	public String getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(String codigo_postal) {
		this.codigo_postal = codigo_postal;
	}

	public String getTelefono(int p) {
		return telefono.get(p);
	}
	
	public int getTelefono_size() {
		return telefono.size();
	}

	public void setTelefono(String telefono) {
		this.telefono.add(telefono);
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getNombre_vendedor() {
		return nombre_vendedor;
	}

	public void setNombre_vendedor(String nombre_vendedor) {
		this.nombre_vendedor = nombre_vendedor.toUpperCase();
	}


}
