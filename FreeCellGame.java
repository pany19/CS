/**
 * project7
 * An class for the freecell game.
 * @author Maxwell
 * @author Pan
 * @author Annjoy
 * @author Zander
 * @version 1.0
 */
public class FreeCellGame implements GameInterface{
	
	private Deck deck;
	private FreeCell[] freeCells = new FreeCell[4];
	private HomeCell[] homeCells = new HomeCell[4];
	private TableauCell[] tableauCells = new TableauCell[8];
	private int moveCount;
	private int leastMoves = 0;
	private int gamesPlayed = 0;
	private int wins = 0;
	private boolean hasBeenWon = false;
	
	public FreeCellGame() {
		for(int i =0; i<4; i++) {
			freeCells[i] = new FreeCell();
			homeCells[i] = new HomeCell();
		}
		for(int i =0; i < 8; i++) {
			tableauCells[i] = new TableauCell();
		}
		newGame();
	}
	
	public TableauCell getTableau(int i) {
		return tableauCells[i];
	}
	
	public FreeCell getFree(int i) {
		return freeCells[i];
	}
	
	public HomeCell getHome(int i) {
		return homeCells[i];
	}
	
	public void newGame() {
		for(int i =0; i<4; i++) {
			freeCells[i].clear();
			homeCells[i].clear();
		}
		for (TableauCell cell : tableauCells) {
			cell.clear();
		}
		deck = new Deck();
		deck.shuffle();
		this.deal();
		moveCount = 0;
		gamesPlayed += 1;
		hasBeenWon = false;
	}
	
	public void deal() {
		for (int i = 0; i < 8; i++) {
			for (int r = 0 ; r < 6; r++) {
				Card card = deck.deal();
				card.turn();
				tableauCells[i].add(card);
			}
		}
		for (int i = 0; i < 4; i++) {
			Card card = deck.deal();
			card.turn();
			tableauCells[i].add(card);
		}
	}

	public boolean makeMove(CellInterface fromCell, CellInterface toCell) {
		if (fromCell.move(toCell)){
			if (!winner()) {
				moveCount += 1;
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	public int getMoveCount() {
		return moveCount;
	}
	
	public int getGamesPlayed() {
		return gamesPlayed;
	}
	
	public int getWinCount() {
		return wins;
	}
	
	public float getWinRate() {
		return ((float) wins) / gamesPlayed;
	}
	
	public int getLeastMoves() {
		return leastMoves;
	}
	
	public String toString() {
		String result= "";
		for (FreeCell cell : freeCells) {
			result += "F" + cell.toString() +"\n";
		}
		for (HomeCell cell : homeCells) {
			result += "H" + cell.toString() +"\n";
		}
		for (TableauCell cell : tableauCells) {
			result += "T" + cell.toString() +"\n";
		}
		return result;
	}
	
	public boolean winner() {
		for (TableauCell cell : tableauCells) {
			if (! cell.inOrder())
			{return false;}
		}
		if (leastMoves == 0) {
			leastMoves = moveCount;
		}
		else {
			if (moveCount < leastMoves) {
				leastMoves = moveCount;
			}
		}
		if (!hasBeenWon) {
			wins += 1;
		}
		hasBeenWon = true;
		return true;
	}
	
	public boolean loser() {
		for (int i = 0; i < 4; i++) {
			if (freeCells[i].isEmpty())
				return false;
		}
		
		for (int i = 0; i < 8; i++) {
			if (tableauCells[i].isEmpty())
				return false;
		}
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (homeCells[j].canMoveFrom(freeCells[i])) {
					return false;
				}
			}
			for (int j = 0; j < 8; j++) {
				if (tableauCells[j].canMoveFrom(freeCells[i])) {
					return false;
				}
			}
		}
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 4; j++) {
				if (homeCells[j].canMoveFrom(tableauCells[i])) {
					return false;
				}
				if (freeCells[j].canMoveFrom(tableauCells[i])) {
					return false;
				}
			}
			for (int j = 0; j < 8; j++) {
				if (tableauCells[j].canMoveFrom(tableauCells[i])) {
					return false;
				}
			}
		}
		return true;
	}
}
