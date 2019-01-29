/**
 * project7
 * Creates the graphics for the tableau cells.
 * @author Maxwell
 * @author Pan
 * @author Annjoy
 * @author Zander
 * @version 1.0
 */
import javax.swing.*;
import java.awt.*;

/**
 * Represents the GUI component for painting an image of a playing card.
 * @author lambertk
 *
 */
public class BottomCellPanel extends CellPanel{

    /**
     * Constructor to display a given card's image.
     * @param c the card to display.
     */
    public BottomCellPanel(CellInterface cell, ViewInformer informer){
        super(cell, informer);
    }

    /**
     * Paints the card's face image if a card is present, otherwise, paints the back side image.
     */
    public void paintComponent(Graphics g){
    	super.paintComponent(g);
    	int y = 0;
    	Icon image;
    	if (cell.isEmpty()){
    		image = Card.getBack();
    		g.setColor(Color.yellow);
    		int x = (getWidth() - image.getIconWidth()) / 2;
    		g.drawRect(x, y, image.getIconWidth(), image.getIconHeight());
    	}
    	
    	else{
    		for (Card card : cell) {
	    		image = card.getImage();
	    		int x = (getWidth() - image.getIconWidth()) / 2;
	    		image.paintIcon(this, g, x, y);
	    		y += 30;
    		}
    	}
    }
    
  

}
