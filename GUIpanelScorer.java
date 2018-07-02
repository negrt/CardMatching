//***************************************************************************
//File: GUIpanelScorer.java
//
//Purpose: To create the Scorer Panel. The Scorer class keeps track of the
//		highest score, the champion Player and updates it appropriately
//		whenever a Player surpasses the Champion.
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

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUIpanelScorer extends JPanel
{
	//Attributes
	private JLabel m_highestLBL, m_championLBL, m_blank1, m_blank2;
	
	public GUIpanelScorer()
	{
		setLayout(new GridLayout(1,4));
		
		m_highestLBL = new JLabel("Highest Score");
		m_highestLBL.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
				
		m_championLBL = new JLabel("Champion");
	}
}
