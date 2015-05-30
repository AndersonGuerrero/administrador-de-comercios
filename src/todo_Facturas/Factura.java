package todo_Facturas;

import java.util.LinkedList;

public class Factura {

	private String codigo;
	private String cliente;
	private String fecha;
	private String hora;
	private String iva;
	private String usuario;
	private String estado;
	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	private LinkedList<String[]> tipo_pago;
	private LinkedList<String[]> Pro_fac;
	
	
	
	public String getCliente() {
		return cliente;
	}



	public void setCliente(String cliente) {
		this.cliente = cliente;
	}



	public String getFecha() {
		return fecha;
	}



	public void setFecha(String fecha) {
		this.fecha = fecha;
	}



	public String getHora() {
		return hora;
	}



	public void setHora(String hora) {
		this.hora = hora;
	}



	public String getIva() {
		return iva;
	}



	public void setIva(String iva) {
		this.iva = iva;
	}



	public String[] getPro_fac(int p) {
		return Pro_fac.get(p);
	}

public int getPro_fac_sise()
    {
	return Pro_fac.size();
	}

	public void setPro_fac(String[] vector) {
		Pro_fac.add(vector);
	}



	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public Factura()
	{
		cliente="";
		fecha="";
		hora="";
		iva="";
		codigo="";
		usuario="";
		tipo_pago=new LinkedList<>();
		Pro_fac=new LinkedList<>();
	}



	public String[] getTipo_pago(int p) {
		return tipo_pago.get(p);
	}

	public int getTipo_pago_sise() {
		return tipo_pago.size();
	}


	public void setTipo_pago(String[] tipo_pago) {
		this.tipo_pago.add(tipo_pago);
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
}
