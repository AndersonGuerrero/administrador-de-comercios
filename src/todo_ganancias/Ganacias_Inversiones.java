package todo_ganancias;

import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import funciones.Dialogo;
import funciones.Enfocar;
import funciones.Fondo;
import funciones.Pintar_boton;
import funciones.Pintar_label;
import funciones.Pintar_txt;

public class Ganacias_Inversiones implements ActionListener,KeyListener{

	JTabbedPane paneles;
	
	//---------------------------------
	Fondo ganancias_del_dia;
    JTextField dia,mes,a�o;
    JLabel dial,mesl,a�ol,totall;
    String totalString="0.00";
    JButton buscar_dia;
    //--------------------------------
    Fondo ganancias_del_mes;
    JTextField mes_mes,mes_a�o;
    JLabel mes_mesl,mes_a�ol,mes_totall;
    String mes_totalString="0.00";
    JButton mes_buscar;
    //----------------------------------
    
    Fondo ganancias_del_a�o;
    JTextField a�o_a�o;
    JLabel a�o_a�ol,a�o_totall;
    String a�o_totalString="0.00";
    JButton a�o_buscar;
    //------------------------------------------
    
    Fondo ganancias_e_Inverciones_del_inventario;
    JLabel gananciasl,Invercionl,total_inventariol;
    String totalgananciaString="0.00";
    String totalInvercionesString="0.00";
    String TOTAL_Inventario="0.00";
    JButton actualizar;
    //---------------------------------------------------------------------
    
