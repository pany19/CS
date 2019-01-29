/**
* project7
* Represents a free cell in the freecell game.
* @author Maxwell
* @author Pan
* @author Annjoy
* @author Zander
* @version 1.0
*/
public class FreeCell extends AbstractCell{
	
	public FreeCell() {
		super();
	}

	public boolean remove(Card card) {
		cards.remove(card);
		return true;
	}

	public boolean canAddTo(Card card) {
		if(this.isEmpty()) {
		 return true;
		}
		else {
			 return false;
			}
	}
	
}


