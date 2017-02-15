/**
 * MiniFacebookAccount.java
 *
 * A simple class to hold account name and a list of friends.
 *
 * CS219. Array as instance data member practice
 *
 */
public class MiniFacebookAccount
{
  // Constant to specify maximum number of friends allowed
  private final int MAX = 5;

  // Name of account holder
  private String name;

  // List of friends (just names)
  private String[] friendsList;

  // track actual number of friends a user has
  private int numFriends;

  //-----------------------------------------------

  // 1-param constructor. Creates a MiniFacebookAccount
  // object for a user with specified name
  public MiniFacebookAccount(String name)
  {
    this.name = name;
    numFriends = 0;
    friendsList = new String[MAX];
  } // end 1-param constructor

  //-----------------------------------------------

  // Adds the specified friend
  /*
   * The name will be appended to the end of the friends list and
   * numFriends increased by one if the friend list is not full
   * and the name is not already in the list. Otherwise displays
   * error messages and no actions taken.
   */
  public void addFriend(String friendName)
  {
    if (numFriends >= MAX) // full
    {
      System.out.println("Account of " + name + ": cannot add " + friendName + ". Friend list is full.");
    }
    else if (exists(friendName)) // duplicate. already in the list
    {
      System.out.println("Account of " + name + ": cannot add " + friendName + ". Already in the list.");
    }
    else // add to friend list
    {
      friendsList[numFriends++] = friendName;
    }
  } // end addFriend

  // Prints accout user name and list of friends on screen
  public void printAccount()
  {
    // print heading
    System.out.println("\n=========================="); // leading separator line
    System.out.println("Account name: " + name);
    System.out.println("Friends with: ");

    // print party
    // can't use for each loop as
    //  - it only works with full arrays and will print null for unfilled spots
    // can't use Arrays.toString() in print for the same reason above, plus
    //  - the format is different (we need each name on a separate line)

    // for loop: up to numFriends-1
    for (int i=0; i<numFriends; i++)
    {
      System.out.println("  " + friendsList[i]);
    }
    System.out.println("=========================="); // trailing separator line
  } // end printAccount

  //------------------------------------------------

  // Tests if the specified name already exists in the friends list
  private boolean exists(String friendName)
  {
    if (numFriends == 0) // empty list
      return false;

    // search through the list (linear search): index 0 to numFriends-1
    for (int i=0; i<numFriends; i++)
    {
      if (friendName.equalsIgnoreCase(friendsList[i]))
        return true;  // yes already on list
    }

    return false;  // not found
  } // end exists

} // end class MiniFacebookAccount
