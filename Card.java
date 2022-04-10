

/*
 * Mustafa Ahmed
 * November 6, 2020
 * Assignment 9, Blackjack
 * Purpose: To apply abstract data types
 */

public class Card                  
{
    //instance variables//
    private String strCardName;
    private int intCardVal;
    
    public Card(String name, int val)       //constructor
    {
        strCardName = name;
        intCardVal = val;
    }
    
    public String getName()                 //returns card name
    {
        return strCardName;
    }
    
    public int getCardVal()                 //returns card value
    {
        return intCardVal;
    }
    
    public void setCardVal(int newVal)      //sets card value (mainly for aces)
    {
        this.intCardVal = newVal;
    }
   
}
