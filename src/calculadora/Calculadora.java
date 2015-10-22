package calculadora;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import funciones.Dialogo;
import funciones.Fondo;
import funciones.Pintar_boton;
import funciones.Pintar_label;

public class Calculadora implements ActionListener{
	boolean suma=false;
    String signo="";
	BigDecimal total;
	BigDecimal n1;
	BigDecimal n2;
	Fondo panel_botones,panel_pantall;
	JTextArea pantalla;
	JLabel rs1,rs2;
	JButton punto,uno,dos,tres,cuatro,cinco,seis,ciete,ocho,nueve,sero,mas,menos,multipli,divi,igual,porcentaje,borrar,eliminar;
	Dialogo d=new Dialogo("Calculadora",220,310);
	public Calculadora()
	{
		total=new BigDecimal("0");
		n1=new BigDecimal("0");
		n2=new BigDecimal("0");
		
		panel_botones=new Fondo(0, 0);
		panel_botones.setBounds(5,80,205,200);
		panel_botones.setLayout(new GridLayout(5,4));
		
		panel_pantall=new Fondo(0,0);
		panel_pantall.setBounds(5,5,205,50);
		panel_pantall.setLayout(null);
		
		rs1=new JLabel("0");
		rs1.setBounds(10,30,200,20);
		new Pintar_label(rs1);
		rs1.setFont(new Font(null,1,16));
		
		
		rs2=new JLabel("0");
		rs2.setBounds(10,5,200,20);
		new Pintar_label(rs2);
		rs2.setFont(new Font(null,1,16));
		
		
		eliminar=new JButton("<==");
		new Pintar_boton(eliminar);
		eliminar.setBounds(5,52,100,30);
		
		borrar=new JButton("Borrar");
		new Pintar_boton(borrar);
		borrar.setBounds(112,52,100,30);
		

		uno=new JButton("1");
		new Pintar_boton(uno);
		uno.setFont(new Font(null, 1, 15));
		panel_botones.add(uno);
		
		
	
		dos=new JButton("2");
		new Pintar_boton(dos);
		dos.setFont(new Font(null, 1, 15));
		panel_botones.add(dos);
		
		
		tres=new JButton("3");
		new Pintar_boton(tres);
		tres.setFont(new Font(null, 1, 15));
		panel_botones.add(tres);
		
		
		mas=new JButton("+");
		new Pintar_boton(mas);
		mas.setFont(new Font(null, 1, 20));
		panel_botones.add(mas);
		
		
		cuatro=new JButton("4");
		new Pintar_boton(cuatro);
		cuatro.setFont(new Font(null, 1, 15));
		panel_botones.add(cuatro);
		
	
		cinco=new JButton("5");
		new Pintar_boton(cinco);
		cinco.setFont(new Font(null, 1, 15));
		panel_botones.add(cinco);
		
		
	
		seis=new JButton("6");
		new Pintar_boton(seis);
		seis.setFont(new Font(null, 1, 15));
		panel_botones.add(seis);
		
	
		menos=new JButton("-");
		new Pintar_boton(menos);
		menos.setFont(new Font(null, 1, 20));
		panel_botones.add(menos);
		
		
		ciete=new JButton("7");
		new Pintar_boton(ciete);
		ciete.setFont(new Font(null, 1, 15));
		panel_botones.add(ciete);
		
		
		ocho=new JButton("8");
		new Pintar_boton(ocho);
		ocho.setFont(new Font(null, 1, 15));
		panel_botones.add(ocho);
		
		
		nueve=new JButton("9");
		new Pintar_boton(nueve);
		nueve.setFont(new Font(null, 1, 15));
		panel_botones.add(nueve);
		
		
		multipli=new JButton("*");
		new Pintar_boton(multipli);
		multipli.setFont(new Font(null, 1, 20));
		panel_botones.add(multipli);
		
		
		sero=new JButton("0");
		new Pintar_boton(sero);
		sero.setFont(new Font(null, 1, 15));
		panel_botones.add(sero);
		
		
		divi=new JButton("/");
		new Pintar_boton(divi);
		divi.setFont(new Font(null, 1, 20));
		panel_botones.add(divi);
		
		
		porcentaje=new JButton("%");
		new Pintar_boton(porcentaje);
		porcentaje.setFont(new Font(null, 1, 20));
		panel_botones.add(porcentaje);
		
		punto=new JButton(".");
		new Pintar_boton(punto);
		punto.setFont(new Font(null, 1, 20));
		panel_botones.add(punto);
		
		
		igual=new JButton("=");
		new Pintar_boton(igual);
		igual.setFont(new Font(null, 1, 20));
		igual.setBounds(7,240,200,37);
		d.add(igual);
		igual.addActionListener(this);
		uno.addActionListener(this);
		dos.addActionListener(this);
		tres.addActionListener(this);
		cuatro.addActionListener(this);
		cinco.addActionListener(this);
		seis.addActionListener(this);
		ciete.addActionListener(this);
		ocho .addActionListener(this);
		nueve.addActionListener(this);
		sero.addActionListener(this);
		mas.addActionListener(this);
		menos.addActionListener(this);
		multipli.addActionListener(this);
		divi.addActionListener(this);
		eliminar.addActionListener(this);
		borrar.addActionListener(this);
        punto.addActionListener(this);
        porcentaje.addActionListener(this);
		d.add(rs1);
		d.add(rs2);
		d.add(eliminar);
		d.add(borrar);
	    d.add(panel_botones);
	    d.add(panel_pantall);
		d.setVisible(true);
		
	}


