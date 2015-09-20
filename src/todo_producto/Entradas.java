package todo_producto;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import funciones.Enfocar;
import funciones.Fondo;
import funciones.Mensaje;
import funciones.Pintar_label;
import javax.swing.JProgressBar;

import java.awt.Color;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.Thread.State;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class Entradas extends JDialog implements ActionListener {

	private final Fondo panel;
	public static JTextField txt_buscar;
	public static JTextField Codigo;
	public static JTextField cant_exis;
	public static JTextField cant_entra;
	private  JButton Buscar;
	public static JTextArea descripcion;
	public static JButton agregar;
	JScrollPane barra;
	public static LinkedList<Producto> lista;
	Proceso_buscar_productos_entrada proceso;
	public static JProgressBar barra_progreso;
    public static JTable tabla;
	String x[];
	public static String[] columnas={"Codigo","Nombre","Descripcion","Marca","Modelo","Ubicacion"};
	
	 public static String[][]filas={{""}};
	
	public static DefaultTableModel dtm=new DefaultTableModel(filas,columnas){
	
	public boolean isCellEditable(int row ,int column){return false;}
		
	};

	/**
	 * Create the dialog.
	 */
	public Entradas() {
		proceso=new Proceso_buscar_productos_entrada();
		setTitle("Nueva entrada");
		setSize(678,415);
		setResizable(false);
        setLocationRelativeTo(this);
		panel = new Fondo(526, 372);
		panel.setBounds(10, 0, 652, 387);
		
		
		agregar = new JButton("Agregar");
		agregar.setBounds(368, 319, 249, 30);
		agregar.setToolTipText("Escribe la Cantidad de Productos Comprados para Actualizar el Inventario");
		panel.add(agregar);
		
		tabla=new JTable(dtm);
		barra=new JScrollPane(tabla);
		tabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				if(arg0.getSource().equals(tabla)){
					
					for(int i=0;i<lista.size();i++)
					{
					
				      if(lista.get(i).getCodigo().equals(dtm.getValueAt(tabla.getSelectedRow(), 0).toString()))
				      {
				    	 Codigo.setText(lista.get(i).getCodigo());
				    	
				    	 descripcion.setText(lista.get(i).getDescripcion());
			
				    	 x=lista.get(i).getCantidad().split(":");
				    	 
				    	 
				    	 cant_exis.setText(x[0]+"=>");
				    	 
				    	 if(x[1].equals("UD")){cant_exis.setText(cant_exis.getText()+"Unidad/es");}
				    	 else
				    		 if(x[1].equals("KG")){cant_exis.setText(cant_exis.getText()+"KG");}
				    		     else
				    		    	 if(x[1].equals("LT")){cant_exis.setText(cant_exis.getText()+"Litro/s");}
				    		    	 else
					    		    	 if(x[1].equals("MT")){cant_exis.setText(cant_exis.getText()+"Metro/s");}
					    		    	 else
						    		    	 if(x[1].equals("DC")){cant_exis.setText(cant_exis.getText()+"Docena/s");}
				    	 agregar.setEnabled(true);
				    	 break;
				      }
				 
					}
				new Enfocar(cant_entra);
				}
				
				
			}
		});
		barra.setBounds(8,50,634,169);
		
		getContentPane().setLayout(null);
		panel.setLayout(null);
		
		txt_buscar = new JTextField();
		txt_buscar.setToolTipText("Introduce el nombre, Codigo o descripcion del producto a Buscar");
		txt_buscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent g) {
				
				if(g.getKeyCode()==Event.ENTER){buscarf();}
			}
		});
		txt_buscar.setBounds(166, 11, 204, 30);
		panel.add(txt_buscar);
		txt_buscar.setColumns(10);
		
		 Buscar = new JButton("Buscar");
		Buscar.setBounds(410, 11, 89, 30);
		panel.add(Buscar);
		
		Codigo = new JTextField();
		Codigo.setToolTipText("Codigo del Producto seleccionado el cual se le Incrementara la Cantidad en el Inventario");
		Codigo.setEnabled(false);
		Codigo.setBounds(113, 229, 152, 30);
		panel.add(Codigo);
		Codigo.setColumns(10);
		
		JLabel codigol = new JLabel("Codigo:");
		new Pintar_label(codigol);
		codigol.setBounds(27, 237, 46, 14);
		panel.add(codigol);
		
		descripcion = new JTextArea();
		descripcion.setToolTipText("Descripcion del Producto seleccionado el cual se le Incrementara la Cantidad en el Inventario");
		descripcion.setEditable(false);
		descripcion.setEnabled(false);
		descripcion.setBounds(113, 294, 171, 55);
		panel.add(descripcion);
		
		JLabel descripcionl = new JLabel("Descripcion:");
		new Pintar_label(descripcionl);
		descripcionl.setBounds(27, 299, 76, 14);
		panel.add(descripcionl);
		
		cant_exis = new JTextField();
		cant_exis.setToolTipText("Cantidad Actual Existente en el Inventario");
		cant_exis.setEnabled(false);
		cant_exis.setBounds(469, 229, 158, 30);
		panel.add(cant_exis);
		cant_exis.setColumns(10);
		
		JLabel cant_ex_l = new JLabel("Cantidad Existente:");
		new Pintar_label(cant_ex_l);
		cant_ex_l.setBounds(337, 237, 122, 14);
		panel.add(cant_ex_l);
		
		JLabel cant_ent_l = new JLabel("Cantidad Entrante:");
		new Pintar_label(cant_ent_l);
		cant_ent_l.setBounds(337, 278, 122, 14);
		panel.add(cant_ent_l);
		
		cant_entra = new JTextField();
		cant_entra.setToolTipText("Aqui introduce la cantidad de productos \n--SOLO NUMEROS--");
		cant_entra.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				if((arg0.getKeyChar()< '0' || arg0.getKeyChar()> '9') && arg0.getKeyChar()!='.'  ){arg0.consume();}
			}
		});
		cant_entra.setBounds(469, 270, 158, 30);
		panel.add(cant_entra);
		cant_entra.setColumns(10);
		getContentPane().add(panel);
		
		agregar.setEnabled(false);
		panel.add(barra);
		barra_progreso = new JProgressBar();
		barra_progreso.setToolTipText("xxx");
		barra_progreso.setForeground(new Color(0, 204, 0));
		barra_progreso.setBounds(-16, 373, 681, 14);
	    Buscar.addActionListener(this);
	    agregar.addActionListener(this);
	    setModal(true);
		panel.add(barra_progreso);
		
		int x2=dtm.getRowCount();
		for(int j=0;j<x2;j++)
		{
		dtm.removeRow(0);
		}
		
	}


	public void actionPerformed(ActionEvent a) 
	{
	
		if(a.getSource().equals(Buscar))
		{
			buscarf();
		}
		else if(a.getSource().equals(agregar))
		{
			boolean ent=true;
			String can[]=cant_exis.getText().split("=>");
			BigDecimal can_ex=new BigDecimal(can[0]);
			BigDecimal can_ent=new BigDecimal("0");
			try{
			can_ent=new BigDecimal(cant_entra.getText());
			}catch(Exception e){ent=false;}
			
			if(ent)
			{
			can_ex=can_ex.add(can_ent);
				
				boolean m=new Conexion_productos().actualizar_cant(Codigo.getText(), can_ex+":"+x[1]);
				if(m)
				{
					buscarf();
				}
			}
			else
			{
				 new Mensaje().error("Hubo un Erro en la cantidad. Introduzca cantidades Validas", "Error");
			}
			
		}
		
	}
	
	
	
	public void buscarf()
	{
		
		if(txt_buscar.getText().equals(""))
		{
			new Mensaje().error("Debe Introducir datos para Buscar", "Error al Buscar");
			new Enfocar(txt_buscar);
		}
		
		else
		{
			barra_progreso.setValue(0);
			if(proceso.getState()==State.TIMED_WAITING)
			{
				
			}
			else if(proceso.getState()==State.NEW)
		       {proceso=new Proceso_buscar_productos_entrada(txt_buscar.getText());
				proceso.start();
            new Enfocar(txt_buscar);}
			else if(proceso.getState()==State.TERMINATED){
				proceso=new Proceso_buscar_productos_entrada(txt_buscar.getText());
				proceso.start();
                new Enfocar(txt_buscar);}
		}
		
	}
}
