package administrador;

import javax.swing.*;

import funciones.Mensaje;
import funciones.Registro_user;

public class Inicio {
	
	public static Usuarios users;
	
	public static Confing c;
	static boolean inventario,facturacion,clientes,facturas,proveedores,configuracion;
    public static void main(String[] args) {  
    	
    	decorar(); 
    	c=Conexion.conf;
		users=Conexion.user;
		  
		Conexion com=new Conexion();
		boolean x=com.conectar_access();
   if(x){
		if(com.buscar_usuarios()==null)
		{
          new Registro_user();
		}
		
		if(com.buscar_usuarios()!=null)
		{
			new Loguin(com.buscar_usuarios());
			
		new Mensaje().listo("Bienvenido(a) al Sistema "+users.getXusuario(),"Bienvenida");
		new Interfas_Principal(users.getXusuario(),c.getNombre_empresa(),c.getRif(),c.getIva(),inventario,facturacion,clientes,facturas,proveedores,configuracion);
		}
}
	}
	
	public static void decorar()
	{
		
		SwingUtilities.invokeLater(new Runnable() {
						public void run() {
				try{
					JFrame.setDefaultLookAndFeelDecorated(true);
					JDialog.setDefaultLookAndFeelDecorated(true);
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					
				}catch(Exception e){e.printStackTrace();}
			}
		});
		
		
	}


	
}
