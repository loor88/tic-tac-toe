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
//   - input: static Scanner
//
// Methods:
//   + main(String[] args):                          static void
//   + displayGameTitle                              static void
//   + determinePlayerName(int playerCount):         static String
//   + determinePlayerMarker(int playerCount):       static char
//   + verifyPlayerInfo(Player player):              static char
//   + displayTurnHeader(String name, String board): static void
//   + determineRowChoice():                         static int
//   + determineColumnChoice():                      static int
//   + verifyRowSelection(int row):                  static boolean
//   + verifyColumnSelection(int col)                static boolean
//   + displayWinMessage(String board, String name): static void
//   + displayDrawMessage(String board):             static void
//   + determineRematch():                           static char
//=========================================================================


//=========================================================================
// IMPORT STATEMENTS
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
    //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    // LOCAL MEMBERS
    //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    GameBoard gameBoard = new GameBoard();
    Player[]  players = new Player[2];
    Player    activePlayer;
    int       turn;
    int       rowChoice;
    int       colChoice;
    
    //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    // DISPLAY GAME TITLE
    //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    displayGameTitle();
    
    //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    // PLAYER-INSTANTIATING LOOP
    //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    for(int playerCount = 0; playerCount < players.length; playerCount++)
    {
      do
      {
        players[playerCount] = new Player(playerCount,
                                          determinePlayerName(playerCount),
                                          determinePlayerMarker(playerCount));
        
      }while(Character.toUpperCase(verifyPlayerInfo(players[playerCount])) != 'Y');
    }// END players-iterating for loop
    
    
    //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    // REMATCH LOOP
    //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    do
    {
      gameBoard.resetBoard();
      turn = 1;
      
      //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
      // GAMEPLAY LOOP
      //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
      do
      {
        activePlayer = (turn % 2 != 0 ? players[0] : players[1]);
        
        //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
        // TURN LOOP
        //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
        do
        {
          //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
          // TURN VERIFICATION LOOP
          //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
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
        
        gameBoard.checkFull();
        
        if(gameBoard.getIsWon())
        {
          displayWinMessage(gameBoard.displayGameBoard(), activePlayer.getPlayerName());
        }// END if game has been won
        else if(gameBoard.getIsFull())
        {
          displayDrawMessage(gameBoard.displayGameBoard());
        }// END if board is full
        
        turn++;
        
      }while(!gameBoard.getIsWon() && !gameBoard.getIsFull());
      
      //input.nextLine();
      
    }while(Character.toUpperCase(determineRematch()) == 'Y');
    
    System.exit(0);
    
  }// END main
  
  
  //=======================================================================
  // METHOD:       displayGameTitle
  // RETURN TYPE:  void
  // PARAMETER(S): n/a
  //-----------------------------------------------------------------------
  // Purpose: To display the Tic-Tac-Toe game title and author credits.
  //=======================================================================
  public static void displayGameTitle()
  {
    System.out.printf("%n T | I | C"  +
                      "%n---+---+---" +
                      "%n T | A | C"  +
                      "%n---+---+---" +
                      "%n T | O | E" +
                      "%n%nWritten by Zachary Guajardo%n%n");
  }// END displayGameTitle
  
  
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
    System.out.printf("%nPlayer #%d, enter your name:  ",
                      playerCount + 1);
    return input.nextLine().toUpperCase();
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
    System.out.printf("%n=== %s\'S TURN ===" +
                      "%n%n%s%n",
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
  // PARAMETER(S): int row
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
      System.out.printf("%nInvalid row entry: %d%n",
                        row);
      isValid = false;
    }// END if invalid row value
    
    return isValid;
  }// END verifyRowSelection
  
  
  //=======================================================================
  // METHOD:       verifyColumnSelection
  // RETURN TYPE:  boolean
  // PARAMETER(S): int col
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
      System.out.printf("%nInvalid column entry: %d%n",
                        col);
      isValid = false;
    }// END if invalid row value
    
    return isValid;
  }// END verifyColumnSelection
  
  
  //=======================================================================
  // METHOD:       displayOccupiedMessage
  // RETURN TYPE:  void
  // PARAMETER(S): int row, int col
  //-----------------------------------------------------------------------
  // Purpose: To display a message indicating that a Tic-Tac-Toe Board
  //          space has aleady been marked.
  //=======================================================================
  public static void displayOccupiedMessage(int row, int col)
  {
    System.out.printf("%nBoard space (%d, %d) has already been marked. Please try again.%n",
                      row,
                      col);
  }// END displayOccupiedMessage
  
  
  //=======================================================================
  // METHOD:       displayWinMessage
  // RETURN TYPE:  void
  // PARAMETER(S): String board, String name
  //-----------------------------------------------------------------------
  // Purpose: To display a message indicating that a Tic-Tac-Toe Board
  //          space has aleady been marked.
  //=======================================================================
  public static void displayWinMessage(String board, String name)
  {
    System.out.printf("%n%s" +
                      "%n%nWINNER: %s%n",
                      board,
                      name);
  }// END displayWinMessage
  
  
  //=======================================================================
  // METHOD:       displayDrawMessage
  // RETURN TYPE:  void
  // PARAMETER(S): String board
  //-----------------------------------------------------------------------
  // Purpose: To display a message indicating that a Tic-Tac-Toe Board
  //          there are no winners.
  //=======================================================================
  public static void displayDrawMessage(String board)
  {
    System.out.printf("%n%s" +
                      "%n%nGAME OVER" +
                      "%nIT\'S A DRAW!%n",
                      board);
  }// END displayDrawMessage
  
  
  //=======================================================================
  // METHOD:       determineRematch
  // RETURN TYPE:  char
  // PARAMETER(S): n/a
  //-----------------------------------------------------------------------
  // Purpose: To prompt for and return a char representing whether
  //          the Tic-Tac-Toe Players would like to play another game.
  //=======================================================================
  public static char determineRematch()
  {
    input.nextLine();
    System.out.printf("%nWould you like to play again? Enter \'Y\' or \'N\':  ");
    return input.nextLine().charAt(0);
  }// END determineRematch
  
}// END APPLICATION CLASS TicTacToe