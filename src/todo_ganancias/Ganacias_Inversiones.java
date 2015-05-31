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
    JTextField dia,mes,ano;
    JLabel dial,mesl,anol,totall;
    String totalString="0.00";
    JButton buscar_dia;
    //--------------------------------
    Fondo ganancias_del_mes;
    JTextField mes_mes,mes_ano;
    JLabel mes_mesl,mes_anol,mes_totall;
    String mes_totalString="0.00";
    JButton mes_buscar;
    //----------------------------------
    
    Fondo ganancias_del_ano;
    JTextField ano_ano;
    JLabel ano_anol,ano_totall;
    String ano_totalString="0.00";
    JButton ano_buscar;
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
		anol=new JLabel("Ano");
		new Pintar_label(anol);
		anol.setBounds(150,30,50,30);
		ganancias_del_dia.add(anol);
	    totall=new JLabel("BsF "+totalString);
        new Pintar_label(totall);
        totall.setFont(new Font(null,1,16));
        totall.setBounds(400,35,200,20);
        ganancias_del_dia.add(totall);
		ano=new JTextField();
		new Pintar_txt(ano);
		ano.setBounds(180,30,40,30);
		ganancias_del_dia.add(ano);
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
			mes_anol=new JLabel("Ano");
			new Pintar_label(mes_anol);
			mes_anol.setBounds(150,30,50,30);
			ganancias_del_mes.add(mes_anol);
			mes_totall=new JLabel("BsF "+mes_totalString);
	        new Pintar_label(mes_totall);
	        mes_totall.setFont(new Font(null,1,16));
	        mes_totall.setBounds(400,35,200,20);
	        ganancias_del_mes.add(mes_totall);
	        mes_ano=new JTextField();
			new Pintar_txt(mes_ano);
			mes_ano.setBounds(180,30,40,30);
			ganancias_del_mes.add(mes_ano);
			paneles.addTab("Ganancias del Mes",null,ganancias_del_mes,"Ganancias del Mes");
		//----------------------------------------------------------------------------------------------------------------------------------
		
			//-----------------------------------ganancias Ano-----------------------------------------------------------------------------------------------------------
			
		    ganancias_del_ano=new Fondo(0,0);
		    ganancias_del_ano.setLayout(null);
		    ganancias_del_ano.setBounds(10,30,400,150);
		    ano_buscar=new JButton("Buscar");
		    ano_buscar.setBounds(250, 30, 100,30);
			new Pintar_boton(ano_buscar);
			ganancias_del_ano.add(ano_buscar);
				
			ano_anol=new JLabel("Ano");
			new Pintar_label(mes_anol);
			ano_anol.setBounds(150,30,50,30);
			ganancias_del_ano.add(mes_anol);
			
			
			ano_totall=new JLabel("BsF "+ano_totalString);
	        new Pintar_label(ano_totall);
	        ano_totall.setFont(new Font(null,1,16));
	        ano_totall.setBounds(400,35,200,20);
	        ganancias_del_ano.add(ano_totall);
	        ano_ano=new JTextField();
			new Pintar_txt(ano_ano);
			ano_ano.setBounds(180,30,40,30);
			ganancias_del_ano.add(ano_ano);
			paneles.addTab("Ganancias del Ano",null,ganancias_del_ano,"Ganancias del Ano");
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
		ano_buscar.addActionListener(this);
		ano_buscar.addKeyListener(this);
		buscar_dia.addKeyListener(this);
		mes_buscar.addActionListener(this);
		mes_buscar.addKeyListener(this);
		actualizar.addActionListener(this);
		actualizar.addKeyListener(this);
		dia.addKeyListener(this);
		mes.addKeyListener(this);
		ano.addKeyListener(this);
		ano_ano.addKeyListener(this);
		mes_mes.addKeyListener(this);
		mes_ano.addKeyListener(this);
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
			if(g.getKeyCode()==Event.ENTER){new Enfocar(ano);}
			}
			else
				if(g.getSource().equals(ano))
				{
				if(g.getKeyCode()==Event.ENTER){new Enfocar(buscar_dia);}
				}
				else
					if(g.getSource().equals(mes_mes))
					{
					if(g.getKeyCode()==Event.ENTER){new Enfocar(mes_ano);}
					}
					else
						if(g.getSource().equals(mes_ano))
						{
						if(g.getKeyCode()==Event.ENTER){new Enfocar(mes_buscar);}
						}
						else
							if(g.getSource().equals(ano_ano))
							{
							if(g.getKeyCode()==Event.ENTER){new Enfocar(ano_buscar);}
							}
							else
		if(g.getSource().equals(mes_buscar))
		{
		if(g.getKeyCode()==Event.ENTER){BigDecimal total_dia=new BigDecimal("0");
		   String fecha="/"+mes_mes.getText()+"/"+mes_ano.getText();
		    total_dia=new Buscador().Buscar_mes(fecha);
		    mes_totall.setText("BsF "+total_dia);}
		}
		else
			if(g.getSource().equals(buscar_dia))
			{
			if(g.getKeyCode()==Event.ENTER)
			{
				 BigDecimal total_dia=new BigDecimal("0");
				   String fecha=dia.getText()+"/"+mes.getText()+"/"+ano.getText();
				    total_dia=new Buscador().Buscar_dia(fecha);
				   totall.setText("BsF "+total_dia);
			}
			}
			else
				if(g.getSource().equals(ano_buscar))
				{
				if(g.getKeyCode()==Event.ENTER)
				{
					BigDecimal total_dia=new BigDecimal("0");
					   String fecha="/"+ano_ano.getText();
					    total_dia=new Buscador().Buscar_mes(fecha);
					    ano_totall.setText("BsF "+total_dia);
				}
				}
	}
	@Override
	public void keyReleased(KeyEvent g) {
		
		
	}
	@Override
	public void keyTyped(KeyEvent g) {
		
		if(g.getSource().equals(ano_ano))
		{
			if(ano_ano.getText().length()==4){g.consume();}
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
			if(g.getSource().equals(mes_ano))
			{
				if(mes_ano.getText().length()==4){g.consume();}
				else{
					char x=g.getKeyChar();
					if(x<'0' || x>'9'){g.consume();}
					}	
			}
			else
		if(g.getSource().equals(ano))
		{
			
			if(ano.getText().length()==4){g.consume();}
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
		   String fecha=dia.getText()+"/"+mes.getText()+"/"+ano.getText();
		    total_dia=new Buscador().Buscar_dia(fecha);
		   totall.setText("BsF "+total_dia);
		    
		}
	   else
		   if(a.getSource().equals(mes_buscar))
			{
			   BigDecimal total_dia=new BigDecimal("0");
			   String fecha="/"+mes_mes.getText()+"/"+mes_ano.getText();
			    total_dia=new Buscador().Buscar_mes(fecha);
			    mes_totall.setText("BsF "+total_dia);
			    
			}
		   else
	   if(a.getSource().equals(ano_buscar))
		{
		   BigDecimal total_dia=new BigDecimal("0");
		   String fecha="/"+ano_ano.getText();
		    total_dia=new Buscador().Buscar_mes(fecha);
		    ano_totall.setText("BsF "+total_dia);
		}
		
	}
	
}
