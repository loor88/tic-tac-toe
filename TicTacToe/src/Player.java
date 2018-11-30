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
//   - playerNo:     int
//   - playerName:   String
//   - playerMarker: char
//
// Methods:
//   Constructors:
//     + Player()
//     + Player(int no, String nm, char mkr)
//
//   Set Methods:
//     + setPlayerNo(int no):       void
//     + setPlayerName(String nm):  void
//     + setPlayerMarker(char mkr): void
//
//   Get Methods:
//     + getPlayerNo():     int
//     + getPlayerName():   String
//     + getPlayerMarker(): char
//
//   toString Method:
//     + toString(): String
//=========================================================================


public class Player
{
  //=======================================================================
  // FIELDS
  //=======================================================================
  private int    playerNo;
  private String playerName;
  private char   playerMarker;
  
  
  //=======================================================================
  // CONSTRUCTORS
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
  // METHOD:       setPlayerNo
  // RETURN TYPE:  void
  // PARAMETER(S): int no
  //-----------------------------------------------------------------------
  // Purpose: To assign a value to field playerNo.
  //=======================================================================
  public void setPlayerNo(int no)
  {
    playerNo = no;
  }// END setPlayerNo
  
  //=======================================================================
  // METHOD:       setPlayerName
  // RETURN TYPE:  void
  // PARAMETER(S): String nm
  //-----------------------------------------------------------------------
  // Purpose: To assign a value to field playerName
  //=======================================================================
  public void setPlayerName(String nm)
  {
    playerName = nm;
  }// END setPlayerName
  
  //=======================================================================
  // METHOD:       setPlayerMarker
  // RETURN TYPE:  void
  // PARAMETER(S): char mkr
  //-----------------------------------------------------------------------
  // Purpose: To assign a value to field playerMarker
  //=======================================================================
  public void setPlayerMarker(char mkr)
  {
    playerMarker = mkr;
  }// END setPlayerMarker
  
  
  //=======================================================================
  // METHOD:       getPlayerNo
  // RETURN TYPE:  int
  // PARAMETER(S): n/a
  //-----------------------------------------------------------------------
  // Purpose: To return the value of field playerNo
  //=======================================================================
  public int getPlayerNo()
  {
    return playerNo;
  }// END getPlayerNo
  
  //=======================================================================
  // METHOD:       getPlayerName
  // RETURN TYPE:  String
  // PARAMETER(S): n/a
  //-----------------------------------------------------------------------
  // Purpose: To return the value of field playerName
  //=======================================================================
  public String getPlayerName()
  {
    return playerName;
  }// END getPlayerName
  
  //=======================================================================
  // METHOD:       getPlayerMarker
  // RETURN TYPE:  char
  // PARAMETER(S): n/a
  //-----------------------------------------------------------------------
  // Purpose: To return the value of field playerMarker
  //=======================================================================
  public char getPlayerMarker()
  {
    return playerMarker;
  }// END getPlayerMarker
  
  
  //=======================================================================
  // METHOD:       toString
  // RETURN TYPE:  String
  // PARAMETER(S): n/a
  //-----------------------------------------------------------------------
  // Purpose: To return a summary of the class's meaningful attributes at
  //          any given point in time.
  //=======================================================================
  public String toString()
  {
    return String.format("=== PLAYER #%d ===" +
                         "%nNAME:   %s" +
                         "%nMARKER: %c",
                         getPlayerNo() + 1, getPlayerName(), getPlayerMarker());
  }// END toString
  
}// END class Player