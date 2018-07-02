//***************************************************************************
//File: GUIframeCardGame.java
//
//Purpose: The GUIframeCardGame
//
//Written By: Timothy Negron
//
//Compilers: Eclipse Java Oxygen
//		   
//Update Information
//------------------
//
//Name:
//Date:
//Description: 
//
//***************************************************************************

package guiCardGame;

import java.awt.GridLayout;
import javax.swing.JFrame;

public class GUIframeCardGame extends JFrame
{
	//Attributes
	private GUIpanelCardGame m_GUIpanelCardGame;
	private GUIpanelScorer m_GUIpanelScorer;
	
	//***************************************************************************
	//Method: GUIpanelCardGame()
	//
	//Purpose: To respond to users click on any button displayed on the frame.
	//			   
	//***************************************************************************
	
	public GUIframeCardGame()
	{
		//Customize
		super.setTitle("Match the Cards.");
		setLayout(new GridLayout(1, 1));
		setSize(1300, 1200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Initialize
		m_GUIpanelCardGame = new GUIpanelCardGame();
		//m_GUIpanelScorer = new GUIpanelScorer();
		
		//Add
		add(m_GUIpanelCardGame);
		//add(m_GUIpanelScorer);
		
		//SetVisibility
		setVisible(true);
	}
}
