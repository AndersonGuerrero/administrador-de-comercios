package todo_clientes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import funciones.Enfocar;
import funciones.Fondo;
import funciones.Mensaje;
import funciones.Pintar_boton;
import funciones.Pintar_label;
import funciones.Pintar_txt;

@SuppressWarnings("serial")
public class Nuevo_cliente extends JDialog implements KeyListener,ActionListener {
	JButton guardar,limpiar;
    public static JTextField nombre,apellido,cedula;
	JLabel nombrel,apellidol,cedulal,direccionl;
	JTextArea direccion;
	JScrollPane barra;
	Mensaje msj;
	Fondo fondo;
	
	boolean cerrarx;
	public Nuevo_cliente(String rif,boolean cerrar) {
		setLayout(null);
		cerrarx=cerrar;
		
		fondo=new Fondo(0, 0);
		fondo.setBounds(5,0,320,232);
		
		  direccionl=new JLabel("Direccion:");
		  direccionl.setBounds(10,120,80,30);
		  
		direccion=new JTextArea();
		
		barra=new JScrollPane(direccion);
		barra.setBounds(140,120,180,50);
	    
		
		guardar=new JButton("Guardar");
		guardar.setBounds(20,190,100,30);
	
		
		limpiar=new JButton("Limpiar Todo");
		limpiar.setBounds(160,190,150,30);
		
		nombrel= new JLabel("Nombre o Cliente:");
		nombrel.setBounds(10,20,100,20);
		
		nombre= new JTextField(30);
		nombre.setBounds(140,20,180,30);
		
		
     	apellidol= new JLabel("Apellido (Opcional):");
		apellidol.setBounds(10,50,120,20);
		
		apellido= new JTextField(30);
		apellido.setBounds(140,50,180,30);
		
	
		cedulal= new JLabel("Cedula o Rif:");
		cedulal.setBounds(10,80,100,20);
		
		cedula= new JTextField(rif);
		cedula.setBounds(140,80,180,30);
		
		new Pintar_boton(guardar);
		new Pintar_boton(limpiar);
		new Pintar_txt(apellido);
		new Pintar_txt(cedula);
		new Pintar_txt(nombre);
		new Pintar_label(apellidol);
		new Pintar_label(cedulal);
		new Pintar_label(direccionl);
		new Pintar_label(nombrel);
		
		
		add(nombre);
		add(nombrel);
		add(apellido);
		add(apellidol);
		add(cedula);
		add(cedulal);
		add(guardar);
		add(limpiar);
		add(barra);
		add(direccionl);
		add(fondo);
		setResizable(false);
		setSize(336,260);
		setLocationRelativeTo(this);
		setModal(true);
		setTitle("Nuevo Cliente");
		cedula.addKeyListener(this);
		nombre.addKeyListener(this);
		apellido.addKeyListener(this);
		limpiar.addActionListener(this);
		guardar.addActionListener(this);
		direccion.addKeyListener(this);
		setVisible(true);
		
		
		
	}

	public void keyPressed(KeyEvent e) {

		
		if(e.getSource().equals(cedula))
		{
			if(e.getKeyCode()==KeyEvent.VK_ENTER)
			{
				new Enfocar(direccion);
			}
		}
		
		if(e.getSource().equals(apellido))
		{
			if(e.getKeyCode()==KeyEvent.VK_ENTER)
			{
				new Enfocar(cedula);
			}
		}
		
		
		if(e.getSource().equals(nombre))
		{
			if(e.getKeyCode()==KeyEvent.VK_ENTER)
			{
				new Enfocar(apellido);
				
			}
		}
		
		
	}

	public void keyReleased(KeyEvent arg0) {
	
		
	}

	public void keyTyped(KeyEvent e) {
		
		if(e.getSource().equals(nombre)){
		if(nombre.getText().length()>=30){ e.consume();}
		}
		
		if(e.getSource().equals(apellido)){
			if(apellido.getText().length()>=30){ e.consume();}
			}
		
		if(e.getSource().equals(nombre) || e.getSource().equals(apellido)){
			
			
			
			char ar = e.getKeyChar();
		  
			if((ar<'a' || ar>'z')&& (ar<'A' || ar>'Z')&& ar!=KeyEvent.VK_SPACE && ar !='á'           
				    && ar !='é'            
				    && ar !='í'            
				    && ar !='ó'           
				    && ar !='ú'   
				    && ar !='Á'           
				    && ar !='É'            
				    && ar !='Í'            
				    && ar !='Ó'           
				    && ar !='Ú') {e.consume();}
			
		}
		
		
		if(e.getSource().equals(cedula)){
			 
			if(cedula.getText().length()>=30){ e.consume();}
		char car = e.getKeyChar();
		
		if((car<'0' || car>'9')          
			    && car !='.'
			    && car !='V'
			    && car !='v'
			    && car!='j'
			    && car!='J'
			    && car !='-'
			) {e.consume();}}
		if(e.getSource().equals(direccion)){
			
		}
		
	}


	public void actionPerformed(ActionEvent a) {
	
		if(a.getSource().equals(limpiar)){
			cedula.setText("");
			nombre.setText("");
			apellido.setText("");
			direccion.setText("");
			new Enfocar(nombre);
		}
		else 
			if(a.getSource().equals(guardar))
			{
				if(nombre.getText().equals("") || cedula.getText().equals("") || direccion.getText().equals(""))
				{
					if(nombre.getText().equals(""))
					{new Enfocar(nombre);
					new Mensaje().error("Introduzca el nombre del cliente","Introduzca lo requerido");
					}
					else
						if(cedula.getText().equals("") || cedula.getText().length()<8)
						{
						if(cedula.getText().equals("")){new Mensaje().error("Introduzca el Rif del cliente","Introduzca lo requerido");}
						else
						if(cedula.getText().length()<8){new Mensaje().error("Introduzca un Rif valido","Introduzca lo requerido");}
						
						new Enfocar(cedula);
						}
						else
					if(direccion.getText().equals(""))
					{new Enfocar(direccion); 
					new Mensaje().error("Introduzca la direccion del cliente","Introduzca lo requerido");
					}
				}
				else{
					
			Cliente	C= new Cliente();
			C.setNombre(nombre.getText().toUpperCase());
			C.setApellido(apellido.getText().toUpperCase());
			C.setDireccion(direccion.getText().toUpperCase());
            C.setRif(cedula.getText().toUpperCase());	
            
		      boolean x= new Conexion_clientes().Nuevo(C);
		    if(x){
		    new Mensaje().listo(C.getNombre()+" Fue Registrado(a) Exitosamente..", "Registrado Con Exito..");
		    nombre.setText("");
		    apellido.setText("");
		    cedula.setText("");
		    direccion.setText("");
		    new Enfocar(nombre);
		    if(cerrarx)
		    {
		    	dispose();
		    }
		    }
				}
			}
	}
	
	
}
