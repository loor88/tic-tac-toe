//=========================================================================
// Class:   GameBoard.java
// Author:  Zachary Guajardo
// Date:    11.19.18 6:00 PM
// Version: 1.0
//
// Purpose: To represent a Tic-Tac-Toe board. A single GameBoard object
//          should be instantiated per game.
//-------------------------------------------------------------------------
// Fields:
//   - board:  char[][]
//   - isWon:  boolean
//   - isFull: boolean
//
// Methods:
//   Constructors:
//     + GameBoard()
//
//   Set Methods:
//     + setBoardSpace(int row, int col, char marker): void
//     - setIsWon(boolean won):                        void
//     - setIsFull(boolean full):                      void     
//
//   Get Methods:
//     - getBoard():                      char[][]
//     - getBoardSpace(int row, int col): char
//     + getIsWon():                      boolean
//     + getIsFull():                     boolean
//
//   Functional Methods:
//     + checkEmptyBoardSpace(int row, int col): boolean
//     + checkGameStatus():                      void
//     - checkRows():                            boolean
//     - checkColumns():                         boolean
//     - checkDiagonals():                       boolean
//     + checkFull():                            void
//     + resetBoard():                           void
//     + displayGameBoard():                     String
//=========================================================================

public class GameBoard
{
  //=======================================================================
  // FIELDS 
  //=======================================================================
  private char[][] board = new char[3][3];
  private boolean  isWon;
  private boolean  isFull;
  
  
  //=======================================================================
  // CONSTRUCTORS
  //=======================================================================
  public GameBoard()
  {
    setIsWon(false);
    setIsFull(false);
  }// END null constructor
  
  
  //=======================================================================
  // METHOD:       setBoardSpace
  // RETURN TYPE:  void
  // PARAMETER(S): int row, int col, char marker
  //-----------------------------------------------------------------------
  // Purpose: To mark a specified position on the Tic-Tac-Toe board.
  //=======================================================================
  public void setBoardSpace(int row, int col, char marker)
  {
    board[row][col] = marker;
  }// END setBoardSpace
  
  //=======================================================================
  // METHOD:       setIsWon
  // RETURN TYPE:  void
  // PARAMETER(S): boolean won
  //-----------------------------------------------------------------------
  // Purpose: To assign a value to field isWon.
  //=======================================================================
  private void setIsWon(boolean won)
  {
    isWon = won;
  }// END setIsActive
  
  //=======================================================================
  // METHOD:       setIsWon
  // RETURN TYPE:  void
  // PARAMETER(S): boolean won
  //-----------------------------------------------------------------------
  // Purpose: To assign a value to field isWon.
  //=======================================================================
  public void setIsFull(boolean full)
  {
    isFull = full;
  }// END setIsFull
  
  //=======================================================================
  // METHOD:       getBoard
  // RETURN TYPE:  char[][]
  // PARAMETER(S): n/a
  //-----------------------------------------------------------------------
  // Purpose: To return a 2-D char array representing the current state of
  //          the game board.
  //=======================================================================
  public char[][] getBoard()
  {
    return board;
  }// END getBoard
  
  //=======================================================================
  // METHOD:       getBoardSpace
  // RETURN TYPE:  char
  // PARAMETER(S): int row, int col
  //-----------------------------------------------------------------------
  // Purpose: To return a char representing the marker placed on a
  //          specified board position.
  //=======================================================================
  private char getBoardSpace(int row, int col)
  {
    return getBoard()[row][col];
  }// END getBoardSpace
  
  //=======================================================================
  // METHOD:       getIsWon
  // RETURN TYPE:  boolean
  // PARAMETER(S): n/a
  //-----------------------------------------------------------------------
  // Purpose: To return the value of field isWon.
  //=======================================================================
  public boolean getIsWon()
  {
    return isWon;
  }// END getIsActive
  
  //=======================================================================
  // METHOD:       getIsFull
  // RETURN TYPE:  boolean
  // PARAMETER(S): n/a
  //-----------------------------------------------------------------------
  // Purpose: To return the value of field isFull.
  //=======================================================================
  public boolean getIsFull()
  {
    return isFull;
  }// END getIsFull
  
  
  //=======================================================================
  // METHOD:       checkEmptyBoardSpace
  // RETURN TYPE:  boolean
  // PARAMETER(S): int row, int col
  //-----------------------------------------------------------------------
  // Purpose: To determine whether a space on the Tic-Tac-Toe board has
  //          been marked by a player.
  //=======================================================================
  public boolean checkEmptyBoardSpace(int row, int col)
  {
    return (getBoardSpace(row, col) == ' ' ? true : false);
  }// END checkEmptyBoardSpace
  
  //=======================================================================
  // METHOD:       checkGameStatus
  // RETURN TYPE:  void
  // PARAMETER(S): n/a
  //-----------------------------------------------------------------------
  // Purpose: To determine whether a Tic-Tac-Toe game is still active.
  //=======================================================================
  public void checkGameStatus()
  {
    if(checkRows() || checkColumns() || checkDiagonals())
    {
      setIsWon(true);
    }// END if game is over
  }// END checkGameStatus
  
