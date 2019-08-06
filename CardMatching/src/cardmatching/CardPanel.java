//***************************************************************************
//File: CardPanel.java
//
//Purpose: The card panel creates a class that extends from JPanel
//		and will contain JTextFields, JButtons, JLabels. Action Listener 
//		interface is implemented. This file also has the necessary methods to
//		make the necessary calculations for the game to run. This file also
//		utilizes the Card.java file/class for the JButtons in the game.
//
//Written By: Timothy Negron
//
//Compilers: Eclipse
//		   
//Update Information
//------------------
//
//***************************************************************************

package cardmatching;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CardPanel extends JPanel implements ActionListener
{
	// Attributes
	// Row 1
	private JLabel m_titleLBL[][] = new JLabel[1][4];
	// Row 2
	private JTextField m_gamerTagTF;
	private JButton m_resetBTN, m_continueBTN, m_startBTN;
	// Row 3-5	
	public Card m_cards[][] = new Card[3][4];
	// Row6
	private JLabel m_statusLBL, m_matchesLBL, m_attemptsLBL, m_scoreLBL;
	// Row 7
	private JButton m_endGameBTN, m_noBTN, m_yesBTN;
	private JLabel m_areYouSureLBL;
	
	// Other Attributes
	public final static int NUM_OF_CARDS = 6;
	public final static int NUM_OF_ROWS = 3;
	public final static int NUM_OF_COLS = 4;
	private int m_numOfFlips = 0;
	private int m_lineNumber = 0;
	private boolean m_setAttempt = true;
	private double m_numOfAttempts = 0.0;
	private double m_numOfMatches = 0.0;
	
	// For Random Image Method & Reset Method
	private int selected1 = 0, selected2 = 0, selected3 = 0, selected4 = 0, selected5 = 0, selected6 = 0;
	
	// THINKING ABOUT ADDING...
	// private GUIpanelScorer m_GUIpanelScorer;
	
	//***************************************************************************
	//Method: GUIpanelCardGame()
	//
	//Purpose: To respond to users click on any button displayed on the frame.
	//			   
	//***************************************************************************
	
	public CardPanel()
	{		
		setLayout(new GridLayout(7, 4));	
		
		/********************************************************************************
		 ************
		 *Initialize*
		 ************
		 ********************************************************************************/
		
		// Row 1
		m_titleLBL[0][0] = new JLabel("Memory");
		m_titleLBL[0][0].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
		m_titleLBL[0][0].setHorizontalAlignment(JLabel.RIGHT);
		m_titleLBL[0][1] = new JLabel("Matching");
		m_titleLBL[0][1].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
		m_titleLBL[0][1].setHorizontalAlignment(JLabel.CENTER);
		m_titleLBL[0][2] = new JLabel("Game!");
		m_titleLBL[0][2].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
		m_titleLBL[0][2].setHorizontalAlignment(JLabel.LEFT);
		m_titleLBL[0][3] = new JLabel("BCS345 Project");
		m_titleLBL[0][3].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		m_titleLBL[0][3].setHorizontalAlignment(JLabel.CENTER);
		
		// Row 2
		m_resetBTN = new JButton("Reset");
		m_resetBTN.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		m_resetBTN.setEnabled(false);
		m_resetBTN.setHorizontalAlignment(JLabel.CENTER);
		m_resetBTN.addActionListener(this);
		m_gamerTagTF = new JTextField("GamerTag");
		m_gamerTagTF.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		m_gamerTagTF.setHorizontalAlignment(JTextField.CENTER);
		m_startBTN = new JButton("Start");
		m_startBTN.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		m_startBTN.addActionListener(this);
		m_continueBTN = new JButton("Continue");
		m_continueBTN.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		m_continueBTN.setEnabled(false);
		m_continueBTN.addActionListener(this);
		
		// Row 3-5
		String imagePath;
		for(int row = 0; row < NUM_OF_ROWS; row++)
		{
			for(int col = 0; col < NUM_OF_COLS; col++)
			{
				imagePath = randomImagePathMethod(); 
				
				m_cards[row][col] = new Card(imagePath);
				m_cards[row][col].setIcon(m_cards[row][col].hideCard());
				m_cards[row][col].addActionListener(this);
				m_cards[row][col].setEnabled(false);
			}
		}
		
		// Row 6
		m_statusLBL = new JLabel("Status");
		m_statusLBL.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
		m_statusLBL.setHorizontalAlignment(JLabel.CENTER);
		m_matchesLBL = new JLabel("Number Of Matches");
		m_matchesLBL.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
		m_matchesLBL.setHorizontalAlignment(JLabel.CENTER);
		m_attemptsLBL = new JLabel("Number of Attempts");
		m_attemptsLBL.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
		m_attemptsLBL.setHorizontalAlignment(JLabel.CENTER);
		m_scoreLBL = new JLabel("Score");
		m_scoreLBL.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
		m_scoreLBL.setHorizontalAlignment(JLabel.CENTER);
		
		// Row 7
		m_endGameBTN = new JButton("End Game");
		m_endGameBTN.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		m_endGameBTN.setEnabled(false);
		m_endGameBTN.addActionListener(this);
		m_areYouSureLBL = new JLabel("-");
		m_areYouSureLBL.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		m_areYouSureLBL.setHorizontalAlignment(JLabel.CENTER);
		m_noBTN = new JButton("-");
		m_noBTN.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		m_noBTN.setEnabled(false);
		m_noBTN.addActionListener(this);
		m_yesBTN = new JButton("-");
		m_yesBTN.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		m_yesBTN.setEnabled(false);
		m_yesBTN.addActionListener(this);
		
		// m_GUIpanelScorer = new GUIpanelScorer();
		
		/***************************************************************************
		 ************
		 ***Adding***
		 ************
		 ************
		 **************************************************************************/
		
		// Row 1
		for(int col = 0; col < NUM_OF_COLS; col++)
		{
			add(m_titleLBL[0][col]);
		}
		
		// Row 2
		add(m_startBTN); add(m_gamerTagTF); add(m_continueBTN); add(m_resetBTN);
		
		// Row 3-5
		for(int row = 0; row < NUM_OF_ROWS; row++)
		{
			for(int col = 0; col < NUM_OF_COLS; col++)
			{
				add(m_cards[row][col]);
			}
		}
		
		// Row 6
		add(m_attemptsLBL); add(m_matchesLBL); add(m_scoreLBL); add(m_statusLBL); 
		
		// add(m_GUIpanelScorer);
		
		// Row 7
		add(m_endGameBTN);add(m_areYouSureLBL);add(m_yesBTN);add(m_noBTN); 
		
	}

	//***************************************************************************
	//Method: actionPerformed()
	//
	//Purpose: To respond to users click on any button displayed on the frame.
	//			   
	//***************************************************************************

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		JButton btnCLICKED = (JButton)e.getSource();
		
		if(btnCLICKED.equals(m_resetBTN))
		{
			System.out.println(++m_lineNumber+". Reset Button Clicked");
			//resetGameMethod(); //resetGameMethod() called here.
		}
		else if(btnCLICKED.equals(m_startBTN))
		{
			System.out.println(++m_lineNumber+". Start Button Clicked");
			startMethod();//startMethod() called here.
		}
		else if(btnCLICKED.equals(m_continueBTN))
		{
			System.out.println(++m_lineNumber+". Continue Button Clicked");
			continueGameMethod();//continueGameMethod() called here.
		}
		else if(btnCLICKED.equals(m_endGameBTN))
		{
			System.out.println(++m_lineNumber+". End Game Button Clicked");
			areYouSureMethod();//areYouSureMethod() called here.
		}
		else if(btnCLICKED.equals(m_yesBTN))
		{
			System.out.println(++m_lineNumber+". Clicked YES To End Game");
			endGameMethod();//endGameMethod() called here.
		}
		else if(btnCLICKED.equals(m_noBTN))
		{
			System.out.println(++m_lineNumber+". Clicked NO To Not End Game");
			dontEndGameMethod();//dontEndGameMethod() called here.
		}
		else
		{		
			System.out.println(++m_lineNumber+". A Card Was Selected");	
			
			if(m_numOfFlips == 0 || m_numOfFlips == 1)
			{
				for(int row = 0; row < NUM_OF_ROWS; row++)
				{
					for(int col = 0; col < NUM_OF_COLS; col++)
					{
						if(m_cards[row][col] == btnCLICKED && m_cards[row][col].getCardFlipped() == false)
						{
							if(!m_cards[row][col].getFoundMatch())
							{
								m_cards[row][col].setIcon(m_cards[row][col].showCard());
								m_cards[row][col].setCardFlipped(true);
								m_numOfFlips++;
							}
						}
					}
				}
			}
			
			if(m_numOfFlips == 2)
			{
				m_continueBTN.setEnabled(true);
			}
		}
	}
	
	//***************************************************************************
	//Method: continueGameMethod()
	//
	//Purpose: If two cards have been selected and they don't match, this method
	//		   will flip the two cards back.
	//			   
	//***************************************************************************
	
	public void continueGameMethod()
	{
		if(m_numOfFlips == 2)
		{
			if(checkForMatchMethod())//checkForMatchMethod() called here.
			{
				m_numOfAttempts++;
				m_numOfMatches++;
				updateLabelsMethod();//updateLabelsMethod() called here.
			}
			else if(m_setAttempt)
			{
				m_numOfAttempts++;
				updateLabelsMethod();//updateLabelsMethod() called here.
			}
		}
		
		if(m_numOfFlips == 2)
		{
			for(int row = 0; row < NUM_OF_ROWS; row++)
			{
				for(int col = 0; col < NUM_OF_COLS; col++)
				{
					if(!m_cards[row][col].getFoundMatch())
					{
						m_cards[row][col].setCardFlipped(false);
						m_cards[row][col].setIcon(m_cards[row][col].hideCard());
					}
				}
			}
			
			m_continueBTN.setEnabled(false);
			
			m_numOfFlips = 0;
			System.out.println(++m_lineNumber+". Continue Game Method Executed");
		}
	}
	
	//***************************************************************************
	//Method: checkForMatchMethod()
	//
	//Purpose: Checks every button to see if there is a match. This method is
	//		   called inside the continueGameMethod().
	//			   
	//***************************************************************************
	
	public boolean checkForMatchMethod()
	{	
		for(int row = 0; row < NUM_OF_ROWS; row++)
		{
			for(int col = 0; col < NUM_OF_COLS; col++)
			{
				for(int oRow = 0; oRow < NUM_OF_ROWS; oRow++)
				{
					for(int oCol = 0; oCol < NUM_OF_COLS; oCol++)
					{
						if(m_cards[row][col] != m_cards[oRow][oCol])
						{
							if(!m_cards[row][col].getFoundMatch())
							{
								if(!m_cards[oRow][oCol].getFoundMatch())
								{
									if(m_cards[row][col].equals(m_cards[oRow][oCol]))
									{
										m_cards[row][col].setFoundMatch(true);
										m_cards[oRow][oCol].setFoundMatch(true);
										m_cards[row][col].setCardFlipped(false);
										m_cards[oRow][oCol].setCardFlipped(false);
										System.out.println(++m_lineNumber+". Check For Match Method Executed - Return True");
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		m_setAttempt = true;
		System.out.println(++m_lineNumber+". Check For Match Method Executed - Returned False");
		return false;
	}
	
	//***************************************************************************
	//Method: calculateScoreMethod()
	//
	//Purpose: To calculate the players score.
	//			   
	//***************************************************************************
	
	public double calculateScoreMethod()
	{
		System.out.println(++m_lineNumber+". Calculate Score Method Called");
		
		try
		{
			return Math.round((m_numOfMatches / m_numOfAttempts) * 100);
		}
		catch(ArithmeticException e)
		{
			return 0.0;
		}
	}
	
	//***************************************************************************
	//Method: updateLabelsMethod()
	//
	//Purpose: This method is called every time an attempt is made. An attempt is
	//		   made after the continue button has been press, therefore, this
	//		   method is called in the continueGameMethod() method.
	//			   
	//***************************************************************************
	
	public void updateLabelsMethod()
	{
		m_scoreLBL.setForeground(Color.BLUE);
		
		m_scoreLBL.setText("Score: "+ calculateScoreMethod());//calculateScoreMethod() called here.
		m_matchesLBL.setText("Matches: "+ m_numOfMatches);
		m_attemptsLBL.setText("Attempts: "+ m_numOfAttempts);
		m_statusLBL.setText("Status: "+ accessScoreMethod());//accessScoreMethod() called here.
		
		System.out.println(++m_lineNumber+". Found Match Method Executed");
	}
	
	//***************************************************************************
	//Method: areYouSureMethod()
	//
	//Purpose: To prompt the user if they really would like to end the game.
	//			   
	//***************************************************************************
	
	public void areYouSureMethod()
	{		
		m_continueBTN.setEnabled(false);
		m_endGameBTN.setEnabled(false);
		
		for(int row = 0; row < NUM_OF_ROWS; row++)
		{
			for(int col = 0; col < NUM_OF_COLS; col++)
			{
				m_cards[row][col].setEnabled(false);
			}
		}
				
		m_yesBTN.setEnabled(true);
		m_noBTN.setEnabled(true);
		m_yesBTN.setText("Yes");
		m_noBTN.setText("No");
		m_areYouSureLBL.setText("Are You Sure?");
		m_areYouSureLBL.setForeground(Color.RED);
		
		System.out.println(++m_lineNumber+". Are You Sure Method Executed");
	}
	
	//***************************************************************************
	//Method: dontEndGameMethod()
	//
	//Purpose: To set everything back to normal after user decides not to end the
	//		   game. This method is called when the user decides not to end the
	//		   game.
	//			   
	//***************************************************************************
	
	public void dontEndGameMethod()
	{
		m_endGameBTN.setEnabled(true);
		
		for(int row = 0; row < NUM_OF_ROWS; row++)
		{
			for(int col = 0; col < NUM_OF_COLS; col++)
			{
				m_cards[row][col].setEnabled(true);
			}
		}
				
		m_yesBTN.setEnabled(false);
		m_noBTN.setEnabled(false);
		m_yesBTN.setText("-");
		m_noBTN.setText("-");
		m_areYouSureLBL.setText("-");
		m_areYouSureLBL.setForeground(Color.BLACK);
		
		System.out.println(++m_lineNumber+". Dont End Game Method Executed");
	}
	
	//***************************************************************************
	//Method: endGameMethod()
	//
	//Purpose: To end the game. Calls the accessScoreMethod().
	//
	//		---Will eventually be responsible for storing data into a file.
	//			   
	//***************************************************************************
	
	public void endGameMethod()
	{
		for(int row = 0; row < NUM_OF_ROWS; row++)
		{
			for(int col = 0; col < NUM_OF_COLS; col++)
			{
				m_cards[row][col].setEnabled(false);
				m_cards[row][col].setIcon(m_cards[row][col].hideCard());
			}
		}
		m_continueBTN.setEnabled(false);
		m_endGameBTN.setEnabled(false);
		m_yesBTN.setEnabled(false);
		m_noBTN.setEnabled(false);
		m_yesBTN.setText("-");
		m_noBTN.setText("-");
		m_areYouSureLBL.setText("-");
		m_areYouSureLBL.setForeground(Color.BLACK);
		m_resetBTN.setEnabled(true);
		
		m_scoreLBL.setForeground(Color.BLACK);;
		
		m_attemptsLBL.setText("You're");
		m_matchesLBL.setText("Score"); 
		m_scoreLBL.setText("Was");
		m_statusLBL.setText(accessScoreMethod());//accessScoreMethod() called here.
		
		
		selected1 = 0; selected2 = 0; selected3 = 0;
		selected4 = 0; selected5 = 0; selected6 = 0;
		
		System.out.println(++m_lineNumber+". End Game Method Executed");
		
		//System.exit(0);
	}
	
	//***************************************************************************
	//Method: accessScoreMethod()
	//
	//Purpose: This method is called within the endGameMethod() method. This
	//		   happens when the user decides to end the game and clicks the yes
	//		   button.
	//			   
	//***************************************************************************
	
	public String accessScoreMethod()
	{
		System.out.println(++m_lineNumber+". Access Score Method Called");
		
		double score = calculateScoreMethod();
		
		if(score > 97)
		{
			return "Amazing";
		}
		else if(score > 80)
		{
			return "Excellent";
		}
		else if(score > 60)
		{
			return "OK";
		}
		else if(score > 30)
		{
			return "Lacking";
		}
		else if(score > 10)
		{
			return "Suffering";
		}
		else if(score >= 0)
		{
			return "Really Bad";
		}
		
		return "Negative";
	}
	
	//***************************************************************************
	//Method: startMethod()
	//
	//Purpose: To allow the player to start playing. 
	//
	//		----Will eventually be responsible for creating player objects.
	//			   
	//***************************************************************************
	
	public void startMethod()
	{
		for(int row = 0; row < NUM_OF_ROWS; row++)
		{
			for(int col = 0; col < NUM_OF_COLS; col++)
			{
				m_cards[row][col].setEnabled(true);
			}
		}
		
		m_gamerTagTF.setEnabled(false);
		m_endGameBTN.setEnabled(true);
		m_startBTN.setEnabled(false);
		
		System.out.println(++m_lineNumber+". Start Method Executed");
	}
	
	//***************************************************************************
	//Method: randomImagePath()
	//
	//Purpose: To pass a string containing a randomly selected image to assign
	//		   to a JButton. If an image has been selected twice, it will no 
	//		   longer be able to be selected again until a new game starts.
	//		   This method is called in the constructor.
	//
	//		---This method will eventually be called in the reset game button.
	//			   
	//***************************************************************************
	
	public String randomImagePathMethod()
	{
		
		String imagePath = null;
		int randomNumber;
		
		do
		{
			randomNumber = (int)(Math.random()*6)+1;
			
			switch(randomNumber)
			{
				case 1: if(selected1 != 2){
						imagePath = "img/mario.png";
						selected1++;}
						break;

				case 2: if(selected2 != 2){
						imagePath = "img/cap.png";
						selected2++;}
						break;
				
				case 3: if(selected3 != 2){
						imagePath = "img/batman.png";
						selected3++;}
						break;
				
				case 4: if(selected4 !=2){
						imagePath = "img/code.jpg";
						selected4++;}
						break;
				
				case 5: if(selected5 !=2){
						imagePath = "img/aPlus.png";
						selected5++;}
						break;
			
				case 6: if(selected6 !=2){
						imagePath = "img/android.png";
						selected6++;}
						break;
			}
		}
		while(imagePath == null);
		
		System.out.println(++m_lineNumber+". Random Image Method Executed");
		
		return imagePath;
	}
}

//***************************************************************************
//Method: resetGameMethod()
//
//Purpose: To create a new game.
//			   
//***************************************************************************

//public void resetGameMethod()
//{
//	int counter = 0;
//	String imagePath;
//	
//	for(int row = 0; row < NUM_OF_ROWS; row++)
//	{
//		for(int col = 0; col < NUM_OF_COLS; col++)
//		{
//			m_cards[row][col].setEnabled(true);
//			imagePath = randomImagePathMethod();
//			m_cards[row][col].setCardFlipped(false);
//			m_cards[row][col].setIcon(m_cards[row][col].hideCard());
//			m_cards[row][col].setImagePath(imagePath);
//							
//		}
//	}
//
//	m_continueBTN.setEnabled(true);
//	m_endGameBTN.setEnabled(true);
//	m_resetBTN.setEnabled(false);
//	
//	System.out.println(++lineNumber+". Start Game Method Executed");
//}






























