	Dialogo d=new Dialogo("Ganancias e inversiones", 600,150);
	public Ganacias_Inversiones()
	{
        paneles=new JTabbedPane();
        paneles.setBounds(10,0,575,120);
    //--------------------------------PANEL DE GANANCIAS DEL DIA------------------------------------------
        
        ganancias_del_dia=new Fondo(0,0);
		ganancias_del_dia.setLayout(null);
		ganancias_del_dia.setBounds(10,30,400,150);
		buscar_dia=new JButton("Buscar");
		buscar_dia.setBounds(250, 30, 100,30);
		new Pintar_boton(buscar_dia);
		ganancias_del_dia.add(buscar_dia);
		dial=new JLabel("Dia");
		new Pintar_label(dial);
		dial.setBounds(15,30,30,30);
		ganancias_del_dia.add(dial);
		dia=new JTextField();
		new Pintar_txt(dia);
		dia.setBounds(40,30,30,30);
		ganancias_del_dia.add(dia);
		mesl=new JLabel("Mes");
		new Pintar_label(mesl);
		mesl.setBounds(80,30,30,30);
		ganancias_del_dia.add(mesl);
		mes=new JTextField();
		new Pintar_txt(mes);
		mes.setBounds(110,30,30,30);
		ganancias_del_dia.add(mes);
		a�ol=new JLabel("A�o");
		new Pintar_label(a�ol);
		a�ol.setBounds(150,30,50,30);
		ganancias_del_dia.add(a�ol);
	    totall=new JLabel("BsF "+totalString);
        new Pintar_label(totall);
        totall.setFont(new Font(null,1,16));
        totall.setBounds(400,35,200,20);
        ganancias_del_dia.add(totall);
		a�o=new JTextField();
		new Pintar_txt(a�o);
		a�o.setBounds(180,30,40,30);
		ganancias_del_dia.add(a�o);
		paneles.addTab("Ganancias del Dia",null,ganancias_del_dia,"Ganancias del Dia");
		
		
		
		//-----------------------------------ganancias mes-----------------------------------------------------------------------------------------------------------
		
		    ganancias_del_mes=new Fondo(0,0);
		    ganancias_del_mes.setLayout(null);
		    ganancias_del_mes.setBounds(10,30,400,150);
		    mes_buscar=new JButton("Buscar");
		    mes_buscar.setBounds(250, 30, 100,30);
			new Pintar_boton(mes_buscar);
			ganancias_del_mes.add(mes_buscar);
			
		
			mes_mesl=new JLabel("Mes");
			new Pintar_label(mes_mesl);
			mes_mesl.setBounds(80,30,30,30);
			ganancias_del_mes.add(mes_mesl);
			mes_mes=new JTextField();
			new Pintar_txt(mes_mes);
			mes_mes.setBounds(110,30,30,30);
			ganancias_del_mes.add(mes_mes);
			mes_a�ol=new JLabel("A�o");
			new Pintar_label(mes_a�ol);
			mes_a�ol.setBounds(150,30,50,30);
			ganancias_del_mes.add(mes_a�ol);
			mes_totall=new JLabel("BsF "+mes_totalString);
	        new Pintar_label(mes_totall);
	        mes_totall.setFont(new Font(null,1,16));
	        mes_totall.setBounds(400,35,200,20);
	        ganancias_del_mes.add(mes_totall);
	        mes_a�o=new JTextField();
			new Pintar_txt(mes_a�o);
			mes_a�o.setBounds(180,30,40,30);
			ganancias_del_mes.add(mes_a�o);
			paneles.addTab("Ganancias del Mes",null,ganancias_del_mes,"Ganancias del Mes");
		//----------------------------------------------------------------------------------------------------------------------------------
		
			//-----------------------------------ganancias A�o-----------------------------------------------------------------------------------------------------------
			
		    ganancias_del_a�o=new Fondo(0,0);
		    ganancias_del_a�o.setLayout(null);
		    ganancias_del_a�o.setBounds(10,30,400,150);
		    a�o_buscar=new JButton("Buscar");
		    a�o_buscar.setBounds(250, 30, 100,30);
			new Pintar_boton(a�o_buscar);
			ganancias_del_a�o.add(a�o_buscar);
				
			a�o_a�ol=new JLabel("A�o");
			new Pintar_label(mes_a�ol);
			a�o_a�ol.setBounds(150,30,50,30);
			ganancias_del_a�o.add(mes_a�ol);
			
			
			a�o_totall=new JLabel("BsF "+a�o_totalString);
	        new Pintar_label(a�o_totall);
	        a�o_totall.setFont(new Font(null,1,16));
	        a�o_totall.setBounds(400,35,200,20);
	        ganancias_del_a�o.add(a�o_totall);
	        a�o_a�o=new JTextField();
			new Pintar_txt(a�o_a�o);
			a�o_a�o.setBounds(180,30,40,30);
			ganancias_del_a�o.add(a�o_a�o);
			paneles.addTab("Ganancias del A�o",null,ganancias_del_a�o,"Ganancias del A�o");
		//----------------------------------------------------------------------------------------------------------------------------------
		
			
			
			        ganancias_e_Inverciones_del_inventario=new Fondo(0,0);
			        ganancias_e_Inverciones_del_inventario.setLayout(null);
			        ganancias_e_Inverciones_del_inventario.setBounds(10,30,400,150);
			    
			        actualizar=new JButton("Buscar");
			        actualizar.setBounds(450, 22, 100,30);
				new Pintar_boton(actualizar);
				ganancias_e_Inverciones_del_inventario.add(actualizar);
					
				
				
			    gananciasl=new JLabel("Ganancia  BsF "+totalgananciaString);
				new Pintar_label(gananciasl);
				gananciasl.setFont(new Font(null,1,16));
				gananciasl.setBounds(10,5,300,30);
				ganancias_e_Inverciones_del_inventario.add(gananciasl);
				
				
				    total_inventariol=new JLabel("Total  BsF "+TOTAL_Inventario);
					new Pintar_label(total_inventariol);
					total_inventariol.setFont(new Font(null,1,16));
					total_inventariol.setBounds(250,20,300,30);
					ganancias_e_Inverciones_del_inventario.add(total_inventariol);
				
				
				Invercionl=new JLabel("Invercion  BsF "+totalInvercionesString);
		        new Pintar_label(Invercionl);
		        Invercionl.setFont(new Font(null,1,16));
		        Invercionl.setBounds(10,35,300,20);
		        ganancias_e_Inverciones_del_inventario.add(Invercionl);
		        
		        
				paneles.addTab("Ganancias e Inverciones en el Inventario ",null,ganancias_e_Inverciones_del_inventario,"Ganancias e Inverciones en el Inventario ");
			
		d.add(paneles);
		buscar_dia.addActionListener(this);
		a�o_buscar.addActionListener(this);
		a�o_buscar.addKeyListener(this);
		buscar_dia.addKeyListener(this);
		mes_buscar.addActionListener(this);
		mes_buscar.addKeyListener(this);
		actualizar.addActionListener(this);
		actualizar.addKeyListener(this);
		dia.addKeyListener(this);
		mes.addKeyListener(this);
		a�o.addKeyListener(this);
		a�o_a�o.addKeyListener(this);
		mes_mes.addKeyListener(this);
		mes_a�o.addKeyListener(this);
		new Enfocar(dia);
		d.setVisible(true);
		
	}
	@Override
	public void keyPressed(KeyEvent g) {
		
		if(g.getSource().equals(dia))
		{
		if(g.getKeyCode()==Event.ENTER){new Enfocar(mes);}
		}
		else
			if(g.getSource().equals(mes))
			{
			if(g.getKeyCode()==Event.ENTER){new Enfocar(a�o);}
			}
			else
				if(g.getSource().equals(a�o))
				{
				if(g.getKeyCode()==Event.ENTER){new Enfocar(buscar_dia);}
				}
				else
					if(g.getSource().equals(mes_mes))
					{
					if(g.getKeyCode()==Event.ENTER){new Enfocar(mes_a�o);}
					}
					else
						if(g.getSource().equals(mes_a�o))
						{
						if(g.getKeyCode()==Event.ENTER){new Enfocar(mes_buscar);}
						}
						else
							if(g.getSource().equals(a�o_a�o))
							{
							if(g.getKeyCode()==Event.ENTER){new Enfocar(a�o_buscar);}
							}
							else
		if(g.getSource().equals(mes_buscar))
		{
		if(g.getKeyCode()==Event.ENTER){BigDecimal total_dia=new BigDecimal("0");
		   String fecha="/"+mes_mes.getText()+"/"+mes_a�o.getText();
		    total_dia=new Buscador().Buscar_mes(fecha);
		    mes_totall.setText("BsF "+total_dia);}
		}
		else
			if(g.getSource().equals(buscar_dia))
			{
			if(g.getKeyCode()==Event.ENTER)
			{
				 BigDecimal total_dia=new BigDecimal("0");
				   String fecha=dia.getText()+"/"+mes.getText()+"/"+a�o.getText();
				    total_dia=new Buscador().Buscar_dia(fecha);
				   totall.setText("BsF "+total_dia);
			}
			}
			else
				if(g.getSource().equals(a�o_buscar))
				{
				if(g.getKeyCode()==Event.ENTER)
				{
					BigDecimal total_dia=new BigDecimal("0");
					   String fecha="/"+a�o_a�o.getText();
					    total_dia=new Buscador().Buscar_mes(fecha);
					    a�o_totall.setText("BsF "+total_dia);
				}
				}
	}
	@Override
	public void keyReleased(KeyEvent g) {
		
		
	}
	@Override
	public void keyTyped(KeyEvent g) {
		
		if(g.getSource().equals(a�o_a�o))
		{
			if(a�o_a�o.getText().length()==4){g.consume();}
			else{
			char x=g.getKeyChar();
			if(x<'0' || x>'9'){g.consume();}
			}	
		}
		else
		if(g.getSource().equals(dia))
		{
			if(dia.getText().length()==2){g.consume();}
			else{
			char x=g.getKeyChar();
			if(x<'0' || x>'9'){g.consume();}
			}	
		}
		else
			if(g.getSource().equals(mes_mes))
			{
				if(mes_mes.getText().length()==2){g.consume();}
				else{
					char x=g.getKeyChar();
					if(x<'0' || x>'9'){g.consume();}
					}	
			}
			else
		if(g.getSource().equals(mes))
		{
			
			if(mes.getText().length()==2){g.consume();}
			else{
			char x=g.getKeyChar();
			if(x<'0' || x>'9'){g.consume();}
			}	
		}
		else
			if(g.getSource().equals(mes_a�o))
			{
				if(mes_a�o.getText().length()==4){g.consume();}
				else{
					char x=g.getKeyChar();
					if(x<'0' || x>'9'){g.consume();}
					}	
			}
			else
		if(g.getSource().equals(a�o))
		{
			
			if(a�o.getText().length()==4){g.consume();}
			else{
			char x=g.getKeyChar();
			if(x<'0' || x>'9'){g.consume();}
			}	
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent a) {
		
		 if(a.getSource().equals(actualizar))
			{
			   
			   
			    String xx[]=new Buscador().ganancias_Invercion();
			  
			   BigDecimal total_inverciones=new BigDecimal( xx[0]);
			   totalInvercionesString=total_inverciones.toString();
			   Invercionl.setText("Invercion  BsF "+totalInvercionesString);
			   
			   BigDecimal total_ganancias=new BigDecimal(xx[1]);
			   totalgananciaString=total_ganancias.toString();
			   gananciasl.setText("Ganancia  BsF "+totalgananciaString);
			   
			   BigDecimal totalx=new BigDecimal("0");
			   totalx=total_ganancias.add(total_inverciones).setScale(2,RoundingMode.HALF_EVEN);
			   TOTAL_Inventario=totalx.toString();
			   total_inventariol.setText("Total  BsF "+TOTAL_Inventario);
			}
		 else
	   if(a.getSource().equals(buscar_dia))
		{
		   BigDecimal total_dia=new BigDecimal("0");
		   String fecha=dia.getText()+"/"+mes.getText()+"/"+a�o.getText();
		    total_dia=new Buscador().Buscar_dia(fecha);
		   totall.setText("BsF "+total_dia);
		    
		}
	   else
		   if(a.getSource().equals(mes_buscar))
			{
			   BigDecimal total_dia=new BigDecimal("0");
			   String fecha="/"+mes_mes.getText()+"/"+mes_a�o.getText();
			    total_dia=new Buscador().Buscar_mes(fecha);
			    mes_totall.setText("BsF "+total_dia);
			    
			}
		   else
	   if(a.getSource().equals(a�o_buscar))
		{
		   BigDecimal total_dia=new BigDecimal("0");
		   String fecha="/"+a�o_a�o.getText();
		    total_dia=new Buscador().Buscar_mes(fecha);
		    a�o_totall.setText("BsF "+total_dia);
		}
		
	}
	
}