  //=======================================================================
  // METHOD:       checkRows
  // RETURN TYPE:  boolean
  // PARAMETER(S): n/a
  //-----------------------------------------------------------------------
  // Purpose: To check each row of the Tic-Tac-Toe board for 3 similar
  //          markers in a row.
  //=======================================================================
  private boolean checkRows()
  {
    boolean areSimilar = false;
    
    for(int row = 0; row < getBoard().length; row++)
    {
      if(!checkEmptyBoardSpace(row, 0) &&
         getBoardSpace(row, 0) == getBoardSpace(row, 1) &&
         getBoardSpace(row, 0) == getBoardSpace(row, 2))
      {
        areSimilar = true;
      }// END if three similar markers in a row
    }// END row-iterating for loop
    
    return areSimilar;
  }// END checkRows
  
  //=======================================================================
  // METHOD:       checkColumns
  // RETURN TYPE:  boolean
  // PARAMETER(S): n/a
  //-----------------------------------------------------------------------
  // Purpose: To check each column of the Tic-Tac-Toe board for 3 similar
  //          markers in a row.
  //=======================================================================
  private boolean checkColumns()
  {
    boolean areSimilar = false;
    
    for(int col = 0; col < getBoard().length; col++)
    {
      if(!checkEmptyBoardSpace(0, col) &&
         getBoardSpace(0, col) == getBoardSpace(1, col) &&
         getBoardSpace(0, col) == getBoardSpace(2, col))
      {
        areSimilar = true;
      }// END if three similar matkers in a column
    }// END column-iterating for loop
    
    return areSimilar;
  }// END checkColumns
  
  //=======================================================================
  // METHOD:       checkDiagonals
  // RETURN TYPE:  boolean
  // PARAMETER(S): n/a
  //-----------------------------------------------------------------------
  // Purpose: To check each diagonal of the Tic-Tac-Toe board for 3 similar
  //          markers in a row.
  //=======================================================================
  private boolean checkDiagonals()
  {
    boolean areSimilar = false;
    
    if(!checkEmptyBoardSpace(1, 1))
    {
      if(getBoardSpace(0, 0) == getBoardSpace(1, 1) &&
         getBoardSpace(0, 0) == getBoardSpace(2, 2))
      {
        areSimilar = true;
      }// END if three similar markers in "/" diagonal
      else if(getBoardSpace(0, 2) == getBoardSpace(1, 1) &&
              getBoardSpace(0, 2) == getBoardSpace(2, 0))
      {
        areSimilar = true;
      }// END of three similar markers in "\" diagonal
    }// END if board[1][1] is not empty
    
    return areSimilar;
  }// END checkDiagonals
  
  //=======================================================================
  // METHOD:       checkFull
  // RETURN TYPE:  void
  // PARAMETER(S): n/a
  //-----------------------------------------------------------------------
  // Purpose: To determine if the Tic-Tac-Toe board is full of player
  //          markers.
  //=======================================================================
  public void checkFull()
  {
    int totalSpaces = 0;
    int markedSpaces = 0;
    
    for(int row = 0; row < board.length; row++)
    {
      for(int col = 0; col < board[row].length; col++)
      {
        totalSpaces++;
        
        if(!checkEmptyBoardSpace(row, col))
        {
          markedSpaces++;
        }// END if board space is not empty
      }// END column-iterating for loop
    }// END row-iterating for loop
   
    setIsFull(totalSpaces == markedSpaces ? true : false);
  }// END checkFull
  
  //=======================================================================
  // METHOD:       resetBoard
  // RETURN TYPE:  void
  // PARAMETER(S): n/a
  //-----------------------------------------------------------------------
  // Purpose: To wipe the Tic-Tac-Toe board of player markers.
  //=======================================================================
  public void resetBoard()
  {
    for(int row = 0; row < board.length; row++)
    {
      for(int col = 0; col < board[row].length; col++)
      {
        setBoardSpace(row, col, ' ');
      }// END column-iterating for loop
      
      setIsWon(false);
      setIsFull(false);
    }// END row-iterating for loop
  }// END resetBoard
  
  //=======================================================================
  // METHOD:       displayGameBoard
  // RETURN TYPE:  String
  // PARAMETER(S): n/a
  //-----------------------------------------------------------------------
  // Purpose: To return a String representing the Tic-Tac-Toe board's
  //          current state.
  //=======================================================================
  public String displayGameBoard()
  {
    return String.format("  %c | %c | %c " +
                         "%n ---+---+---" +
                         "%n  %c | %c | %c " +
                         "%n ---+---+---" +
                         "%n  %c | %c | %c ",
                         getBoardSpace(0, 0), getBoardSpace(0, 1), getBoardSpace(0, 2),
                         getBoardSpace(1, 0), getBoardSpace(1, 1), getBoardSpace(1, 2),
                         getBoardSpace(2, 0), getBoardSpace(2, 1), getBoardSpace(2, 2));
  }// END displayGameBoard
  
}// END class GameBoard