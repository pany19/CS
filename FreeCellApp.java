/**
 * project7
 * Opens a window and runs the freecell game.
 * @author Maxwell
 * @author Pan
 * @author Annjoy
 * @author Zander
 * @version 1.0
 */

import javax.swing.JFrame;

public class FreeCellApp {

    public static void main(String[] args){
    	final FreeCellGame game = new FreeCellGame();
        final JFrame view = new AppView(game);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setSize(800, 600);
        view.setVisible(true);
        }
}
