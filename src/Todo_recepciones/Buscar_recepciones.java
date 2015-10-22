package Todo_recepciones;

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

import funciones.Fondo;
import funciones.Mensaje;
import funciones.Pintar_boton;
import funciones.Pintar_filas;
import funciones.Pintar_txt;

@SuppressWarnings("serial")
public class Buscar_recepciones extends JDialog implements ActionListener,KeyListener{

	static int eliminacion=0;
    public static JProgressBar barra_de_progreso;
	JTextField txt_buscar;
	public static LinkedList<Recepciones> listax=new LinkedList<>();
	public static JButton buscar,imprimir;
	
	JScrollPane barra;

	//-------------------------------------------------------------
	public static JTable tabla;
	
	public	static String[] columnas={"Nu_recep","Cod Producto","Cod Proveedor","Fecha","Hora","Total"};
	
	public	static String[][]filas={{""}};
	
	public static DefaultTableModel dtm=new DefaultTableModel(filas,columnas){
	
	public boolean isCellEditable(int row ,int column){return false;}
		
	};
	
	
	public Buscar_recepciones()
	{
        setLayout(null);
		
        barra_de_progreso=new JProgressBar();
        barra_de_progreso.setBounds(6,485,583,20);
        
		tabla=new JTable(dtm);
		
		barra=new JScrollPane(tabla);
		barra.setBounds(8,50,578,380);
		
		txt_buscar=new JTextField();
		new Pintar_txt(txt_buscar);
		txt_buscar.setBounds(150,15,200,30);
		
		buscar=new JButton("Buscar");
		new Pintar_boton(buscar);
		buscar.setBounds(360, 15, 100, 30);
		
		
		imprimir=new JButton("Imprimir");
		new Pintar_boton(imprimir);
		imprimir.setBounds(220,440,150,50);
		
		int xx=dtm.getRowCount();
		for(int i=0;i<xx;i++)
		{
		dtm.removeRow(0);
		}
		
		new Pintar_filas(tabla);
		add(txt_buscar);
		add(buscar);
		
		add(barra);
		
		add(imprimir);
		add(barra_de_progreso);
		setResizable(false);
		setTitle("Buscador Y editor de Resepciones");
		setSize(600,530);
		imprimir.addActionListener(this);
		buscar.addActionListener(this);
		txt_buscar.addKeyListener(this);
		add(new Fondo(getWidth(), getHeight()));
		setModal(true);
		setLocationRelativeTo(this);
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent r) {
	
		if(r.getSource().equals(buscar))
		{
			Buscar();
		}
		else
			if(r.getSource().equals(imprimir))
			{
				if(tabla.getSelectedRow()>=0){
				new Imprimir_recepciones(tabla.getValueAt(tabla.getSelectedRow(), 0).toString());}
				else{new Mensaje().error("Debe Selecionar un Registro a Imprimir", "Imprimir");}
			}
		
	}
	
	public void Buscar()
	{
		if(txt_buscar.getText().length()>=1)
		{
			
			new Procesos_recepciones(txt_buscar.getText());
			
			
		}else{new Procesos_recepciones(txt_buscar.getText());}
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		
		if(arg0.getSource().equals(txt_buscar))
		{
			if(arg0.getKeyCode()==Event.ENTER)
			{Buscar();}
		}
		
	}
	public void keyReleased(KeyEvent arg0) {
		
	}
	public void keyTyped(KeyEvent arg0) {
		
	}
	
}
