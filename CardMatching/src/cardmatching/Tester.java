//***************************************************************************
//File: Tester.java
//
//Purpose: To run the Memory Matching card game.
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

import javax.swing.SwingUtilities;

public class Tester 
{
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				new Frame();
			}
		});
	}
}
