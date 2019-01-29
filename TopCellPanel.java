/**
 * project7
 * Creates the graphics for the home and free cells.
 * @author Maxwell
 * @author Pan
 * @author Annjoy
 * @author Zander
 * @version 1.0
 */
import java.awt.*;
import javax.swing.*;
public class TopCellPanel extends CellPanel{
	
	//The Constructor the the cell panel
	public TopCellPanel(CellInterface cell, ViewInformer informer) {
		super(cell, informer);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
			Icon image;
	    	int y =0;
	    	if (cell.isEmpty()){
	    		image = Card.getBack();
	    		g.setColor(Color.yellow);
	    		int x = (getWidth() - image.getIconWidth()) / 2;
	    		g.drawRect(x, y, image.getIconWidth(), image.getIconHeight());
	    	}
	    	else{
	    		image = this.cell.peek().getImage();
	    		int x = (getWidth() - image.getIconWidth()) / 2;
	    		image.paintIcon(this, g, x, y);
	    	}
	    }
	

}

