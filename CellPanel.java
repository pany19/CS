/**
 * project7
 * An abstract class for the graphics panels for the cells.
 * @author Maxwell
 * @author Pan
 * @author Annjoy
 * @author Zander
 * @version 1.0
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public abstract class CellPanel extends JPanel{
	protected CellInterface cell;
	protected ViewInformer informer;
	
	public CellPanel(CellInterface c, ViewInformer v) {
		cell = c;
		informer = v;
		setBackground(new Color(0, 150, 50));
		addMouseListener(new PanelListener());
	}
	
	public CellInterface getCell() {
		return cell;
	}
	
	private class PanelListener extends MouseAdapter{
		public void mousePressed(MouseEvent E) {
			informer.panelPressed(CellPanel.this);
		}
	}

}