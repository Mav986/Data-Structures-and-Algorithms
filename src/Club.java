/**
 * FILE: 		Club.java
 * AUTHOR: 		Kalon Shannon-Innes
 * ID: 			18529687
 * UNIT: 		Data Structures and Algorithms
 * DATE: 		May 19, 2017 
 * SOURCE: 		Modified version of SportingClub.java
 * REQUIRES:	Organization.java
 */
public class Club extends Organization
{
	private LinkedList<Team> teams = new LinkedList<Team>();

	/**
	 * NAME: Default Constructor 
	 * IMPORT: none
	 * EXPORT: none
	 * PURPOSE: Create a default Club object
	 */
	public Club()
	{
		super();
	}

	/**
	 * NAME: Standard Constructor 
	 * IMPORT: inName, inShort, inAddress, inContactName, inContactEmail (String)
	 * IMPORT: inTeams (Team LinkedList)
	 * EXPORT: none
	 * PURPOSE: Create a custom Club object
	 */
	public Club(String inName, String inShort, String inAddress, String inContactName,
			String inContactEmail, LinkedList<Team> inTeams)
	{
		super(inName, inShort, inAddress, inContactName, inContactEmail);
		setTeams(inTeams);
	}

	/**
	 * NAME: Copy Constructor 
	 * IMPORT: inClub (Club)
	 * EXPORT: none
	 * PURPOSE: Create a copy of a Club object
	 */
	public Club(Club inClub)
	{
		super(inClub);
		setTeams(inClub.getTeams());
	}

	/**
	 * NAME: addTeam 
	 * IMPORT: inTeam (Team)
	 * EXPORT: none
	 * PURPOSE: Add a team to a club
	 */
	public void addChild(Organization inTeam)
	{
		teams.insertLast((Team)inTeam);
	}
	
	/**
	 * NAME: setTeams 
	 * IMPORT: inTeams (Team LinkedList)
	 * EXPORT: none
	 * PURPOSE: Setter for teams class field
	 */
	public void setTeams(LinkedList<Team> inTeams)
	{
		for(Team t : inTeams)
		{
			teams.insertLast(new Team(t));
		}
	}

	/**
	 * NAME: getTeams 
	 * IMPORT: none
	 * EXPORT: teams (Team LinkedList)
	 * PURPOSE: Getter for teams class field
	 */
	public LinkedList<Team> getTeams()
	{
		return teams;
	}
}
