/**
 * project7
 * An tester class for the cells and freecell game.
 * @author Maxwell
 * @author Pan
 * @author Annjoy
 * @author Zander
 * @version 1.0
 */
public class TestGame {
	
	private static FreeCellGame game;
	
	private static FreeCell testFreeCell = new FreeCell();
	private static HomeCell testHomeCell = new HomeCell();
	private static TableauCell testTableauCell1 = new TableauCell();
	private static TableauCell testTableauCell2 = new TableauCell();
	private static Deck deck = new Deck();
	
	public static void main(String[] args) {
		game = new FreeCellGame();
		
		System.out.println("Test Moves");
				
		Card spadeAce = new Card(Suit.spade,1);
		System.out.println("\n" + spadeAce + " added to test tableau 1");
		testTableauCell1.add(spadeAce);
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);
		
		System.out.println("\nMove ace to home cell, should be true: " + game.makeMove(testTableauCell1, testHomeCell));
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);
		
		System.out.println("\nMove ace to tableau 1 cell, should be false: " + game.makeMove(testHomeCell, testTableauCell1));
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);
		
		System.out.println("\nMove ace to free cell, should be false: " + game.makeMove(testHomeCell, testFreeCell));
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);
		
		Card spadeTwo = new Card(Suit.spade,2);
		Card spadeThree = new Card(Suit.spade,3);
		System.out.println("\n" + spadeTwo +" and " + spadeThree + " added to test tableau 1");
		testTableauCell1.add(spadeTwo);
		testTableauCell1.add(spadeThree);
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);
		
		System.out.println("\nTableau 1 in order should be false: " + testTableauCell1.inOrder());
		
		System.out.println("\nMove three to free cell, should be true: " + game.makeMove(testTableauCell1, testFreeCell));
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);
		
		System.out.println("\nMove two to free cell, should be false: " + game.makeMove(testTableauCell1, testFreeCell));
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);
		
		System.out.println("\nMove three to tableau 1 cell, should be false: " + game.makeMove(testFreeCell, testTableauCell1));
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);
		
		System.out.println("\nMove three to home cell, should be false: " + game.makeMove(testFreeCell, testHomeCell));
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);
		
		System.out.println("\nMove two to home cell, should be true: " + game.makeMove(testTableauCell1, testHomeCell));
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);
		
		System.out.println("\nMove three to tableau 1 cell, should be true: " + game.makeMove(testFreeCell, testTableauCell1));
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);
		
		System.out.println("\nMove three to free cell, should be true: " + game.makeMove(testTableauCell1, testFreeCell));
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);
		
		System.out.println("\nMove three to home cell, should be true: " + game.makeMove(testFreeCell, testHomeCell));
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);

		Card clubTwo = new Card(Suit.club,2);
		Card heartThree = new Card(Suit.heart,3);
		System.out.println("\n" + clubTwo +" and " + heartThree + " added to test tableau 1");
		testTableauCell1.add(clubTwo);
		testTableauCell1.add(heartThree);
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);

		System.out.println("\nTableau 1 in order should be false: " + testTableauCell1.inOrder());

		System.out.println("\nMove three to tableau 2 cell, should be true: " + game.makeMove(testTableauCell1, testTableauCell2));
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);
		
		System.out.println("\nMove three to free cell, should be true: " + game.makeMove(testTableauCell2, testFreeCell));
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);

		System.out.println("\nMove three to tableau 1 cell, should be false: " + game.makeMove(testFreeCell, testTableauCell1));
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);

		System.out.println("\nMove three to home cell, should be false: " + game.makeMove(testFreeCell, testHomeCell));
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);

		System.out.println("\nMove three to tableau 2 cell, should be true: " + game.makeMove(testFreeCell, testTableauCell2));
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);

		System.out.println("\nMove two to tableau 2 cell, should be true: " + game.makeMove(testTableauCell1, testTableauCell2));
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);

		System.out.println("\nMove both to tableau 1 cell, should be true: " + game.makeMove(testTableauCell2, testTableauCell1));
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);

		System.out.println("\nMove both to tableau 1 cell, should be true: " + game.makeMove(testTableauCell1, testTableauCell2));
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);
		
		System.out.println("\nTableau 2 in order should be true: " + testTableauCell2.inOrder());
		
		Card spadeEight = new Card(Suit.spade,8);
		Card clubFour = new Card(Suit.club,4);
		Card heartFive = new Card(Suit.heart,5);
		System.out.println("\n" + spadeEight + " and " + heartFive + " and " + clubFour + " added to test tableau 1");
		testTableauCell1.add(spadeEight);
		testTableauCell1.add(heartFive);
		testTableauCell1.add(clubFour);
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);

		System.out.println("\nTableau 1 in order from index 0 should be false: " + testTableauCell1.inOrder());
		
		System.out.println("\nTableau 1 in order from index 1 should be true: " + testTableauCell1.inOrder(1));
		
		System.out.println("\nMove stack to tableau 1 cell, should be true: " + game.makeMove(testTableauCell2, testTableauCell1));
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);
		
		System.out.println("\nMove stack to tableau 2 cell, should be true: " + game.makeMove(testTableauCell1, testTableauCell2));
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);

		System.out.println("\nMove stack to tableau 1 cell, should be false: " + game.makeMove(testTableauCell2, testTableauCell1));
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);

		Card clubAce = new Card(Suit.club,1);
		System.out.println("\nClear home cell and add " + clubAce);
		testHomeCell.clear();
		testHomeCell.add(clubAce);
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);

		System.out.println("\nMove two to home cell, should be true: " + game.makeMove(testTableauCell2, testHomeCell));
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);

		Card diamondFive = new Card(Suit.diamond,5);
		System.out.println("\nForcibly add " + diamondFive + " to tableau 1");
		testTableauCell1.add(diamondFive);
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);

		System.out.println("\nMove stack to tableau 1 cell, should be true: " + game.makeMove(testTableauCell2, testTableauCell1));
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);

		System.out.println("\nMove stack to tableau 2 cell, should be true: " + game.makeMove(testTableauCell1, testTableauCell2));
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);

		Card spadeFour = new Card(Suit.spade,4);
		System.out.println("\nForcibly add " + spadeFour + " to tableau 1");
		testTableauCell1.add(spadeFour);
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);

		System.out.println("\nMove stack to tableau 1 cell, should be true: " + game.makeMove(testTableauCell2, testTableauCell1));
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);

		System.out.println("\nMove stack to tableau 2 cell, should be true: " + game.makeMove(testTableauCell1, testTableauCell2));
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);

		System.out.println("\nMove stack to itself, should be false: " + game.makeMove(testTableauCell1, testTableauCell1));
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);

		Card spadeFive = new Card(Suit.spade,5);
		System.out.println("\n" + spadeFive + " added to free cell");
		testFreeCell.add(spadeFive);
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);

		System.out.println("\nMove five to itself, should be false: " + game.makeMove(testFreeCell, testFreeCell));
		System.out.println("\nFree: " + testFreeCell +  "\nHome: " + testHomeCell + "\nTableau 1: " + testTableauCell1 + "\nTableau 2: " + testTableauCell2);
		
		System.out.println("\nTest Game");
		
		System.out.println(game.toString());
		System.out.println("Tab to other tab, could be true or false, likely false (but cards dealt are random): " + game.makeMove(game.getTableau(0), game.getTableau(1)));
		System.out.println(game.toString());
		System.out.println("Tab to free, should be true: " + game.makeMove(game.getTableau(0), game.getFree(0)));
		System.out.println(game.toString());
		System.out.println("Tab to same free, should be false: " + game.makeMove(game.getTableau(0), game.getFree(0)));
		System.out.println(game.toString());
		System.out.println("Free to other free, should be true: " + game.makeMove(game.getFree(0), game.getFree(1)));
		System.out.println(game.toString());
		System.out.println("Tab to home, could be true or false, likely false (but cards dealt are random): " + game.makeMove(game.getTableau(0), game.getHome(0)));
		System.out.println(game.toString());
		System.out.println("New Game");
		game.newGame();
		System.out.println(game.toString());

		System.out.println("Forcibly make game winnable, to test game.winner():");
		for (int i = 0; i < 8; i++) {
			game.getTableau(i).clear();
		}
		
		game.getHome(0).add(new Card(Suit.heart, 1));
		game.getHome(1).add(new Card(Suit.spade, 1));
		game.getHome(2).add(new Card(Suit.club, 1));
		game.getHome(3).add(new Card(Suit.diamond, 1));
		
		Suit suit;
		for (int i = 13; i > 1; i--) {
			if (i % 2 == 0) {
				suit = Suit.spade;
				}
			else {
				suit = Suit.heart;
				}
			game.getTableau(0).add(new Card(suit, i));
			}
		
		for (int i = 13; i > 1; i--) {
			if (i % 2 == 0) {
				suit = Suit.heart;
				}
			else {
				suit = Suit.spade;
				}
			game.getTableau(1).add(new Card(suit, i));
			}
		
		for (int i = 13; i > 1; i--) {
			if (i % 2 == 0) {
				suit = Suit.diamond;
				}
			else {
				suit = Suit.club;
				}
			game.getTableau(2).add(new Card(suit, i));
			}
		
		game.getTableau(3).add(new Card(Suit.club, 2));
		game.getTableau(3).add(new Card(Suit.diamond, 3));
		
		for (int i = 13; i > 3; i--) {
			if (i % 2 == 0) {
				suit = Suit.club;
				}
			else {
				suit = Suit.diamond;
				}
			game.getTableau(3).add(new Card(suit, i));
			}
		
		System.out.println(game.toString());
		
		System.out.println("Winner should be false: " + game.winner());
		
		System.out.println("\nMove stack of diamond king to tableau 4, should be true: " + game.makeMove(game.getTableau(3), game.getTableau(4)));
		
		System.out.println(game.toString());
		
		System.out.println("Winner should be false: " + game.winner());
		
		System.out.println("\nMove three to tableau 5, should be true: " + game.makeMove(game.getTableau(3), game.getTableau(5)));
		
		System.out.println(game.toString());
		
		System.out.println("Winner should be true: " + game.winner());
		
		System.out.println("\nMove two to tableau 5, should be true: " + game.makeMove(game.getTableau(3), game.getTableau(5)));
		
		System.out.println(game.toString());
		
		System.out.println("Winner should be true: " + game.winner());
		
		System.out.println("\nMove stack to tableau 4, should be true: " + game.makeMove(game.getTableau(5), game.getTableau(4)));
		
		System.out.println(game.toString());
		
		System.out.println("Winner should be true: " + game.winner());
		
		System.out.println("\nMove stack to tableau 3, should be true: " + game.makeMove(game.getTableau(4), game.getTableau(3)));
		
		System.out.println(game.toString());
		
		System.out.println("Winner should be true: " + game.winner());
		
		System.out.println("\nMove a two to its home, should be true: " + game.makeMove(game.getTableau(1), game.getHome(0)));
		
		System.out.println(game.toString());
		
		System.out.println("Winner should be true: " + game.winner());
		
		System.out.println("\nForcibly make game unwinnable, to test game.loser():");
		game.newGame();
		for (int i = 0; i < 8; i++) {
			game.getTableau(i).clear();
		}
		
		Card card = new Card(Suit.spade, 1);
		game.getTableau(3).add(card);
		
		for (int i = 0; i < 6; i++) {
			for (int r = 0 ; r < 8; r++) {
				game.getTableau(r).add(deck.deal());
			}
		}
		for (int i = 0; i < 4; i++) {
			game.getTableau(i).add(deck.deal());
		}
		
		game.getTableau(3).pop();
		
		System.out.println(game.toString());
		
		System.out.println("Loser should be false: " + game.loser());
		
		System.out.println("\nMove cards to free cells:");
		
		for (int i = 0; i < 3; i++) {
			game.makeMove(game.getTableau(i), game.getFree(i));
		}
		
		game.makeMove(game.getTableau(7), game.getFree(3));
		
		System.out.println(game.toString());
		
		System.out.println("Loser should be true: " + game.loser());
		
		}
		
	}


