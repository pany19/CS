import java.util.*; 
/**
 * project7
 * An abstract class for the cells.
 * @author Maxwell
 * @author Pan
 * @author Annjoy
 * @author Zander
 * @version 1.0
 */
public abstract class AbstractCell extends AbstractCollection<Card>  implements CellInterface {
	protected List<Card> cards;
		
	public AbstractCell() {
		cards = new ArrayList<Card>();
	}
	
	public String toString() {
		return cards.toString();
	}
	
	public int size() {
		return cards.size();
	}
	
	public Iterator<Card> iterator(){
		return cards.iterator();
	}
	
	public boolean add(Card card) {
		return cards.add(card);
	}

	public boolean remove(Card card) {
		return false;
	}

	abstract public boolean canAddTo(Card card);
	
	public boolean canMoveFrom(CellInterface cell) {
		if(cell.isEmpty()||cell instanceof HomeCell) {
			return false;
		}
		else {
			return this.canAddTo(cell.peek());
		}
	}
	
	public void clear() {
		cards.clear();
	}

	public Card peek() {
		if (! isEmpty()) {
			return cards.get(cards.size()-1);
		} else {
			return null;
		}
	}
	
	public Card pop() {
		Card card = this.peek();
		this.remove(card);
		return card;
	}
	
	public boolean contains(Card card){
		return cards.contains(card);
	}
	
	public boolean move(CellInterface dest) {
		if (dest.canMoveFrom(this)) {
			dest.add(this.pop());
			return true;
		}
		else {
			return false;
			}
	}
	
}
