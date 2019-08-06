//***************************************************************************
//File: Frame.java
//
//Purpose: To create a window and mount panels for game.
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

import java.awt.GridLayout;
import javax.swing.JFrame;

public class Frame extends JFrame
{
	//Attributes
	private CardPanel m_GUIpanelCardGame;
	private ScorePanel m_GUIpanelScorer;
	
	//***************************************************************************
	//Method: GUIpanelCardGame()
	//
	//Purpose: To respond to users click on any button displayed on the frame.
	//			   
	//***************************************************************************
	
	public Frame()
	{
		//Customize
		super.setTitle("Match the Cards.");
		setLayout(new GridLayout(1, 1));
		setSize(1300, 1200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Initialize
		m_GUIpanelCardGame = new CardPanel();
		//m_GUIpanelScorer = new GUIpanelScorer();
		
		//Add
		add(m_GUIpanelCardGame);
		//add(m_GUIpanelScorer);
		
		//SetVisibility
		setVisible(true);
	}
}
