
/*
 * Mustafa Ahmed
 * November 6, 2020
 * Assignment 9, Blackjack
 * Purpose: To apply abstract data types
 */

import java.util.*;//import for stack

public class Deck 
{
    //stack of cards
    private Stack<Card> cardDeck = new Stack<Card>(); 
    
    //4 of each card object for 52 cards total
    private Card[] ace = new Card[4];
    private Card[] two = new Card[4];
    private Card[] three = new Card[4];
    private Card[] four = new Card[4];
    private Card[] five = new Card[4];
    private Card[] six = new Card[4];
    private Card[] seven = new Card[4];
    private Card[] eight = new Card[4];
    private Card[] nine = new Card[4];
    private Card[] ten = new Card[4];
    private Card[] king = new Card[4];
    private Card[] queen = new Card[4];
    private Card[] jack = new Card[4];
    
    public Deck()                                                     //constructor
    {
        
        /*
         * html codes were used to to break each string in 2 lines for card name and its suit
         * this was done to save space hoizontal space in the gui
         * \n escape sequence does not work on JLabels
         * <br/> works similarly to \n
         */
                                                                    
        //Deck "contains" cards//
        
        //DIAMOND CARDS//
        ace[0] = new Card("<html>Ace<br/>(diamond)</html>",11);//ace set as 11 to begin but can be changed later using setting method in card class
        two[0] = new Card("<html>2<br/>(diamond)</html>",2);
        three[0] = new Card("<html>3<br/>(diamond)</html>",3);
        four[0] = new Card("<html>4<br/>(diamond)</html>",4);
        five[0] = new Card("<html>5<br/>(diamond)</html>",5);
        six[0] = new Card("<html>6<br/>(diamond)</html>",6);
        seven[0] = new Card("<html>7<br/>(diamond)</html>",7);
        eight[0] = new Card("<html>8<br/>(diamond)</html>",8);
        nine[0] = new Card("<html>9<br/>(diamond)</html>",9);
        ten[0] = new Card("<html>10<br/>(diamond)</html>",10);
        king[0] = new Card("<html>King<br/>(diamond)</html>",10);
        queen[0] = new Card("<html>queen<br/>(diamond)</html>",10);
        jack[0] = new Card("<html>Jack<br/>(diamond)</html>",10);
          
        //CLUB CARDS//
        ace[1] = new Card("<html>Ace<br/>(club)</html>",11);//ace set as 11 to begin but can be changed later using setting method in card class
        two[1] = new Card("<html>2<br/>(club)</html>",2);
        three[1] = new Card("<html>3<br/>(club)</html>",3);
        four[1] = new Card("<html>4<br/>(club)</html>",4);
        five[1] = new Card("<html>5<br/>(club)</html>",5);
        six[1] = new Card("<html>6<br/>(club)</html>",6);
        seven[1] = new Card("<html>7<br/>(club)</html>",7);
        eight[1] = new Card("<html>8<br/>(club)</html>",8);
        nine[1] = new Card("<html>9<br/>(club)</html>",9);
        ten[1] = new Card("<html>10<br/>(club)</html>",10);
        king[1] = new Card("<html>King<br/>(club)</html>",10);
        queen[1] = new Card("<html>Queen<br/>(club)</html>",10);
        jack[1] = new Card("<html>Jack<br/>(club)</html>",10);
        
        //HEART CARDS//
        ace[2] = new Card("<html>Ace<br/>(heart)</html>",11);//ace set as 11 to begin but can be changed later using setting method in card class
        two[2] = new Card("<html>2<br/>(heart)</html>",2);
        three[2] = new Card("<html>3<br/>(heart)</html>",3);
        four[2] = new Card("<html>4<br/>(heart)</html>",4);
        five[2] = new Card("<html>5<br/>(heart)</html>",5);
        six[2] = new Card("<html>6<br/>(heart)</html>",6);
        seven[2] = new Card("<html>7<br/>(heart)</html>",7);
        eight[2] = new Card("<html>8<br/>(heart)</html>",8);
        nine[2] = new Card("<html>9<br/>(heart)</html>",9);
        ten[2] = new Card("<html>10<br/>(heart)</html>",10);
        king[2] = new Card("<html>King<br/>(heart)</html>",10);
        queen[2] = new Card("<html>Queen<br/>(heart)</html>",10);
        jack[2] = new Card("<html>Jack<br/>(heart)</html>",10);
          
        //SPADE CARDS//
        ace[3] = new Card("<html>Ace<br/>(spade)</html>",11);//ace set as 11 to begin but can be changed later using setting method in card class
        two[3] = new Card("<html>2<br/>(spade)</html>",2);
        three[3] = new Card("<html>3<br/>(spade)</html>",3);
        four[3] = new Card("<html>4<br/>(spade)</html>",4);
        five[3] = new Card("<html>5<br/>(spade)</html>",5);
        six[3] = new Card("<html>6<br/>(spade)</html>",6);
        seven[3] = new Card("<html>7<br/>(spade)</html>",7);
        eight[3] = new Card("<html>8<br/>(spade)</html>",8);
        nine[3] = new Card("<html>9<br/>(spade)</html>",9);
        ten[3] = new Card("<html>10<br/>(spade)</html>",10);
        king[3] = new Card("<html>King<br/>(spade)</html>",10);
        queen[3] = new Card("<html>Queen<br/>(spade)</html>",10);
        jack[3] = new Card("<html>Jack<br/>(spade)</html>",10);
       
        
        //add all cards to deck 
        for(int i=0;i<=3;i++)
        {
            cardDeck.add(ace[i]);
            cardDeck.add(two[i]);
            cardDeck.add(three[i]);
            cardDeck.add(four[i]);
            cardDeck.add(five[i]);
            cardDeck.add(six[i]);
            cardDeck.add(seven[i]);
            cardDeck.add(eight[i]);
            cardDeck.add(nine[i]);
            cardDeck.add(ten[i]);
            cardDeck.add(king[i]);
            cardDeck.add(queen[i]);
            cardDeck.add(jack[i]);
        }
        
        Collections.shuffle(cardDeck);      //shuffle the deck upon adding all cards
    }
    
    
    public Card pop()                      //removes and returns top of deck
    {
        return cardDeck.pop();
    }
    
    public int size()                      //returns deck size
    {
        return cardDeck.size();
    }
    
    
}
