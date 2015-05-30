package calendario;

import java.awt.Dimension;

import datechooser.beans.DateChooserDialog;

public class Calendario {

	
	public Calendario()
	{
		DateChooserDialog dt = new DateChooserDialog(); 
		Dimension dim=new Dimension(350,300);
		dt.setCalendarPreferredSize(dim);
		dt.showDialog(null);
	}
}
