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
//   > - board:    char[][]
//   > - isActive: boolean
//
// Methods:
//   Constructors:
//     > + GameBoard()
//
//   Set Methods:
//     > + setBoardSpace(int row, int col, char marker): void
//     > - setIsActive(boolean act): void
//
//   Get Methods:
//     > - getBoard():                      char[][]
//     > - getBoardSpace(int row, int col): char
//     > + getIsActive():                   boolean
//
//   Functional Methods:
//     > + checkBoardSpace(int row, int col): boolean
//     > + checkGameStatus():                 void           ?v?
//     > - checkRows():                       boolean         ?
//     > - checkColumns():                    boolean         ?
//     > - checkDiagonals():                  boolean         ?
//     > + resetBoard():                      void
//
//   toString Method:
//     > + toString(): String
//=========================================================================

public class GameBoard
{
  //=======================================================================
  // FIELDS DEFINED HERE:
  //=======================================================================
  private char[][] board = new char[3][3];
  private boolean  isActive = true;
  
  
  //=======================================================================
  // CONSTRUCTORS DEFINED HERE:
  //-----------------------------------------------------------------------
  // Constructors are used to instantiate objects of the class.
  //=======================================================================
  public GameBoard()
  {
  }// END null constructor
  
  
  //=======================================================================
  // SET METHODS DEFINED HERE:
  //-----------------------------------------------------------------------
  // Set methods are used to assign values to the class's fields.
  //=======================================================================
  public void setBoardSpace(int row, int col, char marker)
  {
    board[row][col] = marker;
  }// END setBoardSpace
  
  private void setIsActive(boolean act)
  {
    isActive = act;
  }// END setIsActive
  
  
  //=======================================================================
  // GET METHODS DEFINED HERE:
  //-----------------------------------------------------------------------
  // Get methods are used to return the value of the class's fields.
  //=======================================================================
  public char[][] getBoard()
  {
    return board;
  }// END getBoard
  
  private char getBoardSpace(int row, int column)
  {
    return getBoard()[row][column];
  }// END getBoardSpace
  
  public boolean getIsActive()
  {
    return isActive;
  }// END getIsActive
  
  
  //=======================================================================
  // FUNCTIONAL METHODS DEFINED HERE:
  //-----------------------------------------------------------------------
  // Functional methods are used to provide meaningful functionality to the
  // class.
  //=======================================================================
  public boolean checkBoardSpace(int row, int col)
  {
    return (getBoardSpace(row, col) == ' ' ? true : false);
  }// END checkBoardSpace
  
  public void checkGameStatus()
  {
    
  }// END checkGameStatus
  
  private boolean checkRows()
  {
    boolean areSimilar = false;
    
    for(int row = 0; row < getBoard().length; row++)
    {
      if(!checkBoardSpace(row, 0) &&
         getBoardSpace(row, 0) == getBoardSpace(row, 1) &&
         getBoardSpace(row, 0) == getBoardSpace(row, 2))
      {
        areSimilar = true;
      }// END if three similar markers in a row
    }// END row-iterating for loop
    
    return areSimilar;
  }// END checkRows
  
  private boolean checkColumns()
  {
    boolean areSimilar = false;
    
    for(int col = 0; col < getBoard().length; col++)
    {
      if(!checkBoardSpace(0, col) &&
         getBoardSpace(0, col) == getBoardSpace(1, col) &&
         getBoardSpace(0, col) == getBoardSpace(2, col))
      {
        areSimilar = true;
      }// END if three similar matkers in a column
    }// END column-iterating for loop
    
    return areSimilar;
  }// END checkColumns
  
  private boolean checkDiagonals()
  {
    boolean areSimilar = false;
    
    if(!checkBoardSpace(1, 1))
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
  
  public void resetBoard()
  {
    for(int row = 0; row < board.length; row++)
    {
      for(int col = 0; col < board[row].length; col++)
      {
        setBoardSpace(row, col, ' ');
      }// END column-iterating for loop
      
      setIsActive(true);
    }// END row-iterating for loop
  }// END resetBoard
  
  
  //=======================================================================
  // TO-STRING METHOD DEFINED HERE:
  //-----------------------------------------------------------------------
  // The toString method provides a quick way to display all of the class's
  // meaningful fields at once.
  //=======================================================================
  public String toString()
  {
    return String.format(" %s | %s | %s " +
                         "%n ---+---+---" +
                         "%n %s | %s | %s " +
                         "%n ---+---+---" +
                         "%n %s | %s | %s ",
                         getBoardSpace(0, 0), getBoardSpace(0, 1), getBoardSpace(0, 2),
                         getBoardSpace(1, 0), getBoardSpace(1, 1), getBoardSpace(1, 2),
                         getBoardSpace(2, 0), getBoardSpace(2, 1), getBoardSpace(2, 2));
  }// END toString
  
}// END class GameBoard