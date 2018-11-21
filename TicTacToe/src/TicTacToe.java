//=========================================================================
// Class:   TicTacToe.java
// Author:  Zachary Guajardo
// Date:    11.20.18 3:48 PM
// Version: 1.0
//
// Purpose: To launch the TicTacToe application. This class should
//          culminate all functions from other classes in the project to
//          facilitate Tic-Tac-Toe gameplay.
//-------------------------------------------------------------------------
// Imports:
//   > Scanner
//
// Fields:
//   > - input: static Scanner
//
// Methods:
//   > + main(String[] args): static void
//   > + setPlayers(): static Player[]
//=========================================================================


//=========================================================================
// IMPORT STATEMENTS:
//=========================================================================
import java.util.Scanner;


public class TicTacToe
{
  //=======================================================================
  // FIELDS
  //=======================================================================
  private static Scanner input = new Scanner(System.in);
  
  
  //=======================================================================
  // MAIN METHOD
  //-----------------------------------------------------------------------
  // This is the method from which the application is launched; it contains
  // all gameplay logic.
  //=======================================================================
  public static void main(String[] args)
  {
    // LOCAL MEMBERS
    GameBoard gameBoard = new GameBoard();
    Player[] players = new Player[2];
    
    String name = "";
    char marker = ' ';
    
    // PLAYER-INSTANTIATING LOOP
    for(int playerCount = 0; playerCount < players.length; playerCount++)
    {
      do
      {
        players[playerCount] = new Player(playerCount,
                                          determinePlayerName(playerCount),
                                          determinePlayerMarker(playerCount));
        
      }while(Character.toUpperCase(verifyPlayerInfo(players[playerCount])) != 'Y');
    }// END players-iterating for loop
    
    
    // GAMEPLAY LOOP
    
  }// END main
  
  //=======================================================================
  // METHOD:       determinePlayerName
  // RETURN TYPE:  String
  // PARAMETER(S): int playerCount
  //-----------------------------------------------------------------------
  // Purpose: To prompt for and return a String representing a Player's
  //          name.
  //=======================================================================
  public static String determinePlayerName(int playerCount)
  {
    System.out.printf("%nPlayer #%d, what is you name?  ",
                      playerCount + 1);
    return input.nextLine();
  }// END determinePlayerName
  
  
  //=======================================================================
  // METHOD:       determinePlayerMarker
  // RETURN TYPE:  char
  // PARAMETER(S): int playerCount
  //-----------------------------------------------------------------------
  // Purpose: To determine and return a char representing a Player's
  //          Tic-Tac-Toe marker. 
  //-----------------------------------------------------------------------
  // Details: Markers 'x' and 'o' should be assigned when parameter
  //          playerCount is 0 and 1, respectively.
  //=======================================================================
  public static char determinePlayerMarker(int playerCount)
  {
    return (playerCount == 0 ? 'x' : 'o');
  }// END determinePlayerMarker
  
  
  //=======================================================================
  // METHOD:       verifyPlayerInfo
  // RETURN TYPE:  char
  // PARAMETER(S): Player player
  //-----------------------------------------------------------------------
  // Purpose: To prompt for and return a char indicating a user's
  //          satisfaction with the information stored in a Player object.
  //-----------------------------------------------------------------------
  // Details: A Player's information should be displayed using
  //          Player.toString().
  //=======================================================================
  public static char verifyPlayerInfo(Player player)
  {
    System.out.printf("%n%s" +
                      "%n%nIs this information correct? Enter \'Y\' or \'N\':  ",
                      player.toString());
    return input.nextLine().charAt(0);
  }// END verifyPlayerInfo

}// END APPLICATION CLASS TicTacToe