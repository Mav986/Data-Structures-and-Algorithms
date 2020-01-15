/**
 * FILE: 	ReportHandler.java
 * AUTHOR: 	Kalon Shannon-Innes
 * ID: 		18529687
 * UNIT: 	Data Structures and Algorithms
 * DATE: 	May 19, 2017 
 * SOURCE: 	Version 1.0
 */
public class ReportHandler
{	
	private static LinkedList<National> nationals = new LinkedList<National>();
	private static LinkedList<State> states = new LinkedList<State>();
	private static LinkedList<Association> associations = new LinkedList<Association>();
	private static LinkedList<Club> clubs = new LinkedList<Club>();
	private static LinkedList<Team> teams = new LinkedList<Team>();
	private static LinkedList<Person> people = new LinkedList<Person>();
	
	/**
	 * NAME: nationalReport
	 * IMPORT: none
	 * EXPORT: none
	 * PURPOSE: Display a national report
	 */
	public static void nationalReport()
	{
		LinkedList<State> stateList;
		String nationalReport = "";
		int numUmpire = 0;
		int numCoach = 0;
		int numPlayer = 0;
		
		for(National national : nationals)
		{
			stateList = national.getStates();
			if(stateList.isEmpty())
			{
				nationalReport = nationalReport + "#### no state data available ###\n\n";	
			}
			else
			{
				nationalReport = "\n================ " + national.getName() + " ================\n";
				for(State state : stateList)
				{
					numUmpire = numUmpire + calcNumUmpire(state);
					numCoach = numCoach + calcNumCoach(state);
					numPlayer = numPlayer + calcNumPlayer(state);				
				}
			}
				nationalReport = nationalReport	+ "\nNumber of Umpires: " + numUmpire + "\nNumber of Coaches: " + numCoach 
				+ "\nNumber of Players: " + numPlayer + "\n";
			
			System.out.print(nationalReport);
		}
	}

	/**
	 * NAME: stateReport
	 * IMPORT: none
	 * EXPORT: none
	 * PURPOSE: Display a state report
	 */
	public static void stateReport()
	{
		LinkedList<Association> assocList;
		String stateReport = "";
		int numUmpire;
		int numCoach;
		int numPlayer;
		
		for(State state : states)
		{
			stateReport = "\n================ " + state.getName() + " ================\n";
			numUmpire = calcNumUmpire(state);
			numCoach = calcNumCoach(state);
			numPlayer = calcNumPlayer(state);
			stateReport = stateReport + "\nNumber of Umpires: " + numUmpire + "\nNumber of Coaches: " + numCoach
					+ "\nNumber of Players: " + numPlayer + "\n";
			
			assocList = state.getAssociations();
			if(assocList.isEmpty())
			{
				stateReport = stateReport + "#### no association data available ###\n\n";				
			}
			else
			{
				stateReport = stateReport + "\n------------ ASSOCIATIONS ------------\n";
				for(Association assoc : assocList)
				{
					stateReport = stateReport + "\n" + assoc.toString() + "\n";
				}
			}
			System.out.print(stateReport);
		}
	}

	/**
	 * NAME: assocReport
	 * IMPORT: none
	 * EXPORT: none
	 * PROCESS: Display an association report
	 */
	public static void assocReport()
	{
		LinkedList<Club> clubList;
		LinkedList<Umpire> umpireList;
		
		for(Association association : associations)
		{
			String assocReport = "\n================ " + association.getName() + " ================\n\n";
			
			umpireList = association.getUmpires();
			if(umpireList.isEmpty())
			{
				assocReport = assocReport + "#### no umpire data available ###\n\n";
			}
			else
			{
				assocReport = assocReport + "------------ UMPIRES ------------\n\n";
				for(Umpire umpire : umpireList)
				{
					Person found = SearchHandler.findPerson(umpire.getName());
					assocReport = assocReport + found.toString() + "\n\n";
				}
			}

			clubList = association.getClubs();
			if(clubList.isEmpty())
			{
				assocReport = assocReport + "#### no club data available ####\n\n";
			}
			else
			{
				assocReport = assocReport + "------------ CLUBS ------------\n";
				for(Club club : clubList)
				{
					assocReport = assocReport + "\n" + club.toString() + "\n";
				}
			}
			
			System.out.print(assocReport);
		}
	}
	
