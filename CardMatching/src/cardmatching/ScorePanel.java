//***************************************************************************
//File: ScorePanel.java
//
//Purpose: To create the score panel. Keeps track of the
//		highest score, the champion Player and updates it appropriately
//		whenever a Player surpasses the Champion.
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

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScorePanel extends JPanel
{
	//Attributes
	private JLabel m_highestLBL, m_championLBL, m_blank1, m_blank2;
	
	public ScorePanel()
	{
		setLayout(new GridLayout(1,4));
		
		m_highestLBL = new JLabel("Highest Score");
		m_highestLBL.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
				
		m_championLBL = new JLabel("Champion");
	}
}
