//=========================================================================
// Class:   TicTacToe.java
// Author:  Zachary Guajardo
// Date:    11.14.18 10:53 AM
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
  // FIELDS DEFINED HERE:
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
    Player[] players = setPlayers();
    GameBoard board = new GameBoard();
    
   
  }// END main
  
  
  //=======================================================================
  // METHOD:       setPlayers
  // RETURN TYPE:  Player[]
  // PARAMETER(S): n/a
  //-----------------------------------------------------------------------
  // Purpose: Populate, verify, and return a 1D array of type Player. 
  //-----------------------------------------------------------------------
  // Details: The Player array should have a length of 2 and should be
  //          populated using a for loop. Each Player should be assigned a
  //          number (Player.playerNo), a name (Player.playerName), and a
  //          marker (Player.playerMarker).
  //
  //          After each Player's number, name, and marker attributes have
  //          been set, each user should be able to verify that his/her
  //          Player's name is correct using a do-while loop.
  //-----------------------------------------------------------------------
  // Notes:   Each Player's number should be equal to the for loop's
  //          counter-control variable (playerCount). Each Player's name
  //          should be prompted for. Each Player's marker should be x and
  //          o for Player 0 and 1, respectively. Player numbers should be
  //          0 and 1 for the first and second player, respectively.
  //=======================================================================
  public static Player[] setPlayers()
  {
    Player[] tempPlayers = new Player[2];
    String   name = "";
    char     marker = ' ';
    char     isValid = ' ';
    
    for(int playerCount = 0; playerCount < tempPlayers.length; playerCount++)
    {
      do
      {
        // prompt for name
        System.out.printf("%nPlayer #%d, what is you name?  ",
                          playerCount + 1);
        name = input.nextLine();
        
        // assign marker
        marker = (playerCount == 0 ? 'x' : 'o');
        
        // validate name and marker values
        System.out.printf("%n%n=== PLAYER #%d ===" +
                          "%nNAME:   %s" +
                          "%nMARKER: %c" +
                          "%n%nIs this information correct? Enter \'Y\' or \'N\':  ",
                          playerCount + 1, name, marker);
        isValid = input.nextLine().charAt(0);
      }while(Character.toUpperCase(isValid) != 'Y');
      
      // instantiate Player object and insert into tempPlayers array
      tempPlayers[playerCount] = new Player(playerCount, name, marker);
      
    }// END Player[]-populating for loop
    
    return tempPlayers;
  }// END setPlayers
}// END APPLICATION CLASS TicTacToe