	/**
	 * NAME: clubReport
	 * IMPORT: none
	 * EXPORT: none
	 * PURPOSE: Display a club report
	 */
	public static void clubReport()
	{
		LinkedList<Team> teamList;
		LinkedList<Person> playerList;
		
		for(Club club : clubs)
		{
			String clubReport = "\n================ " + club.getName() + " ================\n";
			
			teamList = club.getTeams();
			if(teamList.isEmpty())
			{
				clubReport = clubReport + "\n#### no team data available ####\n";			
			}
			else
			{
				for(Team team : teamList)
				{
					clubReport = clubReport + "\n------------ TEAM ------------\n" + "\n" + team.toString() + "\n";
					
					playerList = team.getPlayers();
					if(playerList.isEmpty())
					{
						clubReport = clubReport + "#### no player data available ####\n";
					}
					else
					{
						clubReport = clubReport + "\n------------ PLAYERS ------------\n";
						for(Person player : playerList)
						{
							Person found = SearchHandler.findPerson(player.getName());
							clubReport = clubReport + "\n" + found.toString() + "\n";
						}
					}
				}
			}
			
			System.out.print(clubReport);
		}
	}
	
	/**
	 * NAME: getPeople
	 * IMPORT: none
	 * EXPORT: peopleCopy (Person)
	 * PURPOSE: Getter for people class field
	 */
	public static LinkedList<Person> getPeople()
	{
		LinkedList<Person> peopleCopy = new LinkedList<Person>();
		for(Person personCopy : people)
		{
			peopleCopy.insertLast(new Person(personCopy));
		}
		
		return peopleCopy;
	}
	
	/**
	 * NAME: addToList
	 * IMPORT: inNat (National)
	 * EXPORT: none
	 * PURPOSE: Add a National object to the nationals list
	 */
	public static void addToList(National inNat)
	{
		nationals.insertLast(inNat);
	}
	
	/**
	 * NAME: addToList
	 * IMPORT: inState (State)
	 * EXPORT: none
	 * PURPOSE: Add a State object to the states list
	 */
	public static void addToList(State inState)
	{
		states.insertLast(inState);
	}
	
	/**
	 * NAME: addToList
	 * IMPORT: inAssociation (Association)
	 * EXPORT: none
	 * PURPOSE: Add an association to the associations list
	 */
	public static void addToList(Association inAssociation)
	{
		associations.insertLast(inAssociation);
	}
	
	/**
	 * NAME: addToList
	 * IMPORT: inClub (Club)
	 * EXPORT: none
	 * PURPOSE: Add a club to the clubs list
	 */
	public static void addToList(Club inClub)
	{
		clubs.insertLast(inClub);
	}
	
	/**
	 * NAME: addToList
	 * IMPORT: inTeam (Team)
	 * EXPORT: none
	 * PURPOSE: Add a team to the teams list
	 */
	public static void addToList(Team inTeam)
	{
		teams.insertLast(inTeam);
	}
	
	/**
	 * NAME: addToList
	 * IMPORT: inPerson (Person)
	 * EXPORT: none
	 * PURPOSE: Add a person to the people list
	 */
	public static void addToList(Person inPerson)
	{
		people.insertLast(inPerson);
	}

	/**
	 * NAME: calcNumUmpire
	 * IMPORT: state (State)
	 * EXPORT: umpireCount (Integer)
	 * PURPOSE: Calculate the number of umpires in all associations
	 */
	private static int calcNumUmpire(State state)
	{
		int umpireCount = 0;
		LinkedList<Association> assocList = state.getAssociations();
		for(Association assoc : assocList)
		{
			LinkedList<Umpire> umpires = assoc.getUmpires();
			for(Umpire ump : umpires)
			{
				umpireCount++;
			}
		}

		return umpireCount;
	}
	
	/**
	 * NAME: calcNumCoach
	 * IMPORT: state (State)
	 * EXPORT: coachCount
	 * PURPOSE: Calculate the number of coaches in all teams
	 */
	private static int calcNumCoach(State state)
	{
		int coachCount = 0;
		LinkedList<Association> assocList = state.getAssociations();
		for(Association assoc : assocList)
		{
			LinkedList<Club> clubList = assoc.getClubs();
			for(Club club : clubList)
			{
				LinkedList<Team> teamList = club.getTeams();
				for(Team team : teamList)
				{
					LinkedList<Person> coaches = team.getCoaches();
					for(Person coach : coaches)
					{
						coachCount++;
					}
				}
			}
		}
		
		return coachCount;
	}
	
	/**
	 * NAME: calcNumPlayer
	 * IMPORT: state (State)
	 * EXPORT: playerCount
	 * PURPOSE: Calculate the number of players in all teams
	 */
	private static int calcNumPlayer(State state)
	{
		int playerCount = 0;
		LinkedList<Association> assocList = state.getAssociations();
		for(Association assoc : assocList)
		{
			LinkedList<Club> clubList = assoc.getClubs();
			for(Club club : clubList)
			{
				LinkedList<Team> teamList = club.getTeams();
				for(Team team : teamList)
				{
					LinkedList<Person> playerList = team.getPlayers();
					for(Person player : playerList)
					{
						playerCount++;
					}
				}
			}
		}
		
		return playerCount;
	}
}
