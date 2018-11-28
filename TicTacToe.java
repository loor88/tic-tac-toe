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
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    // LOCAL MEMBERS
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    GameBoard gameBoard = new GameBoard();
    Player[]  players = new Player[2];
    Player    activePlayer;
    int       turn = 1;
    int       rowChoice;
    int       colChoice;
    
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    // PLAYER-INSTANTIATING LOOP
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    for(int playerCount = 0; playerCount < players.length; playerCount++)
    {
      do
      {
        players[playerCount] = new Player(playerCount,
                                          determinePlayerName(playerCount),
                                          determinePlayerMarker(playerCount));
        
      }while(Character.toUpperCase(verifyPlayerInfo(players[playerCount])) != 'Y');
    }// END players-iterating for loop
    
    
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    // GAMEPLAY LOOP
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    gameBoard.resetBoard();
    
    while(gameBoard.getIsActive())
    {
      activePlayer = (turn % 2 != 0 ? players[0] : players[1]);
      
      //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
      // TURN LOOP
      //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
      do
      {
        do
        {
          displayTurnHeader(activePlayer.getPlayerName(), gameBoard.displayGameBoard());
          
          rowChoice = determineRowChoice();
          
          colChoice = determineColumnChoice();
          
        }while(!verifyRowSelection(rowChoice) | !verifyColumnSelection(colChoice));
        
        if(!gameBoard.checkEmptyBoardSpace(rowChoice, colChoice))
        {
          displayOccupiedMessage(rowChoice, colChoice);
        }// END if board space already occupied
        
      }while(!gameBoard.checkEmptyBoardSpace(rowChoice, colChoice));
      
      gameBoard.setBoardSpace(rowChoice, colChoice, activePlayer.getPlayerMarker());
      
      gameBoard.checkGameStatus();
      
      if(gameBoard.getIsActive())
      {
        turn++;
      }// END if game is active
      
    }// END game-faciliating while loop
    
    
    
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
  
  
  //=======================================================================
  // METHOD:       displayTurnHeader
  // RETURN TYPE:  void
  // PARAMETER(S): String name, String board
  //-----------------------------------------------------------------------
  // Purpose: To display information regarding a Tic-Tac-Toe game's
  //          upcoming turn.
  //=======================================================================
  public static void displayTurnHeader(String name, String board)
  {
    System.out.printf("%n%n=== %S\'S TURN ===" +
                      "%n%n%s%n%n",
                      name,
                      board);
  }// END displayTurnHeader
  
  
  //=======================================================================
  // METHOD:       deterimineRowChoice
  // RETURN TYPE:  int
  // PARAMETER(S): n/a
  //-----------------------------------------------------------------------
  // Purpose: To prompt for and return an int representing a Player's
  //          desired row.
  //=======================================================================
  public static int determineRowChoice()
  {
    System.out.printf("%nPlease select a row (0-2):  ");
    return input.nextInt();
  }// END determineRowChoice
  
  
  //=======================================================================
  // METHOD:       deterimineColumnChoice
  // RETURN TYPE:  int
  // PARAMETER(S): n/a
  //-----------------------------------------------------------------------
  // Purpose: To prompt for and return an int representing a Player's
  //          desired column.
  //=======================================================================
  public static int determineColumnChoice()
  {
    System.out.printf("%nPlease select a column (0-2):  ");
    return input.nextInt();
  }// END determineColumnChoice
  
  
  //=======================================================================
  // METHOD:       verifyRowSelection
  // RETURN TYPE:  boolean
  // PARAMETER(S): int
  //-----------------------------------------------------------------------
  // Purpose: To return a boolean value representing whether parameter row
  //          is a valid row value (0 - 2, inclusive). If row is invalid,
  //          an error message should be displayed.
  //=======================================================================
  public static boolean verifyRowSelection(int row)
  {
    boolean isValid = true;
    
    if(row < 0 || row > 2)
    {
      System.out.printf("%nInvalid row entry: %d",
                        row);
      isValid = false;
    }// END if invalid row value
    
    return isValid;
  }// END verifyRowSelection
  
  
  //=======================================================================
  // METHOD:       verifyColumnSelection
  // RETURN TYPE:  boolean
  // PARAMETER(S): int
  //-----------------------------------------------------------------------
  // Purpose: To return a boolean value representing whether parameter col
  //          is a valid column value (0 - 2, inclusive). If col is
  //          invalid, an error message should be displayed.
  //=======================================================================
  public static boolean verifyColumnSelection(int col)
  {
    boolean isValid = true;
    
    if(col < 0 || col > 2)
    {
      System.out.printf("%nInvalid column entry: %d",
                        col);
      isValid = false;
    }// END if invalid row value
    
    return isValid;
  }// END verifyColumnSelection
  
  
  
  public static void displayOccupiedMessage(int row, int col)
  {
    System.out.printf("%nBoard space (%d, %d) has already been marked. Please try again.",
                      row, col);
  }// END displayOccupiedMessage
  
}// END APPLICATION CLASS TicTacToe