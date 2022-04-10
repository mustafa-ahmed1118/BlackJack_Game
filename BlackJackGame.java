/*
 * Mustafa Ahmed
 * November 6, 2020
 * Assignment 9, Blackjack
 * Purpose: To apply abstract data types
 */

//imports
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BlackJackGame 
{
    
    
    ////////////////////////////////////////
    ////////GLOBAL VARIABLES/OBJECTS////////
    ////////////////////////////////////////
    
   static Vector<Card> Dealer = new Vector<Card>();                                                                 //Dealer's hand
   static Vector<Card> Player = new Vector<Card>();                                                                 //Player's hand
   
   static boolean blnPlayerAceHandle = false;                                                                       //for handling ace cards in player's hand
   static boolean blnDealerAceHandle = false;                                                                       //for handling ace cards in dealer's hand        
   
   static Deck gameDeck = new Deck();                                                                               //Deck of cards
   
   static int intPlayerTotal = 0, intDealerTotal =0, intWinCounter=0, intLossCounter=0;                             //counter variables
   
   static String strPlayerName;
   
   static JLabel lblScore, lblPlayerTotal, lblDealerTotal, lblCardsLeft;                                             //counter labels
   static JLabel lblSpace1, lblSpace2;                                                                               //spacing labels
   static JLabel lblPlayerName, lblDealerName;                                                                       //labels for marking card hands 
   
   static JLabel lblFiller1,lblFiller2;
   
   static JLabel lblDealerCard1, lblDealerCard2, lblDealerCard3, lblDealerCard4, lblDealerCard5, lblDealerCard6;    //dealer card labels
   static JLabel lblPlayerCard1, lblPlayerCard2, lblPlayerCard3,lblPlayerCard4,lblPlayerCard5,lblPlayerCard6;       //player card labels
   
   static JButton btnHit, btnStand;                                                                                 //JButtons for actions
   
   
   ///////////////////////////////////////////////
   //////////////GUI CONSTRUCTION/////////////////
   ///////////////////////////////////////////////
   public static void blackJackGUI()
   {
     strPlayerName = JOptionPane.showInputDialog("Welcome to Blackjack. Please enter your name:");                   //retrieve user's name
     
     ///////////////////SETTING UP MAIN FRAME////////////////////////
    JFrame frame = new JFrame("Blackjack - Mustafa Ahmed");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
     /////////SETUP JPANNELS FOR WIDGETS//////////
     
    //main panels 
    JPanel TopLeft = new JPanel();
    JPanel TopRight = new JPanel();
    JPanel BottomLeft = new JPanel();
    JPanel BottomRight = new JPanel();
    
    //bottom right sub panels
    JPanel ScorePanel = new JPanel(); 
    JPanel ButtonPanel = new JPanel(); 
    
    //bottom left sub panels
    JPanel PlayerCardsPanel = new JPanel();
    JPanel PlayerNamePanel = new JPanel();
    
    //top left sub panels
    JPanel DealerCardPanel = new JPanel();
    JPanel DealerNamePanel = new JPanel();
   
    
    ////set panel layouts////
    TopLeft.setLayout(new GridLayout(2,1));
    DealerCardPanel.setLayout(new GridLayout(1,6));
    DealerNamePanel.setLayout(new GridLayout(1,3));//for centering name label
    
    BottomLeft.setLayout(new GridLayout(2,1));
    PlayerCardsPanel.setLayout(new GridLayout(1,6));
    PlayerNamePanel.setLayout(new GridLayout(1,3));//for centering name label
    
    TopRight.setLayout(new BorderLayout());
    ScorePanel.setLayout(new BoxLayout(ScorePanel,BoxLayout.PAGE_AXIS));
    
    BottomRight.setLayout(new BorderLayout());
    ButtonPanel.setLayout(new BoxLayout(ButtonPanel,BoxLayout.PAGE_AXIS));
    
    
    ////////////////////DECLARING GOBJECTS/////////////////
    
    //JLABELS//
    
    //spacing labels
    lblSpace1 = new JLabel("----------------------------------");
    lblSpace2 = new JLabel("-----------------------------------");
    lblFiller1 = new JLabel("");
    lblFiller2 = new JLabel("");
    
    //font sizes for labels
    float fltStandardFontSize = 15;
    float fltNameFontSize = 20;
    
    lblDealerTotal = new JLabel("Dealer Card Total: ");
    lblDealerTotal.setFont(lblDealerTotal.getFont().deriveFont(fltStandardFontSize));
    
    lblPlayerTotal = new JLabel(strPlayerName+"'s Card Total");
    lblPlayerTotal.setFont(lblPlayerTotal.getFont().deriveFont(fltStandardFontSize));
    
    lblCardsLeft = new JLabel("Cards Left in deck: "+gameDeck.size());
    lblCardsLeft.setFont(lblCardsLeft.getFont().deriveFont(fltStandardFontSize));
    
    lblScore = new JLabel(strPlayerName+"'s score: ");
    lblScore.setFont(lblScore.getFont().deriveFont(fltStandardFontSize));
    
    lblDealerName = new JLabel ("Dealer's Hand");
    lblDealerName.setForeground(Color.red);
    lblDealerName.setFont(lblDealerName.getFont().deriveFont(fltNameFontSize));
    
    lblPlayerName = new JLabel (strPlayerName+"'s Hand");
    lblPlayerName.setForeground(Color.blue);
    lblPlayerName.setFont(lblPlayerName.getFont().deriveFont(fltNameFontSize));
    
    lblDealerCard1 = new JLabel("");
    lblDealerCard2 = new JLabel("");
    lblDealerCard3 = new JLabel("");
    lblDealerCard4 = new JLabel("");
    lblDealerCard5 = new JLabel("");
    lblDealerCard6 = new JLabel("");
        
    lblPlayerCard1 = new JLabel("");
    lblPlayerCard2 = new JLabel("");
    lblPlayerCard3 = new JLabel("");
    lblPlayerCard4 = new JLabel("");
    lblPlayerCard5 = new JLabel("");
    lblPlayerCard6 = new JLabel("");
    
    //JBUTTONS//
    btnHit = new JButton("Hit!");
    btnHit.setActionCommand("hit");
    
    btnStand = new JButton("Stand");
    btnStand.setActionCommand("stand");
   
    
    /////////////////BUTTON HANDLER///////////////////////
     ButtonHandler onClick = new ButtonHandler();
     btnHit.addActionListener(onClick);
     btnStand.addActionListener(onClick);
    
     //////////////////WIDGET ACTIVATION////////////////////////
     
     //TOP LEFT//
     DealerCardPanel.add(lblDealerCard1);
     DealerCardPanel.add(lblDealerCard2);
     DealerCardPanel.add(lblDealerCard3);
     DealerCardPanel.add(lblDealerCard4);
     DealerCardPanel.add(lblDealerCard5);
     DealerCardPanel.add(lblDealerCard6);
     
     
     DealerNamePanel.add(lblFiller1);
     DealerNamePanel.add(lblDealerName, BorderLayout.SOUTH);
     
     //top left panel implements dealer card and dealer name panels
     TopLeft.add(DealerNamePanel, BorderLayout.CENTER);
     TopLeft.add(DealerCardPanel);
     
     //BOTTOM LEFT//
     PlayerNamePanel.add(lblFiller2);
     PlayerNamePanel.add(lblPlayerName, BorderLayout.NORTH);
     
     PlayerCardsPanel.add(lblPlayerCard1);
     PlayerCardsPanel.add(lblPlayerCard2);
     PlayerCardsPanel.add(lblPlayerCard3);
     PlayerCardsPanel.add(lblPlayerCard4);
     PlayerCardsPanel.add(lblPlayerCard5);
     PlayerCardsPanel.add(lblPlayerCard6);
    
     //bottom left panel implements player name and cards panel
     BottomLeft.add(PlayerCardsPanel);
     BottomLeft.add(PlayerNamePanel);
     
     
     //TOP RIGHT PANEL//
     ScorePanel.add(lblScore);
     ScorePanel.add(lblSpace1);
     ScorePanel.add(lblCardsLeft);
     
     //top right panel impements score panel
     TopRight.add(ScorePanel, BorderLayout.CENTER);
     
     
     //BOTTOM RIGHT PANEL//
     ButtonPanel.add(btnHit);
     ButtonPanel.add(btnStand);
     ButtonPanel.add(lblSpace2);
     ButtonPanel.add(lblPlayerTotal);
     ButtonPanel.add(lblDealerTotal);
     
     //bottom right panel implments button bannel
     BottomRight.add(ButtonPanel, BorderLayout.CENTER);
     
             
     
     /////////////////FRAME SET UP///////////////////////////
     Container contentPane = frame.getContentPane();
    
     contentPane.setLayout(new GridLayout(2,2));
    
    //add panels to each corner
     contentPane.add(TopLeft);
     contentPane.add(TopRight);
     contentPane.add(BottomLeft);
     contentPane.add(BottomRight);
     
     //set fram properties
     frame.setSize(900, 800);
     frame.setVisible(true);
    
    
     
     //output rules before starting game
    JOptionPane.showMessageDialog(null, "Welcome, "+strPlayerName+" to Blackjack. Here are the rules:\n\n"
                                      + "1.  Continually \"hit\" or pull cards from the dealer to get the highest number within 21\n"
                                      + "2.  Once you are satisfied with your cards then you must \"stand\" and the dealer's cards will be revealed\n"
                                      + "3.  If the dealer's cards are worth less than 17 then he must pull more cards until he reaches a number of 17 or greater\n"
                                      + "4.  If the dealer's cards go over 21 then he will \"bust\" and you will be awarded 1 point\n"
                                      + "5.  A player's hand worth 21 in 2 cards is a \"Blackjack\" worth 4 points\n"
                                      + "6.  A player's hand worth 21 in more than 2 cards is a \"Natural\" worth 3 points\n"
                                      + "7.  If both you and the dealer are within 21 and you beat the him, then you will be awarded 2 points\n"
                                      + "8.  If the dealer's cards are greater than or equal to yours, then you will lose and be deducted 1 point\n"
                                      + "9.  If your cards are worth more than 21 then you will bust and be deducted 3 points\n\n"
                                      + "Let the game begin!");
    
    freshGame();                    //start a fresh game upon gui construction
    
   
    
    
   
   }
   
   
  //////////////////////////////////// 
  ////////GAME ACTION METHODS/////////
  ////////////////////////////////////
   public static void freshGame()
   {

       //resetting game values--------------------------------------------------------------------------------------------------------
       Dealer.clear();
       Player.clear();
       
       blnPlayerAceHandle = false;
       blnDealerAceHandle = false;
       
       intDealerTotal = 0;
       intPlayerTotal =0;
       
       lblDealerCard1.setText("");
       lblDealerCard2.setText("");
       lblDealerCard3.setText("");
       lblDealerCard4.setText("");
       lblDealerCard5.setText("");
       lblDealerCard6.setText("");
        
       lblPlayerCard1.setText("");
       lblPlayerCard2.setText("");
       lblPlayerCard3.setText("");
       lblPlayerCard4.setText("");
       lblPlayerCard5.setText("");
       lblPlayerCard6.setText("");
        
      lblPlayerTotal.setText(strPlayerName+"'s Card Total: ");
      lblDealerTotal.setText("Dealer Card Total: ");
       
       //initial game set up below//
       
       //pull dealer's first card-------------------------------------------------------------------------------------------------------
       JOptionPane.showMessageDialog(null, "Dealer pulled a card");  //message for action
       Dealer.addElement(gameDeck.pop());                            //take card from deck then add to dealer's hand
       lblCardsLeft.setText("Cards left in Deck: "+gameDeck.size()); //update card counting label
       
       if(gameDeck.size() == 0)                                      //check if new deck needs to be shuffled
       {
           reShuffle();//shuffles new deck and updates card couner
           
       }
       intDealerTotal+=Dealer.lastElement().getCardVal();            //add card's value to dealer's total
       lblDealerCard1.setText(Dealer.lastElement().getName());       //output card name to first card label
       
       //pull player's first card-----------------------------------------------------------------------------------------------------
       JOptionPane.showMessageDialog(null, "Player pulled a card"); //message for action
       Player.addElement(gameDeck.pop());                           //take card from deck then add to player's hand
       lblCardsLeft.setText("Cards left in Deck: "+gameDeck.size());//update card counting label
       
       if(gameDeck.size() == 0)                                     //check if new deck needs to be shuffled
       {
           reShuffle();//shuffles new deck and updates card counter
       }
       
       intPlayerTotal+=Player.lastElement().getCardVal();            //add card's value to player's total
       lblPlayerCard1.setText(Player.lastElement().getName());       //output card name to first card label
       
       
        //Pull dealer's second card---------------------------------------------------------------------------------------------------
       JOptionPane.showMessageDialog(null, "Dealer pulled a card"); //message for action
       Dealer.addElement(gameDeck.pop());                           //take card from deck then add to dealer's hand
       lblCardsLeft.setText("Cards left in Deck: "+gameDeck.size());//update card counting label
       
       if(gameDeck.size() == 0)                                     //check if new deck needs to be shuffled
       {
           reShuffle();//shuffles new deck and updates card counter
       }
       
        //handling possible double aces//
        if(Dealer.lastElement().getCardVal() == 11)                   //check if card pulled was an ace         
        {
            if(intDealerTotal+Dealer.lastElement().getCardVal()>21)    //if ace card will bust hand
            {
                    Dealer.lastElement().setCardVal(1);                 //set value of ace card to 1
            }
        }
        
       intDealerTotal+=Dealer.lastElement().getCardVal();            //add card's value to dealer's total
       lblDealerCard2.setText("<html>card is<br/>hidden</html>");       //output hidden in place of card for dealer's second card
       
       //pull player's second card-------------------------------------------------------------------------------------------------
       JOptionPane.showMessageDialog(null, "Player pulled a card");//message for action
       Player.addElement(gameDeck.pop());                          //take card from deck and add to player's hand
       lblCardsLeft.setText("Cards left in Deck: "+gameDeck.size());//update card counting label
       
       if(gameDeck.size() == 0)                                     //check if new deck needs to be shuffed
       {
           reShuffle();//shuffle new deck and updates card counter
       }
       
     
        //handling possible double aces//
        if(Player.lastElement().getCardVal() == 11)                     //check if card pulled was an ace               
        {
            if(intPlayerTotal+Player.lastElement().getCardVal()>21)    //if ace card will bust hand
            {
                    Player.lastElement().setCardVal(1);                 //set value of ace card to 1
            }
        }
        
       intPlayerTotal+=Player.lastElement().getCardVal();              //add card's value to player's total
       lblPlayerCard2.setText(Player.lastElement().getName());   
      
       
       
     
     
       lblPlayerTotal.setText(strPlayerName+"'s Card Total: "+intPlayerTotal);//update player's total label
   
      
       if(intPlayerTotal==21)                                       //check to see if player won
       {
           win();
       }
      
 
   }
   
    public static void Hit()
    {
        //Card pull--------------------------------------------------------------------------------------------------------
        Player.addElement(gameDeck.pop());                              //take card from deck and add to player's hand
        lblCardsLeft.setText("Cards left in Deck: "+gameDeck.size());   //update card counting label
        
        if(gameDeck.size() == 0)                                        //check to see if new deck needs to be shuffled
        {
            JOptionPane.showMessageDialog(null, "You pulled the final card, a new deck will now be shuffled");   //message
            reShuffle();
        }
        
        //handling aces---------------------------------------------------------------------------------------------------
        
        handlePreviousPlayerAce();                                   //handles previous before the current card
        
        if(Player.lastElement().getCardVal()==11)                      //check is pulled card is an ace 
        {
            if(intPlayerTotal+Player.lastElement().getCardVal()>21)    //if ace card will bust hand
            {
                    Player.lastElement().setCardVal(1);                 //set value of ace card to 1
            }
        }
        
        
       
        //Output----------------------------------------------------------------------------------------------------------
        intPlayerTotal+= Player.lastElement().getCardVal();             //add to card total
            
        if(lblPlayerCard3.getText().equals(""))                        //set card name to the first available label
        {
            lblPlayerCard3.setText(Player.lastElement().getName());
        }
        else if(lblPlayerCard4.getText().equals(""))
        {
            lblPlayerCard4.setText(Player.lastElement().getName());
        }
        else if(lblPlayerCard5.getText().equals(""))
        {
            lblPlayerCard5.setText(Player.lastElement().getName());
        }
        else if(lblPlayerCard6.getText().equals(""))
        {
            lblPlayerCard6.setText(Player.lastElement().getName());
        }
            
        lblPlayerTotal.setText(strPlayerName+"'s Card Total: "+intPlayerTotal);
        
        
        if(intPlayerTotal == 21)                                       //check to see if player pulled 21/won
        {
                win();
        }
            
           
        else if(intPlayerTotal>21)                                    //check to see if player busted
        {
            bust();
        }  
    }
    
    
    public static void stand()
    {
        //revealing hidden card
        lblDealerCard2.setText(Dealer.elementAt(1).getName());
        JOptionPane.showMessageDialog(null, "Dealer's hidden card was revealed");
        
        //Card pulling loop----------------------------------------------------------------------------------------------
        while(intDealerTotal<17)                                                       //loop adding cards if needed
        {
            Dealer.addElement(gameDeck.pop());                                          //pull card from deck and add to dealer's hand
            lblCardsLeft.setText("Cards left in Deck: "+gameDeck.size());               //update card counter
            
            if(gameDeck.size() == 0)                                                   //check if new deck needs to be shuffed
            {
                JOptionPane.showMessageDialog(null, "The dealer pulled the final card, a new deck will now be shuffled");   //message
                reShuffle();
            }

            
            //ace handling--------------------------------------------------------
            
            handlePreviousDealerAce();                                   //handles previous dealer ace cards if needed
            
            if(Dealer.lastElement().getCardVal()==11)                                   //check to see if ace was pulled                            
            {
                if(intDealerTotal+Dealer.lastElement().getCardVal()>21)                 //check if the ace will bust the hand
                {
                    Dealer.lastElement().setCardVal(1);                                 //set the ace value to 1 if it will bust
                }
            }
            
            handlePreviousDealerAce();                                                  //handles previous dealer ace cards if needed
            
            intDealerTotal+=Dealer.lastElement().getCardVal();                            //add card's value to dealer's total counter
           
            
            JOptionPane.showMessageDialog(null,"Dealer's total was less than 17...\nhe pulled pulled another card ");  //message to user
            lblDealerTotal.setText("Dealer Card Total: "+intDealerTotal);                  //update dealer's total label
             
            if(lblDealerCard3.getText().equals(""))                                        //set card name to first available card label
            {
                lblDealerCard3.setText(Dealer.lastElement().getName());
                
            }
            else if(lblDealerCard4.getText().equals(""))
            {
                lblDealerCard4.setText(Dealer.lastElement().getName());
            }
            else if(lblDealerCard5.getText().equals(""))
            {
                lblDealerCard5.setText(Dealer.lastElement().getName());
            }
            else if(lblDealerCard6.getText().equals(""))
            {
                lblDealerCard6.setText(Dealer.lastElement().getName());
            }
            
        }//end of card pulling loop
        
       
       lblDealerTotal.setText("Dealer Card Total: "+intDealerTotal);                //update dealer total label
        
        if(intPlayerTotal<=intDealerTotal && intDealerTotal<22)                     //check if dealer beat player
        {
           loss();
        }   
        else                                                                       //check if dealer busts/loses
        {
           win();
        }
    }
    
     public static void reShuffle()
    {
        gameDeck = new Deck();                                                          //reinstantiate deck to shuffle new cards
        lblCardsLeft.setText("Cards left in Deck: "+gameDeck.size());                   //updtate card counting lablel
    }
     
   //////////////////////////////// 
   //////ACE HANDLING METHODS//////
   ///////////////////////////////
    public static void handlePreviousPlayerAce()
    {
        int aceCount=0;                                                      //for counting number of aces in hand  
        for(int i=0;i<Player.size();i++)    
        {
            if(Player.elementAt(i).getCardVal()==11)                        //count aces valued as 11
            {
                aceCount++;
            }
        }
        if(aceCount>0 &&intPlayerTotal+Player.lastElement().getCardVal()>21 && blnPlayerAceHandle ==false)  //if hand is about to bust and aces haven't been dealt with
        {
            if((intPlayerTotal+Player.lastElement().getCardVal() - 10)>21)                                   //if more than one ace valued at 11 will bust hand
            {
                intPlayerTotal-=(10*aceCount);                                                              //value each ace in hand as 1
                aceCount=0;
                blnPlayerAceHandle = true;                                                                  
            }
            else                                                                                            //if multiple aces valued at 11 won't bust hand
            {
                intPlayerTotal-=10;                                                                         //take away 10 from player total to value an ace as 1
                aceCount =0;
                blnPlayerAceHandle = true;
            }
        }
    }
    
    public static void handlePreviousDealerAce()
    {
        int aceCount=0;                                                   //for counting aces in hand
        for(int i=0;i<Dealer.size();i++)                                
        {
            if(Dealer.elementAt(i).getCardVal()==11)                     //count aces valued at 11
            {
                aceCount++;
            }
        }
        if(aceCount>0 &&intDealerTotal+Dealer.lastElement().getCardVal()>21 && blnDealerAceHandle ==false)  //if hand is about to bust and aces haven't been dealt with
        {
            if((intDealerTotal+Dealer.lastElement().getCardVal() - 10)>21)                                  //if more than one ace valued at 11 will bust hand
            {
                intDealerTotal-=(10*aceCount);                                                              //value each ace in hand as 1
                aceCount=0;
                blnDealerAceHandle = true;
            }
            else                                                                                             //if multiple aces valued at 11 won't bust hand
            {
                intDealerTotal-=10;                                                                          //take away 10 from dealer's total to value an ace as 1
                aceCount=0;
                blnDealerAceHandle = true;
            }
        }
    }
     
  //////////////////////////////////// 
  ////////GAME OUTCOME METHODS////////
  ////////////////////////////////////
    public static void win() 
    {
        
        if(Player.size()==2 && intPlayerTotal == 21)                                  //if player pulls 21 in 2 cards 
        {
            JOptionPane.showMessageDialog(null,"You won with a Blackjack!\n(+4pts)");
            intWinCounter+=4;//player is awarded 4 points for winning with a black jack      
        }
        else if(Player.size()>2 && intPlayerTotal == 21)                              //if player pulls 21 in more than 2 cards
        {
             JOptionPane.showMessageDialog(null,"You won with a Natural!\n(+3pts)");
             intWinCounter+=3;//player is awarded 3 points for winning by natural      
        }
        else if(intDealerTotal>21)                                                    //if player wins by the dealer busting
        {
            JOptionPane.showMessageDialog(null,"The dealer busted, you won!\n(+1pt)");
            intWinCounter++; //player is awarded one point if dealer busts      
        }
        else
        {
             JOptionPane.showMessageDialog(null,"You won!\n(+2pt)");                  //if user won by any other way then generic
             intWinCounter+=2;//player is awarded 2 points in other conditions      
        }
        
     
        lblScore.setText(strPlayerName+"'s score: "+intWinCounter);                             //update win label
        
        JOptionPane.showMessageDialog(null, "Next game beigins now"); 
        freshGame();                                                                  //start a new game   
    }
    
    public static void bust()
    {
       JOptionPane.showMessageDialog(null, "It's a bust!\n(-3pts)");     
       intWinCounter-=3;//player loses 3 points for busting
       lblScore.setText(strPlayerName+"'s score: "+intWinCounter);
       
       JOptionPane.showMessageDialog(null, "Next game beigins now");  
       freshGame();
    }
    
    public static void loss()
    {
        JOptionPane.showMessageDialog(null, "You lost!\n(-1pt)");
        intWinCounter--;//player loses 1 point for normal loss
        lblScore.setText(strPlayerName+"'s score: "+intWinCounter);
        
        JOptionPane.showMessageDialog(null, "Next game beigins now"); 
        freshGame();
    }
    
    //////////////////////////
    //////BUTTON HANDLER//////
    //////////////////////////
    private static class ButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            String command = e.getActionCommand();  
            
            if(command.equals("hit"))               //if user presses hit
            {
                Hit();
               
               
            }
            else if(command.equals("stand"))       //if user presses stand
            {
                stand();
                
            }
        }
        
    }
    
    ///////////////////    
   ////RUN PROGRAM////
   ////////////////// 
    public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
          public void run()
          {
              blackJackGUI();
          }  
        });
        
    } 

    
}//end of program
