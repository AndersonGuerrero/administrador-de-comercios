package todo_clientes;

public class Cliente {
 private String nombre;
 private String apellido;
 private String rif;
 private String direccion;
	
 public Cliente()
 {
	 this.apellido="";
	 this.nombre="";
	 this.rif="";
	 this.direccion="";
 }

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre.toUpperCase();
}

public String getApellido() {
	return apellido;
}

public void setApellido(String apellido) {
	this.apellido = apellido.toUpperCase();
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
 
 
	
}
