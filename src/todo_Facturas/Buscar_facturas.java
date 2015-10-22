package todo_Facturas;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import administrador.Inicio;


import funciones.Fondo;
import funciones.Mensaje;
import funciones.Pintar_boton;
import funciones.Pintar_filas;
import funciones.Pintar_txt;

@SuppressWarnings("serial")
public class Buscar_facturas extends JDialog implements ActionListener,KeyListener {

	JTextField txt_buscar;
	
	JButton buscar,ver;
	public static JProgressBar barra_progreso;
	JScrollPane barra;

	//-------------------------------------------------------------
	public static JTable tabla;
	public static LinkedList<Factura> lista_principal=new LinkedList<>();
	static String[] columnas={"Codigo","Cliente","Usuario","Fecha","Hora"};
	
	static String[][]filas={{""}};
	
	static DefaultTableModel dtm=new DefaultTableModel(filas,columnas){
	
	public boolean isCellEditable(int row ,int column){return false;}
		
	};
	
	public Buscar_facturas()
	{
     setLayout(null);
		
     barra_progreso=new JProgressBar();
     barra_progreso.setBounds(6,505,582,20);
     
		tabla=new JTable(dtm);
		
		barra=new JScrollPane(tabla);
		barra.setBounds(8,50,578,400);
		
		txt_buscar=new JTextField();
		new Pintar_txt(txt_buscar);
		txt_buscar.setBounds(150,15,200,30);
		
		buscar=new JButton("Buscar");
		new Pintar_boton(buscar);
		buscar.setBounds(360, 15, 100, 30);
		

		
		ver=new JButton("Ver");
		new Pintar_boton(ver);
		ver.setBounds(250,450,100,50);
		
		int x2=dtm.getRowCount();
		for(int j=0;j<x2;j++)
		{
		dtm.removeRow(0);
		}
		
		new Pintar_filas(tabla);
		
		add(txt_buscar);
		add(buscar);
		
		add(barra);
		
		add(ver);
		add(barra_progreso);
		setResizable(false);
		
		setTitle("Buscador de facturas");
		buscar.addActionListener(this);
		txt_buscar.addKeyListener(this);
		setSize(600,550);
		add(new Fondo(getWidth(),getHeight()));
		setModal(true);
		
		setLocationRelativeTo(this);
		ver.addActionListener(this);
		setVisible(true);
	}

	
	public void actionPerformed(ActionEvent g) {
		
		if(g.getSource().equals(ver))
		{
			if(tabla.getSelectedRow()>=0){
			new Ver_factura(Inicio.c,lista_principal,tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
			Buscar();
			
			    }else{new Mensaje().error("Debe seleccionar un registro de la lista","Error");}
		}
		else
			if(g.getSource().equals(buscar))
			{
				Buscar();
			}
	}
	
	
	public void Buscar()
	{
		if(txt_buscar.getText().length()>=1)
		{
			new Proceso_buscar_factura(txt_buscar.getText());
		}
		else
		{new Mensaje().error("Introduzca Valores a buscar","Introduzca Valores");}
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getSource().equals(txt_buscar))
		{
			if(arg0.getKeyCode()==Event.ENTER)
			{
				Buscar();
			}
		}
		
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
