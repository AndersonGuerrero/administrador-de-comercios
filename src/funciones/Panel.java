package funciones;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Panel extends JPanel {
	
	private Image imagen;
	public Panel()
	{
	super();
	this.setOpaque(false);
	}
	public void setbacgroundimage(Image img)
	{
		this.imagen=img;
	}
	
	public ImageIcon createImage(String ubi)
	{
		URL imgurl=getClass().getResource(ubi);
		if(imgurl!=null){return new ImageIcon(imgurl);}
		else
		{
			System.err.println("Archivo no encontrado"+ubi);
			return null;
		}
	}
	
	public void paint(Graphics g){
		if(imagen!=null){
			g.drawImage(imagen,0,0,getWidth(),getHeight(),null);
		}
		super.paint(g);
	}
}
