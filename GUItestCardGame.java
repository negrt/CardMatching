//***************************************************************************
//File: GUItestCardGame.java
//
//Purpose: To run the Memory Matching card game.
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

import javax.swing.SwingUtilities;

public class GUItestCardGame 
{
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				new GUIframeCardGame();
			}
		});
	}
}
