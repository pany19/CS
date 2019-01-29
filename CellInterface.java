import java.util.*; 
/**
 * project7
 * Represents the cells in the game.
 * @author Maxwell
 * @author Pan
 * @author Annjoy
 * @author Zander
 * @version 1.0
 */
public interface CellInterface extends Collection<Card>{
	
	/**
     * Add a card to the cell.
     * @param card
     * @return true if the addition succeeds
     */
	public boolean add(Card card);
		
	/**
     * @return the current cell state as a string.
     */
	public String toString();

	/**
     * Removes a card from the cell.
     * @param card
     * @return false if remove is not supported.
     */
	public boolean remove(Card card);
	
	/**
	 * @param card
     * @return whether we can add the a card to the cell.
     */
	public boolean canAddTo(Card card);

	/**
	 * @param cell
     * @return whether we can remove the a card from the cell.
     */
	public boolean canMoveFrom(CellInterface cell);
	
	/**
	 * @return the top card in the cell.
	 */
	public Card peek();
	
	/**
	 * @return the top card in the cell, and remove it from that cell.
	 */
	public Card pop();
	
	/**
	 * Moves relevant cards from this cell to the destination
	 * @param dest
	 */
	public boolean move(CellInterface dest);
}
