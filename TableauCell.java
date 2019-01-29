/**
* project7
* Represents a tableau cell in the freecell game.
* @author Maxwell
* @author Pan
* @author Annjoy
* @author Zander
* @version 1.0
*/
public class TableauCell extends AbstractCell {

	public TableauCell() {
		super();
	}

	public boolean canAddTo(Card card) {
		if (this.isEmpty()) {
			return true;
		}
		if (card.getRank() != this.peek().getRank() - 1) {
			return false;
		}
		if (! card.sameColor(this.peek())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean canMoveFrom(CellInterface cell) {
		if (! (cell instanceof TableauCell)) {
			return super.canMoveFrom(cell);
		}
		else {
			Card card = this.peek();
			int index = this.size() - 1;
			while (! cell.canAddTo(card) && index != 0) {
				index -= 1;
				card = this.get(index);
			}
			if (cell.canAddTo(card) && this.inOrder(index))
				return true;
		}
		return false;
	}
	
	public boolean remove(Card card) {
		cards.remove(card);
		return true;
	}
	
	public Card get(int i) {
		return cards.get(i);
	}

	public boolean inOrder(int index) {
		for (int i=index; i< this.size()-1; i++) {
			if (cards.get(i).sameColor(cards.get(i+1)) || ! cards.get(i+1).nextTo(cards.get(i))) {
				return false;
			}
		}
		return true;
	}
	
	public boolean inOrder() {
		return this.inOrder(0);
	}
	
	public boolean move(CellInterface dest) {
		if (! (dest instanceof TableauCell)) {
			return super.move(dest);
		}
		
		Card card = this.peek();
		int index = this.size() - 1;
		
		if (this.isEmpty()) {
			return false;
		}
		
		if (dest.isEmpty()){
			int i = 0;
			while (! this.inOrder(i) && i != index - 1){
				i++;
			}
			if (this.inOrder(i) && i != index) {
				for (int j = i; j <= index; j++) {
					dest.add(this.get(i));
					this.remove(this.get(i));
				}
				return true;
			}
			else {
				dest.add(this.pop());
				return true;
			}
		}
		
		while (! dest.canAddTo(card) && index != 0) {
			index -= 1;
			card = this.get(index);
		}
		if (dest.canAddTo(card) && this.inOrder(index)) {
			int tempSize = this.size();
			for (int i = index; i <= tempSize - 1; i++) {
				dest.add(this.get(index));
				this.remove(this.get(index));
			}
			return true;
		}
		return false;
	}
}