	@Override
	public void actionPerformed(ActionEvent g) {
		
		if(g.getSource().equals(eliminar))
		{    
			if(rs1.getText().equals("0"))
			{
				
			}
			else{
			char x[]=rs1.getText().toCharArray();
			String x2="";
			for(int i=0;i<x.length-1;i++)
			{
			x2+=x[i];
			}
			
			rs1.setText(x2);
			}
			
		}
		else
		if(g.getSource().equals(borrar))
		{
			rs2.setText("0");
			rs1.setText("0");
			suma=false;
			total=new BigDecimal("0");
		}
		else
		if(g.getSource().equals(igual))
		{
           calculo();
		}
		else
			if(g.getSource().equals(uno))
			{
				if(rs1.getText().equals("0"))
				{
					rs1.setText("1");
				}
				else{rs1.setText(rs1.getText()+"1");}
				
			}
			else
				if(g.getSource().equals(dos))
				{
					if(rs1.getText().equals("0"))
					{
						rs1.setText("2");
					}
					else{
					rs1.setText(rs1.getText()+"2");}
				}
				else
					if(g.getSource().equals(tres))
					{
						if(rs1.getText().equals("0"))
						{
							rs1.setText("3");
						}
						else{
						rs1.setText(rs1.getText()+"3");}
					}
					else
						if(g.getSource().equals(cuatro))
						{
							if(rs1.getText().equals("0"))
							{
								rs1.setText("4");
							}
							else{
							rs1.setText(rs1.getText()+"4");}
						}
						else
							if(g.getSource().equals(cinco))
							{
								if(rs1.getText().equals("0"))
								{
									rs1.setText("5");
								}
								else{
								rs1.setText(rs1.getText()+"5");}
							}
							else
								if(g.getSource().equals(seis))
								{
									if(rs1.getText().equals("0"))
									{
										rs1.setText("6");
									}
									else{
									rs1.setText(rs1.getText()+"6");}
								}
								else
									if(g.getSource().equals(ciete))
									{
										if(rs1.getText().equals("0"))
										{
											rs1.setText("7");
										}
										else{
										rs1.setText(rs1.getText()+"7");}
									}
									else
										if(g.getSource().equals(punto))
										{
											
											if(rs1.getText().equals("0.") || rs1.getText().equals("1.") || rs1.getText().equals("2.")  
													                      || rs1.getText().equals("3.") || rs1.getText().equals("4.")
													                      || rs1.getText().equals("5.") || rs1.getText().equals("6.")
													                      || rs1.getText().equals("7.") || rs1.getText().equals("8.")
													                      || rs1.getText().equals("9."))
											{
											
											}else
											{
											rs1.setText(rs1.getText()+".");
											}
										
										}
										else
										if(g.getSource().equals(ocho))
										{
											if(rs1.getText().equals("0"))
											{
												rs1.setText("8");
											}
											else{
											rs1.setText(rs1.getText()+"8");}
										}
										else
											if(g.getSource().equals(nueve))
											{
												if(rs1.getText().equals("0"))
												{
													rs1.setText("9");
												}
												else{
												rs1.setText(rs1.getText()+"9");}
											}
											else
												if(g.getSource().equals(sero))
												{
													if(rs1.getText().equals("0"))
													{
														rs1.setText("0");
													}
													else{
													rs1.setText(rs1.getText()+"0");}
												}
												else
													if(g.getSource().equals(mas))
													{
														
														
														if(rs2.getText().equals("0"))
														{
															rs2.setText(rs1.getText());
														}
														else
														{
														rs2.setText(rs2.getText()+"+"+rs1.getText());
														
														}
														if(suma)
														{
															rs2.setText(""+total);
															rs1.setText("0");
															suma=false;
														}
														
													
														  signo="+";
														 n1=new BigDecimal(rs1.getText());
												         total=total.add(n1);
												        
												     	rs1.setText("0");
													}
													else
														if(g.getSource().equals(menos))
														{
															
															if(rs2.getText().equals("0"))
															{
																rs2.setText(rs1.getText());
															}
															else
															{
															rs2.setText(rs2.getText()+"-"+rs1.getText());
															
															}
															if(suma)
															{
																rs2.setText(""+total);
																rs1.setText("0");
																suma=false;
															}
															
														
															  signo="-";
															 n1=new BigDecimal(rs1.getText());
													         if(total.compareTo(new BigDecimal("0"))==0)
													         {
													        	 total=n1;
													         }else{
															 total=total.subtract(n1);}
													     	  rs1.setText("0");
														
														}
														else
															if(g.getSource().equals(multipli))
															{
																if(rs2.getText().equals("0"))
																{
																	rs2.setText(rs1.getText());
																}
																else
																{
																rs2.setText(rs2.getText()+"*"+rs1.getText());
																
																}
																if(suma)
																{
																	rs2.setText(""+total);
																	rs1.setText("0");
																	suma=false;
																}
																
															
																  signo="*";
																 n1=new BigDecimal(rs1.getText());
														         if(total.compareTo(new BigDecimal("0"))==0)
														         {
														        	 total=n1;
														         }else{
																 total=total.subtract(n1);}
														         
														     	  rs1.setText("0");
															}
															else
																if(g.getSource().equals(divi))
																{
																	
																	if(rs2.getText().equals("0"))
																	{
																		rs2.setText(rs1.getText());
																	}
																	else
																	{
																	rs2.setText(rs2.getText()+"/"+rs1.getText());
																	
																	}
																	if(suma)
																	{
																		rs2.setText(""+total);
																		rs1.setText("0");
																		suma=false;
																	}
																	
																
																	  signo="/";
																	 n1=new BigDecimal(rs1.getText());
															         if(total.compareTo(new BigDecimal("0"))==0)
															         {
															        	 total=n1;
															         }else{
																	 total=total.subtract(n1);}
															         
															     	  rs1.setText("0");
																}
																else
		                                                              if(g.getSource().equals(porcentaje))
		                                                                {
		                                                            	  
		                                                            	  BigDecimal x=new BigDecimal(rs1.getText());
		                                                            
		                                                            	  rs2.setText(rs1.getText());
		                                                            	  x=x.divide(new BigDecimal("100"));
		                                                            	
		                                                            	  rs1.setText(""+x);
		                                                            	 total=x;
		                                                            	  signo="";
		                                                            	  suma=true;
		                                                                }
	}
	
	
	public void calculo()
	{
		
		
		if(signo.equals("+")){
			
			if(rs2.getText().equals("0"))
			{
				
				rs2.setText(rs1.getText());
			}
			else
			{
			rs2.setText(rs2.getText()+"+"+rs1.getText());
			}
		    n1=new BigDecimal(rs1.getText());

            total=n1.add(total);
			rs1.setText(""+total);
			suma=true;
			}
		
		
		
		
		if(signo.equals("-")){
			if(rs2.getText().equals("0"))
			{
				rs2.setText(rs1.getText());
			}
			else
			{
			rs2.setText(rs2.getText()+"-"+rs1.getText());
			}
		    n1=new BigDecimal(rs1.getText());

            total=total.subtract(n1);
			rs1.setText(""+total);
			suma=true;
			}
		
		if(signo.equals("/")){
			
			if(rs2.getText().equals("0"))
			{
				rs2.setText(rs1.getText());
			}
			else
			{
			rs2.setText(rs2.getText()+"/"+rs1.getText());
			}
		    n1=new BigDecimal(rs1.getText());

            total=total.divide(n1);
			rs1.setText(""+total);
			suma=true;
			
			
				}
		
		if(signo.equals("*"))
		{
			if(rs2.getText().equals("0"))
			{
				rs2.setText(rs1.getText());
			}
			else
			{
			rs2.setText(rs2.getText()+"*"+rs1.getText());
			}
		    n1=new BigDecimal(rs1.getText());

            total=total.multiply(n1);
			rs1.setText(""+total);
			suma=true;
			
		
		}
		
		
		
		
	}
}
