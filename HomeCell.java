/**
* project7
* Represents a home cell in the freecell game.
* @author Maxwell
* @author Pan
* @author Annjoy
* @author Zander
* @version 1.0
*/
public class HomeCell extends AbstractCell{
	public HomeCell() {
		super();
	}
	
	public boolean canAddTo(Card card) {
		if(this.isEmpty() == true) {
			if (card.getRank() == 1) {
				return true;
			}
			else {
				return false;
				}
		}
		else {
			if (card.getSuit() == this.peek().getSuit() && 
					card.getRank() == this.peek().getRank()+1) {
				return true;
				}
			else {
				return false;
				}
			}
	}

}