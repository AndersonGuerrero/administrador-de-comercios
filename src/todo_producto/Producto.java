package todo_producto;

public class Producto {

	private String codigo;
	private String nombre;
	private String marca;
	private String modelo;
	private String descripcion;
	private String costo_compra;
	private String costo_venta;
	private String departamento;
	private String cantidad;
	private String cod_proveedor;
	private String fecha;
	
	public Producto()
	{
     codigo="";
	 nombre="";
	 fecha="";
	 marca="";
	 modelo="";
	 descripcion="";
	 costo_compra="";
	 costo_venta="";
	 departamento="";
	 cantidad="";
	 cod_proveedor="";
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo.toUpperCase();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre.toUpperCase();
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca.toUpperCase();
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo.toUpperCase();
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion.toUpperCase();
	}

	public String getCosto_compra() {
		return costo_compra;
	}

	public void setCosto_compra(String costo_compra) {
		this.costo_compra = costo_compra.toUpperCase();
	}

	public String getCosto_venta() {
		return costo_venta;
	}

	public void setCosto_venta(String costo_venta) {
		this.costo_venta = costo_venta.toUpperCase();
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String ubicacion) {
		this.departamento = ubicacion.toUpperCase();
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad.toUpperCase();
	}

	public String getCod_proveedor() {
		return cod_proveedor;
	}

	public void setCod_proveedor(String cod_proveedor) {
		this.cod_proveedor = cod_proveedor.toUpperCase();
	}
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
}
