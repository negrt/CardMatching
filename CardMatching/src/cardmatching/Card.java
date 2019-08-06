//***************************************************************************
//File: Card.java
//
//Purpose: The Card.java creates the Card class that extends from JButton to
//		give the ability to be a JButton in the memory matching card game.
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

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Card extends JButton
{
	// Attributes
	ImageIcon m_imageIcon, m_unFlipped;
	String m_imagePath;
	boolean m_cardFlipped, m_foundMatch;
	
	// Constructors
	public Card()
	{
		m_imageIcon = null;
		m_imagePath = null;
		m_unFlipped = new ImageIcon("img/java.jpg");
		m_cardFlipped = false;
		m_foundMatch = false;
	}
	public Card(String imagePath)
	{
		this();
		m_imagePath = imagePath;
		m_imageIcon = new ImageIcon(m_imagePath);
	}
	
	// Setters
	public void setImageIcon(String imagePath)
	{
		m_imageIcon = new ImageIcon(imagePath);
	}
	public void setImagePath(String imagePath)
	{
		m_imagePath = imagePath;
	}
	public void setCardFlipped(boolean b)
	{
		m_cardFlipped = b;
	}
	public void setFoundMatch(boolean b)
	{
		m_foundMatch = b;
	}
	
	// Getters
	public ImageIcon getImageIcon()
	{
		return m_imageIcon;
	}
	public String getImagePath()
	{
		return m_imagePath;
	}
	public boolean getCardFlipped()
	{
		return m_cardFlipped;
	}
	public boolean getFoundMatch()
	{
		return m_foundMatch;
	}
	
	// Other methods
	public ImageIcon hideCard()
	{
		return m_unFlipped;
	}
	public ImageIcon showCard()
	{
		return m_imageIcon;
	}
	
	// Overrides
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Card)
		{
			Card otherCard = (Card) o;
			
			if(this.m_cardFlipped == true)
			{
					if(otherCard.m_cardFlipped == true)
					{
						if(this.m_imagePath == otherCard.m_imagePath)
						{
							return true;
						}
					}
			}
		}
		
		return false;
	}
}
