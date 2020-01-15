/**
 * FILE: 		Team.java
 * AUTHOR: 		Kalon Shannon-Innes
 * ID: 			18529687
 * UNIT: 		Data Structures and Algorithms
 * DATE: 		May 19, 2017 
 * SOURCE: 		Modified version of Team.java I submitted for Prac01
 * REQUIRES:	Organization.java
 */
public class Team extends Organization
{
	private LinkedList<Person> players = new LinkedList<Person>();
	private LinkedList<Person> coaches = new LinkedList<Person>();

	/**
	 * NAME: Default Constructor 
	 * IMPORT: none
	 * EXPORT: none
	 * PURPOSE: Create a default Team object
	 */
	public Team()
	{
		super();
	}

	/**
	 * NAME: Standard Constructor 
	 * IMPORT: inName, inAddress, inContactName, inContactEmail (String)
	 * IMPORT: inPlayers (Player LinkedList)
	 * IMPORT: inCoaches (Coach LinkedList)
	 * EXPORT: none
	 * PURPOSE: Create a custom Team object
	 */
	public Team(String inName, String inShort, String inAddress, String inContactName, 
			String inContactEmail, LinkedList<Person> inPlayers, LinkedList<Person> inCoaches)
	{
		super(inName, inShort, inAddress, inContactName, inContactEmail);
		setPlayers(inPlayers);
		setCoaches(inCoaches);
	}

	/**
	 * NAME: Copy Constructor 
	 * IMPORT: inTeam (Team)
	 * EXPORT: none
	 * PURPOSE: Create a copy of a Team object
	 */
	public Team(Team inTeam)
	{
		super(inTeam);
		setPlayers(inTeam.getPlayers());
		setCoaches(inTeam.getCoaches());
	}

	/**
	 * NAME: addPlayer 
	 * IMPORT: inPlayer (Player)
	 * EXPORT: none
	 * PURPOSE: Add a player to a team
	 */
	public void addPlayer(Person inPlayer)
	{
		players.insertLast(inPlayer);
	}
	
	/**
	 * NAME: setPlayers
	 * IMPORT: inPlayers (Player LinkedList)
	 * EXPORT: none
	 * PURPOSE: Setter for players class field
	 */
	public void setPlayers(LinkedList<Person> inPlayers)
	{
		for(Person p : inPlayers)
		{
			players.insertLast(new Person(p));
		}
	}

	/**
	 * NAME: getPlayers 
	 * IMPORT: none
	 * EXPORT: players (Player LinkedList)
	 * PURPOSE: Getter for players class field
	 */
	public LinkedList<Person> getPlayers()
	{
		return players;
	}
	
	/**
	 * NAME: addCoach
	 * IMPORT: inCoach (Coach)
	 * EXPORT: none
	 * PURPOSE: Add a coach to a team
	 */
	public void addCoach(Person inCoach)
	{
		coaches.insertLast(inCoach);
	}
	
	/**
	 * NAME: setCoaches
	 * IMPORT: inCoaches (Coach LinkedList)
	 * EXPORT: none
	 * PURPOSE: Setter for coaches class field
	 */
	public void setCoaches(LinkedList<Person> inCoaches)
	{
		for(Person c : inCoaches)
		{
			coaches.insertLast(new Person(c));
		}
	}
	
	/**
	 * NAME: getCoaches
	 * IMPORT: none
	 * EXPORT: coaches (Coach LinkedList)
	 * PURPOSE: Getter for coaches class field
	 */
	public LinkedList<Person> getCoaches()
	{
		return coaches;
	}
}
