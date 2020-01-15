import java.util.*;

/**
 * FILE: 	ObjectHandler.java
 * AUTHOR: 	Kalon Shannon-Innes
 * ID: 		18529687
 * UNIT: 	Data Structures and Algorithms
 * DATE: 	May 19, 2017 
 * SOURCE: 	Modified version of OrgHandler.java I submitted for Prac01
 */
public class ObjectHandler
{
	/**
	 * NAME: createObject
	 * IMPORT: inString (String)
	 * EXPORT: none
	 * PURPOSE: Control which methods are called based on the imported parameter
	 */
	public static void createObject(String inString)
	{
		String[] comRemoved = FileHandler.removeComma(inString);
		String objType = comRemoved[0];
		try
		{
			if(objType.equals("NATIONAL"))
			{
				National nat = createNational(comRemoved);
				ReportHandler.addToList(nat);
				SearchHandler.addToSearch(nat.getName(), nat);		
			}
			else if(objType.equals("STATE"))
			{
				State state = createState(comRemoved);
				ReportHandler.addToList(state);
				SearchHandler.addToSearch(state.getName(), state);
			}
			else if(objType.equals("ASSOCIATION"))
			{
				Association assoc = createAssociation(comRemoved);
				ReportHandler.addToList(assoc);
				SearchHandler.addToSearch(assoc.getShort(), assoc);
			}
			else if(objType.equals("CLUB"))
			{
				Club club = createClub(comRemoved);
				ReportHandler.addToList(club);
				SearchHandler.addToSearch(club.getShort(), club);
			}
			else if(objType.equals("TEAM"))
			{
				Team team = createTeam(comRemoved);
				ReportHandler.addToList(team);
				SearchHandler.addToSearch(team.getName(), team);
			}
			else if(objType.equals("PERSON"))
			{
				Person person = createPerson(comRemoved);
				ReportHandler.addToList(person);
				SearchHandler.addToSearch(person.getName(), person);
			}
		}
		catch(UnsupportedOperationException e)
		{
			/**
			 * If this exception is thrown, do nothing. It means a duplicate object was found,
			 * and we don't want to do any processing with it.
			 * 
			 * Thrown by setOrgAttr & setPersonAttr
			 */			
		}
	}
	
	/**
	 * NAME: createNational
	 * IMPORT: natText (String Array)
	 * EXPORT: newNat (National)
	 * PURPOSE: Create a new National object and update its attributes
	 */
	private static National createNational(String[] natText)
	{
		National newNat = new National();
		for(String s : natText)
		{
			String[] colRemoved = FileHandler.removeColon(s);
			setOrgAttr(newNat, colRemoved);
		}	
		
		return newNat;
	}
	
	/**
	 * NAME: createState
	 * IMPORT: stateText (String Array)
	 * EXPORT: newState (State)
	 * PURPOSE: Create a new State object and update its attributes
	 */
	private static State createState(String[] stateText)
	{
		State newState = new State();
		for(String s : stateText)
		{
			String[] colRemoved = FileHandler.removeColon(s);
			setOrgAttr(newState, colRemoved);
		}

		return newState;
	}
	
	/**
	 * NAME: createAssociation
	 * IMPORT: assocText (String Array)
	 * EXPORT: newAssociation (Association)
	 * PURPOSE: Create a new Association object and update its attributes
	 */
	private static Association createAssociation(String[] assocText)
	{
		Association newAssociation = new Association();
		for(String s : assocText)
		{
			String[] colRemoved = FileHandler.removeColon(s);
			if(s.startsWith("UMPIRE"))
			{
				Umpire ump = new Umpire();
				ump.setName(colRemoved[1]);
				newAssociation.addUmpire(ump);
			}
			setOrgAttr(newAssociation, colRemoved);
		}

		return newAssociation;
	}

	/**
	 * NAME: createClub
	 * IMPORT: clubText (String Array)
	 * EXPORT: newClub (Club)
	 * PURPOSE: Create a new Club object and update its attributes
	 */
	private static Club createClub(String[] clubText)
	{
		Club newClub = new Club();
		for(String s : clubText)
		{
			String[] colRemoved = FileHandler.removeColon(s);
			setOrgAttr(newClub, colRemoved);
		}	
		
		return newClub;
	}
	
	/**
	 * NAME: createTeam
	 * IMPORT: teamText (String Array)
	 * EXPORT: newTeam (Team)
	 * PURPOSE: Create a new Team object and update its attributes
	 */
	private static Team createTeam(String[] teamText)
	{		
		Team newTeam = new Team();
		for(String attribute : teamText)
		{
			String[] colRemoved = FileHandler.removeColon(attribute);
			if(attribute.startsWith("CONTACT_NAME"))
			{
				Person coach = new Person();
				coach.setName(colRemoved[1]);
				newTeam.setContactName(coach.getName());
				newTeam.addCoach(coach);
			}
			else if(attribute.startsWith("PLAYER"))
			{
				Person player = new Person();
				player.setName(colRemoved[1]);
				newTeam.addPlayer(player);
			}
			setOrgAttr(newTeam, colRemoved);
		}

		return newTeam;
	}

