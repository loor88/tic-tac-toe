//=========================================================================
// Class:   Player.java
// Author:  Zachary Guajardo
// Date:    11.14.18 11:04 AM
// Version: 1.0
//
// Purpose: To represent a Tic-Tac-Toe player. Two Player objects should
//          be instantiated in every Tic-Tac-Toe game.
//-------------------------------------------------------------------------
// Fields:
//   > - playerNo:     int
//   > - playerName:   String
//   > - playerMarker: char
//
// Methods:
//   Constructors:
//     > + Player()
//     > + Player(int no, String nm, char mkr)
//
//   Set Methods:
//     > + setPlayerNo(int no):       void
//     > + setPlayerName(String nm):  void
//     > + setPlayerMarker(char mkr): void
//
//   Get Methods:
//     > + getPlayerNo():     int
//     > + getPlayerName():   String
//     > + getPlayerMarker(): char
//
//   toString Method:
//     > + toString(): String
//=========================================================================


public class Player
{
  //=======================================================================
  // FIELDS DEFINED HERE:
  //=======================================================================
  private int    playerNo = 0;
  private String playerName = "";
  private char   playerMarker = ' ';
  
  
  //=======================================================================
  // CONSTRUCTORS DEFINED HERE:
  //-----------------------------------------------------------------------
  // Constructors are used to instantiate objects of the class.
  //=======================================================================
  public Player()
  {
  }// END null constructor
  
  public Player(int no, String nm, char mkr)
  {
    setPlayerNo(no);
    setPlayerName(nm);
    setPlayerMarker(mkr);
  }// END full constructor
  
  
  //=======================================================================
  // SET METHODS DEFINED HERE:
  //-----------------------------------------------------------------------
  // Set methods are used to assign values to the class's fields.
  //=======================================================================
  public void setPlayerNo(int no)
  {
    playerNo = no;
  }// END setPlayerNo
  
  public void setPlayerName(String nm)
  {
    playerName = nm;
  }// END setPlayerName

  public void setPlayerMarker(char mkr)
  {
    playerMarker = mkr;
  }// END setPlayerMarker
  
  
  //=======================================================================
  // GET METHODS DEFINED HERE:
  //-----------------------------------------------------------------------
  // Get methods are used to return the value of the class's fields.
  //=======================================================================
  public int getPlayerNo()
  {
    return playerNo;
  }// END getPlayerNo
  
  public String getPlayerName()
  {
    return playerName;
  }// END getPlayerName
  
  public char getPlayerMarker()
  {
    return playerMarker;
  }// END getPlayerMarker
  
  
  //=======================================================================
  // TO-STRING METHOD DEFINED HERE:
  //-----------------------------------------------------------------------
  // The toString method provides a quick way to display all of the class's
  // meaningful fields at once.
  //=======================================================================
  public String toString()
  {
    return String.format("Player Number: %d" +
                         "%nPlayer Name:   %s" +
                         "%nPlayer Marker: %c",
                         getPlayerNo(),
                         getPlayerName(),
                         getPlayerMarker());
  }// END toString
}// END class Player