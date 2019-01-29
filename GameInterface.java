/**
 * project7
 * Represents a freecell game.
 * @author Maxwell
 * @author Pan
 * @author Annjoy
 * @author Zander
 * @version 1.0
 */
public interface GameInterface {
	/**
     * Returns the game state.
     * @return the game state as a string
     */
	public String toString();
	
	/**
	 * Returns the ith element in the cell.
	 * @param i
	 * @return the ith element in the cell.
	 */
	public TableauCell getTableau(int i);
	
	/**
	 * Returns the ith element in the cell.
	 * @param i
	 * @return the ith element in the cell.
	 */
	public FreeCell getFree(int i);
	
	/**
	 * Returns the ith element in the cell.
	 * @param i
	 * @return the ith element in the cell.
	 */
	public HomeCell getHome(int i);
	
	/**
     * Deals 52 cards to 8 columns.
     */
	public void deal();
	
	/**
     * start a new game.
     */
	public void newGame();
	
	/**
     * Makes one move in the game played.
     * @param fromCell 
     * @param toCell
     * @return whether the move is legal
     */
	public boolean makeMove(CellInterface fromCell, CellInterface toCell);
	
	/**
     * Returns false if the player does not win yet, and true if he has.
     * @return a boolean indicating whether the player won
     */
	public boolean winner();
	
	/**
     * Returns true if the player cannot make any moves.
     * @return a boolean indicating that the player can no longer make any moves.
     */
	public boolean loser();

}

	