	/**
	 * NAME: createPerson
	 * IMPORT: personText (String Array)
	 * EXPORT: newPerson (Person)
	 * PURPOSE: Create a new Person object and update its attributes
	 */
	private static Person createPerson(String[] personText)
	{
		Person newPerson = new Person();
		for(String attribute : personText)
		{
			String[] colRemoved = FileHandler.removeColon(attribute);
			setPersonAttr(newPerson, colRemoved);
		}
		
		return newPerson;
	}
	
	/**
	 * NAME: checkDupeOrg
	 * IMPORT: orgName (String)
	 * EXPORT: none
	 * PURPOSE: Check to see if there is a duplicate organization already loaded
	 */
	private static void checkDupeOrg(String orgName)
	{
		SearchHandler.findOrg(orgName);
	}
	
	/**
	 * NAME: checkDupePerson
	 * IMPORT: personsName (String)
	 * EXPORT: none
	 * PURPOSE: Check to see if there is a duplicate person already loaded
	 */
	private static void checkDupePerson(String personName)
	{
		SearchHandler.findPerson(personName);
	}

	/**
	 * NAME: setOrgAttr
	 * IMPORT: org (Organization)
	 * IMPORT: colRemoved (String Array)
	 * EXPORT: none
	 * PURPOSE: Update an Organizations attributes
	 */
	private static void setOrgAttr(Organization org, String[] colRemoved)
	{
		try
		{
			String attribute = colRemoved[0];
			if(attribute.startsWith("NAME"))
			{
				try
				{
					checkDupeOrg(colRemoved[1]);
					throw new UnsupportedOperationException();
				}
				catch(NoSuchElementException e)
				{
					org.setName(colRemoved[1]);			
				}
			}
			else if(attribute.startsWith("SHORT"))
			{
				try
				{
					checkDupeOrg(colRemoved[1]);
					throw new UnsupportedOperationException();
				}
				catch(NoSuchElementException e)
				{
					org.setShort(colRemoved[1]);		
				}
			}
			else if(attribute.startsWith("CONTACT_ADDRESS"))
			{
				org.setAddress(colRemoved[1]);
			}
			else if(attribute.startsWith("CONTACT_NAME"))
			{
				org.setContactName(colRemoved[1]);
			}
			else if(attribute.startsWith("CONTACT_EMAIL"))
			{
				org.setContactEmail(colRemoved[1]);
			}
			if(attribute.startsWith("PARENT"))
			{
				Organization parent = SearchHandler.findOrg(colRemoved[1]);
				parent.addChild(org);
			}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			/**
			 * If this exception is thrown, do nothing. It just means that an attribute is blank
			 * ie. An organization may not have a contact address listed in file
			 * 
			 * Thrown by LinkedList.java
			 */
		}
		catch(NoSuchElementException e)
		{
			/**
			 * If this exception is thrown, do nothing. It just means that an attribute is blank
			 * ie. An organization may not have a contact address listed in file
			 * 
			 * Thrown by BinarySearchTree.java
			 */
		}
	}

	/**
	 * SUBMODULE: setPersonAttr
	 * IMPORT: person (Person)
	 * IMPORT: colRemoved (String Array)
	 * EXPORT: none
	 * PURPOSE: Update a Persons attributes
	 */
	private static void setPersonAttr(Person person, String[] colRemoved)
	{
		try
		{
			String attribute = colRemoved[0];
			if(attribute.startsWith("NAME"))
			{
				try
				{
					checkDupePerson(colRemoved[1]);
					throw new UnsupportedOperationException();
				}
				catch(NoSuchElementException e)
				{
					person.setName(colRemoved[1]);		
				}
			}
			else if(attribute.startsWith("CONTACT_EMAIL"))
			{
				person.setContactEmail(colRemoved[1]);
			}
			else if(attribute.startsWith("DOB"))
			{
				person.setDob(colRemoved[1]);
			}
			else if(attribute.startsWith("UMPIRE"))
			{
				Umpire ump = new Umpire(person.getName(), person.getContactEmail(), 
						person.getDob(), colRemoved[1]);
				person = ump;
			}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			/**
			 * If this exception is thrown, do nothing. It just means that an attribute is blank
			 * ie. A person may not have a contact email or contact address listed on file
			 * 
			 * Thrown by StringArray.java(?) Not sure what the class is called that handles String
			 * Arrays.
			 */
		}
		catch(NoSuchElementException e)
		{
			/**
			 * If this exception is thrown, do nothing. It just means that an attribute is blank
			 * ie. A person may not have a contact email or contact address listed on file
			 * 
			 * Thrown by BinarySearchTree.java
			 */
		}
	}
}
