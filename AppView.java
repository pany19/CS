/**
 * project7
 * Creates the graphics for the whole freecell game.
 * @author Maxwell
 * @author Pan
 * @author Annjoy
 * @author Zander
 * @version 1.0
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AppView extends JFrame{
	private TopCellPanel[] homeCellPanel = new TopCellPanel[4];
	private TopCellPanel[] freeCellPanel= new TopCellPanel[4];
	private BottomCellPanel[] tableauPanel = new BottomCellPanel[8];
	private FreeCellGame game;
	private CellPanel fromPanel;
	private AppViewInformer informer = new AppViewInformer();
	
	public AppView(FreeCellGame inputGame) {
		setTitle("The Game of FreeCell");
		game = inputGame;
				
		Container c = getContentPane();
		
		for(int i= 0; i<4; i++) {
			homeCellPanel[i] = new TopCellPanel(game.getHome(i), informer);
			freeCellPanel[i]= new TopCellPanel(game.getFree(i), informer);
			tableauPanel[i]= new BottomCellPanel(game.getTableau(i), informer);
			tableauPanel[i+4]= new BottomCellPanel(game.getTableau(i+4), informer);
		}
		JLabel freeCellLabel = new JLabel("Free Cells");
		JLabel homeCellLabel = new JLabel("Home Cells");
		freeCellLabel.setHorizontalAlignment(SwingConstants.CENTER);
		homeCellLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel buttonPanel = new JPanel();
		JButton newButton = new JButton("New Game");
		JButton statsButton = new JButton ("Stats");
		
		
		newButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.newGame();
				fromPanel = null;
				AppView.this.repaint();
			}
		});
		statsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String statString = String.format("Games Played: %d\nGames Won: %d\nWin Rate: %.2f\nCurrent Moves: %d\nFastest Win: %d", game.getGamesPlayed(), game.getWinCount(), game.getWinRate(), game.getMoveCount(), game.getLeastMoves());
				JOptionPane.showMessageDialog(c, statString);
			}
		});
		
				
		buttonPanel.add(newButton);
		buttonPanel.add(statsButton);
		
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		c.setLayout(layout);
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 4;
		layout.setConstraints(freeCellLabel,  constraints);
		c.add(freeCellLabel);
		
		constraints.gridx = 4;
		constraints.gridy = 0;
		constraints.gridwidth = 4;
		layout.setConstraints(homeCellLabel,  constraints);
		c.add(homeCellLabel);
		
		constraints.weightx = 1;
		constraints.weighty = 0.5;
		constraints.gridwidth = 1;
		constraints.gridy = 1;
		for(int i= 0; i<4; i++) {
			constraints.gridx = i;
			layout.setConstraints(freeCellPanel[i],  constraints);
			c.add(freeCellPanel[i]);
		}
		for(int i= 0; i<4; i++) {
			constraints.gridx = i+4;
			layout.setConstraints(homeCellPanel[i],  constraints);
			c.add(homeCellPanel[i]);
		}
		constraints.weighty = 1;
		constraints.gridy = 2;
		for(int i= 0; i<8; i++) {
			constraints.gridx = i;
			layout.setConstraints(tableauPanel[i],  constraints);
			c.add(tableauPanel[i]);
		}
		constraints.weighty = 0;
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 8;
		layout.setConstraints(buttonPanel,  constraints);
		c.add(buttonPanel);
		
	}
	
	private class AppViewInformer implements ViewInformer {
		public void panelPressed(CellPanel panel) {
			if (fromPanel == null) {
				fromPanel = panel;
			}
			else if (fromPanel.equals(panel)) {
				fromPanel = null;
			}
			else {
				if (! game.makeMove(fromPanel.getCell(), panel.getCell())) {
					JOptionPane.showMessageDialog(AppView.this, "Illegal move");
				}
				else {
					fromPanel.repaint();
					panel.repaint();
					if (game.winner()) {
					int reply = JOptionPane.showConfirmDialog(AppView.this, "You win! Do you want to play again?",
							    "Winner!",
							    JOptionPane.YES_NO_OPTION);
						if (reply == JOptionPane.YES_OPTION) {
									game.newGame();
									fromPanel = null;
									AppView.this.repaint();						
							}									        
					        else {
					           JOptionPane.showMessageDialog(null, "GOODBYE");
					           System.exit(0);}	
					}
					else if (game.loser()) {
						JOptionPane.showMessageDialog(AppView.this, "There are no more possible moves");
					}
				}
				fromPanel = null;
			}
		}
		
	}

}
