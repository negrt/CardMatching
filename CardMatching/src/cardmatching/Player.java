//***************************************************************************
//File: Player.java
//
//Purpose: To creates the Player class.
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

public class Player 
{
		//Attributes
		private String m_gamerTag;
		private int m_wins;
		private int m_losses;
		
		//Constructors
		public Player()
		{
			m_gamerTag = "None";
			m_wins = 0;
			m_losses = 0;
		}
		public Player(String name)
		{
			this();
			m_gamerTag = name;
		}
		
		//Getters
		public String getName()
		{
			return m_gamerTag;
		}
		public int getWins()
		{
			return m_wins;
		}
		public int getLosses()
		{
			return m_losses;
		}
		
		//Setters
		public void setGamertag(String gamertag)
		{
			m_gamerTag = gamertag;
		}
		public void setWins(int won)
		{
			m_wins = won;
		}
		public void setLosses(int lost)
		{
			m_losses = lost;
		}
}
